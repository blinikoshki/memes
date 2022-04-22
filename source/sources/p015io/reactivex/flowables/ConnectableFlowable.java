package p015io.reactivex.flowables;

import java.util.concurrent.TimeUnit;
import p015io.reactivex.Flowable;
import p015io.reactivex.Scheduler;
import p015io.reactivex.annotations.BackpressureKind;
import p015io.reactivex.annotations.BackpressureSupport;
import p015io.reactivex.annotations.CheckReturnValue;
import p015io.reactivex.annotations.SchedulerSupport;
import p015io.reactivex.disposables.Disposable;
import p015io.reactivex.functions.Consumer;
import p015io.reactivex.internal.functions.Functions;
import p015io.reactivex.internal.functions.ObjectHelper;
import p015io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import p015io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import p015io.reactivex.internal.operators.flowable.FlowablePublishClassic;
import p015io.reactivex.internal.operators.flowable.FlowableRefCount;
import p015io.reactivex.internal.util.ConnectConsumer;
import p015io.reactivex.plugins.RxJavaPlugins;
import p015io.reactivex.schedulers.Schedulers;

/* renamed from: io.reactivex.flowables.ConnectableFlowable */
public abstract class ConnectableFlowable<T> extends Flowable<T> {
    public abstract void connect(Consumer<? super Disposable> consumer);

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    private ConnectableFlowable<T> onRefCount() {
        if (!(this instanceof FlowablePublishClassic)) {
            return this;
        }
        FlowablePublishClassic flowablePublishClassic = (FlowablePublishClassic) this;
        return RxJavaPlugins.onAssembly(new FlowablePublishAlt(flowablePublishClassic.publishSource(), flowablePublishClassic.publishBufferSize()));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public Flowable<T> refCount() {
        return RxJavaPlugins.onAssembly(new FlowableRefCount(onRefCount()));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> refCount(int i) {
        return refCount(i, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> refCount(long j, TimeUnit timeUnit) {
        return refCount(1, j, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public final Flowable<T> refCount(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return refCount(1, j, timeUnit, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> refCount(int i, long j, TimeUnit timeUnit) {
        return refCount(i, j, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public final Flowable<T> refCount(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i, "subscriberCount");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableRefCount(onRefCount(), i, j, timeUnit, scheduler));
    }

    public Flowable<T> autoConnect() {
        return autoConnect(1);
    }

    public Flowable<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    public Flowable<T> autoConnect(int i, Consumer<? super Disposable> consumer) {
        if (i > 0) {
            return RxJavaPlugins.onAssembly(new FlowableAutoConnect(this, i, consumer));
        }
        connect(consumer);
        return RxJavaPlugins.onAssembly(this);
    }
}
