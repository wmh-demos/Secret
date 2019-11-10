package me.wayne.proxy.provider;


import me.wayne.proxy.Font;
import me.wayne.proxy.FontProvider;

public class FontProviderA implements FontProvider {
    @Override
    public Font getFont(String name) {
        System.out.println("FontProviderA get font " + name);
        return new Font(name);
    }
}
