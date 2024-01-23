package ru.edu;

import lombok.Data;


import java.util.LinkedList;

@Data
public class QuickSort<T extends Comparable<T>> {

    public LinkedList<T> quickSort(LinkedList<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        int size = list.size();
        T pivot = list.get(size / 2);

        LinkedList<T> smaller = new LinkedList<>();
        LinkedList<T> equal = new LinkedList<>();
        LinkedList<T> larger = new LinkedList<>();

        for (T element : list) {
            int compareResult = element.compareTo(pivot);
            if (compareResult < 0) {
                smaller.add(element);
            } else if (compareResult == 0) {
                equal.add(element);
            } else {
                larger.add(element);
            }
        }

        quickSort(smaller);
        quickSort(larger);

        list.clear();
        list.addAll(smaller);
        list.addAll(equal);
        list.addAll(larger);

        return list;
    }

    public LinkedList<T> transformationCustomLinkedList(CustomLinkedListImpl<T> listCustom) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : listCustom)
            if (element == null){
                break;
            } else {
                list.add(element);
            }
        return list;
    }
}