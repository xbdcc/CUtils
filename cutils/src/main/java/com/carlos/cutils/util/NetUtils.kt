package com.carlos.cutils.util

import android.os.Handler
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Carlos on 2018/11/30.
 */
class NetUtils {

    fun get(url: String): String {
        try {
            val url = URL(url)
            val httpURLConnection = url.openConnection()
            httpURLConnection.connectTimeout = 10 * 1000
            httpURLConnection.connect()
            // 通过InputStreamReader读取流，设置编码防止中文乱码
            val inputStreamReader = InputStreamReader(httpURLConnection.getInputStream(), "GBK")
            val bufferedReader = BufferedReader(inputStreamReader)
            var resultData = ""
            var inputLine = bufferedReader.readLine()
            while (inputLine != null) {
                resultData += inputLine
                inputLine = bufferedReader.readLine()
            }
            return resultData
//            Log.i("Http通信之HttpURLConnection", "get方法\n" + resultData);
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    fun post(url: String, data: String): String {
        try {
            val url = URL(url)
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.doInput = true
            httpURLConnection.doOutput = true
            httpURLConnection.requestMethod = "POST"
            httpURLConnection.connect()

            val dataOutputStream = DataOutputStream(httpURLConnection.outputStream)
            dataOutputStream.write(data.toByteArray())
            dataOutputStream.flush()
            dataOutputStream.close()

            val inputStreamReader = InputStreamReader(httpURLConnection.inputStream, "UTF-8")
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuffer = StringBuffer()
            var temp = bufferedReader.readLine()
            while (temp != null) {
                stringBuffer.append(temp)
                temp = bufferedReader.readLine()
            }
            bufferedReader.close()
            inputStreamReader.close()
            httpURLConnection.disconnect()
            LogUtils.d("test:$stringBuffer")
            return stringBuffer.toString()
        } catch (e: Exception) {
            LogUtils.d("error", e)
            e.printStackTrace()
            return ""
        }
    }

    fun download(url: String, filePath: String, handler: Handler) {
        try {
            val file = File(filePath)
            LogUtils.d("filePath:" + file.path)

            val url = URL(url)
            val httpURLConnection = url.openConnection() as HttpURLConnection

            var hasDownSize = 0L

            if (file.exists()) {
                hasDownSize = file.length()

                // 设置断点续传的开始位置
                httpURLConnection.setRequestProperty("Range", "bytes=" + file.length() + "-")
            }
            val code = httpURLConnection.responseCode
            LogUtils.d("responseCode:$code")
            if (code == 200 || code == 206) {

                val inputStream = httpURLConnection.inputStream
                val fileOutputStream = FileOutputStream(file, true)

                val totoalSize = httpURLConnection.contentLength + hasDownSize
                val buffer = ByteArray(102400)
                var readByte = inputStream.read(buffer)

                while (readByte != -1) {
                    fileOutputStream.write(buffer, 0, readByte)
                    hasDownSize += readByte
                    readByte = inputStream.read(buffer)

                    val percent = hasDownSize * 100.0f / totoalSize
                    handler.sendEmptyMessage(percent.toInt())
                    LogUtils.d("percent:$percent----down:$hasDownSize---total:$totoalSize")
                }
            } else if (code == 416) {
                handler.sendEmptyMessage(100)
            } else
                handler.sendEmptyMessage(-1)
        } catch (e: Exception) {
            handler.sendEmptyMessage(-1)
        }

    }

}