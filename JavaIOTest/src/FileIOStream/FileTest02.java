package FileIOStream;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest02 {
//	디렉토리 (폴더) 만들기
//	1.mkdir()	: File 객체의 경로 중 제일 마지막 위치의 디렉토리를 만든다
//	 			- 반환값 : (만들기 성공 : true, 만들기 실패 : false)
//				- 중간의 경로가 모두 미리 만들어져 있어야 마지막 위치의 디렉토리를 만들 수 있다.
//	
//	2.mkdirs()	: 중간의 경로가 없으면 중간의 경로도 새롭게 만든다.
//
//	3.exists()  : File 객체에 지정한 '파일'이나'폴더'가 존재하면 true, 그렇지 않으면 false
//	
//	4.isFile()	: file 인지 아닌지 boolean값 반환.	
//	
//	5.isDirectory : 디렉토리인지 아닌지 boolean값 반환.
//		
//		
//		
//	
	public static void main(String[] args) {
	
		//만들기
		File file  = new File("d:/d_other/연습용");
		File file2 = new File("d:/d_other/src");	//mkdir()은 전체 경로중 맨끝의 폴더를 만든다.
		File file3 = new File("d:/d_other/java/test2.txt");
		File file4 = new File("./src");
		System.out.println(file3.getAbsolutePath());
		if(file.mkdir()){
			System.out.println(file.getName() + " 만들기 성공");
		}else{
			System.out.println(file.getName() + " 만들기 실패");
		}
		try {
			file3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(file2.mkdirs()){
			System.out.println(file2.getName() + " 만들기 성공");
		}else{
			System.out.println(file2.getName() + " 만들기 실패");
		}
		//존재유무확인
		if(file.exists()){
			System.out.println(file.getName() + " 은 이미 존재한다 불련아");
		}
		//삭제하기
		if(file.exists()){
//			file.delete();
		}else{
			System.out.println(file.getName() + "은 지울수가 없단다 왜냐면 없으니까 씨불련아");
		}
		System.out.println();
		
		System.out.println("file3 의 getPath : "			+ file3.getPath());
		System.out.println("file3 의 getAbsolutePath : "	+ file3.getAbsolutePath());
		System.out.println();
		System.out.println("file4 의 getPath : "			+ file4.getPath());
		System.out.println("file4 의 getAbsolutePath : "	+ file4.getAbsolutePath());
		
		if(file3.isFile()){
			System.out.println("파일이다.");
		}else{
			System.out.println("파일 아니다");
			
		}
		if(file4.isDirectory()){
			System.out.println("디렉토리(폴더)다.");
		}else{
			System.out.println("디렉토리(폴더)아니다.");
		}
		
		File file5 = new File("d:/d_other");
		
		displayFileList(file5);
		
		
	}
	
	public static void displayFileList(File dir){
		if(!dir.isDirectory()){
			System.out.println(dir.getPath() + " 는 디렉토리(폴더)가 아니다 불련아.");
			return;
		}
		System.out.println("[" + dir.getAbsolutePath() + "] 디랙토리 내용");
		File[] files = dir.listFiles();
//		String[] strFiles = dir.list();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for(int i = 0;i<files.length; i++){
			String fileName = files[i].getName();
			String attr = "";	//파일의 속성(읽기,쓰기,히든,디렉토리 구분)
			String size = "";
			if(files[i].isDirectory()){
				attr = "<DIR>";
			}else{
				attr = String.valueOf(files[i].length());
				attr += files[i].canRead()?"R":" ";
				attr += files[i].canWrite()?"W":" ";
				attr += files[i].isHidden()?"H":" ";
				
			}
			System.out.printf("%s %5s %12s %s\n",df.format(new Date(files[i].lastModified())),attr,size,fileName);
			
			
		}
	}
	
	
}
