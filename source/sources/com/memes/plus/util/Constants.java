package com.memes.plus.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/util/Constants;", "", "()V", "ANNUAL_SKU", "", "ANNUAL_SKU_DEFAULT_DISPLAY_PRICE", "MONTHLY_SKU", "MONTHLY_SKU_DEFAULT_DISPLAY_PRICE", "PASSWORD_MAX_LENGTH", "", "PASSWORD_MIN_LENGTH", "UNUSUAL_ERROR", "activeSkuList", "", "allSkuList", "createPlayStoreSubscriptionsUrl", "context", "Landroid/content/Context;", "targetSku", "legacySkuList", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Constants.kt */
public final class Constants {
    public static final String ANNUAL_SKU = "com.memes.subscription.yearly9";
    public static final String ANNUAL_SKU_DEFAULT_DISPLAY_PRICE = "$9.99";
    public static final Constants INSTANCE = new Constants();
    public static final String MONTHLY_SKU = "com.memes.subscription.monthly.9";
    public static final String MONTHLY_SKU_DEFAULT_DISPLAY_PRICE = "$0.99";
    public static final int PASSWORD_MAX_LENGTH = 64;
    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final String UNUSUAL_ERROR = "> Something went wrong.";

    private Constants() {
    }

    private final List<String> legacySkuList() {
        return CollectionsKt.listOf("com.memes.subscription.monthly", "com.memes.subscription.annual", "com.memes.subscription.monthly.new", "com.memes.subscription.annual.new");
    }

    private final List<String> activeSkuList() {
        return CollectionsKt.listOf(MONTHLY_SKU, ANNUAL_SKU);
    }

    public final List<String> allSkuList() {
        List<String> arrayList = new ArrayList<>();
        Constants constants = INSTANCE;
        arrayList.addAll(constants.legacySkuList());
        arrayList.addAll(constants.activeSkuList());
        return arrayList;
    }

    public final String createPlayStoreSubscriptionsUrl(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return "https://play.google.com/store/account/subscriptions";
        }
        return "https://play.google.com/store/account/subscriptions" + "?sku=" + str + "&package=" + context.getPackageName();
    }
}
