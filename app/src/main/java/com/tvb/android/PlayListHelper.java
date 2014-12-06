package com.tvb.android;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by fung on 03/12/2014.
 */
public class PlayListHelper {

    public static final String TAG = PlayListHelper.class.getSimpleName();

    public enum Channel {HDJ, J2, INEWS};
    private static String[] links = {"http://token.tvb.com/stream/live/hls/mobilehd_hdj.smil",
            "http://token.tvb.com/stream/live/hls/mobilehd_j2.smil",
            "http://token.tvb.com/stream/live/hls/mobilehd_inews.smil"};


    public static String getPlaylist(String smil) {

        try {

            URL url = new URL(smil);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false);
            int code = conn.getResponseCode();
            Map map = conn.getHeaderFields();

            Log.d(TAG, map.toString());

            if (code == 302) {
                return map.get("Location").toString().replaceAll("\\[", "").replaceAll("\\]", "");
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPlaylist(Channel channel) {
        try {
            String link = null;
            switch (channel) {
                case HDJ:
                    link = links[0];
                    break;
                case J2:
                    link = links[1];
                    break;
                case INEWS:
                    link = links[2];
                    break;
            }
            URL url = new URL(link);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false);
            int code = conn.getResponseCode();
            Map map = conn.getHeaderFields();
            if (code == 302) {
                return map.get("Location").toString().replaceAll("\\[", "").replaceAll("\\]", "");
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
