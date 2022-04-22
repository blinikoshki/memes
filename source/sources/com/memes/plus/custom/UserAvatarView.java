package com.memes.plus.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.UserAvatarViewBinding;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\bJ+\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\b\u0003\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001bH\u0014J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\n\u0010%\u001a\u0004\u0018\u00010$H\u0014J(\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0014J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\nR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\n¨\u0006/"}, mo26107d2 = {"Lcom/memes/plus/custom/UserAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "basicBorderStrokeColor", "", "getBasicBorderStrokeColor", "()I", "basicBorderStrokeColor$delegate", "Lkotlin/Lazy;", "binding", "Lcom/memes/plus/databinding/UserAvatarViewBinding;", "getBinding", "()Lcom/memes/plus/databinding/UserAvatarViewBinding;", "binding$delegate", "borderStrokeWidth", "getBorderStrokeWidth", "borderStrokeWidth$delegate", "loadedImageUrl", "", "proBorderStrokeColor", "getProBorderStrokeColor", "proBorderStrokeColor$delegate", "loadDrawable", "", "placeholderRes", "loadUrl", "imageUrl", "resize", "(Ljava/lang/String;ILjava/lang/Integer;)V", "onFinishInflate", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSizeChanged", "w", "h", "oldw", "oldh", "setProUser", "isProUser", "", "SavedState", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarView.kt */
public final class UserAvatarView extends ConstraintLayout {
    private final Lazy basicBorderStrokeColor$delegate;
    private final Lazy binding$delegate;
    private final Lazy borderStrokeWidth$delegate = LazyKt.lazy(new UserAvatarView$borderStrokeWidth$2(this));
    private String loadedImageUrl;
    private final Lazy proBorderStrokeColor$delegate;

    private final int getBasicBorderStrokeColor() {
        return ((Number) this.basicBorderStrokeColor$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final UserAvatarViewBinding getBinding() {
        return (UserAvatarViewBinding) this.binding$delegate.getValue();
    }

    private final int getBorderStrokeWidth() {
        return ((Number) this.borderStrokeWidth$delegate.getValue()).intValue();
    }

    private final int getProBorderStrokeColor() {
        return ((Number) this.proBorderStrokeColor$delegate.getValue()).intValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.binding$delegate = LazyKt.lazy(new UserAvatarView$binding$2(this, context));
        this.basicBorderStrokeColor$delegate = LazyKt.lazy(new UserAvatarView$basicBorderStrokeColor$2(context));
        this.proBorderStrokeColor$delegate = LazyKt.lazy(new UserAvatarView$proBorderStrokeColor$2(context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        AppCompatImageView appCompatImageView = getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.avatarImageView");
        appCompatImageView.setBackground(getBackground());
        setBackground((Drawable) null);
        setProUser(false);
        float dimension = getResources().getDimension(C4199R.dimen._100sdp);
        AppCompatImageView appCompatImageView2 = getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.avatarImageView");
        ViewCornerOutlineProviderKt.roundCorners$default((View) appCompatImageView2, dimension, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getBinding().proUserIndicatorView.post(new UserAvatarView$onSizeChanged$1(this, i));
    }

    public final void setProUser(boolean z) {
        View view = getBinding().borderView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.borderView");
        Drawable background = view.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (!z) {
            getBinding().proUserIndicatorView.setImageResource(0);
            gradientDrawable.setStroke(getBorderStrokeWidth(), getBasicBorderStrokeColor());
            return;
        }
        getBinding().proUserIndicatorView.setImageResource(C4199R.C4202drawable.icon_pro_badge);
        gradientDrawable.setStroke(getBorderStrokeWidth(), getProBorderStrokeColor());
    }

    public static /* synthetic */ void loadUrl$default(UserAvatarView userAvatarView, String str, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        userAvatarView.loadUrl(str, i, num);
    }

    public final void loadUrl(String str, int i, Integer num) {
        this.loadedImageUrl = str;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            loadDrawable(i);
        } else {
            ((RequestBuilder) ((RequestBuilder) Glide.with((View) this).load(str).placeholder(i)).error(i)).into((ImageView) getBinding().avatarImageView);
        }
    }

    public final void loadDrawable(int i) {
        this.loadedImageUrl = null;
        getBinding().avatarImageView.setImageResource(i);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/custom/UserAvatarView$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "loadedImageUrl", "", "getLoadedImageUrl", "()Ljava/lang/String;", "setLoadedImageUrl", "(Ljava/lang/String;)V", "toString", "writeToParcel", "", "flags", "", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: UserAvatarView.kt */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new UserAvatarView$SavedState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String loadedImageUrl;

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/custom/UserAvatarView$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/memes/plus/custom/UserAvatarView$SavedState;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: UserAvatarView.kt */
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
        String str = null;
        if (!(parcelable instanceof SavedState)) {
            parcelable = null;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState != null ? savedState.getSuperState() : null);
        if (savedState != null) {
            str = savedState.getLoadedImageUrl();
        }
        String str2 = str;
        CharSequence charSequence = str2;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            loadUrl$default(this, str2, 0, (Integer) null, 6, (Object) null);
        }
    }
}
