package com.giphy.sdk.analytics.threading;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty0;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: ApiTask.kt */
final class ApiTask$Companion$getCompletionExecutor$1 extends MutablePropertyReference0 {
    public static final KMutableProperty0 INSTANCE = new ApiTask$Companion$getCompletionExecutor$1();

    ApiTask$Companion$getCompletionExecutor$1() {
    }

    public String getName() {
        return "COMPLETION_EXECUTOR";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ApiTaskKt.class, "giphy-android-sdk-analytics_release");
    }

    public String getSignature() {
        return "getCOMPLETION_EXECUTOR()Ljava/util/concurrent/Executor;";
    }

    public Object get() {
        return ApiTaskKt.access$getCOMPLETION_EXECUTOR$p();
    }

    public void set(Object obj) {
        ApiTaskKt.COMPLETION_EXECUTOR = (Executor) obj;
    }
}
