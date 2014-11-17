package com.polarbirds.numericalintegration.interfaces;

/**
 * The derivative function is the function f in dy/dx = f(x, y).
 */
public interface DerivativeFunction {
    /**
     * Calculates the value of dy/dx = f(x, y)
     * @param x the x value in f(x, y).
     * @param y the y value in f(x, y).
     * @return f(x, y).
     */
    public double evaluate(double x, double y);
}
