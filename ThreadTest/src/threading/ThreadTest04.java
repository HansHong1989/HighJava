package threading;

public class ThreadTest04 {

	
		//1~20억까지 합계를 구하는데 걸린 시간을 체크해보자
		//전체 합계를 구하는 작업을 싱글 쓰레드가 처리할때와 
		//멀티 쓰ㅔ드로 분할해서 처리할 때의 시간을 비교해보자
	
		public static void main(String[] args) {
			
			SumThread04 smAll = new SumThread04(1L,2000000000L);
			
			SumThread04[] sms = new SumThread04[]{
				new SumThread04(1L         , 500000000L),
				new SumThread04(500000001L ,1000000000L),
				new SumThread04(1000000001L,1500000000L),
				new SumThread04(1500000001L,2000000000L)
			};
			
			
			long startTime = System.currentTimeMillis();
			smAll.start();
			try{
				smAll.join();
			}catch(InterruptedException e){
				
			}
			long endTime = System.currentTimeMillis();
			
			System.out.println("단독으로 처리할 때의 시간 : " + (endTime - startTime));
			System.out.println();
			//-----------------------------------------------------------
			//여러개의 쓰레드가 협력해서 처리했을떄
			
			startTime = System.currentTimeMillis();
			
			for(int i = 0; i< sms.length; i++){
				sms[i].start();
			}
			
			for(SumThread04 sm : sms){
				try {
					sm.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			endTime = System.currentTimeMillis();
			
			System.out.println("협력해서 처리했을때의 시간 : "+ (endTime - startTime));
		}
	
	
}

class SumThread04 extends Thread{
	private long min,max;
	
	public SumThread04(long min, long max){
		this.min = min;
		this.max = max;
		
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = min; i<=max;i++){
			sum+=i;
		}
		System.out.println("합계 : " + sum);
	}
	
	
	
	
}