import java.util.Arrays;
public class MyArrayList {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void add(Object value) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = value;
    }
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }
    private void grow() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
}
class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        System.out.println("Size: " + list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.remove(1);
        System.out.println("Size after removal: " + list.size());
        System.out.println(list.get(1));
        list.clear();
        System.out.println("Size after clearing: " + list.size());
    }
}
