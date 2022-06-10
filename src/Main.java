import java.util.Scanner;

public class Main
{
    public static VliegtuigBouwerSingleton Bouwer = VliegtuigBouwerSingleton.getInstance();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoe wilt u inloggen?");
        System.out.println("1) Ik ben een nieuwe klant die een vlucht wil boeken");
        System.out.println("2) Ik ben een bestaande klant die al een Vlucht heeft geboekt");
        System.out.println("3) Ik ben een Medewerker van het Vlieg maatschappij");
        System.out.println();

        switch (scanner.nextLine())
        {
            case "1":
                KlantMenu.NieuweKlantMenu();
                break;
            case "2":
                KlantMenu.MainMenu();
                break;
            case "3":
                StaffMenu.MainMenu();
                break;
        }

    }
}