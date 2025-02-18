import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile="ninja_events.xml";
        String outputFile="result.xml";

        LogReader logReader=new LogReader(inputFile,outputFile);

        List<NinjaLog> ninjaLogs=logReader.parse(inputFile);
        ninjaLogs.forEach(System.out::println);


        System.out.println("Jonin");
        ninjaLogs.stream().filter(ninjaLog -> ninjaLog.getRank()==Rank.Jonin).sorted(Comparator.comparing(NinjaLog::getDate))
                .map(NinjaLog::getName).forEach(System.out::println);

    }
}