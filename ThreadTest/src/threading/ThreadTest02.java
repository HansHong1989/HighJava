package threading;

public class ThreadTest02 {

	public static void main(String[] args) {
		
		//첫번재 방법
		//Thread 클래스를 상속한 class 의 인스턴스를 생성 후 start()메서드 호출.
		MyThread1 mt1 = new MyThread1();
		mt1.start();
		
		
		
		//두번째 방법
		//Runnable 인터페이스를 구현한 class 의 인스턴스를 생성한 후
		//이 인스턴스를 Thread의 인스턴스를 생성할때 생성자의 매개변수값으로 넘겨준다.
		//이때 생성된 Thread의 인스턴스의 start()메서드를 호출한다.
		MyThread2 mt2 = new MyThread2();
		Thread th2 = new Thread(mt2);
		th2.start();
		
		//세번째 방법
		//Runnable 인터페이스의 익명구현체를 생성한 후 익명구현체를
		//Thread의 인스턴스를 생성할때, 생성자의 매개변수값으로 넘겨준다.
		//이때 생성된 Thread의 인스턴스의 start()메서드를 호출한다.
		
		Thread th3 = new Thread(
			new Runnable() {
				@Override
				public void run() {
					for(int i = 1;i<=200;i++){
						System.out.print("@");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO: handle exception
						}
					}
				}
			}
			
		);
				
		th3.start();
		
		
		
		
		
	}
	
}

//Thread 클래스를 상속한 클래스를 작성하기

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		// 쓰레드가 할일을 코딩하면 된다.
		for(int i = 1;i<=200;i++){
			System.out.print("*");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
class MyThread2 implements Runnable{
	@Override
	public void run() {
		
		for(int i = 1;i<=200;i++){
			System.out.print("#");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}