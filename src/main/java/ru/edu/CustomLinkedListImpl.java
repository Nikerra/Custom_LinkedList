package ru.edu;

import lombok.Data;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// следи за нэймингом. LinkedListCustom и CustomLinkedList сильно путают
public class CustomLinkedListImpl<T> implements CustomLinkedList<T>, Iterable<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public CustomLinkedListImpl() {
        //firstNode в инициализации lastNode всегда null. Параметризация объекта тоже лишняя, джава сама выводит тип
        //по типу ссылки
        lastNode = new Node<>(null, null, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    /**
     *
     * @return size of the LinkedList
     */
    public  int size() {
        return size;
    }

    /**
     *
     * @param element adds to the LinkedList
     */
    @Override
    public void add(T element) {

        Node<T> previousElement = lastNode;
        previousElement.setCurrentElement(element);
        lastNode = new Node<>(null, previousElement, null);
        previousElement.setNextElement(lastNode);
        size++;
    }

    /**
     *
     * @param index   - index for the add an element to the LinkedList
     * @param element - adds to the LinkedList
     */
    @Override
    public void addByIndex(int index, T element) {

            if (index == size) {
                add(element);
            } else {
                addBefore(element, node(index));
            }
        }

    /**
     *
     * @param index - index of the element to return from the LinkedList
     * @return element from the LinkedList
     */
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

    /**
     *
     * @param element - removes the first occurrence of an element in an array
     * @return the removed element
     */
    @Override
    public T remove(T element) {
        int i=0;
        Node<T> currentNode = firstNode;
        Node<T> previousNode = null;
        boolean flag = false;
        while ((!flag)) {
            if (currentNode.nextElement == null) {
                //А что если параметризуем не строкой? Тут надо прокидывать исключение.
                return (T) ("element \"" + element + "\" not found");
            }
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

    /**
     * clears the LinkedList
     */
    @Override
    public void clear() {

        size = 0;
        firstNode = new Node<>(null, null, lastNode);
        lastNode = new Node<>(null,firstNode,null);
    }



    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                return get(counter--);
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
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
    private void addBefore(T t, Node<T> node) {

        Node<T> pred = node.previousElement;
        Node<T> newNode = new Node<>(t, pred, node);
        node.previousElement = newNode;
        if (pred == null) {
            firstNode = newNode;
        } else {
            pred.nextElement = newNode;
        }
        size++;

    }
    private Node<T> node(int index) {

        if (index < (size >> 1)) {
            Node<T> target = firstNode;
            for (int i = 0; i < index + 1; i++)
                target = target.nextElement;
            return target;
        } else {
            Node<T> target = lastNode;
            for (int i = size - 1; i > index; i--)
                target = target.previousElement;
            return target;
        }
    }

}

