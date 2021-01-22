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

}
