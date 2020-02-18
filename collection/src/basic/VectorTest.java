package basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector v1 = new Vector();
		
		System.out.println("처음 크기 : " + v1.size());
		v1.add("aaa");
		v1.add(111);
		v1.add(v1);
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		
		System.out.println("v1의 크기 : " + v1.size());
		
		v1.addElement("kkk");
//		addElement() 메서드 -> 이 메서드도 데이터를 추가할때 사용되낟.
		for(int i = 0; i< v1.size(); i++){
			System.out.println("v" + i+" : " + v1.get(i) );
		}
//		add(index,데이터) -> 벡터의 index 번째에 '데이터'를 끼워넣는다.
//						-> index == 0 부터 시작
		
		v1.add(1,"가나다라");
		
//		set(index,데이터) -> 벡터의 index 번째의 값을 '데이터' 로 변경한다(덮어쓴다)
		String temp = "zzz";
		v1.set(1,temp);
		
//		remove(index) -> 벡터의 index번째 '데이터'을 삭제한다.
		
		v1.remove(1);
		v1.remove(new Integer(123));
		v1.remove('a');
		v1.remove(new Character('a'));
		System.out.println("-------------------------------------------------------");
		
		
		Vector<Integer> v2 = new Vector<>();
		Vector<String> v3 = new Vector<>();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
