package userInterface.Components;

import userInterface.Core.Renderable;

import java.awt.*;

public class Text implements Renderable
{
    private String textContent;
    private final Point textPosition;
    private final Color textColor;
    private final Font textFont;
    private final Dimension textArea;

    public Text(String textContent, Point textPosition, Color textColor, Font textFont, float fontSize, Dimension textArea)
    {
        this.textContent = textContent;
        this.textPosition = textPosition;
        this.textColor = textColor;
        this.textFont = textFont.deriveFont(fontSize);;

        this.textArea = textArea;
    }

    public Text(String textContent, Point textPosition, Color textColor, Font textFont, float fontSize)
    {
        this(textContent, textPosition, textColor, textFont, fontSize,null);
    }

    @Override
    public void render(Graphics2D graphicsContext)
    {
        graphicsContext.setColor(textColor);
        graphicsContext.setFont(textFont);

        if (textArea == null)
        {
            graphicsContext.drawString(textContent, textPosition.x, textPosition.y);
            return;
        }

        FontMetrics fontMetrics = graphicsContext.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(textContent);
        int textHeight = fontMetrics.getHeight();
        int textAscent = fontMetrics.getAscent();

        int textPositionX = textPosition.x + (textArea.width - textWidth) / 2;
        int textPositionY = textPosition.y + (textArea.height - textHeight) / 2 + textAscent;

        graphicsContext.drawString(textContent, textPositionX, textPositionY);
    }

    public String getTextContent()
    {
        return textContent;
    }

    public void setTextContent(String textContent)
    {
        this.textContent = textContent;
    }

    public Point getTextPosition()
    {
        return textPosition;
    }

    public Color getTextColor()
    {
        return textColor;
    }

    public Font getTextFont()
    {
        return textFont;
    }

    public Dimension getTextArea()
    {
        return textArea;
    }
}
