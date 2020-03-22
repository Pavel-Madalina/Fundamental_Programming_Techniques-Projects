package data_layer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterClass {
	public void write(String fileName, String data) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(data);
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
