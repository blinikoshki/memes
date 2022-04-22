package editor.gpu.gpuvideo.composer;

interface IAudioComposer {
    long getWrittenPresentationTimeUs();

    boolean isFinished();

    void release();

    void setup();

    boolean stepPipeline();
}
