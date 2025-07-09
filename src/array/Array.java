package array;

import array.map.Map;
import array.map.impl.MapImpl;

public class Array {
    public static void main(String[] args) {
        Map<Integer, String> testArray = new MapImpl<>();
        testArray.put(1,"Hello");
        testArray.put(2,"World");
        testArray.put(3,"!");
        String el = testArray.find(2);
        System.out.println(el);
    }
}
