# ExoPlayerSample2

This Sample demonstrating playing two videos back to back using ConcatenatingMediaSource.

# Gradel changes
    '''
    compile 'com.google.android.exoplayer:exoplayer:r2.4.0'
    compile 'com.google.android.exoplayer:exoplayer-core:r2.4.0'
    compile 'com.google.android.exoplayer:exoplayer-dash:r2.4.0'
    compile 'com.google.android.exoplayer:exoplayer-hls:r2.4.0'
    compile 'com.google.android.exoplayer:exoplayer-smoothstreaming:r2.4.0'
    compile 'com.google.android.exoplayer:exoplayer-ui:r2.4.0'
    
    '''
    
# UI - activity_main.xml

'''
<com.google.android.exoplayer2.ui.SimpleExoPlayerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/exoplayer_view">
</com.google.android.exoplayer2.ui.SimpleExoPlayerView>
'''

# MainActivity.java

'''

        // BangwidthMeter to inspects the client Badwidth time to time
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

        // TrackSelector helps in selecting the track for the client based on his capabilities.
        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));


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

'''

