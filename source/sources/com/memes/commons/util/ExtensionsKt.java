package com.memes.commons.util;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.memes.commons.pagination.Paginator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringEscapeUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\t\u001a\f\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\u000b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u000b\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\n\u0010\u0017\u001a\u00020\u0007*\u00020\u0018\u001a\u0012\u0010\u0019\u001a\u00020\u000b*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b\u001a&\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001d\"\u0004\b\u0000\u0010\u001e*\n\u0012\u0004\u0012\u0002H\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0010\u001a\n\u0010 \u001a\u00020\u0007*\u00020\t\u001a\u001c\u0010!\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\"\u001a\u00020#2\b\b\u0001\u0010$\u001a\u00020\u0010\u001a\u001c\u0010!\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\"\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u000b\u001a\u0016\u0010&\u001a\u00020\u0007*\u0004\u0018\u00010\u00112\b\b\u0001\u0010$\u001a\u00020\u0010\u001a\u0016\u0010&\u001a\u00020\u0007*\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u000b¨\u0006'"}, mo26107d2 = {"addPaginator", "Lcom/memes/commons/pagination/Paginator;", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "function", "Lkotlin/Function0;", "", "clearText", "Landroid/widget/EditText;", "decode", "", "encode", "flatten", "Landroid/os/Bundle;", "getColorFromAttr", "", "Landroid/content/Context;", "attrColor", "typedValue", "Landroid/util/TypedValue;", "resolveRefs", "", "hideStatusBar", "Landroidx/appcompat/app/AppCompatActivity;", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "readOnly", "", "T", "count", "setMultiLineCapSentencesAndDoneAction", "snack", "anchorView", "Landroid/view/View;", "messageRes", "message", "toast", "commons_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final void toast(Context context, String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            Toast.makeText(context, charSequence, 0).show();
        }
    }

    public static final void toast(Context context, int i) {
        toast(context, context != null ? context.getString(i) : null);
    }

    public static final void snack(Context context, View view, String str) {
        Intrinsics.checkNotNullParameter(context, "$this$snack");
        Intrinsics.checkNotNullParameter(view, "anchorView");
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            Snackbar.make(view, charSequence, -1).show();
        }
    }

    public static final void snack(Context context, View view, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$snack");
        Intrinsics.checkNotNullParameter(view, "anchorView");
        snack(context, view, context.getString(i));
    }

    public static final void clearText(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$clearText");
        editText.setText("");
    }

    public static final void setMultiLineCapSentencesAndDoneAction(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$setMultiLineCapSentencesAndDoneAction");
        editText.setImeOptions(6);
        editText.setRawInputType(147456);
    }

    public static final void hideStatusBar(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$hideStatusBar");
        appCompatActivity.requestWindowFeature(1);
        appCompatActivity.getWindow().setFlags(1024, 1024);
    }

    public static final <T> List<T> readOnly(List<T> list, int i) {
        List<T> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        if (list.size() > i) {
            return list.subList(0, i);
        }
        arrayList.addAll(list);
        return arrayList;
    }

    public static final Paginator addPaginator(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$addPaginator");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(function0, "function");
        Paginator create = Paginator.Companion.create(layoutManager, recyclerView);
        create.setOnLoadMoreListener(new C4167xf46c5ef5(function0));
        return create;
    }

    public static final String encode(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        if (StringsKt.isBlank(charSequence)) {
            return StringsKt.trim(charSequence).toString();
        }
        return StringEscapeUtils.unescapeJava(str);
    }

    public static final String decode(String str) {
        if (str == null) {
            return "";
        }
        CharSequence charSequence = str;
        if (StringsKt.isBlank(charSequence)) {
            return StringsKt.trim(charSequence).toString();
        }
        String escapeJava = StringEscapeUtils.escapeJava(str);
        Intrinsics.checkNotNullExpressionValue(escapeJava, "StringEscapeUtils.escapeJava(this)");
        return escapeJava;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        kotlin.p017io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readAssetsFile(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "$this$readAssetsFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            java.io.Reader r0 = (java.io.Reader) r0
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0023
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x002b
        L_0x0023:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x002b:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x003d }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x003d }
            java.lang.String r2 = kotlin.p017io.TextStreamsKt.readText(r2)     // Catch:{ all -> 0x003d }
            kotlin.p017io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x003d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            kotlin.p017io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.commons.util.ExtensionsKt.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    public static /* synthetic */ int getColorFromAttr$default(Context context, int i, TypedValue typedValue, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return getColorFromAttr(context, i, typedValue, z);
    }

    public static final int getColorFromAttr(Context context, int i, TypedValue typedValue, boolean z) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorFromAttr");
        Intrinsics.checkNotNullParameter(typedValue, "typedValue");
        context.getTheme().resolveAttribute(i, typedValue, z);
        return typedValue.data;
    }

    public static final String flatten(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "$this$flatten");
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        for (String str : keySet) {
            sb.append(str + ": " + bundle.get(str));
            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        }
        sb.append("}");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
