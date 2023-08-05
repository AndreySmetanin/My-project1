public class StationsFromJson {

        String name;
        float depth;

        public StationsFromJson(String name, float depth) {
            this.name = name;
            this.depth = depth;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDepth(float depth) {
            this.depth = depth;
        }

        public float getDepth() {
            return depth;
        }

        @Override
        public String toString() {
            return "Station{" +
                    "name='" + name + '\'' +
                    ", depth=" + depth +
                    '}';
        }


}
