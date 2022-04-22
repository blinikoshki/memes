package editor.optionsui.addcontent.giphy;

import androidx.fragment.app.FragmentManager;
import com.giphy.sdk.p013ui.GPHSettings;
import com.giphy.sdk.p013ui.views.GiphyDialogFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/optionsui/addcontent/giphy/GiphyProxy;", "", "()V", "TAG", "", "showGiphyDialog", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "listener", "Leditor/optionsui/addcontent/giphy/GiphyGifSelectedListener;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GiphyProxy.kt */
public final class GiphyProxy {
    public static final GiphyProxy INSTANCE = new GiphyProxy();
    private static final String TAG = "giphy_dialog";

    private GiphyProxy() {
    }

    public final void showGiphyDialog(FragmentManager fragmentManager, GiphyGifSelectedListener giphyGifSelectedListener) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(giphyGifSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!ExtKt.fragmentTagExists(fragmentManager, TAG)) {
            GiphyDialogFragment newInstance$default = GiphyDialogFragment.Companion.newInstance$default(GiphyDialogFragment.Companion, (GPHSettings) null, 1, (Object) null);
            newInstance$default.setGifSelectionListener(giphyGifSelectedListener);
            newInstance$default.show(fragmentManager, TAG);
        }
    }
}
