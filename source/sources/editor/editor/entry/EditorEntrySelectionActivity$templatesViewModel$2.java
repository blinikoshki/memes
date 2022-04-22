package editor.editor.entry;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import editor.core.BaseViewModelFactory;
import editor.optionsui.layout.templates.TemplatesViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/optionsui/layout/templates/TemplatesViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$templatesViewModel$2 extends Lambda implements Function0<TemplatesViewModel> {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorEntrySelectionActivity$templatesViewModel$2(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        super(0);
        this.this$0 = editorEntrySelectionActivity;
    }

    public final TemplatesViewModel invoke() {
        ViewModel viewModel = ViewModelProviders.m18of((FragmentActivity) this.this$0, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<TemplatesViewModel>(this) {
            final /* synthetic */ EditorEntrySelectionActivity$templatesViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final TemplatesViewModel invoke() {
                return new TemplatesViewModel(this.this$0.this$0.getOutputTargetGenerator());
            }
        })).get(TemplatesViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…r)\n\t\t).get(T::class.java)");
        return (TemplatesViewModel) viewModel;
    }
}
