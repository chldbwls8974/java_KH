package day23.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIOStreamEx {

	public static void main(String[] args) {

		// ���� ������ �о���� ����
		try(FileReader fr = new FileReader("file.txt")){
			char buffer[] = new char[1024];
			
			while(fr.read(buffer) != -1) {
				System.out.print(buffer);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("exception");
		}
		
		
		// ���� ������ ���� ������
		// filewriter��������( ���ϸ�, �̾�� ����) >> true �Է½� �ڵ� ������������
		// >> �̾�� ���ΰ�  true�̸� �̾ �ۼ�
		try(FileWriter fw = new FileWriter("file.txt", true)){
			String str ="Hello World!\n";
			fw.write(97);
			String str2 = "Hi, javja\n";
			fw.write(100);
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

}
