import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        //get the numeric values that is in the string
        int x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(")+1, coord1.indexOf(",")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(" ")+1, coord1.indexOf(")")));
        int x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(")+1, coord2.indexOf(",")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(" ")+1, coord2.indexOf(")")));

        //check for a vertical line by checking the same x value
        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        }
        else {
            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

            System.out.println(equation.lineInfo());
            System.out.print("Enter a value for x: ");
            double xValue = scan.nextDouble();
            scan.nextLine();
            scan.close();
            System.out.println(equation.coordinateForX(xValue));
        }
    }
}
