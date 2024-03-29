package ru.edu;



import java.util.Iterator;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {

        CustomLinkedListImpl<String> listCustom = new CustomLinkedListImpl<>();
        listCustom.add("c");
        listCustom.add("bc");
        listCustom.add("abc");
        listCustom.add("gh");
        listCustom.add("dfg");
        listCustom.add("df");
        listCustom.add("g");
        listCustom.add("ghj");

        System.out.println("size for add element=" + listCustom.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("element by index(2)=" + listCustom.get(2));
        System.out.println("element by index(1)=" + listCustom.get(1));
        System.out.println("element by index(0)=" + listCustom.get(0));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (String s : listCustom){
            System.out.println("element by forEach=" + s);
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("element by index(3)=" + listCustom.get(3));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        listCustom.addByIndex(3,"new abc");
        System.out.println("element by index(3) for  add by index=" + listCustom.get(3));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.print("element by forEach before sorting=");
        for (String s : listCustom){
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        LinkedList<String> list = new LinkedList<>();
        QuickSort<String> sort = new QuickSort<>();
        list = sort.quickSort(sort.transformationCustomLinkedList(listCustom));
        System.out.print("element after quick sort=");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+ " ");
        }
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("remove element=" + listCustom.remove("bc"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Iterator<String> iterator = listCustom.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println("element by descending Iterator=" + iterator.next());
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        listCustom.clear();
//        System.out.println("size for clear=" +listCustom.size());

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("element by index(0) for the clean list=" + listCustom.get(0));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("remove element=" + listCustom.remove("bc"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}