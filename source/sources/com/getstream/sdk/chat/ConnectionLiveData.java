package com.getstream.sdk.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.lifecycle.LiveData;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

public class ConnectionLiveData extends LiveData<ConnectionModel> {
    private Context context;
    /* access modifiers changed from: private */
    public TaggedLogger logger = ChatLogger.Companion.get("ConnectionLiveData");
    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras() != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    ConnectionLiveData.this.logger.logE("Can't get access to ConnectivityManager");
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        ConnectionLiveData connectionLiveData = ConnectionLiveData.this;
                        connectionLiveData.postValue(new ConnectionModel(0, true));
                    } else if (type == 1) {
                        ConnectionLiveData connectionLiveData2 = ConnectionLiveData.this;
                        connectionLiveData2.postValue(new ConnectionModel(1, true));
                    }
                } else {
                    ConnectionLiveData connectionLiveData3 = ConnectionLiveData.this;
                    connectionLiveData3.postValue(new ConnectionModel(0, false));
                }
            }
        }
    };

    public ConnectionLiveData(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        this.context.registerReceiver(this.networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        this.context.unregisterReceiver(this.networkReceiver);
    }

    public class ConnectionModel {
        private boolean isConnected;
        private int type;

        public ConnectionModel(int i, boolean z) {
            this.type = i;
            this.isConnected = z;
        }

        public int getType() {
            return this.type;
        }

        public boolean getIsConnected() {
            return this.isConnected;
        }
    }
}
