package com.steven.demo.algorithm;

public class MergeTwoSortedLists {

    //递归地实现
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {

            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    //非递归实现
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {

            return l2;
        }

        if (l2 == null) {

            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode prev = result;

        //合并
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

        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }

        return result.next;
    }
}
