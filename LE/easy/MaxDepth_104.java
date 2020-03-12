package LE.easy;

import LE.vo.TreeNode;
import org.junit.Test;

public class MaxDepth_104 {
    private int maxDepth(TreeNode root) {
        return maxDepth2(root);
    }
//    private int maxDepth1(TreeNode root){
//        int length = 0;
//        int currMax = 0;
//        length++;
//        currMax += maxDepth1(null==root.left?root.left?root.right);
//        return Math.max(l1,l2);
//     return 5;
//    }
    //深度检索的方法，递归求深度
    //int ans=0;
    private int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = maxDepth2(root.left);
        int R = maxDepth2(root.right);
        return Math.max(L,R)+1;
    }

    @Test
    public void testMaxDepth(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        Integer[] arr = new Integer[]{1,2,2,3,4,4,3};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Boolean flag = 3==maxDepth(root);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7,20,null,null,15,7};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Boolean flag = 4==maxDepth(root);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
}
