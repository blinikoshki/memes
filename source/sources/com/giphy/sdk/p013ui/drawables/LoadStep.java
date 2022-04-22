package com.giphy.sdk.p013ui.drawables;

import com.giphy.sdk.core.models.enums.RenditionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/drawables/LoadStep;", "", "type", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "onlyCached", "", "actionIfLoaded", "Lcom/giphy/sdk/ui/drawables/GifStepAction;", "(Lcom/giphy/sdk/core/models/enums/RenditionType;ZLcom/giphy/sdk/ui/drawables/GifStepAction;)V", "getActionIfLoaded", "()Lcom/giphy/sdk/ui/drawables/GifStepAction;", "getOnlyCached", "()Z", "getType", "()Lcom/giphy/sdk/core/models/enums/RenditionType;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.drawables.LoadStep */
/* compiled from: LoadStep.kt */
public final class LoadStep {
    private final GifStepAction actionIfLoaded;
    private final boolean onlyCached;
    private final RenditionType type;

    public LoadStep(RenditionType renditionType, boolean z, GifStepAction gifStepAction) {
        Intrinsics.checkParameterIsNotNull(renditionType, "type");
        Intrinsics.checkParameterIsNotNull(gifStepAction, "actionIfLoaded");
        this.type = renditionType;
        this.onlyCached = z;
        this.actionIfLoaded = gifStepAction;
    }

    public final GifStepAction getActionIfLoaded() {
        return this.actionIfLoaded;
    }

    public final boolean getOnlyCached() {
        return this.onlyCached;
    }

    public final RenditionType getType() {
        return this.type;
    }
}
