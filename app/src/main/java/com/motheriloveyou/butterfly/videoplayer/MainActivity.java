package com.motheriloveyou.butterfly.videoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("https://r1---sn-2gpnh5-q5je.googlevideo.com/videoplayback?sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpcm2%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&c=WEB&fvip=1&mime=video%2Fmp4&pl=24&expire=1536059082&ratebypass=yes&ipbits=0&initcwndbps=577500&requiressl=yes&lmt=1530164051151764&itag=22&ip=124.6.238.222&dur=407.069&source=youtube&id=o-AMikRVMwUNTmVUF0gfJwgkPDkR_uKtJ2xbXZGAaPoaN5&mm=31%2C29&mn=sn-2gpnh5-q5je%2Csn-npoe7ne7&key=yt6&ei=aRKOW6DJI8q5z7sPnoSZqAM&ms=au%2Crdu&mt=1536037357&pcm2=no&mv=m&signature=22F33856D63379E6B7C9C18A57B14B3DA7878AFB.68C59260059C316F3A842D3BE02AFC514AE60238&title=Official%20Video_%20Humnava%20Mere%20Song%20_%20Jubin%20Nautiyal%20_%20Manoj%20Muntashir%20_%20Rocky%20-%20Shiv%20_%20Bhushan%20Kumar",
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
                "Video player");


    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
