package p015io.getstream.chat.android.client;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.utils.observable.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\b\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000b0\n\"\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\f\u001a'\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\b\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\"\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000b0\n\"\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\r\u001a'\u0010\u000e\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\b¨\u0006\u000f"}, mo26107d2 = {"subscribeFor", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "T", "Lio/getstream/chat/android/client/events/ChatEvent;", "Lio/getstream/chat/android/client/ChatClient;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lio/getstream/chat/android/client/ChatEventListener;", "eventTypes", "", "Lkotlin/reflect/KClass;", "(Lio/getstream/chat/android/client/ChatClient;Landroidx/lifecycle/LifecycleOwner;[Lkotlin/reflect/KClass;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "(Lio/getstream/chat/android/client/ChatClient;[Lkotlin/reflect/KClass;Lio/getstream/chat/android/client/ChatEventListener;)Lio/getstream/chat/android/client/utils/observable/Disposable;", "subscribeForSingle", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ClientExtensionsKt */
/* compiled from: ClientExtensions.kt */
public final class ClientExtensionsKt {
    public static final /* synthetic */ <T extends ChatEvent> Disposable subscribeFor(ChatClient chatClient, ChatEventListener<T> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatClient, "$this$subscribeFor");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class[] clsArr = {ChatEvent.class};
        Intrinsics.needClassReification();
        return chatClient.subscribeFor((Class<? extends ChatEvent>[]) clsArr, (ChatEventListener<ChatEvent>) new ClientExtensionsKt$subscribeFor$1(chatEventListener));
    }

    public static final /* synthetic */ <T extends ChatEvent> Disposable subscribeFor(ChatClient chatClient, LifecycleOwner lifecycleOwner, ChatEventListener<T> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatClient, "$this$subscribeFor");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class[] clsArr = {ChatEvent.class};
        Intrinsics.needClassReification();
        return chatClient.subscribeFor(lifecycleOwner, (Class<? extends ChatEvent>[]) clsArr, (ChatEventListener<ChatEvent>) new ClientExtensionsKt$subscribeFor$2(chatEventListener));
    }

    public static final /* synthetic */ <T extends ChatEvent> Disposable subscribeForSingle(ChatClient chatClient, ChatEventListener<T> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatClient, "$this$subscribeForSingle");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return chatClient.subscribeForSingle(ChatEvent.class, chatEventListener);
    }

    public static final Disposable subscribeFor(ChatClient chatClient, KClass<? extends ChatEvent>[] kClassArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatClient, "$this$subscribeFor");
        Intrinsics.checkNotNullParameter(kClassArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Collection arrayList = new ArrayList(kClassArr.length);
        for (KClass<? extends ChatEvent> javaClass : kClassArr) {
            arrayList.add(JvmClassMappingKt.getJavaClass(javaClass));
        }
        Object[] array = ((List) arrayList).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class[] clsArr = (Class[]) array;
        return chatClient.subscribeFor((Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), chatEventListener);
    }

    public static final Disposable subscribeFor(ChatClient chatClient, LifecycleOwner lifecycleOwner, KClass<? extends ChatEvent>[] kClassArr, ChatEventListener<ChatEvent> chatEventListener) {
        Intrinsics.checkNotNullParameter(chatClient, "$this$subscribeFor");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(kClassArr, "eventTypes");
        Intrinsics.checkNotNullParameter(chatEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Collection arrayList = new ArrayList(kClassArr.length);
        for (KClass<? extends ChatEvent> javaClass : kClassArr) {
            arrayList.add(JvmClassMappingKt.getJavaClass(javaClass));
        }
        Object[] array = ((List) arrayList).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class[] clsArr = (Class[]) array;
        return chatClient.subscribeFor(lifecycleOwner, (Class<? extends ChatEvent>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length), chatEventListener);
    }
}
