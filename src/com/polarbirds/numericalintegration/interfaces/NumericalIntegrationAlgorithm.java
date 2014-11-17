package com.polarbirds.numericalintegration.interfaces;

import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;

/**
 * Created by kristian on 17.11.14.
 */
public interface NumericalIntegrationAlgorithm {
    public double step(double x, double y, DerivativeFunction f, double dx);
}
