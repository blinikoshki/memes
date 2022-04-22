package com.appsflyer.oaid;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.oaid.OaidClient;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

class OaidMsaClient {
    OaidMsaClient() {
    }

    static OaidClient.Info fetchMsa(Context context, final Logger logger, long j, TimeUnit timeUnit) {
        String str;
        try {
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int InitSdk = MdidSdkHelper.InitSdk(context, logger.getLevel() == null, new IIdentifierListener() {
                public void OnSupport(boolean z, IdSupplier idSupplier) {
                    try {
                        linkedBlockingQueue.offer(idSupplier == null ? "" : idSupplier.getOAID());
                    } catch (Throwable th) {
                        logger.info(th.getMessage());
                    }
                }
            });
            if (InitSdk != 0) {
                switch (InitSdk) {
                    case 1008610:
                        str = "Init error begin";
                        break;
                    case 1008611:
                        str = "Unsupported manufacturer";
                        break;
                    case 1008612:
                        str = "Unsupported device";
                        break;
                    case 1008613:
                        str = "Error loading configuration file";
                        break;
                    case 1008614:
                        str = "Callback will be executed in a different thread";
                        break;
                    case 1008615:
                        str = "Reflection call error";
                        break;
                    default:
                        str = String.valueOf(InitSdk);
                        break;
                }
                logger.warning(str);
            }
            String str2 = (String) linkedBlockingQueue.poll(j, timeUnit);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new OaidClient.Info(str2);
        } catch (Throwable th) {
            logger.info(th.getMessage());
            return null;
        }
    }
}
