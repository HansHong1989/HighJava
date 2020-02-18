package quest;

public class TestTest {
	public static void main(String[] args) {
		int num = 987;
		System.out.println(solution(num));
		 
		
		
		
	}
	 public static int solution(int n) {
		  int answer = 0;
		  int a = 0;
	        
	        while(true) {
	            a = n%10;
	            n = n/10;
	            answer += a;
	            
	            if(n==0) break;
	        }
	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("Hello Java");

	        return answer;
	    }
}
