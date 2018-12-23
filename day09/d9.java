import java.util.Arrays;

public class d9 {
    public static void main(String[] args) {
        System.out.println("Challenge 1: " + winningmarble(416, 7161700));
        System.out.println("Challenge 2: " + winningmarble(416, 71617));
    }

    public static long winningmarble(int totalPlayers, int finalMarble) {
        CDLList<Long> circle = new CDLList<Long>();
        long[] scores = new long[totalPlayers];
        int curPlayer = 0;
        circle.addFirst(new Long(0));
        for (long i = 1; i != finalMarble + 1; i++) {
            if (i % 23 == 0) {
                scores[curPlayer] += i;
                circle.rotateBackward();
                circle.rotateBackward();
                circle.rotateBackward();
                circle.rotateBackward();
                circle.rotateBackward();
                circle.rotateBackward();
                scores[curPlayer] += circle.removeLast();
            } else {
                circle.rotateForward();
                circle.rotateForward();
                circle.addFirst(i);
            }
            if (curPlayer == totalPlayers - 1) {
                curPlayer = 0;
            } else {
                curPlayer++;
            }
        }

        Arrays.sort(scores);
        return (scores[totalPlayers - 1]);
    }
}

class CDLList<T> {
    class Node {
        // Each Node object has these three fields
        private T element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(T e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets T e as input and sets e as the element of the Node
        public void setElement(T e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public T getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in CDLList has one field head, which points to the starting Node of CDLList.
    public Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public CDLList() {
        head = null;
    }

    /**
     * @return The element in the first Node of this CDLL. If the list is empty, this method returns null.
     */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(T e) {
        Node n = new Node(e, null, null);
        if (head == null) {
            n.setNext(n);
            n.setPrevious(n);
            head = n;
        } else {
            Node tail = head.getPrevious();
            tail.setNext(n);
            head.setPrevious(n);
            n.setNext(head);
            n.setPrevious(tail);
            this.rotateBackward();
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node. If the list is empty, this method returns null.
     */
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T t = head.getElement();
        if (head.getNext() == head) {
            head = null;
        } else {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
            head = head.getNext();
        }
        return t;
    }

    /**
     * @return The element in the last Node of the CDLL. If the list is empty, this method returns null.
     */
    public T getLast() {
        if (head == null) {
            return null;
        }
        return head.getPrevious().getElement();
    }

    /**
     * Adds element e in a new Node to the end of the list.
     *
     * @param e The element to add.
     */
    public void addLast(T e) {
        Node n = new Node(e, null, null);
        if (head == null) {
            n.setNext(n);
            n.setPrevious(n);
            head = n;
        } else {
            Node tail = head.getPrevious();
            tail.setNext(n);
            head.setPrevious(n);
            n.setNext(head);
            n.setPrevious(tail);
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the last Node. If the list is empty, this method returns null.
     */
    public T removeLast() {
        if (head == null) {
            return null;
        }
        this.rotateBackward();
        T t = removeFirst();
        return t;
    }

    /**
     * Moves the head reference to the next element.
     */
    public void rotateForward() {
        if (head == null) {
            return;
        }
        head = head.getNext();
    }

    /**
     * Moves the head reference to the previous element.
     */
    public void rotateBackward() {
        if (head == null) {
            return;
        }
        head = head.getPrevious();
    }
}
