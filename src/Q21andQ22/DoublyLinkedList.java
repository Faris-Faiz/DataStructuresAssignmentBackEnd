package Q21andQ22;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {


    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
        this.head = null;
        this.tail = null;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        //create object tmp and set pointer of the new node
        Node<E> tmp = new Node(element, head, null);
        //set head.prev of current head to be linked to the new node
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp; //now tmp become head
        //if no tail, then tmp set to be a tail
        if (tail == null) {
            tail = tmp;
        }
        size++;//increase number of node
    }


    public void addLast(E element) {
        //create object tmp and set pointer of the previous node
        Node<E> tmp = new Node(element, null, tail);
        //set tail.next point to object tmp
        if (tail != null) {
            tail.next = tmp;
        }
        //now tmp become tail
        tail = tmp;
        //if no head, then tmp set to be a head
        if (head == null) {
            head = tmp;
        }
        size++;//increase number of node
    }


    public void iterateForward() {

        System.out.println("iterating forward..");
        Node<E> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.element);
            System.out.print(" ");
            tmp = tmp.next;
        }
    }


    public void iterateBackward() {

        System.out.println("iterating backward..");
        Node<E> tmp = tail;
        while (tmp != null) {
            System.out.print(tmp.element);
            System.out.print(" ");
            tmp = tmp.prev;
        }
    }


    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        //copy head to node tmp
        Node<E> tmp = head;
        //head.next become a head
        head = head.next;
        //set pointer of prev of new head to be null
        if (head != null)
            head.prev = null;
        //reduce number of node
        size--;
        return tmp.element;
    }


    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        //copy tail to node tmp
        Node<E> tmp = tail;
        //tail.prev become a tail
        tail = tail.prev;
        //set pointer of next of new tail to be null
        tail.next = null;
        //reduce number of node
        size--;
        System.out.println("removed");
        return tmp.element;
    }
    //add element in list based on index
    public void add(int index, E element) {
        //if index 0, addFirst method is called
        if (index == 0) {
            addFirst(element);
        } //if index is >= size, addLast method is called
        else if (index >= size) {
            addLast(element);
        } else {
            
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                //assigns the next to current
                current = current.next;
            }
            //creates temp node and point it to the next node
            Node<E> temp = current.next;
            //assigns the new element as next
            current.next = new Node<E>(element);
            (current.next).next = temp;
            //increases size
            size++;
            System.out.println("added");
        }
    }
    //remove the element based on index
    public E remove(int index) {
        E element = null;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            element = removeFirst();
        else if (index == size - 1)
            element = removeLast();
        else {
            //asigns head as temporary node
            Node<E> temp = head;
            //iterates the list until index
            for (int i = 0; i < index; i++) {
                //assigns next temporary as temporary, the last temp will be at the index
                temp = temp.next;
            }
            //the temp element assigned as element
            element = temp.element;
            //to delete the temp
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            //decreases size
            size--;
        }

        return element;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }
    //to show element based on index
    public E show(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //assign head as temp
        Node<E> temp = head;
        //iterates until element of index found as assigned as temp
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //to return element
        E element = temp.element;
        return element;
    }
    //to check if list contains element
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {

                return true;
            }
            current = current.next;
        }

        return false;
    }
}
