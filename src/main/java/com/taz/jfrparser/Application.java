package com.taz.jfrparser;

import com.taz.jfrparser.core.JFRReader;
import java.io.IOException;

public class Application {

    private static JFRReader jfrReader;
    final static String FILE_PATH = "/home/mani/Documents/Semester-VII/FYP/JFR/old_big.jfr";

    public static void main(String[] args) throws IOException {

        jfrReader = JFRReader.getInstance();

    }
}
