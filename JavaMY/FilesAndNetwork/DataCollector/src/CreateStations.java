import java.util.ArrayList;
import java.util.List;

public class CreateStations {

    public  static List<StationsFullInfo> listFullInfo = new ArrayList<>();
    private static String name;
    private static  String line;
    private static float depth;
    private static String date;
    private static boolean hasConnection;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CreateStations.name = name;
    }

    public static String getLine() {
        return line;
    }

    public static void setLine(String line) {
        CreateStations.line = line;
    }

    public static float getDepth() {
        return depth;
    }

    public static void setDepth(float depth) {
        CreateStations.depth = depth;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        CreateStations.date = date;
    }

    public static boolean isHasConnection() {
        return hasConnection;
    }

    public static void setHasConnection(boolean hasConnection) {
        CreateStations.hasConnection = hasConnection;
    }

    public static void createdStations(){
        ParsingWeb.listStationsHTML.forEach(el -> {
            name = el.getNameStation();

            line = el.getNumberLine();

            ParsingWeb.linesListHTML.forEach(li -> {
                if(line.equals(li.getNumberLine())){
                    line = li.getNameLine();
                }
            });

            ParsingCSV.listCSV.forEach(da -> {
                if(name.equals(da.getName())){
                    date = da.getDateBuild();
                }
            });

            ParsingJSON.stationsWithDepthList.forEach(de ->{
                if(name.equals(de.getName())){
                    depth = de.getDepth();
                }

            });

            depth = 0;
            hasConnection = el.isHasConnection();

            listFullInfo.add(new StationsFullInfo(name, line, date, depth, hasConnection));
        });

    }


}
