package com.swordoffer.linklist;

import com.Timing;

import java.util.ArrayList;
import java.util.Collections;

/**
 * class:PrintListFromTailToHead   <br/>
 * Description:nowcoder网->剑指offer: 从尾到头打印链表 <br/>
 * 题目描述：输入一个链表，从尾到头打印链表每个节点的值。 <br/>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-23 下午3:45
 */

public class PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        nodeList.add(listNode.val);
        while ((listNode = listNode.next) != null) {
            nodeList.add(listNode.val);
        }
        Collections.reverse(nodeList);
        return nodeList;
    }

    public static void main(String[] args) {
        Timing.startNanoTime();
        ListNode firstListNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        firstListNode.next = listNode1;
        System.out.println(printListFromTailToHead(firstListNode));
        Timing.printNanoTime();
    }
}
