package quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	
	static Scanner scan = new Scanner(System.in);
	static HashMap<Integer,Room> map = new HashMap<>();
	public static void main(String[] args) {
		makeRoomDB();
		start();
	}
	private static void makeRoomDB(){
		int[] singleR = {201,202,203,204,205,206,207,208,209};
		int[] doubleR = {301,302,303,304,305,306,307,308,309};
		int[] sweetR = {401,402,403,404,405,406,407,408,409};
		
		for(int i = 0; i<singleR.length;i++){
			map.put(singleR[i],new Room(singleR[i],"싱글룸","-"));
			map.put(doubleR[i],new Room(doubleR[i],"더블룸","-"));
			map.put(sweetR[i],new Room(sweetR[i],"스위트룸","-"));
		}
	}
	
	
	private static void start(){
		System.out.println("***********************************");
		System.out.println("		어서들와 이런호텔 처음이지?");
		System.out.println("***********************************");
		int select =0;
		do{
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("어떤 임무를 하시겠습니까?");
		System.out.println("1. 체크인\t2. 체크아웃\t3. 객실상태\t4. 업무종료");
		System.out.println("----------------------------------------------------------");
		select = Integer.parseInt(scan.nextLine());
		
		switch (select) {
		case 1:		//체크인
			checkIn();
			break;
		case 2:		//체크아웃
			checkOut();
			break;
		case 3:		//객실상태
			showAllRoom();
			break;
		case 4:		//업무종료
			System.out.println("업무를 마감합니다.");
			System.exit(0);
			break;

		default:
			break;
		}
		}while(select !=4);
	}
	
	
	//체크인
	private static void checkIn(){
		System.out.println("-------------------------------------");
		System.out.println("	체크인을 선택하셨습니다.");
		System.out.println("-------------------------------------");
		System.out.println("	201~209: 싱글룸");
		System.out.println("	301~309: 더블룸");
		System.out.println("	401~409: 스위트룸");
		System.out.println("-------------------------------------");
		System.out.print("방번호 입력 >>");
		int sNum = Integer.parseInt(scan.nextLine());
		
		Set set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			if(it.next().equals(sNum)){
				Room r = map.get(sNum);
				if(!r.getName().equals("-")){
					System.out.println("이미 빌려져 있는 방입니다.");
					break;
				}else{
					int type = 0;
					if(sNum>=201&&sNum<=209){
						//싱글룸
						type = 1;
					}else if(sNum>=301&&sNum<=309){
						//더블룸
						type = 2;
					}else if(sNum>=401&&sNum<=409){
						//스위트
						type = 3;
					}else{
						System.out.println("선택하신  " + sNum + "호 는 존재하지 않습니다.");
						return;
					}
					getGuestInfo(sNum,type);
					break;
				}		
			}
		}			
	}
	private static void getGuestInfo(int sNum,int type){
		System.out.println("누구를 체크인 하시겠습니까>");
		System.out.print("이름입력>>");
		String name = scan.nextLine();
		
		
		switch(type){
		case 1:
			map.put(sNum, new Room(sNum,"싱글룸",name));
			break;
		case 2:
			map.put(sNum, new Room(sNum,"더블룸",name));
			break;
		case 3:
			map.put(sNum, new Room(sNum,"스위트룸",name));
			break;
		}
		System.out.println("체크인 되었습니다.");
	}
	
	private static void checkOut(){
		System.out.println("체크아웃할 방 번호를 입력해주세요.");
		System.out.print("방번호 입력>>");
		int select = Integer.parseInt(scan.nextLine());
		
		Room r = map.get(select);
		if(r.getName().equals("-")){
			System.out.println(select + "객실에는 체크인 한 사람이 없습니다.");
		}else{
			System.out.println(r.getName()+ "님이 체크아웃 되셨습니다.");
			map.put(select, new Room(select,r.getType(),"-"));
		}
	}
	private static void showAllRoom(){
		System.out.println("-------------------------");
		System.out.println("       현재 객실 상태");
		System.out.println("-------------------------");
		System.out.println("방번호 	방종류	투숙객");
		Set set = map.keySet();
		Iterator it = set.iterator();
		ArrayList<Integer> array = new ArrayList<>();
		while(it.hasNext()){
			int rNum = (int) it.next();
			array.add(rNum);
		}
		Collections.sort(array);
		for(int i = 0; i<array.size(); i++){
			Room room = map.get(array.get(i));
			System.out.println(room.getrNum() + "	" +
							   room.getType() + "	" + 
							   room.getName());
		}
		System.out.println("-------------------------");
	}
}


class Room{
	int rNum;
	String type,name;
	
	public Room() {
		super();
	}

	public Room(int rNum, String type, String name) {
		
		this.rNum = rNum;
		this.type = type;
		this.name = name;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}



