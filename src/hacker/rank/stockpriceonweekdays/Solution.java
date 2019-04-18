package hacker.rank.stockpriceonweekdays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

class StockPrice{

    String date;
    String open;
    String high;
    String low;
    String close;
}

class ResponseClass {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<StockPrice> data;
}

public class Solution
{
    /*
     * Complete the function below.
     */
    static void openAndClosePrices(String firstDate, String lastDate, String weekDay)
    {
        String[] firstTokens = firstDate.split("-");
        String[] lastTokens = lastDate.split("-");
        String firstYear = firstTokens[2];
        String lastYear = lastTokens[2];
        int iniYear = Integer.parseInt(firstYear);
        int endYear = Integer.parseInt(lastYear);

        for(int i=iniYear ; i <= endYear ;i++) {
            // make request by year
            List<StockPrice> stocks = requestStocks(String.valueOf(i));
            // Validate if each day is equal to 'weekDay'
            stocks.forEach(s -> {
                if(validateDay(weekDay, s.date, firstDate, lastDate)){
                    System.out.println(s.date + " " + s.open + " " + s.close);
                }
            });
        }
    }

    private static List<StockPrice> requestStocks(final String year)
    {
        URL url;
        HttpURLConnection connection = null;
        BufferedReader buffer = null;
        StringBuffer response = new StringBuffer();
        try
        {
            url = new URL("https://jsonmock.hackerrank.com/api/stocks/search?date=" + year);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // GET request
            buffer = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = buffer.readLine()) != null) {
                response.append(inputLine);
            }
            buffer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            connection.disconnect();
        }

        // Process the response and convert to StockPrioe List

        return convertResponse(response.toString());
    }

    private static List<StockPrice> convertResponse(final String response) {
        Gson gson = new GsonBuilder().create();
        ResponseClass responseObj = gson.fromJson(response, ResponseClass.class);
        return responseObj.data;
    }

    private static boolean validateDay(String weekDay, String date, String firstDate, String lastDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        LocalDate currentDate = LocalDate.parse(date, formatter);
        LocalDate localFirstDate = LocalDate.parse(firstDate, formatter);
        LocalDate localLastDate = LocalDate.parse(lastDate, formatter);

        if(currentDate.getDayOfWeek().name().
            equals(weekDay.toUpperCase())
            && currentDate.minusDays(1).
                isBefore(localLastDate)
            && currentDate.plusDays(1).
                isAfter(localFirstDate)
            )
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = in.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }

        String _lastDate;
        try {
            _lastDate = in.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }

        String _weekDay;
        try {
            _weekDay = in.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }

        openAndClosePrices(_firstDate, _lastDate, _weekDay);
    }
}
