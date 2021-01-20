package com.newpi.data.tree.binarysearchtree;

import com.newpi.data.tree.model.TreeNode;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/20 2:54 PM
 * @desc: 二叉搜索树
 */
public class BinarySearchTree {

    public TreeNode createBST(Integer[] data) {
        TreeNode root = null;
        for (Integer num : data) {
            root = insert(root, num);
        }
        return root;
    }

    public TreeNode insertWithRecursion(TreeNode root, Integer data) {

        if (null == root) {
            return new TreeNode().setData(data);
        }
        if (root.getData().equals(data)) {
            return root;
        }
        if (root.getData() > data) {
            if (null == root.getLeftNode()) {
                root.setLeftNode(new TreeNode().setData(data));
            } else {
                insertWithRecursion(root.getLeftNode(), data);
            }
        } else {
            if (null == root.getRightNode()) {
                root.setRightNode(new TreeNode().setData(data));
            }else {
                insertWithRecursion(root.getRightNode(), data);
            }
        }
        return root;
    }

    /**
     * 插入节点
     *
     * @param root
     * @param data
     *
     * @return
     */
    public TreeNode insert(TreeNode root, Integer data) {
        if (null == root) {
            return new TreeNode().setData(data);
        }
        TreeNode parent = root;
        TreeNode currentNode = root;
        while (null != currentNode) {
            parent = currentNode;
            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
            } else {
                if (currentNode.getData() < data) {
                    currentNode = currentNode.getRightNode();
                } else {
                    return root;
                }
            }
        }
        TreeNode node = new TreeNode().setData(data);
        if (parent.getData() > data) {
            parent.setLeftNode(node);
        } else {
            parent.setRightNode(node);
        }
        return root;
    }

    /**
     * 删除节点
     *
     * @param root
     * @param data
     *
     * @return
     */
    public TreeNode delete(TreeNode root, Integer data) {
        return null;
    }


    public boolean find(TreeNode root, Integer data) {

        if (null == root) {
            return false;
        }

        TreeNode currentNode = root;
        while (null != currentNode) {
            if (currentNode.getData().equals(data)) {
                return true;
            }
            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return false;
    }

    public boolean findWithRecursion(TreeNode root, Integer data) {
        if (null == root) {
            return false;
        }
        if (root.getData().equals(data)) {
            return true;
        }
        if (root.getData() > data) {
            return findWithRecursion(root.getLeftNode(), data);
        } else {
            return findWithRecursion(root.getRightNode(), data);
        }
    }
}
