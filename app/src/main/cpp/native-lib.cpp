#include <jni.h>
#include <string>

extern "C"
jstring Java_hello_1android_vgame_com_helloandroid_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring Java_hello_1android_vgame_com_helloandroid_MainActivity_customMethodJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello android C++";
    return env->NewStringUTF(hello.c_str());
}
