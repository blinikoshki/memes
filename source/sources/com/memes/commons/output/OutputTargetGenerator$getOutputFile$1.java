package com.memes.commons.output;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: OutputTargetGenerator.kt */
final /* synthetic */ class OutputTargetGenerator$getOutputFile$1 extends MutablePropertyReference0Impl {
    OutputTargetGenerator$getOutputFile$1(OutputTargetGenerator outputTargetGenerator) {
        super(outputTargetGenerator, OutputTargetGenerator.class, "outputFile", "getOutputFile()Ljava/io/File;", 0);
    }

    public Object get() {
        return OutputTargetGenerator.access$getOutputFile$p((OutputTargetGenerator) this.receiver);
    }

    public void set(Object obj) {
        ((OutputTargetGenerator) this.receiver).outputFile = (File) obj;
    }
}
