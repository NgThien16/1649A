package week5.L04_Queue;

class LinkedQueueADT<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    //constructor
    public LinkedQueueADT() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public void offer(E element){
        Node<E> newNode = new Node<>(element);
        if(head==null&&tail==null) {
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public E poll(){
        if(head== null && tail == null){
            throw new IllegalStateException("Queue is empty");
        }
        E oldElement = head.element;
        if(head==tail) {//if list has only one element
            head = null;
            tail = null;
        }else{// if list has more than one element
            Node<E> tempNode = head;
            head = head.next;
            tempNode.next = null;
        }
        size--;
        return oldElement;
    }
    public E peek(){
        if(head == null && tail == null){
            throw new IllegalStateException("Queue is empty");
        }
        return head.element;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
