package p015io.getstream.chat.android.livedata.repository.domain.channelconfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Command;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.livedata.model.ChannelConfig;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0001H\u0002¨\u0006\b"}, mo26107d2 = {"toEntity", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/CommandInnerEntity;", "Lio/getstream/chat/android/client/models/Command;", "channelType", "", "Lio/getstream/chat/android/livedata/repository/domain/channelconfig/ChannelConfigEntity;", "Lio/getstream/chat/android/livedata/model/ChannelConfig;", "toModel", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.channelconfig.ChannelConfigMapperKt */
/* compiled from: ChannelConfigMapper.kt */
public final class ChannelConfigMapperKt {
    public static final ChannelConfigEntity toEntity(ChannelConfig channelConfig) {
        Intrinsics.checkNotNullParameter(channelConfig, "$this$toEntity");
        Config config = channelConfig.getConfig();
        ChannelConfigInnerEntity channelConfigInnerEntity = r2;
        ChannelConfigInnerEntity channelConfigInnerEntity2 = new ChannelConfigInnerEntity(channelConfig.getType(), config.getCreated_at(), config.getUpdated_at(), config.isTypingEvents(), config.isReadEvents(), config.isConnectEvents(), config.isSearch(), config.isReactionsEnabled(), config.isRepliesEnabled(), config.isMutes(), config.getMaxMessageLength(), config.getAutomod(), config.getInfinite(), config.getName());
        Iterable<Command> commands = channelConfig.getConfig().getCommands();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(commands, 10));
        for (Command entity : commands) {
            arrayList.add(toEntity(entity, channelConfig.getType()));
        }
        return new ChannelConfigEntity(channelConfigInnerEntity, (List) arrayList);
    }

    public static final ChannelConfig toModel(ChannelConfigEntity channelConfigEntity) {
        Intrinsics.checkNotNullParameter(channelConfigEntity, "$this$toModel");
        String channelType = channelConfigEntity.getChannelConfigInnerEntity().getChannelType();
        ChannelConfigInnerEntity channelConfigInnerEntity = channelConfigEntity.getChannelConfigInnerEntity();
        Date createdAt = channelConfigInnerEntity.getCreatedAt();
        Date updatedAt = channelConfigInnerEntity.getUpdatedAt();
        boolean isTypingEvents = channelConfigInnerEntity.isTypingEvents();
        boolean isReadEvents = channelConfigInnerEntity.isReadEvents();
        boolean isConnectEvents = channelConfigInnerEntity.isConnectEvents();
        boolean isSearch = channelConfigInnerEntity.isSearch();
        boolean isReactionsEnabled = channelConfigInnerEntity.isReactionsEnabled();
        boolean isRepliesEnabled = channelConfigInnerEntity.isRepliesEnabled();
        boolean isMutes = channelConfigInnerEntity.isMutes();
        int maxMessageLength = channelConfigInnerEntity.getMaxMessageLength();
        String automod = channelConfigInnerEntity.getAutomod();
        String infinite = channelConfigInnerEntity.getInfinite();
        String name = channelConfigInnerEntity.getName();
        Iterable<CommandInnerEntity> commands = channelConfigEntity.getCommands();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(commands, 10));
        for (CommandInnerEntity model : commands) {
            arrayList.add(toModel(model));
        }
        return new ChannelConfig(channelType, new Config(createdAt, updatedAt, isTypingEvents, isReadEvents, isConnectEvents, isSearch, isReactionsEnabled, isRepliesEnabled, isMutes, maxMessageLength, automod, infinite, name, (List) arrayList));
    }

    private static final Command toModel(CommandInnerEntity commandInnerEntity) {
        return new Command(commandInnerEntity.getName(), commandInnerEntity.getDescription(), commandInnerEntity.getArgs(), commandInnerEntity.getSet());
    }

    private static final CommandInnerEntity toEntity(Command command, String str) {
        return new CommandInnerEntity(command.getName(), command.getDescription(), command.getArgs(), command.getSet(), str);
    }
}
