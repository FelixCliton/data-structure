package com.newpi.data.linkedList.linkedlist;

import com.newpi.data.linkedList.model.Node;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/22 9:38 AM
 * @desc:
 */
public class LinkedList {


    public Node createLinkedList(String[] data) {
        if (data == null || 0 == data.length) {
            return new Node();
        }
        Node head = new Node();
        Node p = head;
        for (String str : data) {
            Node node = new Node().setData(str);
            p.setNextNode(node);
            p = node;
        }
        return head;
    }

    public Node reverse(Node head, int k) {
        if (null == head || k <= 0) {
            return head;
        }
        Node pre = head.getNextNode();
        Node after = null;
        head.setNextNode(null);
        while (pre != null) {
            int step = 0;
            after = pre;
            while (step < k - 1 && pre.getNextNode() != null) {
                pre = pre.getNextNode();
                step++;
            }
            Node node = pre.getNextNode();
            pre.setNextNode(head.getNextNode());
            head.setNextNode(after);
            pre = node;
        }
        return head;
    }

    public Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head.getNextNode();
        head.setNextNode(null);
        while (pre != null) {
            Node node = pre.getNextNode();
            pre.setNextNode(head.getNextNode());
            head.setNextNode(pre);
            pre = node;
        }
        return head;
    }


    public void visit(Node head) {
        Node node = head.getNextNode();
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNextNode();
        }
        System.out.println();
    }


    public boolean cycleCheck(Node head) {
        if (null == head) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode();
            if (fast == null) {
                return false;
            } else {
                fast = fast.getNextNode();
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public Node sortedListMerge(Node head1, Node head2) {

        Node head = new Node();
        Node p = head;
        Node node1 = head1.getNextNode();
        Node node2 = head2.getNextNode();

        while (node1 != null && node2 != null) {

            if (Integer.parseInt(node1.getData()) < Integer.parseInt(node2.getData())) {
                p.setNextNode(node1);
                p = node1;
                node1 = node1.getNextNode();
                p.setNextNode(null);
            } else {
                p.setNextNode(node2);
                p = node2;
                node2 = node2.getNextNode();
                p.setNextNode(null);
            }
        }
        if (node1 == null) {
            p.setNextNode(node2);
        }
        if (node2 == null) {
            p.setNextNode(node1);
        }
        return head1;
    }

    /**
     * 删除倒数第N个节点
     *
     * @param head
     * @param n
     *
     * @return
     */
    public Node deleteNode(Node head, int n) {
        if (null == head || n <= 0) {
            return head;
        }
        Node p = head;
        for (int i = 0; i < n; i++) {
            if (p == null) {
                return head;
            }
            p = p.getNextNode();
        }
        Node q = head;
        while (p.getNextNode() != null) {
            q = q.getNextNode();
            p = p.getNextNode();
        }
        q.setNextNode(q.getNextNode().getNextNode());
        return head;
    }

    public Node getMiddleNode(Node head) {
        if (null == head) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null) {
            fast = fast.getNextNode();
            if (null == fast) {
                return slow;
            }
            fast = fast.getNextNode();
            slow = slow.getNextNode();
        }
        return slow;
    }

    public Boolean isCrossOfTwoList(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return false;
        }
        int length1 = 0;
        int length2 = 0;
        Node p = head1;
        while (p != null) {
            p = p.getNextNode();
            length1++;
        }
        p = head2;
        while (p != null) {
            p = p.getNextNode();
            length2++;
        }

        p = head1;
        Node q = head2;
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                p = p.getNextNode();
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                q = q.getNextNode();
            }
        }
        while (p != null && q != null) {
            if (p == q) {
                return true;
            }
            p = p.getNextNode();
            q = q.getNextNode();
        }
        return false;
    }
}
