package cn.perf4j.test;

import cn.perf4j.aop.ProfilerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by LinShunkang on 2018/3/11
 */
public class ProfilerTest{

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("*.xml");
        ProfilerApi profilerApi = ctx.getBean("profilerApi", ProfilerApi.class);
//        ProfilerApi profilerApi = new ProfilerApiImpl();
        System.out.println(profilerApi.getClass());

        int times = 1000000000;
        for (int i = 0; i < times; ++i) {
            profilerApi.test1("1111");
        }
        System.out.println();

//        for (int i = 0; i < times; ++i) {
//            profilerApi.test1("1111", "222");
//        }
//
//        System.out.println();
//        for (int i = 0; i < times; ++i) {
//            profilerApi.test2();
//        }

        ProfilerContainer profilerContainer = ctx.getBean("profilerContainer", ProfilerContainer.class);
        System.out.println(profilerContainer.getRecorderMap());

    }

}
