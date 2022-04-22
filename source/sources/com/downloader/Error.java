package com.downloader;

import java.util.List;
import java.util.Map;

public class Error {
    private Throwable connectionException;
    private Map<String, List<String>> headerFields;
    private boolean isConnectionError;
    private boolean isServerError;
    private int responseCode;
    private String serverErrorMessage;

    public boolean isServerError() {
        return this.isServerError;
    }

    public void setServerError(boolean z) {
        this.isServerError = z;
    }

    public boolean isConnectionError() {
        return this.isConnectionError;
    }

    public void setConnectionError(boolean z) {
        this.isConnectionError = z;
    }

    public void setServerErrorMessage(String str) {
        this.serverErrorMessage = str;
    }

    public String getServerErrorMessage() {
        return this.serverErrorMessage;
    }

    public void setHeaderFields(Map<String, List<String>> map) {
        this.headerFields = map;
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.headerFields;
    }

    public void setConnectionException(Throwable th) {
        this.connectionException = th;
    }

    public Throwable getConnectionException() {
        return this.connectionException;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
