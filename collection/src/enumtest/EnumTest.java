package enumtest;

public class EnumTest {
	
	/*	
	 * 	Enum(에넘)
	 * 	열거형이란?
	 * 	서로 관련(용도상)이 있는 상수들의 집합.
	 *  클래스 처럼 보이게 하는 상수
	 *  비교를 할떄 '==' 연산자를 사용해서 비교할 수 있다.
	 *  switch 문에서도 사용 가능하다.	
	 * 
	 * 
	 *  열거형 만들기
	 *  형식)
	 *  
	 *  enum 열거형이름{ 상수명1,상수명2,상수명3,....,상수명n}
	 
	 */
	
	public enum City{서울,부산,대구,대전,광주}
	
	//열거형 상수에 사용자가 임의의 값을 설정할 수 있다.
	//사용자가 설정할 임의의 값은 상수명 앞에 괄호속에 지정한다.
	
	public enum Season{
			봄("3월부터5월까지"),
			여름("6월부터 8월까지"),
			가을("9월부터11월까지"),
			겨울("12월부터2월까지");		//임의의 값이 설정된 상수를 선언할때는 마지막에 세미콜론을 붙인다.
			
			//임의의 값이 저장될 변수 선언
			private String span;
			//열거형의 생성자를 만드다 --.저장한 임의의 값을 변수에 셋팅 하는 역할을 수햏핟한다
			//열거형 생성자는 private 이어야 한다.
			//내부적으로만 사용하고 value를 가져오기 위해서 사용되어진다.
			// 봄 : Season
			// 3월부터 5월까지 : String str
			
			private Season(String str){
				span = str;
			}
			
			//외부에서 설정한 임의의 값을 가져갈 수 있는 메서드 만들기 ( 일종의 getter 메서드 만들기)
			public String getSpan(){
				return span;
			}
			
			
	}
	
	public static void main(String[] args) {
		//열거형에서 사용하는 메서드들
		// name() --> 열거형 상수의 이름을 문자열로 반환한다.
		// ordinal() --> 열거형 상수가 정의된 순서값을 반환한다.
		// valueOf("상수명") --> 지정된 열거형에서 '상수명'과 일치하는 열거형 상수를 반환한다.
		// values()--> 열거형 상수들을 배열에 담아 가져온다.
		
		
		//City 형 열거형 상수들 중에서 '서울' 값을 가져온다.
		City city1 = City.valueOf("대전");
		
		System.out.println(city1.name());
		System.out.println(city1.ordinal());	//열거형의 위치 인덱스
		
		City city2 = City.대구;	//City형 열거형 상수들 중에서 '대구'값을 가져온다.
								//City.valueOf("대구") 와 같다.
		System.out.println(city2);
		System.out.println(city2.ordinal());
		
		//------------------------------------
		
		//Season형 열거형 상수들 중에서 '봄'값 가져오기
		
		Season ss = Season.valueOf("봄");
		System.out.println("ss: " + ss);
		System.out.println("ss: " + ss.name());
		System.out.println("ss의 ordinal() : " + ss.ordinal());
		System.out.println("ss의 span() : " + ss.getSpan());
		
		for(Season time : Season.values()){
			System.out.println(time.name() + " : " + time.getSpan());
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public static void test(){
		if(MyConst.ONE==MyConst2.RED){
			System.out.println("합격....");
		}else{
			System.out.println("둘이 달라도 너무 달라");
		}
	}
	
}
