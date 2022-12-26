package com.solvd.app.myLinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyOwnLinkedlist<T> {
    private static final Logger LOGGER = LogManager.getLogger(MyOwnLinkedlist.class);
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public int getSize() {
        return size;

    }

    public void addFirst(T current) {
        Node<T> currentNode;
        if (size == 0) {
            currentNode = new Node<>(null, current, null);
            firstNode = currentNode;
        } else {
            currentNode = new Node<>(null, current, firstNode);
            firstNode.previousNode = currentNode;
            lastNode = firstNode;

        }
        firstNode = currentNode;
        size++;

    }

    public void addLast(T current) {
        Node<T> currentNode;
        if (size == 0) {
            currentNode = new Node<>(null, current, null);
            firstNode = currentNode;
        } else {
            currentNode = new Node<>(lastNode, current, null);
            lastNode.nextNode = currentNode;
        }
        lastNode = currentNode;
        size++;
    }

    public void addByIndex(int index, T current) {
        if (index == 0) {
            addFirst(current);
        } else if (index == size) {
            addLast(current);
        } else {
            int index1 = 0;
            Node<T> addNode = firstNode;
            while (index1 < index) {
                addNode = addNode.nextNode;
                index1++;
            }
            Node<T> prev = addNode.previousNode;
            Node<T> addNewNode = new Node<>(prev, current, addNode);
            addNode.previousNode = addNewNode;
            prev.nextNode = addNewNode;
        }
    }


    public void print() {
        Node<T> currentNode = firstNode;
        String strings = "";

        if (firstNode.current != null) {
            strings += firstNode.current;
            strings += ", ";
        }
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            strings += currentNode.current;
            strings += ", ";
        }

        System.out.println(strings);
    }

    public void removeAll() {
        //сделать стримы
        for (Node<T> x = firstNode; x != null; ) {
            Node<T> next = x.nextNode;
            x.current = null;
            x.nextNode = null;
            x.previousNode = null;
            x = next;
        }
        firstNode = lastNode = null;
        size = 0;
    }

    public void removeByIndex(int index) {
        if (size == 0) {
            LOGGER.info("There are no items in the list");
        }
        if (size == 1) {
            Node<T> removeNode = firstNode;
            removeAll();

        }
        if (index == size) {
            Node<T> removeNode = lastNode;
            lastNode = removeNode.previousNode;
            removeNode.previousNode = null;
            removeNode.nextNode = null;

            size--;

        } else if (index == 0) {
            Node<T> removeNode = firstNode;
            firstNode = removeNode.nextNode;
            removeNode.previousNode = null;
            removeNode.nextNode = null;
            size--;

        } else {
            int index1 = 0;
            Node<T> removeNode = firstNode;
            while (index1 < index) {
                removeNode = removeNode.nextNode;
                index1++;
            }
            removeNode.previousNode.nextNode = removeNode.nextNode;
            removeNode.nextNode.previousNode = removeNode.previousNode;
            size--;

        }
    }

    public void setByIndex(int index, T current) {
        int index1 = 0;
        Node<T> currentNode = firstNode;
        while (index1 < index) {
            currentNode = currentNode.nextNode;
            index1++;
        }
        currentNode.current = current;
    }

    public T getByINdex(int index) {
        int index1 = 0;
        Node<T> currentNode = firstNode;
        while (index1 < index) {
            currentNode = currentNode.nextNode;
            index1++;
        }
        return currentNode.current;
    }

    public class Node<T> {
        private T current;
        private Node<T> nextNode;
        private Node<T> previousNode;

        public Node(Node<T> previousNode, T current, Node<T> nextNode) {
            this.current = current;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

    }


}
