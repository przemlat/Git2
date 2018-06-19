package articualtionPoint;

import common.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("text.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int lineNumber = 0;

        String line = bufferedReader.readLine();

        while (line != null) {
            lineNumber++;
            line = bufferedReader.readLine();
        }

        int numberOfNodes = --lineNumber;

        Node[] nodes = new Node[numberOfNodes + 1];

        for (int i = 1; i <= numberOfNodes; i++) {
            nodes[i] = new Node(i);
        }

        FileReader fileReader2 = new FileReader("text.txt");
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        int temp = 0;
        for (int i = 1; i <= numberOfNodes; i++) {
            temp++;
            String lowerNodeString = bufferedReader2.readLine();

            for (int j = 0; j < lowerNodeString.length(); j++) {
                if (String.valueOf(lowerNodeString.charAt(j)).equals(" ")) {
                    j++;
                }
                nodes[temp].addNode(nodes[Character.getNumericValue(lowerNodeString.charAt(j))]);
                nodes[Character.getNumericValue(lowerNodeString.charAt(j))].addNode(nodes[temp]);
            }
        }

        ArticulationPoint articulationPoint = new ArticulationPoint(nodes);
        articulationPoint.getResult();
    }
}