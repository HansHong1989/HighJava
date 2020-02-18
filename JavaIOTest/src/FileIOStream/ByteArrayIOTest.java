package FileIOStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data;	//일겅온 자료를 저장할 변수
		
		//더이상 읽어올 자료가 없으면 -1을 반환
		while((data = input.read())!=-1){
			output.write(data);	//읽어온 데이터를 출력하기
		}
		
		outSrc = output.toByteArray();
		
		System.out.println("inSrc : " + Arrays.toString(inSrc));
		System.out.println("outSrc : " + Arrays.toString(outSrc));
		
		input.close();
		output.close();
		
	}
}
