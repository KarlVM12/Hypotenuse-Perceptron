import java.util.Random;

public class Perceptron
{
    // double array of weights, random variable, and learning rate are all initialized
    double[] weights = new double[2];
    Random rand = new Random();
    double lr = 0.1;

    public Perceptron()
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

        // output tells if the guess is correct(0), below(-1), or above(1) target value    
        //int output = this.sign(Math.sqrt(sum), targetValue);

        // guess is returned as squareroot of sum
        return Math.sqrt(sum);
    }

    // returns a -1, 0, or 1 depending on how the target value relates to the guess
    private int sign(double sum, double targetValue)
    {
        if (sum == targetValue)
            return 0;
        else if (sum < targetValue)
            return -1;
        else    
            return 1;
    
    }

    // trains the perceptron by guessing a value and then making the appropriate adjustments to the weights
    public void train(double[] inputs, double targetValue)
    {
        // calculates the sum of the two squared sides times the weights
        double sum = 0;
        for (int i = 0; i < inputs.length; i++)
            sum += Math.pow(inputs[i], 2) * this.weights[i];

        // guess is the squareroot of the sum
        double guess = Math.sqrt(sum);

        // if the guess doesnt match the hypotenuse, the weights are corrected by subtracting the guess from the 
        // actual value, multiplying it by the learning rate, and then added that to the current weight. 
        if (guess != targetValue)
            for (int i = 0; i < this.weights.length; i++)
                this.weights[i] += (targetValue - Math.sqrt(sum)) * lr;
            
    }

}