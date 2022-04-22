package editor.tools.signature;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.media.MediaContent;
import editor.core.NicoViewModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Leditor/tools/signature/SignatureViewModel;", "Leditor/core/NicoViewModel;", "()V", "_signatureCreated", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/media/MediaContent;", "onSignatureCreated", "Landroidx/lifecycle/LiveData;", "saveSignatureBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "outputPath", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SignatureViewModel.kt */
public final class SignatureViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<MediaContent> _signatureCreated = new MutableLiveData<>();

    public final LiveData<MediaContent> onSignatureCreated() {
        return this._signatureCreated;
    }

    public final void saveSignatureBitmap(Bitmap bitmap, String str) {
        showBlockingProgress("Saving Signature..");
        if (bitmap == null || bitmap.isRecycled()) {
            showErrorOnBlockingProgress("Unable to retrieve signature data");
            return;
        }
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            showErrorOnBlockingProgress("Unable to access signature output path");
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new File(str);
        if (!((File) objectRef.element).exists()) {
            showErrorOnBlockingProgress("Signature output file doesn't exist");
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SignatureViewModel$saveSignatureBitmap$1(this, bitmap, objectRef, (Continuation) null), 3, (Object) null);
        }
    }
}
