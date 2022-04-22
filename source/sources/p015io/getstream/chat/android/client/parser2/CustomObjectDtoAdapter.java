package p015io.getstream.chat.android.client.parser2;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 \u001b*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u001bB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J=\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0004¢\u0006\u0002\u0010\u0014JI\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u001a\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0004¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/CustomObjectDtoAdapter;", "Value", "", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "memberNames", "", "", "getMemberNames", "()Ljava/util/List;", "memberNames$delegate", "Lkotlin/Lazy;", "parseWithExtraData", "jsonReader", "Lcom/squareup/moshi/JsonReader;", "mapAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "valueAdapter", "(Lcom/squareup/moshi/JsonReader;Lcom/squareup/moshi/JsonAdapter;Lcom/squareup/moshi/JsonAdapter;)Ljava/lang/Object;", "serializeWithExtraData", "", "jsonWriter", "Lcom/squareup/moshi/JsonWriter;", "value", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;Lcom/squareup/moshi/JsonAdapter;Lcom/squareup/moshi/JsonAdapter;)V", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser2.CustomObjectDtoAdapter */
/* compiled from: CustomObjectDtoAdapter.kt */
public abstract class CustomObjectDtoAdapter<Value> {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String EXTRA_DATA = "extraData";
    /* access modifiers changed from: private */
    public final KClass<Value> kClass;
    private final Lazy memberNames$delegate = LazyKt.lazy(new CustomObjectDtoAdapter$memberNames$2(this));

    private final List<String> getMemberNames() {
        return (List) this.memberNames$delegate.getValue();
    }

    public CustomObjectDtoAdapter(KClass<Value> kClass2) {
        Intrinsics.checkNotNullParameter(kClass2, "kClass");
        this.kClass = kClass2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser2/CustomObjectDtoAdapter$Companion;", "", "()V", "EXTRA_DATA", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.parser2.CustomObjectDtoAdapter$Companion */
    /* compiled from: CustomObjectDtoAdapter.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Value parseWithExtraData(JsonReader jsonReader, JsonAdapter<Map<String, Object>> jsonAdapter, JsonAdapter<Value> jsonAdapter2) {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        Intrinsics.checkNotNullParameter(jsonAdapter, "mapAdapter");
        Intrinsics.checkNotNullParameter(jsonAdapter2, "valueAdapter");
        Map<String, Object> fromJson = jsonAdapter.fromJson(jsonReader);
        Intrinsics.checkNotNull(fromJson);
        Intrinsics.checkNotNullExpressionValue(fromJson, "mapAdapter.fromJson(jsonReader)!!");
        Map map = fromJson;
        Map linkedHashMap = new LinkedHashMap();
        Object obj = map.get(EXTRA_DATA);
        if (obj != null) {
            linkedHashMap.put(EXTRA_DATA, obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!getMemberNames().contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        map.put(EXTRA_DATA, linkedHashMap);
        Value fromJsonValue = jsonAdapter2.fromJsonValue(map);
        Intrinsics.checkNotNull(fromJsonValue);
        return fromJsonValue;
    }

    /* access modifiers changed from: protected */
    public final void serializeWithExtraData(JsonWriter jsonWriter, Value value, JsonAdapter<Map<String, Object>> jsonAdapter, JsonAdapter<Value> jsonAdapter2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        Intrinsics.checkNotNullParameter(jsonAdapter, "mapAdapter");
        Intrinsics.checkNotNullParameter(jsonAdapter2, "valueAdapter");
        if (value == null) {
            jsonWriter.nullValue();
            return;
        }
        Object jsonValue = jsonAdapter2.toJsonValue(value);
        Objects.requireNonNull(jsonValue, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
        Map asMutableMap = TypeIntrinsics.asMutableMap(jsonValue);
        Object obj = asMutableMap.get(EXTRA_DATA);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        asMutableMap.remove(EXTRA_DATA);
        asMutableMap.putAll((Map) obj);
        jsonAdapter.toJson(jsonWriter, asMutableMap);
    }
}
