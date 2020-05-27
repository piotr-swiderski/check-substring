package com.swiderski.app;

import com.swiderski.app.utils.KMPSubstringUtil;
import com.swiderski.app.utils.SubstringUtil;

public class App {

    public static void main(String[] args) {

        SubstringUtil stringUtil = new KMPSubstringUtil();
        ConsoleGui consoleGui = new ConsoleGui(stringUtil);
        consoleGui.run();

    }

}
