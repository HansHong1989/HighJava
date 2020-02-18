package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
	학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 가진 Student클래스를 만든다.
	이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 처리한다.
	
	이 Student객체들은 List에 저장하여 관리한다.
	
	List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분(내부 정렬기준)과
	총점의 역순으로 정렬하는 부분(외부 정렬기준)을 프로그램 하시오.
	(그리고, 총점이 같으면 이름의 내림차순으로 정렬되도록 한다.)
 */
class Student implements Comparable<Student>{
	
	private int korScore, EngScore, MathScore, sNum;
	private String sName;
	int grade;
	int sumScore = korScore + EngScore + MathScore;	

	//생성자
	public Student(int korScore, int engScore, int mathScore, int sNum,
			String sName) {
		super();
		this.korScore = korScore;
		this.EngScore = engScore;
		this.MathScore = mathScore;
		this.sNum = sNum;
		this.sName = sName;
		this.sumScore = korScore + engScore + mathScore;		
		this.grade = 1;
	}
	
	@Override
	public String toString() {
		return "Student [등수: " + grade + ", 총점= " + sumScore + ", 국어점수=" + korScore + ", 영어점수=" + EngScore
				+ ", 수학점수=" + MathScore + ", 학번=" + sNum + ", 이름="
				+ sName + "]";
	}
		
	public void setgrade(int grade) {
		this.grade = grade;
	}
	
	public int getSumScore() {
		return sumScore;
	}
	
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public int getKorScore() {
		return korScore;
	}


	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}


	public int getEngScore() {
		return EngScore;
	}


	public void setEngScore(int engScore) {
		EngScore = engScore;
	}


	public int getMathScore() {
		return MathScore;
	}


	public void setMathScore(int mathScore) {
		MathScore = mathScore;
	}

	
	@Override
	public int compareTo(Student stu) {
		
		return this.getsNum() - stu.getsNum();
		
	}
	
}


public class StudentTest {
	
	public static void main(String[] args) {
		ArrayList<Student> studentsList = new ArrayList<>();

		studentsList.add(new Student(80, 85, 70, 3, "윤서울"));
		studentsList.add(new Student(65, 50, 85, 4, "강대구"));
		studentsList.add(new Student(100, 90, 85, 1, "정대전"));
		studentsList.add(new Student(50, 55, 90, 5, "최부산"));
		studentsList.add(new Student(70, 45, 60, 2, "다전주"));
		studentsList.add(new Student(70, 60, 45, 7, "가전주"));
		studentsList.add(new Student(60, 70, 45, 6, "라전주"));
		studentsList.add(new Student(60, 70, 45, 8, "나전주"));
		
	
		
		
	for (int i = 0; i < studentsList.size(); i++) {			
		for (int j = 0; j < studentsList.size(); j++) {			
			if( studentsList.get(i).getSumScore() < studentsList.get(j).getSumScore() ){					
					studentsList.get(i).grade ++;
			}
		}			
	}		

		
		System.out.println("정렬 전 출력");
		for (Student mem : studentsList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------------");
		
		Collections.sort(studentsList);
		
		System.out.println("학번의 오름차순 내부정렬 후 출력");
		for (Student mem : studentsList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------------");
		
		Collections.shuffle(studentsList);
		Collections.sort(studentsList, new SortSumDesc());
		System.out.println("총점의 내림차순 정렬 후 출력");
		for (Student mem : studentsList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------------");	
			
						
	}
	
}


//총점의 역순 외부
class SortSumDesc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {		
		
		if(stu1.getSumScore() < stu2.getSumScore()){
			return -1; // 양수를 반환하면 두 값의 순서가 바뀐다.
		}else if(stu1.getSumScore() == stu2.getSumScore()){
			return -(stu1.getsName().compareTo(stu2.getsName()));
		}else{
			return 1;
		}
				
	}

}








