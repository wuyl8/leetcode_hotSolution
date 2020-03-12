package LE.easy;

import LE.vo.ListNode;
import org.junit.Test;

import java.util.HashSet;
/*给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
示例 1：输入：head = [3,2,0,-4], pos = 1
输出：true 解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：输入：head = [1,2], pos = 0
输出：true 解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：输入：head = [1], pos = -1
输出：false    解释：链表中没有环。
进阶：你能用 O(1)（即，常量）内存解决此问题吗？*/

public class HasCycle_141 {
    private boolean hasCycle(ListNode head) {
        return hashCycle2(head);
    }
// 双指针的思想，快慢指针
    private Boolean hashCycle1(ListNode head){
        if(head==null||head.next==null||head.next.next==null){
            return false;
        }
        ListNode fastPoint = head.next.next;
        while (head!=null&&fastPoint!=null&&fastPoint.next!=null){
            if(fastPoint.val==head.val){
                return true;
            }
            head = head.next;
            fastPoint = fastPoint.next.next;
        }
        return false;
    }
//hash表
    private Boolean hashCycle2(ListNode head){
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head!=null){
            if(hashSet.contains(head)){
                return true;
            }else{
                hashSet.add(head);
                head = head.next;
            }
        }
        return false;
    }
    @Test
    public void testHashCycle(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2()&&test3()&&test4();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode2);
        Boolean flag = hasCycle(listNode1);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private  Boolean test2(){
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        Boolean flag = !hasCycle(listNode1);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
    private  Boolean test3(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode1);
        Boolean flag = hasCycle(listNode1);
        System.out.println("测试3"+(flag?"通过":"不通过"));
        return flag;
    }
    private  Boolean test4(){
        ListNode listNode1 = new ListNode(1);
        Boolean flag = !hasCycle(listNode1);
        System.out.println("测试4"+(flag?"通过":"不通过"));
        return flag;
    }
}
