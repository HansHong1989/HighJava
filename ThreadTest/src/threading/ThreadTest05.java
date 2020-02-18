package threading;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThreadTest05 {
	
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("불련이를 본다의 영어를 한글로 표기하면?");
		System.out.println("입력값 : " + str);
		System.out.println("정답입니다.");
		
		
		for(int i = 10; i>=1; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
