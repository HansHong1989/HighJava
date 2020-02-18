package basic;

import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest2 {
	
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<>();
		
		
		for(char ch = 'Z'; ch>='A'; ch--){
			String temp = String.valueOf(ch);
//			String temp = ch +"";
			ts.add(temp);
		}
		
		System.out.println("TreeSet 자료 => " + ts);
		
		//TreeSet 에 저장된 자료 중 특정한 범위의 자료를 찾아서 반환해 주는 메서드들이 있다.
		//headSet(기준값) ==> '기준값' 보다 작은 자료들을 반환(기준값은 포함되지 않는다.)
		//headSet(기준값,포함여부) ==> 포함여부가 true 이면 기준값까지 포함해서 반환
		
		SortedSet<String> ss1 = ts.headSet("k");
		System.out.println("K 이전자료 : " + ss1);
		System.out.println("K 이전자료 : " + ts.headSet("K",false));
		
		//subSet(시작값,종료값) ==> 시작값부터 종료값 이전까지의 자료를 반환한다(시작값 포함, 종료값 미포함)
		//subSet(시작값,시작값포함여부,종료값,종료값포함여부)
		System.out.println("K부터 N 까지의 자로 : " + ts.subSet("K","N"));
		System.out.println("K부터 N 까지의 자료 : " + ts.subSet("K",true,"N",true));
		
		
	}
}
