package com.memes.plus.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J+\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ+\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/util/BooleanIntPropertyConverter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Boolean;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "(Ljava/lang/Boolean;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BooleanIntPropertyConverter.kt */
public final class BooleanIntPropertyConverter implements JsonSerializer<Boolean>, JsonDeserializer<Boolean> {
    public JsonElement serialize(Boolean bool, Type type, JsonSerializationContext jsonSerializationContext) {
        if (bool == null) {
            return new JsonPrimitive((Number) 0);
        }
        return new JsonPrimitive((Number) Integer.valueOf(bool.booleanValue() ? 1 : 0));
    }

    public Boolean deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        boolean z = false;
        if (jsonElement == null) {
            return false;
        }
        String asString = jsonElement.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "json");
        if (StringsKt.isBlank(asString)) {
            return false;
        }
        Integer intOrNull = StringsKt.toIntOrNull(asString);
        if (intOrNull != null && intOrNull.intValue() == 1) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
