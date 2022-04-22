package com.memes.network;

import com.memes.network.giphy.source.GiphyRepository;
import com.memes.network.giphy.source.remote.RemoteGiphyDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/network/giphy/source/GiphyRepository;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: NetworkProxy.kt */
final class NetworkProxy$giphyDataSource$2 extends Lambda implements Function0<GiphyRepository> {
    public static final NetworkProxy$giphyDataSource$2 INSTANCE = new NetworkProxy$giphyDataSource$2();

    NetworkProxy$giphyDataSource$2() {
        super(0);
    }

    public final GiphyRepository invoke() {
        return new GiphyRepository(new RemoteGiphyDataSource(NetworkProxy.serviceGenerator.getGiphyClient()));
    }
}
