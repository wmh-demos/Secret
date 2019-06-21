package wayne.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

import wayne.proxy.FontProvider;
import wayne.proxy.provider.FontProviderA;

public class DynamicProxyFactory {

    /**
     * 考虑以下各种情况，有多个提供类，每个类都有getXxx(String name)方法，
     * 每个类都要加入缓存功能，使用静态代理虽然也能实现，但需要手动一一创建代理类。
     * public static FontProvider getFontProvider() {...}
     * public static ImageProvider getImageProvider() {...}
     * public static MusicProvider getMusicProvider() {...}
     */

    public static FontProvider getFontProvider() {
        Class<FontProvider> targetClass = FontProvider.class;
        return (FontProvider) Proxy.newProxyInstance(
                targetClass.getClassLoader(),
                new Class[]{targetClass},
                new ProviderHandler(new FontProviderA()));
    }
}
