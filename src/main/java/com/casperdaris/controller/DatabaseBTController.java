package com.casperdaris.controller;

import com.casperdaris.model.BinaryTree;
import com.casperdaris.netwerk.DatabaseHelper;

import java.util.Scanner;

public class DatabaseBTController {

    public static Scanner inputScanner = new Scanner(System.in);

    public static void SpelSpelen(BinaryTree boom) {

        UitlegGeven();

        if (AntwoordGeven("Ben je er klaar voor?")) {
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("Jammer dan, we beginnen toch. \n--------------------------------------------");
        }

        while(!boom.getHuidigeNode().isSqlLeaf()) {
            if (AntwoordGeven(boom.getHuidigeNode().getData())) {
                boom.setHuidigeNode(DatabaseHelper.NodeLaden(boom.getHuidigeNode().getLeft_id()));
            } else {
                boom.setHuidigeNode(DatabaseHelper.NodeLaden(boom.getHuidigeNode().getRight_id()));
            }
        }

        if (AntwoordGeven(boom.getHuidigeNode().getData())) {
            System.out.println("Ik win.");
        } else {
            System.out.println("Jij hebt gewonnen.");
        }

    }

    public static void UitlegGeven() {
        System.out.println("--------------------------------------------");
        System.out.println("Neem een voetbalclub in gedachte. \nIk ga raden welke club het is. ");
        System.out.println("Als ik het goed heb, dan heb ik gewonnen. \nAls jij wint, moet je mij deze nieuwe club leren kennen.");
        System.out.println("Beantwoord mijn vragen alleen met 'Y' (ja) of 'N' (nee).");
    }

    public static boolean AntwoordGeven(String vraag) {
        System.out.println(vraag);
        String antwoord = inputScanner.nextLine().toUpperCase();
        while (!antwoord.equals("Y") && !antwoord.equals("N")) {
            System.out.print("Antwoord uitsluitend met Y (ja) of N (nee).");
            System.out.print(vraag);
        }
        if (antwoord.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
