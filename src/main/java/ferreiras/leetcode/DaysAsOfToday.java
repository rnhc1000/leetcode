package ferreiras.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DaysAsOfToday {

  private static final String DATE_FORMAT = "dd/MM/yyyy";
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
  private static final Logger logger = LoggerFactory.getLogger(DaysAsOfToday.class);

  public static void main(String[] args) {

    String firstDay = "01/01/2024";
    String currentDay = LocalDateTime.now().format(formatter);
    int response = getDaysOfDifference(firstDay, currentDay);
    logger.info("Day {} of 365", response);
  }

  public static int getYearsOfDifference(String start, String end) {

    int firstDay = LocalDate.parse(start, formatter).getYear();
    int currentDay = LocalDate.parse(end, formatter).getYear();

    return currentDay - firstDay;
  }

  public static int getDaysOfDifference(String start, String end) {

    int firstDay = LocalDate.parse(start, formatter).getDayOfYear();
    int currentDay = LocalDate.parse(end, formatter).getDayOfYear();

    return currentDay - firstDay;
  }
}
