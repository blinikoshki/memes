package com.memes.network;

import com.memes.network.memes.source.MemesRepository;
import com.memes.network.memes.source.remote.MemesMapper;
import com.memes.network.memes.source.remote.RemoteMemesDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/network/memes/source/MemesRepository;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NetworkProxy.kt */
final class NetworkProxy$memesDataSource$2 extends Lambda implements Function0<MemesRepository> {
    public static final NetworkProxy$memesDataSource$2 INSTANCE = new NetworkProxy$memesDataSource$2();

    NetworkProxy$memesDataSource$2() {
        super(0);
    }

    public final MemesRepository invoke() {
        return new MemesRepository(new RemoteMemesDataSource(NetworkProxy.serviceGenerator.getMemesClient(), new MemesMapper()));
    }
}
