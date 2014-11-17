package Tests;

import com.polarbirds.numericalintegration.Evaluator;
import com.polarbirds.numericalintegration.implementation.Euler;
import com.polarbirds.numericalintegration.implementation.ImprovedEuler;
import com.polarbirds.numericalintegration.implementation.RungeKutta;
import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;

/**
 * Example code for usage.
 */
public class Main {

    public static void main(String args[]){

        System.out.println("Started.");

        // This function represents dy/dx = x-y  as f(x, y).
        DerivativeFunction f = new DerivativeFunction() {
            @Override
            public double evaluate(double x, double y) {
                return x - y;
            }
        };

        //Instantiate different evaluators. Think of them as calculators doing the manual work
        // of steps etc for you. Each takes an NumericalIntegrationAlgorithm and DerivativeFunction,
        Evaluator eul = new Evaluator(new Euler(), f);
        Evaluator impEul = new Evaluator(new ImprovedEuler(), f);
        Evaluator runge = new Evaluator(new RungeKutta(), f);

        //Steps results in h=dx/steps.
        //x_0 is the initial x value (known/chosen).
        //y_0 is the initial y value (depending on x_0).
        //dx is the distance from x_0 you want to estimate.
        // Example: g(0)=1 (known), g(1)=g(0+1) => dx=1
        int steps = 5;
        double x_0 = 0.0d;
        double y_0 = 1.0d;
        double dx = 1.0d;

        //They return a list of the values y_0, y_1, ..., y_n
        // where n=steps and x_n = x_0 + dx.
        double[] eulResults = eul.evaluate(x_0, y_0, dx, steps);
        double[] impEulResults = impEul.evaluate(x_0, y_0, dx, steps);
        double[] rungeResults = runge.evaluate(x_0, y_0, dx, steps);

        //Displaying the values and the 'exact' answer for this particular test.
        System.out.println("Actual value for g(x)=x-1+2e^(-x) of g(1) is 0.7357588823");
        print(eulResults, "Euler");
        print(impEulResults, "Improved Euler");
        print(rungeResults, "Runge-Kutta");
    }

    /**
     * Utility method for listing the result.
     * @param results numbers to be printed
     * @param name a name or title indicating the method.
     */
    static void print(double[] results, String name){
        System.out.println(name + " results:\n====================================");
        for (int i = 0; i < results.length; i++){
            System.out.println("|"+ i + "| " + results[i]);
        }
        System.out.println();
    }

}
