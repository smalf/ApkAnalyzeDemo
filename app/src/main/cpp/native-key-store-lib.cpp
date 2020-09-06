#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_softserveinc_smal_apkanalyzedemo_MainActivity_nativeSecretToken(
        JNIEnv* env,
        jobject /* this */) {
    std::string secretToken = "native_secret_token";
    return env->NewStringUTF(secretToken.c_str());
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_softserveinc_smal_apkanalyzedemo_DemoApplication_nativeBannerAdID(
        JNIEnv* env,
        jobject /* this */) {
    std::string bannerAdId = "ABCDEF012345";
    return env->NewStringUTF(bannerAdId.c_str());
}

