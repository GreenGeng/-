package test1.listnode;

import java.util.List;

public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val){
        this.val = val;
    }
    public ListNode (int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}