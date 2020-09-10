package com.windranger.Thread.Communication.Process;

import java.io.IOException;

public class ProcessTest {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java  com.windranger.Thread.Communication.Process.ChildProcess");

        StringBuilder sbuilder = new StringBuilder();
        for (int k = 0; k < 1; k++) {
            sbuilder.append("hello");
        }

        int outSize = 1;
        TestOut out[] = new TestOut[outSize];
        for (int i = 0; i < outSize; i++) {
            out[i] = new TestOut(p, sbuilder.toString().getBytes());
            new Thread(out[i]).start();
        }

        int inSize = 1;
        TestIn in[] = new TestIn[inSize];
        for (int j = 0; j < inSize; j++) {
            in[j] = new TestIn(p);
            new Thread(in[j]).start();
        }
    }
}
