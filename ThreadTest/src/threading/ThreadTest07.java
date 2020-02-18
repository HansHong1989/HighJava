package threading;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	public static boolean isDone;

	//가위 1 바위 2 보 3
	
	
	public static void main(String[] args) {
		
		CountDown2 cd = new CountDown2();
		RPSGame g = new RPSGame();
		String str = null;
		cd.start();
		g.start();
		
	}
}
class RPSGame extends Thread{
	public static boolean isDone;
	String str;
	
//	public RPSGame(String str) {
//		this.str = str;
//	}

	@Override
	public void run() {
		
		do{
			
			str = JOptionPane.showInputDialog("입력해봐 불련아");
			
		}while(str==null);
		 if(str != null){
			 isDone = true;
		 }
		
		System.out.println("불련이가 낸거는" + str);
		int user = 0;		
		if(str.equals("가위")){
			user = 1;
			
		}else if(str.equals("바위")){
			user = 2;
			
		}else if(str.equals("보")){
			user = 3;
		}else{
		System.out.println("똑바로 내라 불련아 이런것도 똑바로 못하냐 다시 시작해 씨불련아");
		return;
		}
		int com = (int)(Math.random()*3)+1;
		switch(com){
		case 1: System.out.println("com 이가 낸거는 가위"); break;
		case 2: System.out.println("com 이가 낸거는 바위"); break;
		case 3: System.out.println("com 이가 낸거는 보"); break;
		default:break;
		}
		
		String how = null;
		switch(user){
		case 1:
			if(com == 1) {how = "draw";}
			if(com == 2) {how = "lose";}
			if(com == 3) {how = "win";}
			break;
		case 2:
			if(com == 1) {how = "win";}
			if(com == 2) {how = "draw";}
			if(com == 3) {how = "lose";}
			break;
		case 3:
			if(com == 1) {how = "lose";}
			if(com == 2) {how = "draw";}
			if(com == 3) {how = "win";}
			break;
			default:break;
		
		}
		
		if(how.equals("win")){
			System.out.println("불련아 가위바위보는 좀 하는구나 이겼도다.");
		}else if(how.equals("lose")){
			System.out.println("너는 잘하는게 뭐냐 불련아 이것도 못하고 지기만 하는 하류인생 씨불련이");
		}else{
			System.out.println("비겼다 불련아 어떻게 이거하나 못이기냐 이 씨불련아");
		}
		
	}
}

class CountDown2 extends Thread{
	
	@Override
	public void run() {
		for(int i =5; i>=1; i--){
			if(RPSGame.isDone == true){
				
				return;
			}
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("안내고 뭐하냐 불련아 넌 걍 진거다 씨불련");
	}
}
