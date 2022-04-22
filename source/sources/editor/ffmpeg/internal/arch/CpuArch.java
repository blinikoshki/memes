package editor.ffmpeg.internal.arch;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo26107d2 = {"Leditor/ffmpeg/internal/arch/CpuArch;", "", "sha1", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSha1", "()Ljava/lang/String;", "X86", "ARMv7", "ARMv8", "X86_64", "NONE", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CpuArch.kt */
public enum CpuArch {
    X86("0dd4dbad305ff197a1ea9e6158bd2081d229e70e"),
    ARMv7("871888959ba2f063e18f56272d0d98ae01938ceb"),
    ARMv8("8cc6b01618b14a07d86ed1d2e19befc957eefae6"),
    X86_64("3f486973998ca951b735cb0c0dd58e05424c81d4"),
    NONE((String) null);
    
    private final String sha1;

    private CpuArch(String str) {
        this.sha1 = str;
    }

    public final String getSha1() {
        return this.sha1;
    }
}
