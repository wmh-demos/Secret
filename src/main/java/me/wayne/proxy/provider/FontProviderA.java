package wayne.proxy.provider;

import wayne.proxy.Font;
import wayne.proxy.FontProvider;

public class FontProviderA implements FontProvider {
    @Override
    public Font getFont(String name) {
        System.out.println("FontProviderA get font " + name);
        return new Font(name);
    }
}
