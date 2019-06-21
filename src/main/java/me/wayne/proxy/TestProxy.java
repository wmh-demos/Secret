package wayne.proxy;

import wayne.proxy.dynamicproxy.DynamicProxyFactory;
import wayne.proxy.staticproxy.StaticProxyFactory;

public class TestProxy {

    public static void main() {
        FontProvider fontProvider = StaticProxyFactory.getFontProvider();
        fontProvider.getFont("Sour Code Pro");

        fontProvider = DynamicProxyFactory.getFontProvider();
        fontProvider.getFont("Sour Code Pro");
    }
}
