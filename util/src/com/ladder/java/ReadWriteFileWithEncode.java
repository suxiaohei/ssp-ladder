package com.ladder.java;

import org.apache.commons.compress.compressors.deflate.DeflateParameters;

import java.io.*;

/**
 * Created by suxin on 16-11-21.
 */
public class ReadWriteFileWithEncode {

    public static void write(String path, String content, String encoding)
            throws IOException {
        File file = new File(path);
        file.delete();
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), encoding));
        writer.write(content);
        writer.close();
    }

    public static String read(String path, String encoding) throws IOException {
        String content = "";
        String line = null;

        DeflateParameters dp = new DeflateParameters();
        dp.setWithZlibHeader(true);
//        DeflateCompressorOutputStream txt = new DeflateCompressorOutputStream(new FileOutputStream(output), dp);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), encoding));
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        reader.close();
        return content;
    }

    public static void main(String[] args) throws IOException {
        String content = "中文内容";
        String path = "/home/suxin/下载/BCA-1B/2016-11-13-20-15-30-250-sanofi001-auto.csv.zip";
        String encoding = "gbk";
//        ReadWriteFileWithEncode.write(path, content, encoding);
        System.out.println(ReadWriteFileWithEncode.read(path, encoding));
    }
}
