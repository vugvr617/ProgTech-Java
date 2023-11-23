package shape;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {
    @Test
    public void testCreateShapes() throws InvalidShapeDataException {
        Shape circle = ShapeFactory.createShape("Circle", 1.0, 2.0, 3.0);
        Shape square = ShapeFactory.createShape("Square", 1.0, 2.0, 3.0);
        assertTrue(circle instanceof Circle);
        assertTrue(square instanceof Square);
        assertEquals(1.0, circle.x);
        assertEquals(2.0, square.y);
    }

    @Test
    public void testCreateInvalidShape() {
        try {
            ShapeFactory.createShape("Rectangle", 1.0, 2.0, 3.0);
        } catch (InvalidShapeDataException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCreateNegativeSize() {
        try {
            ShapeFactory.createShape("Circle", 1.0, 2.0, -3.0);
        } catch (InvalidShapeDataException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCalculateBox () throws InvalidShapeDataException {
        Shape circle = ShapeFactory.createShape("Circle", 5, 11, 3);
        Shape square = ShapeFactory.createShape("Square", 17, 16, 6);
        Shape triangle = ShapeFactory.createShape("Square", 9, 5, 4);
        Shape hexagon = ShapeFactory.createShape("Triangle", 19, 10, 6);

        ArrayList<Shape> shapes = new ArrayList<>(Arrays.asList(circle,square,triangle,hexagon));

        assertEquals(BoundingBoxCalculator.findMinX(shapes), 2.0);
        assertEquals(BoundingBoxCalculator.findMaxX(shapes), 22.0);
        assertEquals(BoundingBoxCalculator.findMinY(shapes), 3.0);
        assertEquals(BoundingBoxCalculator.findMaxY(shapes), 19.0);
    }

    @Test
    public void testCalculateBoxWithMinimalValue () throws InvalidShapeDataException {
        Shape circle = ShapeFactory.createShape("Circle", 0, 0, Double.MIN_VALUE);
        Shape square = ShapeFactory.createShape("Square", 0, 0, Double.MIN_VALUE);
        Shape triangle = ShapeFactory.createShape("Triangle", 0, 0, Double.MIN_VALUE);
        Shape hexagon = ShapeFactory.createShape("Hexagon", 0, 0, Double.MIN_VALUE);

        ArrayList<Shape> shapes = new ArrayList<>(Arrays.asList(circle,square,triangle,hexagon));

        assertEquals(BoundingBoxCalculator.findMinX(shapes), -Double.MIN_VALUE);
        assertEquals(BoundingBoxCalculator.findMaxX(shapes), Double.MIN_VALUE);
        assertEquals(BoundingBoxCalculator.findMinY(shapes), -Double.MIN_VALUE);
        assertEquals(BoundingBoxCalculator.findMaxY(shapes), Double.MIN_VALUE);
    }
}