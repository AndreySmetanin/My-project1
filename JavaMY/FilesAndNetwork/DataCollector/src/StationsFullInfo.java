public class StationsFullInfo {
    private String name;
    private String line;
    private String date;
    private float depth;
    private boolean hasConnection;

    public StationsFullInfo(String name, String line, String date, float depth, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }

    public String getDate() {
        return date;
    }

    public float getDepth() {
        return depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLine(String line) {
        line = line;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }
    @Override
    public String toString() {
        return "Stations{" +
                "name='" + name + '\'' +
                ", Line='" + line + '\'' +
                ", date='" + date + '\'' +
                ", depth='" + depth + '\'' +
                ", hasConnection=" + hasConnection +
                '}';
    }

}
