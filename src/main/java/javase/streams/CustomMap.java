package javase.streams;

import java.util.function.Function;

@FunctionalInterface
public interface CustomMap {

    <T, R> R map(Function<? super T,? extends R> function);
}
