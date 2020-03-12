package LE.medium;

import LE.vo.ListNode;
import org.junit.Test;

public class AddTwoNumbers_2 {
    /*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8      原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers1(l1,l2);
    }
    //初等数学，用了指针寄存器思想。这题特殊的坑比较多没注意，错了好几次。。。
    private ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode listNodeFirst = new ListNode(-1);
        ListNode listNode = listNodeFirst;
        int ans = 0;
        while(l1!=null||l2!=null){
            int x = l1==null?0:l1.val;
            int y = l2==null?0:l2.val;
            listNode.next = new ListNode((x+y+ans)%10);
            ans = (x+y+ans)/10;
            if(l1!=null)l1 = l1.next;if(l2!=null)l2 = l2.next;
            listNode = listNode.next;
        }
        if(ans!=0){
            listNode.next = new ListNode(ans);
        }
        return listNodeFirst.next;
    }

    @Test
    public void testAddTwoNumbers(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2()&&test3()&&test4()&&test5();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);

        ListNode listNode = addTwoNumbers(listNode1,listNode4);
        Boolean flag = 7==listNode.val&&0==listNode.next.val&&8==listNode.next.next.val;
        System.out.println("测试1"+(flag?"通过":"不通过")+",列表："+listNode.val+","+listNode.next.val+","+listNode.next.next.val);
        return flag;
    }
    private Boolean test2(){
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode = addTwoNumbers(listNode1,listNode2);
        Boolean flag = 0==listNode.val&&1==listNode.next.val;
        System.out.println("测试2"+(flag?"通过":"不通过")+",列表："+listNode.val+","+listNode.next.val);
        return flag;
    }
    private Boolean test3(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(8);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(0);
        ListNode listNode = addTwoNumbers(listNode1,listNode3);
        Boolean flag = 1==listNode.val&&8==listNode.next.val;
        System.out.println("测试3"+(flag?"通过":"不通过")+",列表："+listNode.val+","+listNode.next.val);
        return flag;
    }
    private Boolean test4(){
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(8);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(1);
        ListNode listNode = addTwoNumbers(listNode1,listNode3);
        Boolean flag = 0==listNode.val&&9==listNode.next.val;
        System.out.println("测试4"+(flag?"通过":"不通过")+",列表："+listNode.val+","+listNode.next.val);
        return flag;
    }
    private Boolean test5(){
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        listNode2.next = listNode3;
        ListNode listNode = addTwoNumbers(listNode1,listNode2);
        Boolean flag = 0==listNode.val&&0==listNode.next.val&&1==listNode.next.next.val;
        System.out.println("测试5"+(flag?"通过":"不通过")+",列表："+listNode.val+","+listNode.next.val+","+listNode.next.next.val);
        return flag;
    }
}
