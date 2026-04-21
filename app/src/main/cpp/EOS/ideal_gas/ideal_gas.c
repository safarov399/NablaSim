#include <math.h>
#include "../../constants/universal_constants.h"
#include "ideal_gas.h"

double ideal_gas_residue(double P, double V, double n, double T) {
    return (P * V) - (n * UNIVERSAL_GAS_CONSTANT * T);
}

double ideal_gas(double *target, double (*f)(double, double, double, double), double* P, double* V, double* n, double* T) {
    double precision = 1e-7;
    int max_iterations = 1000;
    int i = 0;
    for (; i < max_iterations; i++) {
        double y = f(*P, *V, *n, *T);
        if(fabs(y) <= precision) break;
        double h = 1e-5;
        double original_value = *target;
        *target += h;
        double y_h = f(*P, *V, *n, *T);
        double derivative = (y_h - y) / h;
        if (fabs(derivative) < 1e-12) break;
        *target = original_value - (y / derivative);
    }
    return *target;
}