import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class FileManager {
    private static String FILENAME_RED = "./" + getTimeAndDate() + "_r.txt";
    private static String FILENAME_GREEN = "./" + getTimeAndDate() + "_g.txt";
    private static String FILENAME_BLUE = "./" + getTimeAndDate() + "_b.txt";


    public static void saveFiles(JButton btns[][]) throws IOException {
        String red = "{";
        String green = "{";
        String blue = "{";

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
        createFiles();
        File.write(FILENAME_RED, red);
        File.write(FILENAME_GREEN, green);
        File.write(FILENAME_BLUE, blue);
    }

    private static void createFiles() {
        File.create(FILENAME_RED);
        File.create(FILENAME_GREEN);
        File.create(FILENAME_BLUE);
    }

    private static String getTimeAndDate() {
        long curTime = System.currentTimeMillis();
        return new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(curTime);
    }
}
