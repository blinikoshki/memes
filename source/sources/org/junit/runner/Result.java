package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Result implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(SerializedForm.class).getFields();
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final AtomicInteger count;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<Failure> failures;
    /* access modifiers changed from: private */
    public final AtomicInteger ignoreCount;
    /* access modifiers changed from: private */
    public final AtomicLong runTime;
    private SerializedForm serializedForm;
    /* access modifiers changed from: private */
    public final AtomicLong startTime;

    public Result() {
        this.count = new AtomicInteger();
        this.ignoreCount = new AtomicInteger();
        this.failures = new CopyOnWriteArrayList<>();
        this.runTime = new AtomicLong();
        this.startTime = new AtomicLong();
    }

    private Result(SerializedForm serializedForm2) {
        this.count = serializedForm2.fCount;
        this.ignoreCount = serializedForm2.fIgnoreCount;
        this.failures = new CopyOnWriteArrayList<>(serializedForm2.fFailures);
        this.runTime = new AtomicLong(serializedForm2.fRunTime);
        this.startTime = new AtomicLong(serializedForm2.fStartTime);
    }

    public int getRunCount() {
        return this.count.get();
    }

    public int getFailureCount() {
        return this.failures.size();
    }

    public long getRunTime() {
        return this.runTime.get();
    }

    public List<Failure> getFailures() {
        return this.failures;
    }

    public int getIgnoreCount() {
        return this.ignoreCount.get();
    }

    public boolean wasSuccessful() {
        return getFailureCount() == 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        new SerializedForm(this).serialize(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.serializedForm = SerializedForm.deserialize(objectInputStream);
    }

    private Object readResolve() {
        return new Result(this.serializedForm);
    }

    @RunListener.ThreadSafe
    private class Listener extends RunListener {
        public void testAssumptionFailure(Failure failure) {
        }

        private Listener() {
        }

        public void testRunStarted(Description description) throws Exception {
            Result.this.startTime.set(System.currentTimeMillis());
        }

        public void testRunFinished(Result result) throws Exception {
            Result.this.runTime.addAndGet(System.currentTimeMillis() - Result.this.startTime.get());
        }

        public void testFinished(Description description) throws Exception {
            Result.this.count.getAndIncrement();
        }

        public void testFailure(Failure failure) throws Exception {
            Result.this.failures.add(failure);
        }

        public void testIgnored(Description description) throws Exception {
            Result.this.ignoreCount.getAndIncrement();
        }
    }

    public RunListener createListener() {
        return new Listener();
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final AtomicInteger fCount;
        /* access modifiers changed from: private */
        public final List<Failure> fFailures;
        /* access modifiers changed from: private */
        public final AtomicInteger fIgnoreCount;
        /* access modifiers changed from: private */
        public final long fRunTime;
        /* access modifiers changed from: private */
        public final long fStartTime;

        public SerializedForm(Result result) {
            this.fCount = result.count;
            this.fIgnoreCount = result.ignoreCount;
            this.fFailures = Collections.synchronizedList(new ArrayList(result.failures));
            this.fRunTime = result.runTime.longValue();
            this.fStartTime = result.startTime.longValue();
        }

        private SerializedForm(ObjectInputStream.GetField getField) throws IOException {
            this.fCount = (AtomicInteger) getField.get("fCount", (Object) null);
            this.fIgnoreCount = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.fFailures = (List) getField.get("fFailures", (Object) null);
            this.fRunTime = getField.get("fRunTime", 0);
            this.fStartTime = getField.get("fStartTime", 0);
        }

        public void serialize(ObjectOutputStream objectOutputStream) throws IOException {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("fCount", this.fCount);
            putFields.put("fIgnoreCount", this.fIgnoreCount);
            putFields.put("fFailures", this.fFailures);
            putFields.put("fRunTime", this.fRunTime);
            putFields.put("fStartTime", this.fStartTime);
            objectOutputStream.writeFields();
        }

        public static SerializedForm deserialize(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            return new SerializedForm(objectInputStream.readFields());
        }
    }
}
