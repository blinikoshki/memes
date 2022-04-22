package editor.editor.editorframehost.frame;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.imagepipeline.common.RotationOptions;
import com.memes.editor.C4175R;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.editorframehost.EditorEntityManager;
import editor.editor.editorframehost.gesture.ViewTouchCallback;
import editor.editor.editorframehost.gesture.ViewTouchListener;
import editor.editor.editorframehost.selection.NicoLayerSelectionListener;
import editor.editor.editorframehost.selection.NicoLayerSelectionView;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.core.CoreLayer;
import editor.editor.equipment.core.CoreStyle;
import editor.editor.equipment.frame.FrameEntity;
import editor.editor.equipment.frame.FrameLayer;
import editor.editor.equipment.frame.FrameLayerView;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.property.OnNPropertyAppliedListener;
import editor.editor.equipment.text.TextEntity;
import editor.editor.equipment.text.TextStyle;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import editor.tools.wftransformer.WireframeTransformer;
import editor.util.ColorUtil;
import editor.util.ExtKt;
import editor.util.ViewToPathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.apache.commons.lang3.ClassUtils;
import timber.log.Timber;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010*\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020.J\u0012\u0010/\u001a\u00020+2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J,\u00100\u001a\u00020+2\u0012\u00101\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u00112\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0018H\u0002J\u0010\u00104\u001a\u00020+2\b\u0010&\u001a\u0004\u0018\u00010'J\b\u00105\u001a\u00020+H\u0002J\u001c\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020;H\u0002J\u001c\u0010<\u001a\u00020=2\b\b\u0002\u00108\u001a\u00020>2\b\b\u0002\u0010:\u001a\u00020;H\u0002J\u0014\u0010?\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u0011H\u0002J\u0010\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u001a\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u00110DH\u0016J\b\u0010E\u001a\u00020\u0016H\u0016J\u0010\u0010F\u001a\u0002072\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010G\u001a\u00020=2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KH\u0002J\u0014\u0010L\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u0011H\u0016J\b\u0010M\u001a\u0004\u0018\u00010'J\u0012\u0010N\u001a\u00020;2\b\u0010A\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010O\u001a\u00020+2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u001c\u0010P\u001a\u00020+2\u0012\u00101\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u0011H\u0002J\b\u0010Q\u001a\u00020+H\u0002J\u000e\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\u0018J0\u0010T\u001a\u00020+2\u0016\u00101\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020VH\u0016J\b\u0010X\u001a\u00020+H\u0014J$\u0010Y\u001a\u00020+2\u0012\u00101\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u00112\u0006\u0010Z\u001a\u00020[H\u0016J\u0018\u0010\\\u001a\u00020+2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010^\u001a\u00020+2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010_\u001a\u00020+2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010`\u001a\u00020+2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KH\u0016J \u0010a\u001a\u00020+2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020K2\u0006\u0010b\u001a\u00020;H\u0016J\u0006\u0010c\u001a\u00020+J\u0006\u0010d\u001a\u00020+J \u0010e\u001a\u00020+2\u0016\u00101\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016J(\u0010f\u001a\u00020+2\u0006\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u0018H\u0014J\u001c\u0010k\u001a\u00020;2\u0012\u00101\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u0011H\u0002J\b\u0010l\u001a\u00020+H\u0002J\u000e\u0010m\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010n\u001a\u00020+J\u0010\u0010o\u001a\u00020+2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010p\u001a\u00020+2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020+2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010t\u001a\u00020+2\u0006\u0010q\u001a\u00020rH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000RB\u0010\r\u001a6\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u00110\u000ej\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010j\u0002`\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, mo26107d2 = {"Leditor/editor/editorframehost/frame/EditorFrame;", "Leditor/editor/equipment/frame/FrameLayerView;", "Leditor/editor/editorframehost/EditorEntityManager;", "Leditor/editor/editorframehost/gesture/ViewTouchCallback;", "Leditor/editor/equipment/property/OnNPropertyAppliedListener;", "Leditor/editor/editorframehost/selection/NicoLayerSelectionListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "entities", "Ljava/util/HashMap;", "", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "Lkotlin/collections/HashMap;", "frameCallback", "Leditor/editor/editorframehost/frame/EditorFrameCallback;", "frameEntity", "Leditor/editor/equipment/frame/FrameEntity;", "lastFrameHeight", "", "lastFrameWidth", "selectionView", "Leditor/editor/editorframehost/selection/NicoLayerSelectionView;", "kotlin.jvm.PlatformType", "getSelectionView", "()Leditor/editor/editorframehost/selection/NicoLayerSelectionView;", "selectionView$delegate", "Lkotlin/Lazy;", "sizeChangesRateLimitingHandler", "Landroid/os/Handler;", "viewToPathUtils", "Leditor/util/ViewToPathUtils;", "watermarkEntity", "wireframe", "Lwireframe/language/Wireframe;", "wireframeTransformer", "Leditor/tools/wftransformer/WireframeTransformer;", "apply", "", "watermark", "Leditor/optionsui/watermark/PhotoWatermark;", "Leditor/optionsui/watermark/TextWatermark;", "applyDraft", "applyMetadata", "entity", "frameWidth", "frameHeight", "applyWireframe", "createInitialSampleEntities", "createMediaEntity", "Leditor/editor/equipment/media/MediaEntity;", "style", "Leditor/editor/equipment/media/MediaStyle;", "moveToCenter", "", "createTextEntity", "Leditor/editor/equipment/text/TextEntity;", "Leditor/editor/equipment/text/TextStyle;", "createWatermarkEntity", "deleteEntity", "token", "duplicateEntity", "getEntities", "", "getFrameEntity", "getMediaEntity", "getTextEntity", "getViewTouchListener", "Leditor/editor/editorframehost/gesture/ViewTouchListener;", "view", "Landroid/view/View;", "getWatermarkEntity", "getWireframe", "hasEntity", "hideEntity", "moveEntityToCenter", "notifyEntityVisibilityCountChanged", "notifyVisiblePanelCountChanged", "count", "onEntityResized", "displacementX", "", "displacementY", "onFinishInflate", "onNPropertyApplied", "property", "Leditor/editor/equipment/property/NicoProperty;", "onOverlayViewDragStarted", "identifier", "onOverlayViewDragStopped", "onOverlayViewDragging", "onOverlayViewLongPressed", "onOverlayViewTapped", "isDoubleTap", "onPause", "onResume", "onSaveAsWatermarkTapped", "onSizeChanged", "w", "h", "oldw", "oldh", "relocateEntityIfOutOfBounds", "resetAutoRearrange", "setTouchCallback", "showAllEntities", "showEntity", "updateEntity", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "updateMediaEntity", "updateTextEntity", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
public final class EditorFrame extends FrameLayerView implements EditorEntityManager, ViewTouchCallback, OnNPropertyAppliedListener, NicoLayerSelectionListener {
    /* access modifiers changed from: private */
    public EditorDraft draft;
    /* access modifiers changed from: private */
    public final HashMap<String, CoreEntity<?, ?>> entities = new HashMap<>();
    private EditorFrameCallback frameCallback;
    private final FrameEntity frameEntity;
    /* access modifiers changed from: private */
    public int lastFrameHeight;
    /* access modifiers changed from: private */
    public int lastFrameWidth;
    private final Lazy selectionView$delegate = LazyKt.lazy(new EditorFrame$selectionView$2(this));
    private final Handler sizeChangesRateLimitingHandler = new Handler();
    private final ViewToPathUtils viewToPathUtils = new ViewToPathUtils();
    private CoreEntity<?, ?> watermarkEntity;
    /* access modifiers changed from: private */

    /* renamed from: wireframe  reason: collision with root package name */
    public Wireframe f1536wireframe;
    private final WireframeTransformer wireframeTransformer = new WireframeTransformer(this);

    private final NicoLayerSelectionView getSelectionView() {
        return (NicoLayerSelectionView) this.selectionView$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        setResizeMode(1);
        this.frameEntity = new FrameEntity(new FrameLayer(this), (FrameStyle) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.watermarkEntity = createWatermarkEntity();
    }

    public final void setTouchCallback(EditorFrameCallback editorFrameCallback) {
        Intrinsics.checkNotNullParameter(editorFrameCallback, "frameCallback");
        this.frameCallback = editorFrameCallback;
    }

    private final void createInitialSampleEntities() {
        for (int i = 0; i < 2; i++) {
            TextStyle textStyle = new TextStyle();
            StringBuilder sb = new StringBuilder();
            sb.append(Random.Default.nextLong());
            sb.append(10);
            sb.append(Random.Default.nextLong());
            textStyle.setText(sb.toString());
            textStyle.setRotation((float) Random.Default.nextInt(-180, RotationOptions.ROTATE_180));
            textStyle.setColor(ColorUtil.INSTANCE.colorIntToHex(ExtKt.nextRgb$default(Random.Default, 0, 1, (Object) null)));
            textStyle.setBackground(new LayerPaint.Color(ColorUtil.INSTANCE.colorIntToHex(ExtKt.nextRgb(Random.Default, 60))));
            createTextEntity$default(this, textStyle, false, 2, (Object) null);
        }
    }

    static /* synthetic */ TextEntity createTextEntity$default(EditorFrame editorFrame, TextStyle textStyle, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle = new TextStyle();
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return editorFrame.createTextEntity(textStyle, z);
    }

    /* access modifiers changed from: private */
    public final TextEntity createTextEntity(TextStyle textStyle, boolean z) {
        TextEntity create = TextEntity.Companion.create(this, textStyle);
        Timber.m300d("~> create-entity " + create.getToken(), new Object[0]);
        this.entities.put(create.getToken(), create);
        notifyEntityVisibilityCountChanged();
        View view = create.getView();
        view.setOnTouchListener(getViewTouchListener(create.getToken(), view));
        create.setOnNPropertyAppliedListener(this);
        if (z) {
            moveEntityToCenter(create);
        }
        getSelectionView().resetSelectedView();
        return create;
    }

    static /* synthetic */ MediaEntity createMediaEntity$default(EditorFrame editorFrame, MediaStyle mediaStyle, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaStyle = new MediaStyle();
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return editorFrame.createMediaEntity(mediaStyle, z);
    }

    /* access modifiers changed from: private */
    public final MediaEntity createMediaEntity(MediaStyle mediaStyle, boolean z) {
        MediaEntity create = MediaEntity.Companion.create(this, mediaStyle);
        Timber.m300d("~> create-entity " + create.getToken(), new Object[0]);
        this.entities.put(create.getToken(), create);
        notifyEntityVisibilityCountChanged();
        View view = create.getView();
        view.setOnTouchListener(getViewTouchListener(create.getToken(), view));
        create.setOnNPropertyAppliedListener(this);
        if (z) {
            moveEntityToCenter(create);
        }
        getSelectionView().resetSelectedView();
        return create;
    }

    private final CoreEntity<?, ?> createWatermarkEntity() {
        Timber.m300d("~> create-entity watermark", new Object[0]);
        ImageView imageView = (ImageView) findViewById(C4175R.C4179id.official_watermark_view);
        Intrinsics.checkNotNullExpressionValue(imageView, "watermarkView");
        return new EditorFrame$createWatermarkEntity$1(imageView, new CoreLayer(imageView), new CoreStyle());
    }

    private final void moveEntityToCenter(CoreEntity<?, ?> coreEntity) {
        View view = coreEntity.getView();
        view.post(new EditorFrame$moveEntityToCenter$1(this, view, coreEntity));
    }

    public final void onPause() {
        for (CoreEntity next : this.entities.values()) {
            if (next instanceof MediaEntity) {
                ((MediaEntity) next).stopPlaying();
            }
        }
    }

    public final void onResume() {
        for (CoreEntity next : this.entities.values()) {
            if (next instanceof MediaEntity) {
                ((MediaEntity) next).refresh();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.sizeChangesRateLimitingHandler.removeCallbacksAndMessages((Object) null);
        this.sizeChangesRateLimitingHandler.postDelayed(new EditorFrame$onSizeChanged$1(this, i, i2), 400);
    }

    public boolean hasEntity(String str) {
        Timber.m300d("~> has-entity: " + str + " in " + this.entities.keySet(), new Object[0]);
        if (str == null || this.entities.get(str) == null) {
            return false;
        }
        return true;
    }

    public Collection<CoreEntity<?, ?>> getEntities() {
        Collection<CoreEntity<?, ?>> values = this.entities.values();
        Intrinsics.checkNotNullExpressionValue(values, "entities.values");
        return values;
    }

    public TextEntity getTextEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Timber.m300d("~> access-entity: " + str + " from " + this.entities.keySet(), new Object[0]);
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        Objects.requireNonNull(coreEntity, "null cannot be cast to non-null type editor.editor.equipment.text.TextEntity");
        return (TextEntity) coreEntity;
    }

    public MediaEntity getMediaEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Timber.m300d("~> access-entity: " + str + " from " + this.entities.keySet(), new Object[0]);
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        Objects.requireNonNull(coreEntity, "null cannot be cast to non-null type editor.editor.equipment.media.MediaEntity");
        return (MediaEntity) coreEntity;
    }

    public FrameEntity getFrameEntity() {
        Timber.m300d("~> access-entity: " + this.frameEntity.getToken(), new Object[0]);
        return this.frameEntity;
    }

    public CoreEntity<?, ?> getWatermarkEntity() {
        CoreEntity<?, ?> coreEntity = this.watermarkEntity;
        if (coreEntity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watermarkEntity");
        }
        return coreEntity;
    }

    public void updateTextEntity(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        Timber.m300d("~> update-text-entity: " + nicoPropertyBundle.getToken() + " in " + this.entities.keySet(), new Object[0]);
        CoreEntity coreEntity = this.entities.get(nicoPropertyBundle.getToken());
        if (coreEntity == null) {
            coreEntity = createTextEntity$default(this, (TextStyle) null, false, 3, (Object) null);
        }
        coreEntity.applyPropertyBundle(nicoPropertyBundle);
    }

    public void updateMediaEntity(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        Timber.m300d("~> update-media-entity: " + nicoPropertyBundle.getToken() + " in " + this.entities.keySet(), new Object[0]);
        CoreEntity coreEntity = this.entities.get(nicoPropertyBundle.getToken());
        if (coreEntity == null) {
            coreEntity = createMediaEntity$default(this, (MediaStyle) null, false, 3, (Object) null);
        }
        coreEntity.applyPropertyBundle(nicoPropertyBundle);
    }

    public void updateEntity(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        Timber.m300d("~> update-entity: " + nicoPropertyBundle.getToken() + " from " + this.entities.keySet(), new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("~> applying-bundle: ");
        sb.append(nicoPropertyBundle);
        Timber.m300d(sb.toString(), new Object[0]);
        if (Intrinsics.areEqual((Object) nicoPropertyBundle.getToken(), (Object) this.frameEntity.getToken())) {
            this.frameEntity.applyPropertyBundle(nicoPropertyBundle);
            return;
        }
        resetAutoRearrange();
        CoreEntity<?, ?> coreEntity = this.entities.get(nicoPropertyBundle.getToken());
        if (coreEntity != null) {
            coreEntity.applyPropertyBundle(nicoPropertyBundle);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void duplicateEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Timber.m300d("~> duplicate-entity: " + str + " in " + this.entities.keySet(), new Object[0]);
        resetAutoRearrange();
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            CoreEntity duplicate = coreEntity.duplicate(this);
            Timber.m300d("~> duplicated-entity: " + duplicate.getToken(), new Object[0]);
            View view = duplicate.getView();
            view.setOnTouchListener(getViewTouchListener(duplicate.getToken(), view));
            duplicate.setOnNPropertyAppliedListener(this);
            this.entities.put(duplicate.getToken(), duplicate);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void showEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Timber.m300d("~> show-entity: " + str + " in " + this.entities.keySet(), new Object[0]);
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            coreEntity.show(true);
            notifyEntityVisibilityCountChanged();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void hideEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Timber.m300d("~> hide-entity: " + str + " in " + this.entities.keySet(), new Object[0]);
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            coreEntity.hide();
            notifyEntityVisibilityCountChanged();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void deleteEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        Timber.m300d("~> delete-entity: " + str + " in " + this.entities.keySet(), new Object[0]);
        getSelectionView().resetSelectedView();
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            if (coreEntity.remove()) {
                this.entities.remove(str);
            } else {
                Timber.m303e("Unable to delete this entity " + str + ClassUtils.PACKAGE_SEPARATOR_CHAR, new Object[0]);
            }
            resetAutoRearrange();
            notifyEntityVisibilityCountChanged();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void notifyEntityVisibilityCountChanged() {
        int size = this.entities.size();
        Collection<CoreEntity<?, ?>> values = this.entities.values();
        Intrinsics.checkNotNullExpressionValue(values, "entities.values");
        Iterable<CoreEntity> iterable = values;
        int i = 0;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (CoreEntity isVisible : iterable) {
                if (isVisible.isVisible() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        EditorFrameCallback editorFrameCallback = this.frameCallback;
        if (editorFrameCallback != null) {
            editorFrameCallback.onTotalEntityVisibilityCountChanged(i, size - i);
        }
    }

    public final void showAllEntities() {
        resetAutoRearrange();
        Collection<CoreEntity<?, ?>> values = this.entities.values();
        Intrinsics.checkNotNullExpressionValue(values, "entities.values");
        for (CoreEntity coreEntity : values) {
            if (!coreEntity.isVisible()) {
                coreEntity.applyProperty(new NicoProperty.Scale(1.0f));
                coreEntity.applyProperty(new NicoProperty.Rotation(0.0f));
                coreEntity.show(true);
            }
        }
        notifyEntityVisibilityCountChanged();
    }

    public void onEntityResized(CoreEntity<?, ?> coreEntity, float f, float f2) {
        resetAutoRearrange();
    }

    public void onSaveAsWatermarkTapped(CoreEntity<?, ?> coreEntity) {
        EditorFrameCallback editorFrameCallback;
        if (coreEntity == null || !coreEntity.isWatermark()) {
            return;
        }
        if (coreEntity instanceof TextEntity) {
            EditorFrameCallback editorFrameCallback2 = this.frameCallback;
            if (editorFrameCallback2 != null) {
                editorFrameCallback2.onSaveEntityAsWatermarkTapped(coreEntity);
            }
        } else if ((coreEntity instanceof MediaEntity) && (editorFrameCallback = this.frameCallback) != null) {
            editorFrameCallback.onSaveEntityAsWatermarkTapped(coreEntity);
        }
    }

    public void onNPropertyApplied(CoreEntity<?, ?> coreEntity, NicoProperty nicoProperty) {
        Intrinsics.checkNotNullParameter(coreEntity, "entity");
        Intrinsics.checkNotNullParameter(nicoProperty, "property");
        Timber.m306i("onNPropertyApplied(" + coreEntity.getToken() + ", " + nicoProperty + "); entity-count=" + this.entities.size(), new Object[0]);
        getSelectionView().redraw();
    }

    private final ViewTouchListener getViewTouchListener(String str, View view) {
        return new ViewTouchListener(view, this, true, str, this);
    }

    public void onOverlayViewTapped(String str, View view, boolean z) {
        EditorFrameCallback editorFrameCallback;
        EditorFrameCallback editorFrameCallback2;
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        CoreEntity coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            Intrinsics.checkNotNullExpressionValue(coreEntity, "entities[identifier] ?: return");
            if (coreEntity instanceof TextEntity) {
                TextEntity textEntity = (TextEntity) coreEntity;
                if (textEntity.isDefault()) {
                    EditorFrameCallback editorFrameCallback3 = this.frameCallback;
                    if (editorFrameCallback3 != null) {
                        editorFrameCallback3.onEntityTapped(textEntity);
                    }
                } else if (z && (editorFrameCallback2 = this.frameCallback) != null) {
                    editorFrameCallback2.onTextEntityDoubleTapped(textEntity);
                }
            } else if (coreEntity instanceof MediaEntity) {
                MediaEntity mediaEntity = (MediaEntity) coreEntity;
                if (mediaEntity.isDefault() && (editorFrameCallback = this.frameCallback) != null) {
                    editorFrameCallback.onEntityTapped(mediaEntity);
                }
            }
        }
    }

    public void onOverlayViewLongPressed(String str, View view) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Timber.m300d("onOverlayViewLongPressed()", new Object[0]);
    }

    public void onOverlayViewDragStarted(String str, View view) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Timber.m300d("onOverlayViewDragStarted()", new Object[0]);
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            CoreEntity coreEntity2 = coreEntity;
            if (coreEntity2 instanceof TextEntity) {
                TextEntity textEntity = (TextEntity) coreEntity2;
                if (!textEntity.isDefault()) {
                    getSelectionView().setSelectedEntity(coreEntity2);
                    EditorFrameCallback editorFrameCallback = this.frameCallback;
                    if (editorFrameCallback != null) {
                        editorFrameCallback.onEntityTapped(textEntity);
                        return;
                    }
                    return;
                }
            }
            if (coreEntity2 instanceof MediaEntity) {
                MediaEntity mediaEntity = (MediaEntity) coreEntity2;
                if (!mediaEntity.isDefault()) {
                    getSelectionView().setSelectedEntity(coreEntity2);
                    EditorFrameCallback editorFrameCallback2 = this.frameCallback;
                    if (editorFrameCallback2 != null) {
                        editorFrameCallback2.onEntityTapped(mediaEntity);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void onOverlayViewDragging(String str, View view) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        resetAutoRearrange();
        getSelectionView().redraw();
    }

    public void onOverlayViewDragStopped(String str, View view) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Timber.m300d("onOverlayViewDragStopped()", new Object[0]);
        CoreEntity<?, ?> coreEntity = this.entities.get(str);
        if (coreEntity != null) {
            CoreEntity coreEntity2 = coreEntity;
            relocateEntityIfOutOfBounds(coreEntity2);
            CoreLayer layer = coreEntity2.getLayer();
            layer.postDelayed(new EditorFrame$onOverlayViewDragStopped$1(layer, str, coreEntity2), 200);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public final boolean relocateEntityIfOutOfBounds(CoreEntity<?, ?> coreEntity) {
        boolean viewIntersects = this.viewToPathUtils.viewIntersects(coreEntity.getView(), this);
        if (!viewIntersects) {
            coreEntity.moveCenterTo((int) StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, (int) StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB);
        }
        return !viewIntersects;
    }

    private final void resetAutoRearrange() {
        applyWireframe((Wireframe) null);
        applyDraft((EditorDraft) null);
    }

    public final void notifyVisiblePanelCountChanged(int i) {
        if (i > 0) {
            CoreEntity<?, ?> coreEntity = this.watermarkEntity;
            if (coreEntity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("watermarkEntity");
            }
            coreEntity.getView().animate().alpha(0.4f);
            return;
        }
        CoreEntity<?, ?> coreEntity2 = this.watermarkEntity;
        if (coreEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watermarkEntity");
        }
        coreEntity2.getView().animate().alpha(1.0f);
    }

    public final Wireframe getWireframe() {
        return this.f1536wireframe;
    }

    public final void applyWireframe(Wireframe wireframe2) {
        int i;
        int i2;
        this.f1536wireframe = wireframe2;
        if (wireframe2 != null) {
            getSelectionView().resetSelectedView();
            this.draft = null;
            Collection arrayList = new ArrayList();
            for (Object next : getEntities()) {
                if (next instanceof TextEntity) {
                    arrayList.add(next);
                }
            }
            List<TextEntity> list = (List) arrayList;
            Collection arrayList2 = new ArrayList();
            for (Object next2 : getEntities()) {
                if (next2 instanceof MediaEntity) {
                    arrayList2.add(next2);
                }
            }
            List<MediaEntity> list2 = (List) arrayList2;
            Iterable<TextEntity> iterable = list;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                i = 0;
                for (TextEntity isWatermark : iterable) {
                    if ((!isWatermark.isWatermark()) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i = 0;
            }
            Iterable<MediaEntity> iterable2 = list2;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                i2 = 0;
                for (MediaEntity isWatermark2 : iterable2) {
                    if ((!isWatermark2.isWatermark()) && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i2 = 0;
            }
            int textElementCount = wireframe2.getTextElementCount();
            int mediaElementCount = wireframe2.getMediaElementCount();
            if (textElementCount > i) {
                int i3 = textElementCount - i;
                for (int i4 = 0; i4 < i3; i4++) {
                    createTextEntity$default(this, (TextStyle) null, false, 1, (Object) null).enablePlaceholder();
                }
            } else if (i > textElementCount) {
                int i5 = i - textElementCount;
                List arrayList3 = new ArrayList();
                for (TextEntity textEntity : list) {
                    if (!textEntity.isWatermark() && textEntity.isPlaceholder() && textEntity.isDefault()) {
                        arrayList3.add(textEntity.getToken());
                    }
                }
                for (String deleteEntity : CollectionsKt.take(arrayList3, i5)) {
                    deleteEntity(deleteEntity);
                }
            }
            if (mediaElementCount > i2) {
                int i6 = mediaElementCount - i2;
                for (int i7 = 0; i7 < i6; i7++) {
                    createMediaEntity$default(this, (MediaStyle) null, false, 1, (Object) null).enablePlaceholder();
                }
            } else if (i2 > mediaElementCount) {
                int i8 = i2 - mediaElementCount;
                List arrayList4 = new ArrayList();
                for (MediaEntity mediaEntity : list2) {
                    if (!mediaEntity.isWatermark() && mediaEntity.isPlaceholder() && mediaEntity.isDefault()) {
                        arrayList4.add(mediaEntity.getToken());
                    }
                }
                for (String deleteEntity2 : CollectionsKt.take(arrayList4, i8)) {
                    deleteEntity(deleteEntity2);
                }
            }
            this.wireframeTransformer.transform(wireframe2);
        }
    }

    public final void apply(TextWatermark textWatermark) {
        Intrinsics.checkNotNullParameter(textWatermark, "watermark");
        TextStyle textStyle = new TextStyle();
        textWatermark.getStyle().copy(textStyle);
        createTextEntity$default(this, textStyle, false, 2, (Object) null);
    }

    public final void apply(PhotoWatermark photoWatermark) {
        Intrinsics.checkNotNullParameter(photoWatermark, "watermark");
        MediaStyle mediaStyle = new MediaStyle();
        photoWatermark.getStyle().copy(mediaStyle);
        createMediaEntity$default(this, mediaStyle, false, 2, (Object) null);
    }

    public final void apply(EditorDraft editorDraft) {
        Intrinsics.checkNotNullParameter(editorDraft, "draft");
        int size = this.entities.size();
        if (size == 0) {
            post(new EditorFrame$apply$1(this, editorDraft));
            return;
        }
        Timber.m303e(size + " unsaved entities available.", new Object[0]);
        throw new RuntimeException("Editor frame has unsaved entities. A draft can't be applied.");
    }

    /* access modifiers changed from: private */
    public final void applyDraft(EditorDraft editorDraft) {
        this.draft = editorDraft;
        if (editorDraft != null) {
            this.f1536wireframe = null;
            Rect drawingRect = ((FrameLayer) getFrameEntity().getLayer()).getDrawingRect();
            post(new EditorFrame$applyDraft$1(this, drawingRect.width(), drawingRect.height()));
        }
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [editor.editor.equipment.core.CoreEntity, editor.editor.equipment.core.CoreEntity<?, ?>] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void applyMetadata(editor.editor.equipment.core.CoreEntity<?, ?> r8, int r9, int r10) {
        /*
            r7 = this;
            android.view.View r0 = r8.getView()
            editor.editor.equipment.core.CoreLayer r1 = r8.getLayer()
            editor.editor.equipment.core.CoreStyle r8 = r8.getStyle()
            editor.editor.equipment.core.metadata.LayerMetadata r2 = r8.getMetadata()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0017
            return
        L_0x0017:
            editor.editor.equipment.core.metadata.LayerMetadata r2 = r8.getMetadata()
            float r2 = r2.getAbsoluteX(r9)
            editor.editor.equipment.core.metadata.LayerMetadata r3 = r8.getMetadata()
            float r3 = r3.getAbsoluteY(r10)
            editor.editor.equipment.core.metadata.LayerMetadata r4 = r8.getMetadata()
            int r9 = r4.getAbsoluteWidthInt(r9)
            editor.editor.equipment.core.metadata.LayerMetadata r8 = r8.getMetadata()
            int r8 = r8.getAbsoluteHeightInt(r10)
            r4 = 0
            r10 = 1
            r6 = 0
            android.view.ViewPropertyAnimator r10 = editor.util.ExtKt.animator$default(r0, r4, r10, r6)
            editor.editor.editorframehost.frame.EditorFrame$applyMetadata$1 r4 = new editor.editor.editorframehost.frame.EditorFrame$applyMetadata$1
            r4.<init>(r9, r0, r8, r1)
            android.animation.ValueAnimator$AnimatorUpdateListener r4 = (android.animation.ValueAnimator.AnimatorUpdateListener) r4
            android.view.ViewPropertyAnimator r10 = r10.setUpdateListener(r4)
            editor.editor.editorframehost.frame.EditorFrame$applyMetadata$2 r0 = new editor.editor.editorframehost.frame.EditorFrame$applyMetadata$2
            r0.<init>(r1, r9, r8)
            android.animation.Animator$AnimatorListener r0 = (android.animation.Animator.AnimatorListener) r0
            android.view.ViewPropertyAnimator r8 = r10.setListener(r0)
            android.view.ViewPropertyAnimator r8 = r8.translationX(r2)
            r8.translationY(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.editor.editorframehost.frame.EditorFrame.applyMetadata(editor.editor.equipment.core.CoreEntity, int, int):void");
    }
}
