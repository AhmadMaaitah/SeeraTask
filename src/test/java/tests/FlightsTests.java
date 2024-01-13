package tests;

import helpers.CommonMethods;
import helpers.Assertions;
import org.testng.annotations.Test;

public class FlightsTests {

	Assertions assertions = new Assertions();

	@Test
	public void getFlightApiStatusCodeTest() {

		CommonMethods.setURL();
		assertions.assertGetFlightsApiStatusCodeIsTwoHundred();
	}

	@Test
	public void getFlightApiResponseBodyTest_Nid() {

		CommonMethods.setURL();
		assertions.assertGetFlightsApiResponseBodyNid();
	}

	@Test
	public void getFlightApiResponseBodyTest_Destinations() {

		CommonMethods.setURL();
		assertions.assertGetFlightsApiResponseBodyDestinations();
	}
}
