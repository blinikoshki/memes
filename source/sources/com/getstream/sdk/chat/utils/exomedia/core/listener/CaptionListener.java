package com.getstream.sdk.chat.utils.exomedia.core.listener;

import com.google.android.exoplayer2.text.Cue;
import java.util.List;

public interface CaptionListener {
    void onCues(List<Cue> list);
}
