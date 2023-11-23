package shape;

abstract class Shape {

    protected final double x;
    protected final double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getMinX();

    public abstract double getMaxX();

    public abstract double getMinY();

    public abstract double getMaxY();
}

class Circle extends Shape {

    private final double radius;

    public Circle(double x, double y, double rad) {
        super(x, y);
        this.radius = rad;
    }

    @Override
    public double getMinX() {
        return x - radius;
    }

    @Override
    public double getMaxX() {
        return x + radius;
    }

    @Override
    public double getMinY() {
        return y - radius;
    }

    @Override
    public double getMaxY() {
        return y + radius;
    }
}

class Triangle extends Shape {

    private double side;
    private final double height = (side * Math.sqrt(3)) / 2;

    public Triangle(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public double getMinX() {
        return x - side / 2;
    }

    @Override
    public double getMaxX() {
        return x + side / 2;
    }

    @Override
    public double getMinY() {
        return y - height / 2;
    }

    @Override
    public double getMaxY() {
        return y + height / 2;
    }
}

class Hexagon extends Shape {

    private final double side;

    public Hexagon(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public double getMinX() {
        return x - side;
    }

    @Override
    public double getMaxX() {
        return x + side;
    }

    @Override
    public double getMinY() {
        return y - side;
    }

    @Override
    public double getMaxY() {
        return y + side;
    }
}

class Square extends Shape {

    private final double side;

    public Square(double x, double y, double side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public double getMinX() {
        return x - side / 2;
    }

    @Override
    public double getMaxX() {
        return x + side / 2;
    }

    @Override
    public double getMinY() {
        return y - side / 2;
    }

    @Override
    public double getMaxY() {
        return y + side / 2;
    }
}
