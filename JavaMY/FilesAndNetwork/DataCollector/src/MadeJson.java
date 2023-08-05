
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.ConcurrentModificationException;

public class MadeJson {

    public static String nameStationJson;
    public  static String nameLineJson;
    public  static String dateJson;
    public  static float depthJson;
    public static boolean hasConnectionJson;

    public static void createJsonFile() throws IOException {

        StringBuilder info = new StringBuilder("{\n\t\"stations\": [\n");
        ParsingWeb.listStationsHTML.forEach(el -> {
            nameStationJson = el.getNameStation();
            info.append("\t\t{\n\t\t\t\"name\": \"").append(nameStationJson).append("\",");
            nameLineJson = el.getNumberLine();

            ParsingWeb.linesListHTML.forEach(line -> {
                if(nameLineJson.equals(line.getNumberLine())){
                    nameLineJson = line.getNameLine();
                }
            });
            info.append("\n\t\t\t\"line\": \"").append(nameLineJson).append("\",");

            ParsingCSV.listCSV.forEach(da -> {
                if(nameStationJson.equals(da.getName())&& dateJson != da.getDateBuild()){
                    dateJson = da.getDateBuild();
                }
            });
            info.append("\n\t\t\t\"date\": \"").append(dateJson).append("\",");

            ParsingJSON.stationsWithDepthList.forEach(de ->{
                if(nameStationJson.equals(de.getName())){
                    depthJson = de.getDepth();
                }

            });
            info.append("\n\t\t\t\"depth\": \"").append(depthJson).append("\",");
            depthJson = 0;
            hasConnectionJson = el.isHasConnection();
            info.append("\n\t\t\t\"hasConnection\": \"").append(hasConnectionJson).append("\"\n\t\t},\n");

        });
        info.delete(info.length()- 2, info.length() - 1);
        info.append("\t]\n}");
        try {
            Files.write(Paths.get("data\\stations.json"), Collections.singleton(info));
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}


