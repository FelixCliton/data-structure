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
        linkedList.visit(head);
        head = linkedList.reverse(head);
        linkedList.visit(head);
        head = linkedList.reverse(head,1);
        linkedList.visit(head);
        head = linkedList.reverse(head,2);
        linkedList.visit(head);
    }

}
