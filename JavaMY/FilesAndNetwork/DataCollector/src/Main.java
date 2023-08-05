import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

                //класс ПарсингВеб
        ParsingWeb.parseHTML();

                // Поиск в папке "data" и создание папки с путями к файлам json и csv
        ParsingDirectory.madePathsFiles("DataCollector/resources/stations-data/data");

                // ПарсингДжисон
        ParsingJSON.parserJson("data\\pathsToFiles.txt");


                //парсингCSV
        ParsingCSV.getListFromCsv("data\\pathsToFiles.txt");

                //создание Станций с полной информацией
        CreateStations.createdStations();

                //создание Json файлов
        MadeJson.createJsonFile();

        MadeMetroMSK.madeJson();




    }
}
