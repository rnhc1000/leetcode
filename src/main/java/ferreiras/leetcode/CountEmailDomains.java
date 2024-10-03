package ferreiras.leetcode;

import java.util.*;

/*
String[] emails = {"foo@a.com", "bar@a.com", "baz@b.com", "qux@d.com"};
String[] domains = {"www.a.com", "www.b.com", "www.c.com", www.d.com"};
 */
public class CountEmailDomains {

  public static void main(String[] args) {
    String[] emails = {"foo@a.com", "bar@a.com", "tezzouro@b.com", "baz@c.com", "qux@d.com"};
    String[] domains = {"www.a.com", "www.b.com", "www.c.com", "www.d.com"};
    Map<String, List<String>> dictionary = mapDomainToEmails(domains, emails);
    Map<String, Integer> count = mapDomainToEmailsAndCount(domains, emails);
    System.out.println(dictionary);
    System.out.println(count);

  }

  public static  Map<String, List<String>>  mapDomainToEmails(String[] domains, String[] emails) {

    Map<String, List<String>> map = new LinkedHashMap<>();
    for (String domain : domains) {
       map.put(domain.substring(domain.indexOf(".") + 1), new ArrayList<>());
    }

    for (String email : emails) {
      String emailDomain = email.substring(email.indexOf("@")+1);

      if (map.containsKey(emailDomain)) {
        map.get(emailDomain).add(email);
      }

    }

    return  map;
  }

  public static  Map<String, Integer>  mapDomainToEmailsAndCount(String[] domains, String[] emails) {

    Map<String, Integer> map = new LinkedHashMap<>();
    for (String domain : domains) {
      map.put(domain.substring(domain.indexOf(".") + 1), 0);
    }

    for (String email : emails) {
      String emailDomain = email.substring(email.indexOf("@")+1);

      if (map.containsKey(emailDomain)) {
        map.put(emailDomain, map.getOrDefault(emailDomain, 0) + 1);
      }

    }

    return  map;
  }
}
