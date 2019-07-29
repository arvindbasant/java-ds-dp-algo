package javase.generics;

public class TypeUnsafeExample {

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        buffer.offer(1); // Integer cannot be cast to String

        String value = concatenate(buffer);
        System.out.println(value);

    }

    private static String concatenate(CircularBuffer buffer){
        StringBuilder builder = new StringBuilder();
        String value;
        while ((value = (String) buffer.poll()) != null){
            builder.append(value);
        }
        return builder.toString();
    }
}
