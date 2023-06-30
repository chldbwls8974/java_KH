package day23.stream;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) {
		File file = new File("test");
		try {
			// 해당 파일/폴더가 존재하지 ㅏㄶ고 확장자가 존재하면
			if(!file.exists()&& file.getName().contains(".")) {
				file.createNewFile();
				System.out.println("create file");
			}
			
			if(!file.exists()&& !file.getName().contains(".") ) {
				file.mkdir();
				System.out.println("create direc");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//file.delete();
	}

}
