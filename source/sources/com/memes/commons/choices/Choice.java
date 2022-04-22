package com.memes.commons.choices;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0000J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u001bJ\u0006\u0010\u001c\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, mo26107d2 = {"Lcom/memes/commons/choices/Choice;", "", "id", "", "title", "enabled", "", "highlightType", "Lcom/memes/commons/choices/Choice$HighlightType;", "subChoices", "", "type", "", "(Ljava/lang/String;Ljava/lang/String;ZLcom/memes/commons/choices/Choice$HighlightType;Ljava/util/List;I)V", "getEnabled", "()Z", "getHighlightType", "()Lcom/memes/commons/choices/Choice$HighlightType;", "getId", "()Ljava/lang/String;", "getTitle", "getType", "()I", "addChoice", "", "choice", "getSubChoices", "", "hasSubChoices", "Companion", "HighlightType", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Choice.kt */
public final class Choice {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_CHOICE = 12;
    public static final int TYPE_DIVIDER = 13;
    private final boolean enabled;
    private final HighlightType highlightType;

    /* renamed from: id */
    private final String f958id;
    private final List<Choice> subChoices;
    private final String title;
    private final int type;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/commons/choices/Choice$HighlightType;", "", "(Ljava/lang/String;I)V", "NONE", "PLAIN", "PRIMARY", "DANGER", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Choice.kt */
    public enum HighlightType {
        NONE,
        PLAIN,
        PRIMARY,
        DANGER
    }

    private Choice(String str, String str2, boolean z, HighlightType highlightType2, List<Choice> list, int i) {
        this.f958id = str;
        this.title = str2;
        this.enabled = z;
        this.highlightType = highlightType2;
        this.subChoices = list;
        this.type = i;
    }

    public final String getId() {
        return this.f958id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final HighlightType getHighlightType() {
        return this.highlightType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ Choice(String str, String str2, boolean z, HighlightType highlightType2, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, highlightType2, (i2 & 16) != 0 ? new ArrayList() : list, i);
    }

    public final int getType() {
        return this.type;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/commons/choices/Choice$Companion;", "", "()V", "TYPE_CHOICE", "", "TYPE_DIVIDER", "create", "Lcom/memes/commons/choices/Choice;", "id", "", "title", "enabled", "", "highlightType", "Lcom/memes/commons/choices/Choice$HighlightType;", "divider", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Choice.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Choice create$default(Companion companion, String str, String str2, boolean z, HighlightType highlightType, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                highlightType = HighlightType.PRIMARY;
            }
            return companion.create(str, str2, z, highlightType);
        }

        public final Choice create(String str, String str2, boolean z, HighlightType highlightType) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(highlightType, "highlightType");
            return new Choice(str, str2, z, highlightType, (List) null, 12, 16, (DefaultConstructorMarker) null);
        }

        public final Choice divider() {
            return new Choice("divider", "divider", true, HighlightType.NONE, (List) null, 13, 16, (DefaultConstructorMarker) null);
        }
    }

    public final boolean hasSubChoices() {
        return !this.subChoices.isEmpty();
    }

    public final List<Choice> getSubChoices() {
        return this.subChoices;
    }

    public final void addChoice(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "choice");
        this.subChoices.add(choice);
    }
}
