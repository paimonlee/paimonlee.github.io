package com.code.java.practise.utils;

/**
 * @author: 2253339528@qq.com
 * @since: 2024年04月25日 21:49:45
 * @apiNote:
 */
public class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;

    public static <T> LinkedListNode<T> reverse(LinkedListNode<T> header) {
        LinkedListNode<T> dummyHeader = new LinkedListNode<>();

        while (header != null) {
            LinkedListNode<T> tmp = header.next;
            header.next = dummyHeader.next;
            dummyHeader.next = header;
            header = tmp;
        }
        return dummyHeader.next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setPrev(LinkedListNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public LinkedListNode<T> getPrev() {
        return prev;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }
}
