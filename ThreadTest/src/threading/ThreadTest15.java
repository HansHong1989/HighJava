package threading;

public class ThreadTest15 {
	/*
		원주율을 계산하는 쓰레드와 계산된 원주율을 출력하는 쓰레드가 있다.
		
		원주율을 관리하는 객체를 생성해서 두 쓰레드에서 공통으로 사용한다.
		
		
		
	*/
	public static void main(String[] args) {
		ShareData sd = new ShareData();
		CalcPIThread cal = new CalcPIThread(sd);
		PrintThread prn = new PrintThread(sd);
		cal.start();
		prn.start();
	}
}


//원주율을 계산하는 쓰레드

class CalcPIThread extends Thread{
	
	private ShareData sd;
	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		
		double PI = 0.0;
		for(int i = 1; i<=1000000000; i+=2){
//			방법 1
//			PI+= i%4 == 1 ? 1/i : ( i%4 == 3 ? -1/i : 0 );
//			방법 2
//			if((i/2)%2 == 0){
//				PI+= 1.0/i;
//			}else{
//				PI-=1.0/i;
//			}
//			방법 3
			if(i%4 == 1){
				PI+=1.0/i;
			}else{
				PI-=1.0/i;
			}
			
		}
		PI = PI*4;
//		System.out.println(PI);
		sd.result = PI*4;
		sd.isOk = true;
	}
	
	
}

//계산이 완료되면 계산된 원주율을 출력하는 쓰레드

class PrintThread extends Thread{
	
	public PrintThread(ShareData sd) {
		this.sd = sd;
	}

	private ShareData sd;
	@Override
	public void run() {
		while(!sd.isOk){
			Thread.yield();
		}
		System.out.println();
		System.out.println("결과 : " + sd.result);
		System.out.println("PI : " + Math.PI);
	}
	
	
}



//원주율을 관리하는 클래스(공유될 클래스)

class ShareData{
	public double result; //계산된 결과가 저장될 변수
	//volatile ==> 
//	public volatile boolean isOk = false;
	public boolean isOk = false;//계산이 완료 되었는지를 나타내는 변수
	
}
