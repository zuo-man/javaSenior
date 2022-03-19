package com.java;

import org.junit.Test;

/**
 * @create 2021-10-10 16:48
 */
public class StringMethodTest {
    /*
    int Length()：返回字符串的长度： return value.length
    char charAt(int index)： 返回某索引处的字符return value[index]
    boolean isEmpty（）：判断是否是空字符串：return value.length == 0
    String toLowerCase()：使用默认语言环境，将String 中的所有字符转换为小写
    String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
    String trim()：返回字符串的副本，忽略前导空白 和尾部空白

    boolean equals(Object obj)：比较字符串的内容是否相同
    boolean equalsIgnoreCase(String anotherstring)：与equals方法类似，忽略大小写
    String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
    int compareTo(String anotherString)：比较两个字符串的大小
    String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取
    String substring(intbeginIndex，int endIndex)：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex（不包含）的一个子字符串
    boolean endsWith(Sting suffix):测试此此付出是否以指定的后缀结束
    boolean starsWith(String perfix):测试此字符串是否以指定的前缀开始
    boolean starsWith(String perfix, int toffset):测试此字符串从指定索引开始的子字符串是否指定前缀开始

    boolean contains(CharSequence s)：当且仅当此字符串包含指定的char值序列时，返回 true
    int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    int indexOf(String str,int fromlndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
    int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
    int lastlndexOf(String str, int fromlndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
                                                indexOf和lastlndexOf方法如果未找到都是返回-1

    替换：
    String replace(char oldChar,char newChar)：返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的。
    String replace(CharSequence target,CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
    String replaceAll(String regex,String replacement):使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串。
    String replaceFirst(String regex, String replacement):使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串。
    匹配：
    boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
    切片：
    String nsprit(String regex)：根据给定正则表达式的匹配拆分此字符串。
    String isplit(String regex,int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */

    @Test
    public void test1(){
        String s1 = "HelloW";
        System.out.println(s1.length());/*返回字符串的长度*/
        System.out.println(s1.charAt(2));/*返回某索引处的字符*/

        System.out.println(s1.isEmpty());/*判断是否是空字符串*/

        String s2 = s1.toLowerCase();/*所有字符转换为小写*/
        System.out.println(s1);//s1不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串

        String s3 = "   he llo   ";
        String s4 = s3.trim();/*返回字符串的副本，忽略前导空白和尾部空白*/
        System.out.println("---" + s3 + "---");
        System.out.println("---" + s4 + "---");
    }
    @Test
    public void test2(){
        String s1 = "HELLO";
        String s2 = "hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));/*比较字符串的内容是否相同，忽略大小写*/

        String s3 = "aa";
        String s4 = new String("ab");
        System.out.println(s3.compareTo(s4));/*比较两个字符串的大小,结果用ASCII表示，涉及到字符串排序*/

        String s5 = "ABCD";
        String s6 = s5.substring(2);/*返回一个新的字符串，它是此字符串的从beginIndex开始截取*/
        System.out.println(s5);
        System.out.println(s6);

        String s7 = s5.substring(2,3);
        System.out.println(s7);/*此字符串从beginIndex开始截取到endIndex（不包含）的一个子字符串*/
                               //左闭右开
    }
    @Test
    public void test3(){
        String str1 = "hello";
        boolean b1 = str1.endsWith("lo");/*测试此此付出是否以指定的后缀结束*/
        System.out.println(b1);

        boolean b2 = str1.startsWith("ll",2);/*测试此字符串从指定索引开始的子字符串是否指定前缀开始*/
        System.out.println(b2);

        String str2 = "el";
        System.out.println(str1.contains(str2));/*当且仅当此字符串包含指定的char值序列时，返回 true*/

        System.out.println(str1.indexOf("el"));/*返回指定子字符串在此字符串中第一次出现处的索引*/
                                               //未找到则返回-1
        System.out.println(str1.indexOf("lo",3));/*返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始*/
                                                              //未找到则返回-1
    }
    @Test
    public void test4(){
        String str1 = "ABCDDD";
        String str2 = str1.replace('D','I');/*返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的*/

        System.out.println(str1);
        System.out.println(str2);

        String str = "234A234B234C";                                //把字符串中的数组替换成,，如果结果中和结尾有逗号，就去掉
        String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(string);/*使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串*/

        System.out.println("**********");

        String q = "123";           //匹配是否全是数字
        boolean matches = q.matches("\\d+");/*告知此字符串是否匹配给定的正则表达式*/
        System.out.println(matches);

        String q2 = "000-123";      //匹配000后面的是否是3位 或者 4位字符，如果是12345，则是false
        boolean result = q2.matches("000-\\d{3,4}");
        System.out.println(result);

        String x = "AAA,BBB,CCC";
        String[] xx = x.split("\\,");/*根据给定正则表达式的匹配拆分此字符串*/
        for(int i = 0; i < xx.length; i++){     //以逗号为切割线，for循环遍历出来
            System.out.println(xx[i]);
        }
    }
}
