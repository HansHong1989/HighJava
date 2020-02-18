package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
    문제1) 5명의 별명을 Scanner로 입력하여 ArrayList에 저장하고
       이들 중 별명의 길이가 제일 긴 별명을 출력하시오
       (단, 별명의 길이는 모두 다르게 입력한다.)
       
    문제2) 문제 1번에서 별명을 입력할 때 별명의 길이가 같은 것이 허용될 경우를 처리하시오.
 */





public class ArrayListTest3 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> nicknameList = new ArrayList<>();
		
		System.out.println("서로 다른 길이의 별명 입력(5명)");
		for (int i = 0; i < 5; i++) {
			System.out.print(i+1 + "번째 별명: ");
			nicknameList.add(s.nextLine());
		}
			
//		String temp = ""; //제일 긴 별명이 저장될 변수
//		for (int i = 0; i < nicknameList.size(); i++) {
//			for (int j = i+1; j < nicknameList.size(); j++) {
//				if(nicknameList.get(i).length() < nicknameList.get(j).length()){
//					temp = nicknameList.get(j);
//					nicknameList.set(i, temp);
//					nicknameList.set(j, nicknameList.get(i));
//				}
//			}			
//		}
//		System.out.println("별명 중 제일 긴 별명은 :" + nicknameList.get(0));
//		
//		for (int i = 0; i < nicknameList.size(); i++) {
//			if(nicknameList.get(i).length() == nicknameList.get(0).length()){
//				System.out.println(nicknameList.get(i));
//			}
//		}
		
		String maxNickName = nicknameList.get(0); //제일 긴 별명이 저장될 변수 (첫번째 별명으로 초기화)
		
		for (int i = 1; i < nicknameList.size(); i++) {
			if(maxNickName.length() < nicknameList.get(i).length()){
				maxNickName = nicknameList.get(i);
			}
		}
		
		System.out.println("제일 긴 별명: " + maxNickName);
		
	}

	
	

}














