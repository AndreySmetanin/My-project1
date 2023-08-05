import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsingWeb{

        public static List<LinesFromHTML> linesListHTML = new ArrayList<>();
        public static List<StationsFromHTML> listStationsHTML = new ArrayList<>();
        public static boolean hasConnection;
        public static String numberLine;
        public  static String nameStation;

        public static void parseHTML() throws IOException {
            Document doc = Jsoup.connect("https://skillbox-java.github.io/").get();
            parsingHTML(doc);
        }

        public static void parsingHTML(Document doc){
            //парсинг имя и номер линий
            Elements lines = doc.select("span[data-line]");  //span[data-line]
            lines.forEach(line -> {
                String numberLine = line.attr("data-line");
                linesListHTML.add(new LinesFromHTML(line.text(), numberLine));
            });
            //парсинг имя, номер линии и пересадки станций
            Elements stations = doc.select("p.single-station");
            for(Element st : stations){
                nameStation = st.text().replaceAll("\\d+. ", "");
                assert st.parent() != null;
                numberLine = st.parent().attr("data-line");
                st.forEach(a-> {
                    if(a.hasClass("t-icon-metroln")){
                        hasConnection = true;
                    }
                });
                listStationsHTML.add(new StationsFromHTML(nameStation, numberLine, hasConnection));
                hasConnection = false;
            }
            System.out.println(listStationsHTML.size());
        }
}






