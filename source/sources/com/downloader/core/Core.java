package com.downloader.core;

public class Core {
    private static Core instance;
    private final ExecutorSupplier executorSupplier = new DefaultExecutorSupplier();

    private Core() {
    }

    public static Core getInstance() {
        if (instance == null) {
            synchronized (Core.class) {
                if (instance == null) {
                    instance = new Core();
                }
            }
        }
        return instance;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }

    public static void shutDown() {
        if (instance != null) {
            instance = null;
        }
    }
}
