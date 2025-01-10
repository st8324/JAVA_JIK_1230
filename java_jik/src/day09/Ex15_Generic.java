package day09;

public class Ex15_Generic {

	public static void main(String[] args) {
		Array<String> list1 = new Array<String>(10);
		list1.set(0, "abc");
		list1.set(1, "123");
		System.out.println(list1.get(0));
		System.out.println("----------");
		list1.print();

		System.out.println("----------");
		Array<Integer> list2 = new Array<Integer>(5);
		list2.set(0, 100);
		list2.set(2, 200);
		list2.print();
		
		System.out.println("----------");
		print(1);
		print("123");
	}

	public static <T> void print(T t) {
		if(t == null) {
			return;
		}
		System.out.println(t);
	}
}

class Array<T>{
	
	private T [] list;
	
	public void setList(T [] list) {
		this.list = list;
	}
	
	public T [] getList() {
		return list;
	}
	
	public Array(int size) {
		list = (T[]) new Object[size];
	}
	
	/* 특정 번지에 있는 값을 바꾸고 바꾸는데 성공하면 기존에 있던 데이터를 반환하고,
	 * 실패하면 null을 반환
	 * */
	public T set(int index, T data) {
		if(index < 0 || index >= list.length) {
			return null;
		}
		T tmp = list[index];
		list[index] = data;
		return tmp;
	}
	
	public T get(int index) {
		if(index < 0 || index >= list.length) {
			return null;
		}
		return list[index];
	}
	
	public void print() {
		for(T tmp : list) {
			if(tmp != null) {
				System.out.println(tmp);
			}
		}
	}
}
