public class NodeMain
{
    public static void main(String[] beans)
    {
        // Training set, data set, and perceptron created
        ThreeSides[] dataSet = new ThreeSides[2];
        ThreeSides[] trainingSet = new ThreeSides[4];
        Perceptron node = new Perceptron();

        // Epochs sets how many training cycles perceptron goes through
        int epochs = 10000;
        
        // for loop that trains the perceptron. Does so by the perceptron adjusting its own weights
        for (int i = 0; i < epochs; i++)
        {   
            // cycles through training set
            for (int j = 0; j < trainingSet.length; j++)
            {
                // makes new triangle sides and gets the sides that aren't the hypotenuse
                trainingSet[j] = new ThreeSides();
                double[] inputs = {trainingSet[j].sides[0], trainingSet[j].sides[1]};

                // perceptron is trained with inputs and their correct hypotunese while its guesses
                // Depending on how far the guess is, the weights are adjusted accordingly
                node.train(inputs, trainingSet[j].hypotenuseSide);

                trainingSet[j] = null;
            }
        }

        // for loop that tests how well the perceptron guesses the correct hypotenuse
        for (int i = 0; i < dataSet.length; i++)
        {
            // Random data is created to test
            dataSet[i] = new ThreeSides();
            double[] inputs = {dataSet[i].sides[0], dataSet[i].sides[1]}; 

            // Actual hypotenuse along with guess is printed
            System.out.println(dataSet[i] + " Perceptron's guess(): " + node.guess(inputs, dataSet[i].hypotenuseSide));
        }

        // Perceptron's weights are printed
        System.out.println("Perceptron Weights: " + node.weights[0] + ", " + node.weights[1]);
 
    }
}