import java.time.LocalDate;

public class StationsFromCSV {
    String name;
    String dateBuild;

    public String getName() {
        return name;
    }

    public String getDateBuild() {
        return dateBuild;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBuild(String dateBuild) {
        this.dateBuild = dateBuild;
    }

    public StationsFromCSV(String name, String dateBuild) {
        this.name = name;
        this.dateBuild = dateBuild;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", dateBuild=" + dateBuild;
    }
}
