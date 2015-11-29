package uk.ac.cam.cpr41.oopsupervisions.supervision3.q2;

import java.util.AbstractList;

public class CollectionArrayList<T> extends AbstractList<T> {

    // Set the default size
    private T[] mArray = (T[]) new Object[10];

    public CollectionArrayList () {}

    public CollectionArrayList (int size) {
        changeSize(size);
    }

    private void changeSize(int size) {
        // Create the new array
        T[] newArray = (T[]) new Object[size];

        // Copy over the old elements
        for (int i = 0; i < mArray.length; i++) {
            newArray[i] = get(i);
        }

        // Assign it and update modCount
        mArray = newArray;
        modCount++;
    }

    private void shift(int index, ShiftDirection dir) {
        // Move all elements in an array from index up or down 1 position
        switch (dir) {
            case SHIFT_DOWN:
                // Shift down by 1
                for (int i = index; i <= size() - 2; i++) {
                    set(i, get(i + 1));
                }

                // Set last value to null
                set(size() - 1, null);
                break;
            case SHIFT_UP:
                // Increase the size if needed
                if (get(size() - 1) != null) {
                    changeSize(size() / 2 + size());
                }

                // Shift up by 1
                for (int i = size() - 2; i >= index; i--) {
                    set(i+1, get(i));
                }

                set(index, null);
                break;
        }
    }

    @Override
    public T get(int index)  {
        return mArray[index];
    }

    @Override
    public int size() {
        return mArray.length;
    }

    @Override
    public T set(int index, T element) {
        // Return the value at index then overwrite it
        T previous = get(index);
        mArray[index] = element;
        return previous;
    }

    @Override
    public void add(int index, T element) {
        // Change the size or shift if needed
        if (index >= size()) {
            changeSize(index + (size() / 2) );
        } else {
            shift(index, ShiftDirection.SHIFT_UP);
        }

        mArray[index] = element;
    }

    @Override
    public T remove(int index) {
        // Remove that element and shift the rest into place
        T removed = get(index);
        shift(index, ShiftDirection.SHIFT_DOWN);
        return removed;
    }

    public static void main(String[] args) {
        // Testing
        CollectionArrayList<Integer> list = new CollectionArrayList<Integer>();

        int[] elements = {1,2,3,4,5,6,7,8,9,10,11,12};
        for (int i = 0; i < elements.length; i++) {
            list.add(i, elements[i]);
        }

        for (int i = 0; i < 10; i++) {
            list.add(3, 100);
        }

        list.remove(10);

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println(list);
    }
}
