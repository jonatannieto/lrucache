package com.schibsted;

import java.util.LinkedHashMap;

/**
 * Created by jonatannietoa on 27/07/2016.
 */
public class LRU {
    private LinkedHashMap<Integer,String> lruMap;
    private int lruSize;

    public LRU(int lruSize) {
        this.lruMap = new LinkedHashMap<Integer, String>();
        this.lruSize = lruSize;
    }

    public void put(int key, String value){
        if(lruMap.values().size()>=lruSize){
            lruMap.remove(lruMap.keySet().iterator().next());
        }
        lruMap.put(key, value);
    }

    public String get(int key) throws Exception {
        if(lruMap.get(key)!=null){
            final String value = lruMap.get(key);
            lruMap.remove(key);
            lruMap.put(key, value);
            return value;
        } else {
            throw new NullPointerException("Key is not in cache");
        }
    }

    @Override
    public String toString(){
        String lruString = "";
        for (String value : lruMap.values()) {
            lruString = lruString + value + " ";
        }
        return lruString;
    }

    public void print(){
        System.out.println(this.toString());
    }
}
