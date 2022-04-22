package com.getstream.sdk.chat.view.messages;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.appsflyer.share.Constants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.style.TextStyle;
import editor.ffmpeg.api.FfmpegCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001 B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "", "avatarWidth", "", "avatarHeight", "avatarBorderWidth", "avatarBorderColor", "avatarBackgroundColor", "avatarInitialText", "Lcom/getstream/sdk/chat/style/TextStyle;", "(IIIIILcom/getstream/sdk/chat/style/TextStyle;)V", "getAvatarBackgroundColor", "()I", "getAvatarBorderColor", "getAvatarBorderWidth", "getAvatarHeight", "getAvatarInitialText", "()Lcom/getstream/sdk/chat/style/TextStyle;", "getAvatarWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "Builder", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AvatarStyle.kt */
public final class AvatarStyle {
    private final int avatarBackgroundColor;
    private final int avatarBorderColor;
    private final int avatarBorderWidth;
    private final int avatarHeight;
    private final TextStyle avatarInitialText;
    private final int avatarWidth;

    public static /* synthetic */ AvatarStyle copy$default(AvatarStyle avatarStyle, int i, int i2, int i3, int i4, int i5, TextStyle textStyle, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = avatarStyle.avatarWidth;
        }
        if ((i6 & 2) != 0) {
            i2 = avatarStyle.avatarHeight;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = avatarStyle.avatarBorderWidth;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = avatarStyle.avatarBorderColor;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = avatarStyle.avatarBackgroundColor;
        }
        int i10 = i5;
        if ((i6 & 32) != 0) {
            textStyle = avatarStyle.avatarInitialText;
        }
        return avatarStyle.copy(i, i7, i8, i9, i10, textStyle);
    }

    public final int component1() {
        return this.avatarWidth;
    }

    public final int component2() {
        return this.avatarHeight;
    }

    public final int component3() {
        return this.avatarBorderWidth;
    }

    public final int component4() {
        return this.avatarBorderColor;
    }

    public final int component5() {
        return this.avatarBackgroundColor;
    }

    public final TextStyle component6() {
        return this.avatarInitialText;
    }

    public final AvatarStyle copy(int i, int i2, int i3, int i4, int i5, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "avatarInitialText");
        return new AvatarStyle(i, i2, i3, i4, i5, textStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvatarStyle)) {
            return false;
        }
        AvatarStyle avatarStyle = (AvatarStyle) obj;
        return this.avatarWidth == avatarStyle.avatarWidth && this.avatarHeight == avatarStyle.avatarHeight && this.avatarBorderWidth == avatarStyle.avatarBorderWidth && this.avatarBorderColor == avatarStyle.avatarBorderColor && this.avatarBackgroundColor == avatarStyle.avatarBackgroundColor && Intrinsics.areEqual((Object) this.avatarInitialText, (Object) avatarStyle.avatarInitialText);
    }

    public int hashCode() {
        int i = ((((((((this.avatarWidth * 31) + this.avatarHeight) * 31) + this.avatarBorderWidth) * 31) + this.avatarBorderColor) * 31) + this.avatarBackgroundColor) * 31;
        TextStyle textStyle = this.avatarInitialText;
        return i + (textStyle != null ? textStyle.hashCode() : 0);
    }

    public String toString() {
        return "AvatarStyle(avatarWidth=" + this.avatarWidth + ", avatarHeight=" + this.avatarHeight + ", avatarBorderWidth=" + this.avatarBorderWidth + ", avatarBorderColor=" + this.avatarBorderColor + ", avatarBackgroundColor=" + this.avatarBackgroundColor + ", avatarInitialText=" + this.avatarInitialText + ")";
    }

    public AvatarStyle(int i, int i2, int i3, int i4, int i5, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "avatarInitialText");
        this.avatarWidth = i;
        this.avatarHeight = i2;
        this.avatarBorderWidth = i3;
        this.avatarBorderColor = i4;
        this.avatarBackgroundColor = i5;
        this.avatarInitialText = textStyle;
    }

    public final int getAvatarWidth() {
        return this.avatarWidth;
    }

    public final int getAvatarHeight() {
        return this.avatarHeight;
    }

    public final int getAvatarBorderWidth() {
        return this.avatarBorderWidth;
    }

    public final int getAvatarBorderColor() {
        return this.avatarBorderColor;
    }

    public final int getAvatarBackgroundColor() {
        return this.avatarBackgroundColor;
    }

    public final TextStyle getAvatarInitialText() {
        return this.avatarInitialText;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\bJ\u001a\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\bJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\bJV\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\b2\b\b\u0001\u0010\u0019\u001a\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\b2\b\b\u0001\u0010\u001b\u001a\u00020\b2\b\b\u0003\u0010\u001c\u001a\u00020\b2\b\b\u0003\u0010\u001d\u001a\u00020\b2\b\b\u0001\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\bJ\u001a\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\bJ\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messages/AvatarStyle$Builder;", "", "a", "Landroid/content/res/TypedArray;", "c", "Landroid/content/Context;", "(Landroid/content/res/TypedArray;Landroid/content/Context;)V", "avatarBackgroundColor", "", "avatarBorderColor", "avatarBorderWidth", "avatarHeight", "avatarInitialText", "Lcom/getstream/sdk/chat/style/TextStyle;", "avatarWidth", "res", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "avatarBackgroundColorStyleableId", "defaultColor", "avatarBorderColorStyleableId", "avatarBorderWidthStyleableId", "defaultValue", "avatarHeightStyleableId", "avatarTextSizeStyleableId", "avatarTextSizeDefaultValue", "avatarTextColorStyleableId", "avatarTextColorDefaultValue", "avatarTextFontAssetsStyleableId", "avatarTextFontStyleableId", "avatarTextStyleStyleableId", "defaultTextStyle", "avatarWidthStyleableId", "build", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: AvatarStyle.kt */
    public static final class Builder {

        /* renamed from: a */
        private final TypedArray f169a;
        private int avatarBackgroundColor;
        private int avatarBorderColor;
        private int avatarBorderWidth;
        private int avatarHeight;
        private TextStyle avatarInitialText = new TextStyle();
        private int avatarWidth;
        private final Resources res;

        public Builder(TypedArray typedArray, Context context) {
            Intrinsics.checkNotNullParameter(typedArray, FfmpegCommand.AUDIO_STREAM);
            Intrinsics.checkNotNullParameter(context, Constants.URL_CAMPAIGN);
            this.f169a = typedArray;
            this.res = context.getResources();
        }

        public final Builder avatarWidth(int i, int i2) {
            Builder builder = this;
            builder.avatarWidth = builder.f169a.getDimensionPixelSize(i, builder.res.getDimensionPixelSize(i2));
            return builder;
        }

        public final Builder avatarHeight(int i, int i2) {
            Builder builder = this;
            builder.avatarHeight = builder.f169a.getDimensionPixelSize(i, builder.res.getDimensionPixelSize(i2));
            return builder;
        }

        public final Builder avatarBorderWidth(int i, int i2) {
            Builder builder = this;
            builder.avatarBorderWidth = builder.f169a.getDimensionPixelSize(i, builder.res.getDimensionPixelSize(i2));
            return builder;
        }

        public final Builder avatarBorderColor(int i, int i2) {
            Builder builder = this;
            builder.avatarBorderColor = builder.f169a.getColor(i, i2);
            return builder;
        }

        public final Builder avatarBackgroundColor(int i, int i2) {
            Builder builder = this;
            builder.avatarBackgroundColor = builder.f169a.getColor(i, i2);
            return builder;
        }

        public static /* synthetic */ Builder avatarInitialText$default(Builder builder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
            int i10 = i9;
            return builder.avatarInitialText(i, i2, i3, i4, (i10 & 16) != 0 ? C1673R.styleable.MessageListView_streamAvatarTextFontAssets : i5, (i10 & 32) != 0 ? C1673R.styleable.MessageListView_streamAvatarTextFont : i6, i7, (i10 & 128) != 0 ? 1 : i8);
        }

        public final Builder avatarInitialText(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Builder builder = this;
            builder.avatarInitialText = new TextStyle.Builder(builder.f169a).size(i, builder.res.getDimensionPixelSize(i2)).color(i3, i4).font(i5, i6).style(i7, i8).build();
            return builder;
        }

        public final AvatarStyle build() {
            return new AvatarStyle(this.avatarWidth, this.avatarHeight, this.avatarBorderWidth, this.avatarBorderColor, this.avatarBackgroundColor, this.avatarInitialText);
        }
    }
}
