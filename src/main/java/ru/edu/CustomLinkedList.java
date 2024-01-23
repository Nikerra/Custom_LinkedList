package ru.edu;

import java.util.Iterator;

public interface CustomLinkedList<T> {


        /**
         * Add single item.
         */
        void add(T element);

        /**
         * add an element by index.
         *
         * @param index   - index
         * @param element - element for insert
         */
        void addByIndex(int index, T element);

        /**
         * Get item by index.
         *
         * @param index - index
         */
        T get(int index);


        /**
         * Clear list.
         */
        void clear();


        /**
         *
         * @param element - item
         * @return index of a remove element or -1 of a list doesn't contain the element
         */
        T remove(T element);

        Iterator<T> descendingIterator();
}
