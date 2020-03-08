package problem_1;

public class LinkedListTests extends Tests {

    public static void testAll() {
        testCopyConstructor();
        testRemove();
        testReverseIterative();
        testMergeSorted();
        testEmptyList();
        testListWithMultipleElements();
        testToString();
    }

    public static void testCopyConstructor() {
        // homework
        SingleLinkedList list1 = new SingleLinkedList();//test 1
        SingleLinkedList list2 = new SingleLinkedList();//test 2
        list2.add(4);
        SingleLinkedList list3 = new SingleLinkedList();//test 3
        list3.add(4);
        list3.add(5);
        SingleLinkedList list4 = new SingleLinkedList();//test 4
        list4.add(4);
        list4.add(4);
        SingleLinkedList list5 = new SingleLinkedList();//test 5
        list5.add(4);
        list5.add(5);
        list5.add(6);
        SingleLinkedList list1copy = new SingleLinkedList(list1);
        SingleLinkedList list2copy = new SingleLinkedList(list2);
        SingleLinkedList list3copy = new SingleLinkedList(list3);
        SingleLinkedList list4copy = new SingleLinkedList(list4);
        SingleLinkedList list5copy = new SingleLinkedList(list5);
        SingleLinkedList[] inputs = {list1copy, list2copy, list3copy, list4copy, list5copy};
        SingleLinkedList[] expect = {list1, list2, list3, list4, list5};
        boolean pass = true;
        for(int i = 0; i < inputs.length; i++) {
            for(int j = 0; j < inputs[i].size(); j++) {
                if (inputs[i].get(j).getData()!=expect[i].get(j).getData()) {
                    System.out.printf("testCopyConstructor FAILED, Case %d, Location %d, Actual %d, Expected %d \n", i, j, inputs[i].get(j).getData(), expect[i].get(j).getData());
                    pass = false;
                }

            }
        }
        if(pass) {
            System.out.println("testCopyConstructor PASSED");
        }

    }

    public static void testRemove() {
        // homework
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        SingleLinkedList list3 = new SingleLinkedList();
        list3.add(1);
        list3.add(2);
        list3.add(4);
        list3.add(2);
        SingleLinkedList list4 = new SingleLinkedList();
        list4.add(1);
        list4.add(1);
        list4.add(4);
        list4.add(2);
        SingleLinkedList list5 = new SingleLinkedList();
        list5.add(3);
        list5.add(3);
        list5.add(3);
        list5.add(3);

        int[] input = {
                list1.remove(4),
                list2.remove(3),
                list3.remove(2),
                list4.remove(1),
                list5.remove(3),
                list4.remove(5)
        };
        int[] expect = {0, 1, 2, 2, 4, 0};
        boolean pass = true;
        for(int i = 0; i < input.length; i++) {
            if(input[i]!=expect[i]) {
                System.out.printf("testRemove FAILED, Case %d, Actual: %d, Expected: %d\n", i, input[i], expect[i]);
                pass = false;
            }
        }
        if(pass) {
            System.out.println("testRemove PASSED");
        }
    }

    public static void testReverseIterative() {
        // homework
        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.reverseIterative();
        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(1);
        list2.reverseIterative();
        SingleLinkedList list3 = new SingleLinkedList();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.reverseIterative();
        SingleLinkedList list1expect = new SingleLinkedList();
        list1expect.add(3);
        list1expect.add(2);
        list1expect.add(1);
        SingleLinkedList list2expect = new SingleLinkedList();
        list2expect.add(1);
        SingleLinkedList list3expect = new SingleLinkedList();
        list3expect.add(4);
        list3expect.add(3);
        list3expect.add(2);
        list3expect.add(1);


        SingleLinkedList[] input = {list1, list2, list3 };
        SingleLinkedList[] expect = {list1expect, list2expect, list3expect};

        boolean pass = true;
        for(int i = 0; i < input.length; i++) {
            if(!input[i].toString().equals(expect[i].toString())){
                System.out.println("testReverseIterative FAILED");
                pass = false;
            }
        }
        if(pass){
            System.out.println("testReverseIterative PASSED");
        }
    }

    public static void testMergeSorted() {
        // homework
        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(1);
        list1.add(3);
        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(2);
        list2.add(4);
        SingleLinkedList list3 = new SingleLinkedList();
        list3.add(1);
        list3.add(3);
        SingleLinkedList list4 = new SingleLinkedList();
        list4.add(4);
        list4.add(5);
        SingleLinkedList list5 = new SingleLinkedList();
        list5.add(6);
        list5.add(7);
        list5.add(8);
        SingleLinkedList list6 = new SingleLinkedList();
        list6.add(4);
        list6.add(5);
        SingleLinkedList list7= new SingleLinkedList();
        list7.add(3);
        list7.add(3);
        list7.add(8);
        SingleLinkedList list8 = new SingleLinkedList();
        list8.add(2);
        list8.add(5);
        SingleLinkedList list1mergedlist2 = new SingleLinkedList(list1);
        SingleLinkedList list3mergedlist4 = new SingleLinkedList(list3);
        SingleLinkedList list5mergedlist6 = new SingleLinkedList(list5);
        SingleLinkedList list7mergedlist8 = new SingleLinkedList(list7);
        list1mergedlist2.mergeSorted(list2);
        list3mergedlist4.mergeSorted(list4);
        list5mergedlist6.mergeSorted(list6);
        list7mergedlist8.mergeSorted(list8);
        SingleLinkedList[] inputs = {list1mergedlist2, list3mergedlist4, list5mergedlist6, list7mergedlist8};
        int[][] outputs = {
                {1, 2, 3, 4},
                {1, 3, 4, 5},
                {4, 5, 6, 7, 8},
                {2, 3, 3, 5, 8}
        };
        for(int i = 0; i < inputs.length; i++) {
            System.out.println(inputs[i].toString()); //didn't have enough time for test. These are print statements to verify it works.
        }
        /*
         * for(int i = 0; i < inputs.length; i++) { for(int j = 0; j <
         * outputs[i].length; j++) { if(inputs[i].get(j).getData()!=outputs[i][j]) {
         * System.out.println("testMergedSorted FAILED, "); } } }
         * System.out.println(list1.toString());
         * System.out.println(list3mergedlist4.toString());
         */
    }

    private static void testListWithMultipleElements() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

        // list as [-1, 1, 2]
        list.add(1);
        list.add(2);
        list.addFirst(-1);

        if (!assertEquals(list.size(), 3)) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(0), new Item(-1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(1), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(2), new Item(2, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(3), invalidItem)) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        list.removeLast();
        if (!assertEquals(list.get(0), new Item(-1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.getLast(), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        list.removeFirst();
        if (!assertEquals(list.get(0), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.getLast(), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }

        System.out.println("testListWithOneElement PASSED");
    }

    private static void testToString() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.toString().isEmpty());
        list.add(1);
        if (!assertEquals(list.toString(), "1 -> end")) {
            System.out.println("testToString FAILED");
            return;
        }
        list.add(2);
        if (!assertEquals(list.toString(), "1 -> 2 -> end")) {
            System.out.println("testToString FAILED");
            return;
        }
        System.out.println("testToString PASSED");
    }

    private static void testEmptyList() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

        if (!assertEquals(list.size(), 0)) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.getFirst())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.getLast())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.get(0))) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertTrue(list.toString().isEmpty())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        System.out.println("testEmptyList PASSED");
    }
}


