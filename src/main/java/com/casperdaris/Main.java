package com.casperdaris;

import com.casperdaris.controller.BTController;
import com.casperdaris.netwerk.DatabaseHelper;

public class Main {

    public static void OfflineSpelen() {

        BTController controller = new BTController();

        while (controller.spelen) {
            controller.spelSpelen(controller.beginBoomMaken());
        }

    }

    public static void main(String[] args) {

        DatabaseHelper.ConnectieMaken();

        DatabaseHelper.NodeLaden();
    }
}
