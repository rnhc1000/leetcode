package ferreiras.leetcode;

import java.util.Arrays;



/*
You are given a 0-indexed array of strings details.
Each element of details provides information about a given passenger compressed
into a string of length 15.
The system is such that:

The first ten characters consist of the phone number of passengers.
The next character denotes the gender of the person.
The following two characters are used to indicate the age of the person.
The last two characters determine the seat allotted to that person.
Return the number of passengers who are strictly more than 60 years old.



Example 1:

Input: details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
Output: 2
Explanation: The passengers at indices 0, 1, and 2 have ages 75, 92, and 40. Thus, there are 2 people who are over 60 years old.
Example 2:

Input: details = ["1313579440F2036","2921522980M5644"]
Output: 0
Explanation: None of the passengers are older than 60.


Constraints:

1 <= details.length <= 100
details[i].length == 15
details[i] consists of digits from '0' to '9'.
details[i][10] is either 'M' or 'F' or 'O'.
The phone numbers and seat numbers of the passengers are distinct.

 */
public class ArrayCountSeniors {
  public static void main(String[] args) {
    String [] details = {
            "7868190130M7522",
            "5303914400F9211",
            "9273338290F4010"
    };

    int response = countSeniors(details);
    System.out.println(response);

  }

  public static int countSeniors(String[] details) {
/*
details = ["7868190130M7522","5303914400F9211","9273338290F4010"
The first ten characters consist of the phone number of passengers.
The next character denotes the gender of the person.
The following two characters are used to indicate the age of the person.
The last two characters determine the seat allotted to that person.
Return the number of passengers who are strictly more than 60 years old.
 */

//    String[] numbers = new String[details.length];
//    String[] genre = new String[details.length];
    int[] age = new int[details.length];

    for (int i = 0 ; i < details.length; i++) {

//      numbers[i] = details[i].substring(0,10);
//      genre[i] = details[i].substring(10,11);
      age[i] = Integer.parseInt(details[i].substring(11,13));
    }



    System.out.println(Arrays.toString(age));
    long count = Arrays.stream(age).filter(x -> x > 60).map((x) -> x).count();
    return (int)count;
  }
}
