package com.snapchat.kit.sdk.core.metrics.p043b;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.snapchat.kit.sdk.core.metrics.C4426c;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* renamed from: com.snapchat.kit.sdk.core.metrics.b.a */
public final class C4414a {

    /* renamed from: a */
    private static final Type f1162a = new TypeToken<List<C4426c<String>>>() {
    }.getType();

    /* renamed from: b */
    private final Gson f1163b;

    @Inject
    C4414a(Gson gson) {
        this.f1163b = gson;
    }

    /* renamed from: a */
    public final <T extends Message> String mo61350a(List<C4426c<T>> list) {
        try {
            return this.f1163b.toJson((Object) m864b(list), f1162a);
        } catch (JsonParseException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final <T extends Message> List<C4426c<T>> mo61351a(ProtoAdapter<T> protoAdapter, String str) {
        try {
            List list = (List) this.f1163b.fromJson(str, f1162a);
            if (list == null) {
                return null;
            }
            return m863a(protoAdapter, (List<C4426c<String>>) list);
        } catch (JsonParseException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static <T extends Message> List<C4426c<T>> m863a(ProtoAdapter<T> protoAdapter, List<C4426c<String>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C4426c next : list) {
            String str = (String) next.mo61362c();
            if (str != null) {
                try {
                    arrayList.add(new C4426c((Message) protoAdapter.decode(Base64.decode(str, 0)), next.mo61361b()));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static <T extends Message> List<C4426c<String>> m864b(List<C4426c<T>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C4426c next : list) {
            try {
                arrayList.add(new C4426c(Base64.encodeToString(((Message) next.mo61362c()).encode(), 0), next.mo61361b()));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }
}
