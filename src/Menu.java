import java.util.Scanner;

public class Menu
{
    public static Scanner scanner = new Scanner(System.in);
    public static void MainMenu()
    {
        System.out.println("------------------------------------");
        System.out.println("Main Menu");
        System.out.println();
        System.out.println("Maak uw keuze:");
        System.out.println("1) Maak een Vliegtuig aan");
        System.out.println("2) Bekijk de vliegtuigen");
        System.out.println("e) Exit");


        String option = scanner.nextLine();
        switch (option)
        {
            case "1":
                VliegtuigAanmaakMenu();
                break;
            case "2":

                break;
            case "e":

                break;
        }
    }

    public static void VliegtuigAanmaakMenu()
    {
        System.out.println("------------------------------------");
        System.out.println("Maak een nieuwe Vliegtuig aan:");
        System.out.println();
        System.out.println("Maak uw keuze:");
        System.out.println("1) Maak standaard vliegtuig");
        System.out.println("2) Maak een Custom Vliegtuig");
        scanner.nextLine();
    }

    public static void
}
