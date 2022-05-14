public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getLocationX() {
        return this.x;
    }
    public double getLocationY() {
        return this.y;
    }

    public double calcDistance(Location location) {
        return Math.hypot(location.getLocationX() - this.x, location.getLocationY() - this.y);
    }
}
