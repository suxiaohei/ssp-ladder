package com.ladder.java;

/**
 * Created by suxin on 16-11-23.
 */


import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

/**
 * 利用7zbinding
 */
public class Unzip {

    public static void main(String[] args) {
        try {
//            Unzip.extract("/home/suxin/下载/test/test.zip");
            Unzip.extract(new File("/home/suxin/下载/test/aaa.7z"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void extractile(String filepath) {
        RandomAccessFile randomAccessFile = null;

        IInArchive inArchive = null;

        try {
            randomAccessFile = new RandomAccessFile(filepath, "r");
            inArchive = SevenZip.openInArchive(ArchiveFormat.ZIP, new RandomAccessFileInStream(randomAccessFile));

            // Getting simple interface of the archive inArchive
            ISimpleInArchive simpleInArchive = inArchive.getSimpleInterface();

            System.out.println("  Hash  |  Size  | Filename");
            System.out.println("----------+------------+---------");

            for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()) {
                final int[] hash = new int[]{0};
                if (!item.isFolder()) {
                    ExtractOperationResult result;

                    final long[] sizeArray = new long[1];
                    result = item.extractSlow(new ISequentialOutStream() {
                        public int write(byte[] data) throws SevenZipException {

                            //Write to file
                            FileOutputStream fos;
                            try {
                                File file = new File(item.getPath());
                                //error occours below
//                 file.getParentFile().mkdirs();
                                fos = new FileOutputStream(file);
                                fos.write(data);
                                fos.close();

                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            hash[0] ^= Arrays.hashCode(data); // Consume data
                            sizeArray[0] += data.length;
                            return data.length; // Return amount of consumed data
                        }
                    });
                    if (result == ExtractOperationResult.OK) {
                        System.out.println(String.format("%9X | %10s | %s", //
                                hash[0], sizeArray[0], item.getPath()));
                    } else {
                        System.err.println("Error extracting item: " + result);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurs: " + e);
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (inArchive != null) {
                try {
                    inArchive.close();
                } catch (SevenZipException e) {
                    System.err.println("Error closing archive: " + e);
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e);
                }
            }
        }
    }

    private static void extract(File srcZipfile)
            throws IOException {
        ZipInputStream zipIn = null;
        try {
            zipIn = new ZipInputStream(new FileInputStream(srcZipfile));
            ZipEntry entry = null;
            while ((entry = zipIn.getNextEntry()) != null) {
                String outFilename = entry.getName();
                if (!entry.isDirectory())
                    System.out.println(zipIn);
            }
            System.out.println("Zip文件提取成功...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zipIn != null) {
                zipIn.close();
            }
        }
    }


    static void extractile1(String filepath) throws Exception {
        File tempFile = new File(filepath);//需要解压的文件
        FileOutputStream outputStream = new FileOutputStream(new File(filepath));
        SevenZFile sevenZFile = new SevenZFile(tempFile);
        while (true) {
            //获取下一个文件
            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            if (entry == null) {
                break;
            }
            byte[] content = new byte[(int) entry.getSize()];
            int count = 0;
            while ((count = sevenZFile.read(content, 0, (int) entry.getSize())) > 0) {
                System.out.print(content);
                outputStream.write(content, 0, count);
            }
        }
        sevenZFile.close();
    }

}