package threading;

public class ThreadTest14 {
	
	/*	
	 * 	Thread 의 stop() 메서드를 호출하면 쓰레드가 바로 멈춘다.
	 * 	이때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어
	 *  나중에 실행되는 프로그램에 영향을 줄수있다.
	 *  그래서 메서드 stop()메서드는 사용하지 말아야 할 비 권고사항이다.
	 *  
	 * */
	
	public static void main(String[] args) {
//		THreadStopEx1 th1 = new THreadStopEx1();
//		th1.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//stop 메서드를 쓸경우 불안정하기때문에 이런식으로 처리해 주는 것이 좋다.
//		th1.setStop(true);
//		th1.stop();
		
		//------------------------------------------
		InterruptThread th2 = new InterruptThread();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.interrupt();
	}
	
}


class THreadStopEx1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 실행중...");
		}
		
		System.out.println("자원 정리...");
		System.out.println("실행종료");
	}
	
	
}


//interrupt()메서드를 이용하여 쓰레드를 멈추게 하는 방법

class InterruptThread extends Thread{
	
	
/*	@Override
	public void run() {
		//방법 1
		while(true){
			System.out.println("쓰레드 실행중...");
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				break;
			}
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료...");
	}
*/
//----------------------------------------------
	
	@Override
	public void run() {
		//방법 2
		while(true){
			System.out.println("실행중");
			
			//interrupt()메서드가 호출 되었는지를 검사
//			검사방법1
//			인스턴스 객체용 메서드 isInterrupted() 를 이용하여 검사한다.
			if(this.isInterrupted()){
				break;
			}
//			검사방법2
			// Thread의 정적 메서드 interrupted()를 이용하여 검사한다.
			if(Thread.interrupted()){
				break;
			}
			
			
			
		}
		
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료...");
	}
}
	

















