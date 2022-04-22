package editor.mediaselection.localmedia;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.livinglifetechway.quickpermissions_kotlin.PermissionsManagerKt;
import com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions;
import com.memes.editor.databinding.NLocalMediaFragmentBinding;
import editor.mediaselection.BaseMediaCategoryAdapter;
import editor.mediaselection.MediaSelectionFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\u001a\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010)\u001a\u00020\u001b2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, mo26107d2 = {"Leditor/mediaselection/localmedia/LocalMediaFragment;", "Leditor/mediaselection/MediaSelectionFragment;", "()V", "binding", "Lcom/memes/editor/databinding/NLocalMediaFragmentBinding;", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "liteMediaSelectionViewModel", "Leditor/mediaselection/localmedia/LocalMediaViewModel;", "getLiteMediaSelectionViewModel", "()Leditor/mediaselection/localmedia/LocalMediaViewModel;", "liteMediaSelectionViewModel$delegate", "localMediaAdapter", "Leditor/mediaselection/localmedia/LocalMediaAdapter;", "getLocalMediaAdapter", "()Leditor/mediaselection/localmedia/LocalMediaAdapter;", "localMediaAdapter$delegate", "localMediaSelectedListener", "Leditor/mediaselection/localmedia/OnLocalMediaSelectedListener;", "selectedItemIds", "", "", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setSelectedItemIds", "itemIds", "", "tag", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LocalMediaFragment.kt */
public final class LocalMediaFragment extends MediaSelectionFragment {
    /* access modifiers changed from: private */
    public NLocalMediaFragmentBinding binding;
    private final Lazy layoutManager$delegate = LazyKt.lazy(LocalMediaFragment$layoutManager$2.INSTANCE);
    private final Lazy liteMediaSelectionViewModel$delegate = LazyKt.lazy(new LocalMediaFragment$liteMediaSelectionViewModel$2(this));
    private final Lazy localMediaAdapter$delegate = LazyKt.lazy(new LocalMediaFragment$localMediaAdapter$2(this));
    /* access modifiers changed from: private */
    public OnLocalMediaSelectedListener localMediaSelectedListener;
    private final List<String> selectedItemIds = new ArrayList();

    private final StaggeredGridLayoutManager getLayoutManager() {
        return (StaggeredGridLayoutManager) this.layoutManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LocalMediaViewModel getLiteMediaSelectionViewModel() {
        return (LocalMediaViewModel) this.liteMediaSelectionViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LocalMediaAdapter getLocalMediaAdapter() {
        return (LocalMediaAdapter) this.localMediaAdapter$delegate.getValue();
    }

    public String tag() {
        return "local-media-fragment";
    }

    public static final /* synthetic */ NLocalMediaFragmentBinding access$getBinding$p(LocalMediaFragment localMediaFragment) {
        NLocalMediaFragmentBinding nLocalMediaFragmentBinding = localMediaFragment.binding;
        if (nLocalMediaFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return nLocalMediaFragmentBinding;
    }

    public static final /* synthetic */ OnLocalMediaSelectedListener access$getLocalMediaSelectedListener$p(LocalMediaFragment localMediaFragment) {
        OnLocalMediaSelectedListener onLocalMediaSelectedListener = localMediaFragment.localMediaSelectedListener;
        if (onLocalMediaSelectedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localMediaSelectedListener");
        }
        return onLocalMediaSelectedListener;
    }

    public void setSelectedItemIds(List<String> list) {
        this.selectedItemIds.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            this.selectedItemIds.addAll(collection);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.binding != null) {
            NLocalMediaFragmentBinding nLocalMediaFragmentBinding = this.binding;
            if (nLocalMediaFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout root = nLocalMediaFragmentBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
        NLocalMediaFragmentBinding inflate = NLocalMediaFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NLocalMediaFragmentBindi…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout root2 = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return root2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        getActivityHandle().registerViewModel(getLiteMediaSelectionViewModel());
        NLocalMediaFragmentBinding nLocalMediaFragmentBinding = this.binding;
        if (nLocalMediaFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        nLocalMediaFragmentBinding.contentLayout.setCallback(this);
        NLocalMediaFragmentBinding nLocalMediaFragmentBinding2 = this.binding;
        if (nLocalMediaFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = nLocalMediaFragmentBinding2.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(getLayoutManager());
        NLocalMediaFragmentBinding nLocalMediaFragmentBinding3 = this.binding;
        if (nLocalMediaFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = nLocalMediaFragmentBinding3.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setAdapter(getLocalMediaAdapter());
        BaseMediaCategoryAdapter.setSelectedItemIds$default(getLocalMediaAdapter(), this.selectedItemIds, false, 2, (Object) null);
        QuickPermissionsOptions quickPermissionsOptions = new QuickPermissionsOptions(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
        quickPermissionsOptions.setPermissionsDeniedMethod(new LocalMediaFragment$onViewCreated$$inlined$apply$lambda$1(this));
        quickPermissionsOptions.setPermanentDeniedMethod(quickPermissionsOptions.getPermissionsDeniedMethod());
        PermissionsManagerKt.runWithPermissions((Fragment) this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, quickPermissionsOptions, (Function0<Unit>) new LocalMediaFragment$onViewCreated$1(this));
        getLiteMediaSelectionViewModel().onGetResultsLiveData().observe(getViewLifecycleOwner(), new LocalMediaFragment$onViewCreated$2(this));
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.localMediaSelectedListener = (OnLocalMediaSelectedListener) context;
        super.onAttach(context);
    }

    public void onDestroyView() {
        if (this.binding != null) {
            NLocalMediaFragmentBinding nLocalMediaFragmentBinding = this.binding;
            if (nLocalMediaFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            nLocalMediaFragmentBinding.recyclerView.clearOnScrollListeners();
        }
        super.onDestroyView();
    }
}
