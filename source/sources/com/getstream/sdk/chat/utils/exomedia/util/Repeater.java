package com.getstream.sdk.chat.utils.exomedia.util;

import android.os.Handler;
import android.os.HandlerThread;

public class Repeater {
    protected static final int DEFAULT_REPEAT_DELAY = 33;
    protected static final String HANDLER_THREAD_NAME = "ExoMedia_Repeater_HandlerThread";
    protected Handler delayedHandler;
    protected HandlerThread handlerThread;
    protected RepeatListener listener;
    protected PollRunnable pollRunnable;
    protected int repeatDelay;
    protected volatile boolean repeaterRunning;
    protected boolean useHandlerThread;

    public interface RepeatListener {
        void onRepeat();
    }

    public Repeater() {
        this(true);
    }

    public Repeater(boolean z) {
        this.repeaterRunning = false;
        this.repeatDelay = 33;
        this.useHandlerThread = false;
        this.pollRunnable = new PollRunnable();
        if (z) {
            this.delayedHandler = new Handler();
        } else {
            this.useHandlerThread = true;
        }
    }

    public Repeater(Handler handler) {
        this.repeaterRunning = false;
        this.repeatDelay = 33;
        this.useHandlerThread = false;
        this.pollRunnable = new PollRunnable();
        this.delayedHandler = handler;
    }

    public int getRepeaterDelay() {
        return this.repeatDelay;
    }

    public void setRepeaterDelay(int i) {
        this.repeatDelay = i;
    }

    public void start() {
        if (!this.repeaterRunning) {
            this.repeaterRunning = true;
            if (this.useHandlerThread) {
                HandlerThread handlerThread2 = new HandlerThread(HANDLER_THREAD_NAME);
                this.handlerThread = handlerThread2;
                handlerThread2.start();
                this.delayedHandler = new Handler(this.handlerThread.getLooper());
            }
            this.pollRunnable.performPoll();
        }
    }

    public void stop() {
        HandlerThread handlerThread2 = this.handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quit();
        }
        this.repeaterRunning = false;
    }

    public boolean isRunning() {
        return this.repeaterRunning;
    }

    public void setRepeatListener(RepeatListener repeatListener) {
        this.listener = repeatListener;
    }

    protected class PollRunnable implements Runnable {
        protected PollRunnable() {
        }

        public void run() {
            if (Repeater.this.listener != null) {
                Repeater.this.listener.onRepeat();
            }
            if (Repeater.this.repeaterRunning) {
                performPoll();
            }
        }

        public void performPoll() {
            Repeater.this.delayedHandler.postDelayed(Repeater.this.pollRunnable, (long) Repeater.this.repeatDelay);
        }
    }
}
