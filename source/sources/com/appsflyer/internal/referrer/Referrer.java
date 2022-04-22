package com.appsflyer.internal.referrer;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public abstract class Referrer extends Observable {
    private final String $$a;
    /* access modifiers changed from: private */
    public final Runnable $$b;
    public final Map<String, Object> map = new HashMap();
    private State valueOf = State.NOT_STARTED;
    private long values;

    public enum State {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public abstract void start(Context context);

    public Referrer(String str, Runnable runnable) {
        this.$$b = runnable;
        this.$$a = str;
    }

    public void start() {
        this.values = System.currentTimeMillis();
        this.valueOf = State.STARTED;
        addObserver(new Observer() {
            public final void update(Observable observable, Object obj) {
                Referrer.this.$$b.run();
            }
        });
    }

    public void finish() {
        this.map.put("source", this.$$a);
        this.map.putAll(new MandatoryFields());
        this.map.put(Payload.LATENCY, Long.valueOf(System.currentTimeMillis() - this.values));
        this.valueOf = State.FINISHED;
        setChanged();
        notifyObservers();
    }

    public State getState() {
        return this.valueOf;
    }

    public String getSource() {
        return this.$$a;
    }
}
