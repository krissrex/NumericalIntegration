package com.polarbirds.numericalintegration.interfaces;


/**
 * An algorithm for estimating a value by using the derivative.
 */
public interface NumericalIntegrationAlgorithm {

    /**
     * Goes a step forward from y(x) to y(x+dx).
     * y(x+dx) is estimated using the derivative dy/dx = f(x, y).
     * @param x the x value in f(x, y).
     * @param y the y value in f(x, y).
     * @param f the derivative dy/dx = f(x, y).
     * @param dx the distance from x to estimate y.
     * @return estimation of y(x+dx).
     */
    public double step(double x, double y, DerivativeFunction f, double dx);
}
