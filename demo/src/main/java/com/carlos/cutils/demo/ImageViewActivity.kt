package com.carlos.cutils.demo

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import com.carlos.cutils.base.activity.CBaseActivity
import com.carlos.cutils.listener.PermissionListener
import com.carlos.cutils.util.LogUtils
import java.io.File

/**
 * Created by Carlos on 2019-11-18.
 */
class ImageViewActivity : CBaseActivity() {

    lateinit var file : File; //随便命名一个
    lateinit var uriClipUri : Uri; //随便命名一个
    lateinit var albumUtils: AlbumUtils;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imageview)
//        file = File(cacheDir, "abc.jpg")
        file = File(Environment.getExternalStorageDirectory().path + "/" + "clip.jpg")
        albumUtils = AlbumUtils()
        albumUtils.pathUrl = file.path
    }

    fun choosePic(view: View) {
        requestPermission(200, object : PermissionListener {
            override fun permissionSuccess() {
                AlbumUtils().openAlbum(this@ImageViewActivity, object : ChooseSuccessListener {
                    override fun success() {
                        val bitmap = BitmapFactory.decodeFile(file.path)
                        findViewById<ImageView>(R.id.imageview).setImageBitmap(bitmap)
                    }

                })
            }

            override fun permissionFail() {
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    fun chooseAndCropPic(view: View) {
        requestPermission(200, object : PermissionListener {
            override fun permissionSuccess() {
                AlbumUtils().openAlbumCrop(this@ImageViewActivity, object : ChooseSuccessListener {
                    override fun success() {
                        val bitmap = BitmapFactory.decodeFile(file.path)
                        findViewById<ImageView>(R.id.imageview).setImageBitmap(bitmap)
                    }

                })
            }

            override fun permissionFail() {
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        albumUtils.onActivityResult(this, requestCode, resultCode, data)
        LogUtils.d("返回结果：${data ?: data.toString()}")

//
//        if (requestCode ==  1) {
//
//            data?.let {
//                LogUtils.d("返回结果：${file.path}")
//                crop(data.data, file.path)
//
//            }
//
//
//            //相机结果返回
//            if (resultCode == Activity.RESULT_OK) {
////                imgUri?.let { corpPic(it) }
//            }
//        } else if (requestCode == 33) {
//            data?.let {
//                LogUtils.d("返回结果：${data.data}")
//                val bitmap = BitmapFactory.decodeFile(file.path)
//                LogUtils.d("返回结果：${file.path}")
//
////                findViewById<ImageView>(R.id.imageview).setImageBitmap(bitmap)
////                findViewById<ImageView>(R.id.imageview).setImageURI(uriClipUri)
//                findViewById<ImageView>(R.id.imageview).setImageBitmap(bitmap)
////                findViewById<ImageView>(R.id.imageview).setima
//            }
////            //相册返回结果
////            if (resultCode == Activity.RESULT_OK) {
////                //选择的图片转存 在DCIM/Image目录
////                data?.let {
////                    //                    corpPic(it.data)
////                }
////            }
//
//        } else if (requestCode == 44) {
//            //裁剪回调
////            Picasso.get().load(imgUri).memoryPolicy(MemoryPolicy.NO_CACHE).into(image)
//        }

    }


    private fun crop(uri: Uri, pathUrl: String) {
        val intent = Intent("com.android.camera.action.CROP")
        intent.setDataAndType(uri, "image/*")
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(File(pathUrl)))
        LogUtils.d("Url: " + pathUrl)
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, pathUrl)
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString())

        uriClipUri = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().path + "/" + "clip.jpg");
        LogUtils.d("Url: " + uriClipUri.path)
//        //Android 对Intent中所包含数据的大小是有限制的，一般不能超过 1M，否则会使用缩略图 ,所以我们要指定输出裁剪的图片路径
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriClipUri);
        intent.putExtra("return-data", false);//是否将数据保留在Bitmap中返回
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//输出格式，一般设为Bitmap格式及图片类型
        intent.putExtra("noFaceDetection", true);//人脸识别功能

        startActivityForResult(intent, 33)
    }



}