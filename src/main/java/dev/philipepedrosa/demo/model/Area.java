package dev.philipepedrosa.demo.model;

public enum Area {
    EXATAS("Exatas"),
    HUMANAS("Humanas"),
    BIOLOGICAS("Biológicas"),
    ARTES("Artes"),
    OUTRAS("Outras");

    private String area;

    Area(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}
