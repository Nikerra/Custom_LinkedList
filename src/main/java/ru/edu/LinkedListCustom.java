package ru.edu;

import lombok.Data;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedListCustom <T> implements CustomLinkedList<T>, Iterable<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public LinkedListCustom() {
        lastNode = new Node<T> (null, firstNode, null);
        firstNode = new Node<T> (null, null, lastNode);
    }

    @Override
    public void add(T element) {

        Node<T> previousElement = lastNode;
        previousElement.setCurrentElement(element);
        lastNode = new Node<>(null, previousElement, null);
        previousElement.setNextElement(lastNode);
        size++;
    }
    @Override
    public void addByIndex(int index, T element) {

            if (index == size) {
                add(element);
            } else {
                addBefore(element, index);
            }
        }

    private void addBefore(T element, int index) {


        Node<T> nextNode = firstNode;
        Node<T> previousNode = null;

        for (int i = 0; i < index; i++) {
            nextNode = nextNode.nextElement;
            previousNode = nextNode.nextElement;
            System.out.println("AddBefore method nextNode=" + nextNode.currentElement);
            System.out.println("AddBefore method previousNode=" + previousNode.currentElement);
        }
        Node<T> target = new Node<>(element,nextNode,previousNode);
        System.out.println("target=" + target.currentElement);
    }

    @Override
    public T get(int index) {

        Node<T> target = firstNode.getNextElement();

        for (int i = 0; i < index; i++) {
            target = getElement(target);
        }
        return target.getCurrentElement();
    }
    private Node<T> getElement(Node<T> current) {
        return current.getNextElement();
    }
    @Override
    public T remove(T element) {

        Node<T> currentNode = firstNode;
        Node<T> previousNode = null;
        boolean flag = false;
        while ((!flag)) {
            if(currentNode.getCurrentElement() == element) {
                if(currentNode == firstNode) {
                    firstNode = currentNode.nextElement;
                    flag = true;
                } else {
                    previousNode.nextElement = currentNode.nextElement;
                    flag = true;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.nextElement;
        }
        return previousNode.getCurrentElement();
    }
    @Override
    public void clear() {

        size = 0;
        firstNode = new Node<>(null, null, lastNode);
        lastNode = new Node<>(null,firstNode,null);
    }



    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                return counter >=0;
            }

            @Override
            public T next() {
                return get(counter--);
            }
        };
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Data
    private class Node<T> {
        private T currentElement;
        private Node<T> nextElement;
        private Node<T> previousElement;

        public Node(T currentElement,  Node<T> previousElement, Node<T> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.previousElement = previousElement;
        }
    }

    public  int size() {
        return size;
    }
}

