package quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BaseBallTest {

	public static void main(String[] args) {
		/*
		 	-Set을 이용하여 숫자 야구게임 프로그램을 작성한다.
		 	컴퓨터의 숫자는 난수를 이용해서 구한다.
		 	스트라이크는 S, 볼은 B로 출력한다.
			세자리 숫자는 중복이 안되야한다.
		*/
		HashSet<Integer> hs = new HashSet<>();
		
		while(hs.size()<3){
			int num = (int)(Math.random() * 8+1);
			hs.add(num);
		}
		ArrayList<Integer> ball = new ArrayList<>(hs);
		
		
		int S = 0;
		int B = 0;
		Collections.shuffle(ball);
		ArrayList<Integer> getNum = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("3개의 숫자가 생성되었습니다. 게임을 시작합니다.");
		System.out.println(ball);
		while(S!=3){
		System.out.println("3 개의 숫자를 띄워쓰기로 입력해 주세요.");
		getNum.add(scan.nextInt());
		getNum.add(scan.nextInt());
		getNum.add(scan.nextInt());
		
		for(int i =0; i< ball.size(); i++){
			
			System.out.println(ball.get(i));
			if(getNum.get(i) == ball.get(i)){
				System.out.println("맞다");
				S++;
			}else{
				switch (i) {
				case 0:
					if(getNum.get(i) ==ball.get(1) || getNum.get(i)==ball.get(2)){
						B++;
					}
					break;
				case 1:
					if(getNum.get(i) ==ball.get(0) || getNum.get(i)==ball.get(2)){
						B++;
					}
					break;
				case 2:
					if(getNum.get(i) ==ball.get(0) || getNum.get(i)==ball.get(1)){
						B++;
					}
					break;

				default:
					break;
				}
			}
		}
			if(S == 3){
				System.out.println("정답입니다. 게임을 종료합니다.");
			}else{
				System.out.println("S : " + S + " / " + "B : " + B);
				S = 0;
				B = 0;
				getNum.clear();
			}
		}
		
		
		
		
	}
	
}
