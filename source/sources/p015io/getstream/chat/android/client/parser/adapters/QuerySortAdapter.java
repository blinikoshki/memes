package p015io.getstream.chat.android.client.parser.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/adapters/QuerySortAdapter;", "Lcom/google/gson/TypeAdapter;", "Lio/getstream/chat/android/client/api/models/QuerySort;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.adapters.QuerySortAdapter */
/* compiled from: QuerySortAdapter.kt */
public final class QuerySortAdapter extends TypeAdapter<QuerySort<?>> {
    private final Gson gson;

    public QuerySortAdapter(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    public void write(JsonWriter jsonWriter, QuerySort<?> querySort) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        TypeAdapter<ArrayList> adapter = this.gson.getAdapter(ArrayList.class);
        ArrayList arrayList = null;
        List<Map<String, Object>> dto = querySort != null ? querySort.toDto() : null;
        if (dto instanceof ArrayList) {
            arrayList = dto;
        }
        adapter.write(jsonWriter, arrayList);
    }

    public QuerySort<?> read(JsonReader jsonReader) {
        throw new IOException("QuerySort must not be deserialized");
    }
}
