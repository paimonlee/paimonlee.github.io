package com.code.java.practise.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 16:01:37
 * @apiNote: 图
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public GraphNode(int val) {
        this.val = val;
    }

    public GraphNode() {
        this.val = 0;
        this.neighbors = new ArrayList<GraphNode>();
    }

}
