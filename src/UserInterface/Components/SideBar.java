    package UserInterface.Components;

    import UserInterface.Renderable;
    import UserInterface.WindowConfig;

    import java.awt.*;

    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example
    //Тут зразу все меню просто як example

    /**
     * Компонент SideBar відповідає за відображення бічного меню.
     * Це меню є умовним прикладом (example) і може містити кнопки, які викликають певні дії.
     *
     * Всі візуальні елементи повинні реалізовувати інтерфейс Renderable
     * і мати свою логіку малювання всередині методу public void render(Graphics2D graphics2D).
     *
     * Примітка щодо порядку малювання:
     * - Об'єкти, які рендеряться ПІЗНІШЕ, відображаються ПОВЕРХ попередніх.
     * - Тобто, якщо елемент A рендериться перед елементом B, а вони мають однакову позицію —
     *   B перекриє A.
     */

    public class SideBar implements Renderable
    {
        private Dimension size = new Dimension(100, (int) WindowConfig.SIZE.getWidth());

        private CustomButton someButton1 = new CustomButton(10, 10, 80, 40, "Sort");
        private CustomButton someButton2 = new CustomButton(10, 60, 80, 40, "Tags");
        private CustomButton someButton3 = new CustomButton(10, 550, 80, 40, "Add task");


        @Override
        public void render(Graphics2D graphics2D)
        {
            graphics2D.setColor(new Color(136, 207, 200));
            graphics2D.fillRect(0, 0, (int) size.getWidth(), (int) WindowConfig.SIZE.getHeight());
            graphics2D.setColor(new Color(163, 247, 239));
            graphics2D.fillRect(100, 0, (int)  WindowConfig.SIZE.getWidth() - 100, (int) WindowConfig.SIZE.getHeight());

            someButton1.render(graphics2D);
            someButton2.render(graphics2D);
            someButton3.render(graphics2D);
        }
    }


    /**
     * Клас CustomButton — це приклад кастомної кнопки, яку ми малюємо вручну.
     * В майбутньому її можна розширити, щоб підтримувати обробку кліків.
     */


    class CustomButton implements Renderable {
        private final Rectangle bounds;
        private String text;
    //    private ClickListener clickListener;
        private boolean isHovered = false;

        public CustomButton(int x, int y, int width, int height, String text) {
            this.bounds = new Rectangle(x, y, width, height);
            this.text = text;
        }

        // В майбутньому ти можеш активувати ці методи для обробки кліків:
        // - setClickListener(...): дозволить задати дію при натисканні
        // - handleMousePressed(...): перевіряє, чи був клік по кнопці
        // - handleMouseMoved(...): відслідковує наведення на кнопку (hover)

    //    public void setClickListener(ClickListener listener) {
    //        this.clickListener = listener;
    //    }
    //
    //    public void handleMousePressed(MouseEvent e) {
    //        if (bounds.contains(e.getPoint()) && clickListener != null) {
    //            clickListener.onClick();
    //        }
    //    }
    //
    //    public void handleMouseMoved(MouseEvent e) {
    //        isHovered = bounds.contains(e.getPoint());
    //    }

        @Override
        public void render(Graphics2D g) {
            g.setColor(isHovered ? Color.LIGHT_GRAY : new Color(155, 224, 218));
            g.fill(bounds);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 16));

            //Оця хуня дела текст по центру бо драв стрінг дуже странно робота і в джаві є костиль так шо лучше чекни гайдік на
            //ютубі шоб буть про челіком

            // Малювання тексту по центру — трішки складніше, ніж здається:
            // потрібно враховувати ширину тексту і висоту шрифта

            //аххаххаха це чат гпт написав (коментар на строчкі 101-102) суть в тому що центр намальованої строки не
            //центр а лівий верхній угол
            // https://imgur.com/9zHMOUP
            // https://imgur.com/9zHMOUP
            // https://imgur.com/9zHMOUP
            // https://imgur.com/9zHMOUP
            // https://imgur.com/9zHMOUP Чекни
            FontMetrics fm = g.getFontMetrics();
            int textX = bounds.x + (bounds.width - fm.stringWidth(text)) / 2;
            int textY = bounds.y + (bounds.height + fm.getAscent()) / 2 - 4;
            //-------------------
            g.drawString(text, textX, textY);
        }
    }