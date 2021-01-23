package com.newpi.data.linkedList.linkedlist;


import com.newpi.data.linkedList.model.Node;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void cycleCheck() {

        Node head = new Node();
        Node node1 = new Node().setData("1");
        Node node2 = new Node().setData("2");
        Node node3 = new Node().setData("3");
        Node node4 = new Node().setData("4");
        Node node5 = new Node().setData("5");
        Node node6 = new Node().setData("6");
        Node node7 = new Node().setData("7");

        head.setNextNode(node1);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
        node6.setNextNode(node7);
        node7.setNextNode(node3);
//        node7.setNextNode(null);

        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.cycleCheck(head));

    }

    @Test
    public void sortedListMerge(){
        Node head1 = new Node();
        Node head2 = new Node();
        Node node1 = new Node().setData("1");
        Node node2 = new Node().setData("2");
        Node node3 = new Node().setData("3");
        Node node4 = new Node().setData("4");
        Node node5 = new Node().setData("5");
        Node node6 = new Node().setData("6");
        Node node61 = new Node().setData("6");
        Node node7 = new Node().setData("7");
        Node node9 = new Node().setData("9");
        Node node10 = new Node().setData("10");

        head1.setNextNode(node1);
        node1.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node6);
        node6.setNextNode(node10);
        head2.setNextNode(node2);
        node2.setNextNode(node5);
        node5.setNextNode(node61);
        node61.setNextNode(node7);
        node7.setNextNode(node9);

        LinkedList linkedList = new LinkedList();
        linkedList.visit(linkedList.sortedListMerge(head1,head2));
    }

    @Test
    public void deleteNode(){
        Node head = new Node();
        Node node1 = new Node().setData("1");
        Node node2 = new Node().setData("2");
        Node node3 = new Node().setData("3");
        Node node4 = new Node().setData("4");
        Node node5 = new Node().setData("5");
        Node node6 = new Node().setData("6");
        Node node7 = new Node().setData("7");

        head.setNextNode(node1);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
        node6.setNextNode(node7);
        node7.setNextNode(null);

        LinkedList linkedList = new LinkedList();
        linkedList.visit(head);
        linkedList.visit(linkedList.deleteNode(head,3));
        linkedList.visit(linkedList.deleteNode(head,8));
    }

    @Test
    public void getMiddleNode(){
        Node head = new Node();
        Node node1 = new Node().setData("1");
        Node node2 = new Node().setData("2");
        Node node3 = new Node().setData("3");
        Node node4 = new Node().setData("4");
        Node node5 = new Node().setData("5");
        Node node6 = new Node().setData("6");
        Node node7 = new Node().setData("7");

        head.setNextNode(node1);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
        node6.setNextNode(node7);
        node7.setNextNode(null);

        LinkedList linkedList = new LinkedList();
        linkedList.visit(head);
        System.out.println(linkedList.getMiddleNode(head).getData());
    }

    @Test
   public void isCrossOfTwoList(){
        Node head1 = new Node();
        Node head2 = new Node();
        Node node1 = new Node().setData("1");
        Node node2 = new Node().setData("2");
        Node node3 = new Node().setData("3");
        Node node4 = new Node().setData("4");
        Node node5 = new Node().setData("5");
        Node node6 = new Node().setData("6");
        Node node7 = new Node().setData("7");
        Node node9 = new Node().setData("9");
        Node node10 = new Node().setData("10");

        head1.setNextNode(node1);
        node1.setNextNode(node3);
        node3.setNextNode(node5);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
        node6.setNextNode(node7);
        node7.setNextNode(node9);
        node9.setNextNode(node10);

        head2.setNextNode(node2);
        node2.setNextNode(node4);
        node4.setNextNode(node6);

        LinkedList linkedList = new LinkedList();
        linkedList.visit(head1);
        linkedList.visit(head2);
        System.out.println(linkedList.isCrossOfTwoList(head1,head2));
    }
}