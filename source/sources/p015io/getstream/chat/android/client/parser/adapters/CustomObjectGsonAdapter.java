package p015io.getstream.chat.android.client.parser.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.errors.ChatParsingError;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.IgnoreDeserialisation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/adapters/CustomObjectGsonAdapter;", "Lcom/google/gson/TypeAdapter;", "Lio/getstream/chat/android/client/models/CustomObject;", "gson", "Lcom/google/gson/Gson;", "clazz", "Ljava/lang/Class;", "(Lcom/google/gson/Gson;Ljava/lang/Class;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "setFieldOrError", "", "field", "Ljava/lang/reflect/Field;", "obj", "", "value", "name", "", "setFieldSafe", "", "tryToRestoreNullValue", "write", "writer", "Lcom/google/gson/stream/JsonWriter;", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.adapters.CustomObjectGsonAdapter */
/* compiled from: CustomObjectGsonAdapter.kt */
public final class CustomObjectGsonAdapter extends TypeAdapter<CustomObject> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TaggedLogger logger = ChatLogger.Companion.get("CustomObjectAdapter");
    private final Class<?> clazz;
    private final Gson gson;

    public CustomObjectGsonAdapter(Gson gson2, Class<?> cls) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.gson = gson2;
        this.clazz = cls;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/adapters/CustomObjectGsonAdapter$Companion;", "", "()V", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "getLogger", "()Lio/getstream/chat/android/client/logger/TaggedLogger;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.parser.adapters.CustomObjectGsonAdapter$Companion */
    /* compiled from: CustomObjectGsonAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TaggedLogger getLogger() {
            return CustomObjectGsonAdapter.logger;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:12|(1:14)|15|16|17|18|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.google.gson.stream.JsonWriter r8, p015io.getstream.chat.android.client.models.CustomObject r9) {
        /*
            r7 = this;
            java.lang.String r0 = "writer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r9 != 0) goto L_0x0015
            com.google.gson.Gson r9 = r7.gson     // Catch:{ all -> 0x009a }
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            com.google.gson.TypeAdapter r9 = r9.getAdapter(r0)     // Catch:{ all -> 0x009a }
            r0 = 0
            r9.write(r8, r0)     // Catch:{ all -> 0x009a }
            goto L_0x0099
        L_0x0015:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x009a }
            r0.<init>()     // Catch:{ all -> 0x009a }
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x009a }
            java.util.Map r2 = r9.getExtraData()     // Catch:{ all -> 0x009a }
            r1.putAll(r2)     // Catch:{ all -> 0x009a }
            java.lang.Class<?> r1 = r7.clazz     // Catch:{ all -> 0x009a }
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch:{ all -> 0x009a }
            int r2 = r1.length     // Catch:{ all -> 0x009a }
            r3 = 0
        L_0x002c:
            if (r3 >= r2) goto L_0x008e
            r4 = r1[r3]     // Catch:{ all -> 0x009a }
            java.lang.String r5 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x009a }
            boolean r5 = r4.isSynthetic()     // Catch:{ all -> 0x009a }
            if (r5 == 0) goto L_0x003c
            goto L_0x006a
        L_0x003c:
            java.lang.Class<io.getstream.chat.android.client.parser.IgnoreSerialisation> r5 = p015io.getstream.chat.android.client.parser.IgnoreSerialisation.class
            java.lang.annotation.Annotation r5 = r4.getAnnotation(r5)     // Catch:{ all -> 0x009a }
            if (r5 == 0) goto L_0x0045
            goto L_0x006a
        L_0x0045:
            r5 = 1
            r4.setAccessible(r5)     // Catch:{ all -> 0x009a }
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x009a }
            java.lang.String r6 = "field.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x009a }
            java.lang.Class<com.google.gson.annotations.SerializedName> r6 = com.google.gson.annotations.SerializedName.class
            java.lang.annotation.Annotation r6 = r4.getAnnotation(r6)     // Catch:{ all -> 0x009a }
            com.google.gson.annotations.SerializedName r6 = (com.google.gson.annotations.SerializedName) r6     // Catch:{ all -> 0x009a }
            if (r6 == 0) goto L_0x0060
            java.lang.String r5 = r6.value()     // Catch:{ all -> 0x009a }
        L_0x0060:
            java.lang.Object r4 = r4.get(r9)     // Catch:{ all -> 0x009a }
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x006d }
            r6.put(r5, r4)     // Catch:{ Exception -> 0x006d }
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x002c
        L_0x006d:
            io.getstream.chat.android.client.errors.ChatParsingError r8 = new io.getstream.chat.android.client.errors.ChatParsingError     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r9.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "unable to set field "
            r9.append(r0)     // Catch:{ all -> 0x009a }
            r9.append(r5)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = " with value "
            r9.append(r0)     // Catch:{ all -> 0x009a }
            r9.append(r4)     // Catch:{ all -> 0x009a }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x009a }
            r8.<init>(r9)     // Catch:{ all -> 0x009a }
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x009a }
            throw r8     // Catch:{ all -> 0x009a }
        L_0x008e:
            com.google.gson.Gson r9 = r7.gson     // Catch:{ all -> 0x009a }
            java.lang.Class<java.util.HashMap> r1 = java.util.HashMap.class
            com.google.gson.TypeAdapter r9 = r9.getAdapter(r1)     // Catch:{ all -> 0x009a }
            r9.write(r8, r0)     // Catch:{ all -> 0x009a }
        L_0x0099:
            return
        L_0x009a:
            r8 = move-exception
            io.getstream.chat.android.client.errors.ChatParsingError r9 = new io.getstream.chat.android.client.errors.ChatParsingError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "custom object serialisation error of "
            r0.append(r1)
            java.lang.Class<?> r1 = r7.clazz
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0, r8)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.parser.adapters.CustomObjectGsonAdapter.write(com.google.gson.stream.JsonWriter, io.getstream.chat.android.client.models.CustomObject):void");
    }

    public CustomObject read(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        try {
            Object newInstance = this.clazz.newInstance();
            if (newInstance != null) {
                CustomObject customObject = (CustomObject) newInstance;
                HashMap read = this.gson.getAdapter(HashMap.class).read(jsonReader);
                if (read == null) {
                    logger.logE("exception case when api returned null where it shouldn't: " + jsonReader);
                    return null;
                }
                for (Field field : this.clazz.getDeclaredFields()) {
                    Intrinsics.checkNotNullExpressionValue(field, QuerySort.KEY_FIELD_NAME);
                    if (!field.isSynthetic()) {
                        if (field.getAnnotation(IgnoreDeserialisation.class) == null) {
                            String name = field.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "field.name");
                            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                            if (serializedName != null) {
                                name = serializedName.value();
                            }
                            if (read.containsKey(name)) {
                                field.setAccessible(true);
                                Object fromJson = this.gson.getAdapter(TypeToken.get(field.getGenericType())).fromJson(this.gson.toJson(read.remove(name)));
                                if (fromJson != null) {
                                    setFieldOrError(field, customObject, fromJson, name);
                                } else if (!tryToRestoreNullValue(field, customObject)) {
                                    setFieldOrError(field, customObject, (Object) null, name);
                                }
                            }
                        }
                    }
                }
                customObject.setExtraData(read);
                return customObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.getstream.chat.android.client.models.CustomObject");
        } catch (Throwable th) {
            throw new ChatParsingError("custom object deserialisation error of " + this.clazz, th);
        }
    }

    private final void setFieldOrError(Field field, Object obj, Object obj2, String str) {
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            throw new ChatParsingError("unable to set field " + str + " with value " + obj2);
        }
    }

    private final boolean tryToRestoreNullValue(Field field, Object obj) {
        Class<?> type = field.getType();
        if (Intrinsics.areEqual((Object) type, (Object) List.class)) {
            return setFieldSafe(field, obj, new ArrayList());
        }
        if (Intrinsics.areEqual((Object) type, (Object) Map.class)) {
            return setFieldSafe(field, obj, new LinkedHashMap());
        }
        if (Intrinsics.areEqual((Object) type, (Object) Integer.TYPE)) {
            return setFieldSafe(field, obj, 0);
        }
        if (Intrinsics.areEqual((Object) type, (Object) Boolean.TYPE)) {
            return setFieldSafe(field, obj, false);
        }
        if (Intrinsics.areEqual((Object) type, (Object) Float.TYPE)) {
            return setFieldSafe(field, obj, Float.valueOf(0.0f));
        }
        if (Intrinsics.areEqual((Object) type, (Object) String.class)) {
            return setFieldSafe(field, obj, "");
        }
        return false;
    }

    private final boolean setFieldSafe(Field field, Object obj, Object obj2) {
        try {
            field.set(obj, obj2);
            return true;
        } catch (Throwable unused) {
            TaggedLogger taggedLogger = logger;
            taggedLogger.logE("unable to set field " + field.getName() + " with value " + obj2);
            return false;
        }
    }
}
