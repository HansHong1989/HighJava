package threading;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	
	public static void main(String[] args) {
		DataInput input = new DataInput();
		CountDown count = new CountDown();
		
		input.start();
		
		count.start();
		
		
	}
	
}

class DataInput extends Thread{
	public static boolean inputChk;
	String str = null;
	@Override
	public void run() {
		do{
			if(str==null){
				str = JOptionPane.showInputDialog("입력해봐 불련아");
			}
		}while(inputChk);
			inputChk = true;
			
		
		System.out.println("불련이가 입력한 값 : " + str);
	}
}
class CountDown extends Thread{	
	@Override
	public void run() {
		for(int i =10; i>=1; i--){
			System.out.println(i);
			if(DataInput.inputChk == true){
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("10초 땡 했다 불련아 프로그램 종료한다 씨불련 어게인");
	}
}