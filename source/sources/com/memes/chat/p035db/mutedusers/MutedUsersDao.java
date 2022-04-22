package com.memes.chat.p035db.mutedusers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Mute;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/db/mutedusers/MutedUsersDao;", "", "delete", "", "entity", "Lcom/memes/chat/db/mutedusers/MutedUserEntity;", "deleteAll", "deleteById", "id", "", "getAll", "", "getAllMutes", "Lio/getstream/chat/android/client/models/Mute;", "getByUserId", "getMuteByUserId", "insertAll", "entities", "replaceMutes", "mutes", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.mutedusers.MutedUsersDao */
/* compiled from: MutedUsersDao.kt */
public interface MutedUsersDao {
    void delete(MutedUserEntity mutedUserEntity);

    void deleteAll();

    void deleteById(String str);

    List<MutedUserEntity> getAll();

    List<Mute> getAllMutes();

    MutedUserEntity getByUserId(String str);

    Mute getMuteByUserId(String str);

    void insertAll(List<MutedUserEntity> list);

    void replaceMutes(List<Mute> list);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.db.mutedusers.MutedUsersDao$DefaultImpls */
    /* compiled from: MutedUsersDao.kt */
    public static final class DefaultImpls {
        public static void replaceMutes(MutedUsersDao mutedUsersDao, List<Mute> list) {
            Intrinsics.checkNotNullParameter(list, "mutes");
            mutedUsersDao.deleteAll();
            Iterable<Mute> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Mute from : iterable) {
                arrayList.add(MutedUserEntity.Companion.from(from));
            }
            mutedUsersDao.insertAll((List) arrayList);
        }

        public static List<Mute> getAllMutes(MutedUsersDao mutedUsersDao) {
            Iterable<MutedUserEntity> all = mutedUsersDao.getAll();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all, 10));
            for (MutedUserEntity mute : all) {
                arrayList.add(mute.toMute());
            }
            return (List) arrayList;
        }

        public static Mute getMuteByUserId(MutedUsersDao mutedUsersDao, String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            MutedUserEntity byUserId = mutedUsersDao.getByUserId(str);
            if (byUserId != null) {
                return byUserId.toMute();
            }
            return null;
        }
    }
}
