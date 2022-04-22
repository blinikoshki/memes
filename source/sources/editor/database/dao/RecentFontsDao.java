package editor.database.dao;

import editor.optionsui.text.textfont.TextFont;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH'¨\u0006\u000b"}, mo26107d2 = {"Leditor/database/dao/RecentFontsDao;", "", "deleteRecentFontById", "", "id", "", "getRecentFonts", "", "Leditor/optionsui/text/textfont/TextFont;", "insertRecentFont", "font", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RecentFontsDao.kt */
public interface RecentFontsDao {
    void deleteRecentFontById(String str);

    List<TextFont> getRecentFonts();

    void insertRecentFont(TextFont textFont);
}
