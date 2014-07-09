package searching;

import datastructures.node.BasicNode;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/07/14
 * Time: 14.13
 */
public class BinarySearch {


    /**
     * searches for a key into a sorted array of nodes (containing key and value)
     * @param nodes
     * @param key
     * @return the searched node or nuill if key not present
     */
    public static BasicNode getNode(BasicNode[] nodes, int key) {

        int j;
        int min = 0;
        int max = nodes.length;

        do {
            j = (min + max) / 2;

            if (nodes[j].getKey() == key) return nodes[j];

            if (nodes[j].getKey()>key) {
                max = j;
            }
            else  {
                min = j;
            }
        } while (Math.abs(min-max) > 1);

        return null;
    }


}
