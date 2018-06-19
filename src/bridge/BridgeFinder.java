package bridge;

import common.Node;

class BridgeFinder {

    private Node[] nodes;

    BridgeFinder(Node[] nodes, StringBuilder bridges) {
        this.nodes = nodes;
    }

    void getResult() {
        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].isVisited()) {
                DFS(1, i, -1);
            }
        }
    }

    private int DFS(int indexDFS, int currentNodeNumber, int parentNode) {
        Node currentNode = nodes[currentNodeNumber];
        currentNode.setDfsIndex(indexDFS);
        currentNode.setLow(indexDFS);

        for (int i = 0; i < currentNode.getNodes().size(); i++) {
            Node neighbour = currentNode.getNodes().get(i);
            if (neighbour.getNodeIndex() != parentNode) {
                if (!(neighbour.getDfsIndex() > 0)) {
                    int nestedLow = DFS(indexDFS + 1, neighbour.getNodeIndex(), currentNodeNumber);
                    if (nestedLow < currentNode.getLow()) {
                        currentNode.setLow(nestedLow);
                    }

                } else if (neighbour.getDfsIndex() < currentNode.getLow()) {
                    currentNode.setLow(neighbour.getDfsIndex());
                }
            }
        }


        if (parentNode > -1 && currentNode.getDfsIndex() == currentNode.getLow()) {
            System.out.println(parentNode + " " + currentNodeNumber);
        }
        return currentNode.getLow();
    }
}