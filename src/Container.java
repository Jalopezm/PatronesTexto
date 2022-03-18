public class Container<T> {
    private Object[] objectArray;
    private int capacity;
    private int nobj;

    public Container() {
        objectArray = new Object[2];
        capacity = 2;
    }

    public int size() {
        return this.nobj;
    }

    void addElement(T o) {
        if (this.nobj == this.capacity) {
            int newCapacity = this.capacity * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < this.capacity; i++) {
                newArray[i] = this.objectArray[i];
            }
            this.objectArray = newArray;
            this.capacity = newCapacity;
        }
        this.objectArray[this.nobj] = o;
        this.nobj++;
    }

}
