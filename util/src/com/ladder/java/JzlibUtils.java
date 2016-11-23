package com.ladder.java;

import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.ZStream;

import java.io.*;

/**
 * Created by suxin on 16-11-21.
 */
public class JzlibUtils {

    private static final int PIPSIZE = 1024;
    //要确保方法compressfile（）与uncompressfile（）参数一致
    static int resLen = 0;

    public static void main(String[] args) {
        String inputPath = "/home/suxin/下载/BCA-1B/2016-11-17-13-19-9-340-sanofi001-auto.csv.zip";
        JzlibUtils.unZip(new File(inputPath));
//        JzlibUtils.zip(new File("/home/suxin/下载/BCA-1B/2016-11-13-20-15-30-250-sanofi001-auto.csv"), new File("/home/suxin/下载/BCA-1B/2016-11-13-20-15-30-250-sanofi001-auto.csv.zip"), 8);
    }

    public static byte[] uncompressfile(byte[] data, int len) {
        int err;
        int uncomprLen = len;
        byte[] uncompr = new byte[uncomprLen];
        ZStream d_stream = new ZStream();

        err = d_stream.inflateInit();
        CHECK_ERR(d_stream, err, "inflateInit");

        d_stream.next_in = data;
        d_stream.next_in_index = 0;
        d_stream.next_out = uncompr;
        d_stream.next_out_index = 0;

        while (d_stream.total_out < uncomprLen
                && d_stream.total_in < uncomprLen) {
            d_stream.avail_in = d_stream.avail_out = 1;
            err = d_stream.inflate(JZlib.Z_NO_FLUSH);
            if (err == JZlib.Z_STREAM_END) {
                break;
            }
            CHECK_ERR(d_stream, err, "inflate");
        }
        err = d_stream.inflateEnd();
        CHECK_ERR(d_stream, err, "inflateEnd");

        byte[] unzipfile = new byte[(int) d_stream.total_out];
        System.arraycopy(uncompr, 0, unzipfile, 0, unzipfile.length);
        return unzipfile;
    }

    static void CHECK_ERR(ZStream z, int err, String msg) {
        if (err != JZlib.Z_OK) {
            if (z.msg != null) {
                System.out.print(z.msg + " ");
            }
            System.out.println(msg + " error: " + err);
            System.exit(1);
        }
    }

    /**
     * 压缩
     *
     * @param data
     * @param type 压缩方法为一个整数 -1为默认压缩比 9为最高压缩比 0为不压缩 1为快速压缩
     * @return
     */
    private static byte[] compressfile(byte[] data, int type, int len) {

        int err;
        int comprLen = len;
        byte[] compr = new byte[comprLen];
        ZStream c_stream = new ZStream();
        err = c_stream.deflateInit(type);
        CHECK_ERR(c_stream, err, "deflateInit");

        c_stream.next_in = data;
        c_stream.next_in_index = 0;

        c_stream.next_out = compr;
        c_stream.next_out_index = 0;

        while (c_stream.total_in != data.length
                && c_stream.total_out < comprLen) {
            c_stream.avail_in = c_stream.avail_out = 1; // 置初值
            err = c_stream.deflate(JZlib.Z_NO_FLUSH);
            CHECK_ERR(c_stream, err, "deflate");
        }

        while (true) {
            c_stream.avail_out = 1;
            err = c_stream.deflate(JZlib.Z_FINISH);
            if (err == JZlib.Z_STREAM_END) {
                break;
            }
            CHECK_ERR(c_stream, err, "deflate");
        }

        err = c_stream.deflateEnd();
        CHECK_ERR(c_stream, err, "deflateEnd");

        byte[] zipfile = new byte[(int) c_stream.total_out];
        System.arraycopy(compr, 0, zipfile, 0, zipfile.length);
        return zipfile;
    }

    /**
     * 解压zlib文件，并输出到指定目录
     *
     * @param input 源文件
     */
    public static void unZip(File input) {

        File output = JzlibUtils.getOutPutFile(input);

        if (!input.exists())
            return;
        if (!output.getParentFile().exists())
            output.getParentFile().mkdir();

        try {
            FileInputStream in = new FileInputStream(input);
            FileOutputStream out = new FileOutputStream(output);

            byte[] buff = new byte[JzlibUtils.PIPSIZE];
            in.read(buff);

            byte[] suBuff = uncompressfile(buff, JzlibUtils.PIPSIZE);
            out.write(suBuff, 0, suBuff.length); // 写压缩文件

            in.close();
            out.close();
            System.out.println("解压完毕！" + input.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void zip(File input, File output, int compressFactor) {
        if (!input.exists())
            return;
        if (!output.getParentFile().exists())
            output.getParentFile().mkdir();

        try {
            FileInputStream in = new FileInputStream(input);
            FileOutputStream out = new FileOutputStream(output);
            resLen = in.available();
            byte[] buff = new byte[resLen];
            in.read(buff);

            byte[] suBuf = compressfile(buff, compressFactor, resLen);
            out.write(suBuf, 0, suBuf.length); // 写压缩文件

            in.close();
            out.close();
            System.out.println("压缩完毕！" + input.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File getOutPutFile(File input) {
        String fileName = input.getName();
        String dir = input.getAbsolutePath().substring(0, input.getAbsolutePath().lastIndexOf(input.separator));
        String outputFileName = fileName.substring(0, fileName.lastIndexOf(".zip"));
        return new File(dir + input.separator + outputFileName);
    }
}
