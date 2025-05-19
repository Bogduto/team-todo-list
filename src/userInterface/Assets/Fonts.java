package userInterface.Assets;

import IO.FontInitializer;

import java.awt.*;

public class Fonts
{
    public static final Font SF_PRO_TEXT_LIGHT;
    public static final Font SF_PRO_TEXT_MEDIUM;
    public static final Font SF_PRO_TEXT_REGULAR;

    static
    {
        SF_PRO_TEXT_LIGHT = FontInitializer.load("/fonts/SFProText-Light.ttf");
        SF_PRO_TEXT_MEDIUM = FontInitializer.load("/fonts/SFProText-Medium.ttf");
        SF_PRO_TEXT_REGULAR = FontInitializer.load("/fonts/SFProText-Regular.ttf");
    }
}