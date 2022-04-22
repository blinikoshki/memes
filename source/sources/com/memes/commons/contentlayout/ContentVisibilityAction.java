package com.memes.commons.contentlayout;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "", "()V", "action", "", "getAction", "()I", "setAction", "(I)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentVisibilityAction.kt */
public final class ContentVisibilityAction {
    public static final int CONTENT = 1214;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ERROR = 1211;
    public static final int LOGIN_ERROR = 1212;
    public static final int NO_CONTENT = 1213;
    public static final int PROGRESS = 1210;
    private int action = CONTENT;
    private String message;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/commons/contentlayout/ContentVisibilityAction$Companion;", "", "()V", "CONTENT", "", "ERROR", "LOGIN_ERROR", "NO_CONTENT", "PROGRESS", "content", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "contentNotAvailable", "message", "", "error", "loginError", "progress", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ContentVisibilityAction.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContentVisibilityAction content() {
            ContentVisibilityAction contentVisibilityAction = new ContentVisibilityAction();
            contentVisibilityAction.setAction(ContentVisibilityAction.CONTENT);
            return contentVisibilityAction;
        }

        public static /* synthetic */ ContentVisibilityAction progress$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.progress(str);
        }

        public final ContentVisibilityAction progress(String str) {
            ContentVisibilityAction contentVisibilityAction = new ContentVisibilityAction();
            contentVisibilityAction.setAction(ContentVisibilityAction.PROGRESS);
            contentVisibilityAction.setMessage(str);
            return contentVisibilityAction;
        }

        public static /* synthetic */ ContentVisibilityAction error$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.error(str);
        }

        public final ContentVisibilityAction error(String str) {
            ContentVisibilityAction contentVisibilityAction = new ContentVisibilityAction();
            contentVisibilityAction.setAction(ContentVisibilityAction.ERROR);
            contentVisibilityAction.setMessage(str);
            return contentVisibilityAction;
        }

        public static /* synthetic */ ContentVisibilityAction loginError$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.loginError(str);
        }

        public final ContentVisibilityAction loginError(String str) {
            ContentVisibilityAction contentVisibilityAction = new ContentVisibilityAction();
            contentVisibilityAction.setAction(ContentVisibilityAction.LOGIN_ERROR);
            contentVisibilityAction.setMessage(str);
            return contentVisibilityAction;
        }

        public static /* synthetic */ ContentVisibilityAction contentNotAvailable$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.contentNotAvailable(str);
        }

        public final ContentVisibilityAction contentNotAvailable(String str) {
            ContentVisibilityAction contentVisibilityAction = new ContentVisibilityAction();
            contentVisibilityAction.setAction(ContentVisibilityAction.NO_CONTENT);
            contentVisibilityAction.setMessage(str);
            return contentVisibilityAction;
        }
    }

    public final int getAction() {
        return this.action;
    }

    public final void setAction(int i) {
        this.action = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
