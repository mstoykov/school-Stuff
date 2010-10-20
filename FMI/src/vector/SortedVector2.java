package vector;

import java.util.Vector;


public class SortedVector2<E extends Comparable<E>> extends Vector<E> {
	// Methods inherited from class Vector<E>

	// Private method
	/**
	 * 
	 */
	private static final long serialVersionUID = 5682931788732603344L;

	private int pos(E arg) {
		int i = 0, j = this.size();
		E center;
		int ind;
		while (i < j) {
			ind = (i+j)/2;
			 center = get(ind);
			if (center.equals(arg)){
				return ind;			
			} else if(center.compareTo(arg) > 0){
				j = ind -1;
			} else {
				i = ind +1;
			}
		}
		
		return j == i ? j-1: j ;
	}

	// Търси в текущия нареден вектор по метода на двоичното търсене максималния
	// индекс, такъв че
	// елементът на вектора с този индекс е по-малък или равен на arg. Връща
	// определения индекс

	// Override methods
	public boolean add(E e) {
		try {
			add(pos(e) + 1, e);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	// Включва елемента e в текущия нареден вектор в позиция, определена от
	// метода pos

	@SuppressWarnings("unchecked")
	public boolean remove(Object e) {
		int pos = pos((E) e);
		if (pos >= 0  && pos < size() &&  get(pos).equals(e)) {
			remove(pos);
			return true;
		}
		return false;
	}

	// Изключване елемента e от текущия нареден вектор, използвайки метода pos

	@SuppressWarnings("unchecked")
	public boolean contains(Object e) {
		int pos = pos((E) e);
		return (pos >= 0 && pos < size() && get(pos).equals(e));
		
	}
	// Проверява дали елемента e се съдържа в текущия нареден вектор,
	// използвайки метода pos
}