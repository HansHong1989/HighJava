package threading;

public class ThreadTest20 {
	public static void main(String[] args) {
		
	}
}

class WorkObject{
	public synchronized void methodA(){
		System.out.println("methodA 메서드 작업중..." );
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void methodB(){
		System.out.println("methodB 메서드 작업중..." );
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

class ThreadA extends Thread{
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i = 0; i<10; i++){
			workObj.methodA();
		}
	}
}

class ThreadB extends Thread{
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i = 0; i<10; i++){
			workObj.methodB();
		}
	}
}

















