package helpers;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import utilities.ReaderUtility;

public class Assertions {

	CommonMethods reusableCommonMethods = new CommonMethods();
	Requests requests = new Requests();
	String stringResponse;
	ValidatableResponse objectResponse;

	public void assertGetFlightsApiStatusCodeIsTwoHundred() {

		requests.getFlightsApi().then().log().all().statusCode(200);
	}

	public void assertGetFlightsApiResponseBodyNid() {

		stringResponse = requests.getFlightsApi().then().log().all().extract().asString();

		String nid = reusableCommonMethods.getValueFromResponseBody(stringResponse, "next.nid");

		Assert.assertNotNull(nid);
	}

	public void assertGetFlightsApiResponseBodyDestinations() {

		stringResponse = requests.getFlightsApi().then().log().all().extract().asString();

		String actualOriginId = reusableCommonMethods.getValueFromResponseBody(stringResponse, "request.leg[0].originId");
		String actualDestinationId = reusableCommonMethods.getValueFromResponseBody(stringResponse,
				"request.leg[0].destinationId");

		Assert.assertEquals(ReaderUtility.dataReader("expectedOriginID"), actualOriginId);
		Assert.assertEquals(ReaderUtility.dataReader("expectedDestinationID"), actualDestinationId);
	}

	public void assertSearchChaletsApiStatusCodeIsTwoHundred() {

		objectResponse = requests.postChaletsSearchApi().then().assertThat().statusCode(200);
	}

	public void assertSearchChaletsApiSearchId() {

		stringResponse = requests.postChaletsSearchApi().then().log().all().extract().asString();
		String searchId = reusableCommonMethods.getValueFromResponseBody(stringResponse, "searchId");
		Assert.assertNotNull(searchId);

		String searchIdExpiry = reusableCommonMethods.getValueFromResponseBody(stringResponse, "searchIdExpiry");
		Assert.assertNotNull(searchIdExpiry);
	}

	public void assertSearchChaletsApiCheckInCheckOut() {

		stringResponse = requests.postChaletsSearchApi().then().log().all().extract().asString();

		String checkIn = reusableCommonMethods.getValueFromResponseBody(stringResponse, "checkIn");
		Assert.assertNotNull(checkIn);

		String checkOut = reusableCommonMethods.getValueFromResponseBody(stringResponse, "checkOut");
		Assert.assertNotNull(checkOut);
	}
}
