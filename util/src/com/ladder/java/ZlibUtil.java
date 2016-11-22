package com.ladder.java;

import com.jcraft.jzlib.ZInputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateParameters;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
//import java.util.zip.Deflater;
//import java.util.zip.Inflater;
//import java.util.zip.ZipInputStream;

import static org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField.READ;

/**
 * Created by suxin on 16-11-21.
 */
public class ZlibUtil {

    public static void main(String[] args) {
        try {
//            ZlibUtil.zlib("/home/suxin/下载/BCA-1B/2016-11-13-20-11-43-887--auto.csv.zip", "/home/suxin/下载/BCA-1B/test.csv");
//            ZlibUtil.zlib2("/home/suxin/下载/BCA-1B/2016-11-13-20-11-43-887--auto.csv.zip");
//            ZlibUtil.zlib3("/home/suxin/下载/BCA-1B/test.txt.zip");
//            ZlibUtil.zlib4("/home/suxin/下载/BCA-1B/2016-11-13-20-11-43-887--auto.csv.zip", "/home/suxin/下载/BCA-1B/test.txt");
            FileInputStream fis = new FileInputStream("/home/suxin/下载/BCA-1B/2016-11-13-20-11-43-887--auto.csv.zip");
            int len = fis.available();
            byte[] b = new byte[len];
            fis.read(b);
            unjzlib(b);
////            byte[] bd = compress(b);
////            byte[] bi = uncompress(b);
////            FileOutputStream fos = new FileOutputStream("/home/suxin/下载/BCA-1B/test.csv");
////            fos.write(bi);
////            fos.flush();
////            fos.close();
////            fis.close();
//            System.out.println(ZlibUtil.unZip(b));
//            ZlibUtil.readZipStreamTest("/home/suxin/下载/BCA-1B/test.txt.zip");
//            ZlibUtil.readZipStreamTest("/home/suxin/下载/BCA-1B/2016-11-13-20-11-43-887--auto.csv.zip");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zlib(String input, String output) throws Exception {

        DeflateParameters dp = new DeflateParameters();
        dp.setWithZlibHeader(false);

        //DeflateCompressorOutputStream dcos = new DeflateCompressorOutputStream(new FileOutputStream(output), dp);
        //FileInputStream read = new FileInputStream(input);
        InputStream ins = new DeflateCompressorInputStream(new FileInputStream(input), dp);
        OutputStream outs = new FileOutputStream(output);

        //FileInputStream fis = new FileInputStream(input);
        int length = (int) new File(input).length();
        byte data[] = new byte[length];
        // int length;
        while ((length = ins.read(data)) > 0) {
            outs.write(data, 0, length);
        }

        //fis.close();
        //outs.finish();
        outs.close();
        ins.close();
    }

    public static void zlib2(String input) throws Exception {

        FileInputStream fis = new FileInputStream(input);
        DumpArchiveInputStream dumpInput = new DumpArchiveInputStream(fis, "gbk");
        DumpArchiveEntry entry = dumpInput.getNextDumpEntry();
        byte[] content = new byte[(int) entry.getSize()];
        System.out.println(content);
    }

    public static void zlib3(String input) throws Exception {

        FileInputStream fis = new FileInputStream(input);
        ZipArchiveInputStream zipInput = new ZipArchiveInputStream(fis);
        ZipArchiveEntry entry = zipInput.getNextZipEntry();
        byte[] content = new byte[(int) entry.getSize()];
        System.out.println(content);
    }

    public static void zlib4(String input, String output) throws Exception {

        FileInputStream fin = new FileInputStream(input);
        BufferedInputStream in = new BufferedInputStream(fin);
        FileOutputStream out = new FileOutputStream(output);
        DeflateCompressorInputStream defIn = new DeflateCompressorInputStream(in);
        final byte[] buffer = new byte[fin.available()];
        int n = 0;
        while (-1 != (n = defIn.read(buffer))) {
            out.write(buffer, 0, n);
        }
        out.write(buffer, 0, n);
        out.close();
        defIn.close();
    }

//    /**
//     * @param inputByte 待解压缩的字节数组
//     * @return 解压缩后的字节数组
//     * @throws IOException
//     */
//    public static byte[] uncompress(byte[] inputByte) throws IOException {
//        int len = 0;
//        Inflater infl = new Inflater();
//        infl.setInput(inputByte);
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        byte[] outByte = new byte[1024];
//        try {
//            while (!infl.finished()) {
//                // 解压缩并将解压缩后的内容输出到字节输出流bos中
//                len = infl.inflate(outByte);
//                if (len == 0) {
//                    break;
//                }
//                bos.write(outByte, 0, len);
//            }
//            infl.end();
//        } catch (Exception e) {
//            //
//        } finally {
//            bos.close();
//        }
//        return bos.toByteArray();
//    }
//
//    /**
//     * 压缩.
//     *
//     * @param inputByte 待压缩的字节数组
//     * @return 压缩后的数据
//     * @throws IOException
//     */
//    public static byte[] compress(byte[] inputByte) throws IOException {
//        int len = 0;
//        Deflater defl = new Deflater();
//        defl.setInput(inputByte);
//        defl.finish();
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        byte[] outputByte = new byte[1024];
//        try {
//            while (!defl.finished()) {
//                // 压缩并将压缩后的内容输出到字节输出流bos中
//                len = defl.deflate(outputByte);
//                bos.write(outputByte, 0, len);
//            }
//            defl.end();
//        } finally {
//            bos.close();
//        }
//        return bos.toByteArray();
//    }
//
//    /***
//     * 解压Zip
//     *
//     * @param data
//     * @return
//     */
//    public static byte[] unZip(byte[] data) {
//        byte[] b = null;
//        try {
//            ByteArrayInputStream bis = new ByteArrayInputStream(data);
//            ZipInputStream zip = new ZipInputStream(bis);
//            while (zip.getNextEntry() != null) {
//                byte[] buf = new byte[1024];
//                int num = -1;
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                while ((num = zip.read(buf, 0, buf.length)) != -1) {
//                    baos.write(buf, 0, num);
//                }
//                b = baos.toByteArray();
//                baos.flush();
//                baos.close();
//            }
//            zip.close();
//            bis.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return b;
//    }

    /**
     * 解压被压缩的数据
     *
     * @param object
     * @return
     * @throws IOException
     */
    public static byte[] unjzlib(byte[] object) {
        byte[] data = null;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(object);
            ZInputStream zIn = new ZInputStream(in);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = zIn.read(buf, 0, buf.length)) != -1) {
                System.out.println(buf);
                baos.write(buf, 0, num);
            }

            data = baos.toByteArray();
            baos.flush();
            baos.close();
            zIn.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void readZipStreamTest(String path) {
        try {
            ZipInputStream zin = new ZipInputStream(new FileInputStream(path),
                    Charset.forName("gbk"));
            ZipEntry zipEntry = null;
            while ((zipEntry = zin.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());
            }
            zin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
