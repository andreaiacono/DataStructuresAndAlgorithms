package datastructures;

import datastructures.node.LinkedNode;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 11/07/14
 * Time: 21.59
 */
public class MyLinkedList<E> {

    LinkedNode<E> root;

    public void add(E value) {

        LinkedNode<E> node = new LinkedNode<E>(value);

        if (root == null) {
            root = node;
            return;
        }

        LinkedNode<E> lastNode = getLastNode();
        lastNode.setNext(node);
    }

    public void add(E value, int index) {

        LinkedNode<E> newNode = new LinkedNode<E>(value);

        if (root == null) {
            root = newNode;
            return;
        }

        if (index == 0) {
            newNode.setNext(root);
            root = newNode;
            return;
        }

        int counter = 0;
        LinkedNode node = root;

        while (counter < index - 1 && node.getNext() != null) {
            node = node.getNext();
            counter++;
        }

        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    public E get(int index) {

        if (root == null) return null;

        int counter = 0;
        LinkedNode node = root;
        while (counter < index && node.getNext() != null) {
            node = node.getNext();
            counter++;
        }

        return (E) node.getValue();
    }

    private LinkedNode getLastNode() {

        if (root == null) return null;

        LinkedNode node = root;
        while (node.getNext() != null) {
            node = node.getNext();
        }

        return node;
    }

    public int size() {

        if (root == null) return 0;

        int counter = 1;
        LinkedNode node = root;
        while (node.getNext() != null) {
            node = node.getNext();
            counter++;
        }

        return counter;
    }

    public void delete(int index) {

        if (root == null) return;

        if (root.getNext() == null) {
            root = null;
            return;
        }

        int counter = 0;
        LinkedNode node = root;

        while (counter < index - 1 && node.getNext() != null) {
            node = node.getNext();
            counter++;
        }

        node.setNext(node.getNext()== null?null:node.getNext().getNext());
    }
}
