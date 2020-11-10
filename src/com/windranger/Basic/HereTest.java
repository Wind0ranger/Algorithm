package com.windranger.Basic;

// 跳出多层循环
public class HereTest {
    public static void main(String[] args) {
        outloop:
        //outloop这个标示是可以自定义的比如outloop1,ol2,out5
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + ":" + j);
                if (i > 3)
                    break outloop; //如果是双数，结束外部循环
            }
        }
    }
}
