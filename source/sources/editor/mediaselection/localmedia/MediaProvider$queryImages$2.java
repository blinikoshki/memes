package editor.mediaselection.localmedia;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.CloseableKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.mediaselection.localmedia.MediaProvider$queryImages$2", mo26808f = "MediaProvider.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: MediaProvider.kt */
final class MediaProvider$queryImages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $liteMediaContents;
    int label;
    final /* synthetic */ MediaProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaProvider$queryImages$2(MediaProvider mediaProvider, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaProvider;
        this.$liteMediaContents = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MediaProvider$queryImages$2(this.this$0, this.$liteMediaContents, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MediaProvider$queryImages$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String[] strArr = {"_id", "date_added", MessengerShareContentUtility.MEDIA_TYPE, "mime_type", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "_data"};
            Uri contentUri = MediaStore.Files.getContentUri("external");
            Intrinsics.checkNotNullExpressionValue(contentUri, "MediaStore.Files.getContentUri(\"external\")");
            String[] strArr2 = {"_data"};
            Cursor query = this.this$0.contentResolver.query(contentUri, strArr, "media_type=1 OR media_type=3", (String[]) null, "date_added DESC");
            if (query == null) {
                return null;
            }
            Closeable closeable = query;
            Throwable th2 = null;
            try {
                Cursor cursor = (Cursor) closeable;
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("date_added");
                int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(MessengerShareContentUtility.MEDIA_TYPE);
                int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("mime_type");
                int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                while (cursor.moveToNext()) {
                    long j = cursor.getLong(columnIndexOrThrow);
                    long j2 = cursor.getLong(columnIndexOrThrow2);
                    int i = cursor.getInt(columnIndexOrThrow3);
                    int i2 = cursor.getInt(columnIndexOrThrow4);
                    int i3 = cursor.getInt(columnIndexOrThrow5);
                    int i4 = cursor.getInt(columnIndexOrThrow6);
                    ContentUris.withAppendedId(contentUri, j);
                    Uri uri = contentUri;
                    String string = cursor.getString(cursor.getColumnIndex(strArr2[0]));
                    String[] strArr3 = strArr2;
                    Intrinsics.checkNotNullExpressionValue(string, "filePath");
                    this.$liteMediaContents.add(new LocalMedia(j, j2, string, i, i2, i == 1, i == 3, i3, i4));
                    contentUri = uri;
                    strArr2 = strArr3;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, th2);
                return unit;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                CloseableKt.closeFinally(closeable, th);
                throw th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
