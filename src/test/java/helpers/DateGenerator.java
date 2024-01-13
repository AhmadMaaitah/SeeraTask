package helpers;

import org.testng.internal.collections.Pair;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DateGenerator {

	LocalDateTime fromDate = null;
	LocalDateTime toDate = null;
	LocalDateTime randomFuturedate1;
	LocalDateTime randomFuturedate2;
	Random randomDays = ThreadLocalRandom.current();
	String stringFromDate;
	String stringToDate;

	public Pair<String, String> getTwoRandomDates() {

		do {

			randomFuturedate1 = LocalDateTime.now().plusDays(randomDays.nextInt(365) + 1);
			randomFuturedate2 = LocalDateTime.now().plusDays(randomDays.nextInt(365) + 1);
		}

		while (randomFuturedate1 == null || randomFuturedate2 == null);

		if (randomFuturedate1.isBefore(randomFuturedate2)) {

			fromDate = randomFuturedate1;
			toDate = randomFuturedate2;

		} else {

			toDate = randomFuturedate1;
			fromDate = randomFuturedate2;
		}

		stringFromDate = dateFormatter(fromDate, "yyyy-MM-dd");
		stringToDate = dateFormatter(toDate, "yyyy-MM-dd");

		return new Pair<String, String>(stringFromDate, stringToDate);
	}

	public Pair<String, String> getTwoRandomConsecutiveDates() {

		do {
			randomFuturedate1 = LocalDateTime.now().plusDays(randomDays.nextInt(365) + 1);
			randomFuturedate2 = randomFuturedate1.plusDays(1);
		}

		while (randomFuturedate1 == null || randomFuturedate2 == null);

		stringFromDate = dateFormatter(randomFuturedate1, "yyyy-MM-dd");
		stringToDate = dateFormatter(randomFuturedate2, "yyyy-MM-dd");

		return new Pair<String, String>(stringFromDate, stringToDate);
	}

	public static String dateFormatter(LocalDateTime date, String format) {

		String formattedDate = date.format(DateTimeFormatter.ofPattern(format)).toString();
		return formattedDate;
	}
}
