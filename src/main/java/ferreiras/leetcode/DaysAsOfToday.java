package ferreiras.leetcode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DaysAsOfToday {

  private static final String DATE_FORMAT = "dd/MM/yyyy";
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

  public static void main(String[] args) {

    String firstDay = "01/01/2024";
    String currentDay = LocalDateTime.now().format(formatter);
    int response = getDaysOfDifference(firstDay, currentDay);
    System.out.println("Day " + response + " of 365");
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
