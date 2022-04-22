package org.jetbrains.anko.internals;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import editor.ffmpeg.api.FfmpegCommand;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.AnkoException;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002UVB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\fJ%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000fJ%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016JI\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010\u001eJ3\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0003¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J-\u0010#\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001aH\u0007¢\u0006\u0002\u0010%JC\u0010&\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010'JK\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a2\u0006\u0010*\u001a\u00020+2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010,JE\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u00101JC\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u00104J\u0006\u00105\u001a\u000206J\u0001\u00107\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u0001092\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u0001032\b\u0010@\u001a\u0004\u0018\u00010+2\b\u0010A\u001a\u0004\u0018\u00010+2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u0001032\b\u0010E\u001a\u0004\u0018\u0001032\b\u0010F\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010GJ0\u0010H\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010I\u001a\u00020J2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u0002H\u00070\u0016H\b¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020+JO\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00070P\"\u0004\b\u0000\u0010\u0007*\u0002H\u00072\u0006\u0010\r\u001a\u00020\u000e2\u001d\u0010Q\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070P\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\bR2\b\b\u0002\u0010S\u001a\u000203H\b¢\u0006\u0002\u0010TR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006W"}, mo26107d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals;", "", "()V", "NO_GETTER", "", "addView", "", "T", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Landroid/view/View;)V", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;Landroid/view/View;)V", "manager", "Landroid/view/ViewManager;", "(Landroid/view/ViewManager;Landroid/view/View;)V", "applyRecursively", "v", "style", "Lkotlin/Function1;", "createIntent", "Landroid/content/Intent;", "clazz", "Ljava/lang/Class;", "params", "", "Lkotlin/Pair;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Landroid/content/Intent;", "fillIntentArguments", "intent", "(Landroid/content/Intent;[Lkotlin/Pair;)V", "getContext", "initiateView", "viewClass", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "internalStartActivity", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)V", "internalStartActivityForResult", "act", "requestCode", "", "(Landroid/app/Activity;Ljava/lang/Class;I[Lkotlin/Pair;)V", "internalStartService", "Landroid/content/ComponentName;", "service", "Landroid/app/Service;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Landroid/content/ComponentName;", "internalStopService", "", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Z", "noGetter", "", "testConfiguration", "screenSize", "Lorg/jetbrains/anko/ScreenSize;", "density", "Lkotlin/ranges/ClosedRange;", "language", "orientation", "Lorg/jetbrains/anko/Orientation;", "long", "fromSdk", "sdk", "uiMode", "Lorg/jetbrains/anko/UiMode;", "nightMode", "rightToLeft", "smallestWidth", "(Landroid/content/Context;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Z", "useCursor", "cursor", "Landroid/database/Cursor;", "f", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "wrapContextIfNeeded", "theme", "createAnkoContext", "Lorg/jetbrains/anko/AnkoContext;", "init", "Lkotlin/ExtensionFunctionType;", "setContentView", "(Ljava/lang/Object;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Z)Lorg/jetbrains/anko/AnkoContext;", "AnkoContextThemeWrapper", "InternalConfiguration", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
/* compiled from: Internals.kt */
public final class AnkoInternals {
    public static final AnkoInternals INSTANCE = null;
    public static final String NO_GETTER = "Property does not have a getter";

    static {
        new AnkoInternals();
    }

    private AnkoInternals() {
        INSTANCE = this;
    }

    public final Void noGetter() {
        throw new AnkoException(NO_GETTER);
    }

    @Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo26107d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals$AnkoContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "getTheme", "()I", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
    /* compiled from: Internals.kt */
    private static final class AnkoContextThemeWrapper extends ContextThemeWrapper {
        private final int theme;

        public AnkoContextThemeWrapper(Context context, int i) {
            super(context, i);
            this.theme = i;
        }

        public final int getTheme() {
            return this.theme;
        }
    }

    public final <T extends View> void addView(ViewManager viewManager, T t) {
        Intrinsics.checkParameterIsNotNull(viewManager, "manager");
        Intrinsics.checkParameterIsNotNull(t, ViewHierarchyConstants.VIEW_KEY);
        if (viewManager instanceof ViewGroup) {
            ((ViewGroup) viewManager).addView(t);
        } else if (viewManager instanceof AnkoContext) {
            viewManager.addView(t, (ViewGroup.LayoutParams) null);
        } else {
            throw new AnkoException(viewManager + " is the wrong parent");
        }
    }

    public final Context wrapContextIfNeeded(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        if (i != 0) {
            return (!(context instanceof AnkoContextThemeWrapper) || ((AnkoContextThemeWrapper) context).getTheme() != i) ? new AnkoContextThemeWrapper(context, i) : context;
        }
        return context;
    }

    public final void applyRecursively(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, FfmpegCommand.VIDEO_STREAM);
        Intrinsics.checkParameterIsNotNull(function1, "style");
        function1.invoke(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount() - 1;
            int i = 0;
            if (childCount >= 0) {
                while (true) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        INSTANCE.applyRecursively(childAt, function1);
                        Unit unit = Unit.INSTANCE;
                    }
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final Context getContext(ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "manager");
        if (viewManager instanceof ViewGroup) {
            Context context = ((ViewGroup) viewManager).getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "manager.context");
            return context;
        } else if (viewManager instanceof AnkoContext) {
            return ((AnkoContext) viewManager).getCtx();
        } else {
            throw new AnkoException(viewManager + " is the wrong parent");
        }
    }

    public static /* bridge */ /* synthetic */ AnkoContext createAnkoContext$default(AnkoInternals ankoInternals, Object obj, Context context, Function1 function1, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, obj, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    public final <T> AnkoContext<T> createAnkoContext(T t, Context context, Function1<? super AnkoContext<? extends T>, Unit> function1, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, t, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals$InternalConfiguration;", "", "()V", "SCREENLAYOUT_LAYOUTDIR_MASK", "", "getSCREENLAYOUT_LAYOUTDIR_MASK", "()I", "SCREENLAYOUT_LAYOUTDIR_RTL", "getSCREENLAYOUT_LAYOUTDIR_RTL", "SCREENLAYOUT_LAYOUTDIR_SHIFT", "getSCREENLAYOUT_LAYOUTDIR_SHIFT", "UI_MODE_TYPE_APPLIANCE", "getUI_MODE_TYPE_APPLIANCE", "UI_MODE_TYPE_WATCH", "getUI_MODE_TYPE_WATCH", "commons_release"}, mo26108k = 1, mo26109mv = {1, 1, 5})
    /* compiled from: Internals.kt */
    private static final class InternalConfiguration {
        public static final InternalConfiguration INSTANCE = null;
        private static final int SCREENLAYOUT_LAYOUTDIR_MASK = 192;
        private static final int SCREENLAYOUT_LAYOUTDIR_RTL = 128;
        private static final int SCREENLAYOUT_LAYOUTDIR_SHIFT = 6;
        private static final int UI_MODE_TYPE_APPLIANCE = 5;
        private static final int UI_MODE_TYPE_WATCH = 6;

        static {
            new InternalConfiguration();
        }

        private InternalConfiguration() {
            INSTANCE = this;
            SCREENLAYOUT_LAYOUTDIR_MASK = 192;
            SCREENLAYOUT_LAYOUTDIR_SHIFT = 6;
            SCREENLAYOUT_LAYOUTDIR_RTL = 2 << 6;
            UI_MODE_TYPE_APPLIANCE = 5;
            UI_MODE_TYPE_WATCH = 6;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_MASK() {
            return SCREENLAYOUT_LAYOUTDIR_MASK;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_SHIFT() {
            return SCREENLAYOUT_LAYOUTDIR_SHIFT;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_RTL() {
            return SCREENLAYOUT_LAYOUTDIR_RTL;
        }

        public final int getUI_MODE_TYPE_APPLIANCE() {
            return UI_MODE_TYPE_APPLIANCE;
        }

        public final int getUI_MODE_TYPE_WATCH() {
            return UI_MODE_TYPE_WATCH;
        }
    }

    @JvmStatic
    public static final <T> Intent createIntent(Context context, Class<? extends T> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        Intent intent = new Intent(context, cls);
        if (!(((Object[]) pairArr).length == 0)) {
            fillIntentArguments(intent, pairArr);
        }
        return intent;
    }

    @JvmStatic
    public static final void internalStartActivity(Context context, Class<? extends Activity> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "activity");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        context.startActivity(createIntent(context, cls, pairArr));
    }

    @JvmStatic
    public static final void internalStartActivityForResult(Activity activity, Class<? extends Activity> cls, int i, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(activity, "act");
        Intrinsics.checkParameterIsNotNull(cls, "activity");
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        activity.startActivityForResult(createIntent(activity, cls, pairArr), i);
    }

    @JvmStatic
    public static final ComponentName internalStartService(Context context, Class<? extends Service> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        return context.startService(createIntent(context, cls, pairArr));
    }

    @JvmStatic
    public static final boolean internalStopService(Context context, Class<? extends Service> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        return context.stopService(createIntent(context, cls, pairArr));
    }

    @JvmStatic
    private static final void fillIntentArguments(Intent intent, Pair<String, ? extends Object>[] pairArr) {
        Object[] objArr = (Object[]) pairArr;
        for (Object obj : objArr) {
            Pair pair = (Pair) obj;
            Object second = pair.getSecond();
            if (Intrinsics.areEqual(second, (Object) null)) {
                intent.putExtra((String) pair.getFirst(), (Serializable) null);
            } else if (second instanceof Integer) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).intValue());
            } else if (second instanceof Long) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).longValue());
            } else if (second instanceof CharSequence) {
                intent.putExtra((String) pair.getFirst(), (CharSequence) second);
            } else if (second instanceof String) {
                intent.putExtra((String) pair.getFirst(), (String) second);
            } else if (second instanceof Float) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).floatValue());
            } else if (second instanceof Double) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).doubleValue());
            } else if (second instanceof Character) {
                intent.putExtra((String) pair.getFirst(), ((Character) second).charValue());
            } else if (second instanceof Short) {
                intent.putExtra((String) pair.getFirst(), ((Number) second).shortValue());
            } else if (second instanceof Boolean) {
                intent.putExtra((String) pair.getFirst(), ((Boolean) second).booleanValue());
            } else if (second instanceof Serializable) {
                intent.putExtra((String) pair.getFirst(), (Serializable) second);
            } else if (second instanceof Bundle) {
                intent.putExtra((String) pair.getFirst(), (Bundle) second);
            } else if (second instanceof Parcelable) {
                intent.putExtra((String) pair.getFirst(), (Parcelable) second);
            } else if (second instanceof Object[]) {
                Object[] objArr2 = (Object[]) second;
                if (objArr2 instanceof CharSequence[]) {
                    intent.putExtra((String) pair.getFirst(), (Serializable) second);
                } else if (objArr2 instanceof String[]) {
                    intent.putExtra((String) pair.getFirst(), (Serializable) second);
                } else if (objArr2 instanceof Parcelable[]) {
                    intent.putExtra((String) pair.getFirst(), (Serializable) second);
                } else {
                    throw new AnkoException("Intent extra " + ((String) pair.getFirst()) + " has wrong type " + objArr2.getClass().getName());
                }
            } else if (second instanceof int[]) {
                intent.putExtra((String) pair.getFirst(), (int[]) second);
            } else if (second instanceof long[]) {
                intent.putExtra((String) pair.getFirst(), (long[]) second);
            } else if (second instanceof float[]) {
                intent.putExtra((String) pair.getFirst(), (float[]) second);
            } else if (second instanceof double[]) {
                intent.putExtra((String) pair.getFirst(), (double[]) second);
            } else if (second instanceof char[]) {
                intent.putExtra((String) pair.getFirst(), (char[]) second);
            } else if (second instanceof short[]) {
                intent.putExtra((String) pair.getFirst(), (short[]) second);
            } else if (second instanceof boolean[]) {
                intent.putExtra((String) pair.getFirst(), (boolean[]) second);
            } else {
                throw new AnkoException("Intent extra " + ((String) pair.getFirst()) + " has wrong type " + second.getClass().getName());
            }
        }
    }

    @JvmStatic
    public static final <T> T useCursor(Cursor cursor, Function1<? super Cursor, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(cursor, "cursor");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        try {
            return function1.invoke(cursor);
        } finally {
            InlineMarker.finallyStart(1);
            try {
                cursor.close();
            } catch (Exception unused) {
            }
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r5 = r1.invoke().newInstance(new java.lang.Object[]{r5, null});
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, "getConstructor2().newInstance(ctx, null)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0045, code lost:
        return (android.view.View) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0067, code lost:
        throw new org.jetbrains.anko.AnkoException("Can't initiate View of class " + r6.getName() + ": can't find proper constructor");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002c */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> T initiateView(android.content.Context r5, java.lang.Class<T> r6) {
        /*
            java.lang.String r0 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "viewClass"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            org.jetbrains.anko.internals.AnkoInternals$initiateView$1 r0 = new org.jetbrains.anko.internals.AnkoInternals$initiateView$1
            r0.<init>(r6)
            org.jetbrains.anko.internals.AnkoInternals$initiateView$2 r1 = new org.jetbrains.anko.internals.AnkoInternals$initiateView$2
            r1.<init>(r6)
            r2 = 0
            r3 = 1
            org.jetbrains.anko.internals.AnkoInternals$initiateView$1 r0 = (org.jetbrains.anko.internals.AnkoInternals$initiateView$1) r0     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.reflect.Constructor r0 = r0.invoke()     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x002c }
            r4[r2] = r5     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.Object r0 = r0.newInstance(r4)     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.String r4 = "getConstructor1().newInstance(ctx)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)     // Catch:{ NoSuchMethodException -> 0x002c }
            android.view.View r0 = (android.view.View) r0     // Catch:{ NoSuchMethodException -> 0x002c }
            return r0
        L_0x002c:
            org.jetbrains.anko.internals.AnkoInternals$initiateView$2 r1 = (org.jetbrains.anko.internals.AnkoInternals$initiateView$2) r1     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.reflect.Constructor r0 = r1.invoke()     // Catch:{ NoSuchMethodException -> 0x0046 }
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x0046 }
            r1[r2] = r5     // Catch:{ NoSuchMethodException -> 0x0046 }
            r5 = 0
            r1[r3] = r5     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.Object r5 = r0.newInstance(r1)     // Catch:{ NoSuchMethodException -> 0x0046 }
            java.lang.String r0 = "getConstructor2().newInstance(ctx, null)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)     // Catch:{ NoSuchMethodException -> 0x0046 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ NoSuchMethodException -> 0x0046 }
            return r5
        L_0x0046:
            org.jetbrains.anko.AnkoException r5 = new org.jetbrains.anko.AnkoException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Can't initiate View of class "
            r0.append(r1)
            java.lang.String r6 = r6.getName()
            r0.append(r6)
            java.lang.String r6 = ": can't find proper constructor"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.internals.AnkoInternals.initiateView(android.content.Context, java.lang.Class):android.view.View");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01a2, code lost:
        if (r31.booleanValue() != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        if (r1 != r24.getEndInclusive().intValue()) goto L_0x008a;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean testConfiguration(android.content.Context r22, org.jetbrains.anko.ScreenSize r23, kotlin.ranges.ClosedRange<java.lang.Integer> r24, java.lang.String r25, org.jetbrains.anko.Orientation r26, java.lang.Boolean r27, java.lang.Integer r28, java.lang.Integer r29, org.jetbrains.anko.UiMode r30, java.lang.Boolean r31, java.lang.Boolean r32, java.lang.Integer r33) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r29
            r6 = r30
            r7 = r32
            r8 = r33
            java.lang.String r9 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r9)
            android.content.res.Resources r9 = r22.getResources()
            if (r9 == 0) goto L_0x0022
            android.content.res.Configuration r9 = r9.getConfiguration()
            goto L_0x0023
        L_0x0022:
            r9 = 0
        L_0x0023:
            r11 = 4
            r12 = 3
            r13 = 2
            r14 = 1
            r15 = 0
            if (r1 == 0) goto L_0x0062
            if (r9 != 0) goto L_0x002d
            return r15
        L_0x002d:
            int r10 = r9.screenLayout
            r10 = r10 & 15
            if (r10 == r14) goto L_0x0058
            if (r10 == r13) goto L_0x004e
            if (r10 == r12) goto L_0x0044
            if (r10 == r11) goto L_0x003a
            goto L_0x0062
        L_0x003a:
            org.jetbrains.anko.ScreenSize r10 = org.jetbrains.anko.ScreenSize.XLARGE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x0062
            return r15
        L_0x0044:
            org.jetbrains.anko.ScreenSize r10 = org.jetbrains.anko.ScreenSize.LARGE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x0062
            return r15
        L_0x004e:
            org.jetbrains.anko.ScreenSize r10 = org.jetbrains.anko.ScreenSize.NORMAL
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x0062
            return r15
        L_0x0058:
            org.jetbrains.anko.ScreenSize r10 = org.jetbrains.anko.ScreenSize.SMALL
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x0062
            return r15
        L_0x0062:
            if (r2 == 0) goto L_0x008a
            android.content.res.Resources r1 = r22.getResources()
            if (r1 == 0) goto L_0x0089
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            if (r1 == 0) goto L_0x0089
            int r1 = r1.densityDpi
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            boolean r10 = r2.contains(r10)
            r10 = r10 ^ r14
            if (r10 != 0) goto L_0x0089
            java.lang.Comparable r2 = r24.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r1 != r2) goto L_0x008a
        L_0x0089:
            return r15
        L_0x008a:
            if (r3 == 0) goto L_0x00b5
            java.util.Locale r1 = java.util.Locale.getDefault()
            r16 = r3
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            r17 = 95
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r16, (char) r17, (int) r18, (boolean) r19, (int) r20, (java.lang.Object) r21)
            if (r2 < 0) goto L_0x00a9
            java.lang.String r1 = r1.toString()
            goto L_0x00ad
        L_0x00a9:
            java.lang.String r1 = r1.getLanguage()
        L_0x00ad:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x00b5
            return r15
        L_0x00b5:
            if (r4 == 0) goto L_0x00e1
            if (r9 != 0) goto L_0x00ba
            return r15
        L_0x00ba:
            int r1 = r9.orientation
            if (r1 == r14) goto L_0x00d7
            if (r1 == r13) goto L_0x00cd
            if (r1 == r12) goto L_0x00c3
            goto L_0x00e1
        L_0x00c3:
            org.jetbrains.anko.Orientation r1 = org.jetbrains.anko.Orientation.SQUARE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x00e1
            return r15
        L_0x00cd:
            org.jetbrains.anko.Orientation r1 = org.jetbrains.anko.Orientation.LANDSCAPE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x00e1
            return r15
        L_0x00d7:
            org.jetbrains.anko.Orientation r1 = org.jetbrains.anko.Orientation.PORTRAIT
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x00e1
            return r15
        L_0x00e1:
            if (r27 == 0) goto L_0x0100
            if (r9 != 0) goto L_0x00e6
            return r15
        L_0x00e6:
            int r1 = r9.screenLayout
            r1 = r1 & 48
            r2 = 32
            if (r1 != r2) goto L_0x00f5
            boolean r2 = r27.booleanValue()
            if (r2 != 0) goto L_0x00f5
            return r15
        L_0x00f5:
            r2 = 16
            if (r1 != r2) goto L_0x0100
            boolean r1 = r27.booleanValue()
            if (r1 == 0) goto L_0x0100
            return r15
        L_0x0100:
            if (r28 == 0) goto L_0x010f
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = r28.intValue()
            int r1 = kotlin.jvm.internal.Intrinsics.compare((int) r1, (int) r2)
            if (r1 >= 0) goto L_0x010f
            return r15
        L_0x010f:
            if (r5 == 0) goto L_0x011f
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x011f
            return r15
        L_0x011f:
            if (r6 == 0) goto L_0x017c
            if (r9 != 0) goto L_0x0124
            return r15
        L_0x0124:
            int r1 = r9.uiMode
            r1 = r1 & 15
            if (r1 != r14) goto L_0x0134
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.NORMAL
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x017c
            return r15
        L_0x0134:
            if (r1 != r13) goto L_0x0140
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.DESK
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x017c
            return r15
        L_0x0140:
            if (r1 != r12) goto L_0x014c
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.CAR
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x017c
            return r15
        L_0x014c:
            if (r1 != r11) goto L_0x0158
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.TELEVISION
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x017c
            return r15
        L_0x0158:
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r2 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r2 = r2.getUI_MODE_TYPE_APPLIANCE()
            if (r1 != r2) goto L_0x016a
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.APPLIANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x017c
            return r15
        L_0x016a:
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r2 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r2 = r2.getUI_MODE_TYPE_WATCH()
            if (r1 != r2) goto L_0x017c
            org.jetbrains.anko.UiMode r1 = org.jetbrains.anko.UiMode.WATCH
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x017c
            return r15
        L_0x017c:
            if (r31 == 0) goto L_0x01a5
            java.lang.String r1 = "uimode"
            java.lang.Object r0 = r0.getSystemService(r1)
            boolean r1 = r0 instanceof android.app.UiModeManager
            if (r1 != 0) goto L_0x018a
            r10 = 0
            goto L_0x018b
        L_0x018a:
            r10 = r0
        L_0x018b:
            android.app.UiModeManager r10 = (android.app.UiModeManager) r10
            if (r10 == 0) goto L_0x01a4
            int r0 = r10.getNightMode()
            if (r0 != r13) goto L_0x019c
            boolean r1 = r31.booleanValue()
            if (r1 != 0) goto L_0x019c
            return r15
        L_0x019c:
            if (r0 != r14) goto L_0x01a5
            boolean r0 = r31.booleanValue()
            if (r0 == 0) goto L_0x01a5
        L_0x01a4:
            return r15
        L_0x01a5:
            if (r7 == 0) goto L_0x01ca
            if (r9 != 0) goto L_0x01aa
            return r15
        L_0x01aa:
            int r0 = r9.screenLayout
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r1 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r1 = r1.getSCREENLAYOUT_LAYOUTDIR_MASK()
            r0 = r0 & r1
            org.jetbrains.anko.internals.AnkoInternals$InternalConfiguration r1 = org.jetbrains.anko.internals.AnkoInternals.InternalConfiguration.INSTANCE
            int r1 = r1.getSCREENLAYOUT_LAYOUTDIR_RTL()
            if (r0 != r1) goto L_0x01bd
            r0 = 1
            goto L_0x01be
        L_0x01bd:
            r0 = 0
        L_0x01be:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            r0 = r0 ^ r14
            if (r0 == 0) goto L_0x01ca
            return r15
        L_0x01ca:
            if (r8 == 0) goto L_0x01ec
            if (r9 != 0) goto L_0x01cf
            return r15
        L_0x01cf:
            int r0 = r9.smallestScreenWidthDp
            if (r0 != 0) goto L_0x01df
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            r0 = r0 ^ r14
            if (r0 == 0) goto L_0x01ec
            return r15
        L_0x01df:
            int r0 = r9.smallestScreenWidthDp
            int r1 = r33.intValue()
            int r0 = kotlin.jvm.internal.Intrinsics.compare((int) r0, (int) r1)
            if (r0 >= 0) goto L_0x01ec
            return r15
        L_0x01ec:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.internals.AnkoInternals.testConfiguration(android.content.Context, org.jetbrains.anko.ScreenSize, kotlin.ranges.ClosedRange, java.lang.String, org.jetbrains.anko.Orientation, java.lang.Boolean, java.lang.Integer, java.lang.Integer, org.jetbrains.anko.UiMode, java.lang.Boolean, java.lang.Boolean, java.lang.Integer):boolean");
    }

    public final <T extends View> void addView(Context context, T t) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(t, ViewHierarchyConstants.VIEW_KEY);
        INSTANCE.addView((ViewManager) new AnkoContextImpl(context, context, false), t);
    }

    public final <T extends View> void addView(Activity activity, T t) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(t, ViewHierarchyConstants.VIEW_KEY);
        INSTANCE.addView((ViewManager) new AnkoContextImpl(activity, this, true), t);
    }
}
