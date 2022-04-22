package com.getstream.sdk.chat.utils.exomedia.util;

import android.content.Context;
import android.os.Build;
import com.appsflyer.AdvertisingIdUtil;
import java.util.LinkedList;
import java.util.List;

public class DeviceUtil {
    protected static final List<NonCompatibleDevice> NON_COMPATIBLE_DEVICES;

    static {
        LinkedList linkedList = new LinkedList();
        NON_COMPATIBLE_DEVICES = linkedList;
        linkedList.add(new NonCompatibleDevice(AdvertisingIdUtil.AMAZON_MANUFACTURER));
    }

    public boolean supportsExoPlayer(Context context) {
        if (Build.VERSION.SDK_INT >= 16 && !isNotCompatible(NON_COMPATIBLE_DEVICES)) {
            return true;
        }
        if (!Build.MANUFACTURER.equalsIgnoreCase(AdvertisingIdUtil.AMAZON_MANUFACTURER) || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return true;
    }

    public boolean isNotCompatible(List<NonCompatibleDevice> list) {
        for (NonCompatibleDevice next : list) {
            if (Build.MANUFACTURER.equalsIgnoreCase(next.getManufacturer()) && (next.ignoreModel() || Build.DEVICE.equalsIgnoreCase(next.getModel()))) {
                return true;
            }
        }
        return false;
    }

    public static class NonCompatibleDevice {
        private boolean ignoreModel;
        private final String manufacturer;
        private final String model;

        public NonCompatibleDevice(String str) {
            this.manufacturer = str;
            this.model = null;
            this.ignoreModel = true;
        }

        public NonCompatibleDevice(String str, String str2) {
            this.model = str;
            this.manufacturer = str2;
        }

        public boolean ignoreModel() {
            return this.ignoreModel;
        }

        public String getModel() {
            return this.model;
        }

        public String getManufacturer() {
            return this.manufacturer;
        }
    }
}
