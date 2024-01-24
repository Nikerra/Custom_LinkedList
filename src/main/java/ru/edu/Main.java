package ru.edu;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {

        CustomLinkedListImpl<String> listCustom = new CustomLinkedListImpl<>();
        listCustom.add("abc");
        listCustom.add("bc");
        listCustom.add("c");
        listCustom.add("dfg");
        listCustom.add("df");
        listCustom.add("g");
        listCustom.add("ghj");
        listCustom.add("gh");

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

        for (String s : listCustom){
            System.out.println("element by forEach=" + s);
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("remove element=" + listCustom.remove("bc"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Iterator<String> iterator = listCustom.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println("element by descending Iterator=" + iterator.next());
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        listCustom.clear();
        System.out.println("size for clear=" +listCustom.size());

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("element by index(0) for the clean list=" + listCustom.get(0));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("remove element=" + listCustom.remove("bc"));
    }
}