import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;


class FileManager {
    private String FILENAME_RED;
    private String FILENAME_GREEN;
    private String FILENAME_BLUE;

    private String red;
    private String green;
    private String blue;

    FileManager() {
        red = "{";
        green = "{";
        blue = "{";

        FILENAME_RED = getFileName("r");
        FILENAME_GREEN = getFileName("g");
        FILENAME_BLUE = getFileName("b");

        createFiles();
    }

    void saveFiles(JButton btns[][]) throws IOException {
        for (int i = 0, y = 0; i < RGBglobeUI.ROWS; i++, y += RGBglobeUI.SIZE_OF_BUTTON) {
            for (int j = 0, x = 0; j < RGBglobeUI.COLUMNS; j++, x += RGBglobeUI.SIZE_OF_BUTTON) {
                String tail = ",";
                if (i == RGBglobeUI.ROWS - 1 && j == RGBglobeUI.COLUMNS - 1) tail = "";

                if (btns[i][j].getBackground() == Color.RED) {
                    red = red.concat("1" + tail);
                    green = green.concat("0" + tail);
                    blue = blue.concat("0" + tail);
                }
                if (btns[i][j].getBackground() == Color.GREEN) {
                    red = red.concat("0" + tail);
                    green = green.concat("1" + tail);
                    blue = blue.concat("0" + tail);
                }
                if (btns[i][j].getBackground() == Color.BLUE) {
                    red = red.concat("0" + tail);
                    green = green.concat("0" + tail);
                    blue = blue.concat("1" + tail);
                }
                if (btns[i][j].getBackground() == Color.CYAN) {
                    red = red.concat("0" + tail);
                    green = green.concat("1" + tail);
                    blue = blue.concat("1" + tail);
                }
                if (btns[i][j].getBackground() == Color.YELLOW) {
                    red = red.concat("1" + tail);
                    green = green.concat("1" + tail);
                    blue = blue.concat("0" + tail);
                }
                if (btns[i][j].getBackground() == Color.MAGENTA) {
                    red = red.concat("1" + tail);
                    green = green.concat("0" + tail);
                    blue = blue.concat("1" + tail);
                }
                if (btns[i][j].getBackground() == Color.WHITE) {
                    red = red.concat("1" + tail);
                    green = green.concat("1" + tail);
                    blue = blue.concat("1" + tail);
                }
                if (btns[i][j].getBackground() == Color.BLACK) {
                    red = red.concat("0" + tail);
                    green = green.concat("0" + tail);
                    blue = blue.concat("0" + tail);
                }
            }
        }
        red = red.concat("}");
        green = green.concat("}");
        blue = blue.concat("}");
        File.write(FILENAME_RED, red);
        File.write(FILENAME_GREEN, green);
        File.write(FILENAME_BLUE, blue);
    }

    private void createFiles() {
        File.create(FILENAME_RED);
        File.create(FILENAME_GREEN);
        File.create(FILENAME_BLUE);
    }

    private String getFileName(String color) {
        return "./" + getTimeAndDate() + "_" + color + ".txt";
    }

    private static String getTimeAndDate() {
        long curTime = System.currentTimeMillis();
        return new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(curTime);
    }
}
