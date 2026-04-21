#ifndef IDEAL_GAS_H
#define IDEAL_GAS_H

double ideal_gas_residue(double P, double V, double n, double T);
double ideal_gas(double *target, double (*f)(double, double, double, double), double *P, double *V, double *n, double *T);

#endif