package tests;

import helpers.CommonMethods;
import helpers.Assertions;
import org.testng.annotations.Test;

public class ChaletsTests {

	Assertions assertions = new Assertions();

	@Test(priority = 1)
	public void postSearchChaletsApiStatusCodeTest() {

		CommonMethods.setURL();
		assertions.assertSearchChaletsApiStatusCodeIsTwoHundred();
	}

	@Test(priority = 2)
	public void postSearchChaletsApiResponseBodyTest_SearchId() {

		CommonMethods.setURL();
		assertions.assertSearchChaletsApiSearchId();
	}

	@Test(priority = 3)
	public void postSearchChaletsApiResponseBodyTest_Dates() {

		CommonMethods.setURL();
		assertions.assertSearchChaletsApiCheckInCheckOut();
	}
}
