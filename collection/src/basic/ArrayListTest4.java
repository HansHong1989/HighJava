package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제1) 5명의 별명을 Scanner로 입력하여 ArrayList에 저장하고
   	이들 중 별명의 길이가 제일 긴 별명을 출력하시오
   	(단, 별명의 길이는 모두 다르게 입력한다.)
   
	문제2) 문제 1번에서 별명을 입력할 때 별명의 길이가 같은 것이 허용될 경우를 처리하시오.
	(단, 별명의 길이는 같을 수 있다.[1번에서 확장])
*/


public class ArrayListTest4 {
	
	public static void main(String[] args) {
		ArrayList<String> aliasList = new ArrayList<>();
		Scanner s = new Scanner(System.in);	
		
		System.out.println("서로 다른 길이의 별명 입력(5명)");
		for (int i = 0; i < 5; i++) {
			System.out.print(i+1 + "번째 별명: ");
			aliasList.add(s.nextLine());
		}
		System.out.println("입력 완료");
		
		//제일 긴 별명의 길이가 저장될 변수 (첫번째 별명의 길이로 초기화)
		int maxLength = aliasList.get(0).length(); 
		
		for (int i = 1; i < aliasList.size(); i++) {   //index[0]으로 초기화를 했기때문에 굳이 0부터 할 필요가 없음
			if(maxLength < aliasList.get(i).length()){
				maxLength = aliasList.get(i).length();
			}
		}
				
		System.out.println("제일 긴 별명들...");
		for (int i = 0; i < aliasList.size(); i++) {
			if(maxLength == aliasList.get(i).length()){
				System.out.println(aliasList.get(i));
			}
		}
		
		
	}

}
