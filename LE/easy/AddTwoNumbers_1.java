package LE.easy;

import LE.vo.ListNode;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AddTwoNumbers_1 {
    /*

     */

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        System.out.println(new LinkedHashMap[1].toString());
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers1(l1,l2);
    }

    @Test
    public void testAddTwoNumbers(){
        Boolean flag = testAddTwoNumbers1();
        String message = flag?"通过":"不通过";
        System.out.println("测试"+message);
    }
    public Boolean testAddTwoNumbers1(){
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
        addTwoNumbers(listNode1,listNode4);
        return true;
    }

}
