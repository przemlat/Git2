package common;

import java.util.ArrayList;

public class Node {

    private int nodeIndex;
    private int dfsIndex;
    private boolean isVisited;
    private int low;
    private ArrayList<Node> nodes = new ArrayList<>();

    public Node(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public void addNode(Node Node) {
        nodes.add(Node);
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public int getDfsIndex() {
        return dfsIndex;
    }

    public void setDfsIndex(int dfsIndex) {
        this.dfsIndex = dfsIndex;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}
