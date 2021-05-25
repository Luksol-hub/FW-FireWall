package defects;

public enum DefectCategory {
    FLOAT("Wady Float"),
    SURFACE("Wady Powierzchni"),
    EDGE("Wady Krawędzi"),
    POST("Wady Znaczka"),
    BELT("Wady Czarny pas"),
    DIRT("Brudy Wewnętrzne");

   private String polishName;

    DefectCategory(String name) {
        this.polishName = name;
    }

    public String getPolishName() {
        return polishName;
    }

    @Override
    public String toString() {
        return polishName;
    }
}
