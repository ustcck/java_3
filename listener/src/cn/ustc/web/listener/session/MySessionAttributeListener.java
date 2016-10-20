package cn.ustc.web.listener.session;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * HttpSessionAttributeListener
 * Created by ustcck on 2016/10/15.
 */
public class MySessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        // httpSessionBindingEvent.getSession(); 获取事件源，也就是获取session对象.
        //System.out.println(httpSessionBindingEvent.getName());
        //System.out.println(httpSessionBindingEvent.getValue());
        System.out.println("向session中添加属性");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("向session中删除属性");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("向session中替换属性");
    }
}
