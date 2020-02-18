package quest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class LottoTest {
		// 100장 이상 X
		// 로또 1 : 2 3 4 5 6 7
		// 로또 2 : 2 3 4 5 6 7
		//잔액 돌려주기
		//
	static Scanner scan = new Scanner(System.in);
		public static void main(String[] args) {
			int select = 0;
			
		do {
			System.out.println("=========================="); 
			System.out.println("       Lotto 프로그램     "); 
			System.out.println("--------------------------"); 
			System.out.println("      1. Lotto 구입		  "); 
			System.out.println("      2. 프로그램 종료		  "); 
			System.out.println("==========================");
			select = Integer.parseInt(scan.nextLine());
			
			if(select==1) {
				//메서드 작
				
				getLottoNum(getMoney());
				
			}else if(select == 2) {
				System.out.println("감사합니다. 안녕히 가세요.");
				System.exit(0);
			}else{
				System.out.println("숫자를 다시 입력하세요.");
			}
		}
		while(select!=2);
			//번호 6개 생성하는거
		}
		
	private static int getMoney() {
		int count = 0;
		boolean isPossible = false;
			while(isPossible == false) {
			System.out.println("구매하실 금액을 입력하여 주세요.");
			int perchase = Integer.parseInt(scan.nextLine());
			if(perchase > 999 && perchase<=100000) {
				
				count = perchase/1000;					
				int change = perchase%1000;	//거스름
				
				System.out.println("받은 금액은 " + perchase +"원 이고 거스름 돈은 "+change + "원 입니다." );
				System.out.println("총 " + count +"개의 로또 번호를 생성합니다.");
				
				
				isPossible = true;
			}else if(perchase>100000) {
				System.out.println("구매가능 금액을 초과하였습니다.");
			}else {
				System.out.println("1000원 이상 입력해 주세요.");
			}
		}
			return count;
		
	}
	
	private static void getLottoNum(int count) {
		Set<Integer> lottoSet = new HashSet<>();
	
		System.out.println("========== 로또번호 ==========");
		
	for(int i = 0; i< count; i++) {	
		while(lottoSet.size()<6) {
			int num = (int)(Math.random()* 44)+1;
			lottoSet.add(num);
		}
		Iterator<Integer> it = lottoSet.iterator(); 
		System.out.print("로또 "+(i+1) + "\t");
		while(it.hasNext()) {
		System.out.print( it.next() + "\t");
		}
		System.out.println();
		lottoSet.clear();
	}
	System.out.println("--------------------------");
		
	}
	
	
	
}