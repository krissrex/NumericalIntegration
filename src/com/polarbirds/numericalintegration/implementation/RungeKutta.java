package com.polarbirds.numericalintegration.implementation;

import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;
import com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm;

/**
 * Created by kristian on 17.11.14.
 */
public class RungeKutta implements NumericalIntegrationAlgorithm {
    @Override
    public double step(double x, double y, DerivativeFunction f, double dx) {
        // 4th order Runge-Kutta method.
        double x_2 = x + dx/2.0d;
        double dx_half = dx/2.0d;

        double p = f.evaluate(x, y);
        double q = f.evaluate(x_2, y + dx_half*p);
        double r = f.evaluate(x_2, y + dx_half*q);
        double s = f.evaluate(x + dx, y + dx*r);
        return y + dx*(p + 2*q + 2*r + s)/6.0d;
    }
}
