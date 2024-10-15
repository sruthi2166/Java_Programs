package pack1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class TC0011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Instant CurrentTime = Instant.now();
		
		LocalDate now = LocalDate.now();
		
		System.out.println("Current time is:"+CurrentTime);
		
		System.out.println("Today:"+now);
		
		System.out.println("Tomorrow:"+now.plusDays(1));
		
		System.out.println("Yesterday:"+now.minusDays(1));
		
		System.out.println("Last Month:"+now.minusMonths(1));
		
		System.out.println("LeapYear?:"+now.isLeapYear());
		
		System.out.println("Move of 30th day of the month:"+now.withDayOfMonth(30));
		
		System.out.println("Training end date"+now.plusDays(48));
		
ZonedDateTime CT = ZonedDateTime.now();
		
		ZonedDateTime CT_paris=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		
		System.out.println("Current time is:"+CT);
		
		System.out.println("Current time in paris is:"+CT_paris);
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		
		LocalDate now1 = LocalDate.now();
		
		System.out.println("current time is:"+CurrentTime);
		
		
		LocalDate Start = LocalDate.of(1947,Month.AUGUST, 15);
		LocalDate end=LocalDate.now();
		Period period=Start.until(end);
		System.out.println("Days:"+period.get(ChronoUnit.DAYS));
		
		System.out.println("Months:"+period.get(ChronoUnit.MONTHS));
		
		System.out.println("Years:"+period.get(ChronoUnit.YEARS));
		
		
		

	}

}
