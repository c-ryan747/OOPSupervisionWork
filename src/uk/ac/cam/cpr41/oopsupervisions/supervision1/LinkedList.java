package uk.ac.cam.cpr41.oopsupervisions.supervision1;

import java.util.List;
import java.util.ArrayList;

public class LinkedList {
    private LLElement head;

    public LinkedList (LLElement head) {
        this.head = head;
    }

    private int computeLength() {
        if (this.listContainsACycle()) {
            // What to do here?
            return -1;
        } else {
            // Loop through list counting elements
            int length = 1;
            LLElement current = this.head;

            while (current.getNext() != null) {
                length++;
                current = current.getNext();
            }
            return length;
        }
    }

    private boolean isTheIndexInvalid(int index) {
        // Error in index check
        return (index < 0 && index >= this.getLength());
    }

    public int getLength() {
        return computeLength();
    }

    public LLElement getHead() {
        return head;
    }

    public void setHead(LLElement head) {
        this.head = head;
    }

    public void addValue(LLElement newElement, int index) throws LLIndexOutOfBounds {
        // Error in index check
        if (this.isTheIndexInvalid(index) && index != this.getLength()) {
            throw new LLIndexOutOfBounds(index, this.getLength());
        }

        LLElement elementBefore = null;
        LLElement elementAfter = this.head;

        // Get to the insertion position
        while (index > 0) {
            elementBefore = elementAfter;
            elementAfter = elementAfter.getNext();
            index--;
        }

        // Update the list
        newElement.setNext(elementAfter);
        if (elementBefore == null) {
            this.head = newElement;
        } else {
            elementBefore.setNext(newElement);
        }
    }

    public void removeValue(int index) throws LLIndexOutOfBounds {
        // Error in index check
        if (this.isTheIndexInvalid(index)) {
            throw new LLIndexOutOfBounds(index, this.getLength());
        }

        LLElement elementBefore = null;
        LLElement toRemove      = head;

        // Get to the element to delete
        while (index > 0) {
            elementBefore = toRemove;
            toRemove = toRemove.getNext();
            index--;
        }

        // Delete it
        if (elementBefore == null) {
            this.head = toRemove.getNext();
        } else {
            elementBefore.setNext(toRemove.getNext());
        }
    }

    public LLElement getElementAtIndex(int index) throws LLIndexOutOfBounds {
        // Error in index check
        if (this.isTheIndexInvalid(index)) {
            throw new LLIndexOutOfBounds(index, this.getLength());
        }

        // Get the element at that index
        LLElement element = head;
        while (index > 0) {
            element = element.getNext();
            index--;
        }
        return element;
    }

    @Override
    public boolean equals(Object obj) {
        // Check ist the right kind of class, then cast obj to LinkedList
        if (this.getClass() == obj.getClass()) {
            LinkedList ll = (LinkedList) obj;

            // Check that all the elements values are the same
            int length = this.getLength();
            if (length == ll.getLength()) {
                for (int i = 0; i < length; i++) {
                    try {
                        if (this.getElementAtIndex(i).getValue() != ll.getElementAtIndex(i).getValue()) {
                            return false;
                        }
                    } catch (LLIndexOutOfBounds e) {
                        // Should never happen
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean listContainsACycle () {
        List<LLElement> elements = new ArrayList<>();

        // Build up an array of elements, if we come across three we've seen before then a cycle has been found
        LLElement element = this.head;
        while (element != null) {
            if (elements.contains(element)) {
                return true;
            } else {
                elements.add(element);
            }
            element = element.getNext();
        }
        return false;
    }
}
