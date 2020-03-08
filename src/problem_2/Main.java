package problem_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    private static int factor = 2;
    private static int testSize = 270000 * factor;

    public static void main(String[] args) {

        testArrayListRemoval();

        testLinkedListRemoval();

    }

    private static void testLinkedListRemoval() {
        List<Integer> list2 = new LinkedList<>();
        IntStream.range(0, testSize).forEach(i -> list2.add(i, i));

        // timing method based on https://howtodoinjava.com/java/date-time/execution-elapsed-time/
        long startTime = System.nanoTime();

        removeFirstFromList(list2);

        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("remove from LinkedList : " + durationInMillis);
    }

    private static void testArrayListRemoval() {
        // allocate and prefill the arraylist
        // this prevents re-allocating array as the
        // size of array increases when running the test
        List<Integer> list1 = new ArrayList<>(testSize);
        IntStream.range(0, testSize).forEach(i -> list1.add(i, i));

        // timing method based on https://howtodoinjava.com/java/date-time/execution-elapsed-time/
        long startTime = System.nanoTime();

        removeFirstFromList(list1);

        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println("remove from ArrayList : " + durationInMillis);
    }

    private static void removeFirstFromList(List<Integer> list) {
        for (int i = 0; i < testSize; i++) {
            // homework
            list.remove(0);
        }
    }
}
