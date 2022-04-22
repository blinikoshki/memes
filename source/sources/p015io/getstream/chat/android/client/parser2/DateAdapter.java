package p015io.getstream.chat.android.client.parser2;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import p015io.getstream.chat.android.client.utils.ThreadLocalDelegateKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/DateAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/util/Date;", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lkotlin/properties/ReadOnlyProperty;", "dateFormatWithoutNanoseconds", "getDateFormatWithoutNanoseconds", "dateFormatWithoutNanoseconds$delegate", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.DateAdapter */
/* compiled from: DateAdapter.kt */
public final class DateAdapter extends JsonAdapter<Date> {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String DATE_FORMAT_WITHOUT_NANOSECONDS = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private final ReadOnlyProperty dateFormat$delegate = ThreadLocalDelegateKt.threadLocal(DateAdapter$dateFormat$2.INSTANCE);
    private final ReadOnlyProperty dateFormatWithoutNanoseconds$delegate = ThreadLocalDelegateKt.threadLocal(DateAdapter$dateFormatWithoutNanoseconds$2.INSTANCE);

    static {
        Class<DateAdapter> cls = DateAdapter.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "dateFormat", "getDateFormat()Ljava/text/SimpleDateFormat;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "dateFormatWithoutNanoseconds", "getDateFormatWithoutNanoseconds()Ljava/text/SimpleDateFormat;", 0))};
    }

    private final SimpleDateFormat getDateFormat() {
        return (SimpleDateFormat) this.dateFormat$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final SimpleDateFormat getDateFormatWithoutNanoseconds() {
        return (SimpleDateFormat) this.dateFormatWithoutNanoseconds$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/DateAdapter$Companion;", "", "()V", "DATE_FORMAT", "", "DATE_FORMAT_WITHOUT_NANOSECONDS", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.parser2.DateAdapter$Companion */
    /* compiled from: DateAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void toJson(JsonWriter jsonWriter, Date date) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(getDateFormat().format(date));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return getDateFormatWithoutNanoseconds().parse(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date fromJson(com.squareup.moshi.JsonReader r4) {
        /*
            r3 = this;
            java.lang.String r0 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.squareup.moshi.JsonReader$Token r0 = r4.peek()
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NULL
            r2 = 0
            if (r0 != r1) goto L_0x0012
            r4.skipValue()
            return r2
        L_0x0012:
            java.lang.String r4 = r4.nextString()
            java.lang.String r0 = "rawValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 == 0) goto L_0x002a
            goto L_0x003c
        L_0x002a:
            java.text.SimpleDateFormat r0 = r3.getDateFormat()     // Catch:{ all -> 0x0034 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ all -> 0x0034 }
            r2 = r4
            goto L_0x003c
        L_0x0034:
            java.text.SimpleDateFormat r0 = r3.getDateFormatWithoutNanoseconds()     // Catch:{ all -> 0x003c }
            java.util.Date r2 = r0.parse(r4)     // Catch:{ all -> 0x003c }
        L_0x003c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.parser2.DateAdapter.fromJson(com.squareup.moshi.JsonReader):java.util.Date");
    }
}
