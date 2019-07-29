package dataStructures;

public class LinkedList {

    class Link {
        private Link next;
        private int data;

        Link(int data) {
            this.data = data;
            next = null;
        }
    }

    private Link first;

    public LinkedList() {
        first = null;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int data) {
        Link current = first;
        while (current.data != data) {
            current = current.next;
            if (current == null)
                return null;
        }
        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link delete(int data) {
        Link current = first;
        Link prev = first;

        while (current.data != data) {
            prev = current;
            current = current.next;
            if (current == null)
                return null;
        }

        if (current == first)
            first = first.next;
        else
            prev.next = current.next;
        return current;
    }

    public void display() {
        Link current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int length(Link link) {
        Link current = link;
        if (current == null)
            return 0;
        return 1 + length(current.next);
    }

    public Link getNthNode(Link first, int n) {
        if (n == 1)
            return first;
        return getNthNode(first.next, n - 1);
    }

    public Link nthNodeFromEnd(int n) {
        int len = length(first);
        if (n > len)
            return null;

        Link current = first;

        for (int i = 1; i < len - n + 1; i++)
            current = current.next;

        return current;
    }

    public void reverse() {
        Link current = first;
        Link previous = null;
        Link next;
        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
        first = previous;
    }

    public void swap(int x, int y) {
        if (x == y)
            return;
        Link prevX = null;
        Link currX = first;

        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Link prevY = null;
        Link currY = first;

        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null)
            return;

        if (prevX != null)
            prevX.next = currY;
        else
            first = currY;

        if (prevY != null)
            prevX.next = currX;
        else
            first = currX;

        // swap next pointers
        Link temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }

    public void pairWiseSwap() {

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.insertFirst(i + 1);
        }

        linkedList.display();

        System.out.println(linkedList.find(3).data);

        System.out.println(linkedList.delete(3).data);

        linkedList.display();

        System.out.println(linkedList.length(linkedList.first));

        System.out.println("nthNodeFromEnd" + linkedList.nthNodeFromEnd(4).data);

        linkedList.reverse();
        linkedList.display();

        System.out.println(linkedList.getNthNode(linkedList.first, 2).data);

        linkedList.swap(2, 5);
        linkedList.display();
        linkedList.swap(2, 6);
        linkedList.display();


    }
}
