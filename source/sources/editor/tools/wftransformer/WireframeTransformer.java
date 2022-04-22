package editor.tools.wftransformer;

import android.graphics.Rect;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameLayer;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.text.TextEntity;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import timber.log.Timber;
import wireframe.language.Wireframe;
import wireframe.language.elements.WfElement;
import wireframe.language.elements.WfLayoutElement;
import wireframe.language.elements.WfMediaElement;
import wireframe.language.elements.WfTextElement;
import wireframe.language.properties.WfOrientation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0002J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J \u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fj\u0002`\u00100\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo26107d2 = {"Leditor/tools/wftransformer/WireframeTransformer;", "", "frame", "Leditor/editor/editorframehost/frame/EditorFrame;", "(Leditor/editor/editorframehost/frame/EditorFrame;)V", "mediaEntitiesStack", "Ljava/util/Stack;", "Leditor/editor/equipment/media/MediaEntity;", "mediaTransformer", "Leditor/tools/wftransformer/WfMediaTransformer;", "textEntitiesStack", "Leditor/editor/equipment/text/TextEntity;", "textTransformer", "Leditor/tools/wftransformer/WfTextTransformer;", "watermarkEntities", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "loadElement", "", "element", "Lwireframe/language/elements/WfElement;", "elementRect", "Landroid/graphics/Rect;", "parentElement", "Lwireframe/language/elements/WfLayoutElement;", "parentRect", "loadHorizontalLayoutElement", "layoutElement", "layoutElementRect", "weightSum", "", "loadLayoutElement", "loadStackedLayoutElement", "loadVerticalLayoutElement", "transform", "wireframe", "Lwireframe/language/Wireframe;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WireframeTransformer.kt */
public final class WireframeTransformer {
    private final EditorFrame frame;
    private final Stack<MediaEntity> mediaEntitiesStack = new Stack<>();
    private final WfMediaTransformer mediaTransformer = new WfMediaTransformer();
    private final Stack<TextEntity> textEntitiesStack = new Stack<>();
    private final WfTextTransformer textTransformer = new WfTextTransformer();
    private final Stack<CoreEntity<?, ?>> watermarkEntities = new Stack<>();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WfOrientation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WfOrientation.VERTICAL.ordinal()] = 1;
            iArr[WfOrientation.HORIZONTAL.ordinal()] = 2;
            iArr[WfOrientation.STACKED.ordinal()] = 3;
        }
    }

    public WireframeTransformer(EditorFrame editorFrame) {
        Intrinsics.checkNotNullParameter(editorFrame, "frame");
        this.frame = editorFrame;
    }

    public final void transform(Wireframe wireframe2) {
        Intrinsics.checkNotNullParameter(wireframe2, "wireframe");
        Timber.m300d("transforming wireframe=" + wireframe2, new Object[0]);
        for (CoreEntity coreEntity : this.frame.getEntities()) {
            if (coreEntity.isWatermark()) {
                this.watermarkEntities.push(coreEntity);
            } else if (coreEntity instanceof TextEntity) {
                this.textEntitiesStack.push(coreEntity);
            } else if (coreEntity instanceof MediaEntity) {
                this.mediaEntitiesStack.push(coreEntity);
            }
        }
        loadElement$default(this, wireframe2.getElement(), ((FrameLayer) this.frame.getFrameEntity().getLayer()).getDrawingRect(), (WfLayoutElement) null, (Rect) null, 12, (Object) null);
        while (!this.textEntitiesStack.isEmpty()) {
            this.frame.hideEntity(this.textEntitiesStack.pop().getToken());
        }
        while (!this.mediaEntitiesStack.isEmpty()) {
            this.frame.hideEntity(this.mediaEntitiesStack.pop().getToken());
        }
        while (!this.watermarkEntities.isEmpty()) {
            this.watermarkEntities.pop().getView().bringToFront();
        }
    }

    static /* synthetic */ void loadElement$default(WireframeTransformer wireframeTransformer, WfElement wfElement, Rect rect, WfLayoutElement wfLayoutElement, Rect rect2, int i, Object obj) {
        if ((i & 4) != 0) {
            wfLayoutElement = null;
        }
        if ((i & 8) != 0) {
            rect2 = null;
        }
        wireframeTransformer.loadElement(wfElement, rect, wfLayoutElement, rect2);
    }

    private final void loadElement(WfElement wfElement, Rect rect, WfLayoutElement wfLayoutElement, Rect rect2) {
        if (wfElement instanceof WfTextElement) {
            TextEntity pop = this.textEntitiesStack.pop();
            this.frame.showEntity(pop.getToken());
            WfTextTransformer with = this.textTransformer.with((WfTextElement) wfElement, rect, wfLayoutElement, rect2);
            Intrinsics.checkNotNullExpressionValue(pop, "entity");
            with.transform(pop);
        } else if (wfElement instanceof WfMediaElement) {
            MediaEntity pop2 = this.mediaEntitiesStack.pop();
            this.frame.showEntity(pop2.getToken());
            WfMediaTransformer with2 = this.mediaTransformer.with((WfMediaElement) wfElement, rect, wfLayoutElement, rect2);
            Intrinsics.checkNotNullExpressionValue(pop2, "entity");
            with2.transform(pop2);
        } else if (wfElement instanceof WfLayoutElement) {
            loadLayoutElement((WfLayoutElement) wfElement, rect);
        }
    }

    private final void loadLayoutElement(WfLayoutElement wfLayoutElement, Rect rect) {
        float computeWeightSum = (float) wfLayoutElement.computeWeightSum();
        if (computeWeightSum != 0.0f || wfLayoutElement.getTotalElements() != wfLayoutElement.computeTotalWeightedElements()) {
            int i = WhenMappings.$EnumSwitchMapping$0[wfLayoutElement.getOrientation().ordinal()];
            if (i == 1) {
                loadVerticalLayoutElement(wfLayoutElement, rect, computeWeightSum);
            } else if (i == 2) {
                loadHorizontalLayoutElement(wfLayoutElement, rect, computeWeightSum);
            } else if (i == 3) {
                loadStackedLayoutElement(wfLayoutElement, rect);
            }
        }
    }

    private final void loadVerticalLayoutElement(WfLayoutElement wfLayoutElement, Rect rect, float f) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        float height = ((float) rect.height()) / f;
        for (WfElement next : wfLayoutElement.getElements()) {
            int roundToInt = MathKt.roundToInt(((float) i3) + (((float) next.getWeight()) * height));
            loadElement(next, new Rect(i, i3, i2, roundToInt), wfLayoutElement, rect);
            i3 = roundToInt;
        }
    }

    private final void loadHorizontalLayoutElement(WfLayoutElement wfLayoutElement, Rect rect, float f) {
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.bottom;
        float width = ((float) rect.width()) / f;
        for (WfElement next : wfLayoutElement.getElements()) {
            int roundToInt = MathKt.roundToInt(((float) i) + (((float) next.getWeight()) * width));
            loadElement(next, new Rect(i, i2, roundToInt, i3), wfLayoutElement, rect);
            i = roundToInt;
        }
    }

    private final void loadStackedLayoutElement(WfLayoutElement wfLayoutElement, Rect rect) {
        Rect rect2;
        for (WfElement next : wfLayoutElement.getElements()) {
            if (next.getWeight() <= 0) {
                if (next instanceof WfTextElement) {
                    rect2 = WfTransformerUtil.INSTANCE.createStackedElementRect(this.textEntitiesStack.peek().getView(), next, rect);
                } else if (next instanceof WfMediaElement) {
                    rect2 = WfTransformerUtil.INSTANCE.createStackedElementRect(this.mediaEntitiesStack.peek().getView(), next, rect);
                } else if (next instanceof WfLayoutElement) {
                    rect2 = rect;
                } else {
                    throw new RuntimeException("Unknown element-type: " + next);
                }
                loadElement(next, rect2, wfLayoutElement, rect);
            } else {
                throw new RuntimeException("Stacked Elements can't have weight");
            }
        }
    }
}
