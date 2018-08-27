﻿/*
 * 1. 解法存在致命缺陷
 *  设置字符数组存储输入的字符串，最长长度是猜的；
 * 	题目要求，如果是非法输入，要输出该非法输入，不得不构造字符数组
 * 2. 解题关键：
 *  利用了 int sscanf( string str, string fmt, mixed var1, mixed var2 ... );
 *  和 int sprintf(char *str, char * format [, argument, ...]); , 与原输入进行比较。
 * 3. 只有当合法输入的个数为1时，输出内容 The average of 1 number is Y 中，
 *    number才为单数，个数为0还是numbers
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	int N, K = 0;	//输入的数量，合法输入的个数
	double sum = 0.0, t;	// 合法输入实数的和，临时存储的实数 
	char num[9], str[50];	// 设置输入字符串的最长长度是猜的！！！ 致命缺陷（测试用例的字符串最长40） 
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", str);	//读取字符串 
		int len = strlen(str);	//获取字符串长度
		int islegal = 1;	//判断是否合法 
		if (len <= 8) {	// 符合要求的实数长度最多为8 -1000.00
			sscanf(str, "%lf", &t);		//将字符串转为浮点数类型 
			sprintf(num, "%.2f", t);	//将浮点数精确到小数点后两位 转为字符串;
			for (int j = 0; j < len; j++) {
				if (num[j] != str[j]) {	//如果处理前后的字符串不一致，就是非法输入 
					islegal = 0;
					break;
				}
			}
		} else {//长度超过8，必非法 
			islegal = 0;
		}
		if (!islegal || t > 1000 || t < -1000) {//如果是非法输入
			printf("ERROR: %s is not a legal number\n", str);
		} else {
			sum += t;
			K++;
		}
	}
	if (K == 0) { //平均值无法计算 即 分母为0 
		printf("The average of 0 numbers is Undefined\n");
	} else if (K == 1) { 
		printf("The average of 1 number is %.2f\n", sum);
	} else { 
		printf("The average of %d numbers is %.2f\n", K, sum / K);
	} 
	return 0;
}