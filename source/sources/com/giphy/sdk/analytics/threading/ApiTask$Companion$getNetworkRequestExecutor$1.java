package com.giphy.sdk.analytics.threading;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty0;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: ApiTask.kt */
final class ApiTask$Companion$getNetworkRequestExecutor$1 extends MutablePropertyReference0 {
    public static final KMutableProperty0 INSTANCE = new ApiTask$Companion$getNetworkRequestExecutor$1();

    ApiTask$Companion$getNetworkRequestExecutor$1() {
    }

    public String getName() {
        return "NETWORK_REQUEST_EXECUTOR";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(ApiTaskKt.class, "giphy-android-sdk-analytics_release");
    }

    public String getSignature() {
        return "getNETWORK_REQUEST_EXECUTOR()Ljava/util/concurrent/ExecutorService;";
    }

    public Object get() {
        return ApiTaskKt.access$getNETWORK_REQUEST_EXECUTOR$p();
    }

    public void set(Object obj) {
        ApiTaskKt.NETWORK_REQUEST_EXECUTOR = (ExecutorService) obj;
    }
}
