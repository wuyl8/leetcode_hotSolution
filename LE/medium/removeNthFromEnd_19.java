package LE.medium;

import LE.vo.ListNode;
import org.junit.Test;

public class removeNthFromEnd_19 {
    /*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：给定的 n 保证是有效的。
进阶：你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd1(head,n);
    }
    //双指针，快慢指针的思想
    private ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i=1;i<=n;++i){
            first = first.next;
        }
        //如果删除的是listNode的第一个元素
        if(null == first){
            return head.next;
        }
        while (null != first.next){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        boolean flag = test1() && test2() && test3() && test4();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(0);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);

        ListNode resultList = removeNthFromEnd(listNode4,1);
        System.out.println(resultList);
        return true;
    }
    private Boolean test2(){
        ListNode listNode1 = new ListNode(2);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next = new ListNode(1);
        listNode1.next.next.next.next = new ListNode(5);

        ListNode resultList = removeNthFromEnd(listNode1,2);
        System.out.println(resultList);
        return true;
    }
    private Boolean test3(){
        ListNode listNode = new ListNode(1);
        ListNode resultList = removeNthFromEnd(listNode,1);
        System.out.println(resultList);
        return true;
    }
    private Boolean test4(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode resultList = removeNthFromEnd(listNode,2);
        System.out.println(resultList);
        return true;
    }
}
