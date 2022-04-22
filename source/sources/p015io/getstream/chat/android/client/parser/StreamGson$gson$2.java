package p015io.getstream.chat.android.client.parser;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.StreamGson$gson$2 */
/* compiled from: StreamGson.kt */
final class StreamGson$gson$2 extends Lambda implements Function0<Gson> {
    public static final StreamGson$gson$2 INSTANCE = new StreamGson$gson$2();

    StreamGson$gson$2() {
        super(0);
    }

    public final Gson invoke() {
        return new GsonBuilder().registerTypeAdapterFactory(new TypeAdapterFactory()).addSerializationExclusionStrategy(new ExclusionStrategy() {
            public boolean shouldSkipClass(Class<?> cls) {
                Intrinsics.checkNotNullParameter(cls, "clazz");
                return false;
            }

            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                Intrinsics.checkNotNullParameter(fieldAttributes, "f");
                return fieldAttributes.getAnnotation(IgnoreSerialisation.class) != null;
            }
        }).addDeserializationExclusionStrategy(new ExclusionStrategy() {
            public boolean shouldSkipClass(Class<?> cls) {
                Intrinsics.checkNotNullParameter(cls, "clazz");
                return false;
            }

            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                Intrinsics.checkNotNullParameter(fieldAttributes, "f");
                return fieldAttributes.getAnnotation(IgnoreDeserialisation.class) != null;
            }
        }).create();
    }
}
