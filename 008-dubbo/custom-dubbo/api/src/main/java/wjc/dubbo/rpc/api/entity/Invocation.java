package wjc.dubbo.rpc.api.entity;

import java.io.Serializable;

public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] objects;

    /**
     *
     * @param interfaceName 接口名字
     * @param methodName 方法名字
     * @param paramTypes 参数类型列表
     * @param objects 参数列表
     */
    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] objects) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.objects = objects;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }
}
