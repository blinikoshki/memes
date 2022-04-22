package com.memes.plus.firebase;

import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/firebase/PushNotificationIdGenerator;", "", "()V", "generate", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PushNotificationIdGenerator.kt */
public final class PushNotificationIdGenerator {
    public static final PushNotificationIdGenerator INSTANCE = new PushNotificationIdGenerator();

    private PushNotificationIdGenerator() {
    }

    public final int generate() {
        return Random.Default.nextInt(10000, 99999);
    }
}
