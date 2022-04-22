package editor.optionsui.layout.templates;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.memes.commons.output.OutputTargetGenerator;
import editor.core.NicoViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000fJ\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t0\u000fR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Leditor/optionsui/layout/templates/TemplatesViewModel;", "Leditor/core/NicoViewModel;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Lcom/memes/commons/output/OutputTargetGenerator;)V", "_templateDownloaded", "Landroidx/lifecycle/MutableLiveData;", "Leditor/optionsui/layout/templates/Template;", "_trendingTemplates", "", "downloadTemplate", "", "template", "loadTrendingTemplates", "onTemplateDownloaded", "Landroidx/lifecycle/LiveData;", "trendingTemplates", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TemplatesViewModel.kt */
public final class TemplatesViewModel extends NicoViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Template> _templateDownloaded = new MutableLiveData<>();
    private final MutableLiveData<List<Template>> _trendingTemplates = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    public TemplatesViewModel(OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.outputTargetGenerator = outputTargetGenerator2;
        loadTrendingTemplates();
    }

    public final LiveData<List<Template>> trendingTemplates() {
        return this._trendingTemplates;
    }

    public final LiveData<Template> onTemplateDownloaded() {
        return this._templateDownloaded;
    }

    public final void loadTrendingTemplates() {
        this._trendingTemplates.setValue(CollectionsKt.emptyList());
    }

    public final void downloadTemplate(Template template) {
        Intrinsics.checkNotNullParameter(template, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TemplatesViewModel$downloadTemplate$1(this, template, (Continuation) null), 3, (Object) null);
    }
}
