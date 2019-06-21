package wayne.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ProviderHandler implements InvocationHandler {

    private Map<String, Object> mCachedMap = new HashMap<String, Object>();
    private Object mTarget;

    public ProviderHandler(Object target) {
        mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Type[] types = method.getParameterTypes();
        if (method.getName().matches("get.+") && (types.length == 1) &&
                (types[0] == String.class)) {
            String key = (String) args[0];
            Object value = mCachedMap.get(key);
            if (value == null) {
                value = method.invoke(mTarget, args);
                mCachedMap.put(key, value);
            }
            return value;
        }
        return method.invoke(mTarget, args);
    }
}
