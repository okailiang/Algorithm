package com.nowcoder.ali;

import java.util.Scanner;

public class Main {
    private static final Integer CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    private static Model boxTemplate = new Model();
    private static Integer boxMinNum;
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int process(Model[] items) {

        return 0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process(items));
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }
    }

   static class Model {

        private Integer price;
        private Integer length;
        private Integer width;
        private Integer height;

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

}

