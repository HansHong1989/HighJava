package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  문제) 5명의 사람 이름을 Scanner로 입력받아 ArrayList에 저장하고
 *		 이 사람들 중에 '김'씨 성의 이름을 출력하는 프로그램을 작성하시오.
 */







public class ArrayListTest2 {
	
	
	public static void main(String[] args) {
			
		Scanner s = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<>();
		
		System.out.println("5명의 사람 이름을 입력해주세요.");
		for (int i = 0; i < 5; i++) {	
			nameList.add(s.nextLine());
		}	
		
		//System.out.println(nameList);
		System.out.println("성이 김씨인 사람의 이름은");
		System.out.println("=======================================================");
		for (int i = 0; i < nameList.size(); i++) {
//			if(nameList.get(i).substring(0,1).equals("김")){
//		    if(nameList.get(i).charAt(0)=='김'){    0번째 글자를 뽑아 그게 "김"이면
//			if(nameList.get(i).indexOf("김")==0){   김이 있으면 그 인덱스 값 반환, 없으면 -1반환
			if(nameList.get(i).startsWith("김")){    //김으로 시작하면
				System.out.println( nameList.get(i) );		
			}
		}
		System.out.println("=======================================================");
		System.out.println("입니다");
		
	}

}
