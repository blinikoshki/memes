package com.getstream.sdk.chat.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.appsflyer.share.Constants;
import com.getstream.sdk.chat.style.TextStyle;
import editor.ffmpeg.api.FfmpegCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/ReadStateStyle;", "", "readStateText", "Lcom/getstream/sdk/chat/style/TextStyle;", "isReadStateEnabled", "", "isDeliveredIndicatorEnabled", "readStateAvatarWidth", "", "readStateAvatarHeight", "(Lcom/getstream/sdk/chat/style/TextStyle;ZZII)V", "()Z", "getReadStateAvatarHeight", "()I", "getReadStateAvatarWidth", "getReadStateText", "()Lcom/getstream/sdk/chat/style/TextStyle;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Builder", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ReadStateStyle.kt */
public final class ReadStateStyle {
    private final boolean isDeliveredIndicatorEnabled;
    private final boolean isReadStateEnabled;
    private final int readStateAvatarHeight;
    private final int readStateAvatarWidth;
    private final TextStyle readStateText;

    public static /* synthetic */ ReadStateStyle copy$default(ReadStateStyle readStateStyle, TextStyle textStyle, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            textStyle = readStateStyle.readStateText;
        }
        if ((i3 & 2) != 0) {
            z = readStateStyle.isReadStateEnabled;
        }
        boolean z3 = z;
        if ((i3 & 4) != 0) {
            z2 = readStateStyle.isDeliveredIndicatorEnabled;
        }
        boolean z4 = z2;
        if ((i3 & 8) != 0) {
            i = readStateStyle.readStateAvatarWidth;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = readStateStyle.readStateAvatarHeight;
        }
        return readStateStyle.copy(textStyle, z3, z4, i4, i2);
    }

    public final TextStyle component1() {
        return this.readStateText;
    }

    public final boolean component2() {
        return this.isReadStateEnabled;
    }

    public final boolean component3() {
        return this.isDeliveredIndicatorEnabled;
    }

    public final int component4() {
        return this.readStateAvatarWidth;
    }

    public final int component5() {
        return this.readStateAvatarHeight;
    }

    public final ReadStateStyle copy(TextStyle textStyle, boolean z, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(textStyle, "readStateText");
        return new ReadStateStyle(textStyle, z, z2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadStateStyle)) {
            return false;
        }
        ReadStateStyle readStateStyle = (ReadStateStyle) obj;
        return Intrinsics.areEqual((Object) this.readStateText, (Object) readStateStyle.readStateText) && this.isReadStateEnabled == readStateStyle.isReadStateEnabled && this.isDeliveredIndicatorEnabled == readStateStyle.isDeliveredIndicatorEnabled && this.readStateAvatarWidth == readStateStyle.readStateAvatarWidth && this.readStateAvatarHeight == readStateStyle.readStateAvatarHeight;
    }

    public int hashCode() {
        TextStyle textStyle = this.readStateText;
        int hashCode = (textStyle != null ? textStyle.hashCode() : 0) * 31;
        boolean z = this.isReadStateEnabled;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isDeliveredIndicatorEnabled;
        if (!z3) {
            z2 = z3;
        }
        return ((((i + (z2 ? 1 : 0)) * 31) + this.readStateAvatarWidth) * 31) + this.readStateAvatarHeight;
    }

    public String toString() {
        return "ReadStateStyle(readStateText=" + this.readStateText + ", isReadStateEnabled=" + this.isReadStateEnabled + ", isDeliveredIndicatorEnabled=" + this.isDeliveredIndicatorEnabled + ", readStateAvatarWidth=" + this.readStateAvatarWidth + ", readStateAvatarHeight=" + this.readStateAvatarHeight + ")";
    }

    public ReadStateStyle(TextStyle textStyle, boolean z, boolean z2, int i, int i2) {
        Intrinsics.checkNotNullParameter(textStyle, "readStateText");
        this.readStateText = textStyle;
        this.isReadStateEnabled = z;
        this.isDeliveredIndicatorEnabled = z2;
        this.readStateAvatarWidth = i;
        this.readStateAvatarHeight = i2;
    }

    public final TextStyle getReadStateText() {
        return this.readStateText;
    }

    public final boolean isReadStateEnabled() {
        return this.isReadStateEnabled;
    }

    public final boolean isDeliveredIndicatorEnabled() {
        return this.isDeliveredIndicatorEnabled;
    }

    public final int getReadStateAvatarWidth() {
        return this.readStateAvatarWidth;
    }

    public final int getReadStateAvatarHeight() {
        return this.readStateAvatarHeight;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJV\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u000b2\b\b\u0001\u0010\u0016\u001a\u00020\u000b2\b\b\u0001\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u000b2\b\b\u0001\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/ReadStateStyle$Builder;", "", "a", "Landroid/content/res/TypedArray;", "c", "Landroid/content/Context;", "(Landroid/content/res/TypedArray;Landroid/content/Context;)V", "isDeliveredIndicatorEnabled", "", "isReadStateEnabled", "readStateAvatarHeight", "", "readStateAvatarWidth", "readStateText", "Lcom/getstream/sdk/chat/style/TextStyle;", "res", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "build", "Lcom/getstream/sdk/chat/view/ReadStateStyle;", "defaultValue", "textSize", "defaultTextSize", "textColor", "defaultTextColor", "textFontAssetsStyleableId", "textFontStyleableId", "textStyleStyleableId", "textStyleDefault", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ReadStateStyle.kt */
    public static final class Builder {

        /* renamed from: a */
        private final TypedArray f168a;
        private boolean isDeliveredIndicatorEnabled;
        private boolean isReadStateEnabled;
        private int readStateAvatarHeight;
        private int readStateAvatarWidth;
        private TextStyle readStateText = new TextStyle();
        private final Resources res;

        public Builder(TypedArray typedArray, Context context) {
            Intrinsics.checkNotNullParameter(typedArray, FfmpegCommand.AUDIO_STREAM);
            Intrinsics.checkNotNullParameter(context, Constants.URL_CAMPAIGN);
            this.f168a = typedArray;
            this.res = context.getResources();
        }

        public static /* synthetic */ Builder readStateText$default(Builder builder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
            return builder.readStateText(i, i2, i3, i4, i5, i6, i7, (i9 & 128) != 0 ? 1 : i8);
        }

        public final Builder readStateText(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Builder builder = this;
            builder.readStateText = new TextStyle.Builder(builder.f168a).size(i, builder.res.getDimensionPixelSize(i2)).color(i3, i4).font(i5, i6).style(i7, i8).build();
            return builder;
        }

        public final Builder isReadStateEnabled(int i, boolean z) {
            Builder builder = this;
            builder.isReadStateEnabled = builder.f168a.getBoolean(i, z);
            return builder;
        }

        public final Builder isDeliveredIndicatorEnabled(int i, boolean z) {
            Builder builder = this;
            builder.isDeliveredIndicatorEnabled = builder.f168a.getBoolean(i, z);
            return builder;
        }

        public final Builder readStateAvatarWidth(int i, int i2) {
            Builder builder = this;
            builder.readStateAvatarWidth = builder.f168a.getDimensionPixelSize(i, i2);
            return builder;
        }

        public final Builder readStateAvatarHeight(int i, int i2) {
            Builder builder = this;
            builder.readStateAvatarHeight = builder.f168a.getDimensionPixelSize(i, i2);
            return builder;
        }

        public final ReadStateStyle build() {
            return new ReadStateStyle(this.readStateText, this.isReadStateEnabled, this.isDeliveredIndicatorEnabled, this.readStateAvatarWidth, this.readStateAvatarHeight);
        }
    }
}
