package p015io.getstream.chat.android.livedata;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.appsflyer.share.Constants;
import editor.editor.equipment.core.CoreConfig;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Config;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.TypingEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.client.utils.observable.Disposable;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl;
import p015io.getstream.chat.android.livedata.model.SyncState;
import p015io.getstream.chat.android.livedata.repository.RepositoryFacade;
import p015io.getstream.chat.android.livedata.repository.builder.RepositoryFacadeBuilder;
import p015io.getstream.chat.android.livedata.repository.database.ChatDatabase;
import p015io.getstream.chat.android.livedata.request.MapperKt;
import p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest;
import p015io.getstream.chat.android.livedata.service.sync.BackgroundSyncConfig;
import p015io.getstream.chat.android.livedata.service.sync.SyncProvider;
import p015io.getstream.chat.android.livedata.usecase.UseCaseHelper;
import p015io.getstream.chat.android.livedata.utils.DefaultRetryPolicy;
import p015io.getstream.chat.android.livedata.utils.Event;
import p015io.getstream.chat.android.livedata.utils.RetryPolicy;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Í\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u001e\n\u0002\b\t*\u00019\b\u0000\u0018\u0000 þ\u00012\u00020\u0001:\u0002þ\u0001B?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB_\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aJ\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020'H\u0002J\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020'0\u001dH\u0000¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u00020'2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\u0018\u0010\u0001\u001a\u00020'2\u0007\u0010 \u0001\u001a\u00020&H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020'2\u0007\u0010¡\u0001\u001a\u00020&2\u0007\u0010¢\u0001\u001a\u00020&H\u0000¢\u0006\u0003\b\u0001J\n\u0010£\u0001\u001a\u00030\u0001H\u0016J\n\u0010¤\u0001\u001a\u00030\u0001H\u0002J\u001f\u0010¥\u0001\u001a\u00030\u00012\t\b\u0002\u0010¦\u0001\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0003\u0010§\u0001J%\u0010¨\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010©\u00012\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J\u0014\u0010«\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010¬\u0001J\u0007\u0010­\u0001\u001a\u00020&J\u000f\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020)0\u001dH\u0016J\u0012\u0010¯\u0001\u001a\u00020L2\u0007\u0010¡\u0001\u001a\u00020&H\u0016J\t\u0010°\u0001\u001a\u00020&H\u0016J\n\u0010±\u0001\u001a\u00030\u0001H\u0002J\u0010\u0010²\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020&J\t\u0010³\u0001\u001a\u00020\u0007H\u0016J\t\u0010´\u0001\u001a\u00020\u0007H\u0016J\t\u0010µ\u0001\u001a\u00020\u0007H\u0016J\t\u0010¶\u0001\u001a\u00020\u0007H\u0002J\"\u0010·\u0001\u001a\u00020)2\b\u0010¸\u0001\u001a\u00030¹\u00012\u000f\u0010º\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010»\u0001J&\u0010¼\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030½\u00010\u001d0©\u00012\r\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020&0\u001dH\u0002J.\u0010¿\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030½\u00010\u001d0©\u00012\u000b\b\u0002\u0010 \u0001\u001a\u0004\u0018\u00010&H@ø\u0001\u0000¢\u0006\u0003\u0010À\u0001J3\u0010Á\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030½\u00010\u001d0©\u00012\r\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020&0\u001dH@ø\u0001\u0000¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u001d\u0010Ä\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u001dH@ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010¬\u0001J\u0017\u0010Æ\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\bÇ\u0001\u0010¬\u0001J\u001d\u0010È\u0001\u001a\t\u0012\u0005\u0012\u00030É\u00010\u001dH@ø\u0001\u0000¢\u0006\u0006\bÊ\u0001\u0010¬\u0001J\u001d\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010\u001dH@ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010¬\u0001J?\u0010Î\u0001\u001a\n\u0012\u0005\u0012\u0003HÏ\u00010©\u0001\"\n\b\u0000\u0010Ï\u0001*\u00030Ð\u00012\u0016\u0010Ñ\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u0003HÏ\u00010Ó\u00010Ò\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ô\u0001J)\u0010Õ\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¢\u0001\u001a\u00020&2\b\u0010Ö\u0001\u001a\u00030×\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ø\u0001J)\u0010Õ\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¢\u0001\u001a\u00020&2\b\u0010Ö\u0001\u001a\u00030Ù\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ú\u0001J3\u0010Û\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u001d2\r\u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020&0\u001d2\b\u0010Ö\u0001\u001a\u00030Ý\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Þ\u0001J3\u0010Û\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u001d2\r\u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020&0\u001d2\b\u0010Ö\u0001\u001a\u00030Ù\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010ß\u0001J\u0011\u0010à\u0001\u001a\u00030\u00012\u0007\u0010á\u0001\u001a\u00020\u0007J\u0011\u0010â\u0001\u001a\u00030\u00012\u0007\u0010ã\u0001\u001a\u00020\u0017J\u0010\u0010ä\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bå\u0001J\u0010\u0010æ\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bç\u0001J\u0010\u0010è\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bé\u0001J\u0011\u0010ê\u0001\u001a\u00030\u00012\u0007\u0010ã\u0001\u001a\u00020\u0017J\u0019\u0010ë\u0001\u001a\u00030\u00012\u0007\u0010ì\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\bí\u0001J\n\u0010î\u0001\u001a\u00030\u0001H\u0002J\n\u0010ï\u0001\u001a\u00030\u0001H\u0002J\n\u0010ð\u0001\u001a\u00030\u0001H\u0002J\n\u0010ñ\u0001\u001a\u00030\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030\u0001H\u0002J\u001e\u0010ó\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J%\u0010ô\u0001\u001a\u00030\u00012\u000f\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010ö\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010÷\u0001J\u0018\u0010ø\u0001\u001a\u0004\u0018\u00010[H@ø\u0001\u0000¢\u0006\u0006\bù\u0001\u0010¬\u0001J \u0010ú\u0001\u001a\u00030\u00012\u0007\u0010û\u0001\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0006\bü\u0001\u0010ý\u0001R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020)0%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u000703X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u001703X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0010\u00108\u001a\u000209X\u0004¢\u0006\u0004\n\u0002\u0010:R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010F\"\u0004\bJ\u0010HR\u001c\u0010K\u001a\u00020L8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010PR \u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001903X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00105R\u0014\u0010S\u001a\u00020TX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u000e¢\u0006\u0002\n\u0000R\"\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0ZX.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000703X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u00105R\u0014\u0010b\u001a\u00020cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u000e\u0010f\u001a\u00020gX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d03X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u00105R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010/\"\u0004\bk\u00101R\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\u000703X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u00105R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010/\"\u0004\bo\u00101R\u001a\u0010p\u001a\u00020qX.¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001a\u0010v\u001a\u00020wX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001c\u0010|\u001a\u00020}X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001703X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u00105R\u001c\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020#03X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u00105R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010A\"\u0005\b\u0001\u0010CR\u001c\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010/\"\u0005\b\u0001\u00101\u0002\u0004\n\u0002\b\u0019¨\u0006ÿ\u0001"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/ChatDomainImpl;", "Lio/getstream/chat/android/livedata/ChatDomain;", "client", "Lio/getstream/chat/android/client/ChatClient;", "handler", "Landroid/os/Handler;", "offlineEnabled", "", "recoveryEnabled", "userPresence", "backgroundSyncEnabled", "appContext", "Landroid/content/Context;", "(Lio/getstream/chat/android/client/ChatClient;Landroid/os/Handler;ZZZZLandroid/content/Context;)V", "userOverwrite", "Lio/getstream/chat/android/client/models/User;", "db", "Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "mainHandler", "(Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/client/models/User;Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;Landroid/os/Handler;ZZZZLandroid/content/Context;)V", "_banned", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_channelUnreadCount", "", "_errorEvent", "Lio/getstream/chat/android/livedata/utils/Event;", "Lio/getstream/chat/android/client/errors/ChatError;", "_initialized", "_mutedUsers", "", "Lio/getstream/chat/android/client/models/Mute;", "_online", "_totalUnreadCount", "_typingChannels", "Landroidx/lifecycle/MediatorLiveData;", "Lio/getstream/chat/android/client/models/TypingEvent;", "activeChannelMapImpl", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lio/getstream/chat/android/livedata/controller/ChannelControllerImpl;", "activeQueryMapImpl", "Lio/getstream/chat/android/livedata/controller/QueryChannelsControllerImpl;", "getAppContext$stream_chat_android_offline_release", "()Landroid/content/Context;", "setAppContext$stream_chat_android_offline_release", "(Landroid/content/Context;)V", "getBackgroundSyncEnabled$stream_chat_android_offline_release", "()Z", "setBackgroundSyncEnabled$stream_chat_android_offline_release", "(Z)V", "banned", "Landroidx/lifecycle/LiveData;", "getBanned", "()Landroidx/lifecycle/LiveData;", "channelUnreadCount", "getChannelUnreadCount", "cleanTask", "io/getstream/chat/android/livedata/ChatDomainImpl$cleanTask$1", "Lio/getstream/chat/android/livedata/ChatDomainImpl$cleanTask$1;", "getClient$stream_chat_android_offline_release", "()Lio/getstream/chat/android/client/ChatClient;", "setClient$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/ChatClient;)V", "currentUser", "getCurrentUser", "()Lio/getstream/chat/android/client/models/User;", "setCurrentUser", "(Lio/getstream/chat/android/client/models/User;)V", "database", "getDatabase", "()Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;", "setDatabase", "(Lio/getstream/chat/android/livedata/repository/database/ChatDatabase;)V", "getDb$stream_chat_android_offline_release", "setDb$stream_chat_android_offline_release", "defaultConfig", "Lio/getstream/chat/android/client/models/Config;", "getDefaultConfig$annotations", "()V", "getDefaultConfig", "()Lio/getstream/chat/android/client/models/Config;", "errorEvents", "getErrorEvents", "eventHandler", "Lio/getstream/chat/android/livedata/EventHandlerImpl;", "getEventHandler$stream_chat_android_offline_release", "()Lio/getstream/chat/android/livedata/EventHandlerImpl;", "eventSubscription", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "initJob", "Lkotlinx/coroutines/Deferred;", "Lio/getstream/chat/android/livedata/model/SyncState;", "getInitJob$stream_chat_android_offline_release", "()Lkotlinx/coroutines/Deferred;", "setInitJob$stream_chat_android_offline_release", "(Lkotlinx/coroutines/Deferred;)V", "initialized", "getInitialized", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob$stream_chat_android_offline_release", "()Lkotlinx/coroutines/CompletableJob;", "logger", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "muted", "getMuted", "getOfflineEnabled", "setOfflineEnabled", "online", "getOnline", "getRecoveryEnabled$stream_chat_android_offline_release", "setRecoveryEnabled$stream_chat_android_offline_release", "repos", "Lio/getstream/chat/android/livedata/repository/RepositoryFacade;", "getRepos$stream_chat_android_offline_release", "()Lio/getstream/chat/android/livedata/repository/RepositoryFacade;", "setRepos$stream_chat_android_offline_release", "(Lio/getstream/chat/android/livedata/repository/RepositoryFacade;)V", "retryPolicy", "Lio/getstream/chat/android/livedata/utils/RetryPolicy;", "getRetryPolicy", "()Lio/getstream/chat/android/livedata/utils/RetryPolicy;", "setRetryPolicy", "(Lio/getstream/chat/android/livedata/utils/RetryPolicy;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$stream_chat_android_offline_release", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$stream_chat_android_offline_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "syncModule", "Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "getSyncModule", "()Lio/getstream/chat/android/livedata/service/sync/SyncProvider;", "syncModule$delegate", "Lkotlin/Lazy;", "syncStateFlow", "totalUnreadCount", "getTotalUnreadCount", "typingUpdates", "getTypingUpdates", "useCases", "Lio/getstream/chat/android/livedata/usecase/UseCaseHelper;", "getUseCases", "()Lio/getstream/chat/android/livedata/usecase/UseCaseHelper;", "getUserOverwrite$stream_chat_android_offline_release", "setUserOverwrite$stream_chat_android_offline_release", "getUserPresence", "setUserPresence", "addError", "", "error", "addTypingChannel", "channelController", "allActiveChannels", "allActiveChannels$stream_chat_android_offline_release", "channel", "c", "Lio/getstream/chat/android/client/models/Channel;", "channel$stream_chat_android_offline_release", "cid", "channelType", "channelId", "clean", "clearState", "connectionRecovered", "recoverAll", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createChannel", "Lio/getstream/chat/android/client/utils/Result;", "(Lio/getstream/chat/android/client/models/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateMessageId", "getActiveQueries", "getChannelConfig", "getVersion", "initClean", "isActiveChannel", "isInitialized", "isOffline", "isOnline", "isTestRunner", "queryChannels", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "queryEvents", "Lio/getstream/chat/android/client/events/ChatEvent;", "cids", "replayEventsForActiveChannels", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replayEventsForChannels", "replayEventsForChannels$stream_chat_android_offline_release", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryChannels", "retryChannels$stream_chat_android_offline_release", "retryFailedEntities", "retryFailedEntities$stream_chat_android_offline_release", "retryMessages", "Lio/getstream/chat/android/client/models/Message;", "retryMessages$stream_chat_android_offline_release", "retryReactions", "Lio/getstream/chat/android/client/models/Reaction;", "retryReactions$stream_chat_android_offline_release", "runAndRetry", "T", "", "runnable", "Lkotlin/Function0;", "Lio/getstream/chat/android/client/call/Call;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAndEnrichChannel", "pagination", "Lio/getstream/chat/android/livedata/request/QueryChannelPaginationRequest;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/request/QueryChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;", "(Ljava/lang/String;Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAndEnrichChannels", "channelIds", "Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;", "(Ljava/util/List;Lio/getstream/chat/android/livedata/request/AnyChannelPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/util/List;Lio/getstream/chat/android/livedata/request/QueryChannelsPaginationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBanned", "newBanned", "setChannelUnreadCount", "newCount", "setInitialized", "setInitialized$stream_chat_android_offline_release", "setOffline", "setOffline$stream_chat_android_offline_release", "setOnline", "setOnline$stream_chat_android_offline_release", "setTotalUnreadCount", "setUser", "user", "setUser$stream_chat_android_offline_release", "startListening", "stopClean", "stopListening", "storeBgSyncData", "storeBgSyncDataWhenUserConnects", "storeStateForChannel", "storeStateForChannels", "channelsResponse", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeSyncState", "storeSyncState$stream_chat_android_offline_release", "updateCurrentUser", "me", "updateCurrentUser$stream_chat_android_offline_release", "(Lio/getstream/chat/android/client/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl */
/* compiled from: ChatDomainImpl.kt */
public final class ChatDomainImpl implements ChatDomain {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Disposable EMPTY_DISPOSABLE = new ChatDomainImpl$Companion$EMPTY_DISPOSABLE$1();
    private final MutableStateFlow<Boolean> _banned;
    private final MutableStateFlow<Integer> _channelUnreadCount;
    private final MutableStateFlow<Event<ChatError>> _errorEvent;
    private final MutableStateFlow<Boolean> _initialized;
    private final MutableStateFlow<List<Mute>> _mutedUsers;
    private final MutableStateFlow<Boolean> _online;
    private final MutableStateFlow<Integer> _totalUnreadCount;
    private final MediatorLiveData<TypingEvent> _typingChannels;
    private final ConcurrentHashMap<String, ChannelControllerImpl> activeChannelMapImpl;
    private final ConcurrentHashMap<String, QueryChannelsControllerImpl> activeQueryMapImpl;
    private Context appContext;
    private boolean backgroundSyncEnabled;
    private final LiveData<Boolean> banned;
    private final LiveData<Integer> channelUnreadCount;
    private final ChatDomainImpl$cleanTask$1 cleanTask;
    private ChatClient client;
    public User currentUser;
    public ChatDatabase database;

    /* renamed from: db */
    private ChatDatabase f1462db;
    private final Config defaultConfig;
    private final LiveData<Event<ChatError>> errorEvents;
    private final EventHandlerImpl eventHandler;
    private Disposable eventSubscription;
    public Deferred<SyncState> initJob;
    private final LiveData<Boolean> initialized;
    private final CompletableJob job;
    private TaggedLogger logger;
    /* access modifiers changed from: private */
    public final Handler mainHandler;
    private final LiveData<List<Mute>> muted;
    private boolean offlineEnabled;
    private final LiveData<Boolean> online;
    private boolean recoveryEnabled;
    public RepositoryFacade repos;
    private RetryPolicy retryPolicy;
    private CoroutineScope scope;
    private final Lazy syncModule$delegate;
    /* access modifiers changed from: private */
    public final MutableStateFlow<SyncState> syncStateFlow;
    private final LiveData<Integer> totalUnreadCount;
    private final LiveData<TypingEvent> typingUpdates;
    private final UseCaseHelper useCases;
    private User userOverwrite;
    private boolean userPresence;

    public static /* synthetic */ void getDefaultConfig$annotations() {
    }

    private final SyncProvider getSyncModule() {
        return (SyncProvider) this.syncModule$delegate.getValue();
    }

    public String getVersion() {
        return "4.6.0-release";
    }

    public ChatDomainImpl(ChatClient chatClient, User user, ChatDatabase chatDatabase, Handler handler, boolean z, boolean z2, boolean z3, boolean z4, Context context) {
        ChatClient chatClient2 = chatClient;
        Handler handler2 = handler;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(chatClient2, "client");
        Intrinsics.checkNotNullParameter(handler2, "mainHandler");
        Intrinsics.checkNotNullParameter(context2, "appContext");
        this.client = chatClient2;
        this.userOverwrite = user;
        this.f1462db = chatDatabase;
        this.mainHandler = handler2;
        this.offlineEnabled = z;
        this.recoveryEnabled = z2;
        this.userPresence = z3;
        this.backgroundSyncEnabled = z4;
        this.appContext = context2;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._initialized = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._online = MutableStateFlow2;
        MutableStateFlow<Integer> MutableStateFlow3 = StateFlowKt.MutableStateFlow(0);
        this._totalUnreadCount = MutableStateFlow3;
        MutableStateFlow<Integer> MutableStateFlow4 = StateFlowKt.MutableStateFlow(0);
        this._channelUnreadCount = MutableStateFlow4;
        MutableStateFlow<Event<ChatError>> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._errorEvent = MutableStateFlow5;
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._banned = MutableStateFlow6;
        MutableStateFlow<List<Mute>> MutableStateFlow7 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._mutedUsers = MutableStateFlow7;
        MediatorLiveData<TypingEvent> mediatorLiveData = new MediatorLiveData<>();
        this._typingChannels = mediatorLiveData;
        this.syncModule$delegate = LazyKt.lazy(new ChatDomainImpl$syncModule$2(this));
        this.useCases = new UseCaseHelper(this);
        this.defaultConfig = new Config((Date) null, (Date) null, false, false, true, false, false, false, true, 0, (String) null, (String) null, (String) null, (List) null, 16111, (DefaultConstructorMarker) null);
        this.initialized = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow, (CoroutineContext) null, 0, 3, (Object) null);
        this.online = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow2, (CoroutineContext) null, 0, 3, (Object) null);
        this.totalUnreadCount = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow3, (CoroutineContext) null, 0, 3, (Object) null);
        this.channelUnreadCount = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow4, (CoroutineContext) null, 0, 3, (Object) null);
        this.muted = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow7, (CoroutineContext) null, 0, 3, (Object) null);
        this.banned = FlowLiveDataConversions.asLiveData$default((Flow) MutableStateFlow6, (CoroutineContext) null, 0, 3, (Object) null);
        this.errorEvents = FlowLiveDataConversions.asLiveData$default(FlowKt.filterNotNull(MutableStateFlow5), (CoroutineContext) null, 0, 3, (Object) null);
        this.eventSubscription = EMPTY_DISPOSABLE;
        this.activeChannelMapImpl = new ConcurrentHashMap<>();
        this.typingUpdates = mediatorLiveData;
        this.activeQueryMapImpl = new ConcurrentHashMap<>();
        this.eventHandler = new EventHandlerImpl(this);
        this.logger = ChatLogger.Companion.get("Domain");
        this.cleanTask = new ChatDomainImpl$cleanTask$1(this);
        this.syncStateFlow = StateFlowKt.MutableStateFlow(null);
        this.retryPolicy = new DefaultRetryPolicy();
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(DispatcherProvider.INSTANCE.getIO()));
        TaggedLogger taggedLogger = this.logger;
        taggedLogger.logI("Initializing ChatDomain with version " + getVersion());
        User user2 = this.userOverwrite;
        user2 = user2 == null ? this.client.getCurrentUser() : user2;
        if (user2 != null) {
            setUser$stream_chat_android_offline_release(user2);
        }
        if (this.userOverwrite == null) {
            this.client.getPreSetUserListeners().add(new Function1<User, Unit>(this) {
                final /* synthetic */ ChatDomainImpl this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((User) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(User user) {
                    Intrinsics.checkNotNullParameter(user, "it");
                    this.this$0.setUser$stream_chat_android_offline_release(user);
                }
            });
            this.client.getDisconnectListeners().add(new Function1<User, Unit>(this) {
                final /* synthetic */ ChatDomainImpl this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((User) obj);
                    return Unit.INSTANCE;
                }

                @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
                @DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.ChatDomainImpl$2$1", mo26808f = "ChatDomainImpl.kt", mo26809i = {}, mo26810l = {300}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
                /* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$2$1 */
                /* compiled from: ChatDomainImpl.kt */
                static final class C49591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ C49582 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Intrinsics.checkNotNullParameter(continuation, "completion");
                        return new C49591(this.this$0, continuation);
                    }

                    public final Object invoke(Object obj, Object obj2) {
                        return ((C49591) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            ChatDomainImpl chatDomainImpl = this.this$0.this$0;
                            this.label = 1;
                            if (chatDomainImpl.disconnect(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                public final void invoke(User user) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0.getScope$stream_chat_android_offline_release(), (CoroutineContext) null, (CoroutineStart) null, new C49591(this, (Continuation) null), 3, (Object) null);
                }
            });
        }
        storeBgSyncDataWhenUserConnects();
    }

    public final ChatClient getClient$stream_chat_android_offline_release() {
        return this.client;
    }

    public final void setClient$stream_chat_android_offline_release(ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(chatClient, "<set-?>");
        this.client = chatClient;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatDomainImpl(p015io.getstream.chat.android.client.ChatClient r14, p015io.getstream.chat.android.client.models.User r15, p015io.getstream.chat.android.livedata.repository.database.ChatDatabase r16, android.os.Handler r17, boolean r18, boolean r19, boolean r20, boolean r21, android.content.Context r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000c
            r1 = r2
            io.getstream.chat.android.client.models.User r1 = (p015io.getstream.chat.android.client.models.User) r1
            r5 = r1
            goto L_0x000d
        L_0x000c:
            r5 = r15
        L_0x000d:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0016
            r1 = r2
            io.getstream.chat.android.livedata.repository.database.ChatDatabase r1 = (p015io.getstream.chat.android.livedata.repository.database.ChatDatabase) r1
            r6 = r1
            goto L_0x0018
        L_0x0016:
            r6 = r16
        L_0x0018:
            r1 = r0 & 16
            r2 = 1
            if (r1 == 0) goto L_0x001f
            r8 = 1
            goto L_0x0021
        L_0x001f:
            r8 = r18
        L_0x0021:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0027
            r9 = 1
            goto L_0x0029
        L_0x0027:
            r9 = r19
        L_0x0029:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0030
            r10 = 0
            goto L_0x0032
        L_0x0030:
            r10 = r20
        L_0x0032:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0038
            r11 = 0
            goto L_0x003a
        L_0x0038:
            r11 = r21
        L_0x003a:
            r3 = r13
            r4 = r14
            r7 = r17
            r12 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.<init>(io.getstream.chat.android.client.ChatClient, io.getstream.chat.android.client.models.User, io.getstream.chat.android.livedata.repository.database.ChatDatabase, android.os.Handler, boolean, boolean, boolean, boolean, android.content.Context, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final User getUserOverwrite$stream_chat_android_offline_release() {
        return this.userOverwrite;
    }

    public final void setUserOverwrite$stream_chat_android_offline_release(User user) {
        this.userOverwrite = user;
    }

    public final ChatDatabase getDb$stream_chat_android_offline_release() {
        return this.f1462db;
    }

    public final void setDb$stream_chat_android_offline_release(ChatDatabase chatDatabase) {
        this.f1462db = chatDatabase;
    }

    public boolean getOfflineEnabled() {
        return this.offlineEnabled;
    }

    public void setOfflineEnabled(boolean z) {
        this.offlineEnabled = z;
    }

    public final boolean getRecoveryEnabled$stream_chat_android_offline_release() {
        return this.recoveryEnabled;
    }

    public final void setRecoveryEnabled$stream_chat_android_offline_release(boolean z) {
        this.recoveryEnabled = z;
    }

    public boolean getUserPresence() {
        return this.userPresence;
    }

    public void setUserPresence(boolean z) {
        this.userPresence = z;
    }

    public final boolean getBackgroundSyncEnabled$stream_chat_android_offline_release() {
        return this.backgroundSyncEnabled;
    }

    public final void setBackgroundSyncEnabled$stream_chat_android_offline_release(boolean z) {
        this.backgroundSyncEnabled = z;
    }

    public final Context getAppContext$stream_chat_android_offline_release() {
        return this.appContext;
    }

    public final void setAppContext$stream_chat_android_offline_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChatDomainImpl(p015io.getstream.chat.android.client.ChatClient r12, android.os.Handler r13, boolean r14, boolean r15, boolean r16, boolean r17, android.content.Context r18) {
        /*
            r11 = this;
            java.lang.String r0 = "client"
            r2 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "handler"
            r5 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "appContext"
            r10 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r3 = 0
            r4 = 0
            r1 = r11
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.<init>(io.getstream.chat.android.client.ChatClient, android.os.Handler, boolean, boolean, boolean, boolean, android.content.Context):void");
    }

    public User getCurrentUser() {
        User user = this.currentUser;
        if (user == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentUser");
        }
        return user;
    }

    public void setCurrentUser(User user) {
        Intrinsics.checkNotNullParameter(user, "<set-?>");
        this.currentUser = user;
    }

    public final ChatDatabase getDatabase() {
        ChatDatabase chatDatabase = this.database;
        if (chatDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return chatDatabase;
    }

    public final void setDatabase(ChatDatabase chatDatabase) {
        Intrinsics.checkNotNullParameter(chatDatabase, "<set-?>");
        this.database = chatDatabase;
    }

    public UseCaseHelper getUseCases() {
        return this.useCases;
    }

    public final Config getDefaultConfig() {
        return this.defaultConfig;
    }

    public LiveData<Boolean> getInitialized() {
        return this.initialized;
    }

    public LiveData<Boolean> getOnline() {
        return this.online;
    }

    public LiveData<Integer> getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    public LiveData<Integer> getChannelUnreadCount() {
        return this.channelUnreadCount;
    }

    public LiveData<List<Mute>> getMuted() {
        return this.muted;
    }

    public LiveData<Boolean> getBanned() {
        return this.banned;
    }

    public LiveData<Event<ChatError>> getErrorEvents() {
        return this.errorEvents;
    }

    public LiveData<TypingEvent> getTypingUpdates() {
        return this.typingUpdates;
    }

    public final EventHandlerImpl getEventHandler$stream_chat_android_offline_release() {
        return this.eventHandler;
    }

    public final RepositoryFacade getRepos$stream_chat_android_offline_release() {
        RepositoryFacade repositoryFacade = this.repos;
        if (repositoryFacade == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repos");
        }
        return repositoryFacade;
    }

    public final void setRepos$stream_chat_android_offline_release(RepositoryFacade repositoryFacade) {
        Intrinsics.checkNotNullParameter(repositoryFacade, "<set-?>");
        this.repos = repositoryFacade;
    }

    public final Deferred<SyncState> getInitJob$stream_chat_android_offline_release() {
        Deferred<SyncState> deferred = this.initJob;
        if (deferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initJob");
        }
        return deferred;
    }

    public final void setInitJob$stream_chat_android_offline_release(Deferred<SyncState> deferred) {
        Intrinsics.checkNotNullParameter(deferred, "<set-?>");
        this.initJob = deferred;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy2) {
        Intrinsics.checkNotNullParameter(retryPolicy2, "<set-?>");
        this.retryPolicy = retryPolicy2;
    }

    private final void clearState() {
        this._initialized.setValue(false);
        this._online.setValue(false);
        this._totalUnreadCount.setValue(0);
        this._channelUnreadCount.setValue(0);
        this._banned.setValue(false);
        this._mutedUsers.setValue(CollectionsKt.emptyList());
        this.activeChannelMapImpl.clear();
        this.activeQueryMapImpl.clear();
    }

    private final boolean isTestRunner() {
        String str = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(str, "Build.FINGERPRINT");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "robolectric", false, 2, (Object) null);
    }

    public final void setUser$stream_chat_android_offline_release(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        clearState();
        setCurrentUser(user);
        this.repos = RepositoryFacadeBuilder.Companion.invoke(new ChatDomainImpl$setUser$1(this)).build();
        this.initJob = BuildersKt__Builders_commonKt.async$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new ChatDomainImpl$setUser$2(this, (Continuation) null), 3, (Object) null);
        if (this.client.isSocketConnected()) {
            setOnline$stream_chat_android_offline_release();
        }
        startListening();
        initClean();
    }

    public final CompletableJob getJob$stream_chat_android_offline_release() {
        return this.job;
    }

    public final CoroutineScope getScope$stream_chat_android_offline_release() {
        return this.scope;
    }

    public final void setScope$stream_chat_android_offline_release(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.scope = coroutineScope;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateCurrentUser$stream_chat_android_offline_release(p015io.getstream.chat.android.client.models.User r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$updateCurrentUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.ChatDomainImpl$updateCurrentUser$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$updateCurrentUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$updateCurrentUser$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$updateCurrentUser$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            io.getstream.chat.android.client.models.User r5 = (p015io.getstream.chat.android.client.models.User) r5
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = r5.getId()
            io.getstream.chat.android.client.models.User r2 = r4.getCurrentUser()
            java.lang.String r2 = r2.getId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            r6 = r6 ^ r3
            if (r6 != 0) goto L_0x008b
            r4.setCurrentUser(r5)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r6 = r4.repos
            if (r6 != 0) goto L_0x005c
            java.lang.String r2 = "repos"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x005c:
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.insertCurrentUser(r5, r0)
            if (r6 != r1) goto L_0x0069
            return r1
        L_0x0069:
            r0 = r4
        L_0x006a:
            kotlinx.coroutines.flow.MutableStateFlow<java.util.List<io.getstream.chat.android.client.models.Mute>> r6 = r0._mutedUsers
            java.util.List r1 = r5.getMutes()
            r6.setValue(r1)
            int r6 = r5.getTotalUnreadCount()
            r0.setTotalUnreadCount(r6)
            int r6 = r5.getUnreadChannels()
            r0.setChannelUnreadCount(r6)
            boolean r5 = r5.getBanned()
            r0.setBanned(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x008b:
            java.util.InputMismatchException r6 = new java.util.InputMismatchException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "received connect event for user with id "
            r0.append(r1)
            java.lang.String r5 = r5.getId()
            r0.append(r5)
            java.lang.String r5 = " while chat domain is configured for user with id "
            r0.append(r5)
            io.getstream.chat.android.client.models.User r5 = r4.getCurrentUser()
            java.lang.String r5 = r5.getId()
            r0.append(r5)
            java.lang.String r5 = ". create a new chatdomain when connecting a different user."
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.updateCurrentUser$stream_chat_android_offline_release(io.getstream.chat.android.client.models.User, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object storeSyncState$stream_chat_android_offline_release(kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.model.SyncState> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$storeSyncState$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            io.getstream.chat.android.livedata.ChatDomainImpl$storeSyncState$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$storeSyncState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$storeSyncState$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$storeSyncState$1
            r0.<init>(r12, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r1 = r0.L$1
            io.getstream.chat.android.livedata.model.SyncState r1 = (p015io.getstream.chat.android.livedata.model.SyncState) r1
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00bb
        L_0x0033:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.flow.MutableStateFlow<io.getstream.chat.android.livedata.model.SyncState> r13 = r12.syncStateFlow
            java.lang.Object r13 = r13.getValue()
            r4 = r13
            io.getstream.chat.android.livedata.model.SyncState r4 = (p015io.getstream.chat.android.livedata.model.SyncState) r4
            if (r4 == 0) goto L_0x00c1
            r5 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.ChannelControllerImpl> r13 = r12.activeChannelMapImpl
            java.util.Enumeration r13 = r13.keys()
            java.lang.String r2 = "activeChannelMapImpl.keys()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            java.util.ArrayList r13 = java.util.Collections.list(r13)
            java.lang.String r2 = "java.util.Collections.list(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            r6 = r13
            java.util.List r6 = (java.util.List) r6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl> r13 = r12.activeQueryMapImpl
            java.util.Collection r13 = r13.values()
            java.lang.String r2 = "activeQueryMapImpl.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r7)
            r2.<init>(r7)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r13 = r13.iterator()
        L_0x007f:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto L_0x0097
            java.lang.Object r7 = r13.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r7 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r7
            io.getstream.chat.android.livedata.controller.QueryChannelsSpec r7 = r7.getQueryChannelsSpec()
            java.lang.String r7 = r7.getId()
            r2.add(r7)
            goto L_0x007f
        L_0x0097:
            r7 = r2
            java.util.List r7 = (java.util.List) r7
            r8 = 0
            r9 = 0
            r10 = 25
            r11 = 0
            io.getstream.chat.android.livedata.model.SyncState r13 = p015io.getstream.chat.android.livedata.model.SyncState.copy$default(r4, r5, r6, r7, r8, r9, r10, r11)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r12.repos
            if (r2 != 0) goto L_0x00ac
            java.lang.String r4 = "repos"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x00ac:
            r0.L$0 = r12
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r0 = r2.insertSyncState(r13, r0)
            if (r0 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            r0 = r12
            r1 = r13
        L_0x00bb:
            kotlinx.coroutines.flow.MutableStateFlow<io.getstream.chat.android.livedata.model.SyncState> r13 = r0.syncStateFlow
            r13.setValue(r1)
            goto L_0x00c2
        L_0x00c1:
            r0 = r12
        L_0x00c2:
            kotlinx.coroutines.flow.MutableStateFlow<io.getstream.chat.android.livedata.model.SyncState> r13 = r0.syncStateFlow
            java.lang.Object r13 = r13.getValue()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.storeSyncState$stream_chat_android_offline_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object disconnect(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$disconnect$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.getstream.chat.android.livedata.ChatDomainImpl$disconnect$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$disconnect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$disconnect$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$disconnect$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.storeSyncState$stream_chat_android_offline_release(r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            r0 = r4
        L_0x0045:
            kotlinx.coroutines.CompletableJob r5 = r0.job
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            r1 = 0
            kotlinx.coroutines.JobKt__JobKt.cancelChildren$default((kotlinx.coroutines.Job) r5, (java.util.concurrent.CancellationException) r1, (int) r3, (java.lang.Object) r1)
            r0.stopListening()
            r0.stopClean()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.disconnect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void stopClean() {
        this.mainHandler.removeCallbacks(this.cleanTask);
    }

    private final void initClean() {
        this.mainHandler.postDelayed(this.cleanTask, 5000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object runAndRetry(kotlin.jvm.functions.Function0<? extends p015io.getstream.chat.android.client.call.Call<T>> r10, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<T>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$runAndRetry$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.ChatDomainImpl$runAndRetry$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$runAndRetry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$runAndRetry$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$runAndRetry$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b8
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 1
            r4 = r9
        L_0x0042:
            java.lang.Object r2 = r10.invoke()
            io.getstream.chat.android.client.call.Call r2 = (p015io.getstream.chat.android.client.call.Call) r2
            io.getstream.chat.android.client.utils.Result r2 = r2.execute()
            boolean r5 = r2.isSuccess()
            if (r5 != 0) goto L_0x00dc
            io.getstream.chat.android.client.errors.ChatError r5 = r2.error()
            boolean r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r5)
            if (r5 == 0) goto L_0x005e
            goto L_0x00dc
        L_0x005e:
            io.getstream.chat.android.livedata.utils.RetryPolicy r5 = r4.getRetryPolicy()
            io.getstream.chat.android.client.ChatClient r6 = r4.client
            io.getstream.chat.android.client.errors.ChatError r7 = r2.error()
            boolean r5 = r5.shouldRetry(r6, r11, r7)
            io.getstream.chat.android.livedata.utils.RetryPolicy r6 = r4.getRetryPolicy()
            io.getstream.chat.android.client.ChatClient r7 = r4.client
            io.getstream.chat.android.client.errors.ChatError r8 = r2.error()
            int r6 = r6.retryTimeout(r7, r11, r8)
            java.lang.String r7 = "API call failed (attempt "
            if (r5 == 0) goto L_0x00bc
            io.getstream.chat.android.client.logger.TaggedLogger r5 = r4.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r11)
            java.lang.String r7 = "), retrying in "
            r8.append(r7)
            r8.append(r6)
            java.lang.String r7 = " seconds. Error was "
            r8.append(r7)
            io.getstream.chat.android.client.errors.ChatError r2 = r2.error()
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            r5.logI(r2)
            long r5 = (long) r6
            r0.L$0 = r4
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r2 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            r2 = r10
            r10 = r11
        L_0x00b8:
            int r11 = r10 + 1
            r10 = r2
            goto L_0x0042
        L_0x00bc:
            io.getstream.chat.android.client.logger.TaggedLogger r10 = r4.logger
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r11)
            java.lang.String r11 = "). Giving up for now, will retry when connection recovers. Error was "
            r0.append(r11)
            io.getstream.chat.android.client.errors.ChatError r11 = r2.error()
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.logI(r11)
        L_0x00dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.runAndRetry(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ea A[Catch:{ IllegalStateException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0103 A[Catch:{ IllegalStateException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0123 A[Catch:{ IllegalStateException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0147 A[Catch:{ IllegalStateException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x017b A[Catch:{ IllegalStateException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createChannel(p015io.getstream.chat.android.client.models.Channel r13, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<p015io.getstream.chat.android.client.models.Channel>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            java.lang.String r7 = "repos"
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0080
            if (r2 == r8) goto L_0x0072
            if (r2 == r6) goto L_0x005c
            if (r2 == r5) goto L_0x004f
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r13 = r0.L$0
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x0171
        L_0x003e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0046:
            java.lang.Object r13 = r0.L$0
            io.getstream.chat.android.client.utils.Result r13 = (p015io.getstream.chat.android.client.utils.Result) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x013d
        L_0x004f:
            java.lang.Object r13 = r0.L$1
            io.getstream.chat.android.client.models.Channel r13 = (p015io.getstream.chat.android.client.models.Channel) r13
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r2
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x011b
        L_0x005c:
            boolean r13 = r0.Z$0
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r10 = r0.L$1
            io.getstream.chat.android.client.models.Channel r10 = (p015io.getstream.chat.android.client.models.Channel) r10
            java.lang.Object r11 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r11
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ IllegalStateException -> 0x0181 }
            r14 = r2
            r2 = r10
            r10 = r11
            goto L_0x00e4
        L_0x0072:
            boolean r13 = r0.Z$0
            java.lang.Object r2 = r0.L$1
            io.getstream.chat.android.client.models.Channel r2 = (p015io.getstream.chat.android.client.models.Channel) r2
            java.lang.Object r10 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r10
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x00da
        L_0x0080:
            kotlin.ResultKt.throwOnFailure(r14)
            boolean r14 = r12.isOnline()     // Catch:{ IllegalStateException -> 0x0181 }
            java.util.Date r2 = r13.getCreatedAt()     // Catch:{ IllegalStateException -> 0x0181 }
            if (r2 == 0) goto L_0x008e
            goto L_0x0093
        L_0x008e:
            java.util.Date r2 = new java.util.Date     // Catch:{ IllegalStateException -> 0x0181 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x0093:
            r13.setCreatedAt(r2)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r14 == 0) goto L_0x009b
            io.getstream.chat.android.client.utils.SyncStatus r2 = p015io.getstream.chat.android.client.utils.SyncStatus.IN_PROGRESS     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x009d
        L_0x009b:
            io.getstream.chat.android.client.utils.SyncStatus r2 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x009d:
            r13.setSyncStatus(r2)     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.client.models.User r2 = r13.getCreatedBy()     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.client.models.User r10 = r12.getCurrentUser()     // Catch:{ IllegalStateException -> 0x0181 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r10)     // Catch:{ IllegalStateException -> 0x0181 }
            r2 = r2 ^ r8
            if (r2 == 0) goto L_0x00b6
            io.getstream.chat.android.client.models.User r2 = r12.getCurrentUser()     // Catch:{ IllegalStateException -> 0x0181 }
            r13.setCreatedBy(r2)     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x00b6:
            java.lang.String r2 = r13.getCid()     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r2 = r12.channel$stream_chat_android_offline_release((java.lang.String) r2)     // Catch:{ IllegalStateException -> 0x0181 }
            r2.updateLiveDataFromChannel(r13)     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r12.repos     // Catch:{ IllegalStateException -> 0x0181 }
            if (r2 != 0) goto L_0x00c8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x00c8:
            r0.L$0 = r12     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$1 = r13     // Catch:{ IllegalStateException -> 0x0181 }
            r0.Z$0 = r14     // Catch:{ IllegalStateException -> 0x0181 }
            r0.label = r8     // Catch:{ IllegalStateException -> 0x0181 }
            java.lang.Object r2 = r2.insertChannel(r13, r0)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r2 != r1) goto L_0x00d7
            return r1
        L_0x00d7:
            r10 = r12
            r2 = r13
            r13 = r14
        L_0x00da:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl> r14 = r10.activeQueryMapImpl     // Catch:{ IllegalStateException -> 0x0181 }
            java.util.Collection r14 = r14.values()     // Catch:{ IllegalStateException -> 0x0181 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x00e4:
            boolean r11 = r14.hasNext()     // Catch:{ IllegalStateException -> 0x0181 }
            if (r11 == 0) goto L_0x0101
            java.lang.Object r11 = r14.next()     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r11 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r11     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$0 = r10     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$1 = r2     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$2 = r14     // Catch:{ IllegalStateException -> 0x0181 }
            r0.Z$0 = r13     // Catch:{ IllegalStateException -> 0x0181 }
            r0.label = r6     // Catch:{ IllegalStateException -> 0x0181 }
            java.lang.Object r11 = r11.addChannelIfFilterMatches$stream_chat_android_offline_release(r2, r0)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r11 != r1) goto L_0x00e4
            return r1
        L_0x0101:
            if (r13 == 0) goto L_0x017b
            io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$runnable$1 r13 = new io.getstream.chat.android.livedata.ChatDomainImpl$createChannel$runnable$1     // Catch:{ IllegalStateException -> 0x0181 }
            r13.<init>(r10, r2)     // Catch:{ IllegalStateException -> 0x0181 }
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$0 = r10     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$1 = r2     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$2 = r9     // Catch:{ IllegalStateException -> 0x0181 }
            r0.label = r5     // Catch:{ IllegalStateException -> 0x0181 }
            java.lang.Object r14 = r10.runAndRetry(r13, r0)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r14 != r1) goto L_0x0119
            return r1
        L_0x0119:
            r13 = r2
            r2 = r10
        L_0x011b:
            io.getstream.chat.android.client.utils.Result r14 = (p015io.getstream.chat.android.client.utils.Result) r14     // Catch:{ IllegalStateException -> 0x0181 }
            boolean r5 = r14.isSuccess()     // Catch:{ IllegalStateException -> 0x0181 }
            if (r5 == 0) goto L_0x0147
            io.getstream.chat.android.client.utils.SyncStatus r3 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED     // Catch:{ IllegalStateException -> 0x0181 }
            r13.setSyncStatus(r3)     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.repos     // Catch:{ IllegalStateException -> 0x0181 }
            if (r2 != 0) goto L_0x012f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x012f:
            r0.L$0 = r14     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$1 = r9     // Catch:{ IllegalStateException -> 0x0181 }
            r0.label = r4     // Catch:{ IllegalStateException -> 0x0181 }
            java.lang.Object r13 = r2.insertChannel(r13, r0)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r13 != r1) goto L_0x013c
            return r1
        L_0x013c:
            r13 = r14
        L_0x013d:
            io.getstream.chat.android.client.utils.Result r14 = new io.getstream.chat.android.client.utils.Result     // Catch:{ IllegalStateException -> 0x0181 }
            java.lang.Object r13 = r13.data()     // Catch:{ IllegalStateException -> 0x0181 }
            r14.<init>(r13)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x018e
        L_0x0147:
            io.getstream.chat.android.client.errors.ChatError r4 = r14.error()     // Catch:{ IllegalStateException -> 0x0181 }
            boolean r4 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r4)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r4 == 0) goto L_0x0157
            io.getstream.chat.android.client.utils.SyncStatus r4 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY     // Catch:{ IllegalStateException -> 0x0181 }
            r13.setSyncStatus(r4)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x015c
        L_0x0157:
            io.getstream.chat.android.client.utils.SyncStatus r4 = p015io.getstream.chat.android.client.utils.SyncStatus.SYNC_NEEDED     // Catch:{ IllegalStateException -> 0x0181 }
            r13.setSyncStatus(r4)     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x015c:
            io.getstream.chat.android.livedata.repository.RepositoryFacade r2 = r2.repos     // Catch:{ IllegalStateException -> 0x0181 }
            if (r2 != 0) goto L_0x0163
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)     // Catch:{ IllegalStateException -> 0x0181 }
        L_0x0163:
            r0.L$0 = r14     // Catch:{ IllegalStateException -> 0x0181 }
            r0.L$1 = r9     // Catch:{ IllegalStateException -> 0x0181 }
            r0.label = r3     // Catch:{ IllegalStateException -> 0x0181 }
            java.lang.Object r13 = r2.insertChannel(r13, r0)     // Catch:{ IllegalStateException -> 0x0181 }
            if (r13 != r1) goto L_0x0170
            return r1
        L_0x0170:
            r13 = r14
        L_0x0171:
            io.getstream.chat.android.client.utils.Result r14 = new io.getstream.chat.android.client.utils.Result     // Catch:{ IllegalStateException -> 0x0181 }
            io.getstream.chat.android.client.errors.ChatError r13 = r13.error()     // Catch:{ IllegalStateException -> 0x0181 }
            r14.<init>((p015io.getstream.chat.android.client.errors.ChatError) r13)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x018e
        L_0x017b:
            io.getstream.chat.android.client.utils.Result r14 = new io.getstream.chat.android.client.utils.Result     // Catch:{ IllegalStateException -> 0x0181 }
            r14.<init>(r2)     // Catch:{ IllegalStateException -> 0x0181 }
            goto L_0x018e
        L_0x0181:
            r13 = move-exception
            io.getstream.chat.android.client.utils.Result r14 = new io.getstream.chat.android.client.utils.Result
            io.getstream.chat.android.client.errors.ChatError r0 = new io.getstream.chat.android.client.errors.ChatError
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            r0.<init>(r9, r13, r8, r9)
            r14.<init>((p015io.getstream.chat.android.client.errors.ChatError) r0)
        L_0x018e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.createChannel(io.getstream.chat.android.client.models.Channel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void addError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        this._errorEvent.setValue(new Event(chatError));
    }

    public final boolean isActiveChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "cid");
        return this.activeChannelMapImpl.containsKey(str);
    }

    public final void setChannelUnreadCount(int i) {
        this._channelUnreadCount.setValue(Integer.valueOf(i));
    }

    public final void setBanned(boolean z) {
        this._banned.setValue(Boolean.valueOf(z));
    }

    public final void setTotalUnreadCount(int i) {
        this._totalUnreadCount.setValue(Integer.valueOf(i));
    }

    private final void storeBgSyncDataWhenUserConnects() {
        this.client.addSocketListener(new ChatDomainImpl$storeBgSyncDataWhenUserConnects$1(this));
    }

    /* access modifiers changed from: private */
    public final void storeBgSyncData() {
        if (this.backgroundSyncEnabled && !isTestRunner()) {
            String apiKey = this.client.getConfig().getApiKey();
            String id = getCurrentUser().getId();
            String currentToken = this.client.getCurrentToken();
            if (currentToken == null) {
                currentToken = "";
            }
            BackgroundSyncConfig backgroundSyncConfig = new BackgroundSyncConfig(apiKey, id, currentToken);
            if (backgroundSyncConfig.isValid()) {
                getSyncModule().mo69979x9c3f7c57().put(backgroundSyncConfig);
            }
        }
    }

    private final void startListening() {
        if (this.eventSubscription.isDisposed()) {
            this.eventSubscription = this.client.subscribe((ChatEventListener<ChatEvent>) new ChatDomainImpl$startListening$1(this));
        }
    }

    private final void stopListening() {
        this.eventSubscription.dispose();
    }

    public final ChannelControllerImpl channel$stream_chat_android_offline_release(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, Constants.URL_CAMPAIGN);
        return channel$stream_chat_android_offline_release(channel.getType(), channel.getId());
    }

    public final ChannelControllerImpl channel$stream_chat_android_offline_release(String str) {
        Intrinsics.checkNotNullParameter(str, "cid");
        CharSequence charSequence = str;
        if (ChatDomainImplKt.CHANNEL_CID_REGEX.matches(charSequence)) {
            List split$default = StringsKt.split$default(charSequence, new String[]{":"}, false, 0, 6, (Object) null);
            return channel$stream_chat_android_offline_release((String) split$default.get(0), (String) split$default.get(1));
        }
        throw new IllegalArgumentException("Received invalid cid, expected format messaging:123, got " + str);
    }

    public final ChannelControllerImpl channel$stream_chat_android_offline_release(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        String format = String.format("%s:%s", Arrays.copyOf(new Object[]{str, str2}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        if (!this.activeChannelMapImpl.containsKey(format)) {
            ChannelControllerImpl channelControllerImpl = new ChannelControllerImpl(str, str2, this.client, this);
            this.activeChannelMapImpl.put(format, channelControllerImpl);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new ChatDomainImpl$channel$1(this, channelControllerImpl, (Continuation) null), 2, (Object) null);
        }
        return (ChannelControllerImpl) MapsKt.getValue(this.activeChannelMapImpl, format);
    }

    public final List<ChannelControllerImpl> allActiveChannels$stream_chat_android_offline_release() {
        Collection<ChannelControllerImpl> values = this.activeChannelMapImpl.values();
        Intrinsics.checkNotNullExpressionValue(values, "activeChannelMapImpl.values");
        return CollectionsKt.toList(values);
    }

    public final String generateMessageId() {
        return getCurrentUser().getId() + CoreConfig.ENTITY_TOKEN_PREFIX + UUID.randomUUID().toString();
    }

    /* access modifiers changed from: private */
    public final void addTypingChannel(ChannelControllerImpl channelControllerImpl) {
        this._typingChannels.addSource(channelControllerImpl.getTyping(), new ChatDomainImplKt$sam$androidx_lifecycle_Observer$0(new ChatDomainImpl$addTypingChannel$1(this._typingChannels)));
    }

    public final void setOffline$stream_chat_android_offline_release() {
        this._online.setValue(false);
    }

    public final void setOnline$stream_chat_android_offline_release() {
        this._online.setValue(true);
    }

    public final void setInitialized$stream_chat_android_offline_release() {
        this._initialized.setValue(true);
    }

    public boolean isOnline() {
        return this._online.getValue().booleanValue();
    }

    public boolean isOffline() {
        return !this._online.getValue().booleanValue();
    }

    public boolean isInitialized() {
        return this._initialized.getValue().booleanValue();
    }

    public List<QueryChannelsControllerImpl> getActiveQueries() {
        Collection<QueryChannelsControllerImpl> values = this.activeQueryMapImpl.values();
        Intrinsics.checkNotNullExpressionValue(values, "activeQueryMapImpl.values");
        return CollectionsKt.toList(values);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0031, code lost:
        r2 = new p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl(r5, r6, r4.client, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl queryChannels(p015io.getstream.chat.android.client.utils.FilterObject r5, p015io.getstream.chat.android.client.api.models.QuerySort<p015io.getstream.chat.android.client.models.Channel> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "filter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "sort"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl> r0 = r4.activeQueryMapImpl
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r5.hashCode()
            r1.append(r2)
            r2 = 45
            r1.append(r2)
            int r2 = r6.hashCode()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Object r2 = r0.get(r1)
            if (r2 == 0) goto L_0x0031
            goto L_0x003f
        L_0x0031:
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r2 = new io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl
            io.getstream.chat.android.client.ChatClient r3 = r4.client
            r2.<init>(r5, r6, r3, r4)
            java.lang.Object r5 = r0.putIfAbsent(r1, r2)
            if (r5 == 0) goto L_0x003f
            r2 = r5
        L_0x003f:
            java.lang.String r5 = "activeQueryMapImpl.getOr…s\n            )\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r2 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.queryChannels(io.getstream.chat.android.client.utils.FilterObject, io.getstream.chat.android.client.api.models.QuerySort):io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl");
    }

    private final Result<List<ChatEvent>> queryEvents(List<String> list) {
        Date date;
        ChatClient chatClient = this.client;
        SyncState value = this.syncStateFlow.getValue();
        if (value == null || (date = value.getLastSyncedAt()) == null) {
            date = new Date();
        }
        return chatClient.getSyncHistory(list, date).execute();
    }

    public static /* synthetic */ Object replayEventsForActiveChannels$default(ChatDomainImpl chatDomainImpl, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return chatDomainImpl.replayEventsForActiveChannels(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v9 java.lang.Object), (r7v1 java.lang.Object) binds: [B:25:0x008e, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object replayEventsForActiveChannels(java.lang.String r6, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.events.ChatEvent>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForActiveChannels$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForActiveChannels$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForActiveChannels$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForActiveChannels$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForActiveChannels$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0091
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.Deferred<io.getstream.chat.android.livedata.model.SyncState> r7 = r5.initJob
            if (r7 != 0) goto L_0x004d
            java.lang.String r2 = "initJob"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x004d:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.join(r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r2 = r5
        L_0x005b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.ChannelControllerImpl> r7 = r2.activeChannelMapImpl
            java.util.Enumeration r7 = r7.keys()
            java.lang.String r4 = "activeChannelMapImpl.keys()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            java.util.ArrayList r7 = java.util.Collections.list(r7)
            java.lang.String r4 = "java.util.Collections.list(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            java.util.List r7 = (java.util.List) r7
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.toMutableList(r7)
            if (r6 == 0) goto L_0x0083
            r2.channel$stream_chat_android_offline_release((java.lang.String) r6)
            boolean r6 = r7.add(r6)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0083:
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.replayEventsForChannels$stream_chat_android_offline_release(r7, r0)
            if (r7 != r1) goto L_0x0091
            return r1
        L_0x0091:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.replayEventsForActiveChannels(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object replayEventsForChannels$stream_chat_android_offline_release(java.util.List<java.lang.String> r10, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.events.ChatEvent>>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForChannels$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForChannels$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForChannels$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForChannels$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$replayEventsForChannels$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r10 = r0.L$2
            io.getstream.chat.android.client.utils.Result r10 = (p015io.getstream.chat.android.client.utils.Result) r10
            java.lang.Object r1 = r0.L$1
            java.util.Date r1 = (java.util.Date) r1
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r5 = r1
            goto L_0x0074
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0090
            io.getstream.chat.android.client.utils.Result r10 = r9.queryEvents(r10)
            boolean r2 = r10.isSuccess()
            if (r2 == 0) goto L_0x0099
            io.getstream.chat.android.livedata.EventHandlerImpl r2 = r9.eventHandler
            java.lang.Object r4 = r10.data()
            java.util.List r4 = (java.util.List) r4
            r0.L$0 = r9
            r0.L$1 = r11
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r0 = r2.mo69172xbc9d7433(r4, r0)
            if (r0 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r0 = r9
            r5 = r11
        L_0x0074:
            kotlinx.coroutines.flow.MutableStateFlow<io.getstream.chat.android.livedata.model.SyncState> r11 = r0.syncStateFlow
            java.lang.Object r11 = r11.getValue()
            r1 = r11
            io.getstream.chat.android.livedata.model.SyncState r1 = (p015io.getstream.chat.android.livedata.model.SyncState) r1
            if (r1 == 0) goto L_0x0099
            kotlinx.coroutines.flow.MutableStateFlow<io.getstream.chat.android.livedata.model.SyncState> r11 = r0.syncStateFlow
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 23
            r8 = 0
            io.getstream.chat.android.livedata.model.SyncState r0 = p015io.getstream.chat.android.livedata.model.SyncState.copy$default(r1, r2, r3, r4, r5, r6, r7, r8)
            r11.setValue(r0)
            goto L_0x0099
        L_0x0090:
            io.getstream.chat.android.client.utils.Result r10 = new io.getstream.chat.android.client.utils.Result
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            r10.<init>(r11)
        L_0x0099:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.replayEventsForChannels$stream_chat_android_offline_release(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object connectionRecovered$default(ChatDomainImpl chatDomainImpl, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return chatDomainImpl.connectionRecovered(z, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cd, code lost:
        r1 = new java.util.LinkedHashSet();
        r11 = r10.activeQueryMapImpl.values();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "activeQueryMapImpl.values");
        r12 = new java.util.ArrayList();
        r11 = kotlin.collections.CollectionsKt.toList(r11).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
        if (r11.hasNext() == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f8, code lost:
        r13 = r11.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0103, code lost:
        if (((p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r13).getRecoveryNeeded() != false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0105, code lost:
        if (r4 == false) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0108, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x010a, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0113, code lost:
        if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14).booleanValue() == false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0115, code lost:
        r12.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0119, code lost:
        r11 = kotlin.collections.CollectionsKt.take((java.util.List) r12, 3);
        r12 = r11.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0129, code lost:
        if (r12.hasNext() == false) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x012b, code lost:
        r13 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r12.next();
        r5 = r14;
        r14 = new p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest(new p015io.getstream.chat.android.client.api.models.QuerySort(), 0, 30, 30, 30);
        r2.L$0 = r10;
        r2.L$1 = r1;
        r2.L$2 = r11;
        r2.L$3 = r13;
        r2.L$4 = r12;
        r2.L$5 = r5;
        r2.Z$0 = r4;
        r2.label = 2;
        r14 = r13.runQueryOnline(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0164, code lost:
        if (r14 != r3) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0166, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0167, code lost:
        r15 = r10;
        r10 = r5;
        r21 = r14;
        r14 = r1;
        r1 = r21;
        r22 = r13;
        r13 = r11;
        r11 = r12;
        r12 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0174, code lost:
        r1 = (p015io.getstream.chat.android.client.utils.Result) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x017a, code lost:
        if (r1.isSuccess() == false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x017c, code lost:
        r10 = r10.isFirstPage();
        r2.L$0 = r15;
        r2.L$1 = r14;
        r2.L$2 = r13;
        r2.L$3 = r11;
        r2.L$4 = r1;
        r2.L$5 = null;
        r2.Z$0 = r4;
        r2.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x019a, code lost:
        if (r12.mo69295x48a9403b((java.util.List) r1.data(), r10, r2) != r3) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x019c, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x019d, code lost:
        r10 = r1;
        r12 = r13;
        r13 = r14;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01a1, code lost:
        r1 = (java.lang.Iterable) r10.data();
        r5 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, 10));
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ba, code lost:
        if (r1.hasNext() == false) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01bc, code lost:
        r5.add(((p015io.getstream.chat.android.client.models.Channel) r1.next()).getCid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ca, code lost:
        r13.addAll((java.util.List) r5);
        r1 = r13;
        r10 = r14;
        r21 = r12;
        r12 = r11;
        r11 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01da, code lost:
        r12 = r11;
        r11 = r13;
        r1 = r14;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01e0, code lost:
        r5 = r10.activeChannelMapImpl.entrySet();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "activeChannelMapImpl\n            .entries");
        r1 = kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.map(kotlin.sequences.SequencesKt.take(kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.SequencesKt.filter(kotlin.collections.CollectionsKt.asSequence(r5), new p015io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$1(r4)), new p015io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$2(r1)), 30), p015io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$3.INSTANCE));
        r5 = r10.isOnline();
        r10.logger.logI("recovery called: recoverAll: " + r4 + ", online: " + r5 + " retrying " + r11.size() + " queries and " + r1.size() + " channels");
        r4 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0264, code lost:
        if ((!r1.isEmpty()) == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0266, code lost:
        if (r5 == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0268, code lost:
        r6 = r10.client.queryChannels(new p015io.getstream.chat.android.client.api.models.QueryChannelsRequest(p015io.getstream.chat.android.client.models.Filters.m1008in("cid", (java.util.List<?>) r1), 0, 30, (p015io.getstream.chat.android.client.api.models.QuerySort) null, 0, 0, 56, (kotlin.jvm.internal.DefaultConstructorMarker) null)).execute();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x028e, code lost:
        if (r6.isSuccess() == false) goto L_0x0325;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0290, code lost:
        r4 = r6.data();
        r6 = r4;
        r11 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, 10));
        r6 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x02ac, code lost:
        if (r6.hasNext() == false) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x02ae, code lost:
        r11.add(((p015io.getstream.chat.android.client.models.Channel) r6.next()).getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02bc, code lost:
        r11 = (java.util.List) r11;
        r6 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02c6, code lost:
        if (r6.hasNext() == false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02c8, code lost:
        r7 = (p015io.getstream.chat.android.client.models.Channel) r6.next();
        r10.channel$stream_chat_android_offline_release(r7).updateLiveDataFromChannel(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02d6, code lost:
        r7 = new java.util.ArrayList();
        r6 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02e8, code lost:
        if (r6.hasNext() == false) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02ea, code lost:
        r12 = r6.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02fd, code lost:
        if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11.contains((java.lang.String) r12)).booleanValue() != false) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02ff, code lost:
        r7.add(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0303, code lost:
        r6 = r7;
        r2.L$0 = r10;
        r2.L$1 = r1;
        r2.L$2 = r6;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.Z$0 = r5;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x031d, code lost:
        if (r10.storeStateForChannels(r4, r2) != r3) goto L_0x0320;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x031f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0320, code lost:
        r7 = r1;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0322, code lost:
        r5 = r4;
        r4 = r6;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0325, code lost:
        r7 = r1;
        r6 = r4.iterator();
        r4 = r5;
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0331, code lost:
        if (r6.hasNext() == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0333, code lost:
        r1 = r5.channel$stream_chat_android_offline_release((java.lang.String) r6.next());
        r2.L$0 = r5;
        r2.L$1 = r7;
        r2.L$2 = r6;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.Z$0 = r4;
        r2.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0353, code lost:
        if (p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.watch$default(r1, 0, r2, 1, (java.lang.Object) null) != r3) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0355, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0356, code lost:
        r2.L$0 = r5;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.Z$0 = r4;
        r2.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x036b, code lost:
        if (r5.replayEventsForChannels$stream_chat_android_offline_release(r7, r2) != r3) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x036d, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x036e, code lost:
        r10 = r5;
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0370, code lost:
        if (r5 == false) goto L_0x0388;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0372, code lost:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0385, code lost:
        if (r10.retryFailedEntities$stream_chat_android_offline_release(r2) != r3) goto L_0x0388;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0387, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x038a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connectionRecovered(boolean r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$1 r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$1 r2 = new io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r6 = 3
            r7 = 10
            r8 = 1
            r9 = 0
            switch(r4) {
                case 0: goto L_0x00b1;
                case 1: goto L_0x00a7;
                case 2: goto L_0x0088;
                case 3: goto L_0x006d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0045;
                case 6: goto L_0x003a;
                case 7: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0388
        L_0x003a:
            boolean r4 = r2.Z$0
            java.lang.Object r5 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r5
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x036e
        L_0x0045:
            boolean r4 = r2.Z$0
            java.lang.Object r6 = r2.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r2.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r10 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r10
            r10 = 0
            goto L_0x032d
        L_0x005a:
            boolean r4 = r2.Z$0
            java.lang.Object r6 = r2.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r2.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r10 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r10
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0322
        L_0x006d:
            boolean r4 = r2.Z$0
            java.lang.Object r10 = r2.L$4
            io.getstream.chat.android.client.utils.Result r10 = (p015io.getstream.chat.android.client.utils.Result) r10
            java.lang.Object r11 = r2.L$3
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$2
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r2.L$1
            java.util.Set r13 = (java.util.Set) r13
            java.lang.Object r14 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r14 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r14
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01a1
        L_0x0088:
            boolean r4 = r2.Z$0
            java.lang.Object r10 = r2.L$5
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r10 = (p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest) r10
            java.lang.Object r11 = r2.L$4
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$3
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r12 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r12
            java.lang.Object r13 = r2.L$2
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r14 = r2.L$1
            java.util.Set r14 = (java.util.Set) r14
            java.lang.Object r15 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r15 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r15
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0174
        L_0x00a7:
            boolean r4 = r2.Z$0
            java.lang.Object r10 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r10
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00cd
        L_0x00b1:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.coroutines.Deferred<io.getstream.chat.android.livedata.model.SyncState> r1 = r0.initJob
            if (r1 != 0) goto L_0x00bd
            java.lang.String r4 = "initJob"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x00bd:
            r2.L$0 = r0
            r4 = r24
            r2.Z$0 = r4
            r2.label = r8
            java.lang.Object r1 = r1.join(r2)
            if (r1 != r3) goto L_0x00cc
            return r3
        L_0x00cc:
            r10 = r0
        L_0x00cd:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            java.util.Set r1 = (java.util.Set) r1
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl> r11 = r10.activeQueryMapImpl
            java.util.Collection r11 = r11.values()
            java.lang.String r12 = "activeQueryMapImpl.values"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r11 = kotlin.collections.CollectionsKt.toList(r11)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x00f2:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0119
            java.lang.Object r13 = r11.next()
            r14 = r13
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r14 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r14
            boolean r14 = r14.getRecoveryNeeded()
            if (r14 != 0) goto L_0x010a
            if (r4 == 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r14 = 0
            goto L_0x010b
        L_0x010a:
            r14 = 1
        L_0x010b:
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x00f2
            r12.add(r13)
            goto L_0x00f2
        L_0x0119:
            java.util.List r12 = (java.util.List) r12
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.List r11 = kotlin.collections.CollectionsKt.take(r12, r6)
            java.util.Iterator r12 = r11.iterator()
        L_0x0125:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01e0
            java.lang.Object r13 = r12.next()
            io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl r13 = (p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl) r13
            io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r15 = new io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest
            io.getstream.chat.android.client.api.models.QuerySort r16 = new io.getstream.chat.android.client.api.models.QuerySort
            r16.<init>()
            r17 = 0
            r18 = 30
            r19 = 30
            r20 = 30
            r14 = r15
            r5 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            r2.L$0 = r10
            r2.L$1 = r1
            r2.L$2 = r11
            r2.L$3 = r13
            r2.L$4 = r12
            r2.L$5 = r5
            r2.Z$0 = r4
            r14 = 2
            r2.label = r14
            java.lang.Object r14 = r13.runQueryOnline(r5, r2)
            if (r14 != r3) goto L_0x0167
            return r3
        L_0x0167:
            r15 = r10
            r10 = r5
            r21 = r14
            r14 = r1
            r1 = r21
            r22 = r13
            r13 = r11
            r11 = r12
            r12 = r22
        L_0x0174:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            boolean r5 = r1.isSuccess()
            if (r5 == 0) goto L_0x01da
            java.lang.Object r5 = r1.data()
            java.util.List r5 = (java.util.List) r5
            boolean r10 = r10.isFirstPage()
            r2.L$0 = r15
            r2.L$1 = r14
            r2.L$2 = r13
            r2.L$3 = r11
            r2.L$4 = r1
            r2.L$5 = r9
            r2.Z$0 = r4
            r2.label = r6
            java.lang.Object r5 = r12.mo69295x48a9403b(r5, r10, r2)
            if (r5 != r3) goto L_0x019d
            return r3
        L_0x019d:
            r10 = r1
            r12 = r13
            r13 = r14
            r14 = r15
        L_0x01a1:
            java.lang.Object r1 = r10.data()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r5 = new java.util.ArrayList
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r7)
            r5.<init>(r10)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x01b6:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto L_0x01ca
            java.lang.Object r10 = r1.next()
            io.getstream.chat.android.client.models.Channel r10 = (p015io.getstream.chat.android.client.models.Channel) r10
            java.lang.String r10 = r10.getCid()
            r5.add(r10)
            goto L_0x01b6
        L_0x01ca:
            java.util.List r5 = (java.util.List) r5
            java.util.Collection r5 = (java.util.Collection) r5
            r13.addAll(r5)
            r1 = r13
            r10 = r14
            r21 = r12
            r12 = r11
            r11 = r21
            goto L_0x0125
        L_0x01da:
            r12 = r11
            r11 = r13
            r1 = r14
            r10 = r15
            goto L_0x0125
        L_0x01e0:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, io.getstream.chat.android.livedata.controller.ChannelControllerImpl> r5 = r10.activeChannelMapImpl
            java.util.Set r5 = r5.entrySet()
            java.lang.String r6 = "activeChannelMapImpl\n            .entries"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            kotlin.sequences.Sequence r5 = kotlin.collections.CollectionsKt.asSequence(r5)
            io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$1 r6 = new io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$1
            r6.<init>(r4)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt.filter(r5, r6)
            io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$2 r6 = new io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$2
            r6.<init>(r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt.filterNot(r5, r6)
            r5 = 30
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt.take(r1, r5)
            io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$3 r5 = p015io.getstream.chat.android.livedata.ChatDomainImpl$connectionRecovered$cids$3.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt.map(r1, r5)
            java.util.List r1 = kotlin.sequences.SequencesKt.toList(r1)
            boolean r5 = r10.isOnline()
            io.getstream.chat.android.client.logger.TaggedLogger r6 = r10.logger
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "recovery called: recoverAll: "
            r12.append(r13)
            r12.append(r4)
            java.lang.String r4 = ", online: "
            r12.append(r4)
            r12.append(r5)
            java.lang.String r4 = " retrying "
            r12.append(r4)
            int r4 = r11.size()
            r12.append(r4)
            java.lang.String r4 = " queries and "
            r12.append(r4)
            int r4 = r1.size()
            r12.append(r4)
            java.lang.String r4 = " channels"
            r12.append(r4)
            java.lang.String r4 = r12.toString()
            r6.logI(r4)
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r8
            if (r6 == 0) goto L_0x0370
            if (r5 == 0) goto L_0x0370
            java.lang.String r6 = "cid"
            io.getstream.chat.android.client.utils.FilterObject r12 = p015io.getstream.chat.android.client.models.Filters.m1008in((java.lang.String) r6, (java.util.List<?>) r1)
            io.getstream.chat.android.client.api.models.QueryChannelsRequest r6 = new io.getstream.chat.android.client.api.models.QueryChannelsRequest
            r13 = 0
            r14 = 30
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 56
            r19 = 0
            r11 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            io.getstream.chat.android.client.ChatClient r11 = r10.client
            io.getstream.chat.android.client.call.Call r6 = r11.queryChannels(r6)
            io.getstream.chat.android.client.utils.Result r6 = r6.execute()
            boolean r11 = r6.isSuccess()
            if (r11 == 0) goto L_0x0325
            java.lang.Object r4 = r6.data()
            java.util.List r4 = (java.util.List) r4
            r6 = r4
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r11 = new java.util.ArrayList
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r7)
            r11.<init>(r7)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r6 = r6.iterator()
        L_0x02a8:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x02bc
            java.lang.Object r7 = r6.next()
            io.getstream.chat.android.client.models.Channel r7 = (p015io.getstream.chat.android.client.models.Channel) r7
            java.lang.String r7 = r7.getId()
            r11.add(r7)
            goto L_0x02a8
        L_0x02bc:
            java.util.List r11 = (java.util.List) r11
            java.util.Iterator r6 = r4.iterator()
        L_0x02c2:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x02d6
            java.lang.Object r7 = r6.next()
            io.getstream.chat.android.client.models.Channel r7 = (p015io.getstream.chat.android.client.models.Channel) r7
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r12 = r10.channel$stream_chat_android_offline_release((p015io.getstream.chat.android.client.models.Channel) r7)
            r12.updateLiveDataFromChannel(r7)
            goto L_0x02c2
        L_0x02d6:
            r6 = r1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x02e4:
            boolean r12 = r6.hasNext()
            if (r12 == 0) goto L_0x0303
            java.lang.Object r12 = r6.next()
            r13 = r12
            java.lang.String r13 = (java.lang.String) r13
            boolean r13 = r11.contains(r13)
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x02e4
            r7.add(r12)
            goto L_0x02e4
        L_0x0303:
            r6 = r7
            java.util.List r6 = (java.util.List) r6
            java.util.Collection r4 = (java.util.Collection) r4
            r2.L$0 = r10
            r2.L$1 = r1
            r2.L$2 = r6
            r2.L$3 = r9
            r2.L$4 = r9
            r2.L$5 = r9
            r2.Z$0 = r5
            r7 = 4
            r2.label = r7
            java.lang.Object r4 = r10.storeStateForChannels(r4, r2)
            if (r4 != r3) goto L_0x0320
            return r3
        L_0x0320:
            r7 = r1
            r4 = r5
        L_0x0322:
            r5 = r4
            r4 = r6
            r1 = r7
        L_0x0325:
            java.util.Iterator r4 = r4.iterator()
            r7 = r1
            r6 = r4
            r4 = r5
            r5 = r10
        L_0x032d:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0356
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            io.getstream.chat.android.livedata.controller.ChannelControllerImpl r1 = r5.channel$stream_chat_android_offline_release((java.lang.String) r1)
            r2.L$0 = r5
            r2.L$1 = r7
            r2.L$2 = r6
            r2.L$3 = r9
            r2.L$4 = r9
            r2.L$5 = r9
            r2.Z$0 = r4
            r10 = 5
            r2.label = r10
            r10 = 0
            java.lang.Object r1 = p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl.watch$default(r1, r10, r2, r8, r9)
            if (r1 != r3) goto L_0x032d
            return r3
        L_0x0356:
            r2.L$0 = r5
            r2.L$1 = r9
            r2.L$2 = r9
            r2.L$3 = r9
            r2.L$4 = r9
            r2.L$5 = r9
            r2.Z$0 = r4
            r1 = 6
            r2.label = r1
            java.lang.Object r1 = r5.replayEventsForChannels$stream_chat_android_offline_release(r7, r2)
            if (r1 != r3) goto L_0x036e
            return r3
        L_0x036e:
            r10 = r5
            r5 = r4
        L_0x0370:
            if (r5 == 0) goto L_0x0388
            r2.L$0 = r9
            r2.L$1 = r9
            r2.L$2 = r9
            r2.L$3 = r9
            r2.L$4 = r9
            r2.L$5 = r9
            r1 = 7
            r2.label = r1
            java.lang.Object r1 = r10.retryFailedEntities$stream_chat_android_offline_release(r2)
            if (r1 != r3) goto L_0x0388
            return r3
        L_0x0388:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.connectionRecovered(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object retryFailedEntities$stream_chat_android_offline_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$retryFailedEntities$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.getstream.chat.android.livedata.ChatDomainImpl$retryFailedEntities$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$retryFailedEntities$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$retryFailedEntities$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$retryFailedEntities$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0067
            if (r2 == r6) goto L_0x005f
            if (r2 == r5) goto L_0x0057
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r1 = r0.L$2
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00aa
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0048:
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x0095
        L_0x0057:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0083
        L_0x005f:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0078
        L_0x0067:
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r10
            r0.label = r6
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r11 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r2 = r10
        L_0x0078:
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r11 = r2.retryChannels$stream_chat_android_offline_release(r0)
            if (r11 != r1) goto L_0x0083
            return r1
        L_0x0083:
            java.util.List r11 = (java.util.List) r11
            r0.L$0 = r2
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r4 = r2.retryMessages$stream_chat_android_offline_release(r0)
            if (r4 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r9 = r4
            r4 = r11
            r11 = r9
        L_0x0095:
            java.util.List r11 = (java.util.List) r11
            r0.L$0 = r2
            r0.L$1 = r4
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r0 = r2.retryReactions$stream_chat_android_offline_release(r0)
            if (r0 != r1) goto L_0x00a6
            return r1
        L_0x00a6:
            r1 = r11
            r11 = r0
            r0 = r2
            r2 = r4
        L_0x00aa:
            java.util.List r11 = (java.util.List) r11
            io.getstream.chat.android.client.logger.TaggedLogger r0 = r0.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Retried "
            r3.append(r4)
            int r2 = r2.size()
            r3.append(r2)
            java.lang.String r2 = " channel entities, "
            r3.append(r2)
            int r1 = r1.size()
            r3.append(r1)
            java.lang.String r1 = " messages and "
            r3.append(r1)
            int r11 = r11.size()
            r3.append(r11)
            java.lang.String r11 = " reaction entities"
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            r0.logI(r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.retryFailedEntities$stream_chat_android_offline_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object retryChannels$stream_chat_android_offline_release(kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>> r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$retryChannels$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.ChatDomainImpl$retryChannels$1 r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$retryChannels$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.ChatDomainImpl$retryChannels$1 r2 = new io.getstream.chat.android.livedata.ChatDomainImpl$retryChannels$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            java.lang.String r9 = "repos"
            if (r4 == 0) goto L_0x007c
            if (r4 == r8) goto L_0x0074
            if (r4 == r7) goto L_0x005f
            if (r4 == r6) goto L_0x004e
            if (r4 != r5) goto L_0x0046
            java.lang.Object r4 = r2.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r8 = r2.L$1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.Object r10 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r10
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0158
        L_0x0046:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004e:
            java.lang.Object r4 = r2.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r8 = r2.L$1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.Object r10 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r10
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0121
        L_0x005f:
            java.lang.Object r4 = r2.L$3
            io.getstream.chat.android.client.models.Channel r4 = (p015io.getstream.chat.android.client.models.Channel) r4
            java.lang.Object r8 = r2.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r10 = r2.L$1
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.lang.Object r11 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r11
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00f8
        L_0x0074:
            java.lang.Object r4 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0092
        L_0x007c:
            kotlin.ResultKt.throwOnFailure(r1)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r0.repos
            if (r1 != 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0086:
            r2.L$0 = r0
            r2.label = r8
            java.lang.Object r1 = r1.selectChannelsSyncNeeded(r2)
            if (r1 != r3) goto L_0x0091
            return r3
        L_0x0091:
            r4 = r0
        L_0x0092:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r8 = r1.iterator()
        L_0x0098:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x015f
            java.lang.Object r10 = r8.next()
            io.getstream.chat.android.client.models.Channel r10 = (p015io.getstream.chat.android.client.models.Channel) r10
            io.getstream.chat.android.client.ChatClient r11 = r4.client
            java.lang.String r12 = r10.getType()
            java.lang.String r13 = r10.getId()
            java.util.List r14 = r10.getMembers()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r15 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r5)
            r15.<init>(r5)
            java.util.Collection r15 = (java.util.Collection) r15
            java.util.Iterator r5 = r14.iterator()
        L_0x00c5:
            boolean r14 = r5.hasNext()
            if (r14 == 0) goto L_0x00d9
            java.lang.Object r14 = r5.next()
            io.getstream.chat.android.client.models.UserEntity r14 = (p015io.getstream.chat.android.client.models.UserEntity) r14
            java.lang.String r14 = r14.getUserId()
            r15.add(r14)
            goto L_0x00c5
        L_0x00d9:
            java.util.List r15 = (java.util.List) r15
            java.util.Map r5 = r10.getExtraData()
            io.getstream.chat.android.client.call.Call r5 = r11.createChannel(r12, r13, r15, r5)
            r2.L$0 = r4
            r2.L$1 = r1
            r2.L$2 = r8
            r2.L$3 = r10
            r2.label = r7
            java.lang.Object r5 = p015io.getstream.chat.android.client.call.CallKt.await(r5, r2)
            if (r5 != r3) goto L_0x00f4
            return r3
        L_0x00f4:
            r11 = r4
            r4 = r10
            r10 = r1
            r1 = r5
        L_0x00f8:
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            boolean r5 = r1.isSuccess()
            r12 = 0
            if (r5 == 0) goto L_0x0127
            io.getstream.chat.android.client.utils.SyncStatus r1 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r4.setSyncStatus(r1)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r11.repos
            if (r1 != 0) goto L_0x010d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x010d:
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r8
            r2.L$3 = r12
            r2.label = r6
            java.lang.Object r1 = r1.insertChannel(r4, r2)
            if (r1 != r3) goto L_0x011e
            return r3
        L_0x011e:
            r4 = r8
            r8 = r10
            r10 = r11
        L_0x0121:
            r1 = r8
            r5 = 4
        L_0x0123:
            r8 = r4
            r4 = r10
            goto L_0x0098
        L_0x0127:
            boolean r5 = r1.isError()
            if (r5 == 0) goto L_0x015a
            io.getstream.chat.android.client.errors.ChatError r1 = r1.error()
            boolean r1 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r1)
            if (r1 == 0) goto L_0x015a
            io.getstream.chat.android.client.utils.SyncStatus r1 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            r4.setSyncStatus(r1)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r11.repos
            if (r1 != 0) goto L_0x0143
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0143:
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r8
            r2.L$3 = r12
            r5 = 4
            r2.label = r5
            java.lang.Object r1 = r1.insertChannel(r4, r2)
            if (r1 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r4 = r8
            r8 = r10
            r10 = r11
        L_0x0158:
            r1 = r8
            goto L_0x0123
        L_0x015a:
            r5 = 4
            r1 = r10
            r4 = r11
            goto L_0x0098
        L_0x015f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.retryChannels$stream_chat_android_offline_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a6 A[SYNTHETIC] */
    public final java.lang.Object retryMessages$stream_chat_android_offline_release(kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Message>> r51) {
        /*
            r50 = this;
            r0 = r50
            r1 = r51
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$retryMessages$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.ChatDomainImpl$retryMessages$1 r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$retryMessages$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.ChatDomainImpl$retryMessages$1 r2 = new io.getstream.chat.android.livedata.ChatDomainImpl$retryMessages$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 1
            java.lang.String r8 = "repos"
            if (r4 == 0) goto L_0x0054
            if (r4 == r7) goto L_0x004c
            if (r4 == r6) goto L_0x003b
            if (r4 != r5) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            java.lang.Object r4 = r2.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r7 = r2.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r9 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r9
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x012d
        L_0x004c:
            java.lang.Object r4 = r2.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r4 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x006a
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r1)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r1 = r0.repos
            if (r1 != 0) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x005e:
            r2.L$0 = r0
            r2.label = r7
            java.lang.Object r1 = r1.selectMessagesSyncNeeded(r2)
            if (r1 != r3) goto L_0x0069
            return r3
        L_0x0069:
            r4 = r0
        L_0x006a:
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r7 = r1.iterator()
            r49 = r7
            r7 = r1
            r1 = r4
            r4 = r49
        L_0x0076:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x01a6
            java.lang.Object r9 = r4.next()
            r10 = r9
            io.getstream.chat.android.client.models.Message r10 = (p015io.getstream.chat.android.client.models.Message) r10
            io.getstream.chat.android.client.ChatClient r9 = r1.client
            java.lang.String r11 = r10.getCid()
            io.getstream.chat.android.client.channel.ChannelClient r9 = r9.channel(r11)
            java.util.Date r11 = r10.getDeletedAt()
            if (r11 == 0) goto L_0x00a0
            java.lang.String r11 = r10.getId()
            io.getstream.chat.android.client.call.Call r9 = r9.deleteMessage(r11)
            io.getstream.chat.android.client.utils.Result r9 = r9.execute()
            goto L_0x00c0
        L_0x00a0:
            java.util.Date r11 = r10.getUpdatedAt()
            if (r11 != 0) goto L_0x00b6
            java.util.Date r11 = r10.getUpdatedLocallyAt()
            if (r11 == 0) goto L_0x00ad
            goto L_0x00b6
        L_0x00ad:
            io.getstream.chat.android.client.call.Call r9 = r9.sendMessage(r10)
            io.getstream.chat.android.client.utils.Result r9 = r9.execute()
            goto L_0x00c0
        L_0x00b6:
            io.getstream.chat.android.client.ChatClient r9 = r1.client
            io.getstream.chat.android.client.call.Call r9 = r9.updateMessage(r10)
            io.getstream.chat.android.client.utils.Result r9 = r9.execute()
        L_0x00c0:
            boolean r11 = r9.isSuccess()
            if (r11 == 0) goto L_0x0130
            io.getstream.chat.android.livedata.repository.RepositoryFacade r9 = r1.repos
            if (r9 != 0) goto L_0x00cd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x00cd:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r9 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            io.getstream.chat.android.client.utils.SyncStatus r23 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = -4097(0xffffffffffffefff, float:NaN)
            r47 = 7
            r48 = 0
            io.getstream.chat.android.client.models.Message r10 = p015io.getstream.chat.android.client.models.Message.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48)
            r11 = 0
            r13 = 2
            r2.L$0 = r1
            r2.L$1 = r7
            r2.L$2 = r4
            r2.label = r6
            r12 = r2
            java.lang.Object r9 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r9, r10, r11, r12, r13, r14)
            if (r9 != r3) goto L_0x012c
            return r3
        L_0x012c:
            r9 = r1
        L_0x012d:
            r1 = r9
            goto L_0x0076
        L_0x0130:
            boolean r11 = r9.isError()
            if (r11 == 0) goto L_0x0076
            io.getstream.chat.android.client.errors.ChatError r9 = r9.error()
            boolean r9 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r9)
            if (r9 == 0) goto L_0x0076
            io.getstream.chat.android.livedata.repository.RepositoryFacade r9 = r1.repos
            if (r9 != 0) goto L_0x0147
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x0147:
            io.getstream.chat.android.livedata.repository.domain.message.MessageRepository r9 = (p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository) r9
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            io.getstream.chat.android.client.utils.SyncStatus r23 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = -4097(0xffffffffffffefff, float:NaN)
            r47 = 7
            r48 = 0
            io.getstream.chat.android.client.models.Message r10 = p015io.getstream.chat.android.client.models.Message.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48)
            r11 = 0
            r13 = 2
            r2.L$0 = r1
            r2.L$1 = r7
            r2.L$2 = r4
            r2.label = r5
            r12 = r2
            java.lang.Object r9 = p015io.getstream.chat.android.livedata.repository.domain.message.MessageRepository.DefaultImpls.insertMessage$default(r9, r10, r11, r12, r13, r14)
            if (r9 != r3) goto L_0x012c
            return r3
        L_0x01a6:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.retryMessages$stream_chat_android_offline_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object retryReactions$stream_chat_android_offline_release(kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Reaction>> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$retryReactions$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.getstream.chat.android.livedata.ChatDomainImpl$retryReactions$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$retryReactions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$retryReactions$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$retryReactions$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = "repos"
            if (r2 == 0) goto L_0x004f
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            goto L_0x0037
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0037:
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$1
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r7 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r7 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x006e
        L_0x0047:
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0065
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r12)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r12 = r11.repos
            if (r12 != 0) goto L_0x0059
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0059:
            r0.L$0 = r11
            r0.label = r5
            java.lang.Object r12 = r12.selectReactionsSyncNeeded(r0)
            if (r12 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r11
        L_0x0065:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r5 = r12.iterator()
            r7 = r2
            r2 = r5
            r5 = r12
        L_0x006e:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x00ed
            java.lang.Object r12 = r2.next()
            io.getstream.chat.android.client.models.Reaction r12 = (p015io.getstream.chat.android.client.models.Reaction) r12
            r8 = 0
            io.getstream.chat.android.client.models.User r8 = (p015io.getstream.chat.android.client.models.User) r8
            r12.setUser(r8)
            java.util.Date r8 = r12.getDeletedAt()
            if (r8 == 0) goto L_0x0099
            io.getstream.chat.android.client.ChatClient r8 = r7.client
            java.lang.String r9 = r12.getMessageId()
            java.lang.String r10 = r12.getType()
            io.getstream.chat.android.client.call.Call r8 = r8.deleteReaction(r9, r10)
            io.getstream.chat.android.client.utils.Result r8 = r8.execute()
            goto L_0x00a7
        L_0x0099:
            io.getstream.chat.android.client.ChatClient r8 = r7.client
            boolean r9 = r12.getEnforceUnique()
            io.getstream.chat.android.client.call.Call r8 = r8.sendReaction((p015io.getstream.chat.android.client.models.Reaction) r12, (boolean) r9)
            io.getstream.chat.android.client.utils.Result r8 = r8.execute()
        L_0x00a7:
            boolean r9 = r8.isSuccess()
            if (r9 == 0) goto L_0x00c8
            io.getstream.chat.android.client.utils.SyncStatus r8 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r12.setSyncStatus(r8)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r8 = r7.repos
            if (r8 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x00b9:
            r0.L$0 = r7
            r0.L$1 = r5
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r12 = r8.insertReaction(r12, r0)
            if (r12 != r1) goto L_0x006e
            return r1
        L_0x00c8:
            io.getstream.chat.android.client.errors.ChatError r8 = r8.error()
            boolean r8 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.isPermanent(r8)
            if (r8 == 0) goto L_0x006e
            io.getstream.chat.android.client.utils.SyncStatus r8 = p015io.getstream.chat.android.client.utils.SyncStatus.FAILED_PERMANENTLY
            r12.setSyncStatus(r8)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r8 = r7.repos
            if (r8 != 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x00de:
            r0.L$0 = r7
            r0.L$1 = r5
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r12 = r8.insertReaction(r12, r0)
            if (r12 != r1) goto L_0x006e
            return r1
        L_0x00ed:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.retryReactions$stream_chat_android_offline_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object storeStateForChannel(Channel channel, Continuation<? super Unit> continuation) {
        Object storeStateForChannels = storeStateForChannels(CollectionsKt.listOf(channel), continuation);
        return storeStateForChannels == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? storeStateForChannels : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object storeStateForChannels(java.util.Collection<p015io.getstream.chat.android.client.models.Channel> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$storeStateForChannels$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.getstream.chat.android.livedata.ChatDomainImpl$storeStateForChannels$1 r2 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$storeStateForChannels$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.ChatDomainImpl$storeStateForChannels$1 r2 = new io.getstream.chat.android.livedata.ChatDomainImpl$storeStateForChannels$1
            r2.<init>(r0, r1)
        L_0x001d:
            r9 = r2
            java.lang.Object r1 = r9.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r9.label
            r4 = 1
            if (r3 == 0) goto L_0x004d
            if (r3 != r4) goto L_0x0045
            java.lang.Object r2 = r9.L$4
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r9.L$3
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.Object r4 = r9.L$2
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r9.L$1
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r6 = r9.L$0
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = (p015io.getstream.chat.android.livedata.ChatDomainImpl) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r5
            goto L_0x0154
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r1)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r3 = (java.util.Set) r3
            r12 = r3
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r13 = r3
            java.util.List r13 = (java.util.List) r13
            java.util.Iterator r3 = r17.iterator()
        L_0x006d:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0120
            java.lang.Object r5 = r3.next()
            io.getstream.chat.android.client.models.Channel r5 = (p015io.getstream.chat.android.client.models.Channel) r5
            java.util.List r6 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.users((p015io.getstream.chat.android.client.models.Channel) r5)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r7)
            int r8 = kotlin.collections.MapsKt.mapCapacity(r8)
            r10 = 16
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast((int) r8, (int) r10)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>(r8)
            java.util.Map r11 = (java.util.Map) r11
            java.util.Iterator r6 = r6.iterator()
        L_0x009a:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00af
            java.lang.Object r8 = r6.next()
            r14 = r8
            io.getstream.chat.android.client.models.User r14 = (p015io.getstream.chat.android.client.models.User) r14
            java.lang.String r14 = r14.getId()
            r11.put(r14, r8)
            goto L_0x009a
        L_0x00af:
            r1.putAll(r11)
            io.getstream.chat.android.livedata.model.ChannelConfig r6 = new io.getstream.chat.android.livedata.model.ChannelConfig
            java.lang.String r8 = r5.getType()
            io.getstream.chat.android.client.models.Config r11 = r5.getConfig()
            r6.<init>(r8, r11)
            r12.add(r6)
            java.util.List r6 = r5.getMessages()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x00cc:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0115
            java.lang.Object r8 = r6.next()
            io.getstream.chat.android.client.models.Message r8 = (p015io.getstream.chat.android.client.models.Message) r8
            java.lang.String r11 = r5.getCid()
            p015io.getstream.chat.android.client.extensions.MessageExtensionsKt.enrichWithCid(r8, r11)
            java.util.List r8 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.users((p015io.getstream.chat.android.client.models.Message) r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r7)
            int r11 = kotlin.collections.MapsKt.mapCapacity(r11)
            int r11 = kotlin.ranges.RangesKt.coerceAtLeast((int) r11, (int) r10)
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>(r11)
            java.util.Map r14 = (java.util.Map) r14
            java.util.Iterator r8 = r8.iterator()
        L_0x00fc:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x0111
            java.lang.Object r11 = r8.next()
            r15 = r11
            io.getstream.chat.android.client.models.User r15 = (p015io.getstream.chat.android.client.models.User) r15
            java.lang.String r15 = r15.getId()
            r14.put(r15, r11)
            goto L_0x00fc
        L_0x0111:
            r1.putAll(r14)
            goto L_0x00cc
        L_0x0115:
            java.util.List r5 = r5.getMessages()
            java.util.Collection r5 = (java.util.Collection) r5
            r13.addAll(r5)
            goto L_0x006d
        L_0x0120:
            io.getstream.chat.android.livedata.repository.RepositoryFacade r3 = r0.repos
            if (r3 != 0) goto L_0x0129
            java.lang.String r5 = "repos"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0129:
            java.util.Collection r5 = r1.values()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = kotlin.collections.CollectionsKt.toList(r5)
            r8 = 0
            r10 = 16
            r11 = 0
            r9.L$0 = r0
            r14 = r17
            r9.L$1 = r14
            r9.L$2 = r1
            r9.L$3 = r12
            r9.L$4 = r13
            r9.label = r4
            r4 = r12
            r6 = r17
            r7 = r13
            java.lang.Object r3 = p015io.getstream.chat.android.livedata.repository.RepositoryFacade.m1016xb6c4b435(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r3 != r2) goto L_0x0150
            return r2
        L_0x0150:
            r6 = r0
            r4 = r1
            r3 = r12
            r2 = r13
        L_0x0154:
            io.getstream.chat.android.client.logger.TaggedLogger r1 = r6.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "storeStateForChannels stored "
            r5.append(r6)
            int r6 = r14.size()
            r5.append(r6)
            java.lang.String r6 = " channels, "
            r5.append(r6)
            int r3 = r3.size()
            r5.append(r3)
            java.lang.String r3 = " configs, "
            r5.append(r3)
            int r3 = r4.size()
            r5.append(r3)
            java.lang.String r3 = " users and "
            r5.append(r3)
            int r2 = r2.size()
            r5.append(r2)
            java.lang.String r2 = " messages"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r1.logI(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.storeStateForChannels(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object selectAndEnrichChannel(java.lang.String r5, p015io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest r6, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Channel> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$1 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$1 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r5)
            io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r6 = r6.mo69941xdf1ac592()
            r0.label = r3
            java.lang.Object r7 = r4.selectAndEnrichChannels((java.util.List<java.lang.String>) r5, (p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest) r6, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>>) r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.util.List r7 = (java.util.List) r7
            r5 = 0
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.selectAndEnrichChannel(java.lang.String, io.getstream.chat.android.livedata.request.QueryChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object selectAndEnrichChannel(java.lang.String r5, p015io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest r6, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.Channel> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$2
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$2 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$2 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannel$2
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r5)
            io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r6 = p015io.getstream.chat.android.livedata.request.MapperKt.toAnyChannelPaginationRequest(r6)
            r0.label = r3
            java.lang.Object r7 = r4.selectAndEnrichChannels((java.util.List<java.lang.String>) r5, (p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest) r6, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>>) r0)
            if (r7 != r1) goto L_0x0046
            return r1
        L_0x0046:
            java.util.List r7 = (java.util.List) r7
            r5 = 0
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.selectAndEnrichChannel(java.lang.String, io.getstream.chat.android.livedata.request.QueryChannelsPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object selectAndEnrichChannels(List<String> list, QueryChannelsPaginationRequest queryChannelsPaginationRequest, Continuation<? super List<Channel>> continuation) {
        return selectAndEnrichChannels(list, MapperKt.toAnyChannelPaginationRequest(queryChannelsPaginationRequest), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object selectAndEnrichChannels(java.util.List<java.lang.String> r5, p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r6, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.Channel>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof p015io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannels$2
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannels$2 r0 = (p015io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannels$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannels$2 r0 = new io.getstream.chat.android.livedata.ChatDomainImpl$selectAndEnrichChannels$2
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            r6 = r5
            io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest r6 = (p015io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004e
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r7 = r4.repos
            if (r7 != 0) goto L_0x0043
            java.lang.String r2 = "repos"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0043:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.selectChannels$stream_chat_android_offline_release(r5, r6, r0)
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.List r5 = p015io.getstream.chat.android.livedata.extensions.ClientExtensionsKt.applyPagination(r7, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.selectAndEnrichChannels(java.util.List, io.getstream.chat.android.livedata.request.AnyChannelPaginationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void clean() {
        Collection<ChannelControllerImpl> values = this.activeChannelMapImpl.values();
        Intrinsics.checkNotNullExpressionValue(values, "activeChannelMapImpl.values");
        for (ChannelControllerImpl clean : CollectionsKt.toList(values)) {
            clean.clean();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r3 = r3.getConfig();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p015io.getstream.chat.android.client.models.Config getChannelConfig(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "channelType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.getstream.chat.android.livedata.repository.RepositoryFacade r0 = r2.repos
            if (r0 != 0) goto L_0x000e
            java.lang.String r1 = "repos"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x000e:
            io.getstream.chat.android.livedata.model.ChannelConfig r3 = r0.selectChannelConfig(r3)
            if (r3 == 0) goto L_0x001b
            io.getstream.chat.android.client.models.Config r3 = r3.getConfig()
            if (r3 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            io.getstream.chat.android.client.models.Config r3 = r2.defaultConfig
        L_0x001d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.ChatDomainImpl.getChannelConfig(java.lang.String):io.getstream.chat.android.client.models.Config");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/ChatDomainImpl$Companion;", "", "()V", "EMPTY_DISPOSABLE", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "getEMPTY_DISPOSABLE", "()Lio/getstream/chat/android/client/utils/observable/Disposable;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.ChatDomainImpl$Companion */
    /* compiled from: ChatDomainImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Disposable getEMPTY_DISPOSABLE() {
            return ChatDomainImpl.EMPTY_DISPOSABLE;
        }
    }
}
