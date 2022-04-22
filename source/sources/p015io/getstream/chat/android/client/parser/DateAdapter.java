package p015io.getstream.chat.android.client.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import p015io.getstream.chat.android.client.utils.ThreadLocalDelegateKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/DateAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lkotlin/properties/ReadOnlyProperty;", "dateFormatWithoutNanoseconds", "getDateFormatWithoutNanoseconds", "dateFormatWithoutNanoseconds$delegate", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.DateAdapter */
/* compiled from: DateAdapter.kt */
public final class DateAdapter extends TypeAdapter<Date> {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
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

    public void write(JsonWriter jsonWriter, Date date) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(getDateFormat().format(date));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = getDateFormatWithoutNanoseconds().parse(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date read(com.google.gson.stream.JsonReader r3) {
        /*
            r2 = this;
            java.lang.String r0 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            java.lang.String r3 = r3.nextString()     // Catch:{ all -> 0x002f }
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0018
            int r1 = r1.length()     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            if (r1 == 0) goto L_0x001c
            goto L_0x002f
        L_0x001c:
            java.text.SimpleDateFormat r1 = r2.getDateFormat()     // Catch:{ all -> 0x0025 }
            java.util.Date r3 = r1.parse(r3)     // Catch:{ all -> 0x0025 }
            goto L_0x002e
        L_0x0025:
            java.text.SimpleDateFormat r1 = r2.getDateFormatWithoutNanoseconds()     // Catch:{ all -> 0x002d }
            java.util.Date r0 = r1.parse(r3)     // Catch:{ all -> 0x002d }
        L_0x002d:
            r3 = r0
        L_0x002e:
            r0 = r3
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.parser.DateAdapter.read(com.google.gson.stream.JsonReader):java.util.Date");
    }
}
