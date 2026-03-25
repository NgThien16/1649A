package project_brief.library;

public class ArrayListADT<E> {
    private Object[] array;
    private int size;

    public ArrayListADT(){
        array = new Object[10];
        size = 0;
    }
    public void resize(){
        if(size == array.length){
            Object[] temp = new Object[array.length*2];
            for(int i=0;i<size;i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }
    public boolean add(E element){
        if(size == array.length){
            resize();
        }
        array[size] = element;
        size ++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) array[index];
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldElement = (E) array[index];
        array[index] = element;
        return oldElement;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldElement = (E) array[index];
        // move elements to the left 1
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }

        // delete old paramater for Garbage Collector working
        array[--size] = null;

        return oldElement;
    }

    public int size() {
        return size;
    }
}

