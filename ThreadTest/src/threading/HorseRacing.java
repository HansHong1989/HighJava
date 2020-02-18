package threading;

import java.util.Arrays;
import java.util.HashSet;

public class HorseRacing {
	
	public static void main(String[] args) throws InterruptedException {
		Horse[] horse = {new Horse("1번말"),new Horse("2번말"),new Horse("3번말"),new Horse("4번말"),
						 new Horse("5번말"),new Horse("6번말"),new Horse("7번말")};
		ShowRacing race = new ShowRacing(horse);
		
		System.out.println("-----경기 시작-----");
		for(Horse h : horse){h.start();}

		race.start();
		
		for(Horse h : horse){h.join();}
		
		Arrays.sort(horse);
		System.out.println("-----경기 결과-----");
		
		for(Horse h : horse){System.out.println(h);}
	}
}
//상황 출력
class ShowRacing extends Thread{
	
	private Horse[] horses;
	public ShowRacing(Horse[] horses){
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true){
			if(Horse.currentRank==horses.length)break;
			for(int i =0; i<15; i++){
				System.out.println();
			}
			for(int i = 0; i< horses.length;i++){
				System.out.print(horses[i].getHORSE() + ":");
				for(int j = 1; j<=50; j++){
					if(horses[i].getLocation() == j){
						System.out.print(">");
					}else{
					System.out.print("-");
					}
					
				}//for j
				System.out.println();
			}//for i
			System.out.println();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}





class Horse extends Thread implements Comparable<Horse>{
	private String HORSE;
	private int rank;
	private int location;
	
	public static int currentRank;
	
	
	
	//생성자 생성
	Horse(String name){
		this.HORSE = name;
	}
	
	public String getHORSE() {
		return HORSE;
	}

	public void setHORSE(String hORSE) {
		HORSE = hORSE;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.rank);
	}

	@Override
	public String toString() {
		return "경주마" + HORSE + " 은" + rank + "등 입니다.";
	}
	
	@Override
	public void run() {
		for(int i = 0; i<=50; i++){
			location = i;	//현재 달리고 있는 구간이 현재 말의 위치가 된다.
			try {
				Thread.sleep((int)(Math.random()*400));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//경기가 끝났을때
		++currentRank;
		this.rank = currentRank;
		
		
		
	}
	
	
	
}
