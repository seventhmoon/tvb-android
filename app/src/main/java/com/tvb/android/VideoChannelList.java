package com.tvb.android;

import java.util.ArrayList;
import java.util.List;

public final class VideoChannelList {
    public static final String VIDEO_CHANNEL_CATEGORY[] = {
            "Live",
    };

    public static List<VideoChannel> list;

    public static List<VideoChannel> setupVideoChannels() {
        list = new ArrayList<VideoChannel>();
        String title[] = {
                "HD Jade",
                "J2",
                "INews",
        };

        String description = "720p";

        String videoUrl[] = {
                "http://token.tvb.com/stream/live/hls/mobilehd_hdj.smil",
                "http://token.tvb.com/stream/live/hls/mobilehd_j2.smil",
                "http://token.tvb.com/stream/live/hls/mobilehd_inews.smil"
//                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
//                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
//                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
//                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
//                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };
        String bgImageUrl[] = {
                "http://upload.wikimedia.org/wikipedia/zh/0/0d/TVB_Jade_logo_20121221.jpg",
                "http://upload.wikimedia.org/wikipedia/zh/0/0d/TVB_Jade_logo_20121221.jpg",
                "http://upload.wikimedia.org/wikipedia/zh/0/0d/TVB_Jade_logo_20121221.jpg",
        };
        String cardImageUrl[] = {
                "http://img.tvb.com/tv/live/hdj_225.jpg",
                "http://img.tvb.com/tv/live/j2_225.jpg",
                "http://img.tvb.com/tv/live/inews_225.jpg",
        };

        list.add(buildVideoChannelInfo("category", title[0],
                description, "720p", videoUrl[0], cardImageUrl[0], bgImageUrl[0]));
        list.add(buildVideoChannelInfo("category", title[1],
                description, "720p", videoUrl[1], cardImageUrl[1], bgImageUrl[1]));
        list.add(buildVideoChannelInfo("live", title[2],
                description, "720p", videoUrl[2], cardImageUrl[2], bgImageUrl[2]));
//        list.add(buildVideoChannelInfo("category", title[3],
//                description, "Studio Three", videoUrl[3], cardImageUrl[3], bgImageUrl[3]));
//        list.add(buildVideoChannelInfo("category", title[4],
//                description, "Studio Four", videoUrl[4], cardImageUrl[4], bgImageUrl[4]));

        return list;
    }

    private static VideoChannel buildVideoChannelInfo(String category, String title,
                                                      String description, String studio, String videoUrl, String cardImageUrl,
                                                      String bgImageUrl) {
        VideoChannel videoChannel = new VideoChannel();
        videoChannel.setId(Movie.getCount());
        VideoChannel.incCount();
        videoChannel.setTitle(title);
        videoChannel.setDescription(description);
        videoChannel.setStudio(studio);
        videoChannel.setCategory(category);
        videoChannel.setCardImageUrl(cardImageUrl);
        videoChannel.setBackgroundImageUrl(bgImageUrl);
        videoChannel.setVideoUrl(videoUrl);
//        videoChannel.setVideoUrl(PlayListHelper.getPlaylist(videoUrl));
        return videoChannel;
    }
}
