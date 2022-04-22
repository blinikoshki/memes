package editor.optionsui.text.textfont;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import editor.custom.liveevent.LiveEvent;
import editor.database.dao.RecentFontsDao;
import editor.editor.equipment.text.TextStyle;
import editor.editor.plan.EditorPlan;
import editor.editor.plan.EditorPlanRequirement;
import editor.optionsui.OnEditorPlanRequestedListener;
import editor.optionsui.OnPropertyUpdatedListener;
import editor.optionsui.text.textfont.FontItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0015\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0011H\u0002J\u0006\u0010'\u001a\u00020\u001fJ\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0)J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0)J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110)J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130)J\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130)J\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130)J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170)J\u0010\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020!H\u0002J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00192\b\u00107\u001a\u0004\u0018\u000108J\u000e\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001bJ\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001dJ\u0016\u0010<\u001a\u00020\u001f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020!0\u000eH\u0002J\u000e\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u0006B"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsViewModel;", "Landroidx/lifecycle/ViewModel;", "fontsDao", "Leditor/database/dao/RecentFontsDao;", "fontsProvider", "Leditor/optionsui/text/textfont/TextFontsProvider;", "(Leditor/database/dao/RecentFontsDao;Leditor/optionsui/text/textfont/TextFontsProvider;)V", "_createdFontCategories", "", "Leditor/optionsui/text/textfont/TextFontCategory;", "_createdFontItems", "Leditor/optionsui/text/textfont/FontItem;", "_fontCategories", "Landroidx/lifecycle/MutableLiveData;", "", "_fontItems", "_localTextFontSelected", "", "_newRecentFontItemAdded", "Leditor/custom/liveevent/LiveEvent;", "_recentFontCategoryAdded", "_recentFontItemRemoved", "_showFontsOnPosition", "", "editorPlan", "Leditor/editor/plan/EditorPlan;", "editorPlanRequestedListener", "Leditor/optionsui/OnEditorPlanRequestedListener;", "propertyUpdateListener", "Leditor/optionsui/OnPropertyUpdatedListener;", "changeSelectedFont", "", "font", "Leditor/optionsui/text/textfont/TextFont;", "changeSelectedFontCategoryPosition", "position", "(Ljava/lang/Integer;)V", "deleteRecentFont", "fontId", "fetchFonts", "fontCategories", "Landroidx/lifecycle/LiveData;", "fontItems", "getOrCreateFontCategories", "items", "getOrCreateFontItems", "onLocalTextFontSelected", "onNewRecentFontItemAdded", "onRecentFontCategoryAdded", "onRecentFontItemRemoved", "onShowFontsOnPosition", "saveRecentFont", "textFont", "setEditorPlan", "newPlan", "satisfiedRequirement", "Leditor/editor/plan/EditorPlanRequirement;", "setOnEditorPlanRequestedListener", "listener", "setOnPropertyUpdatedListener", "setRecentFonts", "recentFonts", "setStyle", "style", "Leditor/editor/equipment/text/TextStyle;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsViewModel.kt */
public final class TextFontsViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_RECENT_FONTS = 6;
    private List<TextFontCategory> _createdFontCategories = new ArrayList();
    private List<FontItem> _createdFontItems = new ArrayList();
    private final MutableLiveData<List<TextFontCategory>> _fontCategories = new MutableLiveData<>();
    private final MutableLiveData<List<FontItem>> _fontItems = new MutableLiveData<>();
    private final MutableLiveData<String> _localTextFontSelected = new MutableLiveData<>();
    private final MutableLiveData<LiveEvent<FontItem>> _newRecentFontItemAdded = new MutableLiveData<>();
    private final MutableLiveData<LiveEvent<TextFontCategory>> _recentFontCategoryAdded = new MutableLiveData<>();
    private final MutableLiveData<LiveEvent<FontItem>> _recentFontItemRemoved = new MutableLiveData<>();
    private final MutableLiveData<Integer> _showFontsOnPosition = new MutableLiveData<>();
    private final EditorPlan editorPlan = EditorPlan.Companion.rookie();
    private OnEditorPlanRequestedListener editorPlanRequestedListener;
    /* access modifiers changed from: private */
    public final RecentFontsDao fontsDao;
    private final TextFontsProvider fontsProvider;
    private OnPropertyUpdatedListener propertyUpdateListener;

    public TextFontsViewModel(RecentFontsDao recentFontsDao, TextFontsProvider textFontsProvider) {
        Intrinsics.checkNotNullParameter(recentFontsDao, "fontsDao");
        Intrinsics.checkNotNullParameter(textFontsProvider, "fontsProvider");
        this.fontsDao = recentFontsDao;
        this.fontsProvider = textFontsProvider;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C48861(this, (Continuation) null), 3, (Object) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsViewModel$Companion;", "", "()V", "MAX_RECENT_FONTS", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextFontsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final LiveData<String> onLocalTextFontSelected() {
        return this._localTextFontSelected;
    }

    public final LiveData<List<FontItem>> fontItems() {
        return this._fontItems;
    }

    public final LiveData<LiveEvent<FontItem>> onNewRecentFontItemAdded() {
        return this._newRecentFontItemAdded;
    }

    public final LiveData<LiveEvent<FontItem>> onRecentFontItemRemoved() {
        return this._recentFontItemRemoved;
    }

    public final LiveData<LiveEvent<TextFontCategory>> onRecentFontCategoryAdded() {
        return this._recentFontCategoryAdded;
    }

    public final LiveData<Integer> onShowFontsOnPosition() {
        return this._showFontsOnPosition;
    }

    public final LiveData<List<TextFontCategory>> fontCategories() {
        return this._fontCategories;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "editor.optionsui.text.textfont.TextFontsViewModel$1", mo26808f = "TextFontsViewModel.kt", mo26809i = {}, mo26810l = {65}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: editor.optionsui.text.textfont.TextFontsViewModel$1 */
    /* compiled from: TextFontsViewModel.kt */
    static final class C48861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TextFontsViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C48861(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C48861) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new TextFontsViewModel$1$recentFonts$1(this, (Continuation) null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.this$0.setRecentFonts((List) obj);
            return Unit.INSTANCE;
        }
    }

    public final void setStyle(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this._localTextFontSelected.setValue(textStyle.getFont().getId());
    }

    public final void setOnPropertyUpdatedListener(OnPropertyUpdatedListener onPropertyUpdatedListener) {
        Intrinsics.checkNotNullParameter(onPropertyUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.propertyUpdateListener = onPropertyUpdatedListener;
    }

    public final void setOnEditorPlanRequestedListener(OnEditorPlanRequestedListener onEditorPlanRequestedListener) {
        Intrinsics.checkNotNullParameter(onEditorPlanRequestedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.editorPlanRequestedListener = onEditorPlanRequestedListener;
    }

    public final void setEditorPlan(EditorPlan editorPlan2, EditorPlanRequirement editorPlanRequirement) {
        Intrinsics.checkNotNullParameter(editorPlan2, "newPlan");
        this.editorPlan.updateBy(editorPlan2);
        if ((editorPlanRequirement instanceof EditorPlanRequirement.OfTextFont) && editorPlanRequirement.isNotExpired() && this.editorPlan.ofType(editorPlanRequirement.getRequiredPlanType())) {
            changeSelectedFont(((EditorPlanRequirement.OfTextFont) editorPlanRequirement).getFont());
            editorPlanRequirement.expire();
        }
    }

    /* access modifiers changed from: private */
    public final void setRecentFonts(List<TextFont> list) {
        if (!list.isEmpty()) {
            FontItem.Divider divider = new FontItem.Divider(TextFontCategory.RECENT.name(), TextFontCategory.DEFAULT.name());
            getOrCreateFontItems().add(0, divider);
            this._newRecentFontItemAdded.setValue(new LiveEvent(divider));
            getOrCreateFontCategories$default(this, (List) null, 1, (Object) null).add(0, TextFontCategory.RECENT);
            this._recentFontCategoryAdded.setValue(new LiveEvent(TextFontCategory.RECENT));
            for (TextFont preview : list) {
                FontItem.Preview preview2 = new FontItem.Preview(TextFontCategory.RECENT.name(), preview);
                getOrCreateFontItems().add(0, preview2);
                this._newRecentFontItemAdded.setValue(new LiveEvent(preview2));
            }
        }
    }

    public final void fetchFonts() {
        this._fontItems.setValue(getOrCreateFontItems());
        this._fontCategories.setValue(getOrCreateFontCategories$default(this, (List) null, 1, (Object) null));
    }

    private final List<FontItem> getOrCreateFontItems() {
        if (!this._createdFontItems.isEmpty()) {
            return this._createdFontItems;
        }
        List<TextFont> allFonts = this.fontsProvider.allFonts();
        List<FontItem> arrayList = new ArrayList<>();
        String name = TextFontCategory.RECENT.name();
        int i = 0;
        for (TextFont next : allFonts) {
            String type = next.getType();
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
            Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.String");
            String upperCase = type.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            if (!Intrinsics.areEqual((Object) name, (Object) upperCase)) {
                if (i != 0) {
                    if (i % 2 != 0) {
                        arrayList.add(new FontItem.Placeholder(upperCase));
                    }
                    arrayList.add(new FontItem.Divider(name, upperCase));
                }
                name = upperCase;
                i = 0;
            }
            i++;
            arrayList.add(new FontItem.Preview(upperCase, next));
        }
        this._createdFontItems = arrayList;
        return arrayList;
    }

    static /* synthetic */ List getOrCreateFontCategories$default(TextFontsViewModel textFontsViewModel, List<FontItem> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = textFontsViewModel.getOrCreateFontItems();
        }
        return textFontsViewModel.getOrCreateFontCategories(list);
    }

    private final List<TextFontCategory> getOrCreateFontCategories(List<? extends FontItem> list) {
        if (!this._createdFontCategories.isEmpty()) {
            return this._createdFontCategories;
        }
        List<TextFontCategory> arrayList = new ArrayList<>();
        String str = "";
        for (FontItem fontItem : list) {
            if (fontItem instanceof FontItem.Preview) {
                FontItem.Preview preview = (FontItem.Preview) fontItem;
                if (!Intrinsics.areEqual((Object) preview.getFontType(), (Object) str)) {
                    str = preview.getFontType();
                    String fontType = preview.getFontType();
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                    Objects.requireNonNull(fontType, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = fontType.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    arrayList.add(TextFontCategory.valueOf(upperCase));
                }
            }
        }
        this._createdFontCategories = arrayList;
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0101 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void changeSelectedFont(editor.optionsui.text.textfont.TextFont r7) {
        /*
            r6 = this;
            java.lang.String r0 = "font"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            editor.editor.plan.EditorPlan r0 = r6.editorPlan
            boolean r0 = r0.isPremium()
            if (r0 != 0) goto L_0x0027
            boolean r0 = r7.isPremiumFont()
            if (r0 == 0) goto L_0x0027
            editor.editor.plan.EditorPlanRequirement$OfTextFont r0 = new editor.editor.plan.EditorPlanRequirement$OfTextFont
            r0.<init>(r7)
            editor.optionsui.OnEditorPlanRequestedListener r7 = r6.editorPlanRequestedListener
            if (r7 != 0) goto L_0x0021
            java.lang.String r1 = "editorPlanRequestedListener"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0021:
            editor.editor.plan.EditorPlanRequirement r0 = (editor.editor.plan.EditorPlanRequirement) r0
            r7.onEditorPlanRequested(r0)
            return
        L_0x0027:
            androidx.lifecycle.MutableLiveData<java.lang.String> r0 = r6._localTextFontSelected
            java.lang.String r1 = r7.getId()
            r0.setValue(r1)
            editor.editor.equipment.property.TextProperty$Font r0 = new editor.editor.equipment.property.TextProperty$Font
            r0.<init>(r7)
            editor.optionsui.OnPropertyUpdatedListener r1 = r6.propertyUpdateListener
            if (r1 != 0) goto L_0x003e
            java.lang.String r2 = "propertyUpdateListener"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x003e:
            editor.editor.equipment.property.NicoProperty r0 = (editor.editor.equipment.property.NicoProperty) r0
            r1.onPropertyUpdated(r0)
            editor.optionsui.text.textfont.TextFontCategory r0 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            java.lang.String r1 = r7.getType()
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L_0x0050
            return
        L_0x0050:
            java.util.List r0 = r6.getOrCreateFontItems()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0061:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0073
            java.lang.Object r2 = r0.next()
            boolean r3 = r2 instanceof editor.optionsui.text.textfont.FontItem.Preview
            if (r3 == 0) goto L_0x0061
            r1.add(r2)
            goto L_0x0061
        L_0x0073:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r1.iterator()
        L_0x0082:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x009f
            java.lang.Object r2 = r1.next()
            r3 = r2
            editor.optionsui.text.textfont.FontItem$Preview r3 = (editor.optionsui.text.textfont.FontItem.Preview) r3
            editor.optionsui.text.textfont.TextFontCategory r4 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            java.lang.String r3 = r3.getFontType()
            boolean r3 = r4.matches(r3)
            if (r3 == 0) goto L_0x0082
            r0.add(r2)
            goto L_0x0082
        L_0x009f:
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x00ca
            editor.optionsui.text.textfont.FontItem$Divider r1 = new editor.optionsui.text.textfont.FontItem$Divider
            editor.optionsui.text.textfont.TextFontCategory r3 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            java.lang.String r3 = r3.name()
            editor.optionsui.text.textfont.TextFontCategory r4 = editor.optionsui.text.textfont.TextFontCategory.DEFAULT
            java.lang.String r4 = r4.name()
            r1.<init>(r3, r4)
            java.util.List r3 = r6.getOrCreateFontItems()
            r3.add(r2, r1)
            androidx.lifecycle.MutableLiveData<editor.custom.liveevent.LiveEvent<editor.optionsui.text.textfont.FontItem>> r3 = r6._newRecentFontItemAdded
            editor.custom.liveevent.LiveEvent r4 = new editor.custom.liveevent.LiveEvent
            r4.<init>(r1)
            r3.setValue(r4)
        L_0x00ca:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r3 = 1
            if (r1 == 0) goto L_0x00dc
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00dc
        L_0x00da:
            r0 = 0
            goto L_0x00ff
        L_0x00dc:
            java.util.Iterator r0 = r0.iterator()
        L_0x00e0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00da
            java.lang.Object r1 = r0.next()
            editor.optionsui.text.textfont.FontItem$Preview r1 = (editor.optionsui.text.textfont.FontItem.Preview) r1
            editor.optionsui.text.textfont.TextFont r1 = r1.getTextFont()
            java.lang.String r1 = r1.getId()
            java.lang.String r4 = r7.getId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x00e0
            r0 = 1
        L_0x00ff:
            if (r0 == 0) goto L_0x0102
            return
        L_0x0102:
            editor.optionsui.text.textfont.FontItem$Preview r0 = new editor.optionsui.text.textfont.FontItem$Preview
            editor.optionsui.text.textfont.TextFontCategory r1 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            java.lang.String r1 = r1.name()
            r0.<init>(r1, r7)
            java.util.List r7 = r6.getOrCreateFontItems()
            r7.add(r2, r0)
            androidx.lifecycle.MutableLiveData<editor.custom.liveevent.LiveEvent<editor.optionsui.text.textfont.FontItem>> r7 = r6._newRecentFontItemAdded
            editor.custom.liveevent.LiveEvent r1 = new editor.custom.liveevent.LiveEvent
            r1.<init>(r0)
            r7.setValue(r1)
            editor.optionsui.text.textfont.TextFont r7 = r0.getTextFont()
            r6.saveRecentFont(r7)
            r7 = 0
            java.util.List r0 = getOrCreateFontCategories$default(r6, r7, r3, r7)
            editor.optionsui.text.textfont.TextFontCategory r1 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0147
            java.util.List r7 = getOrCreateFontCategories$default(r6, r7, r3, r7)
            editor.optionsui.text.textfont.TextFontCategory r0 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            r7.add(r2, r0)
            androidx.lifecycle.MutableLiveData<editor.custom.liveevent.LiveEvent<editor.optionsui.text.textfont.TextFontCategory>> r7 = r6._recentFontCategoryAdded
            editor.custom.liveevent.LiveEvent r0 = new editor.custom.liveevent.LiveEvent
            editor.optionsui.text.textfont.TextFontCategory r1 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            r0.<init>(r1)
            r7.setValue(r0)
        L_0x0147:
            java.util.List r7 = r6.getOrCreateFontItems()
            int r0 = r7.size()
        L_0x014f:
            if (r2 >= r0) goto L_0x018d
            java.lang.Object r1 = r7.get(r2)
            editor.optionsui.text.textfont.FontItem r1 = (editor.optionsui.text.textfont.FontItem) r1
            boolean r3 = r1 instanceof editor.optionsui.text.textfont.FontItem.Preview
            if (r3 != 0) goto L_0x015c
            goto L_0x018a
        L_0x015c:
            r3 = 6
            if (r2 < r3) goto L_0x018a
            editor.optionsui.text.textfont.TextFontCategory r3 = editor.optionsui.text.textfont.TextFontCategory.RECENT
            r4 = r1
            editor.optionsui.text.textfont.FontItem$Preview r4 = (editor.optionsui.text.textfont.FontItem.Preview) r4
            java.lang.String r5 = r4.getFontType()
            boolean r3 = r3.matches(r5)
            if (r3 == 0) goto L_0x018d
            java.util.List r3 = r6.getOrCreateFontItems()
            r3.remove(r1)
            editor.optionsui.text.textfont.TextFont r3 = r4.getTextFont()
            java.lang.String r3 = r3.getId()
            r6.deleteRecentFont(r3)
            androidx.lifecycle.MutableLiveData<editor.custom.liveevent.LiveEvent<editor.optionsui.text.textfont.FontItem>> r3 = r6._recentFontItemRemoved
            editor.custom.liveevent.LiveEvent r4 = new editor.custom.liveevent.LiveEvent
            r4.<init>(r1)
            r3.setValue(r4)
        L_0x018a:
            int r2 = r2 + 1
            goto L_0x014f
        L_0x018d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.optionsui.text.textfont.TextFontsViewModel.changeSelectedFont(editor.optionsui.text.textfont.TextFont):void");
    }

    public final void changeSelectedFontCategoryPosition(Integer num) {
        if (num != null) {
            TextFontCategory textFontCategory = (TextFontCategory) getOrCreateFontCategories$default(this, (List) null, 1, (Object) null).get(num.intValue());
            int i = 0;
            for (FontItem fontItem : getOrCreateFontItems()) {
                if (!(fontItem instanceof FontItem.Preview) || !textFontCategory.matches(((FontItem.Preview) fontItem).getFontType())) {
                    i++;
                } else {
                    this._showFontsOnPosition.setValue(Integer.valueOf(i));
                    return;
                }
            }
        }
    }

    private final void saveRecentFont(TextFont textFont) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new TextFontsViewModel$saveRecentFont$1(this, textFont, (Continuation) null), 2, (Object) null);
    }

    private final void deleteRecentFont(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), (CoroutineStart) null, new TextFontsViewModel$deleteRecentFont$1(this, str, (Continuation) null), 2, (Object) null);
    }
}
