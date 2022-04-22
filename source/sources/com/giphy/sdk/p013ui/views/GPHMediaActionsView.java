package com.giphy.sdk.p013ui.views;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.User;
import com.giphy.sdk.p013ui.C1800R;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/GPHMediaActionsView;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "actions", "", "Lcom/giphy/sdk/ui/views/GPHActions;", "(Landroid/content/Context;[Lcom/giphy/sdk/ui/views/GPHActions;)V", "getActions", "()[Lcom/giphy/sdk/ui/views/GPHActions;", "[Lcom/giphy/sdk/ui/views/GPHActions;", "getContext", "()Landroid/content/Context;", "value", "Lcom/giphy/sdk/core/models/Media;", "media", "getMedia", "()Lcom/giphy/sdk/core/models/Media;", "setMedia", "(Lcom/giphy/sdk/core/models/Media;)V", "onShowMore", "Lkotlin/Function1;", "", "", "getOnShowMore", "()Lkotlin/jvm/functions/Function1;", "setOnShowMore", "(Lkotlin/jvm/functions/Function1;)V", "shadowSize", "", "copyLink", "Landroid/view/View$OnClickListener;", "saveToClipboard", "url", "showMoreAction", "viewOnGiphyAction", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaActionsView */
/* compiled from: GPHMediaActionsView.kt */
public final class GPHMediaActionsView extends PopupWindow {
    private final GPHActions[] actions;
    private final Context context;
    private Media media;
    private Function1<? super String, Unit> onShowMore = GPHMediaActionsView$onShowMore$1.INSTANCE;
    private final int shadowSize;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.views.GPHMediaActionsView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GPHActions.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GPHActions.SearchMore.ordinal()] = 1;
            iArr[GPHActions.CopyLink.ordinal()] = 2;
            iArr[GPHActions.OpenGiphy.ordinal()] = 3;
        }
    }

    public GPHMediaActionsView(Context context2, GPHActions[] gPHActionsArr) {
        Intrinsics.checkParameterIsNotNull(gPHActionsArr, "actions");
        this.context = context2;
        this.actions = gPHActionsArr;
        int px = IntExtensionsKt.getPx(2);
        this.shadowSize = px;
        setContentView(View.inflate(context2, C1800R.C1804layout.gph_actions_view, (ViewGroup) null));
        setWidth(-2);
        setHeight(-2);
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation((float) px);
        } else {
            ViewCompat.setElevation(getContentView(), (float) px);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            setOverlapAnchor(true);
        }
        View contentView = getContentView();
        Intrinsics.checkExpressionValueIsNotNull(contentView, "contentView");
        ((TextView) contentView.findViewById(C1800R.C1803id.gphActionMore)).setOnClickListener(showMoreAction());
        View contentView2 = getContentView();
        Intrinsics.checkExpressionValueIsNotNull(contentView2, "contentView");
        ((TextView) contentView2.findViewById(C1800R.C1803id.gphCopyLink)).setOnClickListener(copyLink());
        View contentView3 = getContentView();
        Intrinsics.checkExpressionValueIsNotNull(contentView3, "contentView");
        ((TextView) contentView3.findViewById(C1800R.C1803id.gphActionViewGiphy)).setOnClickListener(viewOnGiphyAction());
        for (GPHActions ordinal : gPHActionsArr) {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal.ordinal()];
            if (i == 1) {
                View contentView4 = getContentView();
                Intrinsics.checkExpressionValueIsNotNull(contentView4, "contentView");
                TextView textView = (TextView) contentView4.findViewById(C1800R.C1803id.gphActionMore);
                Intrinsics.checkExpressionValueIsNotNull(textView, "contentView.gphActionMore");
                textView.setVisibility(0);
            } else if (i == 2) {
                View contentView5 = getContentView();
                Intrinsics.checkExpressionValueIsNotNull(contentView5, "contentView");
                TextView textView2 = (TextView) contentView5.findViewById(C1800R.C1803id.gphCopyLink);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "contentView.gphCopyLink");
                textView2.setVisibility(0);
            } else if (i == 3) {
                View contentView6 = getContentView();
                Intrinsics.checkExpressionValueIsNotNull(contentView6, "contentView");
                TextView textView3 = (TextView) contentView6.findViewById(C1800R.C1803id.gphActionViewGiphy);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "contentView.gphActionViewGiphy");
                textView3.setVisibility(0);
            }
        }
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
    }

    public final GPHActions[] getActions() {
        return this.actions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<String, Unit> getOnShowMore() {
        return this.onShowMore;
    }

    public final void setOnShowMore(Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.onShowMore = function1;
    }

    public final Media getMedia() {
        return this.media;
    }

    public final void setMedia(Media media2) {
        User user;
        String username;
        String str;
        String string;
        this.media = media2;
        View contentView = getContentView();
        Intrinsics.checkExpressionValueIsNotNull(contentView, "contentView");
        TextView textView = (TextView) contentView.findViewById(C1800R.C1803id.gphActionMore);
        Intrinsics.checkExpressionValueIsNotNull(textView, "contentView.gphActionMore");
        textView.setVisibility(8);
        if (media2 != null && !media2.isAnonymous() && ArraysKt.contains((T[]) this.actions, GPHActions.SearchMore) && (user = media2.getUser()) != null && (username = user.getUsername()) != null) {
            View contentView2 = getContentView();
            Intrinsics.checkExpressionValueIsNotNull(contentView2, "contentView");
            TextView textView2 = (TextView) contentView2.findViewById(C1800R.C1803id.gphActionMore);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "contentView.gphActionMore");
            Context context2 = this.context;
            if (context2 == null || (string = context2.getString(C1800R.string.gph_more_by)) == null) {
                str = null;
            } else {
                str = String.format(string, Arrays.copyOf(new Object[]{username}, 1));
                Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
            }
            textView2.setText(str);
            View contentView3 = getContentView();
            Intrinsics.checkExpressionValueIsNotNull(contentView3, "contentView");
            TextView textView3 = (TextView) contentView3.findViewById(C1800R.C1803id.gphActionMore);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "contentView.gphActionMore");
            textView3.setVisibility(0);
        }
    }

    private final View.OnClickListener copyLink() {
        return new GPHMediaActionsView$copyLink$1(this);
    }

    /* access modifiers changed from: private */
    public final void saveToClipboard(String str) {
        Context context2 = this.context;
        Object systemService = context2 != null ? context2.getSystemService("clipboard") : null;
        if (systemService != null) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Giphy", str));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    private final View.OnClickListener showMoreAction() {
        return new GPHMediaActionsView$showMoreAction$1(this);
    }

    private final View.OnClickListener viewOnGiphyAction() {
        return new GPHMediaActionsView$viewOnGiphyAction$1(this);
    }
}
