package com.getstream.sdk.chat.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.images.ViewExtensionsKt;
import com.getstream.sdk.chat.style.ChatFonts;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.utils.Utils;
import com.getstream.sdk.chat.utils.roundedImageView.CircularImageView;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0003J0\u0010\u0013\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/ReadStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarStyle", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "isIncoming", "", "readStateStyle", "Lcom/getstream/sdk/chat/view/ReadStateStyle;", "reads", "", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "init", "", "setReads", "Companion", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ReadStateView.kt */
public final class ReadStateView extends RelativeLayout {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final AvatarStyle defaultAvatarStyle = new AvatarStyle(0, 0, 0, 0, 0, new TextStyle());
    @Deprecated
    private static final ReadStateStyle defaultReadStateStyle = new ReadStateStyle(new TextStyle(), false, false, 0, 0);
    private AvatarStyle avatarStyle = defaultAvatarStyle;
    private boolean isIncoming;
    private ReadStateStyle readStateStyle = defaultReadStateStyle;
    private List<ChannelUserRead> reads = CollectionsKt.emptyList();

    public ReadStateView(Context context) {
        super(context);
        init();
    }

    public ReadStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public static /* synthetic */ void setReads$default(ReadStateView readStateView, List list, boolean z, ReadStateStyle readStateStyle2, AvatarStyle avatarStyle2, int i, Object obj) {
        if ((i & 4) != 0) {
            readStateStyle2 = defaultReadStateStyle;
        }
        if ((i & 8) != 0) {
            avatarStyle2 = defaultAvatarStyle;
        }
        readStateView.setReads(list, z, readStateStyle2, avatarStyle2);
    }

    public final void setReads(List<ChannelUserRead> list, boolean z, ReadStateStyle readStateStyle2, AvatarStyle avatarStyle2) {
        Intrinsics.checkNotNullParameter(list, "reads");
        Intrinsics.checkNotNullParameter(readStateStyle2, "readStateStyle");
        Intrinsics.checkNotNullParameter(avatarStyle2, "avatarStyle");
        this.reads = list;
        this.readStateStyle = readStateStyle2;
        this.avatarStyle = avatarStyle2;
        this.isIncoming = z;
        init();
    }

    private final void init() {
        removeAllViews();
        if (this.readStateStyle.isReadStateEnabled() && !this.reads.isEmpty()) {
            ChatFonts fonts = ChatUI.Companion.instance().getFonts();
            User user = this.reads.get(0).getUser();
            String image = ContentUtils.getImage(user);
            CircularImageView circularImageView = new CircularImageView(getContext());
            circularImageView.setPlaceholder(ContentUtils.getInitials(user), this.avatarStyle.getAvatarBackgroundColor(), this.readStateStyle.getReadStateText().getColor());
            Typeface font = fonts.getFont(this.readStateStyle.getReadStateText());
            if (font != null) {
                circularImageView.setPlaceholderTextSize(0, this.readStateStyle.getReadStateText().getSize(), font);
            } else {
                circularImageView.setPlaceholderTextSize(0, this.readStateStyle.getReadStateText().getSize(), this.readStateStyle.getReadStateText().getStyle());
            }
            if (!Utils.isSVGImage(image)) {
                ViewExtensionsKt.load$default(circularImageView, image, (Integer) null, (StreamImageLoader.ImageTransformation) null, (Function0) null, (Function0) null, 30, (Object) null);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.readStateStyle.getReadStateAvatarWidth(), this.readStateStyle.getReadStateAvatarHeight());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.readStateStyle.getReadStateAvatarHeight());
            circularImageView.setId(1);
            if (this.reads.size() < 2) {
                circularImageView.setLayoutParams(layoutParams);
                addView(circularImageView);
                return;
            }
            TextView textView = new TextView(getContext());
            textView.setText(String.valueOf(this.reads.size() - 1));
            textView.setTextColor(this.readStateStyle.getReadStateText().getColor());
            textView.setTextSize(0, (float) this.readStateStyle.getReadStateText().getSize());
            fonts.setFont(this.readStateStyle.getReadStateText(), textView);
            textView.setGravity(17);
            textView.setId(2);
            if (this.isIncoming) {
                layoutParams2.addRule(1, circularImageView.getId());
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                layoutParams2.setMarginStart(context.getResources().getDimensionPixelOffset(C1673R.dimen.stream_composer_stroke_width));
            } else {
                layoutParams.addRule(1, textView.getId());
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                layoutParams.setMarginStart(context2.getResources().getDimensionPixelOffset(C1673R.dimen.stream_composer_stroke_width));
            }
            circularImageView.setLayoutParams(layoutParams);
            textView.setLayoutParams(layoutParams2);
            addView(textView);
            addView(circularImageView);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/ReadStateView$Companion;", "", "()V", "defaultAvatarStyle", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "defaultReadStateStyle", "Lcom/getstream/sdk/chat/view/ReadStateStyle;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ReadStateView.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
