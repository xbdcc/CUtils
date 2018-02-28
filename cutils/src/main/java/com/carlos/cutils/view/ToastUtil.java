package com.carlos.cutils.view;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Carlos on 2018/2/27.
 */

public class ToastUtil {

    private Toast mToast;
    private Context mContext;
    private String message="";
    private int duration;

    private ToastUtil() {
    }


    public static class Builder{
        ToastUtil mToastUtil = new ToastUtil();

        public Builder(Context context){
            mToastUtil.mContext=context;
        }

        public Builder setText(String message){
            mToastUtil.message=message;
            return this;
        }

        public Builder setShortToast(){
            mToastUtil.duration=Toast.LENGTH_SHORT;
            return this;
        }

        public Builder setLongToast(){
            mToastUtil.duration=Toast.LENGTH_LONG;
            return this;
        }

        public ToastUtil build(){
            mToastUtil.setLayoutView();
            return mToastUtil;
        }

    }

    public void setLayoutView(){
        mToast=Toast.makeText(mContext,message,duration);
        mToast.show();
    }


}
