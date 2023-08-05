public class StationsFromHTML {
    String nameStation;
    String numberLine;
    boolean hasConnection;

    public String getNameStation() {
        return nameStation;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public StationsFromHTML(String nameStation, String numberLine, boolean hasConnection) {
        this.nameStation = nameStation;
        this.numberLine = numberLine;
        this.hasConnection = hasConnection;
    }

    @Override
    public String toString() {
        return "StationsFromHTML{" +
                "nameStation='" + nameStation + '\'' +
                ", numberLine='" + numberLine + '\'' +
                ", hasConnection=" + hasConnection +
                '}';
    }
}


