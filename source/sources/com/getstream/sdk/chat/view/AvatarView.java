package com.getstream.sdk.chat.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.getstream.sdk.chat.images.StreamImageLoader;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J&\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u001e\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fJ\u0017\u0010!\u001a\u0004\u0018\u00010\u0014*\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001d\u0010!\u001a\u00020\u0014*\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010#J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c*\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010%\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/AvatarView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configUIs", "", "style", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "generateAvatarDrawable", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/getstream/sdk/chat/view/AvatarDrawable;", "", "(Lcom/getstream/sdk/chat/view/messages/AvatarStyle;Lkotlin/jvm/functions/Function1;)V", "createImageRounded", "Landroid/graphics/Bitmap;", "initials", "", "avatarStyle", "setChannelAndLastActiveUsers", "channel", "Lio/getstream/chat/android/client/models/Channel;", "lastActiveUsers", "", "Lio/getstream/chat/android/client/models/User;", "setLastActiveUsers", "setUser", "user", "createBitmap", "(Lio/getstream/chat/android/client/models/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/getstream/chat/android/client/models/User;Lcom/getstream/sdk/chat/view/messages/AvatarStyle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBitmaps", "(Ljava/util/List;Lcom/getstream/sdk/chat/view/messages/AvatarStyle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AvatarView.kt */
public final class AvatarView extends AppCompatImageView {
    public AvatarView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public AvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvatarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setLastActiveUsers(List<User> list, AvatarStyle avatarStyle) {
        Intrinsics.checkNotNullParameter(list, "lastActiveUsers");
        Intrinsics.checkNotNullParameter(avatarStyle, "style");
        configUIs(avatarStyle, new AvatarView$setLastActiveUsers$1(this, list, avatarStyle, (Continuation) null));
    }

    public final void setChannelAndLastActiveUsers(Channel channel, List<User> list, AvatarStyle avatarStyle) {
        Intrinsics.checkNotNullParameter(list, "lastActiveUsers");
        Intrinsics.checkNotNullParameter(avatarStyle, "style");
        configUIs(avatarStyle, new AvatarView$setChannelAndLastActiveUsers$1(this, channel, list, avatarStyle, (Continuation) null));
    }

    public final void setUser(User user, AvatarStyle avatarStyle) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(avatarStyle, "style");
        configUIs(avatarStyle, new AvatarView$setUser$1(this, user, avatarStyle, (Continuation) null));
    }

    private final void configUIs(AvatarStyle avatarStyle, Function1<? super Continuation<? super AvatarDrawable>, ? extends Object> function1) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new AvatarView$configUIs$1(this, avatarStyle, function1, (Continuation) null), 2, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.getstream.sdk.chat.view.messages.AvatarStyle} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createBitmap(p015io.getstream.chat.android.client.models.User r7, com.getstream.sdk.chat.view.messages.AvatarStyle r8, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.getstream.sdk.chat.view.AvatarView$createBitmap$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.getstream.sdk.chat.view.AvatarView$createBitmap$1 r0 = (com.getstream.sdk.chat.view.AvatarView$createBitmap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.getstream.sdk.chat.view.AvatarView$createBitmap$1 r0 = new com.getstream.sdk.chat.view.AvatarView$createBitmap$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.L$2
            r8 = r7
            com.getstream.sdk.chat.view.messages.AvatarStyle r8 = (com.getstream.sdk.chat.view.messages.AvatarStyle) r8
            java.lang.Object r7 = r0.L$1
            io.getstream.chat.android.client.models.User r7 = (p015io.getstream.chat.android.client.models.User) r7
            java.lang.Object r0 = r0.L$0
            com.getstream.sdk.chat.view.AvatarView r0 = (com.getstream.sdk.chat.view.AvatarView) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0069
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r9)
            com.getstream.sdk.chat.images.StreamImageLoader$Companion r9 = com.getstream.sdk.chat.images.StreamImageLoader.Companion
            com.getstream.sdk.chat.images.StreamImageLoader r9 = r9.instance()
            android.content.Context r2 = r6.getContext()
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r4 = p015io.getstream.chat.android.client.models.ContentUtils.getImage((p015io.getstream.chat.android.client.models.User) r7)
            com.getstream.sdk.chat.images.StreamImageLoader$ImageTransformation$Circle r5 = com.getstream.sdk.chat.images.StreamImageLoader.ImageTransformation.Circle.INSTANCE
            com.getstream.sdk.chat.images.StreamImageLoader$ImageTransformation r5 = (com.getstream.sdk.chat.images.StreamImageLoader.ImageTransformation) r5
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r9 = r9.loadAsBitmap(r2, r4, r5, r0)
            if (r9 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r0 = r6
        L_0x0069:
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            if (r9 == 0) goto L_0x006e
            goto L_0x0076
        L_0x006e:
            java.lang.String r7 = p015io.getstream.chat.android.client.models.ContentUtils.getInitials((p015io.getstream.chat.android.client.models.User) r7)
            android.graphics.Bitmap r9 = r0.createImageRounded(r7, r8)
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.view.AvatarView.createBitmap(io.getstream.chat.android.client.models.User, com.getstream.sdk.chat.view.messages.AvatarStyle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createBitmaps(java.util.List<p015io.getstream.chat.android.client.models.User> r8, com.getstream.sdk.chat.view.messages.AvatarStyle r9, kotlin.coroutines.Continuation<? super java.util.List<android.graphics.Bitmap>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.getstream.sdk.chat.view.AvatarView$createBitmaps$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.getstream.sdk.chat.view.AvatarView$createBitmaps$1 r0 = (com.getstream.sdk.chat.view.AvatarView$createBitmaps$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.getstream.sdk.chat.view.AvatarView$createBitmaps$1 r0 = new com.getstream.sdk.chat.view.AvatarView$createBitmaps$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r8 = r0.L$4
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Object r9 = r0.L$3
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$2
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$1
            com.getstream.sdk.chat.view.messages.AvatarStyle r4 = (com.getstream.sdk.chat.view.messages.AvatarStyle) r4
            java.lang.Object r5 = r0.L$0
            com.getstream.sdk.chat.view.AvatarView r5 = (com.getstream.sdk.chat.view.AvatarView) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008a
        L_0x003e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r10 = 3
            java.util.List r8 = kotlin.collections.CollectionsKt.take(r8, r10)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r10 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r2)
            r10.<init>(r2)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r8 = r8.iterator()
            r5 = r7
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L_0x0068:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0092
            java.lang.Object r2 = r9.next()
            io.getstream.chat.android.client.models.User r2 = (p015io.getstream.chat.android.client.models.User) r2
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r8
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r2 = r5.createBitmap(r2, r10, r0)
            if (r2 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r4 = r10
            r10 = r2
            r2 = r8
        L_0x008a:
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            r8.add(r10)
            r8 = r2
            r10 = r4
            goto L_0x0068
        L_0x0092:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.view.AvatarView.createBitmaps(java.util.List, com.getstream.sdk.chat.view.messages.AvatarStyle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object createBitmap(Channel channel, Continuation<? super Bitmap> continuation) {
        StreamImageLoader instance = StreamImageLoader.Companion.instance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return instance.loadAsBitmap(context, ContentUtils.getImage(channel), StreamImageLoader.ImageTransformation.Circle.INSTANCE, continuation);
    }

    /* access modifiers changed from: private */
    public final Bitmap createImageRounded(String str, AvatarStyle avatarStyle) {
        boolean z = true;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(avatarStyle.getAvatarInitialText().getFont());
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(avatarStyle.getAvatarInitialText().getColor());
        paint.setTextSize((float) avatarStyle.getAvatarInitialText().getSize());
        Paint paint2 = new Paint(1);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(avatarStyle.getAvatarBackgroundColor());
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        Integer valueOf = Integer.valueOf(Math.max(rect.width(), rect.height()));
        if (valueOf.intValue() > 0) {
            z = false;
        }
        if (z) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : 100;
        int i = intValue * 2;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = (float) intValue;
        canvas.drawCircle(f, f, f, paint2);
        canvas.drawText(str, f, (float) (intValue + (rect.height() / 2)), paint);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "output");
        return createBitmap;
    }
}
