import java.util.Random;

public class ThreeSides
{
    // all sides are declared and a random variable is initialized 
    double[] sides = new double[2];
    Random rand = new Random();
    double bias = 1.0;
    double hypotenuseSide;

    public ThreeSides()
    {
        // sides are assigned a random double from 1 to 10
        for (int i = 0; i < this.sides.length; i++)
            this.sides[i] = this.rand.nextDouble() * 10.0;

        // hypotneuse is calculated based on two other sides
        this.hypotenuseSide = this.pythagFormula();
    }

    // pythagoreom theorem is used to calculare hypotenuse
    private double pythagFormula()
    {
        // a^2 + b^2 = c^2
        double squareOneSide = Math.pow(this.sides[0], 2);
        double squareOtherSide = Math.pow(this.sides[1], 2);

        return Math.sqrt(squareOneSide + squareOtherSide);
    }

    public String toString()
    {
        return "Sides: " + this.sides[0] + " " + this.sides[1] + " Hypotenuse: " + this.hypotenuseSide;
    }
    
}