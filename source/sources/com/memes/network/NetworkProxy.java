package com.memes.network;

import com.memes.network.chat.api.ChatDataSource;
import com.memes.network.chat.source.ChatRepository;
import com.memes.network.core.ServiceGenerator;
import com.memes.network.giphy.api.GiphyDataSource;
import com.memes.network.giphy.source.GiphyRepository;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.source.MemesRepository;
import com.memes.network.reddit.api.RedditDataSource;
import com.memes.network.reddit.source.RedditRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcom/memes/network/NetworkProxy;", "", "()V", "chatDataSource", "Lcom/memes/network/chat/source/ChatRepository;", "getChatDataSource", "()Lcom/memes/network/chat/source/ChatRepository;", "chatDataSource$delegate", "Lkotlin/Lazy;", "giphyDataSource", "Lcom/memes/network/giphy/source/GiphyRepository;", "getGiphyDataSource", "()Lcom/memes/network/giphy/source/GiphyRepository;", "giphyDataSource$delegate", "memesDataSource", "Lcom/memes/network/memes/source/MemesRepository;", "getMemesDataSource", "()Lcom/memes/network/memes/source/MemesRepository;", "memesDataSource$delegate", "redditDataSource", "Lcom/memes/network/reddit/source/RedditRepository;", "getRedditDataSource", "()Lcom/memes/network/reddit/source/RedditRepository;", "redditDataSource$delegate", "serviceGenerator", "Lcom/memes/network/core/ServiceGenerator;", "fromChat", "Lcom/memes/network/chat/api/ChatDataSource;", "fromGiphy", "Lcom/memes/network/giphy/api/GiphyDataSource;", "fromMemes", "Lcom/memes/network/memes/api/MemesDataSource;", "fromReddit", "Lcom/memes/network/reddit/api/RedditDataSource;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NetworkProxy.kt */
public final class NetworkProxy {
    public static final NetworkProxy INSTANCE = new NetworkProxy();
    private static final Lazy chatDataSource$delegate = LazyKt.lazy(NetworkProxy$chatDataSource$2.INSTANCE);
    private static final Lazy giphyDataSource$delegate = LazyKt.lazy(NetworkProxy$giphyDataSource$2.INSTANCE);
    private static final Lazy memesDataSource$delegate = LazyKt.lazy(NetworkProxy$memesDataSource$2.INSTANCE);
    private static final Lazy redditDataSource$delegate = LazyKt.lazy(NetworkProxy$redditDataSource$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final ServiceGenerator serviceGenerator = new ServiceGenerator();

    private final ChatRepository getChatDataSource() {
        return (ChatRepository) chatDataSource$delegate.getValue();
    }

    private final GiphyRepository getGiphyDataSource() {
        return (GiphyRepository) giphyDataSource$delegate.getValue();
    }

    private final MemesRepository getMemesDataSource() {
        return (MemesRepository) memesDataSource$delegate.getValue();
    }

    private final RedditRepository getRedditDataSource() {
        return (RedditRepository) redditDataSource$delegate.getValue();
    }

    private NetworkProxy() {
    }

    public final MemesDataSource fromMemes() {
        return getMemesDataSource();
    }

    public final ChatDataSource fromChat() {
        return getChatDataSource();
    }

    public final GiphyDataSource fromGiphy() {
        return getGiphyDataSource();
    }

    public final RedditDataSource fromReddit() {
        return getRedditDataSource();
    }
}
