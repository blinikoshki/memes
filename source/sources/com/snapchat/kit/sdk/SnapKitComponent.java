package com.snapchat.kit.sdk;

import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.C4427d;
import dagger.Component;

@SnapConnectScope
@Component(modules = {C4488g.class, C4427d.class})
public interface SnapKitComponent extends SnapKitProvidingComponent {
    void inject(SnapCFSActivity snapCFSActivity);

    void inject(SnapKitActivity snapKitActivity);
}
