package com.memes.plus.p040ui.create_post;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.ExportPostViewModel$getOutputTargetFile$1 */
/* compiled from: ExportPostViewModel.kt */
final /* synthetic */ class ExportPostViewModel$getOutputTargetFile$1 extends MutablePropertyReference0Impl {
    ExportPostViewModel$getOutputTargetFile$1(ExportPostViewModel exportPostViewModel) {
        super(exportPostViewModel, ExportPostViewModel.class, "outputFile", "getOutputFile()Ljava/io/File;", 0);
    }

    public Object get() {
        return ExportPostViewModel.access$getOutputFile$p((ExportPostViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((ExportPostViewModel) this.receiver).outputFile = (File) obj;
    }
}
