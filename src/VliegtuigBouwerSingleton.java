import java.util.ArrayList;

public class VliegtuigBouwerSingleton
{
    private static VliegtuigBouwerSingleton singleton = null;
    private ArrayList<Vliegtuig> vliegtuigen;

    private VliegtuigBouwerSingleton()
    {
        vliegtuigen = new ArrayList<Vliegtuig>();
    }

    public ArrayList<Vliegtuig> getVliegtuigen() {
        return this.vliegtuigen;
    }

    public static VliegtuigBouwerSingleton getInstance()
    {
        if (singleton == null)
        {
            singleton = new VliegtuigBouwerSingleton();
        }
        return singleton;
    }

    private Vliegtuig bouwLegeVliegtuig(String naam)
    {
        Vliegtuig v = new Vliegtuig(naam);
        this.getVliegtuigen().add(v);
        return v;
    }

    public void maakCustomVliegtuig(String naam, int aantalBabyStoelen, int aantalComfortStoelen, int aantalEconomyStoelen, int aantalStoelenInRij)
    {
        Vliegtuig v = bouwLegeVliegtuig(naam);

        int aantalStoelen = aantalBabyStoelen + aantalComfortStoelen + aantalEconomyStoelen;
        String huidigeStoeltype = "Baby";

        int teller = 0;
        int rijteller = 1;
        while(teller <= aantalStoelen)
        {

            for (int x = 1; x < aantalStoelenInRij; x++)
            {

                if (teller == aantalBabyStoelen)
                {
                    huidigeStoeltype = "Comfort";
                }
                if (teller == aantalComfortStoelen+aantalBabyStoelen)
                {
                    huidigeStoeltype = "Economy";
                }

                if (teller < aantalStoelen)
                {
                    Stoel stoel = new Stoel(v, ""+rijteller+"."+x, huidigeStoeltype);
                    v.getStoelen().add(stoel);

                }
                teller++;
            }

            rijteller++;

        }

    }

    public void maakStandaartVliegtuig(String naam)
    {
        Vliegtuig v = bouwLegeVliegtuig(naam);

        int aantalStoelen = 0;
        String huidigeStoeltype = "Baby";

        for (int y = 1; y <= 50; y++)
        {

            for (int x = 1; x <= 6; x++)
            {
                Stoel stoel = new Stoel(v, ""+ y + "." + x , huidigeStoeltype);
                v.getStoelen().add(stoel);
                aantalStoelen ++;

                if (aantalStoelen == 12)
                {
                    huidigeStoeltype = "Comfort";
                }

                if (aantalStoelen == (60 + 12))
                {
                    huidigeStoeltype = "Economy";
                }

            }

        }

    }



}
