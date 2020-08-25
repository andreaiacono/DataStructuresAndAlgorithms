//package searching;
//
//import datastructures.BinaryTree;
//import datastructures.node.BinaryTreeNode;
//
//import java.util.*;
//import java.util.stream.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: andrea
// * Date: 26/06/14
// * Time: 13.54
// */
//interface MyList{
//    void convert(String[] a);
//    void replace(int idx);
//    ArrayList<String> compact();
//}
//
//
//class InvalidStringException extends Exception {
//    public InvalidStringException() {
//        super();
//    }
//}
//
//class ArrayToList implements MyList {
//    ArrayList<String> arrayToList;
//
//    public ArrayToList() {
//        arrayToList = new ArrayList<>();
//    }
//
//    public void convert(String[] a) {
//        if (a == null) {
//            return;
//        }
//        for (int i=0; i<a.length; i++) {
//            arrayToList.add(a[i]);
//            System.out.println("I have added the string: " + a[i] + " at the index: " + (arrayToList.size()-1));
//        }
//    }
//
//    public void replace(int idx) {
//        System.out.print("I have replaced the string: " + arrayToList.get(idx) + " with a null string");
//        arrayToList.set(idx, "");
//    }
//
//    public ArrayList<String> compact() {
//        return arrayToList.stream().filter(s -> s.length()> 0).collect(Collectors.toCollection())
//    }
//}
//public class BinarySearchTree extends BinaryTree {
//
//
//    public BinaryTreeNode getNode(Integer key) {
//
//        BinaryTreeNode browsingNode = root;
//        while (browsingNode != null) {
//
//            if (key.compareTo(browsingNode.getKey()) < 0) {
//                browsingNode = browsingNode.getLeft();
//            }
//            else if (key.compareTo(browsingNode.getKey()) > 0) {
//                browsingNode = browsingNode.getRight();
//            }
//            else {
//                return browsingNode;
//            }
//        }
//
//        return null;
//    }
//
//
//    public void insert(Integer key, String value) {
//
//        if (root == null) {
//            root = new BinaryTreeNode(key, value);
//        }
//        else {
//
//            BinaryTreeNode node = root;
//            while (node != null) {
//
//                if (key < node.getKey()) {
//                    if (node.getLeft() == null) {
//                        BinaryTreeNode newNode = new BinaryTreeNode(key, value);
//                        node.setLeft(newNode);
//                        return;
//                    }
//                    else {
//                        node = node.getLeft();
//                    }
//                }
//                else if (key > node.getKey()) {
//                    if (node.getRight() == null) {
//                        BinaryTreeNode newNode = new BinaryTreeNode(key, value);
//                        node.setRight(newNode);
//                        return;
//                    }
//                    else {
//                        node = node.getRight();
//                    }
//                }
//                else {
//                    node.setValue(value);
//                }
//            }
//        }
//    }
//
//    public void remove(Integer value) {
//
//    }
//
//
//
//    public static boolean validateTree(BinaryTreeNode node, int min, int max) {
//
//        if (node == null) {
//            return true;
//        }
//
//        return (node.getKey() > min && node.getKey() <= max && validateTree(node.getLeft(), min, node.getKey()) && validateTree(node.getRight(), node.getKey(), max));
//    }
//
//}
