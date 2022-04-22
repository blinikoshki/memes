package com.memes.plus.data.source.purchase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/data/source/purchase/StoreInfo;", "", "()V", "freeTrialDays", "", "getFreeTrialDays", "()Ljava/lang/String;", "subscriptionType", "getSubscriptionType", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StoreInfo.kt */
public final class StoreInfo {
    @SerializedName("FreeTrialDaysForMemesAndroidNew")
    @Expose
    private final String freeTrialDays;
    @SerializedName("NewIAPProductTypeMemesAndroid")
    @Expose
    private final String subscriptionType;

    public final String getSubscriptionType() {
        return this.subscriptionType;
    }

    public final String getFreeTrialDays() {
        return this.freeTrialDays;
    }
}
