package p015io.reactivex.parallel;

/* renamed from: io.reactivex.parallel.ParallelTransformer */
public interface ParallelTransformer<Upstream, Downstream> {
    ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> parallelFlowable);
}
