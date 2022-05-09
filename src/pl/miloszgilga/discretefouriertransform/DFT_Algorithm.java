/*
 * Copyright (c) 2022 by MILOSZ GILGA <https://miloszgilga.pl>
 *
 * File name: Main.java
 * Last modified: 09/05/2022, 15:24
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

public class DFT_Algorithm {

    public static final int N = 10;

    public static void main(String[] args) {
        DiscreteFourierTransform transform = new DiscreteFourierTransform(N, new IOHandlerConsoleImplementation());
        transform.computedCoefficeints();
    }
}