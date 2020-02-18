package threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest18 {
	
	//Lock 를 이용한 동기화 처리
	private int balance;
	final private Lock lock = new ReentrantLock();	//Lock 객체생성
	
	public void deposit(int money){
		lock.lock();//락설정
		balance += money;
		
		lock.unlock();//락해제
		
	}
	
	//출금하는 메서드(반환값 --> 출금성공 : true, 출금실패 : false)
	public boolean withdraw(int money){
		boolean chk = false;
		lock.lock();	//락 설정
		if(balance>=money){
			//출금 가능 조건			
			for(int i = 1;i<1000000000;i++){}	//시간떼우기용
			
			balance -= money;
			
			
			System.out.println("메서드 안에서 balance : " + getBalance());
			chk =  true;
			
		}else{
			//출금 불가능
			chk =  false;
			
		}
		lock.unlock();	//락 해제
		return chk;
	}
	
	

	public static void main(String[] args) {
		final ThreadTest18 acount = new ThreadTest18();
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


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
