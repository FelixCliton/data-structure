package com.newpi.data.tree.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/19 3:34 PM
 * @desc:
 */
@Data
@Accessors(chain = true)
public class TreeNode {

    private TreeNode leftNode;

    private TreeNode rightNode;

    private Integer data;

}
