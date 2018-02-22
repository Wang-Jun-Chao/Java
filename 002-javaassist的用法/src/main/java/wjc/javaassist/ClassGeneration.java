package wjc.javaassist;

import javassist.*;

import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * <pre>
 * 测试javaAssist对java字节码文件进行直接操作
 * </pre>
 * Author: 王俊超
 * Date: 2018-02-21 22:21
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ClassGeneration {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("wjc.javaassist.bean.Employee");

        try {
            CtField f1 = CtField.make("private int id;", cc);
            CtField f2 = CtField.make("private String name;", cc);
            CtField f3 = CtField.make("private int age;", cc);

            cc.addField(f1);
            cc.addField(f2);
            cc.addField(f3);

            CtMethod m1 = CtMethod.make("public int getId(){return id;}", cc);
            CtMethod m2 = CtMethod.make("public void setId(int id){$0.id=$1;}", cc);
            cc.addMethod(m1);
            cc.addMethod(m2);

            CtMethod m3 = CtMethod.make("public String getName(){return name;}", cc);
            CtMethod m4 = CtMethod.make("public void setName(String name){$0.name=$1;}", cc);
            cc.addMethod(m3);
            cc.addMethod(m4);


            // 无参构造构造函数
            CtConstructor constructor1 = new CtConstructor(new CtClass[]{}, cc);
            constructor1.setBody("{$0.id=1; $0.name=\"wjc\";}");
            cc.addConstructor(constructor1);


            // 有参构造函数
            CtConstructor constructor2 = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String"), CtClass.intType}, cc);
            constructor2.setBody("{$0.id=$1;$0.name=$2;$0.age=$3;}");
            cc.addConstructor(constructor2);



            // 取当前应用运行的根路径
            String path = ClassGeneration.class.getClassLoader().getResource("").getPath();
            path = path.contains(":") ? path.substring(1) : path;
            path = URLDecoder.decode(path, "utf-8");

            // 类生成到根路径下
            cc.writeFile(path);

            // 通过反射创建无参的实例，并调获取em方法
            //为了防止编译器报错，先用o声明，并一直使用
            Object o = Class.forName("wjc.javaassist.bean.Employee").newInstance();
            Method getter = o.getClass().getMethod("getName");
            System.out.println(getter.invoke(o));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
