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
        createFiles();

        File.write(FILENAME_RED, "{");
        File.write(FILENAME_GREEN, "{");
        File.write(FILENAME_BLUE, "{");

        for (int i = 0, y = 0; i < RGBglobeUI.ROWS; i++, y += RGBglobeUI.SIZE_OF_BUTTON) {

            for (int j = 0, x = 0; j < RGBglobeUI.COLUMNS; j++, x += RGBglobeUI.SIZE_OF_BUTTON) {
                String tail = ",";
                if (i == RGBglobeUI.ROWS - 1 && j == RGBglobeUI.COLUMNS - 1) tail = "";

                if (btns[i][j].getBackground() == Color.RED) {
                    File.update(FILENAME_RED, "1" + tail);
                    File.update(FILENAME_GREEN, "0" + tail);
                    File.update(FILENAME_BLUE, "0" + tail);
                }
                if (btns[i][j].getBackground() == Color.GREEN) {
                    File.update(FILENAME_RED, "0" + tail);
                    File.update(FILENAME_GREEN, "1" + tail);
                    File.update(FILENAME_BLUE, "0" + tail);
                }
                if (btns[i][j].getBackground() == Color.BLUE) {
                    File.update(FILENAME_RED, "0" + tail);
                    File.update(FILENAME_GREEN, "0" + tail);
                    File.update(FILENAME_BLUE, "1" + tail);
                }
                if (btns[i][j].getBackground() == Color.CYAN) {
                    File.update(FILENAME_RED, "0" + tail);
                    File.update(FILENAME_GREEN, "1" + tail);
                    File.update(FILENAME_BLUE, "1" + tail);
                }
                if (btns[i][j].getBackground() == Color.YELLOW) {
                    File.update(FILENAME_RED, "1" + tail);
                    File.update(FILENAME_GREEN, "1" + tail);
                    File.update(FILENAME_BLUE, "0" + tail);
                }
                if (btns[i][j].getBackground() == Color.MAGENTA) {
                    File.update(FILENAME_RED, "1" + tail);
                    File.update(FILENAME_GREEN, "0" + tail);
                    File.update(FILENAME_BLUE, "1" + tail);
                }
                if (btns[i][j].getBackground() == Color.WHITE) {
                    File.update(FILENAME_RED, "1" + tail);
                    File.update(FILENAME_GREEN, "1" + tail);
                    File.update(FILENAME_BLUE, "1" + tail);
                }
                if (btns[i][j].getBackground() == Color.BLACK) {
                    File.update(FILENAME_RED, "0" + tail);
                    File.update(FILENAME_GREEN, "0" + tail);
                    File.update(FILENAME_BLUE, "0" + tail);
                }
            }
        }
        File.update(FILENAME_RED, "}");
        File.update(FILENAME_GREEN, "}");
        File.update(FILENAME_BLUE, "}");
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
