package com.memes.plus.p040ui.home.feeds;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "", "position", "", "displayName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getPosition", "()I", "FOR_YOU", "FOLLOWING", "NEW", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.feeds.HomeFeedType */
/* compiled from: HomeFeedType.kt */
public enum HomeFeedType {
    FOR_YOU(0, "For You"),
    FOLLOWING(1, "Following"),
    NEW(2, "New");
    
    public static final int COUNT = 3;
    public static final Companion Companion = null;
    private final String displayName;
    private final int position;

    private HomeFeedType(int i, String str) {
        this.position = i;
        this.displayName = str;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/home/feeds/HomeFeedType$Companion;", "", "()V", "COUNT", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.home.feeds.HomeFeedType$Companion */
    /* compiled from: HomeFeedType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
