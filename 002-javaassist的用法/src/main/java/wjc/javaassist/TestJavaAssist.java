package wjc.javaassist;

import javassist.*;

import java.net.URLDecoder;
import java.util.Base64;

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
public class TestJavaAssist {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("wjc.javaassist.bean.Employee");

        try {
            CtField f1 = CtField.make("private Integer empId;", cc);
            CtField f2 = CtField.make("private String empName;", cc);
            CtField f3 = CtField.make("private Integer empAge;", cc);

            cc.addField(f1);
            cc.addField(f2);
            cc.addField(f3);

            CtMethod m1 = CtMethod.make("public Integer getEmpId(){return empId;}", cc);
            CtMethod m2 = CtMethod.make("public void setEmpId(Integer empId){this.empId=empId;}", cc);

            cc.addMethod(m1);
            cc.addMethod(m2);

            CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, cc);
            constructor.setBody("{this.empId=empId;this.empName=empName;this.empAge=empAge;}");
            cc.addConstructor(constructor);

            // 取当前应用运行的根路径
            String path = TestJavaAssist.class.getClassLoader().getResource("").getPath();
            path = path.contains(":") ? path.substring(1) : path;
            System.out.println(path);
            path = URLDecoder.decode(path, "utf-8");

            // 类生成到根路径下
            cc.writeFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
