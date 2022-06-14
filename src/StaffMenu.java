import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StaffMenu
{
    public static void MainMenu()
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("------------------------------------");
        System.out.println("Main Menu");
        System.out.println();
        System.out.println("Maak uw keuze:");

        System.out.println("1) Maak een Vliegtuig aan");
        System.out.println("2) Bekijk de vliegtuigen");

        System.out.println("3) Maak een Check-in");

        System.out.println("4) Geef een Stoel aan Passagier");

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
            case "4":
                geefStoelBijCheckin();
                break;
            case "e":
                mainMainMenu.mainMainMenu();
                break;
            default:
                System.out.println("ongeldige input...");
                MainMenu();
        }

    }

    public static void geefStoelBijCheckin()
    {
        Scanner scanner = mainMainMenu.newScanner();
        //Scanner scanner = new Scanner(System.in);

        ViewCheckins();
        System.out.println("Bij welke checkin wilt u kijken? Voer de checkin nummer in");

        Vliegtuig v = Main.Bouwer.getVliegtuigen().get(scanner.nextInt()-1);

        showCheckinPassagiers(v.getCheckin());

        System.out.println("Welke passagier wilt u inchecken? voer zijn nummer in...");
        int nummer = scanner.nextInt()-1;

        BevestigStoelgeven(v, nummer);
    }

    public static void BevestigStoelgeven(Vliegtuig v, int nummer)
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("er zijn nog " + v.getCheckin().countVrijeStoelen(v.getCheckin().getCheckedInPassagiers().get(nummer).getStoelType())+" stoelen van het type naar keuze beschikbaar");
        System.out.println("wilt u doorgaan? (j/n)");

        String input = scanner.nextLine();

        switch (input) {
            case "j" -> {
                v.getCheckin().geefStoelAanPassagier(v.getCheckin().getCheckedInPassagiers().get(nummer));
                System.out.println("De passagier kan genieten van zijn vakantie");
                MainMenu();
            }
            case "n" -> {
                System.out.println("U word terug verwezen naar het menu");
                MainMenu();
            }
            default -> {
                System.out.println("ongeldige input...");
                MainMenu();
            }
        }
    }

    public static void showCheckinPassagiers(CheckIn checkin)
    {

        ArrayList<CheckinPassagier> passagiers = checkin.getCheckedInPassagiers();

        for (int i = 0; i < passagiers.size(); i++)
        {
            if (showIfStoelGegeven(passagiers.get(i)))
            {
                System.out.println("==========");
                System.out.println("Nummer: " + (i + 1));
                System.out.println("Naam: " + passagiers.get(i).getPassagier().getPassagierNaam());
                System.out.println("kloppende tickets: " + passagiers.get(i).getPassagier().controleerGegevens());
                System.out.println("Gereserveerde Stoel type: " + passagiers.get(i).getStoelType());
                System.out.println("kloppende dimensies voor stoel: " + passagiers.get(i).getCheckIn().controleerPassagierEigenschappen(passagiers.get(i)));
            }
        }
        System.out.println("==========");
    }

    public static boolean showIfStoelGegeven(CheckinPassagier passagier)
    {
        int x = 0;
        ArrayList<Stoel> Stoelen = passagier.getCheckIn().getVoorVliegtuig().getStoelen();

        for (int i = 0; i < passagier.getCheckIn().getVoorVliegtuig().getStoelen().size(); i++)
        {
            if(Stoelen.get(i).getZittende() != null)
            {
                if (Objects.equals(passagier.getPassagier().getPassagierNaam(), Stoelen.get(i).getZittende().getPassagierNaam()))
                {
                    x++;
                }
            }
        }

        return x == 0;

    }

    public static void VliegtuigAanmaakMenu()
    {
        Scanner scanner = mainMainMenu.newScanner();

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

                System.out.println("Geef het aantal BabyStoelen aan:");
                int BabyStoelen = scanner.nextInt();
                System.out.println("Geef het aantal ComfortStoelen aan:");
                int ComfortStoelen = scanner.nextInt();
                System.out.println("Geef het aantal EconomyStoelen aan:");
                int EconomyStoelen = scanner.nextInt();
                System.out.println("Hoeveel Stoelen zitten er in een rij? :");
                int RijAantal = scanner.nextInt();

                String IndelingInfo = "" + BabyStoelen +","+ ComfortStoelen +","+ EconomyStoelen +","+ RijAantal;

                Main.Bouwer.maakCustomVliegtuig(naam, IndelingInfo);
                System.out.println("Gelukt!");
            }
        }

        System.out.println("we sturen je terug naar het Main menu...");
        System.out.println("------------------------------------");
        MainMenu();
    }

    public static void ViewCheckins()
    {
        System.out.println("------------------------------------");
        System.out.println("Alle Checkins:");

        for (int i = 0; i < Main.Bouwer.getVliegtuigen().size(); i++)
        {
            if (Main.Bouwer.getVliegtuigen().get(i).getCheckin() != null)
            {
                System.out.println("==========");
                System.out.println("Checkin: " + (i+1));
                System.out.println("Vliegtuig naam"+Main.Bouwer.getVliegtuigen().get(i).getVliegtuigNaam());
                System.out.println("Prijs normale stoel: " + Main.Bouwer.getVliegtuigen().get(i).getCheckin().getPrijsNormaleStoel());
            }
        }

        System.out.println("==========");
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
        Scanner scanner = mainMainMenu.newScanner();
        ViewVliegtuigen();
        System.out.println("Druk op Enter om terug te gaan");
        scanner.nextLine();
        MainMenu();
    }

    public static void MaakCheckin()
    {
        Scanner scanner = mainMainMenu.newScanner();
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
