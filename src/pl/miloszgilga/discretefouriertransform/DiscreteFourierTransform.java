/*
 * Copyright (c) 2022 by MILOSZ GILGA <https://miloszgilga.pl>
 *
 * File name: DiscreteFourierTransform.java
 * Last modified: 09/05/2022, 15:39
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


public class DiscreteFourierTransform {

    private final int _k;
    private final int _n;

    private final IOHandler _handler;

    private final double[] _sum;
    private final ComplexNumber[] _dftOutput;

    private final LinearEquationCoefficients _coefficients;

    public DiscreteFourierTransform(int n, IOHandler handler) {
        _n = n;
        _sum = new double[n];
        _handler = handler;
        _coefficients = _handler.insertLinearCoefficients();
        _k = _handler.insertKfactor();
        _dftOutput = new ComplexNumber[_k];
        fillLinearEquationCoefficents();
    }

    public void fillLinearEquationCoefficents() {
        for(int i = 0 ; i < 10; i++) {
            _sum[i] = ((_coefficients.getA() * (double)i) + (_coefficients.getB() * (double)i) - _coefficients.getC());
        }
    }

    public void computedCoefficeints() {
        for(int i = 0; i < _k; i++) {
            _dftOutput[i] = new ComplexNumber();
            for(int j = 0 ; j < _n; j++) {
                _dftOutput[i].realis += _sum[j] * Math.cos((2 * j * i * Math.PI) / _n);
                _dftOutput[i].imaginaris += _sum[j] * Math.sin((2 * j * i * Math.PI) / _n);
            }
        }
        _handler.showComputedCoefficients(_dftOutput);
    }

}