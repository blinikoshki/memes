package com.giphy.sdk.p013ui.views;

import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.MediaResponse;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/ui/views/GifView$setMediaWithId$1", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/MediaResponse;", "onComplete", "", "result", "e", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifView$setMediaWithId$1 */
/* compiled from: GifView.kt */
public final class GifView$setMediaWithId$1 implements CompletionHandler<MediaResponse> {
    final /* synthetic */ RenditionType $renditionType;
    final /* synthetic */ GifView this$0;

    GifView$setMediaWithId$1(GifView gifView, RenditionType renditionType) {
        this.this$0 = gifView;
        this.$renditionType = renditionType;
    }

    public void onComplete(MediaResponse mediaResponse, Throwable th) {
        if (mediaResponse != null) {
            GifView.setMedia$default(this.this$0, mediaResponse.getData(), this.$renditionType, (Integer) null, 4, (Object) null);
        }
        if (th != null) {
            th.printStackTrace();
        }
    }
}
