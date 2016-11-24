package com.ladder.java;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by suxin on 16-11-23.
 */
public class ZipUtil {

    public static void main(String[] args) {
        try {
            File file = new File("/home/suxin/下载/abc.zip");
            System.out.println(unZip(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<byte[]> unZip(File zipfile) throws Exception {
        return unCompress(zipfile);
    }

    public static List<byte[]> unCompress(File zipfile) {
        List<byte[]> fileBytes = new ArrayList<byte[]>();

        try {
            ZipFile zipFile = new ZipFile(zipfile);
            Enumeration<?> e = zipFile.getEntries();
            while (e.hasMoreElements()) {
                ZipArchiveEntry entry = (ZipArchiveEntry) e.nextElement();
                byte[] unzipfile = IOUtils.toByteArray(zipFile.getInputStream(entry));
                fileBytes.add(unzipfile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

}
