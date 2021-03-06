package articualtionPoint;

import common.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ArticulationPoint {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("text.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        int lnumber = 0;
        while (line != null) {
            lnumber++;
            line = bufferedReader.readLine();
        }
        int nodesNumber = lnumber - 1;

        Node[] nodes = new Node[nodesNumber + 1];
        int n = 1;
        while (n <= nodesNumber) {
            nodes[n] = new Node(n);
            n++;
        }

        FileReader newFileReader = new FileReader("text.txt");
        BufferedReader newBufferedReader = new BufferedReader(newFileReader);

        int index = 0;
        for (int i = 1; i <= nodesNumber; i++) {
            index++;
            String lowNode = newBufferedReader.readLine();
            for (int j = 0; j < lowNode.length(); j++) {
                if (String.valueOf(lowNode.charAt(j)).equals(" ")) {
                    j++;
                }
                nodes[index].addNode(nodes[Character.getNumericValue(lowNode.charAt(j))]);
                nodes[Character.getNumericValue(lowNode.charAt(j))].addNode(nodes[index]);
            }
        }
        ArticulationPoint articulationPoint = new ArticulationPoint(nodes);
        articulationPoint.getResult();
    }

    private Node[] nodes;

    private ArticulationPoint(Node[] nodes) {
        this.nodes = nodes;
    }

    private int DeepFirstSearch(int indexDFS, int nodeIndex, int parentNode) {
        Node node = nodes[nodeIndex];
        node.setLow(indexDFS);
        node.setDfsIndex(indexDFS);
        boolean condition = false;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < node.getNodes().size(); i++) {
            Node neighbourNode = node.getNodes().get(i);
            if (neighbourNode.getNodeIndex() != parentNode) {
                if (neighbourNode.getDfsIndex() <= 0) {
                    int lowNode = DeepFirstSearch(indexDFS + 1, neighbourNode.getNodeIndex(), nodeIndex);
                    if (lowNode >= node.getDfsIndex()) {
                        condition = true;
                    } else if (lowNode < node.getLow()) {
                        node.setLow(lowNode);
                    }
                } else if (neighbourNode.getDfsIndex() < node.getLow()) {
                    node.setLow(neighbourNode.getDfsIndex());
                }
            }
        }
        if (condition) {
            stringBuilder.append(nodeIndex).append(" ");
        }
        System.out.print(stringBuilder.toString());
        return node.getLow();
    }

    private void getResult() {
        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].isVisited()) {
                DeepFirstSearch(1, i, -1);
            }
        }
    }
}
