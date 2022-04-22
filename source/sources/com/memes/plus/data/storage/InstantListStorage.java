package com.memes.plus.data.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\b0\u0011\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ$\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ1\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u0002H\b2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u0002H\b¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo26107d2 = {"Lcom/memes/plus/data/storage/InstantListStorage;", "", "()V", "RECENTLY_SEARCHED_USERS", "", "SAVED_HASH_TAGS", "add", "", "ITEM", "repository", "Lcom/memes/plus/data/storage/StorageRepository;", "key", "item", "type", "Ljava/lang/reflect/Type;", "(Lcom/memes/plus/data/storage/StorageRepository;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)V", "all", "", "count", "", "remove", "", "(Lcom/memes/plus/data/storage/StorageRepository;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Z", "replaceAll", "items", "(Lcom/memes/plus/data/storage/StorageRepository;Ljava/lang/String;Ljava/lang/Object;)V", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: InstantListStorage.kt */
public final class InstantListStorage {
    public static final InstantListStorage INSTANCE = new InstantListStorage();
    public static final String RECENTLY_SEARCHED_USERS = "pref_recently_searched_users";
    public static final String SAVED_HASH_TAGS = "saved_hash_tags";

    private InstantListStorage() {
    }

    public final <ITEM> void add(StorageRepository storageRepository, String str, ITEM item, Type type) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        List mutableList = CollectionsKt.toMutableList(all(storageRepository, str, type));
        if (mutableList.contains(item)) {
            mutableList.remove(item);
        } else {
            mutableList.add(item);
        }
        storageRepository.stringPref(str, new Gson().toJson((Object) mutableList));
    }

    public final <ITEM> boolean remove(StorageRepository storageRepository, String str, ITEM item, Type type) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        List mutableList = CollectionsKt.toMutableList(all(storageRepository, str, type));
        if (!mutableList.contains(item)) {
            return false;
        }
        mutableList.remove(item);
        storageRepository.stringPref(str, new Gson().toJson((Object) mutableList));
        return true;
    }

    public final <ITEM> List<ITEM> all(StorageRepository storageRepository, String str, Type type) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        String stringPref = storageRepository.stringPref(str);
        CharSequence charSequence = stringPref;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return new ArrayList<>();
        }
        Gson gson = new Gson();
        TypeToken<?> parameterized = TypeToken.getParameterized(List.class, type);
        Intrinsics.checkNotNullExpressionValue(parameterized, "TypeToken.getParameteriz…leList::class.java, type)");
        Object fromJson = gson.fromJson(stringPref, parameterized.getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(\n       …::class.java, type).type)");
        return (List) fromJson;
    }

    public final <ITEM> void replaceAll(StorageRepository storageRepository, String str, ITEM item) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        Intrinsics.checkNotNullParameter(str, "key");
        storageRepository.stringPref(str, new Gson().toJson((Object) item));
    }

    public final <ITEM> int count(StorageRepository storageRepository, String str, Type type) {
        Intrinsics.checkNotNullParameter(storageRepository, "repository");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        return all(storageRepository, str, type).size();
    }
}
