package editor.core;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.memes.commons.contentlayout.ContentLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0004J\b\u0010\b\u001a\u00020\u0005H\u0004J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/core/NicoFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "activityHandle", "Leditor/core/NActivityHandle;", "dismiss", "", "getActivityHandle", "onAttach", "context", "Landroid/content/Context;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoFragment.kt */
public class NicoFragment extends Fragment implements ContentLayout.Callback {
    private NActivityHandle activityHandle;

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.activityHandle = (NActivityHandle) context;
        super.onAttach(context);
    }

    /* access modifiers changed from: protected */
    public final NActivityHandle getActivityHandle() {
        NActivityHandle nActivityHandle = this.activityHandle;
        if (nActivityHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityHandle");
        }
        return nActivityHandle;
    }

    /* access modifiers changed from: protected */
    public final void dismiss() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getSupportFragmentManager().popBackStack();
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        throw new RuntimeException("Content error resolution is not handled properly.");
    }
}
