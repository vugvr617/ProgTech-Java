package shape;

public class ShapeFactory {

    static Shape createShape(String type, double x, double y, double size) throws InvalidShapeDataException {
        if (size <= 0) {
            throw new InvalidShapeDataException("Invalid size is given, size of the " + type.toLowerCase() + " has to be greater than 0!");
        }

        switch (type.toLowerCase()) {
            case "circle" -> {
                return new Circle(x, y, size);
            }
            case "triangle" -> {
                return new Triangle(x, y, size);
            }
            case "hexagon" -> {
                return new Hexagon(x, y, size);
            }
            case "square" -> {
                return new Square(x, y, size);
            }
            default ->
                throw new InvalidShapeDataException("Invalid shape type is given, " + type.toLowerCase() + " is not applicable!");
        }
    }
}
