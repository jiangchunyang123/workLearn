package com.learn.thinkingInJava;

/**
 * @author jcy
 * @description:
 * @date 2018/12/6
 */
public class InnerClassFactory {
    public void consumeService(ServiceFactory serviceFactory){
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }
    public static void main(String[] args) {
        InnerClassFactory innerClassFactory = new InnerClassFactory();
        innerClassFactory.consumeService(ServceImpl1.serviceFactory);

    }
}

interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class ServceImpl1 implements Service {

    @Override
    public void method1() {
        System.out.println("this is impl 1 method 1");
    }

    @Override
    public void method2() {
        System.out.println("this is impl 1 method 2");
    }
    public static ServiceFactory serviceFactory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServceImpl1();
        }
    };
}