package com.giphy.sdk.p013ui.drawables;

import com.giphy.sdk.core.models.enums.RenditionType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0012R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u0013"}, mo26107d2 = {"Lcom/giphy/sdk/ui/drawables/GifStepMapping;", "", "()V", "EMOJI_STEPS", "Ljava/util/ArrayList;", "Lcom/giphy/sdk/ui/drawables/LoadStep;", "Lkotlin/collections/ArrayList;", "getEMOJI_STEPS", "()Ljava/util/ArrayList;", "FIXED_HEIGHT_STEPS", "getFIXED_HEIGHT_STEPS", "FIXED_WIDTH_STEPS", "getFIXED_WIDTH_STEPS", "FIXED_WIDTH_THEN_ORIGINAL_STEPS", "getFIXED_WIDTH_THEN_ORIGINAL_STEPS", "getLoadingSteps", "", "targetRendition", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.GifStepMapping */
/* compiled from: GifStepMapping.kt */
public final class GifStepMapping {
    private static final ArrayList<LoadStep> EMOJI_STEPS = CollectionsKt.arrayListOf(new LoadStep(RenditionType.fixedWidthSmall, false, GifStepAction.TERMINATE));
    private static final ArrayList<LoadStep> FIXED_HEIGHT_STEPS = CollectionsKt.arrayListOf(new LoadStep(RenditionType.fixedHeight, false, GifStepAction.TERMINATE));
    private static final ArrayList<LoadStep> FIXED_WIDTH_STEPS = CollectionsKt.arrayListOf(new LoadStep(RenditionType.fixedWidth, false, GifStepAction.TERMINATE));
    private static final ArrayList<LoadStep> FIXED_WIDTH_THEN_ORIGINAL_STEPS = CollectionsKt.arrayListOf(new LoadStep(RenditionType.fixedWidth, false, GifStepAction.NEXT), new LoadStep(RenditionType.original, false, GifStepAction.TERMINATE));
    public static final GifStepMapping INSTANCE = new GifStepMapping();

    private GifStepMapping() {
    }

    public final ArrayList<LoadStep> getFIXED_WIDTH_STEPS() {
        return FIXED_WIDTH_STEPS;
    }

    public final ArrayList<LoadStep> getFIXED_HEIGHT_STEPS() {
        return FIXED_HEIGHT_STEPS;
    }

    public final ArrayList<LoadStep> getFIXED_WIDTH_THEN_ORIGINAL_STEPS() {
        return FIXED_WIDTH_THEN_ORIGINAL_STEPS;
    }

    public final ArrayList<LoadStep> getEMOJI_STEPS() {
        return EMOJI_STEPS;
    }

    public final List<LoadStep> getLoadingSteps(RenditionType renditionType) {
        Intrinsics.checkParameterIsNotNull(renditionType, "targetRendition");
        return CollectionsKt.arrayListOf(new LoadStep(RenditionType.fixedWidth, false, GifStepAction.NEXT), new LoadStep(renditionType, false, GifStepAction.TERMINATE));
    }
}
