package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전 list => " + list);
		// 정렬은 Collenctions.sort() 메서드를 이용하여 정렬한다.
		// 정렬은 기본적으로 오름차순 정렬을 수행한다.
		Collections.sort(list);
		System.out.println("정렬 후 list => " + list);
		
		Collections.shuffle(list);  // 자료 섞기
		System.out.println("자료 섞기 후 list => " + list);
		
		Collections.sort(list, new Desc());
		System.out.println("정렬 후 list => " + list);
		
		
		
	}

}


// 정렬하는 방식을 저장하는 클래스 작성 ==> Comparator 인터페이스를 구현하여 정렬 방식을 지정한다.
// Comparator 인터피에스의 compare() 메서드를 재정의해서 정렬방식을 구현한다.
class Desc implements Comparator<String>{
	/*
	    compare() 메서드의 반환값이 양수이면 두 값의 순서를 바꾼다.
	   	
	   	오름차순일 경우 ==> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환
	   	
	   	String객체에는 정렬을 위해서 compareTO() 메서드가 구현되어 있는데, 이 메서드의 반환값은 
	   	오름차순에 맞게 반환되도록 구현되어 있다.
	   	(Wrapper클래스와 Date객체, File클래스에도 구현되어 있다.)
	 */
	
	// 내림차순 정렬이 되도록 재정의
	@Override
	public int compare(String s1, String s2) {
/*1.	if(s1.compareTo(s2)>0){  //앞에꺼가 더 크면 안바꿈 (내림차순이 되어야 하니까)
			return -1;
		}else if(s1.compareTo(s2)==0){
			return 0;
		}else{
			return 1;
		}		*/
//2.		return s1.compareTo(s2)*(-1);
		return -(s1.compareTo(s2));
	}
	
}