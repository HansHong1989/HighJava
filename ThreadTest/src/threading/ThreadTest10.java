package threading;

public class ThreadTest10 {
	//쓰레드 상태출력
	public static void main(String[] args) {
		TargetThread target = new TargetThread();
		StateThread state = new StateThread(target);
		state.start();
	}
}
//TargetThread의 사애를 출력하는 클래스
class StateThread extends Thread{
	private TargetThread target;//상태를 출력할 대상이 되는 쓰레드가 저장될 변수
	public StateThread(TargetThread target) {
		this.target = target;
		
	}
	@Override
	public void run() {
		while(true){
			Thread.State state = target.getState();
			System.out.println("타겟 쓰레드의 상태값 : " + state);
			
			if(state == Thread.State.NEW){			//쓰레드의 상태가 NEW 상태인지 검사
				target.start();
			}
			if(state == Thread.State.TERMINATED){	//쓰레드가 종료된 상태
				break;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
class TargetThread extends Thread{
	@Override
	public void run() {
	
		for(long i=1L; i<=2_000_000_000L; i++){} //시간 지연용
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(long i=1L; i<=2_000_000_000L; i++){} //시간 지연용
		
	}
}