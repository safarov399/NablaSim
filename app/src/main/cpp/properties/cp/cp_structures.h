#ifndef CP_STRUCTURES
#define CP_STRUCTURES
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
#endif