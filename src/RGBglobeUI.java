import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RGBglobeUI {
    private final static int SIZE_OF_BUTTON = 12;
    private final static int ROWS = 24;
    private final static int COLUMNS = 50;
    private final static int WIDTH_OF_WINDOW = COLUMNS * SIZE_OF_BUTTON + 150;
    private final static int HEIGHT_OF_WINDOW = SIZE_OF_BUTTON * ROWS + 30;
    private final static int NUMBER_OF_COLORS = 8;

    private JButton buttons[][];
    private JRadioButtonMenuItem colors[];
    private Color colorsOfButtons[] = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.WHITE, Color.BLACK};


    private RGBglobeUI() {
        JFrame frame = new JFrame();
        frame.setTitle("RGBglobe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH_OF_WINDOW, HEIGHT_OF_WINDOW);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        buttons = new JButton[ROWS][COLUMNS];
        for (int i = 0, y = 0; i < ROWS; i++, y += SIZE_OF_BUTTON) {
            for (int j = 0, x = 0; j < COLUMNS; j++, x += SIZE_OF_BUTTON) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.BLACK);
                buttons[i][j].setBounds(x, y, SIZE_OF_BUTTON, SIZE_OF_BUTTON);
                final int a = i, b = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        buttons[a][b].setBackground(getColor());
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

        colors = new JRadioButtonMenuItem[NUMBER_OF_COLORS];
        for (int i = 0, y = 0; i < NUMBER_OF_COLORS; i++, y += 15) {
            colors[i] = new JRadioButtonMenuItem();
            colors[i].setBounds(WIDTH_OF_WINDOW - 140, y, 15, 15);
            colors[i].setBackground(Color.WHITE);
            final int j = i;
            colors[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    for (JRadioButtonMenuItem c: colors) {
                        c.setSelected(false);
                    }
                    colors[j].setSelected(true);
                }
            });
            panel.add(colors[i]);
        }

        JLabel colorsLabel[] = new JLabel[NUMBER_OF_COLORS];
        for (int i = 0, y = 0; i < NUMBER_OF_COLORS; i++, y += 15) {
            colorsLabel[i] = new JLabel();
            colorsLabel[i].setBounds(WIDTH_OF_WINDOW - 115, y, 15, 15);
            colorsLabel[i].setOpaque(true);
            colorsLabel[i].setBackground(colorsOfButtons[i]);
            panel.add(colorsLabel[i]);
        }

        JButton save = new JButton("Save");
        save.setBackground(Color.WHITE);
        save.setBounds(WIDTH_OF_WINDOW - 125, HEIGHT_OF_WINDOW - 75, 100, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JColorChooser.showDialog(null , "Color", null);
            }
        });
        panel.add(save);

        JButton clear = new JButton("Clear all");
        clear.setBackground(Color.WHITE);
        clear.setBounds(WIDTH_OF_WINDOW - 125, HEIGHT_OF_WINDOW - 115, 100, 30);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                clearButtons();
            }
        });
        panel.add(clear);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private Color getColor() {
        for (int k = 0; k < NUMBER_OF_COLORS; k++) {
            if(colors[k].isSelected()) {
                return colorsOfButtons[k];
            }
        }
        return Color.BLACK;
    }

    private void clearButtons() {
        for (int i = 0, y = 0; i < ROWS; i++, y += SIZE_OF_BUTTON) {
            for (int j = 0, x = 0; j < COLUMNS; j++, x += SIZE_OF_BUTTON) {
                buttons[i][j].setBackground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        RGBglobeUI ui = new RGBglobeUI();
    }
}
