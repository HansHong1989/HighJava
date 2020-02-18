package FileIOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	//sss
	public static void main(String[] args) throws IOException {
		
		File file = new File("d:/d_other/out.txt");
		
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileOutputStream output = new FileOutputStream(file);
		
		for(char ch = 'A'; ch<='Z'; ch++){
			output.write(ch);
		}
		output.close();
		
		
		FileInputStream input = new FileInputStream(file);
		int r;
		while((r = input.read())!=-1){
			System.out.print((char)r);
		}
		input.close();
		
		
		
		
		
		
		
		
		
	}
}
