#include <jni.h>
#include "EOS/ideal_gas.c"
#include "EOS/target_vars.h"


extern "C" JNIEXPORT jstring JNICALL
Java_me_safarov399_idealgassolver_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    char hello[] = "Hello from C++";
    return env->NewStringUTF(hello);
}

extern "C" double
Java_me_safarov399_nablasim_MainActivity_idealGasResidue(
        JNIEnv *env,
        jobject,
        double P, double V, double n, double T, int target_var) {

    if (target_var == IDEAL_GAS_TARGET_PRESSURE) return ideal_gas(&P, ideal_gas_residue, &P, &V, &n, &T);
    if (target_var == IDEAL_GAS_TARGET_VOLUME) return ideal_gas(&V, ideal_gas_residue, &P, &V, &n, &T);
    if (target_var == IDEAL_GAS_TARGET_MOLES) return ideal_gas(&n, ideal_gas_residue, &P, &V, &n, &T);
    return ideal_gas(&T, ideal_gas_residue, &P, &V, &n, &T);
}