package ru.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCustomTest {
    LinkedListCustom<String> listCustom = new LinkedListCustom<>();

    @BeforeEach
    void setListCustom() {
        listCustom.add("abc");
        listCustom.add("bc");
        listCustom.add("c");
        listCustom.add("dfg");
        listCustom.add("df");
        listCustom.add("g");
        listCustom.add("ghj");
        listCustom.add("gh");
    }
    @Test
    void testSize() {
        assertEquals(8, listCustom.size());
    }

    @Test
    void testAdd() {
        assertEquals(8, listCustom.size());
        listCustom.add("abc");
        assertEquals(9, listCustom.size());
    }

    @Test
    void testAddByIndex() {
        assertEquals("dfg", listCustom.get(3));
        listCustom.addByIndex(3,"new DFG");
        assertEquals("new DFG", listCustom.get(3));
    }

    @Test
    void testGet() {
        assertEquals("dfg", listCustom.get(3));
    }

    @Test
    void testRemove() {
        assertEquals("bc", listCustom.remove("bc"));
        assertEquals("element \"bc\" not found", listCustom.remove("bc"));
    }

    @Test
    void testClear() {
        assertEquals(8, listCustom.size());
        listCustom.clear();
        assertEquals(0, listCustom.size());
    }
}