package editor.editor.dashboard.drafts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.SingleLiveEvent;
import editor.contentport.ContentPortUtil;
import editor.core.NicoViewModel;
import editor.database.dao.EditorDraftsDao;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.util.rules.RuleFailedException;
import editor.util.rules.musthavefreespace.MustHaveFreeSpaceRule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0019\u0010$\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010%J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0'J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0'J\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0'J\u0019\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001e\u0010*\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u00061"}, mo26107d2 = {"Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "Leditor/core/NicoViewModel;", "draftsDao", "Leditor/database/dao/EditorDraftsDao;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/database/dao/EditorDraftsDao;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_draftDeletedLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_draftSavedLiveData", "Leditor/editor/dashboard/drafts/EditorDraft;", "_draftsLiveData", "", "draftExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDraftExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "draftExceptionHandler$delegate", "Lkotlin/Lazy;", "portUtil", "Leditor/contentport/ContentPortUtil;", "getPortUtil", "()Leditor/contentport/ContentPortUtil;", "portUtil$delegate", "deleteDraft", "", "draftId", "fetchDrafts", "handleDraftsException", "", "throwable", "", "handleFailedRule", "exception", "Leditor/util/rules/RuleFailedException;", "importDraft", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDraftDeleted", "Landroidx/lifecycle/LiveData;", "onDraftSaved", "onDraftsFound", "saveDraft", "draft", "(Leditor/editor/dashboard/drafts/EditorDraft;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "frame", "Leditor/editor/editorframehost/frame/EditorFrame;", "thumbnailPath", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsViewModel.kt */
public final class EditorDraftsViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _draftDeletedLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<EditorDraft> _draftSavedLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<EditorDraft>> _draftsLiveData = new SingleLiveEvent<>();
    private final Lazy draftExceptionHandler$delegate;
    /* access modifiers changed from: private */
    public final EditorDraftsDao draftsDao;
    private final Lazy portUtil$delegate;

    /* access modifiers changed from: private */
    public final ContentPortUtil getPortUtil() {
        return (ContentPortUtil) this.portUtil$delegate.getValue();
    }

    public final CoroutineExceptionHandler getDraftExceptionHandler() {
        return (CoroutineExceptionHandler) this.draftExceptionHandler$delegate.getValue();
    }

    public EditorDraftsViewModel(EditorDraftsDao editorDraftsDao, OutputTargetGenerator outputTargetGenerator) {
        Intrinsics.checkNotNullParameter(editorDraftsDao, "draftsDao");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
        this.draftsDao = editorDraftsDao;
        this.portUtil$delegate = LazyKt.lazy(new EditorDraftsViewModel$portUtil$2(outputTargetGenerator));
        this.draftExceptionHandler$delegate = LazyKt.lazy(new EditorDraftsViewModel$draftExceptionHandler$2(this));
    }

    public final LiveData<List<EditorDraft>> onDraftsFound() {
        return this._draftsLiveData;
    }

    public final LiveData<String> onDraftDeleted() {
        return this._draftDeletedLiveData;
    }

    public final LiveData<EditorDraft> onDraftSaved() {
        return this._draftSavedLiveData;
    }

    public final void fetchDrafts() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new EditorDraftsViewModel$fetchDrafts$1(this, (Continuation) null), 3, (Object) null);
    }

    public final Object importDraft(String str, Continuation<? super EditorDraft> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EditorDraftsViewModel$importDraft$2(this, str, (Continuation) null), continuation);
    }

    public final void saveDraft(String str, EditorFrame editorFrame, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(editorFrame, "frame");
        Intrinsics.checkNotNullParameter(str2, "thumbnailPath");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getDraftExceptionHandler(), (CoroutineStart) null, new EditorDraftsViewModel$saveDraft$1(this, editorFrame, str2, str, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object saveDraft(EditorDraft editorDraft, Continuation<? super EditorDraft> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EditorDraftsViewModel$saveDraft$3(this, editorDraft, (Continuation) null), continuation);
    }

    public final void deleteDraft(String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new EditorDraftsViewModel$deleteDraft$1(this, str, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean handleDraftsException(Throwable th) {
        if (th instanceof RuleFailedException) {
            return handleFailedRule((RuleFailedException) th);
        }
        return false;
    }

    private final boolean handleFailedRule(RuleFailedException ruleFailedException) {
        boolean z = false;
        if (!(ruleFailedException.getFailedRule() instanceof MustHaveFreeSpaceRule)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The draft cannot be saved or imported because of low storage space.");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CharSequence message = ruleFailedException.getMessage();
        if (message == null || StringsKt.isBlank(message)) {
            z = true;
        }
        if (!z) {
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append(ruleFailedException.getMessage());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        showErrorOnBlockingProgress(sb2);
        return true;
    }
}
