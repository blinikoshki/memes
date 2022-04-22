package com.getstream.sdk.chat.utils.exomedia.util;

import android.os.Handler;
import android.os.HandlerThread;

public class StopWatch {
    protected static final int DEFAULT_TICK_DELAY = 33;
    protected static final String HANDLER_THREAD_NAME = "ExoMedia_StopWatch_HandlerThread";
    protected long currentTime;
    protected Handler delayedHandler;
    protected HandlerThread handlerThread;
    protected volatile boolean isRunning;
    protected TickListener listener;
    protected float speedMultiplier;
    protected long startTime;
    protected long storedTime;
    protected int tickDelay;
    protected TickRunnable tickRunnable;
    protected boolean useHandlerThread;

    public interface TickListener {
        void onStopWatchTick(long j);
    }

    public StopWatch() {
        this(true);
    }

    public StopWatch(boolean z) {
        this.isRunning = false;
        this.tickDelay = 33;
        this.useHandlerThread = false;
        this.tickRunnable = new TickRunnable();
        this.startTime = 0;
        this.currentTime = 0;
        this.storedTime = 0;
        this.speedMultiplier = 1.0f;
        if (z) {
            this.delayedHandler = new Handler();
        } else {
            this.useHandlerThread = true;
        }
    }

    public StopWatch(Handler handler) {
        this.isRunning = false;
        this.tickDelay = 33;
        this.useHandlerThread = false;
        this.tickRunnable = new TickRunnable();
        this.startTime = 0;
        this.currentTime = 0;
        this.storedTime = 0;
        this.speedMultiplier = 1.0f;
        this.delayedHandler = handler;
    }

    public int getTickDelay() {
        return this.tickDelay;
    }

    public void setTickDelay(int i) {
        this.tickDelay = i;
    }

    public float getSpeedMultiplier() {
        return this.speedMultiplier;
    }

    public void setSpeedMultiplier(float f) {
        this.speedMultiplier = f;
    }

    public void start() {
        if (!isRunning()) {
            this.isRunning = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.startTime = currentTimeMillis;
            this.tickRunnable.lastTickTimestamp = currentTimeMillis;
            if (this.useHandlerThread) {
                HandlerThread handlerThread2 = new HandlerThread(HANDLER_THREAD_NAME);
                this.handlerThread = handlerThread2;
                handlerThread2.start();
                this.delayedHandler = new Handler(this.handlerThread.getLooper());
            }
            this.tickRunnable.performTick();
        }
    }

    public void stop() {
        if (isRunning()) {
            this.delayedHandler.removeCallbacksAndMessages((Object) null);
            HandlerThread handlerThread2 = this.handlerThread;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            this.storedTime = this.currentTime + this.storedTime;
            this.isRunning = false;
            this.currentTime = 0;
        }
    }

    public void reset() {
        this.currentTime = 0;
        this.storedTime = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.startTime = currentTimeMillis;
        this.tickRunnable.lastTickTimestamp = currentTimeMillis;
    }

    public void overrideCurrentTime(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        this.startTime = currentTimeMillis;
        this.tickRunnable.lastTickTimestamp = currentTimeMillis;
        this.currentTime = 0;
        this.storedTime = j;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public long getTime() {
        return this.currentTime + this.storedTime;
    }

    public int getTimeInt() {
        long j = this.currentTime + this.storedTime;
        if (j < 2147483647L) {
            return (int) j;
        }
        return Integer.MAX_VALUE;
    }

    public void setTickListener(TickListener tickListener) {
        this.listener = tickListener;
    }

    protected class TickRunnable implements Runnable {
        protected long lastTickTimestamp = -1;
        protected long tempNow = 0;

        protected TickRunnable() {
        }

        public void run() {
            if (this.lastTickTimestamp == -1) {
                this.lastTickTimestamp = StopWatch.this.startTime;
            }
            this.tempNow = System.currentTimeMillis();
            StopWatch stopWatch = StopWatch.this;
            stopWatch.currentTime = (long) (((float) stopWatch.currentTime) + (((float) (this.tempNow - this.lastTickTimestamp)) * StopWatch.this.speedMultiplier));
            this.lastTickTimestamp = this.tempNow;
            if (StopWatch.this.isRunning) {
                performTick();
            }
            if (StopWatch.this.listener != null) {
                StopWatch.this.listener.onStopWatchTick(StopWatch.this.currentTime + StopWatch.this.storedTime);
            }
        }

        public void performTick() {
            StopWatch.this.delayedHandler.postDelayed(StopWatch.this.tickRunnable, (long) StopWatch.this.tickDelay);
        }
    }
}
