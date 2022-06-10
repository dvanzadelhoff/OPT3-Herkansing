import java.util.Scanner;

public class StaffMenu
{
    public static void MainMenu()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Main Menu");
        System.out.println();
        System.out.println("Maak uw keuze:");

        System.out.println("1) Maak een Vliegtuig aan");
        System.out.println("2) Bekijk de vliegtuigen");

        System.out.println("3) Maak een Check-in");

        System.out.println("4) Maak een Passagier aan");

        System.out.println("e) Exit");

        String option = scanner.nextLine();

        switch (option)
        {
            case "1":
                VliegtuigAanmaakMenu();
                break;
            case "2":
                ViewVliegtuigMenu();
                break;
            case "3":
                MaakCheckin();
                break;
            case "e":
                break;
            default:
                System.out.println("ongeldige input...");
                MainMenu();
        }

    }

    public static void VliegtuigAanmaakMenu()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Maak een nieuwe Vliegtuig aan:");
        System.out.println();
        System.out.println("Maak uw keuze:");
        System.out.println("1) Maak standaard vliegtuig");
        System.out.println("2) Maak een Custom Vliegtuig");

        switch (scanner.nextLine()) {
            case "1" -> {
                System.out.println("Geef de vliegtuig een naam:");
                Main.Bouwer.maakStandaartVliegtuig(scanner.nextLine());
                System.out.println("Gelukt!");
            }
            case "2" -> {
                System.out.println("Geef de vliegtuig een naam:");
                String naam = scanner.nextLine();
                /*
                System.out.println("Geef het aantal BabyStoelen aan:");
                int BabyStoelen = scanner.nextInt();
                System.out.println("Geef het aantal ComfortStoelen aan:");
                int ComfortStoelen = scanner.nextInt();
                System.out.println("Geef het aantal EconomyStoelen aan:");
                int EconomyStoelen = scanner.nextInt();
                System.out.println("Hoeveel Stoelen zitten er in een rij? :");
                int RijAantal = scanner.nextInt();
                */
                Main.Bouwer.maakCustomVliegtuig(naam /*, BabyStoelen, ComfortStoelen, EconomyStoelen, RijAantal */);
                System.out.println("Gelukt!");
            }
        }

        System.out.println("we sturen je terug naar het Main menu...");
        MainMenu();
    }

    public static void ViewVliegtuigen()
    {
        System.out.println("------------------------------------");
        System.out.println("Alle Vliegtuigen:");

        for (int i = 0; i < Main.Bouwer.getVliegtuigen().size(); i++)
        {
            System.out.println("==========");
            System.out.println("vliegtuigNummer: " + (i+1));
            System.out.println(Main.Bouwer.getVliegtuigen().get(i).getVliegtuigNaam());
            System.out.println("Aantal Stoelen: " + Main.Bouwer.getVliegtuigen().get(i).getStoelen().size());
        }

        System.out.println("==========");
    }

    public static void ViewVliegtuigMenu()
    {
        Scanner scanner = new Scanner(System.in);
        ViewVliegtuigen();
        System.out.println("Druk op Enter om terug te gaan");
        scanner.nextLine();
        MainMenu();
    }

    public static void MaakCheckin()
    {
        Scanner scanner = new Scanner(System.in);
        ViewVliegtuigen();
        System.out.println("Geef het Vliegtuignummer door waar je een Checkin voor wilt maken");
        int vliegtuigNummer = scanner.nextInt()-1;

        System.out.println("Geef de prijs aan van een EconomyStoel");
        double stoelPrijs = scanner.nextDouble();

        CheckIn c = new CheckIn(Main.Bouwer.getVliegtuigen().get(vliegtuigNummer), stoelPrijs);
        System.out.println("Geen problemen gekregen? Mooi! We sturen je nu terug...");
        MainMenu();
    }

}
