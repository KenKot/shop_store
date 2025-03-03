interface Identifiable {
    Integer getId(); 
}


// Unique & Sorted by Id's
public class KenList<T> {
	private int numItems;
	private T[] list;
	
	public KenList() {
		this.numItems = 0;
		this.list = (T[]) new Object[7];
	}
	
	// each item should have an "id" on it.
	public void addItem(T item) {
		// if item already on it, don't add:
		for (int i = 0; i < numItems; ++i) {
			T curr = list[i];
			if (item.getId().equals(curr.getId())) {
				return;
			}
		}
		
		// Grow list if needed
		if (this.numItems >= list.length) {
			T[] newList =(T[]) new Object[list.length * 2];
			for (int i = 0; i < list.length; ++i) {
				// Shallow Copy
				list[i] = newList[i];
			}
			list = newList;
		}

		if (numItems == 0) {
			list[0] = item;
			++numItems;
			return;
		}
		
		for (int i = numItems - 1; i >= 0; --i) {
			// first array element's title >= than new title, we insert
			if (item.getId().compareTo(list[i].getId()) >= 0) { // Asks: Does 'title' come after alphabetically?
				list[i + 1] = item;
				++numItems;
				return;
			} else {
				list[i + 1] = list[i];

				// edge case if we make it to the beginning
				if (i == 0) {
					list[0] = item;
					++numItems;
					return;
				}
			}

		}
	}
}
