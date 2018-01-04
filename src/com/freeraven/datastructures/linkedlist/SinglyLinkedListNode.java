package com.freeraven.datastructures.linkedlist;

/**
 * Created by zvlad on 6/29/16.
 */
public class SinglyLinkedListNode<T> implements LinkedList<T> {
    private T data;
    private int size = 0;
    private SinglyLinkedListNode<T> next;
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;

    @Override
    public void append(T obj) {
        if (size == 0) {
            createFirstNode(obj);
        } else {
            appendToTail(obj);
        }
        size++;
    }

    private void createFirstNode(T obj) {
        head = new SinglyLinkedListNode<T>();
        tail = head;
        head.data = obj;
    }

    private void appendToTail(T obj) {
        tail.next = new SinglyLinkedListNode<T>();
        tail.next.data = obj;
        tail = tail.next;
    }

    @Override
    public T getData(int targetPosition) {
        return getNodeAtPosition(targetPosition).data;
    }

    @Override
    public void deleteNodeAt(int targetPosition) {
        if (targetPosition == 0) {
            deleteFirstNode();
        } else {
            deleteNotFirstNode(targetPosition);
        }
        size--;
    }

    private void deleteFirstNode() {
        head = head.next;
    }

    private void deleteNotFirstNode(int targetPosition) {
        SinglyLinkedListNode<T> nodeBeforeTarget = getNodeAtPosition(targetPosition - 1);
        SinglyLinkedListNode<T> targetNode = nodeBeforeTarget.next;
        if (targetNode != tail) {
            nodeBeforeTarget.next = targetNode.next;
        } else {
            nodeBeforeTarget.next = null;
            tail = nodeBeforeTarget;
        }
    }

    /**
     * There is more efficient implementation for this functionality
     * for the case when it is needed to retrieve several nodes with ascending indexes.
     * @param targetPosition desired index
     * @return node with specified index
     */
    protected SinglyLinkedListNode<T> getNodeAtPosition(int targetPosition) {
        checkPositionIsValid(targetPosition);
        SinglyLinkedListNode<T> targetNode = head;
        for (int i = 0; i < targetPosition; i++) {
            targetNode = targetNode.next;
        }
        return targetNode;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        if (size != 0){
            StringBuilder listItems = printItems();
            result.append(listItems);
        }
        result.append("]");
        return result.toString();
    }

    private StringBuilder printItems() {
        String itemsDelimiter = ", ";
        SinglyLinkedListNode<T> currentNode = head;
        StringBuilder builder = new StringBuilder();
        while (currentNode != null) {
            builder.append(currentNode.data);
            builder.append(itemsDelimiter);
            currentNode = currentNode.next;
        }
        int trailingDelimiterPosition = builder.length() - itemsDelimiter.length();
        builder.delete(trailingDelimiterPosition, trailingDelimiterPosition + itemsDelimiter.length());
        return builder;
    }

    private void checkPositionIsValid(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected SinglyLinkedListNode<T> getNext() {
        return next;
    }

    protected void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }

    protected SinglyLinkedListNode<T> getTail() {
        return tail;
    }
}
