public class LinearEquation {
    /* Instance Variables */
    final private int x1;
    final private int y1;
    final private int x2;
    final private int y2;

public LinearEquation(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
}

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow((double) x2 - x1,2) + Math.pow((double) y2 - y1, 2)));
    }

    // y1 = slope * x1 + b
    public double yIntercept() {
        return y1 - slope() * x1;
    }

    public double slope() {
        return roundedToHundredth(((double) y2 - y1) / (x2 - x1));
    }
    public String equation() {
        String finalStr = "y = ";

        if (slope() == (int) slope()) {         //if the slope is a whole number and if y-int is 0 it will print (need to check for y-int -/+)
            if (slope() == 1) {
                finalStr += "x";
            }
            else if (slope() == -1) {
                finalStr += "-x";
            }
            else {finalStr += (int) slope() + "x";}
        } else {
            int numerator = y2 - y1;        //if it isn't a whole number make the slop a fraction
            int denominator = x2 - x1;

            if (denominator < 0) { //change the signs so that denominator will never be negative
                denominator *= -1;
                numerator *= -1;
            }
            finalStr += numerator + "/" + denominator + "x";
        }
        //check for the y-int completely
        if (yIntercept() == 0) {
           return finalStr;
        } else if (yIntercept() == Math.abs(yIntercept())) {
            finalStr += " + " + yIntercept();
        } else {
           finalStr += " - " + Math.abs(yIntercept());
        }
        return finalStr;
    }
    public String coordinateForX(double xValue) {
        return "The point on the line is (" + xValue + ", " +  roundedToHundredth(xValue * slope() + yIntercept()) + ")";
    }

    public double roundedToHundredth(double toRound) {
        if (toRound == Math.abs(toRound)) {
            toRound = (int) (toRound * 100 + 0.5);
            return toRound / 100.0;
        }
        toRound = (int) (toRound * 100 - 0.5);
        return toRound / 100.0;
    }

    public String lineInfo() {
        String finalStr = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        if (y1 == y2) {
            finalStr += "\nThe equation of the line between these points is: y = " + y1;
        }
        else {
            finalStr += "\nThe equation of the line between these points is: " + equation();
        }
        finalStr += "\nThe slope of this line is: " + slope();
        finalStr += "\nThe y-intercept of the line is: " + yIntercept();
        finalStr += "\nThe distance between the two points is: " + distance();
        finalStr += "\n";

        return finalStr;
    }

}
