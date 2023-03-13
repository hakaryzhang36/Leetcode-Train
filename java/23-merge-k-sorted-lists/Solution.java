// Leetcode 23-merge-k-sorted-lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 判断是否空链表
        boolean allNull = true;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                allNull = false;
                break;
            }
        }
        if (allNull) {
            return null;
        }

        // 优先队列
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        // 记录队列中节点所属的链表序号
        Map<ListNode, Integer> belong = new HashMap<>();

        int finish = 0;

        // 将每个链表第一个节点加入q
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);
                belong.put(lists[i], i);
                lists[i] = lists[i].next;
            }
            finish = lists[i]==null ? finish+1 : finish;
        }

        // 最终链表的头尾指针
        ListNode head = new ListNode();
        ListNode end = head;

        while (finish != lists.length) {
            // 取一个出来
            end.next = q.poll();
            // end 连过去
            end = end.next;

            // 从对应链表取出一个，加入q
            int p = belong.get(end);
            belong.remove(end);
            if (lists[p] != null) {
                q.add(lists[p]);
                belong.put(lists[p], p);
                lists[p] = lists[p].next;
                // 判断链表是否结束
                if (lists[p] == null) {
                    finish++;
                }
            }
        }

        // 取出还在 q 中的节点
        while (!q.isEmpty()) {
            end.next = q.poll();
            end = end.next;
        }

        return head.next;
    }
}