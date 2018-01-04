package com.freeraven.datastructures.linkedlist;

import com.freeraven.datastructures.linkedlist.SinglyLinkedListNode;

/**
 * Created by zvlad on 8/7/16.
 */
public class LoopedLinkedListNode<T> extends SinglyLinkedListNode<T> {

    /**
     * This method call may lead to breaking list consistency: tail elements may become unreachable.
     * @param sourceNodeIndex
     * @param targetNodeIndex
     */
    public void setLoop(int sourceNodeIndex, int targetNodeIndex) {
        if (!(sourceNodeIndex > targetNodeIndex)) {
            throw new IllegalArgumentException("\n\tLoop link should be created FROM element which is more close to tail of the list (has bigger index value) TO element which is more close to the beginning of the list (has smaller index value)."
                                               + "\n\n\tBut specified indexes were:"
                                               + "\n\tfrom: " + sourceNodeIndex
                                               + "\n\tto: " + targetNodeIndex);
        }
        SinglyLinkedListNode<T> sourceNode = getNodeAtPosition(sourceNodeIndex);
        SinglyLinkedListNode<T> targetNode = getNodeAtPosition(targetNodeIndex);
        sourceNode.setNext(targetNode);
    }

    public boolean hasLoop(LoopDetector detector){
        return detector.hasLoop();
    }

    private interface LoopDetector {
        boolean hasLoop();
    }

    public class TraversingLoopDetector implements LoopDetector {
        @Override
        public boolean hasLoop() {
            SinglyLinkedListNode<T> tail = getTail();
            if (getNodeAtPosition(getSize() - 1) == tail
                && tail.getNext() == null){
                return false;
            }
            return true;
        }
    }

    public class RunnersLoopDetector implements LoopDetector {
        @Override
        public boolean hasLoop() {
            SinglyLinkedListNode slowRunnerNode = getNodeAtPosition(0);
            SinglyLinkedListNode fastRunnerNode = getNodeAtPosition(0);
            while (fastRunnerNode.getNext() != null
                   && fastRunnerNode.getNext().getNext() != null){
                slowRunnerNode = slowRunnerNode.getNext();
                fastRunnerNode = fastRunnerNode.getNext().getNext();
                if (fastRunnerNode == slowRunnerNode){
                    return true;
                }
            }
            return false;
        }
    }
}
