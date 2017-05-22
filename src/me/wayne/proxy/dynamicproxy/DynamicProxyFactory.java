package me.wayne.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

import me.wayne.proxy.FontProvider;
import me.wayne.proxy.provider.FontProviderA;

public class DynamicProxyFactory {

    public static FontProvider getFontProvider() {
        Class<FontProvider> targetClass = FontProvider.class;
        return (FontProvider) Proxy.newProxyInstance(
                targetClass.getClassLoader(),
                new Class[]{targetClass},
                new ProviderHandler(new FontProviderA()));
    }
}
