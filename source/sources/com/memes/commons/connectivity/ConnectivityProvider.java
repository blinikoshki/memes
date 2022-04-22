package com.memes.commons.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider;", "", "addListener", "", "listener", "Lcom/memes/commons/connectivity/ConnectivityProvider$ConnectivityStateListener;", "getNetworkState", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "removeListener", "Companion", "ConnectivityStateListener", "NetworkState", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ConnectivityProvider.kt */
public interface ConnectivityProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$ConnectivityStateListener;", "", "onStateChange", "", "state", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ConnectivityProvider.kt */
    public interface ConnectivityStateListener {
        void onStateChange(NetworkState networkState);
    }

    void addListener(ConnectivityStateListener connectivityStateListener);

    NetworkState getNetworkState();

    void removeListener(ConnectivityStateListener connectivityStateListener);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "", "()V", "ConnectedState", "NotConnectedState", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$NotConnectedState;", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ConnectivityProvider.kt */
    public static abstract class NetworkState {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$NotConnectedState;", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "()V", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ConnectivityProvider.kt */
        public static final class NotConnectedState extends NetworkState {
            public static final NotConnectedState INSTANCE = new NotConnectedState();

            private NotConnectedState() {
                super((DefaultConstructorMarker) null);
            }
        }

        private NetworkState() {
        }

        public /* synthetic */ NetworkState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState;", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState;", "hasInternet", "", "(Z)V", "getHasInternet", "()Z", "Connected", "ConnectedLegacy", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState$Connected;", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState$ConnectedLegacy;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: ConnectivityProvider.kt */
        public static abstract class ConnectedState extends NetworkState {
            private final boolean hasInternet;

            private ConnectedState(boolean z) {
                super((DefaultConstructorMarker) null);
                this.hasInternet = z;
            }

            public /* synthetic */ ConnectedState(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
                this(z);
            }

            public final boolean getHasInternet() {
                return this.hasInternet;
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState$Connected;", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState;", "capabilities", "Landroid/net/NetworkCapabilities;", "(Landroid/net/NetworkCapabilities;)V", "getCapabilities", "()Landroid/net/NetworkCapabilities;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* compiled from: ConnectivityProvider.kt */
            public static final class Connected extends ConnectedState {
                private final NetworkCapabilities capabilities;

                public static /* synthetic */ Connected copy$default(Connected connected, NetworkCapabilities networkCapabilities, int i, Object obj) {
                    if ((i & 1) != 0) {
                        networkCapabilities = connected.capabilities;
                    }
                    return connected.copy(networkCapabilities);
                }

                public final NetworkCapabilities component1() {
                    return this.capabilities;
                }

                public final Connected copy(NetworkCapabilities networkCapabilities) {
                    Intrinsics.checkNotNullParameter(networkCapabilities, "capabilities");
                    return new Connected(networkCapabilities);
                }

                public boolean equals(Object obj) {
                    if (this != obj) {
                        return (obj instanceof Connected) && Intrinsics.areEqual((Object) this.capabilities, (Object) ((Connected) obj).capabilities);
                    }
                    return true;
                }

                public int hashCode() {
                    NetworkCapabilities networkCapabilities = this.capabilities;
                    if (networkCapabilities != null) {
                        return networkCapabilities.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    return "Connected(capabilities=" + this.capabilities + ")";
                }

                public final NetworkCapabilities getCapabilities() {
                    return this.capabilities;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Connected(NetworkCapabilities networkCapabilities) {
                    super(networkCapabilities.hasCapability(12), (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(networkCapabilities, "capabilities");
                    this.capabilities = networkCapabilities;
                }
            }

            @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState$ConnectedLegacy;", "Lcom/memes/commons/connectivity/ConnectivityProvider$NetworkState$ConnectedState;", "networkInfo", "Landroid/net/NetworkInfo;", "(Landroid/net/NetworkInfo;)V", "getNetworkInfo", "()Landroid/net/NetworkInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
            /* compiled from: ConnectivityProvider.kt */
            public static final class ConnectedLegacy extends ConnectedState {
                private final NetworkInfo networkInfo;

                public static /* synthetic */ ConnectedLegacy copy$default(ConnectedLegacy connectedLegacy, NetworkInfo networkInfo2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        networkInfo2 = connectedLegacy.networkInfo;
                    }
                    return connectedLegacy.copy(networkInfo2);
                }

                public final NetworkInfo component1() {
                    return this.networkInfo;
                }

                public final ConnectedLegacy copy(NetworkInfo networkInfo2) {
                    Intrinsics.checkNotNullParameter(networkInfo2, "networkInfo");
                    return new ConnectedLegacy(networkInfo2);
                }

                public boolean equals(Object obj) {
                    if (this != obj) {
                        return (obj instanceof ConnectedLegacy) && Intrinsics.areEqual((Object) this.networkInfo, (Object) ((ConnectedLegacy) obj).networkInfo);
                    }
                    return true;
                }

                public int hashCode() {
                    NetworkInfo networkInfo2 = this.networkInfo;
                    if (networkInfo2 != null) {
                        return networkInfo2.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    return "ConnectedLegacy(networkInfo=" + this.networkInfo + ")";
                }

                public final NetworkInfo getNetworkInfo() {
                    return this.networkInfo;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ConnectedLegacy(NetworkInfo networkInfo2) {
                    super(networkInfo2.isConnectedOrConnecting(), (DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(networkInfo2, "networkInfo");
                    this.networkInfo = networkInfo2;
                }
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/commons/connectivity/ConnectivityProvider$Companion;", "", "()V", "createProvider", "Lcom/memes/commons/connectivity/ConnectivityProvider;", "context", "Landroid/content/Context;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ConnectivityProvider.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ConnectivityProvider createProvider(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT >= 24) {
                return new ConnectivityProviderImpl(connectivityManager);
            }
            return new ConnectivityProviderLegacyImpl(context, connectivityManager);
        }
    }
}
