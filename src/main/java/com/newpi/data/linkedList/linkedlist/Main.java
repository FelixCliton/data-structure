package com.newpi.data.linkedList.linkedlist;

import com.newpi.data.linkedList.model.Node;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/22 10:02 AM
 * @desc:
 */
public class Main {


    public static void main(String[] args) {
        String[] data = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        LinkedList linkedList  = new LinkedList();
        Node head = linkedList.createLinkedList(data);
        head = reverse2(head.getNextNode());
        visit(head);
//        head = linkedList.reverse(head);
//        linkedList.visit(head);
//        head = linkedList.reverse(head,1);
//        linkedList.visit(head);
//        head = linkedList.reverse(head,2);
//        linkedList.visit(head);
    }
    private static void visit(Node head) {
        Node node = head;
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNextNode();
        }
        System.out.println();
    }
    private static Node reverse(Node head){
        if(null==head){
            return head;
        }
        Node cur = head;
        while (cur!=null){
            Node next = cur.getNextNode();
            cur.setNextNode(next.getNextNode());
            next.setNextNode(head);
            head = next;
        }
        return head;
    }


    private static Node reverse2(Node head){
        if(null==head)
            return null;
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.getNextNode();
            head.setNextNode(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    private static Node reverse3(Node head){
        Node pre = new Node();
        pre.setNextNode(head);
        Node cur = head;
        Node  next = cur.getNextNode();
        while (next!=null){
            cur.setNextNode(next.getNextNode());
            next.setNextNode(pre.getNextNode());
            pre.setNextNode(next) ;
            next = cur.getNextNode();
        }
        return pre.getNextNode();
    }

}
