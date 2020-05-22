package julian.solution;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class NordstromSuite {
    @Test
    public void collectionTest() {
/*
Verifique si el siguiente snippet presenta alguna excepción (compile or runtime)
En caso afirmativo, corríjalo.
*/
        List<String> c = new ArrayList<String>();

        for(int i=0; i<10; i++){
            c.add("a");
            c.add("b");
            c.add("c");
        }
        /*for(String s: c){
            if(s.equals("a")){
                c.remove(s);
            }
        }*/
        c = c.stream().filter(x -> !x.equals("a"))
                .collect(Collectors.toList());
        c.forEach(System.out::print);
    }

    @Test
    public void sortTest() {
/*
Ordene la colección logs de acuerdo al tipo de log (WARN, ERROR o INFO) y
por cada tipo de log ordene sus logs en forma ascendente por el id del log.
Las entradas del log son de la forma
logId-logType-logDetail
*/
        class Sorter{
            public List<String> sort(List<String> logEntries){
                List<Log> tempLog = new LinkedList<>();
                for (String logEntry : logEntries) {
                    String [] tokens = logEntry.split("-");
                    Log log = new Log(tokens[0], tokens[1], tokens[2]);
                    tempLog.add(log);
                }

                Comparator<Log> logComparator = Comparator.comparing(Log::getType)
                        .thenComparing(Comparator.comparing(Log::getId));
                return tempLog.stream()
                       .sorted(logComparator)
                       .map(log -> log.id +"-" +log.type+ "-" +log.message)
                       .collect(Collectors.toList());
            }

            class Log{
                String id;
                String type;
                String message;

                public Log(String id, String type, String message) {
                    this.id = id; this.type = type; this.message = message;
                }

                public String getId() {
                    return id;
                }

                public String getType() {
                    return type;
                }
            }
        }
        List<String> logs;
        logs = new ArrayList<>();
        logs.add("101-WARN-asdasdasas");
        logs.add("200-ERROR-asdasdasas");
        logs.add("100-WARN-asdasdasas");
        logs.add("302-INFO-asdasdasas");
        logs.add("201-ERROR-asdasdasas");
        logs.add("303-INFO-asdasdasas");
        logs.add("304-INFO-asdasdasas");
        List<String> sortedlogs = new ArrayList<>();
        sortedlogs.add("200-ERROR-asdasdasas");
        sortedlogs.add("201-ERROR-asdasdasas");
        sortedlogs.add("302-INFO-asdasdasas");
        sortedlogs.add("303-INFO-asdasdasas");
        sortedlogs.add("304-INFO-asdasdasas");
        sortedlogs.add("100-WARN-asdasdasas");
        sortedlogs.add("101-WARN-asdasdasas");
        Sorter s = new Sorter();
        List<String> newList = s.sort(logs);
        assertEquals(newList, sortedlogs);
    }

}
