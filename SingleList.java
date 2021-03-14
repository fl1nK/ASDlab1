package com.company;

public class SingleList implements IList {
    private ListElement head;
    private ListElement tail;

    @Override
    public void addIndex(int data, int position){
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

        node.next = current;
        previous.next = node;
    }

    @Override
    public void addFirst(int data)           //добавить спереди
    {
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;              //инициализируем данные.
        // указатель на следующий элемент автоматически инициализируется как null
        if(head == null)            //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        }
        else {
            a.next = head;          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }

    @Override
    public void addLast(int data) {          //добавление в конец списка
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;
        if (tail == null)           //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            tail.next = a;          //иначе "старый" последний элемент теперь ссылается на новый
            tail = a;               //а в указатель на последний элемент записываем адрес нового элемента
        }
    }

    @Override
    public void print()                //печать списка
    {
        ListElement t = head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
    }

    @Override
    public void deleteFirst()
    {
        head = head.next;
    }

    @Override
    public void deleteLast()
    {
        ListElement tmp = this.head;
        ListElement prev = null;
        while (tmp.next != null)
        {
            prev = tmp;
            tmp = tmp.next;
        }
        prev.next = null;
    }

    @Override
    public void deleteIndex(int data)          //удаление элемента
    {
        if(head == null)        //если список пуст -
            return;             //ничего не делаем

        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }

        if (head.data == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }

        ListElement t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.data == data) {  //проверяем следующий элемент
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }

    @Override
    public void replaceFirst(int obj)
    {
        head.data = obj;
    }

    @Override
    public void replaceLast(int obj)
    {
        ListElement a = new ListElement();
        a.data = obj;
        tail.data = a.data;
    }

    @Override
    public void replaceIndex(int position, int data){
        ListElement a = new ListElement();
        a.data = data;
        a.next = null;

        if (this.head == null) {
            if (position != 0) {
                return;
            } else {
                this.head = a;
            }
        }

        if (head != null && position == 0) {
            a.next = this.head;
            this.head = a;
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

        current.data = a.data;
        previous.next.data = current.data;
    }

    @Override
    public int sum()
    {
        int result = this.head.data;
        ListElement t = this.head;
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
                break;
            }
            index++;
            current = current.next;
        }

        return index;
    }
}
