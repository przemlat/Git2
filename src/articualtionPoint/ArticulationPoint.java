package articualtionPoint;

import common.Node;

class ArticulationPoint {

    private Node[] nodes;

    ArticulationPoint(Node[] nodes) {
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

        int test = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < currentNode.getNodes().size(); i++) {
            Node neighbour = currentNode.getNodes().get(i);
            if (neighbour.getNodeIndex() != parentNode) {
                if (!(neighbour.getDfsIndex() > 0)) {
                    int nestedLow = DFS(indexDFS + 1, neighbour.getNodeIndex(), currentNodeNumber);
                    if (nestedLow < currentNode.getLow()) {
                        currentNode.setLow(nestedLow);
                    }
                    if (nestedLow < currentNode.getLow()) {
                        currentNode.setLow(nestedLow);
                    }
                    if (nestedLow >= currentNode.getDfsIndex()) {
                        test = 1;
                    }

                } else if (neighbour.getDfsIndex() < currentNode.getLow()) {
                    currentNode.setLow(neighbour.getDfsIndex());
                }
            }
        }

        if (test == 1) {
            stringBuilder.append(currentNodeNumber).append(" ");
        }

        System.out.print(stringBuilder.toString());
        return currentNode.getLow();
    }
}