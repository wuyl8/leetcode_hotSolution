package LE.easy;

import LE.vo.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSymmetric_101 {
    private Boolean isSymmetric(TreeNode root) {
        return  isSymmetric3(root);
    }
    //递归
    public Boolean isSymmetric1(TreeNode root){
        if(root==null)return true;
        return isMirror(root.left,root.right);
    }
    private Boolean isMirror(TreeNode left,TreeNode right){
        if(left==null && right==null)return true;
        if(left==null || right==null)return false;
        return left.val==right.val && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
    //中序遍历返回回文list后据此判断，此方法产生回文坑很多，TODO
    public Boolean isSymmetric2(TreeNode root){
        List treeNodeList = TreeNode.inorderTraversal(root);
        List turnOverList = new LinkedList();
        for (int i=treeNodeList.size()-1;i>=0;i--){
            turnOverList.add(treeNodeList.get(i));
        }
        return turnOverList.equals(treeNodeList);
    }
    //queue队列的思想迭代
    private Boolean isSymmetric3(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1==null && t2==null)continue;
            if(t1==null || t2==null )return false;
            if(t1.val!=t2.val)return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    @Test
    public void testIsSymmetric(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2() && test3() && test4()&& test5();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        //二叉树[1,2,2,3,4,4,3]
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(4);
        treeNode3.left = new TreeNode(4);
        treeNode3.right = new TreeNode(3);

        Boolean flag = isSymmetric(treeNode1);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Boolean flag = !isSymmetric(root);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test3(){
        Integer[] arr = new Integer[]{1,2,2,2,null,2};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Boolean flag = !isSymmetric(root);
        System.out.println("测试3"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test4(){
        Integer[] arr = new Integer[]{1,2,2,null,3,3};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Boolean flag = isSymmetric(root);
        System.out.println("测试4"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test5(){
        Integer[] arr = new Integer[]{5,4,1,null,1,null,4,2,null,2,null};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Boolean flag = !isSymmetric(root);
        System.out.println("测试5"+(flag?"通过":"不通过"));
        return flag;
    }
}
