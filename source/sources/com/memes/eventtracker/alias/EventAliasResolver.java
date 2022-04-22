package com.memes.eventtracker.alias;

import android.content.Context;
import android.content.res.AssetManager;
import com.memes.eventtracker.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tH\u0002J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/eventtracker/alias/EventAliasResolver;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "aliases", "", "Lcom/memes/eventtracker/alias/EventAlias;", "fetchAliases", "", "resolve", "eventId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EventAliasResolver.kt */
public final class EventAliasResolver {
    /* access modifiers changed from: private */
    public final List<EventAlias> aliases = new ArrayList();
    private final Context context;

    public EventAliasResolver(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final List<EventAlias> aliases() {
        return this.aliases;
    }

    public final Object resolve(String str, Continuation<? super EventAlias> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventAliasResolver$resolve$2(this, str, (Continuation) null), continuation);
    }

    /* access modifiers changed from: private */
    public final List<EventAlias> fetchAliases() {
        Util util = Util.INSTANCE;
        AssetManager assets = this.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        List<String> listFiles = util.listFiles(assets, "tracking/");
        Collection collection = listFiles;
        if (!(collection == null || collection.isEmpty())) {
            for (String str : listFiles) {
                List<EventAlias> list = this.aliases;
                Util util2 = Util.INSTANCE;
                AssetManager assets2 = this.context.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
                list.addAll(util2.getAliases(assets2, "tracking/" + str));
            }
        }
        return this.aliases;
    }
}
