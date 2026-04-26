#include <jni.h>
#include "EOS/ideal_gas/ideal_gas.h"
#include "EOS/ideal_gas/target_vars.h"

JNIEXPORT jdouble JNICALL Java_me_safarov399_nablasim_ScreenSecondKt_idealGas(
        JNIEnv *env,
        jobject thiz,
        jdouble P, jdouble V, jdouble n, jdouble T, jint target_var) {
    if (target_var == IDEAL_GAS_TARGET_PRESSURE) return ideal_gas(&P, ideal_gas_residue, &P, &V, &n, &T);
    if (target_var == IDEAL_GAS_TARGET_VOLUME) return ideal_gas(&V, ideal_gas_residue, &P, &V, &n, &T);
    if (target_var == IDEAL_GAS_TARGET_MOLES) return ideal_gas(&n, ideal_gas_residue, &P, &V, &n, &T);
    return ideal_gas(&T, ideal_gas_residue, &P, &V, &n, &T);
}