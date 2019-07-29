package javase.generics;

import java.util.ArrayList;
import java.util.List;

public class TheCastProblem {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello, world");
        String message = (String) list.get(0);
        System.out.println(message);
        // hello, world

        list.add(123);
        String count = (String) list.get(1);
        System.out.println(count);
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        // not type safe
        // can contains any object so cast is necessary

    }
}


// generics stops runtime error at compile time
