package com.memes.plus.util.assetfile;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H@"}, mo26107d2 = {"createDefaultProfileThumbBitmap", "", "continuation", "Lkotlin/coroutines/Continuation;", "Landroid/graphics/Bitmap;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.util.assetfile.AssetFileProvider", mo26808f = "AssetFileProvider.kt", mo26809i = {}, mo26810l = {17}, mo26811m = "createDefaultProfileThumbBitmap", mo26812n = {}, mo26813s = {})
/* compiled from: AssetFileProvider.kt */
final class AssetFileProvider$createDefaultProfileThumbBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetFileProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssetFileProvider$createDefaultProfileThumbBitmap$1(AssetFileProvider assetFileProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = assetFileProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createDefaultProfileThumbBitmap(this);
    }
}
