package com.windranger.Thread.Communication.Process;

import java.io.*;

public class TestIn implements Runnable{

    private Process p;
    public TestIn(Process process){
        p = process;
    }

    @Override
    public void run() {
        try {
            InputStream in = p.getInputStream();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
            String rd = bfr.readLine();
            if(rd != null){
                //输出子进程返回信息(即子进程中的System.out.println()内容)
                System.out.println(rd);
            }else{
                return;
            }
            //注意这个地方，如果关闭流则子进程的返回信息无法获取，如果不关闭只有当子进程返回字节为8192时才返回，为什么是8192下面说明.
            //bfr.close();
            //in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}