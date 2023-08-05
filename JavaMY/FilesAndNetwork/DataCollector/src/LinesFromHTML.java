public class LinesFromHTML {

    private String nameLine;
    private String numberLine;
    public LinesFromHTML(String nameLine, String numberLine) {
        this.numberLine = numberLine;
        this.nameLine = nameLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    @Override
    public String toString() {
        return "LinesFromHTML{" +
                "nameLine='" + nameLine + '\'' +
                ", numberLine='" + numberLine + '\'' +
                '}';
    }
}

