package Algo_Ex;

import java.util.HashSet;

public class No141_LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public static void main(String[] args) {
        //사이클을 가지고 있는 리스트인지 확인
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(node1));
        System.out.println(hasCycle2(node1));
    }

    //Two-Pointer
    public static boolean hasCycle(ListNode head) {
        ListNode slow_pointer = head, fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if(slow_pointer == fast_pointer) return true;
        }
        return false;
    }

    //Hash Table
    public static boolean hasCycle2(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curr_node = head;
        while (curr_node != null) {
            if (hashSet.contains(curr_node)) {
                return true;
            }
            hashSet.add(curr_node);
            curr_node = curr_node.next;
        }
        return false;
    }
}
