package coil.request;

import android.graphics.drawable.Drawable;
import coil.request.ImageResult;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, mo26107d2 = {"Lcoil/request/SuccessResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "metadata", "Lcoil/request/ImageResult$Metadata;", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Lcoil/request/ImageResult$Metadata;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getMetadata", "()Lcoil/request/ImageResult$Metadata;", "getRequest", "()Lcoil/request/ImageRequest;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: ImageResult.kt */
public final class SuccessResult extends ImageResult {
    private final Drawable drawable;
    private final ImageResult.Metadata metadata;
    private final ImageRequest request;

    public static /* synthetic */ SuccessResult copy$default(SuccessResult successResult, Drawable drawable2, ImageRequest imageRequest, ImageResult.Metadata metadata2, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable2 = successResult.getDrawable();
        }
        if ((i & 2) != 0) {
            imageRequest = successResult.getRequest();
        }
        if ((i & 4) != 0) {
            metadata2 = successResult.metadata;
        }
        return successResult.copy(drawable2, imageRequest, metadata2);
    }

    public final Drawable component1() {
        return getDrawable();
    }

    public final ImageRequest component2() {
        return getRequest();
    }

    public final ImageResult.Metadata component3() {
        return this.metadata;
    }

    public final SuccessResult copy(Drawable drawable2, ImageRequest imageRequest, ImageResult.Metadata metadata2) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(metadata2, TtmlNode.TAG_METADATA);
        return new SuccessResult(drawable2, imageRequest, metadata2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual((Object) getDrawable(), (Object) successResult.getDrawable()) && Intrinsics.areEqual((Object) getRequest(), (Object) successResult.getRequest()) && Intrinsics.areEqual((Object) this.metadata, (Object) successResult.metadata);
    }

    public int hashCode() {
        Drawable drawable2 = getDrawable();
        int i = 0;
        int hashCode = (drawable2 != null ? drawable2.hashCode() : 0) * 31;
        ImageRequest request2 = getRequest();
        int hashCode2 = (hashCode + (request2 != null ? request2.hashCode() : 0)) * 31;
        ImageResult.Metadata metadata2 = this.metadata;
        if (metadata2 != null) {
            i = metadata2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SuccessResult(drawable=" + getDrawable() + ", request=" + getRequest() + ", metadata=" + this.metadata + ")";
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public final ImageResult.Metadata getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuccessResult(Drawable drawable2, ImageRequest imageRequest, ImageResult.Metadata metadata2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(metadata2, TtmlNode.TAG_METADATA);
        this.drawable = drawable2;
        this.request = imageRequest;
        this.metadata = metadata2;
    }
}
