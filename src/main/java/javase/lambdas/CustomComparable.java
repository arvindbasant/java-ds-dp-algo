package javase.lambdas;

@FunctionalInterface
public interface CustomComparable<T> {

    boolean compare(T a, T b);
}
