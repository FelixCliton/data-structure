package com.newpi.data.tree.binary;

import com.newpi.data.tree.model.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/19 3:36 PM
 * @desc:
 */
public class BinaryTree {


    /**
     * 创建二叉树 输入：层次遍历结果
     */
    public TreeNode createTree(Integer[] data) {

        if (null == data || data.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        TreeNode root = new TreeNode();
        root.setData(data[0]);
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < data.length) {
            TreeNode node = queue.poll();
            if (node.getData() == null) {
                i = i + 2;
                continue;
            }
            if (null == data[i]) {
                node.setLeftNode(null);
                queue.add(new TreeNode());
            } else {
                TreeNode leftNode = new TreeNode();
                leftNode.setData(data[i]);
                queue.add(leftNode);
                node.setLeftNode(leftNode);
            }
            i++;
            if (null == data[i]) {
                node.setRightNode(null);
                queue.add(new TreeNode());
            } else {
                TreeNode rightNode = new TreeNode();
                rightNode.setData(data[i]);
                queue.add(rightNode);
                node.setRightNode(rightNode);
            }
            i++;
        }
        return root;
    }

    public TreeNode createTreeByPreOrder(Integer[] preOrderData) {
        if (null == preOrderData || preOrderData.length == 0) {
            return null;
        }
        Queue<String> queue = new LinkedBlockingQueue<>();
        for (Integer data : preOrderData) {
            queue.add(null == data ? "null" : data.toString());
        }
        TreeNode root = createTreeNodeByPreOrder(queue);
        return root;
    }

    private TreeNode createTreeNodeByPreOrder(Queue<String> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String str = data.poll();
        if ("null".equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode().setData(Integer.valueOf(str));
        node.setLeftNode(createTreeNodeByPreOrder(data));
        node.setRightNode(createTreeNodeByPreOrder(data));
        return node;
    }

    /**
     * 先序递归遍历树
     *
     * @param root
     */
    public void preOrderTravelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrderTravelTree(root.getLeftNode());
        preOrderTravelTree(root.getRightNode());
    }

    /**
     * 中序递归遍历树
     *
     * @param root
     */
    public void inOrderTravelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTravelTree(root.getLeftNode());
        System.out.print(root.getData() + " ");
        inOrderTravelTree(root.getRightNode());
    }

    /**
     * 后续递归遍历树
     *
     * @param root
     */
    public void postOrderTravelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTravelTree(root.getLeftNode());
        postOrderTravelTree(root.getRightNode());
        System.out.print(root.getData() + " ");
    }

    /**
     * 层次遍历树
     *
     * @param root
     */
    public void levelTravelTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        if (null == root) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.getData()).append(" ");
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.getLeftNode() != null) {
                stringBuilder.append(node.getLeftNode().getData()).append(" ");
                queue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                stringBuilder.append(node.getRightNode().getData()).append(" ");
                queue.add(node.getRightNode());
            }
        }
        System.out.println(stringBuilder.toString());
    }


    /**
     * 非递归先序遍历树
     *
     * @param root
     */
    public void preOrderUnRecursionTravelTree(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
        }
    }

    /**
     * 非递归中序遍历树
     *
     * @param root
     */
    public void inOrderUnRecursionTravelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.getLeftNode();
            } else {
                p = stack.pop();
                System.out.print(p.getData() + " ");
                p = p.getRightNode();
            }
        }
    }

    /**
     * 非递归后续遍历树，双栈实现
     *
     * @param root
     */
    public void postOrderUnRecursionTravelTree(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            stack2.push(node);
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
        }

        while (!stack2.empty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.getData() + " ");
        }
    }
}
