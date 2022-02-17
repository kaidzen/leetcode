package org.kaidzen.study.dsandalgo.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<E> implements Iterable<E> {

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

    protected Node<E> getNewNode() {
        Node<E> node = new Node<>();
        lastModifiedNode = new Node[]{node};
        return node;
    }

    public Node<E> appendLast(E value) {
        Node<E> node = getNewNode();
        node.value = value;

        if (last != null) {
            last.next = node;
        }
        last = node;

        if (first == null) {
            first = node;
        }
        length++;
        return node;
    }

    public Node<E> appendFirst(E value) {
        Node<E> node = getNewNode();
        node.value = value;

        node.next = first;
        first = node;

        if (length == 0) {
            last = node;
        }
        length++;

        return node;
    }

    public Node<E> insert(int index, E value) {
        Node<E> node = getNewNode();

        if (index < 0 || index > length) {
            throw new IllegalArgumentException("Invalid index for insertion");
        } else if (index == length) {
            return appendLast(value);
        } else if (index == 0) {
            return appendFirst(value);
        } else {
            Node<E> former = first;
            int idx = index;
            while (idx > 1) {
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

    public E findAtIndex(int index) {
        if (index < 0 || index > length) {
            throw new IllegalArgumentException("Invalid index for search");
        } else if (index == length) {
            return this.last.value;
        } else if (index == 0) {
            return this.first.value;
        } else {
            Node<E> result = this.first;
            while (index >= 0) {
                if (result == null) {
                    throw new NoSuchElementException("Nothing to return - null element is stored");
                } else if (index == 0) {
                    return result.value;
                } else {
                    index--;
                    result = result.next;
                }
            }
            return null;
        }
    }

    public Node<E> removeFirst() {
        if (length == 0) {
            throw new NoSuchElementException("Nothing to be removed");
        }
        Node<E> originalFirst = first;
        first = first.next;
        length--;
        if (length == 0) {
            last = null;
        }
        return originalFirst;
    }

    public Node<E> removeAtIndex(int index) {
        if (index > length || index < 0) {
            throw new NoSuchElementException("Unable to remove");
        }
        if (index == 0) {
            return removeFirst();
        }
        Node<E> justBeforeIt = first;
        while (--index > 0) {
            justBeforeIt = justBeforeIt.next;
        }
        Node<E> nodeRemoved = justBeforeIt.next;
        if (justBeforeIt.next == last) {
            last = justBeforeIt.next.next;
        } else if (justBeforeIt.next == null) {
            return removeLast();
        }
        justBeforeIt.next = justBeforeIt.next.next;
        length--;

        return nodeRemoved;
    }

    public Node<E> removeLast() {
        if (length == 0) {
            throw new NoSuchElementException("Nothing to be removed");
        } else if (length == 1) {
            Node<E> removed = last;
            first = null;
            last = null;
            length = 0;
            return removed;
        }
        Node<E> original = first;
        int indx = length - 2;
        while (indx > 0) {
            original = original.next;
            --indx;
        }
        Node<E> removed = original.next;
        original.next = null;
        return removed;
    }

    public int size() {
        return length;
    }

    protected static class Node<E> {
        protected E value;
        protected Node<E> next;
    }

    protected class ListIterator implements Iterator<E> {

        protected Node<E> nextNode = first;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {

            }
            return null;
        }
    }
}
