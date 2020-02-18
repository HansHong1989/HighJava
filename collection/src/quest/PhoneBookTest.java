package quest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	static HashMap<String,UserPhoneVo> map = new HashMap<>();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//전화번호 등록 수정 검색 전체출력
		//Map을 사용하여 관리
		//1. 전번등록
		//2. 전번수정
		//3. 전번 삭제
		//4. 전번 검색
		//5. 전번 전체출력
		//0. 프로그램 종료
		//====================================
		//			    전화번호 프로그램
		
		//===============전화 번호===============
		//번호	이름		전화번호			주소
		//====================================
		// 1	홍길동	010-1111-2222	대전시
		//====================================
		start();
	
	}
	public static void start(){
		int select = 0;
		do{
		System.out.println("====================================");
		System.out.println("			  전화번호 프로그램"			 );
		System.out.println("====================================");
		System.out.println("	1. 전화번호 등록		");
		System.out.println("	2. 전화번호 수정		");
		System.out.println("	3. 전화번호 삭제		");
		System.out.println("	4. 전화번호 검색		");
		System.out.println("	5. 전화번호 출력		");
		System.out.println("	0. 프로그램 종료		");
		System.out.println("====================================");
		
		select = Integer.parseInt(scan.nextLine());
			
		logicStart(select);
			
			
		}while(select!=0);
	}
	
	
	private static void addPhone(){
		System.out.println("등록하실 사용자 이름을 입력하여 주십시요.");
		String name = scan.nextLine();
		System.out.println("등록하실 사용자 번호를 입력하여 주십시요.");
		String phone = scan.nextLine();
		System.out.println("등록하실 사용자의 사는 지역을 입력하여 주십시요.");
		String addr = scan.nextLine();
		map.put(name, new UserPhoneVo(name,phone,addr));
		System.out.println("등록 되었습니다.");
	}
	private static void showAll(int mode){
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		int count = 0;
		UserPhoneVo uvo = null;
		String selectName = null;
		ArrayList<String> array = new ArrayList<>();
		while(it.hasNext()){
			++count;
			uvo = map.get(it.next());
			System.out.println(count + ". " + uvo.getName() +"\t"+uvo.getPhone()+"\t"+uvo.getAddr() );
			array.add(uvo.getName());
		}
		//이터레이터를 사용하고나면 다시 만들어야 한다.
		switch (mode) {
		case 5:
			
			break;
		case 2:
			System.out.println("수정하실 순서번호를 입력해주세요.");
			int select = Integer.parseInt(scan.nextLine())-1;
			System.out.println("수정하실 전화번호를 입력해 주세요.");
			String rePhone = scan.nextLine();
			System.out.println("수정하실 지역을 입력해 주세요.");
			String reAddr = scan.nextLine();
			map.put(array.get(select), new UserPhoneVo(array.get(select),rePhone,reAddr));
			System.out.println("수정이 완료 되었습니다.");	
			break;
		case 3:
			System.out.println("삭제하실 사용자의 순서번호를 입력해주세요.");
			select = Integer.parseInt(scan.nextLine())-1;
			map.remove(array.get(select));
			System.out.println("수정이 완료되었습니다.");
			break;
		case 4:
			System.out.println("사용자의 이름을 입력해 주세요.");
			String name =scan.nextLine();
			UserPhoneVo uvo2 = map.get(name);
			System.out.println("입력하신 사용자의 폰 번호는 : " + uvo.getPhone() + " 입니다.");	
			
			break;

		default:
			break;
		}
	}
	static void logicStart(int select){
		switch (select) {
		case 1:	//전번 등록
			addPhone();
			break;
		case 2:	//전번 수정
			showAll(2);
			break;
		case 3:	//전번 삭제
			showAll(3);
			break;
		case 4:	//전번 검색
			showAll(4);
			break;
		case 5:	//전체 출력
			showAll(5);
			break;
		default:
			break;
		}
		
	}
}


class UserPhoneVo{
	String name;
	String phone;
	String addr;
	
	public UserPhoneVo(String name, String phone, String addr) {
		super();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
