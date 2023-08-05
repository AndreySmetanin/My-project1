import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ParsingDirectory {
    public static int countJson;
    public static int countCsv;

    public static int total;
    //public static File file = new File("");


    public static ArrayList<String> links = new ArrayList<>();

    public static void foundFiles(File file){
        if(file.isFile()){
            total += 1;
           if(file.getName().matches("[\\w\\d.-]+[csv]")){ //[A-Za-z\d+_.-]+[.csv]
               countCsv += 1;
               links.add(file.getAbsolutePath());
           }
           if(file.getName().matches("[\\w\\d.-]+[.json]") ) {
                countJson += 1;
                links.add(file.getAbsolutePath());
            }
        } if (file.isDirectory()) {
            total +=1;
            File[] folders = file.listFiles();
            assert folders != null;
            for(File files : folders ){
                foundFiles(files);
            }
        }
    }

    public static void madePathsFiles(String path){
        File file = new File(path);
        foundFiles(file);
        File dir = new File("data");
        dir.mkdir();

        try {
            Files.write(Paths.get("data\\pathsToFiles.txt"),links);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        System.out.println("Найдено - " + (countCsv + countJson) + " файлов\nВсего просмотрено " + total
                    + " файлов(папок)" + "\nПути файлов Json и csv созданы в папке: data\\pathsToFiles.txt") ;
    }
}




