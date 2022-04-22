package com.memes.plus.util.picasso;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\b"}, mo26107d2 = {"log", "Lcom/squareup/picasso/Picasso;", "caller", "", "target", "", "info", "tag", "app_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: PicassoExt.kt */
public final class PicassoExtKt {
    public static /* synthetic */ Picasso log$default(Picasso picasso, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return log(picasso, str, str2, str3);
    }

    public static final Picasso log(Picasso picasso, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(picasso, "$this$log");
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        if (str3 == null) {
            Timber.m306i("Picasso is loading " + str2 + " via " + str, new Object[0]);
        } else {
            Timber.m306i("Picasso is loading " + str2 + " via " + str + " (info: " + str3 + ')', new Object[0]);
        }
        return picasso;
    }

    public static /* synthetic */ Picasso log$default(Picasso picasso, Object obj, String str, String str2, int i, Object obj2) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return log(picasso, obj, str, str2);
    }

    public static final Picasso log(Picasso picasso, Object obj, String str, String str2) {
        Intrinsics.checkNotNullParameter(picasso, "$this$log");
        Intrinsics.checkNotNullParameter(obj, "caller");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "caller.javaClass.simpleName");
        return log(picasso, simpleName, str, str2);
    }
}
