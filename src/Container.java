//Esta clase con nombre container servira para guardar los componentes en un array
//que se irá autoincrementado cuando reciba un nuevo componente y no pueda entrar en el array
//Podríamos llegar a decir que tiene un funcionamiento parecido al de los Linked List

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

    //Esta Funcion es la que añade los componentes al array y las nuevas posiciones
    //creando uno nuevo de la cantidad de posiciones anteriores * 2 y
    //copia los valores que ya estuvieran introducidos

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

    public T get(int pos) {
        if (pos < this.nobj) {
            return (T) objectArray[pos];
        }
        return null;
    }
}
