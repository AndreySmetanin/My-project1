import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class MadeMetroMSK  {
        public static StringBuilder metroMSK = new StringBuilder("{\"stations\":{");
        public static StringBuilder linesWithStatioms = new StringBuilder();

        public static void madeJson() throws Exception{
            String name;
            String number;
            StringBuilder listStations = new StringBuilder();
            for (LinesFromHTML line : ParsingWeb.linesListHTML) {
                number = line.getNumberLine();
                metroMSK.append("\"" + number + "\":[");
                for (StationsFromHTML station : ParsingWeb.listStationsHTML) {
                    name = station.getNameStation();
                    if (station.getNumberLine().equals(number)) {
                        metroMSK.append("\"").append(name).append("\",");// + name + "\"" + ",");
                    }
                }
                metroMSK.setLength(metroMSK.length() - 1);
                metroMSK.append("],");
            }
            metroMSK.setLength(metroMSK.length() - 1);
            metroMSK.append("},");

            metroMSK.append("\"lines\":[");
            for(LinesFromHTML lines : ParsingWeb.linesListHTML){
                String numberLine = lines.getNumberLine();
                String nameLine = lines.getNameLine();
                metroMSK.append("{\"number\": \""  + numberLine +"\",").
                        append("\"name\": \""  + nameLine +"\"},");
            }

            metroMSK.setLength(metroMSK.length() - 1);
            metroMSK.append("]}");

            Files.write(Paths.get("data\\metroMSK.json"), Collections.singleton(metroMSK));
        }
}
