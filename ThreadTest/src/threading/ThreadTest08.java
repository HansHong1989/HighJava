package threading;

public class ThreadTest08 {
	
	public static void main(String[] args) {
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();
		System.out.println("t1의 우선순위 : " + th1.getPriority());
		System.out.println("t2의 우선순위 : " + th2.getPriority());
		
		th1.setPriority(9);
		th2.setPriority(2);
		
		
		System.out.println("t1의 우선순위 : " + th1.getPriority());
		System.out.println("t2의 우선순위 : " + th2.getPriority());
		th1.start();
		th2.start();
		
		
		
		
		
	}
	
}

class UpperThread extends Thread{
	
	@Override
	public void run() {
		for(char ch = 'A';ch<='Z';ch++){
			System.out.println(ch);
			//시간떄우는 반복문
			for(long i = 1L; i<=1000000000L;i++){
				
			}
		}
		
		
	}
}
class LowerThread extends Thread{
	
	@Override
	public void run() {
		for(char ch = 'a';ch<='z';ch++){
			System.out.println(ch);
			//시간떄우는 반복문
			for(long i = 1L; i<=1000000000L;i++){
				
			}
		}
		
		
	}
}