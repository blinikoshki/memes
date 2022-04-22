package com.memes.chat.p035db.mutedchannels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelMute;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/db/mutedchannels/MutedChannelsDao;", "", "delete", "", "entity", "Lcom/memes/chat/db/mutedchannels/MutedChannelEntity;", "deleteAll", "deleteById", "channelId", "", "getAll", "", "getAllMutes", "Lio/getstream/chat/android/client/models/ChannelMute;", "getByChannelId", "getMuteByChannelId", "insertAll", "entities", "replaceChannelMutes", "mutes", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.mutedchannels.MutedChannelsDao */
/* compiled from: MutedChannelsDao.kt */
public interface MutedChannelsDao {
    void delete(MutedChannelEntity mutedChannelEntity);

    void deleteAll();

    void deleteById(String str);

    List<MutedChannelEntity> getAll();

    List<ChannelMute> getAllMutes();

    MutedChannelEntity getByChannelId(String str);

    ChannelMute getMuteByChannelId(String str);

    void insertAll(List<MutedChannelEntity> list);

    void replaceChannelMutes(List<ChannelMute> list);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.db.mutedchannels.MutedChannelsDao$DefaultImpls */
    /* compiled from: MutedChannelsDao.kt */
    public static final class DefaultImpls {
        public static void replaceChannelMutes(MutedChannelsDao mutedChannelsDao, List<ChannelMute> list) {
            Intrinsics.checkNotNullParameter(list, "mutes");
            mutedChannelsDao.deleteAll();
            Iterable<ChannelMute> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ChannelMute from : iterable) {
                arrayList.add(MutedChannelEntity.Companion.from(from));
            }
            mutedChannelsDao.insertAll((List) arrayList);
        }

        public static List<ChannelMute> getAllMutes(MutedChannelsDao mutedChannelsDao) {
            Iterable<MutedChannelEntity> all = mutedChannelsDao.getAll();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all, 10));
            for (MutedChannelEntity channelMute : all) {
                arrayList.add(channelMute.toChannelMute());
            }
            return (List) arrayList;
        }

        public static ChannelMute getMuteByChannelId(MutedChannelsDao mutedChannelsDao, String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            MutedChannelEntity byChannelId = mutedChannelsDao.getByChannelId(str);
            if (byChannelId != null) {
                return byChannelId.toChannelMute();
            }
            return null;
        }
    }
}
