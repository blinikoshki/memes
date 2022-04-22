package com.giphy.sdk.p013ui.pagination;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/NetworkStateItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "retryCallback", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "bindLoadingAnimation", "networkState", "Lcom/giphy/sdk/ui/pagination/NetworkState;", "bindTo", "Companion", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.pagination.NetworkStateItemViewHolder */
/* compiled from: NetworkStateItemViewHolder.kt */
public final class NetworkStateItemViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final Function0<Unit> retryCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkStateItemViewHolder(View view, Function0<Unit> function0) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkParameterIsNotNull(function0, "retryCallback");
        this.retryCallback = function0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bindTo(com.giphy.sdk.p013ui.pagination.NetworkState r9) {
        /*
            r8 = this;
            android.view.View r0 = r8.itemView
            java.lang.String r1 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r2 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams
            r3 = 0
            if (r2 != 0) goto L_0x0011
            r0 = r3
        L_0x0011:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r0
            r2 = 1
            if (r0 == 0) goto L_0x0019
            r0.setFullSpan(r2)
        L_0x0019:
            android.view.View r0 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r4 = r0 instanceof androidx.recyclerview.widget.RecyclerView.LayoutParams
            if (r4 != 0) goto L_0x0027
            r0 = r3
        L_0x0027:
            androidx.recyclerview.widget.RecyclerView$LayoutParams r0 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r0
            if (r0 == 0) goto L_0x0037
            android.content.res.Resources r4 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r4 = r4.widthPixels
            r0.width = r4
        L_0x0037:
            r8.bindLoadingAnimation(r9)
            android.view.View r0 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r4 = com.giphy.sdk.p013ui.C1800R.C1803id.retryButton
            android.view.View r0 = r0.findViewById(r4)
            android.widget.Button r0 = (android.widget.Button) r0
            java.lang.String r4 = "itemView.retryButton"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            com.giphy.sdk.ui.pagination.NetworkStateItemViewHolder$Companion r4 = Companion
            if (r9 == 0) goto L_0x0055
            com.giphy.sdk.ui.pagination.Status r5 = r9.getStatus()
            goto L_0x0056
        L_0x0055:
            r5 = r3
        L_0x0056:
            com.giphy.sdk.ui.pagination.Status r6 = com.giphy.sdk.p013ui.pagination.Status.FAILED
            r7 = 0
            if (r5 == r6) goto L_0x006a
            if (r9 == 0) goto L_0x0062
            com.giphy.sdk.ui.pagination.Status r5 = r9.getStatus()
            goto L_0x0063
        L_0x0062:
            r5 = r3
        L_0x0063:
            com.giphy.sdk.ui.pagination.Status r6 = com.giphy.sdk.p013ui.pagination.Status.FAILED_INITIAL
            if (r5 != r6) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r5 = 0
            goto L_0x006b
        L_0x006a:
            r5 = 1
        L_0x006b:
            int r5 = r4.toVisibility(r5)
            r0.setVisibility(r5)
            android.view.View r0 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.errorGif
            android.view.View r0 = r0.findViewById(r5)
            com.giphy.sdk.ui.views.GifView r0 = (com.giphy.sdk.p013ui.views.GifView) r0
            java.lang.String r5 = "itemView.errorGif"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            if (r9 == 0) goto L_0x008b
            com.giphy.sdk.ui.pagination.Status r5 = r9.getStatus()
            goto L_0x008c
        L_0x008b:
            r5 = r3
        L_0x008c:
            com.giphy.sdk.ui.pagination.Status r6 = com.giphy.sdk.p013ui.pagination.Status.FAILED_INITIAL
            if (r5 != r6) goto L_0x0092
            r5 = 1
            goto L_0x0093
        L_0x0092:
            r5 = 0
        L_0x0093:
            int r5 = r4.toVisibility(r5)
            r0.setVisibility(r5)
            if (r9 == 0) goto L_0x00a1
            com.giphy.sdk.ui.pagination.Status r0 = r9.getStatus()
            goto L_0x00a2
        L_0x00a1:
            r0 = r3
        L_0x00a2:
            com.giphy.sdk.ui.pagination.Status r5 = com.giphy.sdk.p013ui.pagination.Status.FAILED_INITIAL
            if (r0 != r5) goto L_0x00b8
            android.view.View r0 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.errorGif
            android.view.View r0 = r0.findViewById(r5)
            com.giphy.sdk.ui.views.GifView r0 = (com.giphy.sdk.p013ui.views.GifView) r0
            int r5 = com.giphy.sdk.p013ui.C1800R.C1802drawable.gph_no_results_sticker
            r0.loadAsset((int) r5)
        L_0x00b8:
            android.view.View r0 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r5 = com.giphy.sdk.p013ui.C1800R.C1803id.errorMessage
            android.view.View r0 = r0.findViewById(r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r5 = "itemView.errorMessage"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            if (r9 == 0) goto L_0x00d0
            java.lang.String r3 = r9.getMsg()
        L_0x00d0:
            if (r3 == 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r2 = 0
        L_0x00d4:
            int r9 = r4.toVisibility(r2)
            r0.setVisibility(r9)
            android.view.View r9 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r1)
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.errorMessage
            android.view.View r9 = r9.findViewById(r0)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r5)
            android.view.View r0 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.giphy.sdk.p013ui.C1800R.string.gph_error_generic_list_loading
            java.lang.CharSequence r0 = r0.getText(r2)
            r9.setText(r0)
            android.view.View r9 = r8.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r1)
            int r0 = com.giphy.sdk.p013ui.C1800R.C1803id.retryButton
            android.view.View r9 = r9.findViewById(r0)
            android.widget.Button r9 = (android.widget.Button) r9
            com.giphy.sdk.ui.pagination.NetworkStateItemViewHolder$bindTo$1 r0 = new com.giphy.sdk.ui.pagination.NetworkStateItemViewHolder$bindTo$1
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.pagination.NetworkStateItemViewHolder.bindTo(com.giphy.sdk.ui.pagination.NetworkState):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindLoadingAnimation(com.giphy.sdk.p013ui.pagination.NetworkState r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.itemView
            java.lang.String r1 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r2 = com.giphy.sdk.p013ui.C1800R.C1803id.loadingAnimation
            android.view.View r0 = r0.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            java.lang.String r2 = "itemView.loadingAnimation"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            com.giphy.sdk.ui.pagination.NetworkStateItemViewHolder$Companion r2 = Companion
            r3 = 0
            if (r7 == 0) goto L_0x001e
            com.giphy.sdk.ui.pagination.Status r4 = r7.getStatus()
            goto L_0x001f
        L_0x001e:
            r4 = r3
        L_0x001f:
            com.giphy.sdk.ui.pagination.Status r5 = com.giphy.sdk.p013ui.pagination.Status.RUNNING
            if (r4 == r5) goto L_0x0032
            if (r7 == 0) goto L_0x002a
            com.giphy.sdk.ui.pagination.Status r4 = r7.getStatus()
            goto L_0x002b
        L_0x002a:
            r4 = r3
        L_0x002b:
            com.giphy.sdk.ui.pagination.Status r5 = com.giphy.sdk.p013ui.pagination.Status.RUNNING_INITIAL
            if (r4 != r5) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r4 = 0
            goto L_0x0033
        L_0x0032:
            r4 = 1
        L_0x0033:
            int r2 = r2.toVisibility(r4)
            r0.setVisibility(r2)
            android.view.View r0 = r6.itemView
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r7 == 0) goto L_0x004a
            com.giphy.sdk.ui.pagination.Status r1 = r7.getStatus()
            goto L_0x004b
        L_0x004a:
            r1 = r3
        L_0x004b:
            com.giphy.sdk.ui.pagination.Status r2 = com.giphy.sdk.p013ui.pagination.Status.RUNNING_INITIAL
            if (r1 == r2) goto L_0x005c
            if (r7 == 0) goto L_0x0055
            com.giphy.sdk.ui.pagination.Status r3 = r7.getStatus()
        L_0x0055:
            com.giphy.sdk.ui.pagination.Status r7 = com.giphy.sdk.p013ui.pagination.Status.FAILED_INITIAL
            if (r3 != r7) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r7 = -2
            goto L_0x005d
        L_0x005c:
            r7 = -1
        L_0x005d:
            r0.height = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.p013ui.pagination.NetworkStateItemViewHolder.bindLoadingAnimation(com.giphy.sdk.ui.pagination.NetworkState):void");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/giphy/sdk/ui/pagination/NetworkStateItemViewHolder$Companion;", "", "()V", "toVisibility", "", "constraint", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.pagination.NetworkStateItemViewHolder$Companion */
    /* compiled from: NetworkStateItemViewHolder.kt */
    public static final class Companion {
        public final int toVisibility(boolean z) {
            return z ? 0 : 8;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
