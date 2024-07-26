package com.code.java.practise.package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import com.code.java.practise.utils.GraphNode;

/**
 * @author: liyunfeng/2253339528@qq.com
 * @since: 2022年7月31日 15:56:52
 * @apiNote: 图的克隆
 */
public class Question133 {
    public static void main(String[] args) {
        GraphNode graphNode = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);
        GraphNode graphNode4 = new GraphNode(4);
        graphNode.neighbors = Arrays.asList(graphNode2, graphNode4);
        graphNode2.neighbors = Arrays.asList(graphNode, graphNode3);
        graphNode3.neighbors = Arrays.asList(graphNode2, graphNode4);
        graphNode4.neighbors = Arrays.asList(graphNode, graphNode3);
        Question133 question133 = new Question133();
        GraphNode cloneGraph = question133.cloneGraph(graphNode);
        return;
    }

    public GraphNode cloneGraph(GraphNode node) {
        if (Objects.isNull(node)) {
            return node;
        }
        return bfs(node);
    }

    private Map<GraphNode, GraphNode> record = new HashMap();

    public GraphNode bfs(GraphNode node) {
        GraphNode graphNode = new GraphNode(node.val);
        record.put(node, graphNode);
        List<GraphNode> neighbors = new ArrayList<>();
        for (GraphNode neighbor : node.neighbors) {
            GraphNode newNeighbor = null;
            if (!record.containsKey(neighbor)) {
                newNeighbor = bfs(neighbor);
            } else {
                newNeighbor = record.get(neighbor);
            }
            neighbors.add(newNeighbor);
        }
        graphNode.neighbors = neighbors;
        return graphNode;
    }
}
