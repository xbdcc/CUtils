package com.carlos.cutils.demo

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.carlos.cutils.util.LogUtils
import java.io.File

/**
 * Created by Carlos on 2019-11-18.
 */
class AlbumUtils {

    val OPEN_ALBUMN = 1
    val OPEN_ALBUMN_CROP = 3
    val OPEN_CAMERA = 2
    val CROP = 4
    val GET_IMAGE = 4
    var uriClipUri: Uri? = null //随便命名一个
    var pathUrl: String = ""
    private var mChooseSuccessListener: ChooseSuccessListener? = null


    fun openAlbum(context: Context) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        context.startActivity(intent)
    }

    fun openAlbum(activity: Activity, chooseSuccessListener: ChooseSuccessListener) {
        val albumIntent = Intent(Intent.ACTION_PICK)
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        activity.startActivityForResult(albumIntent, OPEN_ALBUMN)
        this.mChooseSuccessListener = chooseSuccessListener
        LogUtils.d("data：$mChooseSuccessListener")
    }

    fun openAlbumCrop(activity: Activity, chooseSuccessListener: ChooseSuccessListener) {
        this.mChooseSuccessListener = chooseSuccessListener
        val albumIntent = Intent(Intent.ACTION_PICK)
//        albumIntent.type = "image/*"
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        activity.startActivityForResult(albumIntent, OPEN_ALBUMN_CROP)
        LogUtils.d("data：$mChooseSuccessListener")
    }

    fun onActivityResult(activity: Activity, requestCode: Int, resultCode: Int, data: Intent?) {
        LogUtils.d("requestCode：$requestCode")
        LogUtils.d("resultCode：$resultCode")
        LogUtils.d("data：${data ?: data.toString()}")
        LogUtils.d("data：$mChooseSuccessListener")
        if (resultCode != Activity.RESULT_OK) {
            LogUtils.d("返回结果：${data ?: data.toString()}")
            return
        }
        when (requestCode) {
            OPEN_ALBUMN -> mChooseSuccessListener!!.success()
            OPEN_ALBUMN_CROP -> data?.let {
                crop(activity, data.data, pathUrl)
//                crop(activity, uriClipUri, )
            }
            GET_IMAGE -> {
                mChooseSuccessListener!!.success()
            }
        }


//        if (requestCode == OPEN_ALBUMN && resultCode == Activity.RESULT_OK) {
//            data?.let {
//            }
//
//        } else if (requestCode == 33) {
//            //相册返回结果
//            if (resultCode == Activity.RESULT_OK) {
//                //选择的图片转存 在DCIM/Image目录
//                data?.let {
//                    //                    corpPic(it.data)
//                }
//            }
//        } else if (requestCode == 44) {
//            //裁剪回调
////            Picasso.get().load(imgUri).memoryPolicy(MemoryPolicy.NO_CACHE).into(image)
//        }

    }


    private fun crop(activity: Activity, uri: Uri, pathUrl: String) {
        val intent = Intent("com.android.camera.action.CROP")
        intent.setDataAndType(uri, "image/*")
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(File(pathUrl)))
        LogUtils.d("Url: " + pathUrl)
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, pathUrl)
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString())

        uriClipUri = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().path + "/" + "clip.jpg");
        LogUtils.d("Url: " + uriClipUri?.path)
//        //Android 对Intent中所包含数据的大小是有限制的，一般不能超过 1M，否则会使用缩略图 ,所以我们要指定输出裁剪的图片路径
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriClipUri);
        intent.putExtra("return-data", false);//是否将数据保留在Bitmap中返回
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//输出格式，一般设为Bitmap格式及图片类型
        intent.putExtra("noFaceDetection", true);//人脸识别功能

        activity.startActivityForResult(intent, CROP)
    }

//    private fun crop(activity: Activity, uri: Uri, cropPathUrl: String = pathUrl) {
//        val intent = Intent("com.android.camera.action.CROP")
//        intent.setDataAndType(uri, "image/*")
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(File(cropPathUrl)))
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString())
//
//        uriClipUri =
//            Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().path + "/" + "clip.jpg");
//        LogUtils.d("Url: " + uriClipUri?.path)
//        //Android 对Intent中所包含数据的大小是有限制的，一般不能超过 1M，否则会使用缩略图 ,所以我们要指定输出裁剪的图片路径
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriClipUri);
//        intent.putExtra("return-data", false);//是否将数据保留在Bitmap中返回
//        intent.putExtra(
//            "outputFormat",
//            Bitmap.CompressFormat.JPEG.toString()
//        );//输出格式，一般设为Bitmap格式及图片类型
//        intent.putExtra("noFaceDetection", true);//人脸识别功能
//        activity.startActivityForResult(intent, 33)
//    }

    private fun handImage(data: Intent) {

    }

    private fun getImagePath(context: Context, uri: Uri, selection: String) {
        val path: String? = null
        var cursor = context.contentResolver.query(uri, null, selection, null, null)
    }

    private fun stringToUri(context: Context, path: String) {
        val uri: Uri
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //如果是7.0android系统
            val contentValues = ContentValues(1)
            contentValues.put(MediaStore.Images.Media.DATA, path)
            uri = context.contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
        } else {
            uri = Uri.fromFile(File(path))
        }
    }

}

interface ChooseSuccessListener{
    fun success()
}