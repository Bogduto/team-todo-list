package IO;

import userInterface.Assets.Fonts;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class FontInitializer
{
    public static Font load(String path)
    {
        try (InputStream stream = Objects.requireNonNull(Fonts.class.getResourceAsStream(path)))
        {
            return Font.createFont(Font.TRUETYPE_FONT, stream);
        }
        catch (IOException | FontFormatException exception)
        {
            throw new RuntimeException("Font set error" + path, exception);
        }
    }
}