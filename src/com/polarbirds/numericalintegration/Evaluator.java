package com.polarbirds.numericalintegration;

import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;
import com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm;

/**
 * Created by kristian on 17.11.14.
 */
public class Evaluator {
    private NumericalIntegrationAlgorithm nia;
    private DerivativeFunction f;

    public Evaluator(NumericalIntegrationAlgorithm numericalIntegrationAlgorithm,
                     DerivativeFunction derivativeFunction){
        nia = numericalIntegrationAlgorithm;
        f = derivativeFunction;
    }

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
