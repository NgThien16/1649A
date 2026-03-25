package week4.L02_Node;

public class Node<E>{
    private E element;
    private Node<E> next;

    public Node(E element){
        this.element = element;
        this.next = null;
    }

    public static void main(String[] args) {
        Node<Integer> head;
        Node<Integer> n1 = new Node<>(10);
        head = n1;
        Node<Integer> n2 = new Node<>(20);
        head.next = n2;
    }
}
