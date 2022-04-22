package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import okio.BufferedSink;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo26107d2 = {"<anonymous>", "", "run", "io/getstream/chat/android/client/api/models/ProgressRequestBody$writeTo$1$2"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.ProgressRequestBody$writeTo$$inlined$use$lambda$1 */
/* compiled from: ProgressRequestBody.kt */
final class ProgressRequestBody$writeTo$$inlined$use$lambda$1 implements Runnable {
    final /* synthetic */ byte[] $buffer$inlined;
    final /* synthetic */ BufferedSink $sink$inlined;
    final /* synthetic */ long $total$inlined;
    final /* synthetic */ Ref.LongRef $uploaded$inlined;
    final /* synthetic */ ProgressRequestBody this$0;

    ProgressRequestBody$writeTo$$inlined$use$lambda$1(ProgressRequestBody progressRequestBody, byte[] bArr, Ref.LongRef longRef, long j, BufferedSink bufferedSink) {
        this.this$0 = progressRequestBody;
        this.$buffer$inlined = bArr;
        this.$uploaded$inlined = longRef;
        this.$total$inlined = j;
        this.$sink$inlined = bufferedSink;
    }

    public final void run() {
        this.this$0.callback.onProgress((((long) 100) * this.$uploaded$inlined.element) / this.$total$inlined);
    }
}
