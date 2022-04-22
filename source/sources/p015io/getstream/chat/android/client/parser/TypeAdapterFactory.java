package p015io.getstream.chat.android.client.parser;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.adapters.CustomObjectGsonAdapter;
import p015io.getstream.chat.android.client.parser.adapters.QuerySortAdapter;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/TypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.TypeAdapterFactory */
/* compiled from: TypeAdapterFactory.kt */
public final class TypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "type");
        Class<? super T> rawType = typeToken.getRawType();
        Intrinsics.checkNotNullExpressionValue(rawType, "type.rawType");
        Class[] interfaces = rawType.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "type.rawType.interfaces");
        if (ArraysKt.contains((T[]) interfaces, CustomObject.class)) {
            Class<? super T> rawType2 = typeToken.getRawType();
            Intrinsics.checkNotNullExpressionValue(rawType2, "type.rawType");
            return new CustomObjectGsonAdapter(gson, rawType2);
        }
        Class<? super T> rawType3 = typeToken.getRawType();
        Intrinsics.checkNotNullExpressionValue(rawType3, "type.rawType");
        if (TypeAdapterFactoryKt.getAllInterfaces(rawType3).contains(Map.class)) {
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, typeToken);
            Objects.requireNonNull(delegateAdapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<kotlin.collections.Map<*, *>>");
            return new MapAdapter(delegateAdapter);
        }
        Class<? super T> rawType4 = typeToken.getRawType();
        if (Intrinsics.areEqual((Object) rawType4, (Object) ChatEvent.class)) {
            TypeAdapter<T> delegateAdapter2 = gson.getDelegateAdapter(this, typeToken);
            Objects.requireNonNull(delegateAdapter2, "null cannot be cast to non-null type com.google.gson.TypeAdapter<io.getstream.chat.android.client.events.ChatEvent>");
            return new EventAdapter(gson, delegateAdapter2);
        } else if (Intrinsics.areEqual((Object) rawType4, (Object) Date.class)) {
            return new DateAdapter();
        } else {
            if (Intrinsics.areEqual((Object) rawType4, (Object) FilterObject.class)) {
                return new FilterObjectAdapter(gson);
            }
            if (Intrinsics.areEqual((Object) rawType4, (Object) QuerySortAdapter.class)) {
                return new QuerySortAdapter(gson);
            }
            return null;
        }
    }
}
