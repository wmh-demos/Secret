package me.wayne.proxy.staticproxy;


import me.wayne.proxy.Font;
import me.wayne.proxy.FontProvider;

import java.util.Map;

public class CachedFontProvider implements FontProvider {

    private FontProvider fontProvider;
    private Map<String, Font> cached;

    public CachedFontProvider(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    public Font getFont(String name) {
        Font font = cached.get(name);
        if (font == null) {
            font = fontProvider.getFont(name);
            cached.put(name, font);
        }
        return font;
    }
}
