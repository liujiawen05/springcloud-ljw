import com.ljw.springcloud.entity.IpfCcmOriginPage;
import com.ljw.springcloud.entity.IpfCcmOriginPageLayout;
import com.ljw.springcloud.service.IpfCcmOriginPageLayoutService;
import com.ljw.springcloud.service.IpfCcmOriginPageService;
import com.ljw.springcloud.service.impl.IpfCcmOriginPageLayoutServiceImpl;
import com.ljw.springcloud.service.impl.IpfCcmOriginPageServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: Ljw
 * @Date: 2020/5/28.
 */
//JDK动态代理实现InvocationHandler接口
public class Test implements InvocationHandler {

    //目标对象
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始");
        Object result = method.invoke(target,args);
        System.out.println("动态代理，监听结束");
        return result;
    }

    //定义获取代理对象的方法
    private Object getJDKProxy(Object targetObject){
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        Test t = new Test();
        IpfCcmOriginPageLayoutService ipfCcmOriginPageService = (IpfCcmOriginPageLayoutService) t.getJDKProxy(new IpfCcmOriginPageLayoutServiceImpl());
        ipfCcmOriginPageService.selectByTest("1");

//        IpfCcmOriginPage ipfCcmOriginPage = (IpfCcmOriginPage) t.getJDKProxy(new IpfCcmOriginPage());
//        System.out.println("22222");
    }
}
