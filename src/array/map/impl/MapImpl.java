package array.map.impl;

import array.map.Map;
import array.map.exception.NotUniqueElementException;
import array.map.exception.SizeMapException;

import java.util.Arrays;

public class MapImpl<K, V> implements Map<K, V> {
    final Object[][] list = new Object[10][2];
    int roof = 0;


    @Override
    public void put(K key, V value) {
        if(roof > 9) {
            throw new SizeMapException();
        }
        if(searchUnique(key)) {
            throw new NotUniqueElementException();
        }
        Object[] pair = new Object[2];
        pair[0] = key;
        pair[1] = value;
        list[roof] = pair;
        roof++;
    }

    @Override
    public V find(K key) {
        for (Object[] object : list) {
            if (object[0] != null && object[0].equals(key)) {
                return (V) object[1];
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = 0;
        for (Object[] objects : list) {
            if(objects[0].equals(key)) {
                break;
            }
            index ++;
        }
        list[index] = new Object[2];
        while (index < 9) {
            Object[] swap = list[index + 1];
            list[index + 1] = list[index];
            list[index] = swap;
            index ++;
        }
    }

    private boolean searchUnique(K key) {
            for (int i = 0; i < roof; i++) {  // Только проверяем заполненные элементы (до roof)
                if (list[i][0] != null && list[i][0].equals(key)) {
                    return true;  // Нашли дубликат
                }
            }
            return false;

    }

    @Override
    public String toString() {
        return "MapImpl{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
