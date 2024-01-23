package ru.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListImplTest {
    CustomLinkedListImpl<String> listCustom;

    @BeforeEach
    void setListCustom() {
        listCustom = new CustomLinkedListImpl<>();
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
    void size_whenAdded8elements_thenSizeIs8() {
        assertEquals(8, listCustom.size());
    }

    @Test
    void testAdd_whenSizeIs8_thenAdded1element_thenSizeIs9() {
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
    void testGetElement() {
        assertEquals("dfg", listCustom.get(3));
    }

    @Test
    void testRemoveElementAndTestNoSuchElementException() {
        assertEquals("bc", listCustom.remove("bc"));
        assertThrows(NoSuchElementException.class, () -> listCustom.remove("bc"));
    }

    @Test
    void testClearLinkedList() {
        assertEquals(8, listCustom.size());
        listCustom.clear();
        assertEquals(0, listCustom.size());
    }
}