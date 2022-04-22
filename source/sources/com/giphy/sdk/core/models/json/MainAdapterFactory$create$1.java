package com.giphy.sdk.core.models.json;

import com.giphy.sdk.core.models.Media;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo26107d2 = {"com/giphy/sdk/core/models/json/MainAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: MainAdapterFactory.kt */
public final class MainAdapterFactory$create$1 extends TypeAdapter<T> {
    final /* synthetic */ TypeAdapter $delegateAdapter;

    MainAdapterFactory$create$1(TypeAdapter typeAdapter) {
        this.$delegateAdapter = typeAdapter;
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonWriter, "out");
        this.$delegateAdapter.write(jsonWriter, t);
    }

    public T read(JsonReader jsonReader) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonReader, "in");
        T read = this.$delegateAdapter.read(jsonReader);
        if (read instanceof Media) {
            ((Media) read).postProcess();
        }
        return read;
    }
}
