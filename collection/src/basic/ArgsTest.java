package basic;

class SampleVo{
	String name;
	int num;
}

public class ArgsTest {
	
	//배열을 이용한 메서드 --> 매개변수로 정수값들을 받아서 이값들의 합계를 반환하는 메서드
	//가변형 인수는 메서드내에서는 배열로 처리된다.
	
	public int classArg(SampleVo...data){
		
		
		return 0;
	}
	
	public int sumArr(int[] nums){
		int result = 0;
			
		return result;
	}
	
	public int sumArg(int...data){
		int result = 0;
		for(int i = 0; i<data.length; i++){
			result +=data[i];
		}
		return result;
	}
	//메서드에서 가변형 인수는 한가지만 사용 가능하다.
//	public int sumArg2(int...data,String...str){	//에러발생
//																			
//		return 0;
//	}
	
	//가변형 인수와 다른 매개변수를 같이 사용할 경우에는 가변형 인수를 제일 뒤에 배치해야 한다.
	public int sumArg2(String a, int b, double c, int...data){
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		String a = "65";
		int b = Integer.parseInt(a);
		char c = (char)b;
		System.out.println(c);
		
		
		ArgsTest argTest = new ArgsTest();
		
		System.out.println(argTest.sumArg(100,200,300,400,500));
		
		
	}
	
}
