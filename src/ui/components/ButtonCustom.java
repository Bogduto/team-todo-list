package ui.components;

import java.awt.*;

public class ButtonCustom implements Renderable {
    private Color backgroundColor;
//    private Color backgroundColorHover;
    private String text;
    private int textSize = 16;
//    private int textWeight = 400;
    private Color textColor;
    private final Rectangle bounds;


    public ButtonCustom(int x, int y, int width, int height, String text, Color backgroundColor, Color textColor) {
        this.bounds = new Rectangle(x, y, width, height);
        this.text = text;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;

    }

    @Override
    public void render(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(backgroundColor);
        g.fill(bounds);

        g.setColor(textColor);
        g.setFont(new Font("Segoe UI", Font.PLAIN, textSize));


        FontMetrics fm = g.getFontMetrics();
        int textX = bounds.x + (bounds.width - fm.stringWidth(text)) / 2;
        int textY = bounds.y + (bounds.height + fm.getAscent()) / 2 - 4;
        g.drawString(text, textX, textY);
    }
}
