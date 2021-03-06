import org.w3c.dom.ls.LSOutput;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.util.ArrayList;
import java.util.Scanner;

public class PassagierMenu
{

    public static void NieuweKlantMenu()
    {
        String naam = NaamVraag();

        int leeftijd = LeeftijdVraag();

        Passagier p = SetLeeftijdsgroepPassagier(naam, leeftijd);

        DimensieVragen(p);

        MedicijnenVraag(p);

        ExtraKofferVraag(p);

        geldigPaspoortVraag(p);

        Reserveer(p);
    }

    public static void showBeschikbareVliegtuigen()
    {
        System.out.println("------------------------------------");
        System.out.println("Alle Beschikbare Vliegtuigen:");

        for (int i = 0; i < Main.Bouwer.getVliegtuigen().size(); i++)
        {
            if (Main.Bouwer.getVliegtuigen().get(i).getCheckin() != null)
            {
                System.out.println("==========");
                System.out.println("Vlucht nummer: " + (i+1));
                System.out.println(Main.Bouwer.getVliegtuigen().get(i).getVliegtuigNaam());
                System.out.println("Prijs: Normale stoel = " + Main.Bouwer.getVliegtuigen().get(i).getCheckin().getPrijsNormaleStoel() + " euro");
            }
        }

        System.out.println("==========");
    }

    public static void MainMenu()
    {
        //Scanner scanner = mainMainMenu.newScanner();
        Scanner scanner = new Scanner(System.in);
        showBeschikbareVliegtuigen();
        System.out.println("In welke Vliegtuig zit u? geef het vluchtnummer aan...");
        int vliegtuigNummer = scanner.nextInt()-1;

        ArrayList<CheckinPassagier> checkinPassagiers = Main.Bouwer.getVliegtuigen().get(vliegtuigNummer).getCheckin().getCheckedInPassagiers();

        login(checkinPassagiers);
    }

    public static void login(ArrayList<CheckinPassagier> checkinPassagiers)
    {
        Scanner scanner = mainMainMenu.newScanner();

        for (int i = 0; i < checkinPassagiers.size(); i++)
        {
            System.out.println( i+1+")" + checkinPassagiers.get(i).getPassagier().getPassagierNaam());
        }

        System.out.println("Wie bent u? geef het nummer op...");
        int loginToken = scanner.nextInt()-1;

        profiel(checkinPassagiers.get(loginToken));

    }

    public static void profiel(CheckinPassagier checkinPassagier)
    {
        Scanner scanner = mainMainMenu.newScanner();

        Passagier p = checkinPassagier.getPassagier();
        double ticketkosten = checkinPassagier.BerekenTicketPrijs(checkinPassagier);

        System.out.println("naam: " + p.getPassagierNaam());
        System.out.println("leeftijd: " + p.getLeeftijd());
        System.out.println("Totaalprijs incl extra voorzieningen: " + ticketkosten + " euro");

        System.out.println("wat wilt u doen?");
        System.out.println("1) Vlucht annuleren");
        System.out.println("2) uitloggen");

        switch (scanner.nextInt())
        {
            case 1:
                BevestigAnnulering(checkinPassagier);
                break;
            case 2:
                mainMainMenu.mainMainMenu();
                break;
            default:
                profiel(checkinPassagier);
                break;
        }

    }

    public static void BevestigAnnulering(CheckinPassagier checkinPassagier)
    {
        Scanner scanner = mainMainMenu.newScanner();
        System.out.println("weet u het zeker? (j/n)");
        switch (scanner.nextLine())
        {
            case "j":
                CheckinPassagier.Annulering(checkinPassagier);
                System.out.println("gelukt! je krijgt je geld alleen niet terug lol");
                mainMainMenu.mainMainMenu();
                break;
            case "n":
                profiel(checkinPassagier);
                break;
            default:
                BevestigAnnulering(checkinPassagier);
                break;
        }
    }

    public static void Reserveer(Passagier p)
    {
        Scanner scanner = mainMainMenu.newScanner();
        showBeschikbareVliegtuigen();

        System.out.println("Voor welk Vliegtuig wilt u boeken?");
        System.out.println("schrijf het vlucht nummer daarvan op");
        int vluchtnummer = scanner.nextInt()-1;

        PrintVrijeStoelen(vluchtnummer);

        CheckinPassagier cip = new CheckinPassagier();
        cip.setPassagier(p);
        cip.setCheckIn(Main.Bouwer.getVliegtuigen().get(vluchtnummer).getCheckin());
        cip.getCheckIn().vullCheckedInPassagiers(cip);

        Stoelkeuze(cip);
    }

    public static void Stoelkeuze(CheckinPassagier cip)
    {
        //fix geef stoel aan passagier

        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Welke stoel neemt U?");

        if(cip.getPassagier().getDimensies().getLengte() > 200 || cip.getPassagier().getDimensies().getBreedte() > 120 )
        {
            System.out.println("U kunt geen Economy stoel nemen ivm uw dimensies");
        }
        if (cip.getPassagier().getLeeftijd() < 2)
        {
            System.out.println("U kunt geen Economy stoel of een Comfort stoel nemen ivm uw leeftijd");
        }

        String input = scanner.nextLine();

        switch (input)
        {
            case "Baby":
                cip.setStoelType("Baby");
                break;
            case "Economy":
                cip.setStoelType("Economy");
                break;
            case "Comfort":
                cip.setStoelType("Comfort");
                break;
        }

        toegestaanCheck(cip);

    }

    public static void toegestaanCheck(CheckinPassagier c)
    {
        if (!c.getCheckIn().controleerPassagierEigenschappen(c))
        {
            c.setStoelType(null);
            System.out.println("Stoelkeuze niet toegestaan. probeer het opnieuw");
            System.out.println("-");
            Stoelkeuze(c);
        }

        else
        {
            System.out.println("Gelukt! U word terug verwezen naar het start menu....");
            System.out.println("------------------------------------");
            mainMainMenu.mainMainMenu();
        }

    }

    public static void PrintVrijeStoelen(int vluchtnummer)
    {
        System.out.println("Vrije Babystoelen: "+Main.Bouwer.getVliegtuigen().get(vluchtnummer).getCheckin().countVrijeStoelen("Baby"));
        System.out.println("Vrije Comfortstoelen: "+Main.Bouwer.getVliegtuigen().get(vluchtnummer).getCheckin().countVrijeStoelen("Comfort"));
        System.out.println("Vrije Economystoelen: "+Main.Bouwer.getVliegtuigen().get(vluchtnummer).getCheckin().countVrijeStoelen("Economy"));
    }


    public static void geldigPaspoortVraag(Passagier p) {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Heeft u een geldig paspoort? (j/n)");
        switch (scanner.nextLine()) {
            case "j" -> p.getPassen().setGeldigPaspoort(true);
            case "n" -> p.getPassen().setGeldigPaspoort(false);
            default -> {
                System.out.println("Onbekende invoer dus we denken dat hij niet geldig is");
                p.getPassen().setGeldigPaspoort(false);
            }
        }
    }

    public static String NaamVraag()
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Wat is je naam?");
        return scanner.nextLine();
    }

    public static int LeeftijdVraag()
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Wat is je Leeftijd?");
        return scanner.nextInt();
    }

    public static void DimensieVragen(Passagier p)
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Geef uw lengte aan in cm:");
        int lengte = scanner.nextInt();
        p.getDimensies().setLengte(lengte);

        System.out.println("Geef uw breedte aan in cm");
        int breedte = scanner.nextInt();
        p.getDimensies().setBreedte(breedte);
    }

    public static void ExtraKofferVraag(Passagier p)
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Neemt u een extra koffer mee? (j/n)");
        switch (scanner.nextLine()) {
            case "j" -> p.getExtraInfo().setHeeftExtraKoffer(true);
            case "n" -> p.getExtraInfo().setHeeftExtraKoffer(false);
            default -> {
                System.out.println("Onbekende invoer dus we denken dat je niks extra meeneemt");
                p.getExtraInfo().setHeeftExtraKoffer(false);
            }
        }
    }

    public static void MedicijnenVraag(Passagier p)
    {
        Scanner scanner = mainMainMenu.newScanner();

        System.out.println("Neemt u medicijnen mee? (j/n)");
        switch (scanner.nextLine()) {
            case "j" -> p.getExtraInfo().setHeeftMedicijnen(true);
            case "n" -> p.getExtraInfo().setHeeftMedicijnen(false);
            default -> {
                System.out.println("Onbekende invoer dus we denken dat je niks meeneemt");
                p.getExtraInfo().setHeeftMedicijnen(false);
            }
        }
    }

    public static Passagier SetLeeftijdsgroepPassagier(String naam, int leeftijd)
    {
        if (leeftijd < 18)
        {
            return new Minderjarige(leeftijd,naam);
        }
        else
        {
            return new Volwassene(leeftijd,naam);
        }
    }

}
