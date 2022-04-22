package com.giphy.sdk.core.models.json;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J'\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/core/models/json/IntDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Integer;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: IntDeserializer.kt */
public final class IntDeserializer implements JsonDeserializer<Integer> {
    public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Intrinsics.checkParameterIsNotNull(jsonElement, "json");
        Intrinsics.checkParameterIsNotNull(type, "typeOfT");
        Intrinsics.checkParameterIsNotNull(jsonDeserializationContext, "context");
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        Intrinsics.checkExpressionValueIsNotNull(asJsonPrimitive, "jsonPrimitive");
        if (asJsonPrimitive.isString()) {
            String asString = jsonElement.getAsString();
            if (TextUtils.isEmpty(asString)) {
                return 0;
            }
            return Integer.valueOf(Integer.parseInt(asString));
        } else if (asJsonPrimitive.isNumber()) {
            return Integer.valueOf(jsonElement.getAsInt());
        } else {
            return 0;
        }
    }
}
