package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
final /* synthetic */ class Registrar$$Lambda$1 implements ComponentFactory {
    static final ComponentFactory $instance = new Registrar$$Lambda$1();

    private Registrar$$Lambda$1() {
    }

    public Object create(ComponentContainer componentContainer) {
        return Registrar.lambda$getComponents$1$Registrar(componentContainer);
    }
}