package com.newpi.data.tree.binarysearchtree;

import com.newpi.data.tree.binary.BinaryTree;
import com.newpi.data.tree.model.TreeNode;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/20 3:32 PM
 * @desc:
 */
public class Main {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{5, 2, 1, 3, 4, 8, 6, 7, 9};
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = bst.createBST(data);
        binaryTree.levelTravelTree(root);
        binaryTree.preOrderUnRecursionTravelTree(root);
        System.out.println();
        binaryTree.inOrderUnRecursionTravelTree(root);
        System.out.println();
        System.out.println(bst.find(root, 8));
        System.out.println(bst.find(root, 10));
        System.out.println(bst.findWithRecursion(root, 8));
        System.out.println(bst.findWithRecursion(root, 10));
        bst.insertWithRecursion(root, 10);
        System.out.println(bst.findWithRecursion(root, 10));
        binaryTree.levelTravelTree(root);
        binaryTree.preOrderUnRecursionTravelTree(root);
        System.out.println();
        binaryTree.inOrderUnRecursionTravelTree(root);
        System.out.println();
    }

}
