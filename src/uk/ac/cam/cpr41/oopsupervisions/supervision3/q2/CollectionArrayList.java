package uk.ac.cam.cpr41.oopsupervisions.supervision3.q2;

import java.util.AbstractList;

public class CollectionArrayList<T> extends AbstractList<T> {

    private T[] mArray = (T[]) new Object[10];

    public CollectionArrayList () {}

    public CollectionArrayList (int size) {
        changeSize(size);
    }

    private void changeSize(int size) {
        T[] newArray = (T[]) new Object[size];

        for (int i = 0; i < mArray.length; i++) {
            newArray[i] = get(i);
        }

        mArray = newArray;
        modCount++;
    }

    private void shift(int index, ShiftDirection dir) {
        switch (dir) {
            case SHIFT_DOWN:
                for (int i = index; i <= size() - 2; i++) {
                    set(i, get(i + 1));
                }
                set(size() - 1, null);
                break;
            case SHIFT_UP:
                if (get(size() - 1) != null) {
                    changeSize(size() / 2 + size());
                }
                for (int i = size() - 2; i >= index; i--) {
                    set(i+1, get(i));
                }
                set(index, null);
                break;
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return mArray[index];
    }

    @Override
    public int size() {
        return mArray.length;
    }

    @Override
    public T set(int index, T element) {
        T previous = get(index);
        mArray[index] = element;
        return previous;
    }

    @Override
    public void add(int index, T element) {
        if (index >= size()) {
            changeSize(index + (size() / 2) );
        } else {
            shift(index, ShiftDirection.SHIFT_UP);
        }

        mArray[index] = element;
    }

    @Override
    public T remove(int index) {
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

        System.out.println(list);
    }
}
