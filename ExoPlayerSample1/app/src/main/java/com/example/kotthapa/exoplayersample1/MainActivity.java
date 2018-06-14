package com.example.kotthapa.exoplayersample1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // BangwidthMeter to inspects the client Badwidth time to time
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

        // TrackSelector helps in selecting the track for the client based on his capabilities.
        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));


        DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Sample Video");
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource = new ExtractorMediaSource(Uri.parse("http://techslides.com/demos/sample-videos/small.webm"),
                dataSourceFactory, extractorsFactory, null, null);

        SimpleExoPlayerView exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exoplayer_view);
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this,trackSelector);

        exoPlayerView.setPlayer(player);
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }
}
