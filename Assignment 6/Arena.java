package assignment6;

public class Arena implements Building {
    // instance variables
    private String color;
    private double length;
    private double width;
    private String buildingType;

    // constructor
    public Arena(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Arena";
    }

    @Override
    public void setSize(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setBuildingType(String type) {
        this.buildingType = type;
    }

    @Override
    public String getBuildingType() {
        return buildingType;
    }

    @Override
    public String toString() {
        return String.format("Arena [Color: %s, Length: %.1f, Width: %.1f]",
                color, length, width);
    }

}
