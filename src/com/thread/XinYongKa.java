package com.thread;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class:   <br/>
 * Description:2017 51信用卡内推笔试:<br/>
 * 题目描述：有一个长度200000的队列，队列中的元素均为字符串，现需要创建3个线程分别取出队列中的元素， <br/>
 * 并查找元素中是否含有字符串u51，如果含有该字符串，则计数器加1，直到队列元素都取完，输出含有字符串u51的个数   。<br/>
 * <br/>
 * <p>
 * 输入描述：200000行字符串数据，可以是文件作为队列输入.
 * <p>
 * <br/>
 * <p>
 * 输出描述： 所有数据中包含u51的个数<br/>
 * <br/>
 * <p>
 * 输入例子:  <br/>
 * 输出例子:  <br/>
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-09-18 下午8:05
 */
public class XinYongKa {

    static class DiskMemory implements Runnable {
        private List<String> InputStr;
        private static int totalSize = 0;
        private static int index = 0;

        public DiskMemory(List<String> inputStr) {
            InputStr = inputStr;
        }

        @Override
        public void run() {
            handle();
        }

        public synchronized void  handle(){
            for (index = 0; index < InputStr.size(); index++) {
                if (InputStr.get(index).contains("u51")) {
                    totalSize++;
                }
            }
            notifyAll();//一组中的任一线程打印完后唤醒另一个线程
            try {
                wait();//释放锁进入等待状态，等待另一线程打印
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        public static int getTotalSize() {
            return totalSize;
        }

        public static void setTotalSize(int totalSize) {
            DiskMemory.totalSize = totalSize;
        }
    }


    public static void main(String[] args) throws Exception {
        //一行一行读取文件
//        FileReader fr = new FileReader(new File(""));
//        BufferedReader br = new BufferedReader(fr);
//        String line = null;
//        while ((line = br.readLine()) != null) {
//
//        }
//        fr.close();
//        br.close();


        Scanner sc = new Scanner(System.in);

        List<String> strArr = new ArrayList<>();
        //构建数据
        for (int i = 0; i < 200000; i++) {
            if (i % 2 == 0) {//偶数
                strArr.add("123432");
            } else {
                strArr.add("123432u51");
            }

        }
        CountDownLatch countDownLatch = new CountDownLatch(3);
        int result = 0;
        DiskMemory diskMemory = new DiskMemory(strArr);

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(diskMemory);
            t.start();

//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    int timer = new Random().nextInt(5);
//                    try {
//                        Thread.sleep(timer * 1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    int diskSize = diskMemory.getSize();
//                    System.out.printf("完成磁盘的统计任务,耗费%d秒. 磁盘大小为%d.\n", timer, diskSize);
//                    diskMemory.setSize(diskSize);
//
//                    // 任务完成之后,计数器减一
//                    countDownLatch.countDown();
//                    System.out.println("count num = " + countDownLatch.getCount());
//                }
//            });
//
        }
        // 主线程一直被阻塞,直到count的计数器被置为0
        countDownLatch.await();
        System.out.println(DiskMemory.getTotalSize());
    }

}
