package wjc;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2018-02-06 21:54
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class Demo {

    public static void main(String[] args) {
        case01();

        case02();
    }

    /**
     * str1.intern()发现常量池中不存在“ABCCBA”，因此指向了str1。
     * "ABCCBA"在常量池中创建时，也就直接指向了str1了。两个都返回true就理所当然啦。
     */
    public static void case01() {
        String str1 = new String("ABC") + new String("CBA");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "ABCCBA");
    }

    /**
     * str2先在常量池中创建了“CBAABC”，那么str1.intern()当然就直接指向了str2，
     * 你可以去验证它们两个是返回的true。
     * 后面的"CBAABC"也一样指向str2。所以谁都不搭理在堆空间中的str1了，所以都返回了false。
     */
    public static void case02() {
        String str2 = "CBAABC";
        String str1 = new String("CBA") + new String("ABC");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "CBAABC");
        System.out.println(str1.intern() == str2);
        System.out.println(str2 == "CBAABC");
        System.out.println(str1 == str2);
    }
}
