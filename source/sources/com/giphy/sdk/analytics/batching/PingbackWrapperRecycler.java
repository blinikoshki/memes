package com.giphy.sdk.analytics.batching;

import com.giphy.sdk.analytics.models.enums.ActionType;
import com.giphy.sdk.analytics.models.enums.EventType;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002Jp\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/batching/PingbackWrapperRecycler;", "", "()V", "eventWrappers", "Ljava/util/LinkedList;", "Lcom/giphy/sdk/analytics/batching/PingbackWrapperRecycler$PingbackWrapper;", "getEventWrappers", "()Ljava/util/LinkedList;", "getItem", "userId", "", "loggedInUserId", "randomId", "responseId", "referrer", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "mediaId", "tid", "actionType", "Lcom/giphy/sdk/analytics/models/enums/ActionType;", "sessionId", "layoutType", "position", "", "recycleItem", "", "eventWrapper", "PingbackWrapper", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PingbackWrapperRecycler.kt */
public final class PingbackWrapperRecycler {
    private final LinkedList<PingbackWrapper> eventWrappers = new LinkedList<>();

    public final LinkedList<PingbackWrapper> getEventWrappers() {
        return this.eventWrappers;
    }

    public final PingbackWrapper getItem(String str, String str2, String str3, String str4, String str5, EventType eventType, String str6, String str7, ActionType actionType, String str8, String str9, int i) {
        Intrinsics.checkParameterIsNotNull(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkParameterIsNotNull(str2, "loggedInUserId");
        Intrinsics.checkParameterIsNotNull(str4, "responseId");
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(str6, "mediaId");
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        PingbackWrapper pollFirst = this.eventWrappers.pollFirst();
        if (pollFirst == null) {
            pollFirst = new PingbackWrapper();
        }
        PingbackWrapper pingbackWrapper = pollFirst;
        pingbackWrapper.update(str, str2, str3, str4, str5, eventType, str6, str7, actionType, str8, str9, i);
        return pingbackWrapper;
    }

    public final void recycleItem(PingbackWrapper pingbackWrapper) {
        Intrinsics.checkParameterIsNotNull(pingbackWrapper, "eventWrapper");
        this.eventWrappers.add(pingbackWrapper);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jp\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010'\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001c\u0010*\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001c\u0010-\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014¨\u0006;"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/batching/PingbackWrapperRecycler$PingbackWrapper;", "", "()V", "actionType", "Lcom/giphy/sdk/analytics/models/enums/ActionType;", "getActionType", "()Lcom/giphy/sdk/analytics/models/enums/ActionType;", "setActionType", "(Lcom/giphy/sdk/analytics/models/enums/ActionType;)V", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "getEventType", "()Lcom/giphy/sdk/analytics/models/enums/EventType;", "setEventType", "(Lcom/giphy/sdk/analytics/models/enums/EventType;)V", "layoutType", "", "getLayoutType", "()Ljava/lang/String;", "setLayoutType", "(Ljava/lang/String;)V", "loggedInUserId", "getLoggedInUserId", "setLoggedInUserId", "mediaId", "getMediaId", "setMediaId", "position", "", "getPosition", "()I", "setPosition", "(I)V", "randomId", "getRandomId", "setRandomId", "referrer", "getReferrer", "setReferrer", "responseId", "getResponseId", "setResponseId", "sessionId", "getSessionId", "setSessionId", "tid", "getTid", "setTid", "ts", "", "getTs", "()J", "setTs", "(J)V", "userId", "getUserId", "setUserId", "update", "", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: PingbackWrapperRecycler.kt */
    public static final class PingbackWrapper {
        public ActionType actionType;
        public EventType eventType;
        private String layoutType;
        public String loggedInUserId;
        public String mediaId;
        private int position;
        private String randomId;
        private String referrer;
        public String responseId;
        private String sessionId;
        private String tid;

        /* renamed from: ts */
        private long f171ts;
        public String userId;

        public final String getUserId() {
            String str = this.userId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TagPeopleActivity.USER_ID);
            }
            return str;
        }

        public final void setUserId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.userId = str;
        }

        public final String getLoggedInUserId() {
            String str = this.loggedInUserId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loggedInUserId");
            }
            return str;
        }

        public final void setLoggedInUserId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.loggedInUserId = str;
        }

        public final String getRandomId() {
            return this.randomId;
        }

        public final void setRandomId(String str) {
            this.randomId = str;
        }

        public final String getResponseId() {
            String str = this.responseId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("responseId");
            }
            return str;
        }

        public final void setResponseId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.responseId = str;
        }

        public final String getReferrer() {
            return this.referrer;
        }

        public final void setReferrer(String str) {
            this.referrer = str;
        }

        public final EventType getEventType() {
            EventType eventType2 = this.eventType;
            if (eventType2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventType");
            }
            return eventType2;
        }

        public final void setEventType(EventType eventType2) {
            Intrinsics.checkParameterIsNotNull(eventType2, "<set-?>");
            this.eventType = eventType2;
        }

        public final String getMediaId() {
            String str = this.mediaId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaId");
            }
            return str;
        }

        public final void setMediaId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.mediaId = str;
        }

        public final String getTid() {
            return this.tid;
        }

        public final void setTid(String str) {
            this.tid = str;
        }

        public final ActionType getActionType() {
            ActionType actionType2 = this.actionType;
            if (actionType2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionType");
            }
            return actionType2;
        }

        public final void setActionType(ActionType actionType2) {
            Intrinsics.checkParameterIsNotNull(actionType2, "<set-?>");
            this.actionType = actionType2;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setSessionId(String str) {
            this.sessionId = str;
        }

        public final long getTs() {
            return this.f171ts;
        }

        public final void setTs(long j) {
            this.f171ts = j;
        }

        public final String getLayoutType() {
            return this.layoutType;
        }

        public final void setLayoutType(String str) {
            this.layoutType = str;
        }

        public final int getPosition() {
            return this.position;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        public final void update(String str, String str2, String str3, String str4, String str5, EventType eventType2, String str6, String str7, ActionType actionType2, String str8, String str9, int i) {
            Intrinsics.checkParameterIsNotNull(str, TagPeopleActivity.USER_ID);
            Intrinsics.checkParameterIsNotNull(str2, "loggedInUserId");
            Intrinsics.checkParameterIsNotNull(str4, "responseId");
            Intrinsics.checkParameterIsNotNull(eventType2, "eventType");
            Intrinsics.checkParameterIsNotNull(str6, "mediaId");
            Intrinsics.checkParameterIsNotNull(actionType2, "actionType");
            this.userId = str;
            this.loggedInUserId = str2;
            this.randomId = str3;
            this.responseId = str4;
            this.referrer = str5;
            this.eventType = eventType2;
            this.mediaId = str6;
            this.tid = str7;
            this.actionType = actionType2;
            this.sessionId = str8;
            this.f171ts = System.currentTimeMillis();
            this.layoutType = str9;
            this.position = i;
        }
    }
}
