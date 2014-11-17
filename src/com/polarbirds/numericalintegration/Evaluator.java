package com.polarbirds.numericalintegration;

import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;
import com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm;

/**
 * Helper class for estimating y(x+dx) with steps smaller than dx.
 */
public class Evaluator {
    private NumericalIntegrationAlgorithm nia;
    private DerivativeFunction f;

    /**
     * Choose the implementation of {@link com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm} to use,
     * and a {@link com.polarbirds.numericalintegration.interfaces.DerivativeFunction} to use for estimating.
     * @param numericalIntegrationAlgorithm {@link com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm}
     * that provides the estimation algorith.
     * @param derivativeFunction {@link com.polarbirds.numericalintegration.interfaces.DerivativeFunction} that provides
     * the values for dy/dx = f(x, y).
     */
    public Evaluator(NumericalIntegrationAlgorithm numericalIntegrationAlgorithm,
                     DerivativeFunction derivativeFunction){
        nia = numericalIntegrationAlgorithm;
        f = derivativeFunction;
    }

    /**
     * Estimates the function value at x_0 + dx with
     * {@link com.polarbirds.numericalintegration.interfaces.DerivativeFunction} f using method
     * {@link com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm} numericalIntegrationAlgorithm.
     * @param x_0 The initial, known x value.
     * @param y_0 The initial, known y value. (depends on x; y_0 = g(x_0) where g(x) is the formula being estimated)
     * @param dx The distance from x_0 to estimate towards.
     * @param steps The number of steps from x_0 to x_0+dx. Must be > 0
     * @return double[] results, containing {y_0, y_1, ..., y_n} where n = steps.
     */
    public double[] evaluate(double x_0, double y_0, double dx, int steps){
        if (steps < 1) throw new IllegalArgumentException();

        double[] out = new double[steps + 1];
        double step_size = dx / (double)steps;

        out[0] = y_0;
        double x = x_0;
        for (int i = 1; i <= steps; i++){
            out[i] = nia.step(x, out[i-1], f, step_size);
            x += step_size;
        }

        return out;
    }
}
