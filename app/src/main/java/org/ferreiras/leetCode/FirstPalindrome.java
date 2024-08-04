package org.ferreiras.leetCode;

/**
 * Given an array of strings words, return the first palindromic string in the array.
 * If there is no such string, return an empty string "".
 * A string is palindromic if it reads the same forward and backward.
 * Example 1:
 * Input: words = ["abc","car","ada","racecar","cool"]
 * Output: "ada"
 * Explanation: The first string that is palindromic is "ada".
 * Note that "racecar" is also palindromic, but it is not the first.
 * Example 2:
 * Input: words = ["notapalindrome","racecar"]
 * Output: "racecar"
 * Explanation: The first and only string that is palindromic is "racecar".
 * Example 3:
 * Input: words = ["def","ghi"]
 * Output: ""
 * Explanation: There are no palindromic strings, so the empty string is returned.
 */
public class FirstPalindrome {

  public static void main(String[] args) {
    String[] strings = {"juvqplevqxlygbgrihwflckldfgat",  "gaeikijatvedsuihfzenwejsovrxetddktgdmdeybnvlrirwcghzmhbgiqmuuhbwacpftlduhdpsszmtpjqllew", "ieiumffubnnkbtpknbjmanqlu", "tavebizzdxstfci", "mdycitestkcpy", "ievmjsoafwculanigmwnjosdxgkgwmdzaqjderlliradiqliceggxvskjxukzgdltaoyabyrdsv", "iyzfehpsqkwruflcxtcvhhuhnrmtderuyouexdwyqyodokzmvlnqldcgwvudwnudmdxb", "tsntppdouosbwratzdmioddvuciubtawfxjvnyqjqlgbgvxpcdfjpvyelndzwukrqdwjkxsquueeauffnak", "bfjjgfdrhcddsoaufx", "zlponyvawkgjnctolepsawpityyckfozisprehmlywxlbulndexjuxglzdojtfhrjrjz", "xjjonbimyarmqzezrvwnvqgiedcvszzwjtctornddkjmayzsnpjxvmflrznknwxoyplwfnbszicxrzaax", "wuphyqzlvwxkgyjvtwwddsyhhiylvysszuybpozvtmwzooowpnwiilgsqhfwmyumzlsolrrexifqo", "eitbfwbyignfoxadlenanltstogctowdhducayqocj", "hobh", "exrrxprbtdbnrnyefqbzonpnbhxulqdbmwvk", "ykuwndqknuuczgaehmeacoydhcoxodfayprapedycppskgornvdnmxfhesjqkoeakte", "tpogeotqnlkig", "kndgyjmhpbasptupvlnybmrgvhqmezyaszmxihcjohphlzlrtmbogxazptqvlml", "crbutenwb", "bgb", "rbvmnothuvqetzkwqdmsepq", "mwwkcvecy", "eyprdzprevgyrirhnqrwsel"};
    String response = firstPalindrome(strings);
    System.out.println(response);
  }

  public static String firstPalindrome(String[] words) {

    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      char[] c = word.toCharArray();
      int sizeOfWord = c.length;
      if (sizeOfWord == 1)
        return word;
      int j = sizeOfWord - 1;
      for (int i = 0; i < sizeOfWord; i++) {
        if (c[i] == c[j]) {
          sb.append(c[i]);
          j--;
        } else {
          break;
        }

      }
      if (sb.toString().length() == word.length())
        return word;
    }
    return "";
  }
  public String firstPalindromes(String[] words) {
    for (String word : words) {
      StringBuilder reverse = new StringBuilder(word).reverse();
      if (word.equals(reverse.toString())) {
        return word;
      }
    }
    return "";
  }
  public String firstOcurrencePalindrome(String[] words) {
    for (String word : words) {
      if (helper(word)) {
        return word;
      }
    }
    return "";
  }

  public boolean helper(String s) {
    int beg = 0, end = s.length() - 1;
    while (beg <= end) {
      if (s.charAt(beg) == s.charAt(end)) {
        beg++;
        end--;
      } else {
        return false;
      }
    }
    return true;
  }
}
