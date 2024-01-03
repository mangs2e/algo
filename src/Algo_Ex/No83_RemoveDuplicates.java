package Algo_Ex;

public class No83_RemoveDuplicates {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        //정렬된 Node 중에서 중복 값을 제외한 노드를 출력하는 문제
        ListNode sortedList = new ListNode(1, new ListNode(1, new ListNode(2))); //[1, 1, 2]

        ListNode result = deleteDuplicates(sortedList);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }

        return head;
    }
}
