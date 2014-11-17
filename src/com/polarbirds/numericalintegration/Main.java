package com.polarbirds.numericalintegration;

import com.polarbirds.numericalintegration.implementation.Euler;
import com.polarbirds.numericalintegration.implementation.ImprovedEuler;
import com.polarbirds.numericalintegration.implementation.RungeKutta;
import com.polarbirds.numericalintegration.interfaces.DerivativeFunction;
import jdk.nashorn.internal.objects.annotations.Function;

/**
 * Created by kristian on 17.11.14.
 */
public class Main {

    public static void main(String args[]){
        System.out.println("Started.");
        DerivativeFunction f = new DerivativeFunction() {
            @Override
            public double evaluate(double x, double y) {
                return x - y;
            }
        };

        Evaluator eul = new Evaluator(new Euler(), f);
        Evaluator impEul = new Evaluator(new ImprovedEuler(), f);
        Evaluator runge = new Evaluator(new RungeKutta(), f);

        int steps = 5;
        double x_0 = 0.0d;
        double y_0 = 1.0d;
        double dx = 1.0d;

        double[] eulResults = eul.evaluate(x_0, y_0, dx, steps);
        double[] impEulResults = impEul.evaluate(x_0, y_0, dx, steps);
        double[] rungeResults = runge.evaluate(x_0, y_0, dx, steps);

        System.out.println("Actual value for g(x)=x-1+2e^(-x) of g(1) is 0.7357588823");
        print(eulResults, "Euler");
        print(impEulResults, "Improved Euler");
        print(rungeResults, "Runge-Kutta");

    }

    static void print(double[] results, String name){
        System.out.println(name + " results:\n====================================");
        for (int i = 0; i < results.length; i++){
            System.out.println("|"+ i + "| " + results[i]);
        }
        System.out.println();
    }

}
