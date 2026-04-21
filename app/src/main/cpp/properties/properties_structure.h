#ifndef CP_STRUCTURES
#define CP_STRUCTURES

#define MAX_NAMES 4
#define MAX_NAME_LENGTH 64
typedef struct {
    double a, b, c;
    double t_min, t_max;
} HeatCapacitySolid;

typedef struct {
    double a, b, c, d;
    double t_min, t_max;
} HeatCapacityLiquid;

typedef struct {
    double a, b, c, d, e;
    double t_min, t_max;
} HeatCapacityGas;

typedef struct {
    const char *names[MAX_NAMES];
    char formula[MAX_NAME_LENGTH];
    double yaws_cp_coefficients_gas[7]; // T_min, T_max, a, b, c, d, e,
    double yaws_cp_coefficients_liq[6]; // T_min, T_max, a, b, c, d
    double yaws_cp_coefficients_solid[5]; //  T_min, T_max, a, b, c
    double T_critical;
    double P_critical;
} ComponentProperties;

#endif