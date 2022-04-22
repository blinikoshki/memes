package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class LiveDataUtils {
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(LiveData<In> liveData, final Function<In, Out> function, final TaskExecutor taskExecutor) {
        final Object obj = new Object();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<In>() {
            Out mCurrentOutput = null;

            public void onChanged(final In in) {
                TaskExecutor.this.executeOnBackgroundThread(new Runnable() {
                    public void run() {
                        synchronized (obj) {
                            Out apply = function.apply(in);
                            if (C08731.this.mCurrentOutput == null && apply != null) {
                                C08731.this.mCurrentOutput = apply;
                                mediatorLiveData.postValue(apply);
                            } else if (C08731.this.mCurrentOutput != null && !C08731.this.mCurrentOutput.equals(apply)) {
                                C08731.this.mCurrentOutput = apply;
                                mediatorLiveData.postValue(apply);
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }

    private LiveDataUtils() {
    }
}
