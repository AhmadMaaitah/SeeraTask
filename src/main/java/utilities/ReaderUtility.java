package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReaderUtility {

	public static String dataReader(String parsedValue) {

		FileReader reader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "java" + File.separator + "testData" + File.separator + "data.properties");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String value = p.getProperty(parsedValue);
		return value;
	}

}
