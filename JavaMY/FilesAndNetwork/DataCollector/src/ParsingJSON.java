import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParsingJSON {

    public static List<String> listStationsJSON = new ArrayList<>();
    public static List<StationsFromJson> stationsWithDepthList = new ArrayList<>();

    public static void parserJson(String paths) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(paths));
            for(String path : lines) {
                if (path.matches("([\\w]:)?(\\\\[\\w\\d_.-]+)+\\\\?[.json]")) {
                    List<String> FileJson;
                    StringBuilder builder = new StringBuilder();
                    FileJson = Files.readAllLines(Paths.get(path));
                    JSONParser parser = new JSONParser();
                    FileJson.forEach(builder::append);
                    JSONArray jsonData = (JSONArray) parser.parse(builder.toString());
                    jsonData.forEach(s -> {
                        JSONObject object = (JSONObject) s;
                        String depthString =(String) ((JSONObject) s).get("depth") ;
                        String name = (String) object.get("station_name");
                        depthString = depthString.replace(",", ".").replace("?", "0");
                        listStationsJSON.add(name.concat(";").concat(depthString));
                    });
                }
            }
            List<String> newList = listStationsJSON.stream().distinct().toList();
            //System.out.println(newList.size());
            newList.forEach(a -> {
                String[] stationAndLine = a.split(";");
                String station = stationAndLine[0];
                float depth = Float.parseFloat(stationAndLine[1]);
                stationsWithDepthList.add(new StationsFromJson(station, depth));
            });
            //stationsWithDepthList.forEach(System.out::println);
            System.out.println(stationsWithDepthList.size());;
        } catch (Exception ex){
            ex.printStackTrace();
            }
    }

//    public static void saveStations(List<StationsFromJson> stations){
//        File dir = new File("data");
//        dir.mkdir();
//        try {
//            PrintWriter writer = new PrintWriter("data\\listStationsDepth.txt");
//            stations.forEach(s -> writer.write(s.getName() + " " + s.getDepth() + "\n"));
//            //writer.write(stations.toString());
//            writer.flush();
//            writer.close();
//        }
//        catch (FileNotFoundException ex){
//            ex.printStackTrace();
//        }
//        System.out.println("Станции с глубинами записаны в файле \"data\\listStationsDepth.txt\"");
//    }
}

