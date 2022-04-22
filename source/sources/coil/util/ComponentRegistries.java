package coil.util;

import coil.ComponentRegistry;
import coil.decode.Decoder;
import coil.map.Mapper;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a5\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\b\b\u0000\u0010\u0006*\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, mo26107d2 = {"mapData", "", "Lcoil/ComponentRegistry;", "data", "requireDecoder", "Lcoil/decode/Decoder;", "T", "source", "Lokio/BufferedSource;", "mimeType", "", "(Lcoil/ComponentRegistry;Ljava/lang/Object;Lokio/BufferedSource;Ljava/lang/String;)Lcoil/decode/Decoder;", "requireFetcher", "Lcoil/fetch/Fetcher;", "(Lcoil/ComponentRegistry;Ljava/lang/Object;)Lcoil/fetch/Fetcher;", "coil-base_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* renamed from: coil.util.-ComponentRegistries  reason: invalid class name */
/* compiled from: ComponentRegistries.kt */
public final class ComponentRegistries {
    public static final Object mapData(ComponentRegistry componentRegistry, Object obj) {
        Intrinsics.checkNotNullParameter(componentRegistry, "$this$mapData");
        Intrinsics.checkNotNullParameter(obj, "data");
        List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers$coil_base_release = componentRegistry.getMappers$coil_base_release();
        int size = mappers$coil_base_release.size();
        for (int i = 0; i < size; i++) {
            Pair pair = mappers$coil_base_release.get(i);
            Mapper mapper = (Mapper) pair.component1();
            if (((Class) pair.component2()).isAssignableFrom(obj.getClass())) {
                Objects.requireNonNull(mapper, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                if (mapper.handles(obj)) {
                    obj = mapper.map(obj);
                }
            }
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[EDGE_INSN: B:17:0x004b->B:11:0x004b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0047 A[LOOP:0: B:1:0x0017->B:9:0x0047, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> coil.fetch.Fetcher<T> requireFetcher(coil.ComponentRegistry r7, T r8) {
        /*
            java.lang.String r0 = "$this$requireFetcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.List r7 = r7.getFetchers$coil_base_release()
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x0017:
            if (r2 >= r0) goto L_0x004a
            java.lang.Object r3 = r7.get(r2)
            r4 = r3
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r5 = r4.component1()
            coil.fetch.Fetcher r5 = (coil.fetch.Fetcher) r5
            java.lang.Object r4 = r4.component2()
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Class r6 = r8.getClass()
            boolean r4 = r4.isAssignableFrom(r6)
            if (r4 == 0) goto L_0x0043
            java.lang.String r4 = "null cannot be cast to non-null type coil.fetch.Fetcher<kotlin.Any>"
            java.util.Objects.requireNonNull(r5, r4)
            boolean r4 = r5.handles(r8)
            if (r4 == 0) goto L_0x0043
            r4 = 1
            goto L_0x0044
        L_0x0043:
            r4 = 0
        L_0x0044:
            if (r4 == 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x004a:
            r3 = 0
        L_0x004b:
            kotlin.Pair r3 = (kotlin.Pair) r3
            if (r3 == 0) goto L_0x005b
            java.lang.Object r7 = r3.getFirst()
            java.lang.String r8 = "null cannot be cast to non-null type coil.fetch.Fetcher<T>"
            java.util.Objects.requireNonNull(r7, r8)
            coil.fetch.Fetcher r7 = (coil.fetch.Fetcher) r7
            return r7
        L_0x005b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unable to fetch data. No fetcher supports: "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.ComponentRegistries.requireFetcher(coil.ComponentRegistry, java.lang.Object):coil.fetch.Fetcher");
    }

    public static final <T> Decoder requireDecoder(ComponentRegistry componentRegistry, T t, BufferedSource bufferedSource, String str) {
        Decoder decoder;
        Intrinsics.checkNotNullParameter(componentRegistry, "$this$requireDecoder");
        Intrinsics.checkNotNullParameter(t, "data");
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        List<Decoder> decoders$coil_base_release = componentRegistry.getDecoders$coil_base_release();
        int size = decoders$coil_base_release.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                decoder = null;
                break;
            }
            decoder = decoders$coil_base_release.get(i);
            if (decoder.handles(bufferedSource, str)) {
                break;
            }
            i++;
        }
        Decoder decoder2 = decoder;
        if (decoder2 != null) {
            return decoder2;
        }
        throw new IllegalStateException(("Unable to decode data. No decoder supports: " + t).toString());
    }
}
