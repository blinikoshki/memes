package com.memes.chat.p036ui.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.memes.chat.C4059R;
import com.memes.chat.databinding.VChatUserAvatarViewBinding;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\b\u0003\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0014J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020!R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/ChatUserAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/chat/databinding/VChatUserAvatarViewBinding;", "getBinding", "()Lcom/memes/chat/databinding/VChatUserAvatarViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "loadedImageUrl", "", "loadDrawable", "", "drawableRes", "", "loadUrl", "imageUrl", "placeholderRes", "onFinishInflate", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSizeChanged", "w", "h", "oldw", "oldh", "setPresenceIndicatorState", "Lcom/memes/chat/ui/custom/ChatUserAvatarView$PresenceIndicatorState;", "PresenceIndicatorState", "SavedState", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView */
/* compiled from: ChatUserAvatarView.kt */
public final class ChatUserAvatarView extends ConstraintLayout {
    private final Lazy binding$delegate;
    private String loadedImageUrl;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/ChatUserAvatarView$PresenceIndicatorState;", "", "(Ljava/lang/String;I)V", "ONLINE", "OFFLINE", "INVISIBLE", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView$PresenceIndicatorState */
    /* compiled from: ChatUserAvatarView.kt */
    public enum PresenceIndicatorState {
        ONLINE,
        OFFLINE,
        INVISIBLE
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PresenceIndicatorState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PresenceIndicatorState.ONLINE.ordinal()] = 1;
            iArr[PresenceIndicatorState.OFFLINE.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final VChatUserAvatarViewBinding getBinding() {
        return (VChatUserAvatarViewBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatUserAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new ChatUserAvatarView$binding$2(this, context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        AppCompatImageView appCompatImageView = getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.avatarImageView");
        appCompatImageView.setBackground(getBackground());
        setBackground((Drawable) null);
        setPresenceIndicatorState(PresenceIndicatorState.INVISIBLE);
        float dimension = getResources().getDimension(C4059R.dimen._100sdp);
        AppCompatImageView appCompatImageView2 = getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.avatarImageView");
        ViewCornerOutlineProviderKt.roundCorners$default((View) appCompatImageView2, dimension, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getBinding().presenceIndicatorView.post(new ChatUserAvatarView$onSizeChanged$1(this, i));
    }

    public final void setPresenceIndicatorState(PresenceIndicatorState presenceIndicatorState) {
        int i;
        Intrinsics.checkNotNullParameter(presenceIndicatorState, "state");
        if (presenceIndicatorState == PresenceIndicatorState.INVISIBLE) {
            ImageView imageView = getBinding().presenceIndicatorView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.presenceIndicatorView");
            imageView.setVisibility(8);
            return;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[presenceIndicatorState.ordinal()];
        if (i2 == 1) {
            i = C4059R.C4062drawable.chat_user_online;
        } else if (i2 == 2) {
            i = C4059R.C4062drawable.chat_user_offline;
        } else {
            throw new RuntimeException("Unknown presence-indicator-state: " + presenceIndicatorState);
        }
        getBinding().presenceIndicatorView.setImageResource(i);
        ImageView imageView2 = getBinding().presenceIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.presenceIndicatorView");
        imageView2.setVisibility(0);
    }

    public static /* synthetic */ void loadUrl$default(ChatUserAvatarView chatUserAvatarView, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        chatUserAvatarView.loadUrl(str, i);
    }

    public final void loadUrl(String str, int i) {
        this.loadedImageUrl = str;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            getBinding().avatarImageView.setImageResource(i);
        } else {
            ((RequestBuilder) Glide.with((View) this).load(str).placeholder(i)).into((ImageView) getBinding().avatarImageView);
        }
    }

    public final void loadDrawable(int i) {
        this.loadedImageUrl = null;
        getBinding().avatarImageView.setImageResource(i);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/ChatUserAvatarView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "loadedImageUrl", "", "getLoadedImageUrl", "()Ljava/lang/String;", "setLoadedImageUrl", "(Ljava/lang/String;)V", "toString", "writeToParcel", "", "flags", "", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView$SavedState */
    /* compiled from: ChatUserAvatarView.kt */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new ChatUserAvatarView$SavedState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String loadedImageUrl;

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/custom/ChatUserAvatarView$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/memes/chat/ui/custom/ChatUserAvatarView$SavedState;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView$SavedState$Companion */
        /* compiled from: ChatUserAvatarView.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String getLoadedImageUrl() {
            return this.loadedImageUrl;
        }

        public final void setLoadedImageUrl(String str) {
            this.loadedImageUrl = str;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            super.writeToParcel(parcel, i);
            parcel.writeString(this.loadedImageUrl);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.loadedImageUrl = parcel.readString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(sb.getClass().getSimpleName());
            sb.append(".SavedState { ");
            sb.append(Integer.toHexString(System.identityHashCode(sb)));
            sb.append(" image=");
            sb.append(this.loadedImageUrl);
            sb.append(" }");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setLoadedImageUrl(this.loadedImageUrl);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            parcelable = null;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState != null ? savedState.getSuperState() : null);
        String loadedImageUrl2 = savedState != null ? savedState.getLoadedImageUrl() : null;
        CharSequence charSequence = loadedImageUrl2;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            loadUrl$default(this, loadedImageUrl2, 0, 2, (Object) null);
        }
    }
}
