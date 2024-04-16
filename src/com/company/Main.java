package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Object[][] o = {{"text 11", 14132, 15753, "text 12", "----------- 13"},{"text 21", 214132, 25753, "text 22", "----------- 23"},{"text 31", 314132, 35753, "text 32", "----------- 33"}};
        MyArray<Object> itrO = new MyArray<Object>(o);

        for (int i = 0; i<25; i++){
            System.out.println(itrO.next());
        }

    }
}

class MyArray <T> implements Iterator {

    private T[][] array;
    private int index_1 = 0;
    private int index_2 = 0;

    public MyArray(T[][] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (index_2 < array[index_1].length){
            return true;
        }
        index_2 = 0;
        index_1++;
        if (index_1 < array.length){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (hasNext()){
            return array[index_1][index_2++];
        }
        index_1 = 0;
        return array[index_1][index_2++];
    }

    @Override
    public void remove() {
        array[index_1][index_2] = null;
    }
}
