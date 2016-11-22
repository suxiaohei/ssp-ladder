package com.ladder.java;

import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.ZStream;

import java.io.*;

/**
 * Created by suxin on 16-11-21.
 */
public class JzlibUtils {

    private static final int PIPSIZE = 2048;

    public static void main(String[] args) {
        String inputPath = "/home/suxin/下载/BCA-1B/2016-11-13-20-11-15-478--manual.csv.zip";
        JzlibUtils.unZip(new File(inputPath));
    }


    private static byte[] uncompressfile(byte[] data, int len) {
        int err;
        int uncomprLen = len;
        byte[] uncompr = new byte[uncomprLen];
        ZStream d_stream = new ZStream();

        err = d_stream.inflateInit();
        CHECK_ERR(d_stream, err, "inflateInit");


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

    private static void CHECK_ERR(ZStream z, int err, String msg) {
        if (err != JZlib.Z_OK) {
            if (z.msg != null) {
                System.out.print(z.msg + " ");
            }
            System.out.println(msg + " error: " + err);
        }
    }

    /**
     * 解压zlib文件，并输出到指定目录
     *
     * @param input  源文件
     */
    public static void unZip(File input) {

        String fileName = input.getName();
        String dir = input.getAbsolutePath().substring(0 , input.getAbsolutePath().lastIndexOf(input.separator));
        String outputFileName = fileName.substring(0, fileName.lastIndexOf(".zip"));
        File output = new File(dir + input.separator + outputFileName);

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
}
