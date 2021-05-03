package org.kaidzen.study.dsandalgo.list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<E> implements Iterable<E>{

    int length = 0;
    Node<E>[] lastModifiedNode;
    Node<E> first;
    Node<E> last;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    protected Node<E> getNewNode(){
        Node<E> node = new Node<>();
        lastModifiedNode = new Node[]{node};
        return node;
    }

    public Node<E> appendLast(E value){
        Node<E> node = getNewNode();
        node.value = value;

        if (last != null){
            last.next = node;
        }
        last = node;

        if (first == null){
            first = node;
        }
        length++;
        return node;
    }

    public Node<E> appendFirst(E value){
        Node<E> node = getNewNode();
        node.value = value;

        node.next = first;
        first = node;

        if (length == 0){
            last = node;
        }
        length++;

        return node;
    }

    public Node<E> insert(int index, E value) {
        Node<E> node = getNewNode();

        if (index < 0 || index > length){
            throw new IllegalArgumentException("Invalid index for insertion");
        } else if (index == length){
            return appendLast(value);
        } else if (index == 0){
            return appendFirst(value);
        } else {
            Node<E> former = first;
            int idx = index;
            while (idx > 1){
                idx--;
                former = former.next;
            }
            node.value = value;
            node.next = former.next;
            former.next = node;

            length++;

            return node;
        }
    }

    protected static class Node<E>{
        protected E value;
        protected Node<E> next;
    }
}
