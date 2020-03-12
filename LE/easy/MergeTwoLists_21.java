package LE.easy;

import LE.vo.ListNode;
import org.junit.Test;
/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoLists2(l1,l2);
    }
//递归法拼接单向链表
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
//指针的思想
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    @Test
    public void testMergeTwoLists(){
        Boolean flag = test1()&&test2();
//        String message = flag?"通过":"不通过";
//        System.out.println("测试"+message);
    }
    public Boolean test1(){
        int[] tableList1 = {2,4,3};
        int[] tableList2 = {5,6,4};

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);

        ListNode resultList = mergeTwoLists(listNode1,listNode4);
//        Arrays.equals(result,resultList);
        int[] result = {2,4,3,5,6,4};
        System.out.println(resultList);
        return true;
    }
    public Boolean test2(){
        int[] tableList1 = {2,4,3};
        int[] tableList2 = {3,1,4};
        ListNode listNode1 = new ListNode(2);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(3);

        ListNode listNode4 = new ListNode(3);
        listNode4.next=new ListNode(1);
        listNode4.next.next=new ListNode(4);

        ListNode resultList = mergeTwoLists(listNode1,listNode4);
        int[] result = {2,3,1,4,4,3};
        System.out.println(resultList);
        return true;
    }
}
