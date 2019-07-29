package javase.lambdas;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


class FileFilterLambda {
    public static void main(String[] args) {
        JavaFileFilter fileFilterConcreteClass  = new JavaFileFilter();

        FileFilter fileFilterAnonymous = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat()));

       // ThreadLocal.withInitial(() -> new DateTimeFormatter(new SimpleDateFormat("yyyy-mm-dd")));

        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");


        Predicate<Integer> expression = (val) -> val > 0;

        Function<Integer, Integer> function = a -> a;

        CustomComparable<Integer> comparable = (a,b) -> a > b;

       // Comparable comparable1 = (a, b) -> a == b;

        testMethod(expression);
        testMethod(function);
        testMethod(comparable);

        //

        File dir = new File("/Users/akumar24/Documents/java-tuts/src/main/java/javase/generics");
        File[] files = dir.listFiles(fileFilterAnonymous);
        System.out.println(files.length);

    }

    private static void testMethod(CustomComparable<Integer> comparable) {
        comparable.compare(1,2);
    }

    private static void testMethod(Function<Integer, Integer> function) {
        function.apply(3);
    }

    private static void testMethod(Predicate<Integer> expression) {
        expression.test(9);
    }
}


class JavaFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
