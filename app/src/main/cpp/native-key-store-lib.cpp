#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_softserveinc_smal_apkanalyzedemo_MainActivity_nativeSecretToken(
        JNIEnv* env,
        jobject /* this */) {
    std::string secretToken = "native_secret_token";
    return env->NewStringUTF(secretToken.c_str());
}