package com.windranger.IO.BIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOClient {

    public static void main(String[] args) throws IOException {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Socket socket = new Socket("127.0.0.1", 6666);
        for (int i = 0; i < 20; i++) {
            newCachedThreadPool.execute(() -> {
                while (true){
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

        }

    }

}