package com.memes.commons.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/commons/util/Intents;", "", "()V", "getEmailIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "emailAddress", "", "subject", "message", "getPhotoPickerIntent", "getPhotoPickerLegacyIntent", "getPlayStoreIntent", "packageName", "getPlayStoreLegacyIntent", "getTakePhotoIntent", "outputPhotoUri", "Landroid/net/Uri;", "getVideoPickerIntent", "getVideoPickerLegacyIntent", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Intents.kt */
public final class Intents {
    public static final Intents INSTANCE = new Intents();

    private Intents() {
    }

    public static /* synthetic */ Intent getTakePhotoIntent$default(Intents intents, Context context, Uri uri, int i, Object obj) {
        if ((i & 2) != 0) {
            uri = null;
        }
        return intents.getTakePhotoIntent(context, uri);
    }

    public final Intent getTakePhotoIntent(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (uri != null) {
            intent.putExtra("output", uri);
        }
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return getPhotoPickerLegacyIntent(context);
    }

    public final Intent getPhotoPickerIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/jpeg");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/bmp", "image/png"});
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return getPhotoPickerLegacyIntent(context);
    }

    private final Intent getPhotoPickerLegacyIntent(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setTypeAndNormalize("image/jpeg");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/bmp", "image/png"});
        intent.addCategory("android.intent.category.OPENABLE");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return Intent.createChooser(intent, "Select Photo");
        }
        return null;
    }

    public final Intent getVideoPickerIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("video/mp4");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return getVideoPickerLegacyIntent(context);
    }

    private final Intent getVideoPickerLegacyIntent(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setTypeAndNormalize("video/mp4");
        intent.addCategory("android.intent.category.OPENABLE");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return Intent.createChooser(intent, "Select Video");
        }
        return null;
    }

    public final Intent getEmailIntent(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "emailAddress");
        Intrinsics.checkNotNullParameter(str2, "subject");
        Intrinsics.checkNotNullParameter(str3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        CharSequence charSequence = str;
        if (StringsKt.isBlank(charSequence) || !StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:" + str));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", str3);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }

    public static /* synthetic */ Intent getPlayStoreIntent$default(Intents intents, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(str, "context.packageName");
        }
        return intents.getPlayStoreIntent(context, str);
    }

    public final Intent getPlayStoreIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.setPackage("com.android.vending");
        intent.addFlags(1208483840);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return getPlayStoreLegacyIntent(context, str);
    }

    private final Intent getPlayStoreLegacyIntent(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }
}
