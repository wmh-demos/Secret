package me.wayne.proxy.staticproxy;

import me.wayne.proxy.FontProvider;
import me.wayne.proxy.provider.FontProviderA;

public class StaticProxyFactory {

    public static FontProvider getFontProvider() {
        return new FontProviderA();
    }

    /**
     * 当然，我们直接修改FontProviderFromDisk类也可以实现目的，
     * 但是我们还有FontProviderFromNet, FontProviderFromSystem等多种实现类，
     * 一一修改太过繁琐且易出错。况且将来还可能添加日志，权限检查，
     * 异常处理等功能显然用代理类更好一点。
     */
    public static FontProvider getCachedFontProvider() {
        return new CachedFontProvider(new FontProviderA());
    }
}
