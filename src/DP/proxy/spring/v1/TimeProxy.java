package DP.proxy.spring.v1;

//@Aspect
public class TimeProxy {
//    @Before
    public void before(){
        System.out.println("method start"+System.currentTimeMillis());
    }
//    @After
    public void after(){
        System.out.println("method end"+System.currentTimeMillis());
    }
}
