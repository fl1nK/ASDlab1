package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("Single list: \n");
        test(new SingleList());
        System.out.println("Double list: \n");
        test(new DoubleList());
        System.out.println("ArrayList: \n");
        test(new ArrayList());
    }

    public static void test(IList listInterface) {
        IList list = listInterface;

        for (int i = 1; i < 1001; i++) {
            list.addFirst(i);
        }
        long allTime = System.nanoTime();
        long addFirstTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.addFirst(i);
        }
        addFirstTime = System.nanoTime() - addFirstTime;

        long addLastTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.addLast(i);
        }
        addLastTime = System.nanoTime() - addLastTime;

        long insertTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.addIndex(i, 10);
        }
        insertTime = System.nanoTime() - insertTime;

        long deleteFirstTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.deleteFirst();
        }
        deleteFirstTime = System.nanoTime() - deleteFirstTime;

        long deleteTime = System.nanoTime();
        for (int i = 100; i < 2001; i++) {
            list.deleteIndex(i);
        }
        deleteTime = System.nanoTime() - deleteTime;

        long deleteLastTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.deleteLast();
        }
        deleteLastTime = System.nanoTime() - deleteLastTime;

        long replaceFirstTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.replaceFirst(i + 3);
        }
        replaceFirstTime = System.nanoTime() - replaceFirstTime;

        long replaceTime = System.nanoTime();
        for (int i = 1000; i < 2001; i++) {
            list.replaceIndex(1, i);
        }
        replaceTime = System.nanoTime() - replaceTime;

        long replaceLastTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.replaceLast(i + 3);
        }
        replaceLastTime = System.nanoTime() - replaceLastTime;

        long indexAtTime = System.nanoTime();
        for (int i = 1; i < 1001; i++) {
            list.indexAt(100);
        }

        indexAtTime = System.nanoTime() - indexAtTime;

        long sumTime = System.nanoTime();
        list.sum();
        sumTime = System.nanoTime() - sumTime;
        allTime = System.nanoTime() - allTime;

        System.out.println("Add first time: " + addFirstTime + " ns");
        System.out.println("Add inside time: " + insertTime + " ns");
        System.out.println("Add last time: " + addLastTime + " ns");
        System.out.println();
        System.out.println("Delete first time: " + deleteFirstTime + " ns");
        System.out.println("Delete inside time: " + deleteTime + " ns");
        System.out.println("Delete last time: " + deleteLastTime + " ns");
        System.out.println();
        System.out.println("Replace first time: " + replaceFirstTime + " ns");
        System.out.println("Replace inside time: " + replaceTime + " ns");
        System.out.println("Replace last time: " + replaceLastTime + " ns");
        System.out.println();
        System.out.println("Index at time: " + indexAtTime + " ns");
        System.out.println("Sum time: " + sumTime + " ns");
        System.out.println();
        System.out.println("All time: " +allTime + " ns");
        System.out.println();
    }
}