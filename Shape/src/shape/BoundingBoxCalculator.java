package shape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BoundingBoxCalculator {
    static double findMinX(ArrayList<Shape> shapes) {
        double minX = shapes.get(0).getMinX();
        for (Shape shape : shapes) {
            if (shape.getMinX() < minX) {
                minX = shape.getMinX();
            }
        }
        return minX;
    }

    static double findMinY(ArrayList<Shape> shapes) {
        double minY = shapes.get(0).getMinY();
        for (Shape shape : shapes) {
            if (shape.getMinY() < minY) {
                minY = shape.getMinY();
            }
        }
        return minY;
    }

    static double findMaxX(ArrayList<Shape> shapes) {
        double maxX = shapes.get(0).getMaxX();
        for (Shape shape : shapes) {
            if (shape.getMaxX() > maxX) {
                maxX = shape.getMaxX();
            }
        }
        return maxX;
    }

    static double findMaxY(ArrayList<Shape> shapes) {
        double maxY = shapes.get(0).getMaxY();
        for (Shape shape : shapes) {
            if (shape.getMaxY() > maxY) {
                maxY = shape.getMaxY();
            }
        }
        return maxY;
    }

    static void calculateBoundingBox(String fileName) throws InvalidShapeDataException {
        ArrayList<Shape> shapes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int totalShapes = Integer.parseInt(br.readLine());
            if (totalShapes <= 0) {
                throw new InvalidShapeDataException("There are not enough amount of figures for calculation.");
            }

            for (int i = 0; i < totalShapes; i++) {
                String[] details = br.readLine().split(" ");

                String type = details[0];
                double centerX = Double.parseDouble(details[1]);
                double centerY = Double.parseDouble(details[2]);
                double side = Double.parseDouble(details[3]);

                Shape shape = ShapeFactory.createShape(type, centerX, centerY, side);
                shapes.add(shape);
                if (totalShapes != shapes.size()) {
                    throw new InvalidShapeDataException("Invalid information is given for the number of total shapes.");
                }
            }
        } catch (IOException | InvalidShapeDataException e) {
            e.printStackTrace();
            return;
        }

        double maxX = findMaxX(shapes);
        double minX = findMinX(shapes);
        double maxY = findMaxY(shapes);
        double minY = findMinY(shapes);

        double width = maxX - minX;
        double height = maxY - minY;

        System.out.println("Details of the smallest bounding box:");
        System.out.println("Minimum X coordinate of the box is " + minX);
        System.out.println("Maximum X coordinate of the box is " + maxX);
        System.out.println("Minimum Y coordinate of the box is " + minY);
        System.out.println("Maximum Y coordinate of the box is " + maxY);
        System.out.println("Width of the box is " + width);
        System.out.println("Height of the box is " + height);
    }
}
