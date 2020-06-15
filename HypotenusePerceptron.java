import java.util.Random;

public class HypotenusePerceptron
{
    // double array of weights, random variable, and learning rate are all initialized
    double[] weights = new double[3];
    Random rand = new Random();
    double lr = 0.1;

    public HypotenusePerceptron()
    {
        // weights are assigned a random double value from 0 to 1
        for (int i = 0; i < weights.length; i++)
            this.weights[i] = this.rand.nextDouble();
    }

    // guesses a value for the hypotenuse based on the two sides and weights
    public double guess(double[] inputs, double targetValue)
    {
        // sum is the total of the weights times the square of the two sides
        double sum = 0;
        for (int i = 0; i < inputs.length; i++)
            sum += Math.pow(inputs[i], 2) * this.weights[i];

        // output takes the sum and makes a guess    
        double output = this.activationFunction(sum);

        // guess is returned 
        return output;
    }

    // activationFuntion() takes the sum of the weights times the inputs and returns the guess
    private double activationFunction(double sum)
    {
        return Math.sqrt(sum);
    }

    // trains the perceptron by guessing a value and then making the appropriate adjustments to the weights
    public void train(double[] inputs, double targetValue)
    {
        // calculates the sum of the two squared sides times the weights
        double sum = 0;
        for (int i = 0; i < inputs.length; i++)
            sum += Math.pow(inputs[i], 2) * this.weights[i];

        // guess is the squareroot of the sum
        double guess = this.activationFunction(sum);

        // if the guess doesnt match the hypotenuse, the weights are corrected by subtracting the guess from the 
        // actual value, multiplying it by the learning rate, and then added that to the current weight. 
        if (guess != targetValue)
            for (int i = 0; i < this.weights.length; i++)
                this.weights[i] += (targetValue - guess) * lr;
            
    }

}