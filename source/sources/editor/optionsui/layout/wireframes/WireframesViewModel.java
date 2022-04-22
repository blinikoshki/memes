package editor.optionsui.layout.wireframes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import editor.editor.equipment.property.NicoPropertyBundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\nJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0018J\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_selectedWireframeId", "Landroidx/lifecycle/MutableLiveData;", "", "_wireframeItems", "", "Leditor/optionsui/layout/wireframes/WireframeItem;", "_wireframeSelected", "Lwireframe/language/Wireframe;", "_wireframes", "loadedWireframes", "", "propertyBundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "wireframeProvider", "Leditor/optionsui/layout/wireframes/WireframeProvider;", "getWireframeById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWireframes", "", "onWireframeSelected", "Landroidx/lifecycle/LiveData;", "selectWireframe", "wireframe", "selectedWireframeId", "setStyle", "token", "wireframeItems", "wireframes", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WireframesViewModel.kt */
public final class WireframesViewModel extends ViewModel {
    private final MutableLiveData<String> _selectedWireframeId = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<WireframeItem>> _wireframeItems = new MutableLiveData<>();
    private final MutableLiveData<Wireframe> _wireframeSelected = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<Wireframe>> _wireframes = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final List<Wireframe> loadedWireframes = new ArrayList();
    private NicoPropertyBundle propertyBundle;
    /* access modifiers changed from: private */
    public final WireframeProvider wireframeProvider = new WireframeProvider();

    public WireframesViewModel() {
        loadWireframes();
    }

    public final LiveData<List<WireframeItem>> wireframeItems() {
        return this._wireframeItems;
    }

    public final LiveData<List<Wireframe>> wireframes() {
        return this._wireframes;
    }

    public final LiveData<String> selectedWireframeId() {
        return this._selectedWireframeId;
    }

    public final LiveData<Wireframe> onWireframeSelected() {
        return this._wireframeSelected;
    }

    public final void loadWireframes() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WireframesViewModel$loadWireframes$1(this, (Continuation) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v3 java.lang.Object), (r10v1 java.lang.Object) binds: [B:21:0x0067, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getWireframeById(java.lang.String r9, kotlin.coroutines.Continuation<? super wireframe.language.Wireframe> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof editor.optionsui.layout.wireframes.WireframesViewModel$getWireframeById$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            editor.optionsui.layout.wireframes.WireframesViewModel$getWireframeById$1 r0 = (editor.optionsui.layout.wireframes.WireframesViewModel$getWireframeById$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            editor.optionsui.layout.wireframes.WireframesViewModel$getWireframeById$1 r0 = new editor.optionsui.layout.wireframes.WireframesViewModel$getWireframeById$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006a
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            editor.optionsui.layout.wireframes.WireframesViewModel r2 = (editor.optionsui.layout.wireframes.WireframesViewModel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005d
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.List<wireframe.language.Wireframe> r10 = r8.loadedWireframes
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x006b
            r6 = 250(0xfa, double:1.235E-321)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r10 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r2 = r8
        L_0x005d:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r10 = r2.getWireframeById(r9, r0)
            if (r10 != r1) goto L_0x006a
            return r1
        L_0x006a:
            return r10
        L_0x006b:
            java.util.List<wireframe.language.Wireframe> r10 = r8.loadedWireframes
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0073:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0093
            java.lang.Object r0 = r10.next()
            r1 = r0
            wireframe.language.Wireframe r1 = (wireframe.language.Wireframe) r1
            java.lang.String r1 = r1.getId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0073
            r5 = r0
        L_0x0093:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.optionsui.layout.wireframes.WireframesViewModel.getWireframeById(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setStyle(String str, Wireframe wireframe2) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "token");
        this.propertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
        MutableLiveData<String> mutableLiveData = this._selectedWireframeId;
        if (wireframe2 == null || (str2 = wireframe2.getId()) == null) {
            str2 = Wireframe.Companion.getDEFAULT().getId();
        }
        mutableLiveData.setValue(str2);
    }

    public final void selectWireframe(Wireframe wireframe2) {
        Intrinsics.checkNotNullParameter(wireframe2, "wireframe");
        this._selectedWireframeId.setValue(wireframe2.getId());
        this._wireframeSelected.setValue(wireframe2);
    }
}
