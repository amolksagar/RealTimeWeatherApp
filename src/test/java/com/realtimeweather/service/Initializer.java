package au.selfstudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import au.selfstudy.java8.defaultmethod.InterfaceImpl;
import au.selfstudy.java8.foreach.MyConsumer;

public class Initializer {

	public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=2; i<10; i++) myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
		InterfaceImpl impl = new InterfaceImpl();
		impl.log();
		
		Supplier<String> supplier = () -> "Amol";
		System.out.println(supplier.get());
	}
}
