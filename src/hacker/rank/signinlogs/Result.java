package hacker.rank.signinlogs;

import java.util.*;

class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER maxSpan
     */

// EXAMPLE
//    ID  Sign in  Sign out  Time delta
//--  -------  --------  ----------
//    30  99       105       6
//    12  100      120       20
//    20  80       101       21

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        Map<String, UserLog> map = new HashMap<>();
        for (String log: logs) {
            String[] line = log.split(" ");
            String userId = line[0];
            String timestamp = line[1];
            String action = line[2];
            if (!map.containsKey(userId)) map.put(userId, new UserLog());
            if (action.equals("sign-in")) map.get(userId).signin = timestamp;
            if (action.equals("sign-out")) map.get(userId).signout = timestamp;
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, UserLog> entry: map.entrySet()) {
             if(calculateDeltas(entry.getValue().signin, entry.getValue().signout) <= maxSpan) {
                 result.add(entry.getKey());
             }
        }

        Collections.sort(result);
        return result;
    }

    private static Integer calculateDeltas(String signin, String signout) {
        if(signin != null && signout != null) {
            return Integer.parseInt(signout) - Integer.parseInt(signin);
        }
        return Integer.MAX_VALUE;
    }

    static class UserLog {
        String signin;
        String signout;
        UserLog (String signin, String signout) {
            this.signin = signin;
            this.signout = signout;
        }
        UserLog(){

        }
    }

    public static void main(String[] args) {
        List<String> input = List.of("10 1234 sign-in", "10 1254 sign-out",
                "10 1244 sign-in", "10 1285 sign-out",
                "30 99 sign-in", "30 105 sign-out",
                "12 1684342829 sign-in", "12 1684344600 sign-out",
                "45 1684337400 sign-in", "45 1684344600 sign-out");
        List<String> result = Result.processLogs(input, 10);
        System.out.println(result);

    }

}