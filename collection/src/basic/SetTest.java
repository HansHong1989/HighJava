package basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	
	public static void main(String[] args) {
		/*-List 와 Set 의 차이점
			List
			-데이터 의 순서가 있다.
			- 중복된 데이터를 저장할수 있다.
			Set
			- 데이터의 순서가 없다.
			- 중복된 데이터를 저장할 수 없다.
		*/
		
		
		HashSet hs1 = new HashSet();
		
		hs1.add("DD");
		hs1.add("AA");
		hs1.add("CC");
		hs1.add(2);
		hs1.add("EE");
		hs1.add(1);
		hs1.add(3);
		hs1.add("BB");
		
		System.out.println("hs1 = " + hs1);
		//Set 은 데이터의 순서가 없고 중복을 허용하지 않는다. 그래서 이미 있는 데이터를 add하면
		//add() aptjemsms false를 반호나하고 데이터가 추가되지 않는다.
		
		boolean isAdd = hs1.add("FF");
		System.out.println(isAdd);
		System.out.println("hs1 = " + hs1);
		boolean isAdd2 = hs1.add("AA");
		System.out.println(isAdd2);
		System.out.println("hs1 = " + hs1);
		
		
		//Set 의 저장된 데이터를 차례로 꺼내와서 처리하는 방법
		//1. 향상된 for문을 이용
		//2. Iterator 를 이용하는방법
		
		//1. 향상된for문 이용하기
		for(Object obj : hs1){
			System.out.println(obj);
		}
		
		//Iterator 이용하기
		//Iterator 는 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 것이다.
		//Iterator 객체 구하기 -> 각 컬렉션 객체엔 iterator() 라는 메서드가 있는데
		//이 메서드가 해당 컬렉션의 Iterator객체를 생성해 주는 메서드이다.
		
		//Set 에서 Iterator 객체 구하기
		
		Iterator it = hs1.iterator();
		
		//hasNext() --> 다음 자료가 있는지 검사한다.
		while(it.hasNext()){
			System.out.println(it.next());// next() -> 포인터를 다음 자료위치로 이동 시킨 후 그위치의 데이터를 읽어와 반환한다.
			
		}
		
		
		
		//Set을 이용한 로또
		
		HashSet<Integer> lottoSet = new HashSet<>();
		ArrayList<Integer> lottoList = new ArrayList<>();
		while(lottoSet.size()<6){
			int num = (int)(Math.random() * 45+1);
			lottoSet.add(num);
			lottoList.add(num);
			
		}
		System.out.println("로또번호 : " + lottoSet);
		
		
		System.out.println("LIst 로또번호 : " + lottoList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
