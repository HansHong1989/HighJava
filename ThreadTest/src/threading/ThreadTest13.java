package threading;

public class ThreadTest13 {
	
	//yield()메서드 실행 예제
	//실행중에 다른 스레드에게 양보하고 실행 대기상태가 된다.
	public static void main(String[] args) {
		
		ThreadYield th1 = new ThreadYield("1번 쓰레드");
		
	}
	
}

//yield() 메서드 연습용 쓰레드
class ThreadYield extends Thread{
	
	public boolean stop = false;	//쓰레드 전체의 실행 제어용
	public boolean work = true;		//쓰레드 작동 중 작업의 실행 여부 제어용
	
	public ThreadYield(String name) {
		super(name);				//쓰레드 이름 설정(Thread클래스에 name 속성이 있는데 이 속성에는 쓰레드의 이름이 저장된다.)
	}
	@Override
	public void run() {
		
		while(!stop){
			if(work){
				System.out.println("작업중....");
			}else{
				Thread.yield();
			}
		}
		System.out.println(getName() + "종료...");
	}
}
