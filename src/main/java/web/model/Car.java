package web.model;

public class Car {
    private String name;
    private String color;
    private int year;

    public Car () {};

    public Car(String name, String color, int year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }
}
