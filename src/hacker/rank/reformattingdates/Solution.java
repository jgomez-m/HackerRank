package hacker.rank.reformattingdates;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'reformatDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */

    static{
        final Map<String, String> DAYS = new HashMap<>();

    }


    public static List<String> reformatDate(List<String> dates)
    {
        List<String> result = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM", Locale.ENGLISH);
        for(String date : dates){
            String[] tokens = date.split(" ");
            int day=0;
            try
            {
                day = Integer.parseInt(tokens[0].substring(0, 2));
            }catch (NumberFormatException e){
                day = Integer.parseInt(tokens[0].substring(0, 1));
            }
            int year = Integer.parseInt(tokens[2]);
            Date monthDate = null;
            try
            {
                monthDate = dateFormat.parse(tokens[1]);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            cal.setTime(monthDate);
            int month = cal.get(Calendar.MONTH);
            result.add(LocalDate.of(year,month+1, day).toString());

        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.reformatDate(dates);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
