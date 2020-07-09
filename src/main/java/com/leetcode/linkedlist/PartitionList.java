package com.leetcode.linkedlist;

/**
 * Class:PartitionList<br/>
 * Description:nowcoder网->leetcode题目:partition-list <br/>
 * 
 * 题目描述: A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null. Return a
 * deep copy of the list. <br/>
 * 题目翻译简述：在一个单链表中，对给定的x，将小于x或原链表中排在x前面的这些元素移致x前面。 <br/>
 * 解题思路：问题转化为对单链表遍历，将小于x的元素放到一个链表中，将大于或等于x的放到另外一个链表中。 <br/>
 * 
 * Copyright: USTC
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		// 存分别指向小于x和大于等于的链表的头指针
		ListNode beforeX = new ListNode(0);
		ListNode xAfter = new ListNode(0);
		// 声明两个后移指针
		ListNode beforeP = beforeX;
		ListNode pAfter = xAfter;
		while (head != null) {
			if (head.val < x) {
				beforeP.next = head;
				beforeP = head;
			} else {
				pAfter.next = head;
				pAfter = head;
			}
			head = head.next;
		}
		pAfter.next = null;
		beforeP.next = xAfter.next;
		return beforeX.next;
	}
}

/**
 * 定义一个单链表
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;

	}
}