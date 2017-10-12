package com.base;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author oukailiang
 * @create 2017-10-11 下午7:52
 */

public class BuMen {
    /**
     * 构建树，打印树
     *
     * @param strArr
     */
    private static void test(String[] strArr) {
        int len = strArr.length;
        Set<String> parentIds = new HashSet<>();
        List<Part> parts = new ArrayList<>();
        parentIds.add("0");
        for (int i = 0; i < len; i++) {
            String[] strB = strArr[i].split(",");
            Part part = new Part();
            if (!parentIds.contains(strB[2])) {
                System.out.println("incorrect data");
                return;
            }
            parentIds.add(strB[0]);
            part.setId(strB[0]);
            part.setName(strB[1]);
            part.setParentId(strB[2]);
            parts.add(part);
        }
        Map<String, List<Part>> partMap = parts.stream().collect(Collectors.groupingBy(Part::getParentId));
        Part rootPart = parts.get(0);
        tree(rootPart, partMap);
        //print
        if (rootPart.getNextParts() == null) {
            System.out.println(rootPart.getName());
        } else {
            List<String> results = new ArrayList<>();
            printAllRootToLeaf(rootPart.getNextParts(), rootPart.getName(), results);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < results.size(); i++) {
                if (i != results.size() - 1) {
                    result.append(results.get(i) + ";");
                } else {
                    result.append(results.get(i));
                }
            }
            System.out.println(result.toString());
        }
    }

    /**
     * 获得所有树根节点到叶子节点的路径
     *
     * @param parts
     * @param path
     * @param results
     */
    private static void printAllRootToLeaf(List<Part> parts, String path, List<String> results) {
        for (Part part : parts) {
            if (part.nextParts == null) {
                results.add(path + "-" + part.getName());
                continue;
            }
            path = path + "-" + part.getName();
            printAllRootToLeaf(part.nextParts, path, results);
        }

    }

    /**
     * 构建树结构
     *
     * @param nextPart
     * @param partMap
     */
    private static void tree(Part nextPart, Map<String, List<Part>> partMap) {
        List<Part> nextParts = partMap.get(nextPart.getId());
        if (nextParts == null || nextParts.isEmpty()) {
            return;
        }
        for (Part part : nextParts) {
            tree(part, partMap);
        }
        nextPart.setNextParts(nextParts);
    }

    /**
     * 存储前缀
     *
     * @param strArr
     */
    private static void prex(String[] strArr) {
        int len = strArr.length;
        //查询是否有该父节点
        List<String> parentIds = new ArrayList<>();
        List<String> realParentIds = new ArrayList<>();//记录有子节点的节点id
        Map<String, String> idValueMap = new HashMap<>();
        parentIds.add("0");//根节点
        for (int i = 0; i < len; i++) {
            String[] strB = strArr[i].split(",");
            if (!parentIds.contains(strB[2])) {
                System.out.println("incorrect data");
                return;
            }
            if (!parentIds.contains(strB[0])) {
                parentIds.add(strB[0]);
            }
            if (!realParentIds.contains(strB[2])) {
                realParentIds.add(strB[2]);
            }
            String value = idValueMap.get(strB[2]);
            if (value == null) {
                idValueMap.put(strB[0], strB[1]);
            } else {
                idValueMap.put(strB[0], value + "-" + strB[1]);
            }
        }
        parentIds.removeAll(realParentIds);

        //顺序输入叶子节点的路径
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parentIds.size(); i++) {
            if (i != parentIds.size() - 1) {
                result.append(idValueMap.get(parentIds.get(i)) + ";");
            } else {
                result.append(idValueMap.get(parentIds.get(i)));
            }
        }
        System.out.println(result.toString());

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * 1,A,0;2,B,1;3,C,2;4,D,2
         1,A,0;2,B,1;3,C,1
         1,A,0;B,1,2
         2,A,0;1,B,1;3,C,2
         */
        while (true) {
            String str = sc.nextLine();
            if ("".equals(str.trim())) {
                break;
            }
            String[] strArr = str.split(";");
            //构建树
//            test(strArr);

            //存取前缀
            prex(strArr);
        }
    }

    static class Part {
        private String id;
        private String name;
        private String parentId;
        private List<Part> nextParts;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<Part> getNextParts() {
            return nextParts;
        }

        public void setNextParts(List<Part> nextParts) {
            this.nextParts = nextParts;
        }
    }
}
