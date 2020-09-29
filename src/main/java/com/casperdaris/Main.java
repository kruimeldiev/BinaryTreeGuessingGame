package com.casperdaris;

import com.casperdaris.controller.BTController;

public class Main {

    public static void main(String[] args) {

        BTController controller = new BTController();

        while (controller.spelen) {
            controller.spelSpelen(controller.beginBoomMaken());
        }
    }
}
