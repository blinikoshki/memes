package coil.intercept;

import coil.intercept.Interceptor;
import coil.request.SuccessResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 1})
@DebugMetadata(mo26807c = "coil.intercept.EngineInterceptor$intercept$2", mo26808f = "EngineInterceptor.kt", mo26809i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, mo26810l = {403, 426, 478}, mo26811m = "invokeSuspend", mo26812n = {"this_$iv", "fetcher$iv", "request$iv", "size$iv", "eventListener$iv", "options$iv", "type$iv", "this_$iv", "request$iv", "size$iv", "eventListener$iv", "options$iv", "fetchResult$iv", "decoder$iv", "request$iv", "size$iv", "eventListener$iv", "this_$iv$iv", "baseResult$iv", "$this$foldIndices$iv$iv$iv"}, mo26813s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6"})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptor$intercept$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
    final /* synthetic */ Interceptor.Chain $chain;
    final /* synthetic */ Ref.ObjectRef $eventListener;
    final /* synthetic */ Ref.ObjectRef $fetcher;
    final /* synthetic */ Ref.ObjectRef $mappedData;
    final /* synthetic */ Ref.ObjectRef $memoryCacheKey;
    final /* synthetic */ Ref.ObjectRef $request;
    final /* synthetic */ Ref.ObjectRef $size;
    final /* synthetic */ Ref.ObjectRef $value;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, Interceptor.Chain chain, Ref.ObjectRef objectRef5, Ref.ObjectRef objectRef6, Ref.ObjectRef objectRef7, Continuation continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$request = objectRef;
        this.$value = objectRef2;
        this.$mappedData = objectRef3;
        this.$fetcher = objectRef4;
        this.$chain = chain;
        this.$size = objectRef5;
        this.$eventListener = objectRef6;
        this.$memoryCacheKey = objectRef7;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EngineInterceptor$intercept$2(this.this$0, this.$request, this.$value, this.$mappedData, this.$fetcher, this.$chain, this.$size, this.$eventListener, this.$memoryCacheKey, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EngineInterceptor$intercept$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x01bf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x03ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r7 = r21
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r8 = 3
            r9 = 2
            r12 = 1
            if (r1 == 0) goto L_0x009f
            if (r1 == r12) goto L_0x006f
            if (r1 == r9) goto L_0x0045
            if (r1 != r8) goto L_0x003d
            int r1 = r7.I$1
            int r2 = r7.I$0
            java.lang.Object r3 = r7.L$6
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r7.L$5
            coil.fetch.DrawableResult r4 = (coil.fetch.DrawableResult) r4
            java.lang.Object r5 = r7.L$4
            coil.intercept.EngineInterceptor r5 = (coil.intercept.EngineInterceptor) r5
            java.lang.Object r6 = r7.L$3
            coil.intercept.EngineInterceptor$intercept$2 r6 = (coil.intercept.EngineInterceptor$intercept$2) r6
            java.lang.Object r9 = r7.L$2
            coil.EventListener r9 = (coil.EventListener) r9
            java.lang.Object r13 = r7.L$1
            coil.size.Size r13 = (coil.size.Size) r13
            java.lang.Object r14 = r7.L$0
            coil.request.ImageRequest r14 = (coil.request.ImageRequest) r14
            kotlin.ResultKt.throwOnFailure(r22)
            r10 = r22
            r8 = r4
            r4 = r7
            r15 = 3
            goto L_0x0318
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            java.lang.Object r1 = r7.L$7
            coil.decode.Decoder r1 = (coil.decode.Decoder) r1
            java.lang.Object r2 = r7.L$6
            coil.fetch.FetchResult r2 = (coil.fetch.FetchResult) r2
            java.lang.Object r3 = r7.L$5
            coil.decode.Options r3 = (coil.decode.Options) r3
            java.lang.Object r4 = r7.L$4
            coil.intercept.EngineInterceptor$intercept$2 r4 = (coil.intercept.EngineInterceptor$intercept$2) r4
            java.lang.Object r5 = r7.L$3
            coil.EventListener r5 = (coil.EventListener) r5
            java.lang.Object r6 = r7.L$2
            coil.size.Size r6 = (coil.size.Size) r6
            java.lang.Object r9 = r7.L$1
            coil.request.ImageRequest r9 = (coil.request.ImageRequest) r9
            java.lang.Object r13 = r7.L$0
            coil.intercept.EngineInterceptor r13 = (coil.intercept.EngineInterceptor) r13
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x006c }
            r12 = r22
            goto L_0x01c4
        L_0x006c:
            r0 = move-exception
            goto L_0x01e1
        L_0x006f:
            int r1 = r7.I$0
            java.lang.Object r2 = r7.L$6
            coil.decode.Options r2 = (coil.decode.Options) r2
            java.lang.Object r3 = r7.L$5
            coil.intercept.EngineInterceptor$intercept$2 r3 = (coil.intercept.EngineInterceptor$intercept$2) r3
            java.lang.Object r4 = r7.L$4
            coil.EventListener r4 = (coil.EventListener) r4
            java.lang.Object r5 = r7.L$3
            coil.size.Size r5 = (coil.size.Size) r5
            java.lang.Object r6 = r7.L$2
            coil.request.ImageRequest r6 = (coil.request.ImageRequest) r6
            java.lang.Object r13 = r7.L$1
            coil.fetch.Fetcher r13 = (coil.fetch.Fetcher) r13
            java.lang.Object r14 = r7.L$0
            coil.intercept.EngineInterceptor r14 = (coil.intercept.EngineInterceptor) r14
            kotlin.ResultKt.throwOnFailure(r22)
            r19 = r1
            r15 = r14
            r1 = r22
            r20 = r3
            r3 = r2
            r2 = r6
            r6 = r5
            r5 = r4
            r4 = r20
            goto L_0x0140
        L_0x009f:
            kotlin.ResultKt.throwOnFailure(r22)
            coil.intercept.EngineInterceptor r1 = r7.this$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = r7.$request
            T r2 = r2.element
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2
            java.lang.Object r2 = r2.getData()
            r1.invalidateData(r2)
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.$value
            T r1 = r1.element
            coil.memory.RealMemoryCache$Value r1 = (coil.memory.RealMemoryCache.Value) r1
            if (r1 == 0) goto L_0x00cc
            coil.intercept.EngineInterceptor r1 = r7.this$0
            coil.bitmap.BitmapReferenceCounter r1 = r1.referenceCounter
            kotlin.jvm.internal.Ref$ObjectRef r2 = r7.$value
            T r2 = r2.element
            coil.memory.RealMemoryCache$Value r2 = (coil.memory.RealMemoryCache.Value) r2
            android.graphics.Bitmap r2 = r2.getBitmap()
            r1.decrement(r2)
        L_0x00cc:
            coil.intercept.EngineInterceptor r13 = r7.this$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.$mappedData
            T r3 = r1.element
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.$fetcher
            T r1 = r1.element
            r14 = r1
            coil.fetch.Fetcher r14 = (coil.fetch.Fetcher) r14
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.$request
            T r1 = r1.element
            r15 = r1
            coil.request.ImageRequest r15 = (coil.request.ImageRequest) r15
            coil.intercept.Interceptor$Chain r1 = r7.$chain
            coil.intercept.RealInterceptorChain r1 = (coil.intercept.RealInterceptorChain) r1
            int r6 = r1.getRequestType()
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.$size
            T r1 = r1.element
            r5 = r1
            coil.size.Size r5 = (coil.size.Size) r5
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.$eventListener
            T r1 = r1.element
            r4 = r1
            coil.EventListener r4 = (coil.EventListener) r4
            coil.memory.RequestService r1 = r13.requestService
            coil.util.SystemCallbacks r2 = r13.systemCallbacks
            boolean r2 = r2.isOnline()
            coil.decode.Options r2 = r1.options(r15, r5, r2)
            r4.fetchStart(r15, r14, r2)
            coil.bitmap.BitmapPool r16 = r13.bitmapPool
            r7.L$0 = r13
            r7.L$1 = r14
            r7.L$2 = r15
            r7.L$3 = r5
            r7.L$4 = r4
            r7.L$5 = r7
            r7.L$6 = r2
            r7.I$0 = r6
            r7.label = r12
            r1 = r14
            r17 = r2
            r2 = r16
            r16 = r4
            r4 = r5
            r18 = r5
            r5 = r17
            r19 = r6
            r6 = r21
            java.lang.Object r1 = r1.fetch(r2, r3, r4, r5, r6)
            if (r1 != r0) goto L_0x0136
            return r0
        L_0x0136:
            r4 = r7
            r2 = r15
            r5 = r16
            r3 = r17
            r6 = r18
            r15 = r13
            r13 = r14
        L_0x0140:
            coil.fetch.FetchResult r1 = (coil.fetch.FetchResult) r1
            r5.fetchEnd(r2, r13, r3, r1)
            boolean r13 = r1 instanceof coil.fetch.SourceResult
            if (r13 == 0) goto L_0x01ed
            kotlin.coroutines.CoroutineContext r13 = r21.getContext()     // Catch:{ all -> 0x01df }
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r13)     // Catch:{ all -> 0x01df }
            if (r19 != 0) goto L_0x0164
            coil.target.Target r13 = r2.getTarget()     // Catch:{ all -> 0x01df }
            if (r13 != 0) goto L_0x0164
            coil.request.CachePolicy r13 = r2.getMemoryCachePolicy()     // Catch:{ all -> 0x01df }
            boolean r13 = r13.getWriteEnabled()     // Catch:{ all -> 0x01df }
            if (r13 != 0) goto L_0x0164
            r13 = 1
            goto L_0x0165
        L_0x0164:
            r13 = 0
        L_0x0165:
            if (r13 == 0) goto L_0x016c
            coil.decode.EmptyDecoder r13 = coil.decode.EmptyDecoder.INSTANCE     // Catch:{ all -> 0x01df }
            coil.decode.Decoder r13 = (coil.decode.Decoder) r13     // Catch:{ all -> 0x01df }
            goto L_0x0172
        L_0x016c:
            coil.decode.Decoder r13 = r2.getDecoder()     // Catch:{ all -> 0x01df }
            if (r13 == 0) goto L_0x0174
        L_0x0172:
            r10 = r13
            goto L_0x0190
        L_0x0174:
            coil.ComponentRegistry r13 = r15.registry     // Catch:{ all -> 0x01df }
            java.lang.Object r14 = r2.getData()     // Catch:{ all -> 0x01df }
            r16 = r1
            coil.fetch.SourceResult r16 = (coil.fetch.SourceResult) r16     // Catch:{ all -> 0x01df }
            okio.BufferedSource r10 = r16.getSource()     // Catch:{ all -> 0x01df }
            r16 = r1
            coil.fetch.SourceResult r16 = (coil.fetch.SourceResult) r16     // Catch:{ all -> 0x01df }
            java.lang.String r12 = r16.getMimeType()     // Catch:{ all -> 0x01df }
            coil.decode.Decoder r10 = coil.util.ComponentRegistries.requireDecoder(r13, r14, r10, r12)     // Catch:{ all -> 0x01df }
        L_0x0190:
            r5.decodeStart(r2, r10, r3)     // Catch:{ all -> 0x01df }
            coil.bitmap.BitmapPool r14 = r15.bitmapPool     // Catch:{ all -> 0x01df }
            r12 = r1
            coil.fetch.SourceResult r12 = (coil.fetch.SourceResult) r12     // Catch:{ all -> 0x01df }
            okio.BufferedSource r12 = r12.getSource()     // Catch:{ all -> 0x01df }
            r7.L$0 = r15     // Catch:{ all -> 0x01df }
            r7.L$1 = r2     // Catch:{ all -> 0x01df }
            r7.L$2 = r6     // Catch:{ all -> 0x01df }
            r7.L$3 = r5     // Catch:{ all -> 0x01df }
            r7.L$4 = r4     // Catch:{ all -> 0x01df }
            r7.L$5 = r3     // Catch:{ all -> 0x01df }
            r7.L$6 = r1     // Catch:{ all -> 0x01df }
            r7.L$7 = r10     // Catch:{ all -> 0x01df }
            r7.label = r9     // Catch:{ all -> 0x01df }
            r13 = r10
            r9 = r15
            r15 = r12
            r16 = r6
            r17 = r3
            r18 = r4
            java.lang.Object r12 = r13.decode(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x01df }
            if (r12 != r0) goto L_0x01c0
            return r0
        L_0x01c0:
            r13 = r9
            r9 = r2
            r2 = r1
            r1 = r10
        L_0x01c4:
            coil.decode.DecodeResult r12 = (coil.decode.DecodeResult) r12     // Catch:{ all -> 0x006c }
            r5.decodeEnd(r9, r1, r3, r12)     // Catch:{ all -> 0x006c }
            coil.fetch.DrawableResult r1 = new coil.fetch.DrawableResult
            android.graphics.drawable.Drawable r10 = r12.getDrawable()
            boolean r12 = r12.isSampled()
            coil.fetch.SourceResult r2 = (coil.fetch.SourceResult) r2
            coil.decode.DataSource r2 = r2.getDataSource()
            r1.<init>(r10, r12, r2)
            r2 = r9
            r9 = r13
            goto L_0x01f4
        L_0x01df:
            r0 = move-exception
            r2 = r1
        L_0x01e1:
            coil.fetch.SourceResult r2 = (coil.fetch.SourceResult) r2
            okio.BufferedSource r1 = r2.getSource()
            java.io.Closeable r1 = (java.io.Closeable) r1
            coil.util.Extensions.closeQuietly(r1)
            throw r0
        L_0x01ed:
            r9 = r15
            boolean r10 = r1 instanceof coil.fetch.DrawableResult
            if (r10 == 0) goto L_0x03ba
            coil.fetch.DrawableResult r1 = (coil.fetch.DrawableResult) r1
        L_0x01f4:
            kotlin.coroutines.CoroutineContext r10 = r21.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r10)
            java.util.List r10 = r2.getTransformations()
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L_0x020a
            r4 = r7
            r16 = 1
            goto L_0x034e
        L_0x020a:
            android.graphics.drawable.Drawable r12 = r1.getDrawable()
            boolean r12 = r12 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r13 = " to apply transformations: "
            r14 = 4
            java.lang.String r15 = "EngineInterceptor"
            if (r12 == 0) goto L_0x027c
            android.graphics.drawable.Drawable r12 = r1.getDrawable()
            android.graphics.drawable.BitmapDrawable r12 = (android.graphics.drawable.BitmapDrawable) r12
            android.graphics.Bitmap r12 = r12.getBitmap()
            android.graphics.Bitmap$Config[] r8 = coil.memory.RequestService.VALID_TRANSFORMATION_CONFIGS
            java.lang.String r11 = "resultBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r11)
            android.graphics.Bitmap$Config r11 = coil.util.Bitmaps.getSafeConfig(r12)
            boolean r8 = kotlin.collections.ArraysKt.contains((T[]) r8, r11)
            if (r8 == 0) goto L_0x0234
            goto L_0x02cc
        L_0x0234:
            coil.util.Logger r8 = r9.logger
            if (r8 == 0) goto L_0x0262
            int r11 = r8.getLevel()
            if (r11 > r14) goto L_0x0260
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r14 = "Converting bitmap with config "
            r11.append(r14)
            android.graphics.Bitmap$Config r12 = coil.util.Bitmaps.getSafeConfig(r12)
            r11.append(r12)
            r11.append(r13)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r12 = 4
            r13 = 0
            r8.log(r15, r12, r11, r13)
        L_0x0260:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L_0x0262:
            coil.decode.DrawableDecoderService r12 = r9.drawableDecoder
            android.graphics.drawable.Drawable r13 = r1.getDrawable()
            android.graphics.Bitmap$Config r14 = r3.getConfig()
            coil.size.Scale r16 = r3.getScale()
            boolean r17 = r3.getAllowInexactSize()
            r15 = r6
            android.graphics.Bitmap r12 = r12.convert(r13, r14, r15, r16, r17)
            goto L_0x02cc
        L_0x027c:
            coil.util.Logger r8 = r9.logger
            if (r8 == 0) goto L_0x02b3
            int r11 = r8.getLevel()
            r12 = 4
            if (r11 > r12) goto L_0x02b1
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Converting drawable of type "
            r11.append(r12)
            android.graphics.drawable.Drawable r12 = r1.getDrawable()
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getCanonicalName()
            r11.append(r12)
            r11.append(r13)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r12 = 4
            r13 = 0
            r8.log(r15, r12, r11, r13)
        L_0x02b1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L_0x02b3:
            coil.decode.DrawableDecoderService r12 = r9.drawableDecoder
            android.graphics.drawable.Drawable r13 = r1.getDrawable()
            android.graphics.Bitmap$Config r14 = r3.getConfig()
            coil.size.Scale r16 = r3.getScale()
            boolean r17 = r3.getAllowInexactSize()
            r15 = r6
            android.graphics.Bitmap r12 = r12.convert(r13, r14, r15, r16, r17)
        L_0x02cc:
            java.lang.String r3 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            r5.transformStart(r2, r12)
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r8 = r1
            r14 = r2
            r1 = r3
            r13 = r6
            r3 = r10
            r2 = 0
            r6 = r4
            r4 = r7
            r20 = r9
            r9 = r5
            r5 = r20
        L_0x02e8:
            if (r2 >= r1) goto L_0x0327
            java.lang.Object r10 = r3.get(r2)
            coil.transform.Transformation r10 = (coil.transform.Transformation) r10
            coil.bitmap.BitmapPool r11 = r5.bitmapPool
            java.lang.String r15 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            r4.L$0 = r14
            r4.L$1 = r13
            r4.L$2 = r9
            r4.L$3 = r6
            r4.L$4 = r5
            r4.L$5 = r8
            r4.L$6 = r3
            r15 = 0
            r4.L$7 = r15
            r4.I$0 = r2
            r4.I$1 = r1
            r15 = 3
            r4.label = r15
            java.lang.Object r10 = r10.transform(r11, r12, r13, r6)
            if (r10 != r0) goto L_0x0318
            return r0
        L_0x0318:
            r12 = r10
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12
            kotlin.coroutines.CoroutineContext r10 = r4.getContext()
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r10)
            r16 = 1
            int r2 = r2 + 1
            goto L_0x02e8
        L_0x0327:
            r16 = 1
            java.lang.String r0 = "output"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            r9.transformEnd(r14, r12)
            android.content.Context r0 = r14.getContext()
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r1 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            r1.<init>(r0, r12)
            r9 = r1
            android.graphics.drawable.Drawable r9 = (android.graphics.drawable.Drawable) r9
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            coil.fetch.DrawableResult r1 = coil.fetch.DrawableResult.copy$default(r8, r9, r10, r11, r12, r13)
        L_0x034e:
            android.graphics.drawable.Drawable r13 = r1.getDrawable()
            boolean r0 = r13 instanceof android.graphics.drawable.BitmapDrawable
            if (r0 != 0) goto L_0x0357
            r13 = 0
        L_0x0357:
            android.graphics.drawable.BitmapDrawable r13 = (android.graphics.drawable.BitmapDrawable) r13
            if (r13 == 0) goto L_0x0366
            android.graphics.Bitmap r0 = r13.getBitmap()
            if (r0 == 0) goto L_0x0366
            r0.prepareToDraw()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0366:
            android.graphics.drawable.Drawable r0 = r1.component1()
            boolean r2 = r1.component2()
            coil.decode.DataSource r1 = r1.component3()
            coil.intercept.EngineInterceptor r3 = r4.this$0
            r3.validateDrawable(r0)
            coil.intercept.EngineInterceptor r3 = r4.this$0
            kotlin.jvm.internal.Ref$ObjectRef r5 = r4.$request
            T r5 = r5.element
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            kotlin.jvm.internal.Ref$ObjectRef r6 = r4.$memoryCacheKey
            T r6 = r6.element
            coil.memory.MemoryCache$Key r6 = (coil.memory.MemoryCache.Key) r6
            boolean r3 = r3.writeToMemoryCache(r5, r6, r0, r2)
            kotlin.jvm.internal.Ref$ObjectRef r5 = r4.$request
            T r5 = r5.element
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            kotlin.jvm.internal.Ref$ObjectRef r6 = r4.$memoryCacheKey
            T r6 = r6.element
            coil.memory.MemoryCache$Key r6 = (coil.memory.MemoryCache.Key) r6
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x03a1
            r11 = r6
            goto L_0x03a2
        L_0x03a1:
            r11 = 0
        L_0x03a2:
            coil.intercept.Interceptor$Chain r3 = r4.$chain
            coil.intercept.RealInterceptorChain r3 = (coil.intercept.RealInterceptorChain) r3
            android.graphics.Bitmap r3 = r3.getCached()
            if (r3 == 0) goto L_0x03ae
            r10 = 1
            goto L_0x03af
        L_0x03ae:
            r10 = 0
        L_0x03af:
            coil.request.ImageResult$Metadata r3 = new coil.request.ImageResult$Metadata
            r3.<init>(r11, r2, r1, r10)
            coil.request.SuccessResult r1 = new coil.request.SuccessResult
            r1.<init>(r0, r5, r3)
            return r1
        L_0x03ba:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor$intercept$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
