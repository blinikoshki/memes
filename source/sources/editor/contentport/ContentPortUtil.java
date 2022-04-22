package editor.contentport;

import android.graphics.Bitmap;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.commons.util.Bitmaps;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import editor.util.rules.musthavefreespace.MustHaveFreeSpaceRule;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.FilesKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\"\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016j\u0002`\u00172\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Leditor/contentport/ContentPortUtil;", "", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Lcom/memes/commons/output/OutputTargetGenerator;)V", "copyFileToFolder", "", "file", "Ljava/io/File;", "targetFolderName", "copyMediaContentTo", "", "content", "Lcom/memes/commons/media/MediaContent;", "folderName", "copyMediaStyle", "Leditor/editor/equipment/media/MediaStyle;", "mediaStyle", "createOutputFile", "fileName", "createThumbnail", "entity", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "deleteFolder", "", "requireFreeSpace", "requiredMegabytes", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentPortUtil.kt */
public final class ContentPortUtil {
    private final OutputTargetGenerator outputTargetGenerator;

    public ContentPortUtil(OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.outputTargetGenerator = outputTargetGenerator2;
    }

    public final void requireFreeSpace(long j) {
        String absolutePath = this.outputTargetGenerator.getRootDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "outputTargetGenerator.ge…tDirectory().absolutePath");
        new MustHaveFreeSpaceRule(absolutePath, j).apply();
    }

    public final String createThumbnail(CoreEntity<?, ?> coreEntity, String str) {
        Intrinsics.checkNotNullParameter(coreEntity, "entity");
        Intrinsics.checkNotNullParameter(str, "folderName");
        Bitmap createThumbnail$default = CoreEntity.createThumbnail$default(coreEntity, 0, 0, 3, (Object) null);
        File createOutputFile = createOutputFile("thumbnail.png", str);
        Bitmaps.INSTANCE.save(createThumbnail$default, createOutputFile, Bitmap.CompressFormat.PNG, 100);
        createThumbnail$default.recycle();
        String absolutePath = createOutputFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "thumbnailOutputFile.absolutePath");
        return absolutePath;
    }

    public final MediaStyle copyMediaStyle(MediaStyle mediaStyle, String str) {
        Intrinsics.checkNotNullParameter(mediaStyle, "mediaStyle");
        Intrinsics.checkNotNullParameter(str, "folderName");
        MediaStyle mediaStyle2 = new MediaStyle();
        mediaStyle.copy(mediaStyle2);
        copyMediaContentTo(mediaStyle2.getOriginalContent(), str);
        CropSpec cropSpec = mediaStyle2.getCropSpec();
        MediaContent mediaContent = null;
        copyMediaContentTo(cropSpec != null ? cropSpec.getContent() : null, str);
        FilterSpec filterSpec = mediaStyle2.getFilterSpec();
        if (filterSpec != null) {
            mediaContent = filterSpec.getContent();
        }
        copyMediaContentTo(mediaContent, str);
        return mediaStyle2;
    }

    public final void copyMediaContentTo(MediaContent mediaContent, String str) {
        String copyFileToFolder;
        Intrinsics.checkNotNullParameter(str, "folderName");
        if (mediaContent != null && (copyFileToFolder = copyFileToFolder(mediaContent.asFile(), str)) != null) {
            mediaContent.setContentUrl(copyFileToFolder);
        }
    }

    public final String copyFileToFolder(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(str, "targetFolderName");
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        File createOutputFile = createOutputFile(name, str);
        FilesKt.copyTo$default(file, createOutputFile, true, 0, 4, (Object) null);
        return createOutputFile.getAbsolutePath();
    }

    public final File createOutputFile(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "folderName");
        return OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, str2, str, (String) null, false, false, 20, (Object) null).getOutputFile();
    }

    public final boolean deleteFolder(String str) {
        Intrinsics.checkNotNullParameter(str, "folderName");
        File file = new File(this.outputTargetGenerator.getRootDirectory(), str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        boolean deleteRecursively = FilesKt.deleteRecursively(file);
        if (!deleteRecursively) {
            Timber.m303e("Unable to delete directory: " + str, new Object[0]);
        }
        return deleteRecursively;
    }
}
