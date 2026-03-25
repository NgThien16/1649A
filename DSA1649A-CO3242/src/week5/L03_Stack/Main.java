package week5.L03_Stack;
class LinkedStackADT<E>{
    private Node<E> top;
    private int size;
    public LinkedStackADT(){
        top = null;
        size = 0;
    }
    //push
    public void push(E element){
        Node<E> newNode = new Node<>(element);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    public E pop(){
        if(top == null){
            throw new IllegalStateException("linked stack is empty");
        }
        E oldElement = top.element;

        Node<E> tempNode = top;
        top = top.next;
        tempNode.next = null;

        size--;
        return oldElement;
    }
    public E peek(){
        if(top == null){
            throw new IllegalStateException("linked stack is empty");
        }
        return top.element;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void clear(){
        top = null;
        size = 0;
    }
    @Override
    public String toString(){
        StringBuilder  result = new StringBuilder();
        result.append("[");
        Node<E> temp = top;
        while(temp != null){
            result.append(temp.element);
            if(temp.next != null){
                result.append(", ");
            }
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }
    private class Node<E>{
        private E element;
        private
        Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedStackADT<Integer> linkedStackADT = new LinkedStackADT<Integer>();
        linkedStackADT.push(1);
        linkedStackADT.push(2);
        linkedStackADT.toString();
        linkedStackADT.pop();
        linkedStackADT.toString();
    }
}
