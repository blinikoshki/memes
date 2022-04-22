package com.getstream.sdk.chat.style;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.widget.TextView;
import com.getstream.sdk.chat.ChatUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001a\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006'"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/TextStyle;", "", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "font", "Landroid/graphics/Typeface;", "getFont", "()Landroid/graphics/Typeface;", "fontAssetsPath", "", "getFontAssetsPath", "()Ljava/lang/String;", "setFontAssetsPath", "(Ljava/lang/String;)V", "fontResource", "getFontResource", "setFontResource", "hintColor", "getHintColor", "setHintColor", "size", "getSize", "setSize", "style", "getStyle", "setStyle", "apply", "", "textView", "Landroid/widget/TextView;", "hasFont", "", "Builder", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextStyle.kt */
public final class TextStyle {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int UNSET_COLOR = Integer.MAX_VALUE;
    @Deprecated
    public static final int UNSET_FONT_RESOURCE = -1;
    @Deprecated
    public static final int UNSET_HINT_COLOR = Integer.MAX_VALUE;
    @Deprecated
    public static final int UNSET_SIZE = -1;
    private int color = Integer.MAX_VALUE;
    private String fontAssetsPath;
    private int fontResource = -1;
    private int hintColor = Integer.MAX_VALUE;
    private int size = -1;
    private int style = -1;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/TextStyle$Companion;", "", "()V", "UNSET_COLOR", "", "UNSET_FONT_RESOURCE", "UNSET_HINT_COLOR", "UNSET_SIZE", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextStyle.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getFontResource() {
        return this.fontResource;
    }

    public final void setFontResource(int i) {
        this.fontResource = i;
    }

    public final String getFontAssetsPath() {
        return this.fontAssetsPath;
    }

    public final void setFontAssetsPath(String str) {
        this.fontAssetsPath = str;
    }

    public final int getStyle() {
        return this.style;
    }

    public final void setStyle(int i) {
        this.style = i;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final int getHintColor() {
        return this.hintColor;
    }

    public final void setHintColor(int i) {
        this.hintColor = i;
    }

    public final Typeface getFont() {
        return ChatUI.Companion.instance().getFonts().getFont(this);
    }

    public final void apply(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        ChatFonts fonts = ChatUI.Companion.instance().getFonts();
        int i = this.size;
        if (i != -1) {
            textView.setTextSize(0, (float) i);
        }
        int i2 = this.color;
        if (i2 != Integer.MAX_VALUE) {
            textView.setTextColor(i2);
        }
        int i3 = this.hintColor;
        if (i3 != Integer.MAX_VALUE) {
            textView.setHintTextColor(i3);
        }
        fonts.setFont(this, textView);
    }

    public final boolean hasFont() {
        return (this.fontAssetsPath == null && this.fontResource == -1) ? false : true;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/style/TextStyle$Builder;", "", "array", "Landroid/content/res/TypedArray;", "(Landroid/content/res/TypedArray;)V", "result", "Lcom/getstream/sdk/chat/style/TextStyle;", "build", "color", "ref", "", "defValue", "font", "assetsPath", "resId", "hintColor", "size", "style", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextStyle.kt */
    public static final class Builder {
        private final TypedArray array;
        private final TextStyle result = new TextStyle();

        public Builder(TypedArray typedArray) {
            Intrinsics.checkNotNullParameter(typedArray, "array");
            this.array = typedArray;
        }

        public final Builder size(int i) {
            return size(i, -1);
        }

        public final Builder size(int i, int i2) {
            Builder builder = this;
            builder.result.setSize(builder.array.getDimensionPixelSize(i, i2));
            return builder;
        }

        public final Builder font(int i, int i2) {
            Builder builder = this;
            builder.result.setFontAssetsPath(builder.array.getString(i));
            builder.result.setFontResource(builder.array.getResourceId(i2, -1));
            return builder;
        }

        public final Builder color(int i, int i2) {
            Builder builder = this;
            builder.result.setColor(builder.array.getColor(i, i2));
            return builder;
        }

        public final Builder hintColor(int i, int i2) {
            Builder builder = this;
            builder.result.setHintColor(builder.array.getColor(i, i2));
            return builder;
        }

        public final Builder style(int i, int i2) {
            Builder builder = this;
            builder.result.setStyle(builder.array.getInt(i, i2));
            return builder;
        }

        public final TextStyle build() {
            return this.result;
        }
    }
}
