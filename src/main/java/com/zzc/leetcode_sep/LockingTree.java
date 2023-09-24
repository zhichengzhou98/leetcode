package com.zzc.leetcode_sep;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-23 18:24
 */
public class LockingTree {
    public static void main(String[] args) {
        int[] p = {-1,0,3,4,7,4,3,0,1,8};
        LockingTree lockingTree = new LockingTree(p);
        boolean f1 = lockingTree.lock(8,25);
        boolean f2 = lockingTree.lock(5,50);
        boolean f3= lockingTree.upgrade(1,15);
        boolean f4= lockingTree.lock(3,21);
        System.out.println(1);
    }
    //上锁的结点集合
    int[] lockedNodes;
    int[] parent;
    //当前结点值， 当前结点结构体
    private List<Integer>[] children;
    public LockingTree(int[] parent) {
        this.parent = parent;
        lockedNodes = new int[parent.length];
        children = new List[parent.length];
        for (int i = 0; i < parent.length; i++) {
            children[i] = new ArrayList<>();
        }
        //遍历parent
        for (int i = 0; i < parent.length; i++) {
            int p = parent[i];
            if (p >= 0) {
                children[p].add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (lockedNodes[num] == 0) {
            lockedNodes[num] = user;
            //加锁
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lockedNodes[num] == user) {
            lockedNodes[num] = 0;
            //解锁
            return true;
        }
        return false;
    }

    public boolean isZuXian(int num) {
        int parent1 = parent[num];
        while (parent1 != -1) {
            //该节点被上锁
            if (lockedNodes[parent1] != 0) {
                return false;
            }
            parent1 = parent[parent1];
        }
        return true;
    }

    public boolean isChild(int num) {
        boolean flag = false;
        List<Integer> children1 = children[num];
        for (int i = 0; i < children1.size(); i++) {
            Integer child1 = children1.get(i);
            if (lockedNodes[child1] != 0) {
                flag = true;
                //解锁
                //由于可以给任意用户解锁，所以此user应该是给i上锁的user
                unlock(child1, lockedNodes[child1]);
            }
            flag = flag | isChild(child1);
        }
        return flag;
    }
    /*public boolean isChild(int num) {
        boolean flag = false;
        List<Integer> children1 = children[num];
        while (!children1.isEmpty()) {
            //remove 后将children1 即children[num]中的数据改变了
            Integer child1 = children1.remove(0);
            if (lockedNodes[child1] != 0) {
                flag = true;
                //解锁
                //由于可以给任意用户解锁，所以此user应该是给i上锁的user
                unlock(child1, lockedNodes[child1]);
            }
            //获取child1的子节点
            flag = flag | isChild(child1);
        }
        return flag;
    }*/
    public boolean upgrade(int num, int user) {
        //当前结点是否被上锁
        if (lockedNodes[num] == 0) {
            //获取父节点
            if (!isZuXian(num)) {
                return false;
            }
            //获取子节点
            boolean flag = isChild(num);

            if (flag) {
                //给该结点上锁
                lock(num, user);
                return true;
            }
        }
        return false;
    }

    /*//上锁的结点集合
    Set<Integer> lockedNodes;
    int[] parent;
    //当前结点值， 当前结点结构体
    Map<Integer, LockingTreeStruct> structMap;
    public LockingTree(int[] parent) {
        this.parent = parent;
        lockedNodes = new HashSet<>();
        structMap = new HashMap<>();
        //key -> i, value -> parent[i]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            map.put(i, parent[i]);
        }
        //遍历parent
        for (int i = 0; i < parent.length; i++) {
            // 当前结点i 当前父节点 parent[i]
            LockingTreeStruct lTS = new LockingTreeStruct();
            lTS.current = i;
            int currentParent = parent[i];
            lTS.parentNodes.add(currentParent);
            if (structMap.containsKey(currentParent)) {
                LockingTreeStruct struct = structMap.get(currentParent);
                lTS.parentNodes.addAll(struct.parentNodes);
            }else {
                //递归所有父节点
                while (map.containsKey(currentParent)) {
                    Integer pp = map.get(currentParent);
                    lTS.parentNodes.add(pp);
                    if (structMap.containsKey(pp)) {
                        LockingTreeStruct struct = structMap.get(pp);
                        lTS.parentNodes.addAll(struct.parentNodes);
                        break;
                    }
                    currentParent = pp;
                }
            }
            lTS.childNodes = forMatChildNodes(i);
            structMap.put(i, lTS);
        }
    }

    //获取当前结点的所有子节点
    public List<Integer> forMatChildNodes(int  current) {
        List<Integer> childs = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == current) {
                //子节点
                childs.add(i);
                if (structMap.containsKey(i)) {
                    LockingTreeStruct struct = structMap.get(i);
                    childs.addAll(struct.childNodes);
                }else {
                    childs.addAll(forMatChildNodes(i));
                }
            }
        }
        LockingTreeStruct struct = structMap.getOrDefault(current, new LockingTreeStruct());
        struct.current = current;
        struct.childNodes = childs;
        return childs;
    }

    public boolean lock(int num, int user) {
        LockingTreeStruct struct = structMap.get(num);
        if (struct.user == 0) {
            struct.user = user;
            //加锁
            lockedNodes.add(num);
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        LockingTreeStruct struct = structMap.get(num);
        if (struct.user == user) {
            struct.user = 0;
            //解锁
            lockedNodes.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        LockingTreeStruct struct = structMap.get(num);
        if (struct.user == 0) {
            //获取父节点
            List<Integer> parentNodes = struct.parentNodes;
            for (int i = 0; i < parentNodes.size(); i++) {
                int parent = parentNodes.get(i);
                if (lockedNodes.contains(parent)) {
                    return false;
                }
            }
            //获取子节点
            boolean flag = false;
            List<Integer> childNodes = struct.childNodes;
            for (int i = 0; i < childNodes.size(); i++) {
                Integer child = childNodes.get(i);
                if (lockedNodes.contains(child)) {
                    flag = true;
                    //解锁
                    //由于可以给任意用户解锁，所以此user应该是给i上锁的user
                    unlock(child, structMap.get(child).user);
                }
            }
            if (flag) {
                //给该结点上锁
                lock(num, user);
            }
            return flag;
        }
        return false;
    }*/
}

class LockingTreeStruct {
    int current;
    List<Integer> parentNodes;
    List<Integer> childNodes;

    //当前结点加锁的用户
    int user;
    public LockingTreeStruct() {
        parentNodes = new ArrayList<>();
        childNodes = new ArrayList<>();
    }
}
