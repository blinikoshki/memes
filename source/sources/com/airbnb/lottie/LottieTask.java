package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public Executor EXECUTOR;
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    /* access modifiers changed from: private */
    public LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;
    /* access modifiers changed from: private */
    public final FutureTask<LottieResult<T>> task;
    private Thread taskObserver;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.EXECUTOR = Executors.newCachedThreadPool();
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        FutureTask<LottieResult<T>> futureTask = new FutureTask<>(callable);
        this.task = futureTask;
        if (z) {
            try {
                setResult(callable.call());
            } catch (Throwable th) {
                setResult(new LottieResult(th));
            }
        } else {
            this.EXECUTOR.execute(futureTask);
            startTaskObserverIfNeeded();
        }
    }

    /* access modifiers changed from: private */
    public void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public LottieTask<T> addListener(LottieListener<T> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (!(lottieResult == null || lottieResult.getValue() == null)) {
            lottieListener.onResult(this.result.getValue());
        }
        synchronized (this.successListeners) {
            this.successListeners.add(lottieListener);
        }
        startTaskObserverIfNeeded();
        return this;
    }

    public LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        synchronized (this.successListeners) {
            this.successListeners.remove(lottieListener);
        }
        stopTaskObserverIfNeeded();
        return this;
    }

    public LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (!(lottieResult == null || lottieResult.getException() == null)) {
            lottieListener.onResult(this.result.getException());
        }
        synchronized (this.failureListeners) {
            this.failureListeners.add(lottieListener);
        }
        startTaskObserverIfNeeded();
        return this;
    }

    public LottieTask<T> removeFailureListener(LottieListener<T> lottieListener) {
        synchronized (this.failureListeners) {
            this.failureListeners.remove(lottieListener);
        }
        stopTaskObserverIfNeeded();
        return this;
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() {
            public void run() {
                if (LottieTask.this.result != null && !LottieTask.this.task.isCancelled()) {
                    LottieResult access$000 = LottieTask.this.result;
                    if (access$000.getValue() != null) {
                        LottieTask.this.notifySuccessListeners(access$000.getValue());
                    } else {
                        LottieTask.this.notifyFailureListeners(access$000.getException());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifySuccessListeners(T t) {
        for (LottieListener onResult : new ArrayList(this.successListeners)) {
            onResult.onResult(t);
        }
    }

    /* access modifiers changed from: private */
    public void notifyFailureListeners(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.failureListeners);
        if (arrayList.isEmpty()) {
            Log.w(C0947L.TAG, "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    private void startTaskObserverIfNeeded() {
        if (!taskObserverAlive() && this.result == null) {
            C09782 r0 = new Thread("LottieTaskObserver") {
                public void run() {
                    while (!isInterrupted()) {
                        if (LottieTask.this.task.isDone()) {
                            try {
                                LottieTask lottieTask = LottieTask.this;
                                lottieTask.setResult((LottieResult) lottieTask.task.get());
                            } catch (InterruptedException | ExecutionException e) {
                                LottieTask.this.setResult(new LottieResult(e));
                            }
                            LottieTask.this.stopTaskObserverIfNeeded();
                        }
                    }
                }
            };
            this.taskObserver = r0;
            r0.start();
            C0947L.debug("Starting TaskObserver thread");
        }
    }

    /* access modifiers changed from: private */
    public void stopTaskObserverIfNeeded() {
        if (taskObserverAlive()) {
            if (this.successListeners.isEmpty() || this.result != null) {
                this.taskObserver.interrupt();
                this.taskObserver = null;
                C0947L.debug("Stopping TaskObserver thread");
            }
        }
    }

    private boolean taskObserverAlive() {
        Thread thread = this.taskObserver;
        return thread != null && thread.isAlive();
    }
}
