package LE.vo;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /*@Override
    public String toString() {
        String returnString = "";
        if(null!=next){
            returnString = val + "," + next;
            if (!returnString.startsWith("[") && !returnString.endsWith("]")){
                returnString = "["+returnString+"]";
            }
        }

        return returnString;
    }*/
}
