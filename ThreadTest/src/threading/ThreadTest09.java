package threading;

//데몬쓰데르 연습 --> 자동저장 기능 구현
public class ThreadTest09 {
	
	public static void main(String[] args) {
		AutoSave as = new AutoSave();
		as.setDaemon(true);
		as.start();
		
		for(int i =1;i<=20; i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class AutoSave extends Thread{
	
	@Override
	public void run() {
		for(int i =1;i<=20; i++){
			System.out.println("작업 내용을 저장합니다.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}