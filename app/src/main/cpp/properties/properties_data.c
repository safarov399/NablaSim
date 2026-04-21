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

const ComponentProperties METHANE = {
        .names = {
                "Methane", "Carbane"
        },
        .formula = "CH4",
        .yaws_cp_coefficients_gas = {50, 1500, 34.942, -3.9957e-2, 1.9184e-4, -1.5303e-7, 3.9321e-11},
        .yaws_cp_coefficients_liq = {92, 172, -0.018, 1.1982, -9.8722e-3, 3.167e-5},
        .yaws_cp_coefficients_solid = {21, 90, 5.27, 7.1386e-1, -3.2653e-3},
        .T_critical = 190.58,
        .P_critical = 4.604 * 1e6,
};

const ComponentProperties ETHANE = {
        .names = {
                "Ethane", "Dicarbane"
        },
        .formula = "C2H6",
        .yaws_cp_coefficients_gas = {100, 1500, 28.146, 4.3447e-2, 1.8946e-4, -1.9082e-7, 5.3349e-11},
        .yaws_cp_coefficients_liq = {91, 275, 38.332, 4.1006e-1, -2.3024e-3, 5.9347e-6},
        .yaws_cp_coefficients_solid = {30, 80, -9.6, 8.6284e-1, -3.017e-4},
        .T_critical = 305.42,
        .P_critical = 4.88 * 1e6,
};

const ComponentProperties PROPANE = {
        .names = {
                "Propane", "Tricarbane"
        },
        .formula = "C3H8",
        .yaws_cp_coefficients_gas = {100, 1500, 28.277, 1.16e-1, 1.9597e-4, -2.3271e-7, 6.8669e-11},
        .yaws_cp_coefficients_liq = {86, 333, 59.642, 3.2831e-1, -1.5377e-3, 3.6539e-6},
        .yaws_cp_coefficients_solid = {30, 84, -11.23, 1.059, -3.6e-3},
        .T_critical = 369.82,
        .P_critical = 42.49 * 1e5,
};

const ComponentProperties N_BUTANE = {
        .names = {
                "n-Butane"
        },
        .formula = "C4H10",
        .yaws_cp_coefficients_gas = {200, 1500, 20.056, 2.8153e-1, -1.3143e-5, -9.4571e-8, 3.4149e-11},
        .yaws_cp_coefficients_liq = {136, 383, 62.873, 5.8913e-1, -2.3588e-3, 4.2257e-6},
        .yaws_cp_coefficients_solid = {20, 108, -13.596, 1.1691, -3.5716e-3},
        .T_critical = 425.18,
        .P_critical = 37.97 * 1e5,
};


//const ComponentProperties  = {
//        .names = {
//
//        },
//        .formula = "",
//        .yaws_cp_coefficients_gas = {},
//        .yaws_cp_coefficients_liq = {},
//        .yaws_cp_coefficients_solid = {},
//        .T_critical = 0,
//        .P_critical = 0,
//};