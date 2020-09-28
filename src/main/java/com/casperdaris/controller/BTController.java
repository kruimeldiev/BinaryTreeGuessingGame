package com.casperdaris.controller;

import com.casperdaris.model.BinaryTree;
import com.casperdaris.model.Node;

import java.util.Scanner;

public class BTController {

    private static Scanner inputScanner = new Scanner(System.in);

    public static boolean spelen = true;

    public static BinaryTree beginBoomMaken() {

        BinaryTree boom = new BinaryTree();
        Node child;

        // Instellen van de root node
        boom.setRoot(new Node("Is rood een van de clubkleuren? "));

        // Instellen van de left child node
        child = new Node("Zit de club in de traditionele top 3? ");
        child.setLeft(new Node("PSV"));
        child.setRight(new Node("AZ"));
        boom.getRoot().setLeft(child);

        // Instellen van de right child node
        child = new Node("Komt je club uit het noorden van het land? ");
        child.setLeft(new Node("Groningen"));
        child.setRight(new Node("Vitesse"));
        boom.getRoot().setRight(child);

        return boom;
    }

    public static void spelSpelen(BinaryTree boom) {

        // Huidige Node instellen voor de boom
        boom.setHuidigeNode(boom.getRoot());

        // Zolang de huidige node geen leaf is, wordt er een vraag gesteld
        // Antwoord Y geeft de linker node terug, antwoord N geeft de rechter node terug
        while (!boom.getHuidigeNode().isLeaf()) {

            // antwoordGeven is een functie die een boolean teruggeeft
            // Bij true gaat de loop naar de linker child node, bij false naar de rechter child node
            // antwoordGeven heeft een vraag nodig, deze zit in de data van de node
            if (antwoordGeven(boom.getHuidigeNode().getData())) {
                boom.setHuidigeNode(boom.getHuidigeNode().getLeft());
            } else {
                boom.setHuidigeNode(boom.getHuidigeNode().getRight());
            }
        }

        // Wanneer de while loop is afgelopen (wanneer een leaf is bereikt) gaat de machine raden welke club je in gedachten hebt
        // Als antwoordGeven true ("Y") is wint de machine, bij false ("N") wint de speler
        if(antwoordGeven("Is " + boom.getHuidigeNode().getData() + " je club? ")) {
            System.out.println("Ik win.");
        } else {
            System.out.println("Jij hebt gewonnen.");

            // Wanneer je van de computer hebt gewonnen, dan moet je de computer een nieuwe vraag en antwoord aanleren
            // De node/leaf met het verkeerde antwordt wordt in de nieuweClubLeren functie vervangen door een nieuwe vraag/node
            boom.setHuidigeNode(nieuweClubLeren(boom.getHuidigeNode()));
        }

        // Vragen om het spel nogmaals te spelen
        System.out.print("Nogmaals spelen? ");

        String doorspelen = inputScanner.nextLine();

        // Bij Y als antwoord opnieuw beginnen, anders spel afsluiten
        if (doorspelen.equals("Y")) {
            boom.setHuidigeNode(boom.getRoot());
            spelSpelen(boom);
        } else {
            spelen = false;
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

    public static Node nieuweClubLeren(Node node) {

        // Dit is de club die de machine verkeerd heeft geraden
        String verkeerdeClub = node.getData();

        System.out.println("Welke club had je in gedachten?");

        // Input van de gebruiker om een nieuwe club toe te voegen
        String juisteClub = inputScanner.nextLine();

        System.out.println("Typ een ja/nee vraag die " + juisteClub + " van " + verkeerdeClub + " onderscheid.");

        // Input van de gebruiker om een nieuwe vraag toe te voegen
        String nieuweVraag = inputScanner.nextLine();

        // De huidige node in de boom vervangen door de nieuwe vraag
        node.setData(nieuweVraag + " ");

        // Nieuwe nodes/leafs aan de vraag/boom toevoegen
        if (antwoordGeven("Het antwoord op '" + nieuweVraag + "', voor '" + juisteClub + "', is dus 'Ja'? ")) {
            node.setLeft(new Node(juisteClub));
            node.setRight(new Node(verkeerdeClub));
        } else {
            node.setLeft(new Node(verkeerdeClub));
            node.setRight(new Node(juisteClub));
        }

        return node;
    }
}
