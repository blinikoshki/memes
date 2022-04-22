package editor.mediaselection.localmedia;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.CloseableKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tJI\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo26107d2 = {"Leditor/mediaselection/localmedia/MediaProvider;", "", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;)V", "fetchPhotos", "", "Leditor/mediaselection/localmedia/LocalMedia;", "limit", "", "fetchVideos", "queryContent", "queryUri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "queryImages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaProvider.kt */
public final class MediaProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final ContentResolver contentResolver;

    private MediaProvider(ContentResolver contentResolver2) {
        this.contentResolver = contentResolver2;
    }

    public /* synthetic */ MediaProvider(ContentResolver contentResolver2, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentResolver2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/mediaselection/localmedia/MediaProvider$Companion;", "", "()V", "from", "Leditor/mediaselection/localmedia/MediaProvider;", "context", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaProvider from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            return new MediaProvider(contentResolver, (DefaultConstructorMarker) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object queryImages(kotlin.coroutines.Continuation<? super java.util.List<editor.mediaselection.localmedia.LocalMedia>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof editor.mediaselection.localmedia.MediaProvider$queryImages$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            editor.mediaselection.localmedia.MediaProvider$queryImages$1 r0 = (editor.mediaselection.localmedia.MediaProvider$queryImages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            editor.mediaselection.localmedia.MediaProvider$queryImages$1 r0 = new editor.mediaselection.localmedia.MediaProvider$queryImages$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            editor.mediaselection.localmedia.MediaProvider$queryImages$2 r4 = new editor.mediaselection.localmedia.MediaProvider$queryImages$2
            r5 = 0
            r4.<init>(r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r7
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.localmedia.MediaProvider.queryImages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ List fetchPhotos$default(MediaProvider mediaProvider, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return mediaProvider.fetchPhotos(i);
    }

    public final List<LocalMedia> fetchPhotos(int i) {
        String str;
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.checkNotNullExpressionValue(contentUri, "MediaStore.Files.getContentUri(\"external\")");
        String[] strArr = {"_id", "date_added", MessengerShareContentUtility.MEDIA_TYPE, "mime_type", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "_data"};
        if (i > 0) {
            str = " LIMIT " + i + ' ';
        } else {
            str = "";
        }
        return queryContent(contentUri, strArr, "media_type=1", (String[]) null, "date_added DESC" + str);
    }

    public static /* synthetic */ List fetchVideos$default(MediaProvider mediaProvider, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return mediaProvider.fetchVideos(i);
    }

    public final List<LocalMedia> fetchVideos(int i) {
        String str;
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.checkNotNullExpressionValue(contentUri, "MediaStore.Files.getContentUri(\"external\")");
        String[] strArr = {"_id", "date_added", MessengerShareContentUtility.MEDIA_TYPE, "mime_type", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "_data"};
        if (i > 0) {
            str = " LIMIT " + i + ' ';
        } else {
            str = "";
        }
        return queryContent(contentUri, strArr, "media_type=3", (String[]) null, "date_added DESC" + str);
    }

    private final List<LocalMedia> queryContent(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Throwable th;
        boolean z;
        String str3;
        List<LocalMedia> arrayList = new ArrayList<>();
        Cursor query = this.contentResolver.query(uri, strArr, str, strArr2, str2);
        if (query != null) {
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
                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                    Cursor cursor2 = cursor;
                    Intrinsics.checkNotNullExpressionValue(string, "filePath");
                    boolean z2 = i == 1;
                    if (i == 3) {
                        str3 = string;
                        z = true;
                    } else {
                        str3 = string;
                        z = false;
                    }
                    arrayList.add(new LocalMedia(j, j2, str3, i, i2, z2, z, i3, i4));
                    cursor = cursor2;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, th2);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                CloseableKt.closeFinally(closeable, th);
                throw th4;
            }
        }
        return arrayList;
    }
}
