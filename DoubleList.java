package com.company;

public class DoubleList implements IList {
    private ListElement head;
    private ListElement tail;


    public DoubleList() {
        head = null;
        tail = null;
    }

    @Override
    public void print() {
        ListElement temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    @Override
    public void addFirst(int data) {
        ListElement temp = new ListElement();
        temp.data = data;
        if (head == null) {
            tail = temp;
        } else head.prev = temp;

        temp.next = head;
        head = temp;
    }

    @Override
    public void addLast(int data) {
        ListElement temp = new ListElement();
        temp.data = data;
        if (head == null) {
            head = temp;
        } else
            tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }

    @Override
    public void addIndex(int data, int index) {
        ListElement current = head;
        int counter = 0;
        while (current != null && counter != index) {
            current = current.next;
            counter++;
        }

        ListElement temp = new ListElement();
        temp.data = data;
        current.prev.next = temp;
        temp.prev = current.prev;
        current.prev = temp;
        temp.next = current;
    }
    @Override
    public void deleteFirst() {
        if (head.next == null)
            tail = null;
        else head.next.prev = null;
        head = head.next;
    }
    @Override
    public void deleteLast() {
        if (head.next == null)
            head = null;
        else tail.prev.next = null;
        tail = tail.prev;
    }

    @Override
    public void deleteIndex(int index) {
        ListElement current = head;
        while (current.data != index) {
            current = current.next;

            if (current == null)
                return;
        }

        if (current == head)
            deleteFirst();
        else current.prev.next = current.next;
        if (current == tail)
            deleteLast();
        else current.next.prev = current.prev;
    }
    @Override
    public void replaceFirst(int data) {
        head.data = data;
    }
    @Override
    public void replaceLast(int obj) {
        ListElement a = new ListElement();
        a.data = obj;
        tail.data = a.data;
        tail.prev.next = a;
    }
    @Override
    public void replaceIndex(int position, int data) {
        ListElement node = new ListElement();
        node.data = data;
        node.next = null;

        if (this.head == null) {
            if (position != 0) {
                return;
            } else {
                this.head = node;
            }
        }

        if (head != null && position == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }

        ListElement current = this.head;
        ListElement previous = null;

        int i = 0;

        while (i < position) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }

            i++;
        }

        current.data = node.data;
        previous.next.data = current.data;
        current.prev = previous;
    }
    @Override
    public int sum()
    {
        int result = head.data;
        ListElement t = head;
        while (t != null)
        {
            if (t.next == null)
                break;
            else
                result = result + t.next.data;
            t = t.next;
        }
        return result;
    }
    @Override
    public int indexAt(int obj) {
        int index = 0;
        ListElement current = this.head;
        while (current != null) {
            if (current.data == obj) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }
}
