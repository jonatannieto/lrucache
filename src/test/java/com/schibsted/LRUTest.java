package com.schibsted;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonatannietoa on 27/07/2016.
 */
public class LRUTest {
    private LRU lru;

    @Before
    public void setUp(){
        lru = new LRU(3);
    }

    @Test
    public void lru_add_values_with_first_item_removed(){
        lru.put(1, "aaa");
        lru.put(2, "bbb");
        lru.put(3, "ccc");
        lru.put(4, "ddd");

        lru.print();

        assertEquals(lru.toString(), "bbb ccc ddd ");
    }

    @Test
    public void lru_add_values_and_use_first() throws Exception {
        lru.put(1, "aaa");
        lru.put(2, "bbb");
        lru.put(3, "ccc");
        lru.get(1);
        lru.put(4, "ddd");

        lru.print();

        assertEquals(lru.toString(), "ccc aaa ddd ");
    }

    @Test
    public void lru_add_values_and_use_second() throws Exception {
        lru.put(1, "aaa");
        lru.put(2, "bbb");
        lru.put(3, "ccc");
        lru.get(2);
        lru.put(4, "ddd");

        lru.print();

        assertEquals(lru.toString(), "ccc bbb ddd ");
    }

    @Test(expected = NullPointerException.class)
    public void lru_add_values_and_get_first() throws Exception {
        lru.put(1, "aaa");
        lru.put(2, "bbb");
        lru.put(3, "ccc");
        lru.put(4, "ddd");
        lru.get(1);
    }
}