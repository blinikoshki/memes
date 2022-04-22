package com.memes.network.util.zipgson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.memes.network.util.zipgson.list.ZippedListTypeAdapterFactory;
import com.memes.network.util.zipgson.object.ZippedObjectTypeAdapterFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ZipGsonTest.kt */
final class ZipGsonTest$gson$2 extends Lambda implements Function0<Gson> {
    public static final ZipGsonTest$gson$2 INSTANCE = new ZipGsonTest$gson$2();

    ZipGsonTest$gson$2() {
        super(0);
    }

    public final Gson invoke() {
        return new GsonBuilder().registerTypeAdapterFactory(new ZippedObjectTypeAdapterFactory()).registerTypeAdapterFactory(new ZippedListTypeAdapterFactory()).create();
    }
}
