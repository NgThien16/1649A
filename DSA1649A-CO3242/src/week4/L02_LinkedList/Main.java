package week4.L02_LinkedList;


class LinkedListADT<E>{
    //attributes
    private Node<E> head;
    private Node<E> tail;
    private int size;
    //constructor
    public LinkedListADT() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    //methods
    public void AddFirst(E element){
        Node<E> newNode = new Node<>(element);
        //if list is empty
        if(head==null&&tail==null) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;

    }
    public void AddLast(E element){
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
    // Access methods
    public E getFirst(){
        //option 1
//        if(size != 0) {
//            return head.element;
//        }else{
//            throw new IllegalStateException("Cannot get first element from an empty list.");
//        }
        //option 2
        if (size == 0) {
            throw new IllegalStateException(
                    "Cannot get first element from an empty list."
            );
        }
        return head.element;
    }
    public E getLast() {
        if (size == 0) {
            throw new IllegalStateException(
                    "Cannot get last element from an empty list."
            );
        }
        return tail.element;
    }
    //removal
    public E removeFirst(){
        //if list is empty
        if(head== null && tail == null){
            throw new IllegalStateException("List is empty");
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
    public E removeLast(){
        //if list is empty
        if(head== null && tail == null){
            throw new IllegalStateException("List is empty");
        }
        E oldElement = tail.element;
        if(head==tail) {//if list has only one element
            head = null;
            tail = null;
        }else{// if list has more than one element
            Node<E> tempNode = head;
            while(tempNode.next!=tail){
                tempNode = tempNode.next;
            }
            tail = tempNode;
            tail.next = null;
        }
        size--;
        return oldElement;
    }
    //remove bất kì
    //hai biến tạm
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return head == null && tail == null;
    }
    public void remove(E element){
        if(head== null && tail == null){
            throw new IllegalStateException("List is empty");
        }
        if(head.element.equals(element)){
            removeFirst();
        }
        if(tail.element.equals(element)){
            removeLast();
        }
        Node<E> tempNodeA = head;
        Node<E> tempNodeB = tempNodeA.next;
        while(tempNodeA != null && tempNodeB != null){
            if(tempNodeA.element.equals(element)){
                tempNodeA.next = tempNodeB.next;
                tempNodeB.next = null;
                break;
            }
        }
        tempNodeA = tempNodeA.next;
        tempNodeB = tempNodeB.next;
    }

    //node
    public class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }
    }
}
public class Main{
    public static void main(String[] args) {
        LinkedListADT<Integer> array = new LinkedListADT<>();
        array.AddFirst(1);
        array.AddFirst(3);
        array.AddFirst(5);

        System.out.println("first element: "+ array.getFirst());
        System.out.println("last element: "+ array.getLast());
    }
}
