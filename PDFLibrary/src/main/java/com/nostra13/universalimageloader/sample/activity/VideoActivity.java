package com.nostra13.universalimageloader.sample.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.artifex.mupdfdemo.R;

//import net.protyposis.android.mediaplayer.MediaSource;

//import net.protyposis.android.mediaplayer.MediaSource;

//import net.protyposis.android.mediaplayer.MediaPlayer;
//import net.protyposis.android.mediaplayer.MediaSource;
//import net.protyposis.android.mediaplayer.VideoView;


public class VideoActivity extends Activity {

    private static final String TAG = AudioActivity2.class.getSimpleName();

    private VideoView mVideoView;
    private ProgressBar mProgress;

    private MediaController.MediaPlayerControl mMediaPlayerControl;
    private MediaController mMediaController;

    private Uri mVideoUri;
    private int mVideoPosition;
    private float mVideoPlaybackSpeed;
    private boolean mVideoPlaying;
//    private MediaSource mMediaSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //Utils.setActionBarSubtitleEllipsizeMiddle(this);


        mVideoView = (VideoView) findViewById(R.id.videoView);
        mProgress = (ProgressBar) findViewById(R.id.progress1);

//        mMediaPlayerControl = mVideoView; //new MediaPlayerDummyControl();
        mMediaController = new MediaController(this);
        mMediaController.setAnchorView(mVideoView);
//        mMediaController.setMediaPlayer(mMediaPlayerControl);
//        mMediaController.setEnabled(false);

        // mProgress.setVisibility(View.VISIBLE);

        // Init video playback state (will eventually be overwritten by saved instance state)
        String[] urlsComp = getIntent().getStringExtra("url111").split("/");
        urlsComp[urlsComp.length - 1] = Uri.encode(urlsComp[urlsComp.length - 1]);
        StringBuilder sb = new StringBuilder();
        for (String n : urlsComp) {
            if (n.contains("http")) {
                sb.append(n).append('/');
            } else if (!n.trim().equals("")) {
                sb.append("/").append(n);
            }
        }

        String finalUrl = sb.toString();

        mVideoUri = Uri.parse(finalUrl);
        mVideoPosition = 0;
        mVideoPlaybackSpeed = 1;
        mVideoPlaying = false;
        mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoURI(mVideoUri);
        mVideoView.start();
    }
}