
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParsingCSV {
    public static List<StationsFromCSV> listCSV = new ArrayList<>();

    public static void getListFromCsv(String path) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(path));

        for(String pathCSV : strings) {
            if (pathCSV.matches("([\\w]:)?(\\\\[\\w\\d_.-]+)+\\\\?[.csv]")) { //
                List<String> data;
                data = Files.readAllLines(Paths.get(pathCSV));
                data.remove(0);
                List<String> newList = data.stream().distinct().toList();
                newList.forEach(line -> {
                    String[] nameAndData = line.split(",");
                    String name = nameAndData[0];
                    String date = nameAndData[1];
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//                    LocalDate dateBuild = LocalDate.parse(date, formatter);
                    listCSV.add(new StationsFromCSV(name, date));
                });
            }
        }

        System.out.println("listCSV - " + listCSV.size());
        listCSV.sort(Comparator.comparing(StationsFromCSV::getName));
        //listCSV.forEach(System.out::println);
    }
}
