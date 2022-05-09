/*
 * Copyright (c) 2022 by MILOSZ GILGA <https://miloszgilga.pl>
 *
 * File name: IOHandlerConsoleImplementation.java
 * Last modified: 09/05/2022, 14:38
 * Project name: fourier-transform
 *
 * Licensed under the GNU GPL 3.0 license; you may not use this file except in compliance with the License.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * THE ABOVE COPYRIGHT NOTICE AND THIS PERMISSION NOTICE SHALL BE INCLUDED IN ALL
 * COPIES OR SUBSTANTIAL PORTIONS OF THE SOFTWARE.
 */

package pl.miloszgilga.discretefouriertransform;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;


public class IOHandlerConsoleImplementation implements IOHandler {

    private final Scanner _scanner = new Scanner(System.in);
    private final DecimalFormat df = new DecimalFormat("0.000000000000000");

    @Override
    public LinearEquationCoefficients insertLinearCoefficients() {
        System.out.println("Insert values for simple linear equtation: ax+by=c :");
        double a = 0.0, b = 0.0, c = 0.0;
        try {
            a = _scanner.nextDouble();
            b = _scanner.nextDouble();
            c = _scanner.nextDouble();
        } catch (InputMismatchException ex) {
            System.err.println("Incorrect a, b or c value");
            System.exit(1);
        }
        return new LinearEquationCoefficients(a, b, c);
    }

    @Override
    public int insertKfactor() {
        System.out.println("Insert k value:");
        int k = 0;
        try {
            k = _scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.err.println("Incorrect k-factor value");
            System.exit(1);
        }
        return k;
    }

    @Override
    public void showComputedCoefficients(ComplexNumber[] dftOutput) {
        System.out.println("Computed DFT coefficients:");
        for (ComplexNumber complexNumber : dftOutput) {
            String realis = String.format("[%s]", df.format(complexNumber.realis));
            String imaginaris = String.format("[%s j]", df.format(complexNumber.imaginaris));
            System.out.println(realis + " - " + imaginaris);
        }
    }

}