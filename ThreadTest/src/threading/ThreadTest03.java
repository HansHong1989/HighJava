package threading;

public class ThreadTest03 {
	public static void main(String[] args) {
		//쓰레드의 수행 시간을 체크해보자
		Thread th = new Thread(new MyRunner());
		//1970년 1월1일 0시0분0초부터 경과한 시간을 밀리세컨드(1/1000초) 단위로 반환
		
		long startTime = System.currentTimeMillis();
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		long result = endTime - startTime;
		
		System.out.println("총 " + result+ "초 동안 작동 했습니다.");
		
		
	}
}

class MyRunner implements Runnable{
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = 1L;i<=1_000_000_000L; i++){	//숫자에 , 찍어준거랑 같음 
			sum+=i;
		}
		System.out.println("합계 : " + sum);
	}
	
}