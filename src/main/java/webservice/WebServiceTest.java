package webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

/**
 * webservice客户端
 * 
 * 
 * @author：WangYuanJun
 * @date：2017年12月19日 下午9:39:49
 */
public class WebServiceTest {

    @Test
    public void testSend1(){
        
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/TestService?wsdl");
        
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
        Object[] objects = new Object[0];
        try {
            
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sendMessage", "wyj");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
