#include "properties_structure.h"

const ComponentProperties HYDROGEN = {
        .names = {"Hydrogen"},
        .formula = "H2",
        .yaws_cp_coefficients_gas = {250, 1500, 25.399, 2.0178e-2, -3.8549e-5, 3.188e-8, -8.7585e-12},
        .yaws_cp_coefficients_liq = {14, 32, 50.607, -6.1136, 3.093e-1, -4.148e-3},
        .yaws_cp_coefficients_solid = {12, 14, 5.707, 2.1779e-3, -3.8386e-5,},
        .T_critical = 33.18,
        .P_critical = 1.313e6,
};

const ComponentProperties WATER = {
        .names = {
                "Water", "Ice"
        },
        .formula = "H2O",
        .yaws_cp_coefficients_gas = {100, 1500, 33.933, -8.4186e-3, 2.9906e-5, -1.7825e-8, 3.6934e-12},
        .yaws_cp_coefficients_liq = {273, 615, 92.053, -3.9953e-2, -2.1103e-4, 5.3469e-7},
        .yaws_cp_coefficients_solid = {150, 273, 9.695, 7.4955e-2, -1.5584e-5},
        .T_critical = 647.13,
        .P_critical = 2.2055e7,
};