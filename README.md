# Абстрактные классы и интерфейсы 

7.4. Итератор по массиву

Задача
--------

Напишите итератор по двумерному массиву.
Итератор — это объект, который позволяет поочередно получать элементы из коллекции.

![](Iterato_pattern4.png)

Решение:
--------

    class Array2d<T> implements Iterable<T>{
        private T[][] array;
    
        public Array2d(T[][] array) {
            this.array = array;
        }
    
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
    
                private int i, j;
    
                @Override
                public boolean hasNext() {
                    for(int i = this.i; i< array.length; i++){
                        for(int j = this.j; j< array[i].length; j++){
                            return true;
                        }
                    }
                    return false;
                }
    
                @Override
                public T next() {
                    if(!hasNext())
                        throw new NoSuchElementException();
                    T t = array[i][j];
                    j++;
                    for(int i = this.i; i< array.length; i++){
                        for(int j = (i == this.i ? this.j : 0); j< array[i].length; j++){
                            this.i = i;
                            this.j = j;
                            return t;
                        }
                    }
    
                    return t;
                }
            };
        }
    }
