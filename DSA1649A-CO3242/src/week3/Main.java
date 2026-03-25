package week3;

import java.util.Arrays;

class ArrayListADT<E>{
    //properties
    private E[] elements;
    private int nextIndex;
    //constructor
    public ArrayListADT(){
        elements =(E[]) new Object[5];
        nextIndex = 0;
    }
    public void ensureCapacity(){
        if(nextIndex == elements.length) {
//            //Option1
//            E[] newElements = (E[]) new Object[elements.length*2];
//            for (int i = 0; i < elements.length ; i++) {
//                newElements[i] = elements[i];
//            }
//            this.elements = newElements;
            //Option 2
            this.elements = Arrays.copyOf(this.elements, this.elements.length*2);
        }
    }
    public boolean add(E element) {
        ensureCapacity();
        this.elements[nextIndex] = element;
        nextIndex++;
        return true;
    }
    public void add(int index, E element){
        if(element==null){
            throw new NullPointerException("Element cannot be null");
        }
        ensureCapacity();
        if(index<0||index>nextIndex){
            throw new IndexOutOfBoundsException("Out of range");
        }
        //shift element to the right
        for (int i = nextIndex; i >=index ; i--) {
            elements[i]=elements[i-1];
        }
        elements[index] = element;
        nextIndex++;
        //insert the new element
    }
    public E get(int index){
        if(index<0||index>nextIndex){
            throw new IndexOutOfBoundsException("Out of range");
        }
        return this.elements[index];
    }
    public E set(int index, E element){
        if(element==null){
            throw new NullPointerException("Element cannot be null");
        }
        if(index<0||index>nextIndex){
            throw new IndexOutOfBoundsException("Out of range");
        }
        E oldElement = elements[index];

        elements[index]= element;
        return oldElement;
    }
    public E remove(int index){
        if(index<0||index>nextIndex){
            throw new IndexOutOfBoundsException("Out of range");
        }
        E oldElement = elements[index];
        for (int i = index; i <nextIndex-1 ; i++) {
            elements[i]=elements[i+1];
        }
        elements[nextIndex-1]=null;
        nextIndex--;
        if(nextIndex<=elements.length/3){
            this.elements= Arrays.copyOf(this.elements,this.elements.length/2);
        }
        return oldElement;
    }
    public int size(){
        return nextIndex;
    }
    public boolean isEmpty(){
        //option 1
        if(nextIndex==0){
            return true;
        }else{
            return false;
        }
        //option 2
//        if(nextIndex==0) return true;
//        return false;
        //option3
        // return nextIndex == 0;
    }
    public int indexOf(E element){

        for (int i = 0; i < nextIndex; i++) {
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E element){

        for (int i = 0; i < nextIndex; i++) {
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder finalString = new StringBuilder("[");
        for (int i = 0; i <nextIndex; i++) {
            finalString.append(elements[i]);
            if(i<nextIndex-1){
                finalString.append(", ");
            }
        }
        finalString.append("]");
        return finalString.toString();
    }
}
public class Main {
    static void main(String[] args) {
        ArrayListADT<Integer> myArrayList = new ArrayListADT<>();

        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
        myArrayList.add(70);

        myArrayList.toString();
    }
}