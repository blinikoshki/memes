package com.memes.uritool.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, mo26107d2 = {"Lcom/memes/uritool/util/ContentResolverUtil;", "", "()V", "dataColumn", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentResolverUtil.kt */
public final class ContentResolverUtil {
    public static final ContentResolverUtil INSTANCE = new ContentResolverUtil();

    private ContentResolverUtil() {
    }

    public final String dataColumn(Context context, Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            Timber.m300d("We can't knock DataColumn's door without uri; Uri is null.", new Object[0]);
            return null;
        }
        String arrays = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        Timber.m300d("We are knocking DataColumn's door; selection=%s, selectionArgs=%s", str, arrays);
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                Timber.m300d("We were knocking DataColumn's door; but returned empty-handed", new Object[0]);
                return null;
            }
            int columnIndex = cursor.getColumnIndex("_data");
            if (columnIndex == -1) {
                Timber.m300d("We were knocking DataColumn's door; but column not found;", new Object[0]);
                cursor.close();
                return null;
            }
            String string = cursor.getString(columnIndex);
            Timber.m300d("We were knocking DataColumn's door; found=" + string, new Object[0]);
            cursor.close();
            return string;
        } catch (IllegalArgumentException e) {
            Timber.m300d("We were knocking DataColumn's door; but error happened. error=" + e.getMessage(), new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (SecurityException e2) {
            Timber.m300d("We were knocking DataColumn's door; but error happened. error=" + e2.getMessage(), new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
