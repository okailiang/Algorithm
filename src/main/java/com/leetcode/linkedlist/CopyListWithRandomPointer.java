package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Class:CopyListWithRandomPointer<br/>
 * Description:nowcoder网->leetcode题目:copy-list-with-random-pointer <br/>
 * 
 * 题目描述: A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null. Return a
 * deep copy of the list.<br/>
 * 题目翻译简述：在一个单链表中每个结点包含一个自由指针可以指向该链表中的任意结点或空。 <br/>
 * 
 * 题目分析：题目中每个节点Node出现了Random属性，也就意味着可能当前结点Node所依赖的那个Random对应的结点还没有被创建出来，
 * 所以要先把所有的结点拷贝出来。<br/>
 * 解题思路：先遍历单链表拷贝原来的结点，再调整每个结点自由指针的指向。 <br/>
 * 
 * Copyright: USTC
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}
		// 声明移动指针
		RandomListNode p = head;
		Map<RandomListNode, RandomListNode> randomNodeMap = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode copyNode;
		// 拷贝单链表中的每个结点
		while (p != null) {
			copyNode = new RandomListNode(p.label);
			randomNodeMap.put(p, copyNode);
			p = p.next;
		}
		// 再将移动指针指向原单链表中的头
		p = head;
		// 为每个拷贝新结点设置next,random的指向
		while (p != null) {
			if (p.next != null) {
				randomNodeMap.get(p).next = randomNodeMap.get(p.next);
			}
			if (p.random != null) {
				randomNodeMap.get(p).random = randomNodeMap.get(p.random);
			}
			p = p.next;
		}
		return randomNodeMap.get(head);
	}
}

/**
 * Definition for singly-linked list with a random pointer.<br/>
 * 定义一个带有自由指针的单链表
 */
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
