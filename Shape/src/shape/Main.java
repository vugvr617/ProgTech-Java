package shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidShapeDataException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String fileName = scanner.nextLine();

        BoundingBoxCalculator.calculateBoundingBox(fileName);
    }
}
