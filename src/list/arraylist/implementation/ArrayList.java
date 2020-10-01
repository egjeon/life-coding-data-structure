package list.arraylist.implementation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ListIterator;

public class ArrayList {
  private int size = 0;
  private Object[] elementData = new Object[100];

    public int size(){
        return this.size;
    }

    public boolean addFirst(Object element) {
        return add(0,element);
    }

    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }

    public boolean add(int idx, Object element) {
        for(int i = size; i > idx; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[idx] = element;
        size++;

        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(elementData[i]);
            if(i < size-1){
            sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public Object remove(int idx) {
        Object removed = elementData[idx];
        for(int i=idx+1; i <= size - 1; i++){
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }
    public Object removeFirst(){
        return remove(0);
    }

    public Object removeLast(){
        return remove(size-1);
    }

    public Object get(int idx) {
        return elementData[idx];
    }

    public Object indexOf(Object value) {
        for(int i = 0; i < size; i++){
            if(elementData[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    public ListIterator listIterator(){
        return new ListIterator();

    }
    class ListIterator{
        private int nextIndex = 0;

        public Object next(){
            return elementData[nextIndex++];
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public Object previous() {
             return elementData[--nextIndex];
        }

        public boolean hasPrevious(){
            return nextIndex > 0;
        }

        public void add(Object element) {
            ArrayList.this.add(nextIndex++,element);
        }

        public void remove() {
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;

        }
    }
}
