package p015io.getstream.chat.android.client.parser2;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.DateAdapter$dateFormatWithoutNanoseconds$2 */
/* compiled from: DateAdapter.kt */
final class DateAdapter$dateFormatWithoutNanoseconds$2 extends Lambda implements Function0<SimpleDateFormat> {
    public static final DateAdapter$dateFormatWithoutNanoseconds$2 INSTANCE = new DateAdapter$dateFormatWithoutNanoseconds$2();

    DateAdapter$dateFormatWithoutNanoseconds$2() {
        super(0);
    }

    public final SimpleDateFormat invoke() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }
}
