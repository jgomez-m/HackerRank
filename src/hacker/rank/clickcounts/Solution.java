package hacker.rank.clickcounts;

// You are in charge of a display advertising program. Your ads are displayed on websites all over the internet.
// You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain.
// Every line consists of a click count and a domain name, like this:

// counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "20,overflow.com",
//      "2,en.wikipedia.org",
//      "1,m.wikipedia.org",
//      "1,mobile.sports",
//      "1,google.co.uk"]

// Write a function that takes this input as a parameter and returns a data structure containing the number
// of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com"
// counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain.
// So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

// Sample output (in any order/format):

// calculateClicksByDomain(counts)
// 1340    com
//  900    google.com
//   10    stackoverflow.com
//   20    overflow.com
//  410    yahoo.com
//   60    mail.yahoo.com
//   10    mobile.sports.yahoo.com
//   50    sports.yahoo.com
//    3    org
//    3    wikipedia.org
//    2    en.wikipedia.org
//    1    m.wikipedia.org
//    1    mobile.sports
//    1    sports
//    1    uk
//    1    co.uk
//    1    google.co.uk

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] counts = {
            "900,google.com",
            "60,mail.yahoo.com",
            "10,mobile.sports.yahoo.com",
            "40,sports.yahoo.com",
            "300,yahoo.com",
            "10,stackoverflow.com",
            "20,overflow.com",
            "2,en.wikipedia.org",
            "1,m.wikipedia.org",
            "1,mobile.sports",
            "1,google.co.uk"
        };

        Map<String,Integer> result = calculateClicksByDomain(counts);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }

    }

    private static Map<String, Integer> calculateClicksByDomain(String[] counts) {

        Map<String,Integer> inputMap = new HashMap<>();


        for(int i=0; i<counts.length ; i++)
        {
            String[] temp = counts[i].split(",");
            inputMap.put(temp[1], Integer.parseInt(temp[0]));

        }

        Map<String, Integer> outputMap = new HashMap<>();

        for(Map.Entry<String, Integer> entry : inputMap.entrySet())
        {

            String domain = entry.getKey();
            Integer clicks = entry.getValue();

            // Splitting domain
            List<String> subdomains = getSubdomains(domain);

            for(String sub : subdomains)
            {
                if(outputMap.containsKey(sub)){
                    outputMap.put(sub, outputMap.get(sub) + clicks);
                } else {
                    outputMap.put(sub, clicks);
                }
            }

        }

        return outputMap;

    }

    private static List<String> getSubdomains(String domain)
    {
        List<String> result = new ArrayList<>();
        result.add(domain);

        int subdomainIdx = domain.indexOf(".");
        String temp = domain;
        while(subdomainIdx != -1)
        {
            temp = temp.substring(subdomainIdx+1);
            result.add(temp);
            subdomainIdx = temp.indexOf(".");
        }

        return result;
    }

}