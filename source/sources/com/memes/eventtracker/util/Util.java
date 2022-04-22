package com.memes.eventtracker.util;

import android.content.res.AssetManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.memes.eventtracker.alias.EventAlias;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/eventtracker/util/Util;", "", "()V", "EVENT_ID_SEPARATOR", "", "getAliases", "", "Lcom/memes/eventtracker/alias/EventAlias;", "assetManager", "Landroid/content/res/AssetManager;", "aliasFileName", "listFiles", "folderPath", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Util.kt */
public final class Util {
    public static final String EVENT_ID_SEPARATOR = ",";
    public static final Util INSTANCE = new Util();

    private Util() {
    }

    public final List<String> listFiles(AssetManager assetManager, String str) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(str, "folderPath");
        String[] list = assetManager.list(str);
        if (list != null) {
            return ArraysKt.asList((T[]) list);
        }
        return null;
    }

    public final List<EventAlias> getAliases(AssetManager assetManager, String str) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(str, "aliasFileName");
        String readAssetsFile = UtilKt.readAssetsFile(assetManager, str);
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, EventAlias.class);
        Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…ias::class.java\n        )");
        Object fromJson = new Gson().fromJson(readAssetsFile, parameterized.getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson<MutableL…text, aliasType\n        )");
        return (List) fromJson;
    }
}
