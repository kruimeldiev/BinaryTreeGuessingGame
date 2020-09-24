package com.casperdaris;

import java.util.Scanner;

public class BTController {

    private static Scanner inputScanner = new Scanner(System.in);

    public static Node boomMaken() {

        Node root, child;

        // Instellen van de root node
        root = new Node("Is rood een van de clubkleuren? ");

        // Instellen van de left child node
        child = new Node("Zit de club in de traditionele top 3? ");
        child.setLeft(new Node("PSV"));
        child.setRight(new Node("AZ"));
        root.setLeft(child);

        // Instellen van de right child node
        child = new Node("Komt je club uit het noorden van het land? ");
        child.setLeft(new Node("Groningen"));
        child.setRight(new Node("Vitesse"));
        root.setRight(child);

        return root;
    }

    public static void spelSpelen(Node node) {

        // Zolang de node geen leaf is, worden er vragen gesteld
        // Antwoord Y geeft de linker node terug, antwoord N geeft de rechter node terug
        while (!node.isLeaf()) {

            // antwoordGeven is een functie die een boolean teruggeeft
            // Bij true gaat de loop naar de linker childe node, bij false naar de rechtre child node
            // antwoordGeven heeft een vraag nodig, deze zit in de data van de node
            if (antwoordGeven(node.getData())) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        // Wanneer de while loop is afgelopen (wanneer een leaf is bereikt) gaat de machine raden welke club je in gedachten hebt
        // Als antwoordGeven true ("Y") is wint de machine, bij false ("N") wint de speler
        if(antwoordGeven("Is " + node.getData() + " je club? ")) {
            System.out.println("Ik win.");
        } else {
            System.out.println("Jij hebt gewonnen.");
        }

    }

    public static boolean antwoordGeven(String vraag) {

        // De vraag van de node uitprinten
        System.out.print(vraag);

        // String aanmaken door middel van de input van de gebruiker
        String antwoord = inputScanner.nextLine( ).toUpperCase( );

        // Wanneer de gebruiker niet met Y of N antwoord, foutmelding geven
        while (!antwoord.equals("Y") && !antwoord.equals("N")) {
            System.out.println("Antwoord uitsluitend met Y (ja) of N (nee).");
            System.out.print(vraag);
        }

        // Als antwoord Y is, dan true
        if (antwoord.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    // Functie om een gehele boom in Pre-Order volgorde uit te printen
    public static void printPreOrder(Node node) {

        // Base case aanmaken
        if (node == null) {
            return;
        }

        System.out.println(node.getData());
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

}
