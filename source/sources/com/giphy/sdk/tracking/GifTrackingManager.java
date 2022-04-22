package com.giphy.sdk.tracking;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.giphy.sdk.analytics.GiphyPingbacks;
import com.giphy.sdk.analytics.models.Attribute;
import com.giphy.sdk.analytics.models.enums.ActionType;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.giphy.sdk.analytics.tracking.AdsManager;
import com.giphy.sdk.core.models.BottleData;
import com.giphy.sdk.core.models.Media;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001f\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\r\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u0014J,\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010,\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"Lcom/giphy/sdk/tracking/GifTrackingManager;", "", "trackPingbacks", "", "(Z)V", "drawingRect", "Landroid/graphics/Rect;", "gifTrackingCallback", "Lcom/giphy/sdk/tracking/GifTrackingCallback;", "gifVisibilityListeners", "", "Lcom/giphy/sdk/tracking/GifVisibilityListener;", "globalRect", "layoutType", "", "pingbacksDeduplicator", "Lcom/giphy/sdk/tracking/PingbacksDeduplicator;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addGifVisibilityListener", "", "gifVisibilityListener", "attachToRecyclerView", "getCellVisibility", "", "view", "Landroid/view/View;", "getLayoutType", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getRecyclerScrollListener", "com/giphy/sdk/tracking/GifTrackingManager$getRecyclerScrollListener$1", "()Lcom/giphy/sdk/tracking/GifTrackingManager$getRecyclerScrollListener$1;", "isMediaLoadedForIndex", "position", "", "removeGifVisibilityListener", "reset", "trackMedia", "media", "Lcom/giphy/sdk/core/models/Media;", "actionType", "Lcom/giphy/sdk/analytics/models/enums/ActionType;", "userId", "updateTracking", "Companion", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GifTrackingManager.kt */
public final class GifTrackingManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = GifTrackingManager.class.getSimpleName();
    private final Rect drawingRect;
    private GifTrackingCallback gifTrackingCallback;
    private final List<GifVisibilityListener> gifVisibilityListeners;
    private final Rect globalRect;
    private String layoutType;
    private PingbacksDeduplicator pingbacksDeduplicator;
    private RecyclerView recyclerView;
    private final boolean trackPingbacks;

    public GifTrackingManager() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public GifTrackingManager(boolean z) {
        this.trackPingbacks = z;
        this.globalRect = new Rect();
        this.drawingRect = new Rect();
        this.gifVisibilityListeners = new ArrayList();
        this.pingbacksDeduplicator = new PingbacksDeduplicator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GifTrackingManager(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"Lcom/giphy/sdk/tracking/GifTrackingManager$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: GifTrackingManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return GifTrackingManager.TAG;
        }
    }

    public final boolean isMediaLoadedForIndex(int i) {
        GifTrackingCallback gifTrackingCallback2 = this.gifTrackingCallback;
        return gifTrackingCallback2 != null && gifTrackingCallback2.isMediaLoadedForIndex(i, new GifTrackingManager$isMediaLoadedForIndex$1(this));
    }

    public final void attachToRecyclerView(RecyclerView recyclerView2, GifTrackingCallback gifTrackingCallback2) {
        Intrinsics.checkParameterIsNotNull(recyclerView2, "recyclerView");
        Intrinsics.checkParameterIsNotNull(gifTrackingCallback2, "gifTrackingCallback");
        this.recyclerView = recyclerView2;
        this.gifTrackingCallback = gifTrackingCallback2;
        recyclerView2.addOnScrollListener(getRecyclerScrollListener());
        this.layoutType = getLayoutType(recyclerView2.getLayoutManager());
    }

    public final void addGifVisibilityListener(GifVisibilityListener gifVisibilityListener) {
        Intrinsics.checkParameterIsNotNull(gifVisibilityListener, "gifVisibilityListener");
        this.gifVisibilityListeners.add(gifVisibilityListener);
    }

    public final void removeGifVisibilityListener(GifVisibilityListener gifVisibilityListener) {
        Intrinsics.checkParameterIsNotNull(gifVisibilityListener, "gifVisibilityListener");
        this.gifVisibilityListeners.remove(gifVisibilityListener);
    }

    private final String getLayoutType(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return Attribute.Companion.getLAYOUT_TYPE_CAROUSEL();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return Attribute.Companion.getLAYOUT_TYPE_GRID();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return Attribute.Companion.getLAYOUT_TYPE_GRID();
        }
        return null;
    }

    private final GifTrackingManager$getRecyclerScrollListener$1 getRecyclerScrollListener() {
        return new GifTrackingManager$getRecyclerScrollListener$1(this);
    }

    public final void updateTracking() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            int childCount = recyclerView2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView2.getChildAt(i);
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(recyclerView2.getChildAt(i));
                if (isMediaLoadedForIndex(childAdapterPosition)) {
                    GifTrackingCallback gifTrackingCallback2 = this.gifTrackingCallback;
                    Media mediaForIndex = gifTrackingCallback2 != null ? gifTrackingCallback2.mediaForIndex(childAdapterPosition) : null;
                    if (mediaForIndex != null) {
                        Intrinsics.checkExpressionValueIsNotNull(childAt, ViewHierarchyConstants.VIEW_KEY);
                        float cellVisibility = getCellVisibility(childAt);
                        if (this.trackPingbacks) {
                            if (cellVisibility == 1.0f) {
                                trackMedia$default(this, mediaForIndex, ActionType.SEEN, (String) null, this.layoutType, 4, (Object) null);
                            }
                            GPHAdSession adSession = MediaExtensionKt.getAdSession(mediaForIndex);
                            if (adSession != null) {
                                adSession.trackImpression();
                            }
                        }
                        for (GifVisibilityListener onVisible : this.gifVisibilityListeners) {
                            onVisible.onVisible(childAdapterPosition, mediaForIndex, childAt, cellVisibility);
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ void trackMedia$default(GifTrackingManager gifTrackingManager, Media media, ActionType actionType, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        gifTrackingManager.trackMedia(media, actionType, str, str2);
    }

    public final void trackMedia(Media media, ActionType actionType, String str, String str2) {
        ActionType actionType2 = actionType;
        Intrinsics.checkParameterIsNotNull(media, "media");
        Intrinsics.checkParameterIsNotNull(actionType2, "actionType");
        Intrinsics.checkParameterIsNotNull(str, TagPeopleActivity.USER_ID);
        if (actionType2 == ActionType.SEEN) {
            PingbacksDeduplicator pingbacksDeduplicator2 = this.pingbacksDeduplicator;
            String id = media.getId();
            String responseId = MediaExtensionKt.getResponseId(media);
            if (responseId == null) {
                responseId = "";
            }
            if (!pingbacksDeduplicator2.trackNeeded(id, responseId)) {
                return;
            }
        }
        EventType eventType = MediaExtensionKt.getEventType(media);
        if (eventType != null) {
            GiphyPingbacks giphyPingbacks = GiphyPingbacks.INSTANCE;
            String pingbackId = GiphyPingbacks.INSTANCE.getPingbackId();
            String responseId2 = MediaExtensionKt.getResponseId(media);
            if (responseId2 == null) {
                responseId2 = "";
            }
            String id2 = media.getId();
            String tid = media.getTid();
            Integer position = MediaExtensionKt.getPosition(media);
            giphyPingbacks.log(pingbackId, str, responseId2, (String) null, eventType, id2, tid, actionType, (String) null, str2, position != null ? position.intValue() : -1);
        }
        if (actionType2 == ActionType.SEEN) {
            AdsManager adsManager = AdsManager.INSTANCE;
            BottleData bottleData = media.getBottleData();
            adsManager.trackSeenMedia(bottleData != null ? bottleData.getTags() : null);
        }
    }

    private final float getCellVisibility(View view) {
        if (!view.getGlobalVisibleRect(this.globalRect)) {
            return 0.0f;
        }
        view.getHitRect(this.drawingRect);
        int width = this.globalRect.width() * this.globalRect.height();
        int width2 = this.drawingRect.width() * this.drawingRect.height();
        float f = ((float) width) / ((float) width2);
        if (width2 <= 0) {
            return 0.0f;
        }
        return Math.min(f, 1.0f);
    }

    public final void reset() {
        this.pingbacksDeduplicator.reset();
        OMTracking.INSTANCE.reset();
        for (GifVisibilityListener reset : this.gifVisibilityListeners) {
            reset.reset();
        }
    }
}
