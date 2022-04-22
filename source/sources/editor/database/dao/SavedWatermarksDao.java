package editor.database.dao;

import editor.optionsui.watermark.PhotoWatermark;
import editor.optionsui.watermark.TextWatermark;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH'¨\u0006\u000e"}, mo26107d2 = {"Leditor/database/dao/SavedWatermarksDao;", "", "deletePhotoWatermarkById", "", "id", "", "deleteTextWatermarkById", "getPhotoWatermarks", "", "Leditor/optionsui/watermark/PhotoWatermark;", "getTextWatermarks", "Leditor/optionsui/watermark/TextWatermark;", "insert", "watermark", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksDao.kt */
public interface SavedWatermarksDao {
    void deletePhotoWatermarkById(String str);

    void deleteTextWatermarkById(String str);

    List<PhotoWatermark> getPhotoWatermarks();

    List<TextWatermark> getTextWatermarks();

    void insert(PhotoWatermark photoWatermark);

    void insert(TextWatermark textWatermark);
}
