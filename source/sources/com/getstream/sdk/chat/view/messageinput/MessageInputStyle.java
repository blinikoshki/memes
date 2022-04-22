package com.getstream.sdk.chat.view.messageinput;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010K\u001a\u0004\u0018\u00010\u00132\u0006\u0010L\u001a\u000204J\u0010\u0010M\u001a\u0004\u0018\u00010\u00132\u0006\u0010N\u001a\u000204J\u0006\u0010O\u001a\u000202J \u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\bH\u0002J2\u0010U\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010R\u001a\u00020\b2\b\b\u0001\u0010S\u001a\u00020\b2\b\b\u0001\u0010T\u001a\u00020\b2\b\b\u0001\u0010V\u001a\u00020\bH\u0002J\u0006\u0010W\u001a\u000204J\u000e\u0010X\u001a\u00020Y2\u0006\u0010W\u001a\u000204R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0019R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\rR\u000e\u0010-\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\rR\u0010\u00100\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u0010\u00109\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\rR\u001a\u0010<\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u0011\u0010?\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b?\u00106R\u000e\u0010@\u001a\u000202XD¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\n E*\u0004\u0018\u00010D0DX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010F\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\bG\u00106R\u001a\u0010H\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010\u0019¨\u0006Z"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/messageinput/MessageInputStyle;", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attachmentButtonDefaultIconColor", "", "attachmentButtonDefaultIconDisabledColor", "attachmentButtonDefaultIconPressedColor", "attachmentButtonHeight", "getAttachmentButtonHeight", "()I", "attachmentButtonIcon", "attachmentButtonSelectedIconColor", "attachmentButtonWidth", "getAttachmentButtonWidth", "attachmentCloseButtonBackground", "Landroid/graphics/drawable/Drawable;", "getAttachmentCloseButtonBackground", "()Landroid/graphics/drawable/Drawable;", "attachmentsMenuBackground", "getAttachmentsMenuBackground", "setAttachmentsMenuBackground", "(Landroid/graphics/drawable/Drawable;)V", "avatarStyle", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "getAvatarStyle", "()Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "inputBackground", "getInputBackground", "setInputBackground", "inputBackgroundText", "Lcom/getstream/sdk/chat/style/TextStyle;", "getInputBackgroundText", "()Lcom/getstream/sdk/chat/style/TextStyle;", "setInputBackgroundText", "(Lcom/getstream/sdk/chat/style/TextStyle;)V", "inputButtonDefaultIconColor", "inputButtonDefaultIconDisabledColor", "inputButtonDefaultIconPressedColor", "inputButtonEditIconColor", "inputButtonHeight", "getInputButtonHeight", "inputButtonIcon", "inputButtonWidth", "getInputButtonWidth", "inputEditBackground", "inputHint", "", "inputScrollbarEnabled", "", "getInputScrollbarEnabled", "()Z", "inputScrollbarFadingEnabled", "getInputScrollbarFadingEnabled", "inputSelectedBackground", "inputSendAlsoToChannelTextColor", "getInputSendAlsoToChannelTextColor", "inputText", "getInputText", "setInputText", "isShowAttachmentButton", "permissionSetKey", "prefs", "Landroid/content/SharedPreferences;", "res", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "sendAlsoToChannelCheckboxEnabled", "getSendAlsoToChannelCheckboxEnabled", "suggestionsBackground", "getSuggestionsBackground", "setSuggestionsBackground", "getAttachmentButtonIcon", "isSelected", "getInputButtonIcon", "isEdit", "getInputHint", "getMessageInputStyleColorList", "Landroid/content/res/ColorStateList;", "normalColor", "pressedColor", "disabledColor", "getSelector", "shape", "passedPermissionCheck", "setCheckPermissions", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputStyle.kt */
public final class MessageInputStyle {
    private final int attachmentButtonDefaultIconColor;
    private final int attachmentButtonDefaultIconDisabledColor;
    private final int attachmentButtonDefaultIconPressedColor;
    private final int attachmentButtonHeight;
    private final int attachmentButtonIcon;
    private final int attachmentButtonSelectedIconColor;
    private final int attachmentButtonWidth;
    private final Drawable attachmentCloseButtonBackground;
    public Drawable attachmentsMenuBackground;
    private final AvatarStyle avatarStyle;
    private final Context context;
    private Drawable inputBackground;
    private TextStyle inputBackgroundText;
    private final int inputButtonDefaultIconColor;
    private final int inputButtonDefaultIconDisabledColor;
    private final int inputButtonDefaultIconPressedColor;
    private final int inputButtonEditIconColor;
    private final int inputButtonHeight;
    private final int inputButtonIcon;
    private final int inputButtonWidth;
    private Drawable inputEditBackground;
    private String inputHint = "";
    private final boolean inputScrollbarEnabled;
    private final boolean inputScrollbarFadingEnabled;
    private Drawable inputSelectedBackground;
    private final int inputSendAlsoToChannelTextColor;
    private TextStyle inputText;
    private final boolean isShowAttachmentButton;
    private final String permissionSetKey;
    private final SharedPreferences prefs;
    private final Resources res;
    private final boolean sendAlsoToChannelCheckboxEnabled;
    public Drawable suggestionsBackground;

    public MessageInputStyle(Context context2, AttributeSet attributeSet) {
        Context context3 = context2;
        Intrinsics.checkNotNullParameter(context3, "context");
        this.context = context3;
        Resources resources = context2.getResources();
        this.res = resources;
        this.permissionSetKey = "permissionSetKey";
        TypedArray obtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, C1673R.styleable.MessageInputView);
        this.isShowAttachmentButton = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageInputView_streamShowAttachmentButton, true);
        this.attachmentButtonIcon = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamAttachmentButtonIcon, -1);
        this.attachmentButtonDefaultIconColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamAttachmentButtonDefaultIconColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_gray_dark));
        this.attachmentButtonDefaultIconPressedColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamAttachmentButtonDefaultIconPressedColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_white));
        this.attachmentButtonDefaultIconDisabledColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamAttachmentButtonDefaultIconDisabledColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_gray_light));
        this.attachmentButtonSelectedIconColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamAttachmentButtonSelectedIconColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_black));
        this.attachmentButtonWidth = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageInputView_streamAttachmentButtonWidth, resources.getDimensionPixelSize(C1673R.dimen.stream_attachment_button_width));
        this.attachmentButtonHeight = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageInputView_streamAttachmentButtonHeight, resources.getDimensionPixelSize(C1673R.dimen.stream_attachment_button_height));
        Drawable drawable = obtainStyledAttributes.getDrawable(C1673R.styleable.MessageInputView_streamAttachmentCloseButtonBackground);
        this.attachmentCloseButtonBackground = drawable == null ? ContextCompat.getDrawable(context3, C1673R.C1676drawable.stream_button_close) : drawable;
        this.inputButtonIcon = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamInputButtonIcon, -1);
        this.inputButtonDefaultIconColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamInputButtonDefaultIconColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_input_message_send_button));
        this.inputButtonEditIconColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamInputButtonEditIconColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_input_message_box_stroke_edit));
        this.inputButtonDefaultIconPressedColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamInputButtonDefaultIconPressedColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_white));
        this.inputButtonDefaultIconDisabledColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamInputButtonDefaultIconDisabledColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_gray_dark));
        this.inputButtonWidth = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageInputView_streamInputButtonWidth, resources.getDimensionPixelSize(C1673R.dimen.stream_input_button_width));
        this.inputButtonHeight = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageInputView_streamInputButtonHeight, resources.getDimensionPixelSize(C1673R.dimen.stream_input_button_height));
        String string = obtainStyledAttributes.getString(C1673R.styleable.MessageInputView_streamInputHint);
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, "it");
            this.inputHint = string;
        }
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "this");
        TextStyle.Builder builder = new TextStyle.Builder(obtainStyledAttributes);
        builder.size(C1673R.styleable.MessageInputView_streamInputTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_input_text_size));
        builder.color(C1673R.styleable.MessageInputView_streamInputTextColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_black));
        builder.hintColor(C1673R.styleable.MessageInputView_streamInputHintColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_gray_dark));
        builder.font(C1673R.styleable.MessageInputView_streamInputTextFontAssets, C1673R.styleable.MessageInputView_streamInputTextFont);
        builder.style(C1673R.styleable.MessageInputView_streamInputTextStyle, 0);
        Unit unit = Unit.INSTANCE;
        this.inputText = builder.build();
        this.inputScrollbarEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageInputView_streamInputScrollbarEnabled, false);
        this.inputScrollbarFadingEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageInputView_streamInputScrollbarFadingEnabled, false);
        Drawable drawable2 = context3.getDrawable(obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamInputBackground, C1673R.C1676drawable.stream_round_message_composer));
        if (drawable2 != null) {
            this.inputBackground = drawable2;
        }
        Drawable drawable3 = context3.getDrawable(obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamInputSelectedBackground, C1673R.C1676drawable.stream_round_message_composer_select));
        if (drawable3 != null) {
            this.inputSelectedBackground = drawable3;
        }
        Drawable drawable4 = context3.getDrawable(obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamInputEditBackground, C1673R.C1676drawable.stream_round_message_composer_edit));
        if (drawable4 != null) {
            this.inputEditBackground = drawable4;
        }
        TextStyle.Builder builder2 = new TextStyle.Builder(obtainStyledAttributes);
        builder2.size(C1673R.styleable.MessageInputView_streamInputBackgroundTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_input_text_size));
        builder2.color(C1673R.styleable.MessageInputView_streamInputBackgroundTextColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_black));
        builder2.font(C1673R.styleable.MessageInputView_streamInputBackgroundTextFontAssets, C1673R.styleable.MessageInputView_streamInputBackgroundTextFont);
        builder2.style(C1673R.styleable.MessageInputView_streamInputBackgroundTextStyle, 0);
        Unit unit2 = Unit.INSTANCE;
        this.inputBackgroundText = builder2.build();
        Drawable drawable5 = ContextCompat.getDrawable(context3, obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamInputAttachmentsMenuBackground, C1673R.C1676drawable.stream_round_thread_toolbar));
        if (drawable5 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable5, "it");
            this.attachmentsMenuBackground = drawable5;
        }
        Drawable drawable6 = ContextCompat.getDrawable(context3, obtainStyledAttributes.getResourceId(C1673R.styleable.MessageInputView_streamInputSuggestionsBackground, C1673R.C1676drawable.stream_round_thread_toolbar));
        if (drawable6 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable6, "it");
            this.suggestionsBackground = drawable6;
        }
        this.avatarStyle = AvatarStyle.Builder.avatarInitialText$default(new AvatarStyle.Builder(obtainStyledAttributes, context3).avatarWidth(C1673R.styleable.MessageInputView_streamAvatarWidth, C1673R.dimen.stream_message_avatar_width).avatarHeight(C1673R.styleable.MessageInputView_streamAvatarHeight, C1673R.dimen.stream_message_avatar_height).avatarBorderColor(C1673R.styleable.MessageInputView_streamAvatarBorderColor, -1).avatarBackgroundColor(C1673R.styleable.MessageInputView_streamAvatarBackGroundColor, ContextCompat.getColor(context3, C1673R.C1675color.stream_gray_dark)), C1673R.styleable.MessageInputView_streamAvatarTextSize, C1673R.dimen.stream_channel_initials, C1673R.styleable.MessageInputView_streamAvatarTextColor, -1, C1673R.styleable.MessageInputView_streamAvatarTextFontAssets, C1673R.styleable.MessageInputView_streamAvatarTextFont, C1673R.styleable.MessageInputView_streamAvatarTextStyle, 0, 128, (Object) null).build();
        this.inputSendAlsoToChannelTextColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageInputView_streamSendAlsoToChannel, ContextCompat.getColor(context3, C1673R.C1675color.stream_input_message_send_to_channel_checkbox));
        SharedPreferences sharedPreferences = context3.getSharedPreferences("MessageInputStyle", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ODE_PRIVATE\n            )");
        this.prefs = sharedPreferences;
        this.sendAlsoToChannelCheckboxEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageInputView_streamShowSendAlsoToChannelCheckbox, true);
        obtainStyledAttributes.recycle();
    }

    public final TextStyle getInputText() {
        return this.inputText;
    }

    public final void setInputText(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.inputText = textStyle;
    }

    public final TextStyle getInputBackgroundText() {
        return this.inputBackgroundText;
    }

    public final void setInputBackgroundText(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.inputBackgroundText = textStyle;
    }

    public final boolean isShowAttachmentButton() {
        return this.isShowAttachmentButton;
    }

    public final int getInputButtonWidth() {
        return this.inputButtonWidth;
    }

    public final int getInputButtonHeight() {
        return this.inputButtonHeight;
    }

    public final int getAttachmentButtonWidth() {
        return this.attachmentButtonWidth;
    }

    public final int getAttachmentButtonHeight() {
        return this.attachmentButtonHeight;
    }

    public final Drawable getAttachmentCloseButtonBackground() {
        return this.attachmentCloseButtonBackground;
    }

    public final int getInputSendAlsoToChannelTextColor() {
        return this.inputSendAlsoToChannelTextColor;
    }

    public final boolean getSendAlsoToChannelCheckboxEnabled() {
        return this.sendAlsoToChannelCheckboxEnabled;
    }

    public final boolean getInputScrollbarEnabled() {
        return this.inputScrollbarEnabled;
    }

    public final boolean getInputScrollbarFadingEnabled() {
        return this.inputScrollbarFadingEnabled;
    }

    public final Drawable getInputBackground() {
        return this.inputBackground;
    }

    public final void setInputBackground(Drawable drawable) {
        this.inputBackground = drawable;
    }

    public final Drawable getAttachmentsMenuBackground() {
        Drawable drawable = this.attachmentsMenuBackground;
        if (drawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attachmentsMenuBackground");
        }
        return drawable;
    }

    public final void setAttachmentsMenuBackground(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.attachmentsMenuBackground = drawable;
    }

    public final Drawable getSuggestionsBackground() {
        Drawable drawable = this.suggestionsBackground;
        if (drawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestionsBackground");
        }
        return drawable;
    }

    public final void setSuggestionsBackground(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.suggestionsBackground = drawable;
    }

    public final AvatarStyle getAvatarStyle() {
        return this.avatarStyle;
    }

    private final Drawable getSelector(int i, int i2, int i3, int i4) {
        Drawable drawable = ContextCompat.getDrawable(this.context, i4);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "DrawableCompat.wrap(drawable).mutate()");
        DrawableCompat.setTintList(mutate, getMessageInputStyleColorList(i, i2, i3));
        return mutate;
    }

    public final void setCheckPermissions(boolean z) {
        this.prefs.edit().putBoolean(this.permissionSetKey, z).apply();
    }

    public final boolean passedPermissionCheck() {
        return this.prefs.getBoolean(this.permissionSetKey, false);
    }

    private final ColorStateList getMessageInputStyleColorList(int i, int i2, int i3) {
        return new ColorStateList(new int[][]{new int[]{16842910, -16842919}, new int[]{16842910, 16842919}, new int[]{-16842910}}, new int[]{i, i2, i3});
    }

    public final Drawable getAttachmentButtonIcon(boolean z) {
        int i = this.attachmentButtonIcon;
        if (i != -1) {
            return ContextCompat.getDrawable(this.context, i);
        }
        return getSelector(z ? this.attachmentButtonSelectedIconColor : this.attachmentButtonDefaultIconColor, this.attachmentButtonDefaultIconPressedColor, this.attachmentButtonDefaultIconDisabledColor, C1673R.C1676drawable.stream_ic_add_attachment);
    }

    public final Drawable getInputButtonIcon(boolean z) {
        int i = this.inputButtonIcon;
        if (i != -1) {
            return ContextCompat.getDrawable(this.context, i);
        }
        return getSelector(z ? this.inputButtonEditIconColor : this.inputButtonDefaultIconColor, this.inputButtonDefaultIconPressedColor, this.inputButtonDefaultIconDisabledColor, C1673R.C1676drawable.stream_ic_send);
    }

    public final String getInputHint() {
        if (!TextUtils.isEmpty(this.inputHint)) {
            return this.inputHint;
        }
        String string = this.context.getString(C1673R.string.stream_input_hint);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.stream_input_hint)");
        return string;
    }
}
