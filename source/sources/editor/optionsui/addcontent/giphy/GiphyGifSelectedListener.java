package editor.optionsui.addcontent.giphy;

import com.giphy.sdk.core.models.Image;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.p013ui.views.GiphyDialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.network.giphy.api.model.GiphyGif;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B*\u0012#\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R+\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/optionsui/addcontent/giphy/GiphyGifSelectedListener;", "Lcom/giphy/sdk/ui/views/GiphyDialogFragment$GifSelectionListener;", "listener", "Lkotlin/Function1;", "Lcom/memes/network/giphy/api/model/GiphyGif;", "Lkotlin/ParameterName;", "name", "giphyGif", "", "(Lkotlin/jvm/functions/Function1;)V", "onDismissed", "onGifSelected", "media", "Lcom/giphy/sdk/core/models/Media;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyGifSelectedListener.kt */
public final class GiphyGifSelectedListener implements GiphyDialogFragment.GifSelectionListener {
    private final Function1<GiphyGif, Unit> listener;

    public GiphyGifSelectedListener(Function1<? super GiphyGif, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = function1;
    }

    public void onDismissed() {
        this.listener.invoke(null);
    }

    public void onGifSelected(Media media) {
        Intrinsics.checkNotNullParameter(media, "media");
        Image original = media.getImages().getOriginal();
        if (original != null) {
            String gifUrl = original.getGifUrl();
            CharSequence charSequence = gifUrl;
            boolean z = false;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                String mp4Url = original.getMp4Url();
                CharSequence charSequence2 = mp4Url;
                if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                    z = true;
                }
                if (!z) {
                    this.listener.invoke(new GiphyGif(media.getId(), gifUrl, mp4Url, original.getWidth(), original.getHeight()));
                }
            }
        }
    }
}
