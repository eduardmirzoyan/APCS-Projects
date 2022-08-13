
public class ResizableArray<E> {

	private E[] data;
	private int size;
	private int MAX_DATA_AMOUNT = 10;
	
	public ResizableArray() {
		data = (E[])new Object[MAX_DATA_AMOUNT];
		size = 0;
	}
	
	public ResizableArray(int size) {
		data = (E[])new Object[MAX_DATA_AMOUNT];
		this.size = size;
	}
	
	public void add(E value) {
		resize();
		data[size] = value;
		size++;
	}
	
	public E remove(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}
		else {
			E temp = data[index];
			for(int count = index; count < size; count++) {
				data[count] = data[count + 1];
			}
			size--;
			return temp;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String s = "";
		if(size == 0) {
			throw new IllegalArgumentException("No Values in Array");
		}
		else {
			for(int count = 0; count < size; count++) {
				s += data[count] + ", ";
			}
			return s;
		}
	}
	
	public void insert(int index, E value) {
		if(index > size) {
			throw new IllegalArgumentException("Index out of bounds: " + index + " for value: " + value);
		}
		else {
			resize();
			for(int count = size; count > index; count--) {
				data[count] = data[count - 1];
			}
			data[index] = value;
			size++;
		}
		
	}
	
	public E get(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}
		else {
			return data[index];
		}
		
	}
	
	public void set(int index, E value) {
		if(index >= size) {
			throw new IllegalArgumentException("Index out of bounds: " + index + " for value: " + value);
		}
		else {
			data[index] = value;
		}
		
	}
	
	public void sort() {
		for (int count = 0; count < size; count++) {
	        for (int count2 = count + 1; count2 < size; count2++) {
	            E temp = data[0];
	            Comparable<E> x = (Comparable<E>)data[count];
	            if(x.compareTo(data[count2]) > 0) {
	                temp = data[count];
	                data[count] = data[count2];
	                data[count2] = temp;
	            }
	        }
	    }
	}
	
	public int indexOf(E value) {
		for(int count = 0; count < size; count++) {
			if(data[count] == value) {
				return count;
			}
		}
		return -1;
	}
	
	public boolean equals(Object other) {
		ResizableArray<E> array = (ResizableArray<E>)other;
		if(!(other instanceof ResizableArray)) {
			throw new IllegalArgumentException("Object is not a ResizableArray");
		}
		for(int count = 0; count < size; count++) {
			if(data[count] == array.get(count)) {
				//Do nothing
			}
			else {
				return false;
			}
		}
		return true;	
	}
	
	public E[] toArray() {
		E[] array = (E[])new Object[size];
		for(int count = 0; count < size; count++) {
			array[count] = data[count];
		}
		return array;
	}
	
	public boolean contains(E value) {
		for(int count = 0; count < size; count++) {
			if(data[count] == value) {
				return true;
			}
		}
		return false;
	}
	
	private void resize() {
		if(size + 1 > MAX_DATA_AMOUNT) {
			MAX_DATA_AMOUNT = size + 100;
			E[] newData = (E[])new Object[size + 100];
			for(int count = 0; count < size; count++) {
				newData[count] = data[count];
			}
			data = newData;
		}
	}
	
	public static void main(String[] args) {
		ResizableArray a = new ResizableArray();
		a.add(2);
		a.add(1);
		a.add(100);
		a.add(2.02);
		a.sort();
		System.out.println(a.toString());
	}
}
