package com.carlos.cutils.util;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

import com.carlos.cutils.listener.VoiceListener;

/**
 * Created by Carlos on 2018/3/6.
 */

public class VoiceUtil {

    private static volatile VoiceUtil instance;
    static final int SAMPLE_RATE_IN_HZ = 8000;
    static final int BUFFER_SIZE = android.media.AudioRecord.getMinBufferSize(SAMPLE_RATE_IN_HZ,
            AudioFormat.CHANNEL_IN_DEFAULT, AudioFormat.ENCODING_PCM_16BIT);
    AudioRecord mAudioRecord;
    boolean isGetVoiceRun;
    Object mLock;

    public VoiceUtil() {
        mLock = new Object();
    }

    public static VoiceUtil getInstance(){
        if (instance==null){
            synchronized (VoiceUtil.class){
                if (instance==null)
                    instance=new VoiceUtil();
            }
        }
        return instance;
    }


    public void startRecordVoice(final VoiceListener voiceListener) {
        if (isGetVoiceRun) {
            LogUtil.d("还在录着呢");
            return;
        }

        isGetVoiceRun = true;
        mAudioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                SAMPLE_RATE_IN_HZ, AudioFormat.CHANNEL_IN_DEFAULT,
                AudioFormat.ENCODING_PCM_16BIT, BUFFER_SIZE);
        if (mAudioRecord == null) {
            LogUtil.e("mAudioRecord初始化失败");
            return;
        }else {
            LogUtil.d("mAudioRecord初始化成功");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                mAudioRecord.startRecording();
                short[] buffer = new short[BUFFER_SIZE];
                while (isGetVoiceRun) {
                    //r是实际读取的数据长度，一般而言r会小于buffersize
                    int r = mAudioRecord.read(buffer, 0, BUFFER_SIZE);
                    long v = 0;
                    // 将 buffer 内容取出，进行平方和运算
                    for (int i = 0; i < buffer.length; i++) {
                        v += buffer[i] * buffer[i];
                    }
                    // 平方和除以数据总长度，得到音量大小。
                    double mean = v / (double) r;
                    double volume = 10 * Math.log10(mean);//得到分贝大小
                    voiceListener.getSize(volume);
                    // 大概一秒十次
                    synchronized (mLock) {
                        try {
                            mLock.wait(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                mAudioRecord.stop();
                mAudioRecord.release();
                mAudioRecord = null;
                LogUtil.d("停止录制");
                isGetVoiceRun=false;
            }
        }).start();
    }

    /**
     * 停止录制，下次开启时要先取消本次操作。
     */
    public void stopRecordVoice(){
        isGetVoiceRun=false;
    }

}
