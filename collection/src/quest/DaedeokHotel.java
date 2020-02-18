package quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaedeokHotel {
	private Map<Integer,HotelRoom> myHotel = new HashMap<Integer,HotelRoom>();
	Scanner scan = new Scanner(System.in);
	
	//생성자 --> 방번호와 종류 초기화 작업 수행
	public DaedeokHotel(){
		//객실 초기화
		for(int i = 2; i<=4; i++){
				String roomType = null;
				switch (i) {
				case 2:roomType = "싱글룸";break;
				case 3:roomType = "더블룸";break;
				case 4:roomType = "스위트룸";break;
				default:break;
				}
			for(int j = 1; j<=9; j++){
				int roomNumber = i*100 + j;	//방번호 만들기
				HotelRoom r = new HotelRoom(roomNumber,roomType);	//Room객체 생성
				myHotel.put(roomNumber,r);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		DaedeokHotel dh = new DaedeokHotel();
		dh.hotelStart();
		
		
	}
	
	//메뉴 출력 메서드
	
	public int displayMenu(){
		System.out.println();
		System.out.println("-----------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인  2. 체크아웃  3. 객실상태  4. 업무종료");
		System.out.println("-----------------------------------");
		System.out.print("선택>> ");
		int num = scan.nextInt();
		return num;
	}
	
	public void hotelStart(){
		while(true){
			int choice = displayMenu();
			switch (choice) {
			case 1:	checkIn();break;	//체킨
			case 2:	checkOut();break;	//체카
			case 3:	showAll();break;	//리스텁
			case 4: 
				System.out.println("*********************************");
				System.out.println("	업무 종료 되었다. 호텔문 닫았다.");
				System.out.println("*********************************");
				System.out.println("");
				System.exit(0);break;	//죙료우
			default: System.out.println("번호입력이 잘못되었쥬? 다시 입력해야쥬?");break;
			}
		}
	}

	private void showAll() {
		System.out.println("*********************************");
		System.out.println("           현재 객실 상태 ");
		System.out.println("*********************************");
		System.out.println(" 방 번호             방 종류              투숙객 이름       ");
		System.out.println(" 201호              싱글룸                  홍종욱          ");
		System.out.println("---------------------------------- ");
		
		ArrayList<Integer> roomNumList = new ArrayList<>(myHotel.keySet());
		Collections.sort(roomNumList);
		
		for(int roomNum:roomNumList){
			HotelRoom r2 = myHotel.get(roomNum);
			if(r2.getGuestName()!=null){
			System.out.println(" "+roomNum+"      "+r2.getRoomType()+"     "+ r2.getGuestName());
			}else{
			System.out.println(" "+roomNum+"      "+r2.getRoomType()+"     "+ "-");
			}
			
		}
		
	}

	private void checkIn() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("체크인 작업");
		System.out.println("-----------------------------");
		System.out.println("201~209 : 싱글룸");
		System.out.println("301~309 : 더블룸");
		System.out.println("401~409 : 스위트룸");
		System.out.println("-----------------------------");
		
		int roomNum = scan.nextInt();
		// 객실번호가 있는지 여부 검사
		if(!myHotel.containsKey(roomNum)){
			System.out.println("존재하지 않는 방 번호입니다.");
			return;
			
		}
		
		if(myHotel.get(roomNum).getGuestName()!=null){
			System.out.println("손님이 이미 존재합니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까>");
		String name = scan.next();
		
		myHotel.get(roomNum).setGuestName(name);
		
		System.out.println(roomNum + "호 방에 " + name + "님께서 체크인 되셨습니다.");
		
	}
	
	private void checkOut(){
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("-----------------------------");
		System.out.println("체크아웃 할 방 번호를 입력해 주세요.");
		System.out.println("방번호 입력>>");
		
		int roomNum = scan.nextInt();
		
		if(!myHotel.containsKey(roomNum)){
			System.out.println("존재하지 않는 방입니다.");
			return;
		}
		
		if(myHotel.get(roomNum).getGuestName()==null){
			System.out.println("손님이 없는방입니다.");
			return;
		}
		
		myHotel.get(roomNum).setGuestName(null);
		
	}
	
}	

class HotelRoom{
	private int roomNumber;
	private String roomType;
	private String guestName;
	
	public HotelRoom(int roomNumber, String roomType) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
}
