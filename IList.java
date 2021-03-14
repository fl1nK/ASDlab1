package com.company;

public interface IList {
    void addFirst(int data);
    void addIndex(int data, int index);
    void addLast(int data);
    void deleteFirst();
    void deleteIndex(int index);
    void deleteLast();
    void replaceFirst(int newValue);
    void replaceIndex(int newValue, int index);
    void replaceLast(int newValue);
    int indexAt(int index);
    int sum();
    void print();
}