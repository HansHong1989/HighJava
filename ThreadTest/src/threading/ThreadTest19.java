package threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ThreadTest19 {
	public static void main(String[] args) {
		/*	Vector,HashTable 등 예전부터 존재하던 Collection 들은 내부에 동기화 처리가 되어있다.
		 *	새롭게 구성된 Collection 들은 기본적으로 동기화가 처리되어 있지 않다.
		 *	 
		 * 
		 * 
		 */
	
		
		
		final Vector<Integer> vec = new Vector<>(); 		//백터는 자동으로 동기화처리가 된다.
		final ArrayList<Integer> list = new ArrayList<>();
		final List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				
				for(int i = 0; i<1000; i++){
					list2.add(i);
					vec.add(i);
				}
				
			}
		};
		
		Thread[] ths = new Thread[]{
				new Thread(r),new Thread(r),new Thread(r),new Thread(r),new Thread(r)
		};
		for(Thread th : ths){
			th.start();
		}
		for(Thread th: ths){
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("list2의 개수 : " + list2.size());
		System.out.println("vec의 개수 : " + vec.size());
	}
}
