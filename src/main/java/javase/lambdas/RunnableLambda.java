package javase.lambdas;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {
        final String testVal = "test";
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++){
                    System.out.println("Hello from thread:"+ Thread.currentThread().getName());
                }
            }
        };

        final String value = "test";
        BiFunction<Long,Long, Long> func =  (x, y) -> x + 1;

        Runnable runnableLambda = () -> {
            for (int i = 0; i < 3; i++){
                System.out.println("Hello from thread:"+ Thread.currentThread().getName());
                System.out.println(value);
            }
        };

        String[] artistArray = {"London", "USA"};


        List<String> allArtists = Arrays.asList(artistArray);

        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist);
                    return "London".equalsIgnoreCase(artist);
                }).count();
        allArtists.stream().collect(Collectors.toList());

        testMutation(value);

        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();

        Runnable helloWorld = () -> System.out.println("hello world");
        JButton button = new JButton();
        button.addActionListener(event ->
                System.out.println(event.getActionCommand()));
    }

    private static String testMutation(String value) {
        value = value.concat("test");
        return value;
    }
}
