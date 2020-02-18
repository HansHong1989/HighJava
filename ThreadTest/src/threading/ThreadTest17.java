package threading;

public class ThreadTest17 {
	/*
	 * 쓰레드의 동기화 처리 예제 => 은행의 입출금을 쓰레드로 처리하는 예제
	 * 
	*/
	
	private int balance;	//잔액이 저장될 변수
	
	//getter,setter
	public int getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
	
	//입금을 담당하는 메서드
	public void deposit(int money){
		balance += money;
	}
	
	//출금하는 메서드(반환값 --> 출금성공 : true, 출금실패 : false)
	public synchronized boolean withdraw(int money){
		if(balance>=money){
			//출금 가능 조건			
			for(int i = 1;i<1000000000;i++){}	//시간떼우기용
			
			balance -= money;
			
			
			
			System.out.println("메서드 안에서 balance : " + getBalance());
			return true;
		}else{
			//출금 불가능
			return false;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		final ThreadTest17 acount = new ThreadTest17();
		acount.setBalance(10000);
		
		//익명 구현체를 이용한 쓰레드 구현
		Runnable acountTest = new Runnable() {
			
			@Override
			public void run() {
				
				boolean result = acount.withdraw(6000);
				System.out.println("쓰레드에서 result = " + result);
				
			}
		};
		//----------------------------
		Thread th1 = new Thread(acountTest);
		Thread th2 = new Thread(acountTest);
		th1.start();
		th2.start();
		
	}
}
