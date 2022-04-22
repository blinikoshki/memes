package com.snapchat.kit.sdk.core.models;

public class SnapKitFeatureOptions {
    public boolean profileLinkEnabled = false;

    public String toUriValue() {
        if (this.profileLinkEnabled) {
            return "com.snapchat.snap-kit.feature.toggle.profile-link";
        }
        return null;
    }
}
