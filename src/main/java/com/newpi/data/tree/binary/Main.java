package com.newpi.data.tree.binary;

import com.newpi.data.tree.model.TreeNode;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/19 4:54 PM
 * @desc:
 */
public class Main {
    private static Integer[] levelTravelTreeData = new Integer[]{1, 2, 3, 4, null, null, 7, null, null, null, null, null, null, 14, 15};
    private static Integer[] preOrderTravelTreeData = new Integer[]{1, 2, 4, null, null, null, 3, null, 7, 14, 15};

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
//        TreeNode root = binaryTree.createTree(levelTravelTreeData);
        TreeNode root = binaryTree.createTreeByPreOrder(preOrderTravelTreeData);
        binaryTree.levelTravelTree(root);
        binaryTree.preOrderTravelTree(root);
        System.out.println();
        binaryTree.inOrderTravelTree(root);
        System.out.println();
        binaryTree.postOrderTravelTree(root);
        System.out.println();
        binaryTree.preOrderUnRecursionTravelTree(root);
        System.out.println();
        binaryTree.inOrderUnRecursionTravelTree(root);
        System.out.println();
        binaryTree.postOrderUnRecursionTravelTree(root);
        System.out.println();
    }

}
