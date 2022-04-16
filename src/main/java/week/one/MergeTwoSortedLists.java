package week.one;

/**
 * @author XiongShiyu
 * @description MergeTwoSortedLists
 * @date 2022/4/16 22:07
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7))));
        ListNode listNode2 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(6))));
        ListNode listNode3 = mergeTwoLists(listNode2, listNode1);
        while (listNode3 != null) {
            System.out.print(listNode3.val + " ");
            listNode3 = listNode3.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ret = new ListNode(0);
        ListNode ind = ret;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                ind.next = list1;
                list1 = list1.next;
            }else{
                ind.next = list2;
                list2 = list2.next;
            }
            ind = ind.next;
        }
        ind.next = list1 == null ? list2 : list1;
        return ret.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
