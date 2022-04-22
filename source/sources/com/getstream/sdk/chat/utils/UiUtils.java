package com.getstream.sdk.chat.utils;

import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.model.ModelType;
import com.google.android.exoplayer2.util.MimeTypes;
import com.memes.plus.p040ui.posts.post_basics.post_like.PostLikeType;
import java.text.DecimalFormat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/UiUtils;", "", "()V", "fileSizeFormat", "Ljava/text/DecimalFormat;", "fileSizeUnits", "", "", "[Ljava/lang/String;", "mimeTypesToIconResMap", "", "", "reactionTypeToSymbolMap", "getFileSizeHumanized", "fileSize", "getIcon", "mimeType", "getReactionTypes", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UiUtils.kt */
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();
    private static final DecimalFormat fileSizeFormat = new DecimalFormat("#,##0.#");
    private static final String[] fileSizeUnits = {"B", "KB", "MB", "GB", "TB"};
    private static final Map<String, Integer> mimeTypesToIconResMap = MapsKt.mapOf(TuplesKt.m181to(ModelType.attach_mime_pdf, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_pdf)), TuplesKt.m181to(ModelType.attach_mime_csv, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_csv)), TuplesKt.m181to(ModelType.attach_mime_tar, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_tar)), TuplesKt.m181to(ModelType.attach_mime_zip, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_zip)), TuplesKt.m181to(ModelType.attach_mime_doc, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_doc)), TuplesKt.m181to(ModelType.attach_mime_xls, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_xls)), TuplesKt.m181to(ModelType.attach_mime_ppt, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_ppt)), TuplesKt.m181to(ModelType.attach_mime_mov, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_mov)), TuplesKt.m181to("video/mp4", Integer.valueOf(C1673R.C1676drawable.stream_ic_file_mov)), TuplesKt.m181to(ModelType.attach_mime_m4a, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_mp3)), TuplesKt.m181to(ModelType.attach_mime_mp3, Integer.valueOf(C1673R.C1676drawable.stream_ic_file_mp3)));
    private static final Map<String, String> reactionTypeToSymbolMap = MapsKt.mapOf(TuplesKt.m181to(PostLikeType.LIKE, "👍"), TuplesKt.m181to("love", "❤️"), TuplesKt.m181to("haha", "😂"), TuplesKt.m181to("wow", "😲"), TuplesKt.m181to("sad", "🙁"), TuplesKt.m181to("angry", "😡"));

    private UiUtils() {
    }

    public final int getIcon(String str) {
        if (str == null) {
            return C1673R.C1676drawable.stream_ic_file;
        }
        Integer num = mimeTypesToIconResMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) MimeTypes.BASE_TYPE_AUDIO, false, 2, (Object) null)) {
            return C1673R.C1676drawable.stream_ic_file_mp3;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "video", false, 2, (Object) null)) {
            return C1673R.C1676drawable.stream_ic_file_mov;
        }
        return C1673R.C1676drawable.stream_ic_file;
    }

    @JvmStatic
    public static final Map<String, String> getReactionTypes() {
        return reactionTypeToSymbolMap;
    }

    public final String getFileSizeHumanized(int i) {
        if (i <= 0) {
            return "0";
        }
        double d = (double) i;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        String format = fileSizeFormat.format(d / Math.pow(1024.0d, (double) log10));
        String str = fileSizeUnits[log10];
        return format + ' ' + str;
    }
}
