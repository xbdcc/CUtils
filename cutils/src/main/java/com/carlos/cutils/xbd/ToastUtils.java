package com.carlos.cutils.xbd;

import android.widget.Toast;

/**
 * Created by Carlos on 2018/2/27.
 */

public class ToastUtils {


    /*private控制不应该被实例化*/
    private ToastUtils() {
        throw new UnsupportedOperationException("不能被实例化");
    }

    public static class Builder{

        public Builder(){};

        private  Toast mToast;

        public Builder setText(String text){
            mToast.setText(text);
            return this;
        }

        public Builder show(){
            mToast.show();
            return this;
        }
    }






//    private static void createToast(Context context, CharSequence text, int duration){
//        View view= LayoutInflater.from(BaseApplication.getInstance().getApplication().getApplicationContext()).inflate(R.layout.toast,null);
//        TextView textview= (TextView) view.findViewById(R.id.toast);
//        textview.setText(text);
//        if (mToast!=null){
//            mToast.cancel();
//        }
//        mToast=new Toast(BaseApplication.getInstance().getApplication().getApplicationContext());
//        mToast.setDuration(duration);
//        mToast.setView(view);
//    }

//    public static void  showDefaultShortToast(Context context,CharSequence text){
//        createToast(context,text,Toast.LENGTH_SHORT);
//        mToast.show();
//    }
//
//    public static void showCenterShortToast(Context context,CharSequence text){
//        createToast(context,text,Toast.LENGTH_SHORT);
//        DisplayMetrics metric = new DisplayMetrics();
//        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        windowManager.getDefaultDisplay().getRealMetrics(metric);
//
////        LogUtils.d("height:"+mToast.getView().getY()+";;;"+mToast.getView().getHeight()+";;;"+mToast.getView().getMeasuredHeight());
//        int height= (int) (metric.heightPixels*0.4);
//        setGravity(Gravity.TOP,0,height);
//        mToast.show();
//    }

//    public void show(){
//        if (mToast!=null)
//            mToast.show();
//    }
//
//    private static void setGravity(int gravity,int xOffset,int yOffset){
//        if (mToast!=null){
//            mToast.setGravity(gravity,xOffset,yOffset);
//        }
//    }

}
