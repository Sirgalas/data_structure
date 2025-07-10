package dynamicArray;

import dynamicArray.entity.DynamicArray;
import dynamicArray.entity.impl.DynamicArrayImpl;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArrayImpl<>();
        System.out.println(dynamicArray.isEmpty());
        for (int i = 1; i < 100; i ++ ) {
            dynamicArray.add(i);
        }
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.get(0));
        dynamicArray.remove(0);
        System.out.println(dynamicArray.get(0));
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray.get(50));
        dynamicArray.insert(134, 50);
        System.out.println(dynamicArray.get(50));
        System.out.println(dynamicArray.size());
    }
}
