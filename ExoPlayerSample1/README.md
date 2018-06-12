# ExoPlayer
ExoPlayer is an application level media player that provides an alternative to Android’s MediaPlayer API. We can play audio and video both locally and stream over the Internet. It supports features DASH and SmoothStreaming adaptive playbacks. Its very easy to customize as per needs.

# Architecture of ExoPlayer
![alt text](https://github.com/manikantakotthapalli/ExoPlayer/blob/master/Images/exoplayer_Architecture.png)

Audio/Video Renderer: Receives audio or video data from the exoplayer and renders them on the device.

Track Selector: Selects the appropriate track based on the client bandwidth and device specification.

Load Controller: Take cares of the data, like when to buffer, when to stream.
