package com.carlos.cutils.media

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView

/**
 * Created by Carlos on 2021/1/29.
 */
class CVideoView(context: Context, videoView: VideoView) {

    var mVideoView: VideoView = videoView
    var mContext: Context = context
    private val TAG = "CVideoView"

    fun start(videoPath: String, isLoop: Boolean = false) {
        mVideoView.setVideoPath(videoPath)
        mVideoView.setOnPreparedListener {
            it?.isLooping = isLoop
            mVideoView.start()
            Log.d(TAG, "start-> is loop:$isLoop")
        }
    }

    fun start() {
        if (mVideoView.isPlaying)
            return
        mVideoView.start()
    }

    fun pause() {
        mVideoView.pause()
    }

    fun release() {
        mVideoView.suspend()
    }

    fun getDuration() = mVideoView.duration

    fun getCurrentPosition() = mVideoView.currentPosition

    fun seekTo(position: Int) = mVideoView.seekTo(position)


    fun setOnErrorListener(onErrorListener: OnErrorListener, isHandled: Boolean = false) {
        mVideoView.setOnErrorListener { mp, what, extra ->
            Log.e(TAG, "onError->what:${what} - extra:$extra")
            onErrorListener.onError(mp, what, extra)
            isHandled
        }
    }

    fun setOnCompletionListener(onCompletionListener: OnCompletionListener) {
        mVideoView.setOnCompletionListener {
            Log.e(TAG, "onCompletion")
            onCompletionListener.onCompletion(it)
        }
    }


    /**
     * show default media controller
     */
    fun showMediaController() {
        val mediaController = MediaController(mContext)
        mVideoView.setMediaController(mediaController)
    }

    interface OnErrorListener {
        fun onError(mp: MediaPlayer?, what: Int, extra: Int)
    }

    interface OnCompletionListener {
        fun onCompletion(mp: MediaPlayer?)
    }

}