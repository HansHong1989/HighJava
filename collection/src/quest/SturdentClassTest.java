package quest;

public class SturdentClassTest {
	//		JAVA ORACLE HTML CSS JAVASCRIPT JSP
	//김철희       90		x	 80	  x    70        50
	//정영수	  x     90   x    90    80       x
	//이혁진
	//심주영
	//이제경
	
	public static void main(String[] args) {
		
		getGrade("김철희",90,98,87,100,90);
		getGrade("정영수",92,62,100);
		getGrade("이혁진",80,72,90);
		getGrade("김태유",70,83,72,90);
		
	}
	
	private static void getGrade(String name,int...data){
		
		String student = name;
		int sum = 0;
		for(int i = 0; i< data.length; i++){
			sum += data[i];
		}
		
		double avg = (double)sum/data.length;
		String grade = null;
		if(avg<=100 && avg>=91){
			grade = "A";
		}else if(avg<=90 && avg>=81){
			grade = "B";
		}else if(avg<=80 && avg>=71){
			grade = "C";
		}else if(avg<=70 && avg>=61){
			grade = "D";
		}else{
			grade = "F";
		}
		
		System.out.print(student + " 학생    | ");
		for(int i = 0; i< data.length; i++){
			System.out.print("\t"+ data[i]);
		}
		System.out.println(" / 총점 : " + String.format("%.2f", avg) +" / 평점 : " + grade +" 입니다.");
	}
	
}
