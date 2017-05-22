package me.wayne.proxy;

import me.wayne.proxy.dynamicproxy.DynamicProxyFactory;
import me.wayne.proxy.staticproxy.StaticProxyFactory;

public class TestProxy {

    public static void main() {
        FontProvider fontProvider = StaticProxyFactory.getFontProvider();
        fontProvider.getFont("Sour Code Pro");

        fontProvider = DynamicProxyFactory.getFontProvider();
        fontProvider.getFont("Sour Code Pro");
    }
}
