package com.memes.plus.p040ui.subscription.eventreporter.source;

import android.content.Context;
import com.google.gson.Gson;
import com.memes.plus.p040ui.subscription.eventreporter.LocalPurchaseRecord;
import com.memes.plus.util.Constants;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.FilesKt;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/ui/subscription/eventreporter/source/FileBackedSubscriptionReporter;", "Lcom/memes/plus/ui/subscription/eventreporter/source/BaseSubscriptionReporter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "perDayMillis", "", "purchaseRecordFile", "Ljava/io/File;", "purchaseRecordFileName", "", "purchaseRecordFolderName", "getLocalPurchaseRecord", "Lcom/memes/plus/ui/subscription/eventreporter/LocalPurchaseRecord;", "getSubscriptionGraceMillis", "productSku", "getSubscriptionMillis", "getTrialGraceMillis", "getTrialMillis", "hasLocalPurchaseRecord", "", "saveLocalPurchaseRecord", "", "localPurchaseRecord", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.subscription.eventreporter.source.FileBackedSubscriptionReporter */
/* compiled from: FileBackedSubscriptionReporter.kt */
public final class FileBackedSubscriptionReporter extends BaseSubscriptionReporter {
    private final long perDayMillis = DateUtils.MILLIS_PER_DAY;
    private final File purchaseRecordFile;
    private final String purchaseRecordFileName = "subscription-purchase-record.file";
    private final String purchaseRecordFolderName = "record";

    public FileBackedSubscriptionReporter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File cacheDir = context.getCacheDir();
        this.purchaseRecordFile = new File(cacheDir, "record" + '/' + "subscription-purchase-record.file");
    }

    /* access modifiers changed from: protected */
    public long getTrialMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        if (hashCode == -2009567370) {
            boolean equals = str.equals(Constants.ANNUAL_SKU);
        } else if (hashCode == 709777759) {
            boolean equals2 = str.equals(Constants.MONTHLY_SKU);
        }
        return ((long) 30) * this.perDayMillis;
    }

    /* access modifiers changed from: protected */
    public long getTrialGraceMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        int i = 4;
        if (hashCode != -2009567370) {
            if (hashCode == 709777759) {
                boolean equals = str.equals(Constants.MONTHLY_SKU);
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            i = 8;
        }
        return ((long) i) * this.perDayMillis;
    }

    /* access modifiers changed from: protected */
    public long getSubscriptionMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        int i = 30;
        if (hashCode != -2009567370) {
            if (hashCode == 709777759) {
                boolean equals = str.equals(Constants.MONTHLY_SKU);
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            i = 365;
        }
        return ((long) i) * this.perDayMillis;
    }

    /* access modifiers changed from: protected */
    public long getSubscriptionGraceMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "productSku");
        int hashCode = str.hashCode();
        int i = 4;
        if (hashCode != -2009567370) {
            if (hashCode == 709777759) {
                boolean equals = str.equals(Constants.MONTHLY_SKU);
            }
        } else if (str.equals(Constants.ANNUAL_SKU)) {
            i = 8;
        }
        return ((long) i) * this.perDayMillis;
    }

    public LocalPurchaseRecord getLocalPurchaseRecord() {
        Object fromJson = new Gson().fromJson(FilesKt.readText$default(this.purchaseRecordFile, (Charset) null, 1, (Object) null), LocalPurchaseRecord.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(localPur…rchaseRecord::class.java)");
        return (LocalPurchaseRecord) fromJson;
    }

    public void saveLocalPurchaseRecord(LocalPurchaseRecord localPurchaseRecord) {
        Intrinsics.checkNotNullParameter(localPurchaseRecord, "localPurchaseRecord");
        String json = new Gson().toJson((Object) localPurchaseRecord);
        if (!this.purchaseRecordFile.exists()) {
            File parentFile = this.purchaseRecordFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            this.purchaseRecordFile.createNewFile();
        }
        File file = this.purchaseRecordFile;
        Intrinsics.checkNotNullExpressionValue(json, "localPurchaseRecordJson");
        FilesKt.writeText$default(file, json, (Charset) null, 2, (Object) null);
    }

    public boolean hasLocalPurchaseRecord() {
        return this.purchaseRecordFile.exists();
    }
}
