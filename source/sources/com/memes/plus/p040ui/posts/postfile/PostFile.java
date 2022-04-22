package com.memes.plus.p040ui.posts.postfile;

import com.memes.plus.p040ui.posts.Post;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/postfile/PostFile;", "", "post", "Lcom/memes/plus/ui/posts/Post;", "file", "Ljava/io/File;", "(Lcom/memes/plus/ui/posts/Post;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getPost", "()Lcom/memes/plus/ui/posts/Post;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.postfile.PostFile */
/* compiled from: PostFile.kt */
public final class PostFile {
    private File file;
    private final Post post;

    public static /* synthetic */ PostFile copy$default(PostFile postFile, Post post2, File file2, int i, Object obj) {
        if ((i & 1) != 0) {
            post2 = postFile.post;
        }
        if ((i & 2) != 0) {
            file2 = postFile.file;
        }
        return postFile.copy(post2, file2);
    }

    public final Post component1() {
        return this.post;
    }

    public final File component2() {
        return this.file;
    }

    public final PostFile copy(Post post2, File file2) {
        Intrinsics.checkNotNullParameter(post2, "post");
        Intrinsics.checkNotNullParameter(file2, "file");
        return new PostFile(post2, file2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostFile)) {
            return false;
        }
        PostFile postFile = (PostFile) obj;
        return Intrinsics.areEqual((Object) this.post, (Object) postFile.post) && Intrinsics.areEqual((Object) this.file, (Object) postFile.file);
    }

    public int hashCode() {
        Post post2 = this.post;
        int i = 0;
        int hashCode = (post2 != null ? post2.hashCode() : 0) * 31;
        File file2 = this.file;
        if (file2 != null) {
            i = file2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PostFile(post=" + this.post + ", file=" + this.file + ")";
    }

    public PostFile(Post post2, File file2) {
        Intrinsics.checkNotNullParameter(post2, "post");
        Intrinsics.checkNotNullParameter(file2, "file");
        this.post = post2;
        this.file = file2;
    }

    public final Post getPost() {
        return this.post;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file2) {
        Intrinsics.checkNotNullParameter(file2, "<set-?>");
        this.file = file2;
    }
}
