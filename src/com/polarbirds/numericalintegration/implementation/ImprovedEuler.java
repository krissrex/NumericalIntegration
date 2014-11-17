package com.polarbirds.numericalintegration.implementation;

import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;
import com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm;

/**
 * Improved Euler method that uses averaging.
 */
public class ImprovedEuler implements NumericalIntegrationAlgorithm {

    @Override
    public double step(double x, double y, DerivativeFunction f, double dx) {
        double u = y + dx*f.evaluate(x, y);
        return y + dx*(f.evaluate(x, y) + f.evaluate(x + dx, u))/2.0d;
    }

}
