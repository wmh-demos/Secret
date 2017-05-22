package me.wayne.proxy.staticproxy;

import me.wayne.proxy.FontProvider;
import me.wayne.proxy.provider.FontProviderA;

public class StaticProxyFactory {

    public static FontProvider getFontProvider() {
        return new FontProviderA();
    }

    //考虑以下各种情况，有多个提供类，每个类都有getXxx(String name)方法，
    // 使用静态代理虽然也能实现，但是也是略显繁琐，需要手动一一创建代理类。
//    public static ImageProvider getImageProvider() {...}
//    public static MusicProvider getMusicProvider() {...}
}
