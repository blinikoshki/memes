package com.giphy.sdk.core.models.json;

import com.google.gson.JsonDeserializer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/json/DateDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Ljava/util/Date;", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "dateFormatStories", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: DateDeserializer.kt */
public final class DateDeserializer implements JsonDeserializer<Date> {
    private final SimpleDateFormat dateFormat;
    private final SimpleDateFormat dateFormatStories;

    public DateDeserializer() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        this.dateFormat = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        this.dateFormatStories = simpleDateFormat2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r5 = r2.dateFormatStories;
        r3 = r3.getAsJsonPrimitive();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "json.asJsonPrimitive");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r5.parse(r3.getAsString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date deserialize(com.google.gson.JsonElement r3, java.lang.reflect.Type r4, com.google.gson.JsonDeserializationContext r5) throws com.google.gson.JsonParseException {
        /*
            r2 = this;
            java.lang.String r0 = "json.asJsonPrimitive"
            java.lang.String r1 = "json"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r1)
            java.lang.String r1 = "typeOfT"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r1)
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r4)
            r4 = 0
            java.util.Date r4 = (java.util.Date) r4
            java.text.SimpleDateFormat r5 = r2.dateFormat     // Catch:{ Exception -> 0x0027 }
            com.google.gson.JsonPrimitive r1 = r3.getAsJsonPrimitive()     // Catch:{ Exception -> 0x0027 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x0027 }
            java.util.Date r4 = r5.parse(r1)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0038
        L_0x0027:
            java.text.SimpleDateFormat r5 = r2.dateFormatStories     // Catch:{ Exception -> 0x0038 }
            com.google.gson.JsonPrimitive r3 = r3.getAsJsonPrimitive()     // Catch:{ Exception -> 0x0038 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x0038 }
            java.util.Date r4 = r5.parse(r3)     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.models.json.DateDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):java.util.Date");
    }
}
