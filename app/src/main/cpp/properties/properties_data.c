#include "properties_structure.h"

const ComponentProperties hydrogen = {
        .names = {"Hydrogen", "H2"},
        .formula = "H2",
        .yaws_cp_coefficients_gas = {250, 1500, 25.399, 2.0178e-2, -3.8549e-5, 3.188e-8, -8.7585e-12 },
        .yaws_cp_coefficients_liq = {14, 32, 50.607, -6.1136, 3.093e-1, -4.148e-3},
        .yaws_cp_coefficients_solid = {12, 14, 5.707, 2.1779e-3, -3.8386e-5, },
        .T_critical = 33.18,
        .P_critical = 1.313e6,
};