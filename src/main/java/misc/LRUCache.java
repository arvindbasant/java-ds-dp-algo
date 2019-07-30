package misc;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    static Deque<Integer> dq;
    static HashSet<Integer> hs;

    static int cacheSize;

    public LRUCache(int size) {
        dq = new LinkedList<>();
        hs = new HashSet<>();
        cacheSize = size;
    }

    public void refer(int x) {
        if (!hs.contains(x)) {
            if (dq.size() == cacheSize) {
                int last = dq.removeLast();
                hs.remove(last);
            }
        } else {
            /* The found page may not be always the last element, even if it's an
               intermediate element that needs to be removed and added to the start
               of the Queue */
            int index = 0, i = 0;
            Iterator<Integer> iterator = dq.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }
        dq.push(x);
        hs.add(x);
    }

    // display contents of cache
    public void display() {
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
