package com.nowcoder;


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author oukailiang
 * @create 2017-09-18 下午8:05
 */
public class XinYongKa extends Thread {

    static public class DiskMemory {
        private int totalSize;

        public int getSize() {
            return (new Random().nextInt(3) + 1) * 100;//加一是为了防止获取磁盘大小为0，不符合常理
        }

        public void setSize(int size) {
            totalSize += size;
        }

        public int getTotalSize() {
            return totalSize;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        String[] strArr = new String[20000];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = sc.nextLine();
        }
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        DiskMemory diskMemory = new DiskMemory();
        int result = 0;
//        int index = ;


        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {


                    // 任务完成之后,计数器减一
                    countDownLatch.countDown();
                }
            };
            t.start();

            service.execute(new Runnable() {
                @Override
                public void run() {
                    int timer = new Random().nextInt(5);
                    try {
                        Thread.sleep(timer * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int diskSize = diskMemory.getSize();
                    System.out.printf("完成磁盘的统计任务,耗费%d秒. 磁盘大小为%d.\n", timer, diskSize);
                    diskMemory.setSize(diskSize);

                    // 任务完成之后,计数器减一
                    countDownLatch.countDown();
                    System.out.println("count num = " + countDownLatch.getCount());
                }
            });

        }
        // 主线程一直被阻塞,直到count的计数器被置为0
        countDownLatch.await();
        System.out.println(result);
        service.shutdown();
    }

}
