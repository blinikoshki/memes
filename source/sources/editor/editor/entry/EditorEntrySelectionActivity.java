package editor.editor.entry;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.editor.databinding.NEditorEntrySelectionActivityBinding;
import editor.common.assetsprovider.AssetsProvider;
import editor.core.NicoActivity;
import editor.custom.mediacategoryview.MediaCategoryView;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.dashboard.drafts.EditorDraftsViewModel;
import editor.editor.entry.drafts.EditorDraftEntriesAdapter;
import editor.editor.entry.framesizes.EntryFrameSizesAdapter;
import editor.editor.entry.framesizes.EntryFrameSizesViewModel;
import editor.optionsui.frame.frameresize.FrameSize;
import editor.optionsui.frame.frameresize.customframesizeinput.CustomFrameSizeInputBottomSheet;
import editor.optionsui.layout.templates.Template;
import editor.optionsui.layout.templates.TemplatesAdapter;
import editor.optionsui.layout.templates.TemplatesViewModel;
import editor.optionsui.layout.wireframes.WireframeItem;
import editor.optionsui.layout.wireframes.WireframesAdapter;
import editor.optionsui.layout.wireframes.WireframesViewModel;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020'H\u0002J\u0012\u0010>\u001a\u00020'2\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u00020'H\u0014J\u0018\u0010B\u001a\u00020'2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0002J\b\u0010F\u001a\u00020'H\u0002J\u0018\u0010G\u001a\u00020'2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010DH\u0002J\u0018\u0010J\u001a\u00020'2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010DH\u0002J\u0018\u0010M\u001a\u00020'2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010DH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\b\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0002¢\u0006\f\n\u0004\b6\u0010\b\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010\b\u001a\u0004\b9\u0010:¨\u0006P"}, mo26107d2 = {"Leditor/editor/entry/EditorEntrySelectionActivity;", "Leditor/core/NicoActivity;", "()V", "assetsProvider", "Leditor/common/assetsprovider/AssetsProvider;", "getAssetsProvider", "()Leditor/common/assetsprovider/AssetsProvider;", "assetsProvider$delegate", "Lkotlin/Lazy;", "binding", "Lcom/memes/editor/databinding/NEditorEntrySelectionActivityBinding;", "getBinding", "()Lcom/memes/editor/databinding/NEditorEntrySelectionActivityBinding;", "binding$delegate", "draftsAdapter", "Leditor/editor/entry/drafts/EditorDraftEntriesAdapter;", "getDraftsAdapter", "()Leditor/editor/entry/drafts/EditorDraftEntriesAdapter;", "draftsAdapter$delegate", "draftsViewModel", "Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "getDraftsViewModel", "()Leditor/editor/dashboard/drafts/EditorDraftsViewModel;", "draftsViewModel$delegate", "frameSizeEntriesViewModel", "Leditor/editor/entry/framesizes/EntryFrameSizesViewModel;", "getFrameSizeEntriesViewModel", "()Leditor/editor/entry/framesizes/EntryFrameSizesViewModel;", "frameSizeEntriesViewModel$delegate", "onDraftSelectedListener", "editor/editor/entry/EditorEntrySelectionActivity$onDraftSelectedListener$1", "Leditor/editor/entry/EditorEntrySelectionActivity$onDraftSelectedListener$1;", "onFrameSizeSelectedListener", "Leditor/editor/entry/framesizes/EntryFrameSizesAdapter$Callback;", "onTemplateSelectedListener", "Leditor/optionsui/layout/templates/TemplatesAdapter$Callback;", "onWireframeSelectedListener", "Lkotlin/Function1;", "Lwireframe/language/Wireframe;", "", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "getOutputTargetGenerator", "()Lcom/memes/commons/output/OutputTargetGenerator;", "outputTargetGenerator$delegate", "templatesViewModel", "Leditor/optionsui/layout/templates/TemplatesViewModel;", "getTemplatesViewModel", "()Leditor/optionsui/layout/templates/TemplatesViewModel;", "templatesViewModel$delegate", "viewModel", "Leditor/editor/entry/EditorEntrySelectionViewModel;", "getViewModel", "()Leditor/editor/entry/EditorEntrySelectionViewModel;", "viewModel$delegate", "wireframesViewModel", "Leditor/optionsui/layout/wireframes/WireframesViewModel;", "getWireframesViewModel", "()Leditor/optionsui/layout/wireframes/WireframesViewModel;", "wireframesViewModel$delegate", "attachObservers", "initUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showDrafts", "drafts", "", "Leditor/editor/dashboard/drafts/EditorDraft;", "showFrameSizeInputSheet", "showFrameSizes", "frameSizes", "Leditor/optionsui/frame/frameresize/FrameSize;", "showTrendingTemplates", "templates", "Leditor/optionsui/layout/templates/Template;", "showWireframes", "items", "Leditor/optionsui/layout/wireframes/WireframeItem;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
public final class EditorEntrySelectionActivity extends NicoActivity {
    private final Lazy assetsProvider$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$assetsProvider$2(this));
    private final Lazy binding$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$binding$2(this));
    private final Lazy draftsAdapter$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$draftsAdapter$2(this));
    private final Lazy draftsViewModel$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$draftsViewModel$2(this));
    private final Lazy frameSizeEntriesViewModel$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$frameSizeEntriesViewModel$2(this));
    /* access modifiers changed from: private */
    public final EditorEntrySelectionActivity$onDraftSelectedListener$1 onDraftSelectedListener = new EditorEntrySelectionActivity$onDraftSelectedListener$1(this);
    private final EntryFrameSizesAdapter.Callback onFrameSizeSelectedListener = new EditorEntrySelectionActivity$onFrameSizeSelectedListener$1(this);
    /* access modifiers changed from: private */
    public final TemplatesAdapter.Callback onTemplateSelectedListener = new EditorEntrySelectionActivity$onTemplateSelectedListener$1(this);
    private final Function1<Wireframe, Unit> onWireframeSelectedListener = new EditorEntrySelectionActivity$onWireframeSelectedListener$1(this);
    private final Lazy outputTargetGenerator$delegate = LazyKt.lazy(EditorEntrySelectionActivity$outputTargetGenerator$2.INSTANCE);
    private final Lazy templatesViewModel$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$templatesViewModel$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$viewModel$2(this));
    private final Lazy wireframesViewModel$delegate = LazyKt.lazy(new EditorEntrySelectionActivity$wireframesViewModel$2(this));

    /* access modifiers changed from: private */
    public final AssetsProvider getAssetsProvider() {
        return (AssetsProvider) this.assetsProvider$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NEditorEntrySelectionActivityBinding getBinding() {
        return (NEditorEntrySelectionActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditorDraftEntriesAdapter getDraftsAdapter() {
        return (EditorDraftEntriesAdapter) this.draftsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditorDraftsViewModel getDraftsViewModel() {
        return (EditorDraftsViewModel) this.draftsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EntryFrameSizesViewModel getFrameSizeEntriesViewModel() {
        return (EntryFrameSizesViewModel) this.frameSizeEntriesViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final OutputTargetGenerator getOutputTargetGenerator() {
        return (OutputTargetGenerator) this.outputTargetGenerator$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TemplatesViewModel getTemplatesViewModel() {
        return (TemplatesViewModel) this.templatesViewModel$delegate.getValue();
    }

    private final EditorEntrySelectionViewModel getViewModel() {
        return (EditorEntrySelectionViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final WireframesViewModel getWireframesViewModel() {
        return (WireframesViewModel) this.wireframesViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NEditorEntrySelectionActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        initUi();
        attachObservers();
        QuickPermissionsOptions quickPermissionsOptions = new QuickPermissionsOptions(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
        quickPermissionsOptions.setPermissionsDeniedMethod(new EditorEntrySelectionActivity$onCreate$$inlined$apply$lambda$1(this));
        quickPermissionsOptions.setPermanentDeniedMethod(quickPermissionsOptions.getPermissionsDeniedMethod());
        Unit unit = Unit.INSTANCE;
        PermissionsManagerKt.runWithPermissions((Context) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, quickPermissionsOptions, (Function0<Unit>) EditorEntrySelectionActivity$onCreate$2.INSTANCE);
    }

    private final void initUi() {
        getBinding().backImageView.setOnClickListener(new EditorEntrySelectionActivity$initUi$1(this));
    }

    private final void attachObservers() {
        registerViewModel(getViewModel(), getTemplatesViewModel());
        LifecycleOwner lifecycleOwner = this;
        getFrameSizeEntriesViewModel().onFrameSizesAvailable().observe(lifecycleOwner, new EditorEntrySelectionActivity$attachObservers$1(this));
        getTemplatesViewModel().trendingTemplates().observe(lifecycleOwner, new EditorEntrySelectionActivity$attachObservers$2(this));
        getTemplatesViewModel().onTemplateDownloaded().observe(lifecycleOwner, new EditorEntrySelectionActivity$attachObservers$3(this));
        getWireframesViewModel().wireframeItems().observe(lifecycleOwner, new EditorEntrySelectionActivity$attachObservers$4(this));
        getDraftsViewModel().onDraftsFound().observe(lifecycleOwner, new EditorEntrySelectionActivity$attachObservers$5(this));
        getDraftsViewModel().onDraftDeleted().observe(lifecycleOwner, new EditorEntrySelectionActivity$attachObservers$6(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getDraftsViewModel().fetchDrafts();
    }

    /* access modifiers changed from: private */
    public final void showFrameSizes(List<FrameSize> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().frameSizesCategoryView, (String) null, new EditorEntrySelectionActivity$showFrameSizes$1(this), 1, (Object) null);
            return;
        }
        EntryFrameSizesAdapter entryFrameSizesAdapter = new EntryFrameSizesAdapter(this, this.onFrameSizeSelectedListener);
        entryFrameSizesAdapter.setItems(list);
        getBinding().frameSizesCategoryView.setAdapter(entryFrameSizesAdapter);
        getBinding().frameSizesCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showTrendingTemplates(List<Template> list) {
        if (list == null) {
            MediaCategoryView.showError$default(getBinding().templatesCategoryView, (String) null, new EditorEntrySelectionActivity$showTrendingTemplates$1(this), 1, (Object) null);
        } else if (list.isEmpty()) {
            getBinding().templatesCategoryView.hide();
        } else {
            getBinding().templatesCategoryView.show();
            TemplatesAdapter templatesAdapter = new TemplatesAdapter(this, new C4707x8189b51e(this));
            templatesAdapter.setItems(list);
            getBinding().templatesCategoryView.setAdapter(templatesAdapter);
            getBinding().templatesCategoryView.showContent();
        }
    }

    /* access modifiers changed from: private */
    public final void showWireframes(List<? extends WireframeItem> list) {
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            MediaCategoryView.showError$default(getBinding().wireframesCategoryView, (String) null, new EditorEntrySelectionActivity$showWireframes$1(this), 1, (Object) null);
            return;
        }
        WireframesAdapter wireframesAdapter = new WireframesAdapter(this, this.onWireframeSelectedListener);
        wireframesAdapter.setItems(list);
        getBinding().wireframesCategoryView.setAdapter(wireframesAdapter);
        getBinding().wireframesCategoryView.showContent();
    }

    /* access modifiers changed from: private */
    public final void showDrafts(List<EditorDraft> list) {
        if (list == null) {
            MediaCategoryView.showError$default(getBinding().draftsCategoryView, (String) null, new EditorEntrySelectionActivity$showDrafts$1(this), 1, (Object) null);
        } else if (list.isEmpty()) {
            getBinding().draftsCategoryView.hide();
        } else {
            getBinding().draftsCategoryView.show();
            getDraftsAdapter().setItems(list);
            getBinding().draftsCategoryView.setAdapter(getDraftsAdapter());
            getBinding().draftsCategoryView.showContent();
        }
    }

    /* access modifiers changed from: private */
    public final void showFrameSizeInputSheet() {
        CustomFrameSizeInputBottomSheet customFrameSizeInputBottomSheet = new CustomFrameSizeInputBottomSheet();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        customFrameSizeInputBottomSheet.show(supportFragmentManager, FrameSize.Companion.getDEFAULT_CUSTOM_FRAME_SIZE(), new EditorEntrySelectionActivity$showFrameSizeInputSheet$1(this));
    }
}
