package com.windranger.IO.BasicIO;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        File in = new File("D:\\workspace\\github\\Algorithm\\src\\com\\windranger\\IO\\BasicIO\\xanadu.txt");
        File out = new File("D:\\workspace\\github\\Algorithm\\src\\com\\windranger\\IO\\BasicIO\\outagain.txt");

        copyFileByStream(in, out);
        copyFileByChannel(in, out);
    }

    public static void copyFileByChannel(File source, File dest) throws
            IOException {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel()) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }


    public static void copyFileByStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(dest);) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

}