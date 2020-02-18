package threading;

public class ThreadTest16 {
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		WorkerThread w1 = new WorkerThread("t1",sObj);
		WorkerThread w2 = new WorkerThread("t2",sObj);
		
		w1.start();
		w2.start();
		
		
	}
}

//작업용 쓰레드
class WorkerThread extends Thread{
	
	ShareObject sObj;

	public WorkerThread(String name, ShareObject sObj) {
		super(name);	//쓰레드 네임
		this.sObj = sObj;
	}
	@Override
	public void run() {
		for(int i = 0; i<10; i++){sObj.add();}
		
		
	}
	
}

class ShareObject{
	
	private int sum = 0;
	
	//동기화 처리하기
	//방법 1 메서드 자체에 동기화
//	public synchronized void add(){
	public synchronized void add(){
//		방법 2(동기화 불럭으로 처리하기)
		synchronized (this) {
			int n = sum;
			
			n+=10;
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
//		int n = sum;
//		
//		n+=10;
//		
//		sum = n;
//		
//		System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
//		
		
	}
	
}
