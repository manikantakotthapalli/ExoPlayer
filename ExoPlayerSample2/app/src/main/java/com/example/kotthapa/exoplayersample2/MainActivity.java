package com.example.kotthapa.exoplayersample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;







public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BandwidthMeter badnwidthMeter = new DefaultBandwidthMeter();

        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(badnwidthMeter));

        DefaultHttpDataSourceFactory datasourceFactory = new DefaultHttpDataSourceFactory("Exo_Player_sample2");
        ExtractorsFactory  extractorsFactory = new DefaultExtractorsFactory ();

        MediaSource firstSource = new ExtractorMediaSource(Uri.parse("http://mirrors.standaloneinstaller.com/video-sample/jellyfish-25-mbps-hd-hevc.mp4"),
                datasourceFactory,extractorsFactory,null,null);
        MediaSource secondSource = new ExtractorMediaSource(Uri.parse("http://techslides.com/demos/sample-videos/small.webm"),
                datasourceFactory,extractorsFactory,null,null);

        ConcatenatingMediaSource mediaSource = new ConcatenatingMediaSource(firstSource,secondSource);


        SimpleExoPlayerView exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exoplayerview);
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this,trackSelector);

        exoPlayerView.setPlayer(player);
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }
}
