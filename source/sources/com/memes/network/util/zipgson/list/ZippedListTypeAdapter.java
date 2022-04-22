package com.memes.network.util.zipgson.list;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u001e\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/network/util/zipgson/list/ZippedListTypeAdapter;", "T1", "T2", "Lcom/google/gson/TypeAdapter;", "Lcom/memes/network/util/zipgson/list/ZippedList;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "mergeInto", "Lcom/google/gson/JsonElement;", "e1", "e2", "Lcom/google/gson/JsonObject;", "jsonNull1", "Lcom/google/gson/JsonNull;", "jsonObject2", "jsonObject1", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "zippedList", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ZippedListTypeAdapter.kt */
public final class ZippedListTypeAdapter<T1, T2> extends TypeAdapter<ZippedList<T1, T2>> {
    private final Gson gson;

    private final JsonObject mergeInto(JsonNull jsonNull, JsonObject jsonObject) {
        return jsonObject;
    }

    public ZippedListTypeAdapter(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    public void write(JsonWriter jsonWriter, ZippedList<T1, T2> zippedList) {
        if (jsonWriter != null && zippedList != null) {
            jsonWriter.beginArray();
            Iterator<T1> it = zippedList.getList1().iterator();
            Iterator<T2> it2 = zippedList.getList2().iterator();
            while (true) {
                if (it.hasNext() || it2.hasNext()) {
                    T2 t2 = null;
                    T1 next = it.hasNext() ? it.next() : null;
                    if (it2.hasNext()) {
                        t2 = it2.next();
                    }
                    JsonElement jsonTree = this.gson.toJsonTree(next);
                    Intrinsics.checkNotNullExpressionValue(jsonTree, "gson.toJsonTree(i1)");
                    JsonElement jsonTree2 = this.gson.toJsonTree(t2);
                    Intrinsics.checkNotNullExpressionValue(jsonTree2, "gson.toJsonTree(i2)");
                    this.gson.toJson(mergeInto(jsonTree, jsonTree2), jsonWriter);
                } else {
                    jsonWriter.endArray();
                    return;
                }
            }
        }
    }

    public ZippedList<T1, T2> read(JsonReader jsonReader) {
        throw new UnsupportedOperationException();
    }

    private final JsonElement mergeInto(JsonElement jsonElement, JsonElement jsonElement2) {
        if (jsonElement.isJsonNull()) {
            if (jsonElement2.isJsonObject()) {
                JsonNull asJsonNull = jsonElement.getAsJsonNull();
                Intrinsics.checkNotNullExpressionValue(asJsonNull, "e1.asJsonNull");
                JsonObject asJsonObject = jsonElement2.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject, "e2.asJsonObject");
                return mergeInto(asJsonNull, asJsonObject);
            }
            throw new AssertionError("TODO: " + jsonElement2.getClass());
        } else if (!jsonElement.isJsonObject()) {
            throw new AssertionError("TODO: " + jsonElement.getClass());
        } else if (jsonElement2.isJsonObject()) {
            JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject2, "e1.asJsonObject");
            JsonObject asJsonObject3 = jsonElement2.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject3, "e2.asJsonObject");
            return mergeInto(asJsonObject2, asJsonObject3);
        } else {
            throw new AssertionError("TODO: " + jsonElement2.getClass());
        }
    }

    private final JsonObject mergeInto(JsonObject jsonObject, JsonObject jsonObject2) {
        for (Map.Entry next : jsonObject2.entrySet()) {
            jsonObject.add((String) next.getKey(), (JsonElement) next.getValue());
        }
        return jsonObject;
    }
}
