package com.downloader;

public class Response {
    private Error error;
    private boolean isCancelled;
    private boolean isPaused;
    private boolean isSuccessful;

    public Error getError() {
        return this.error;
    }

    public void setError(Error error2) {
        this.error = error2;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public void setSuccessful(boolean z) {
        this.isSuccessful = z;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void setPaused(boolean z) {
        this.isPaused = z;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean z) {
        this.isCancelled = z;
    }
}
