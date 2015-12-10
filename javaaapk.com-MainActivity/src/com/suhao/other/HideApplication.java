package com.suhao.other;

import android.app.Application;

import com.suhao.db.SongDb;
import com.suhao.manager.SongManager;
import com.suhao.model.LastSong;
import com.suhao.utils.SharedUtils;

/**
 * * * * * * * * * * * * * * * * * * * * * * *
 * Created by zhaoyiding
 * Date: 15/10/21
 * * * * * * * * * * * * * * * * * * * * * * *
 **/
public class HideApplication extends Application {

    public static boolean showListAnim;

    @Override
    public void onCreate() {
        super.onCreate();

        showListAnim = SharedUtils.getBoolean(this, Constants.KEY_SHOW_LIST_ANIM, true);

        LastSong lastSong = SongDb.getLastSong(this);
        if (lastSong != null) {
            SongManager.with(this).setCurrentSong(lastSong.getId());
        }
    }
}
