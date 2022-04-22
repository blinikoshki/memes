package org.jetbrains.anko;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0017\u0010\t\u001a\u00020\u0001*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u0001\u001a\u0017\u0010\t\u001a\u00020\u0001*\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\b\u001a\u001b\u0010\t\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0001\u0010\u000b\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0012\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0012\u0010\u0012\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0015\u0010\u0012\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0019\u0010\u0012\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0014\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0012\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0015\u0010\u0014\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0019\u0010\u0014\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0019\u0010\u0015\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\b\u001a\u0019\u0010\u0015\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"HDPI", "", "LDPI", "MAXDPI", "MDPI", "TVDPI", "XHDPI", "XXHDPI", "XXXHDPI", "dimen", "Landroid/app/Fragment;", "resource", "Landroid/content/Context;", "Landroid/view/View;", "Lorg/jetbrains/anko/AnkoContext;", "dip", "value", "", "px2dip", "px", "px2sp", "sp", "commons_release"}, mo26108k = 2, mo26109mv = {1, 1, 5})
/* compiled from: Dimensions.kt */
public final class DimensionsKt {
    public static final int HDPI = 240;
    public static final int LDPI = 120;
    public static final int MAXDPI = 65534;
    public static final int MDPI = 160;
    public static final int TVDPI = 213;
    public static final int XHDPI = 320;
    public static final int XXHDPI = 480;
    public static final int XXXHDPI = 640;

    public static final int dip(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return (int) (((float) i) * context.getResources().getDisplayMetrics().density);
    }

    public static final int dip(Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: sp */
    public static final int m236sp(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return (int) (((float) i) * context.getResources().getDisplayMetrics().scaledDensity);
    }

    /* renamed from: sp */
    public static final int m235sp(Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return (int) (f * context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static final float px2dip(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return ((float) i) / context.getResources().getDisplayMetrics().density;
    }

    public static final float px2sp(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return ((float) i) / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final int dimen(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final int dip(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dip(ankoContext.getCtx(), i);
    }

    public static final int dip(AnkoContext<?> ankoContext, float f) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dip(ankoContext.getCtx(), f);
    }

    /* renamed from: sp */
    public static final int m240sp(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return m236sp(ankoContext.getCtx(), i);
    }

    /* renamed from: sp */
    public static final int m239sp(AnkoContext<?> ankoContext, float f) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return m235sp(ankoContext.getCtx(), f);
    }

    public static final float px2dip(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return px2dip(ankoContext.getCtx(), i);
    }

    public static final float px2sp(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return px2sp(ankoContext.getCtx(), i);
    }

    public static final int dimen(AnkoContext<?> ankoContext, int i) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        return dimen(ankoContext.getCtx(), i);
    }

    public static final int dip(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return dip(view.getContext(), i);
    }

    public static final int dip(View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return dip(view.getContext(), f);
    }

    /* renamed from: sp */
    public static final int m238sp(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return m236sp(view.getContext(), i);
    }

    /* renamed from: sp */
    public static final int m237sp(View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return m235sp(view.getContext(), f);
    }

    public static final float px2dip(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return px2dip(view.getContext(), i);
    }

    public static final float px2sp(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return px2sp(view.getContext(), i);
    }

    public static final int dimen(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return dimen(view.getContext(), i);
    }

    public static final int dip(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return dip((Context) fragment.getActivity(), i);
    }

    public static final int dip(Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return dip((Context) fragment.getActivity(), f);
    }

    /* renamed from: sp */
    public static final int m234sp(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return m236sp((Context) fragment.getActivity(), i);
    }

    /* renamed from: sp */
    public static final int m233sp(Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return m235sp((Context) fragment.getActivity(), f);
    }

    public static final float px2dip(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return px2dip((Context) fragment.getActivity(), i);
    }

    public static final float px2sp(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return px2sp((Context) fragment.getActivity(), i);
    }

    public static final int dimen(Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        return dimen((Context) fragment.getActivity(), i);
    }
}
