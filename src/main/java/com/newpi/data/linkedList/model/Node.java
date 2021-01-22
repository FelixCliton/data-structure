package com.newpi.data.linkedList.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/22 9:35 AM
 * @desc:
 */
@Data
@Accessors(chain = true)
public class Node {

    private String data;

    private Node nextNode;

}
