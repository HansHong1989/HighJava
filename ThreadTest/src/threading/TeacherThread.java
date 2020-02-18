package threading;

import javax.swing.JOptionPane;

public class TeacherThread {
	public static boolean inputChk;
	public static void main(String[] args) {
		GameTimer timer = new GameTimer();
		
		String[] data = {"가위","바위","보"};
		int index = (int)(Math.random() * 3);
		
		String com = data[index];
		String man = null;
		timer.start();
		boolean isNull = false;
		do{
		man = JOptionPane.showInputDialog("뭐 낼거냐 불련아");
		if(man == null || !(man.equals("가위")||man.equals("바위")||man.equals("보"))){
			System.out.println("다시 입력해라 불련아 똑바로 안내나 씨불련아");
		}
		isNull = true;
		}while(isNull == false);
		inputChk = true;
		
		
		String result = "";
		
		if(man.equals(com)){
			result = "불련이는 이제 잘하는게 하나도 없네 비기는게 말이되냐 씨불련아";
		}else if((man.equals("가위")&&com.equals("보"))
				||(man.equals("바위")&&com.equals("가위"))
				||(man.equals("보")&&com.equals("바위"))){
			
			result = "그래 이런거라도 잘해야지 불련아";
		}else{
			result = "어떻게 된게 넌 이런거도 하나 못하냐 씨불련아";
		}
		
		System.out.println("-------불련이의 가위바위봐-------");
		System.out.println("컴퓨터 : " + com);
		System.out.println("불련이 : " + man);
		System.out.println();
		System.out.println(result);
	}
}



//countTownThread

class GameTimer extends Thread{
	
	@Override
	public void run() {
		
		for(int i =5; i>=1; i--){
			try {
				if(TeacherThread.inputChk == true){
					return;
				}
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
			}
		}
		System.out.println("시간 초과다 불련아 이 씨불련아 이런거도 하나 못하냐");
		System.exit(0);
	}
}