package com.nowcoder.program1;


import java.util.Scanner;

/**
 * class:StringClassification   <br/>
 * Description:nowcoder网->17年校招统一模拟一: DNA合成 <br/>
 * 题目描述：DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。<br/>
 * 碱基互补配对原则：A和T是配对的，C和G是配对的。<br/>
 * 如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。
 * 现在给出两条碱基链，允许在其中一条上做替换操作：<br/>
 * 把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功 <br/>
 * 输入描述：输入包括n+1行：<br/>
 * 包括两个字符串,分别表示两条链,两个字符串长度相同且长度均小于等于50。<br/>
 * 输出描述：输出一个整数，即最少需要多少次让两条碱基链配对成功 <br/>
 * 输入例子：<br/>
 * ACGT TGCA   <br/>
 * 输出例子： <br/>
 * 0 <br/>
 * <p>
 * 题目分析：
 * 解题思路：
 *
 * @author oukailiang
 * @create 2017-03-24 上午1:45
 */

public class DNACompose {

    private static int DNACompose(){
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = in.next();
        }
        System.out.println(DNACompose());
    }
}
