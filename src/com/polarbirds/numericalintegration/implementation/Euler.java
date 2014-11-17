package com.polarbirds.numericalintegration.implementation;

import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;
import com.polarbirds.numericalintegration.interfaces.NumericalIntegrationAlgorithm;

/**
 * Created by kristian on 17.11.14.
 */
public class Euler implements NumericalIntegrationAlgorithm {

    @Override
    public double step(double x, double y, DerivativeFunction f, double dx) {
        return y + dx*f.evaluate(x, y);
    }

}
