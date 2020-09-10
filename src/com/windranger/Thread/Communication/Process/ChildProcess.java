package com.windranger.Thread.Communication.Process;

import java.io.*;

public class ChildProcess {
    public static void main(String[] args) throws IOException {
        System.out.println("子进程被调用成功!");

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String strLine = bfr.readLine();
            if (strLine != null) {
                System.out.println("hi:" + strLine);
            }
        }
    }
}
