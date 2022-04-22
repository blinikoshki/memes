package p015io.getstream.chat.android.client.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/MapAdapter;", "Lcom/google/gson/TypeAdapter;", "", "delegateMapAdapter", "(Lcom/google/gson/TypeAdapter;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.MapAdapter */
/* compiled from: MapAdapter.kt */
public final class MapAdapter extends TypeAdapter<Map<?, ?>> {
    private final TypeAdapter<Map<?, ?>> delegateMapAdapter;

    public MapAdapter(TypeAdapter<Map<?, ?>> typeAdapter) {
        Intrinsics.checkNotNullParameter(typeAdapter, "delegateMapAdapter");
        this.delegateMapAdapter = typeAdapter;
    }

    public Map<?, ?> read(JsonReader jsonReader) {
        return this.delegateMapAdapter.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, Map<?, ?> map) {
        TypeAdapter<Map<?, ?>> typeAdapter = this.delegateMapAdapter;
        Map map2 = null;
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (next.getValue() == null) {
                    z = false;
                }
                if (z) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            Map map3 = linkedHashMap;
            if (!map3.isEmpty()) {
                map2 = map3;
            }
        }
        typeAdapter.write(jsonWriter, map2);
    }
}
