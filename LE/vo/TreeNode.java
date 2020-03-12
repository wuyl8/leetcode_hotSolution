package LE.vo;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode createBinaryTreeByArray(Integer []array,int index)
    {
        TreeNode tn;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return null;
    }

    //迭代、二叉树中序遍历
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty())
        {
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                list.add(stack.peek().val);
                root = stack.peek().right;
                stack.pop();
            }
        }
        return list;
    }
    //中序遍历返回回文带 “null”
//    public static List inorderTraversal(TreeNode root){
//        List list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            if (!stack.isEmpty()){
//                if(stack.peek().left==null&&stack.peek().right!=null){
//                    list.add("null");
//                }
//                list.add(stack.peek().val);
//                root = stack.peek().right;
//                if(stack.peek().left!=null&&stack.peek().right==null){
//                    list.add("null");
//                }
//                stack.pop();
//            }
//        }
//        return list;
//    }

//    public static Integer[] getArrayByBinaryTree(TreeNode binaryTree){
//        int depth = maxDepth(binaryTree);
//        Integer[] arr = new Integer[(int)Math.pow(2,depth)];
//
//        getArrayByBinaryTree(binaryTree,arr);
//
//        arr[0] = binaryTree.val;
//        arr[1] = binaryTree.left.val;
//        arr[2] = binaryTree.right.val;
//
//        return arr;
//    }
//    private static int getArrayByBinaryTree(TreeNode binaryTree,Integer[] arr){
//        if(binaryTree!=null){
//            int L = getArrayByBinaryTree(binaryTree.left,arr);
//            int R = getArrayByBinaryTree(binaryTree.right,arr);
//            return Math.max(L,R)+1;
//        }
//
//    }

    //深度检索、二叉树深度
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        return Math.max(L,R)+1;
    }

    //栈、传入数组判断二叉树是否对称
    public static Boolean isSymmetric(Integer[] arr){
        Stack stack = new Stack();
        stack.push(arr[0]);
        for(int i=0;i<arr.length;i++){
            if(stack.empty() || arr[i] != stack.peek()){
                stack.push(arr[i]);
            }else{
                stack.pop();
            }
        }
        return stack.empty();
    }
    //递归判断二叉树是否对称
    public static Boolean isSymmetric(TreeNode root){
        if(root==null)return true;
        return isMirror(root.left,root.right);
    }
    public static Boolean isMirror(TreeNode left,TreeNode right){
        if(left==null && right==null)return true;
        if(left==null || right==null)return false;
        return left.val==right.val && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

    public static void main(String args[]) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = createBinaryTreeByArray(arr,0);
        System.out.println(root);
    }

}
