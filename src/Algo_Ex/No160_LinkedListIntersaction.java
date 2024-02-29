package Algo_Ex;

import java.util.ArrayList;
import java.util.List;

public class No160_LinkedListIntersaction {
    public static void main(String[] args) {
        ListNode intersact = new ListNode(8, new ListNode(4, new ListNode(5, null)));
        ListNode headA = new ListNode(4, new ListNode(1, intersact));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersact)));

        System.out.println(getIntersectionNode(headA, headB).val);
        System.out.println(getIntersectionNodewithList(headA, headB).val);
    }
    public static class ListNode {
        int val;

        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    //반복문 사용
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    //arrayList 사용
    public static ListNode getIntersectionNodewithList(ListNode headA, ListNode headB) {
        List<ListNode> list = new ArrayList<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != null) {
            list.add(nodeA);
            nodeA = nodeA.next;
        }

        ListNode nodeC = null;
        outer:
            while (nodeB != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == nodeB) {
                        nodeC = nodeB;
                        break outer;
                    }
                }
                nodeB = nodeB.next;
            }
        return nodeC;
    }
}
