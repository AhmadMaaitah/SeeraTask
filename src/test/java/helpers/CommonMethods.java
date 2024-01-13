package helpers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.ReaderUtility;

public class CommonMethods {

	public String getValueFromResponseBody(String response, String key) {

		JsonPath js = new JsonPath(response);
		return js.getString(key);
	}

	public static void setURL() {

		RestAssured.baseURI = ReaderUtility.dataReader("url");
	}
}
