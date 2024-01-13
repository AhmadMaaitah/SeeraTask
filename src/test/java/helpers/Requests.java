package helpers;

import io.restassured.response.Response;
import org.testng.internal.collections.Pair;
import utilities.Payloads;
import utilities.ReaderUtility;

import static io.restassured.RestAssured.given;

public class Requests {

	Response response;
	DateGenerator datehelper = new DateGenerator();
	Pair<String, String> randomDatePairs = datehelper.getTwoRandomDates();
	Pair<String, String> randomConsecutiveDatePairs = datehelper.getTwoRandomConsecutiveDates();
	Payloads payloads = new Payloads();

	public Response getFlightsApi() {

		return response = given().when().log().all()
				.queryParam("query",
						ReaderUtility.dataReader("expectedOriginID") + "-" + ReaderUtility.dataReader("expectedDestinationID")
								+ "/" + randomDatePairs.first() + "/" + randomDatePairs.second() + "/"
								+ ReaderUtility.dataReader("cabinType") + "/" + ReaderUtility.dataReader("passengers"))
				.get(ReaderUtility.dataReader("searchFlightsApiResource"));
	}

	public Response postChaletsSearchApi() {

		return response = given().log().all().header("content-type", ReaderUtility.dataReader("contentType"))
				.header("token", ReaderUtility.dataReader("token")).header("accept", ReaderUtility.dataReader("accept"))
				.body(payloads.postChaletsSearchRequestBodyApi(randomConsecutiveDatePairs.first(),
						randomConsecutiveDatePairs.second()))
				.when().post(ReaderUtility.dataReader("searchChaletsApiResoure"));
	}
}
