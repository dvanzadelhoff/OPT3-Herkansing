import java.util.ArrayList;

public class CheckIn
{
    private Vliegtuig voorVliegtuig;
    private double prijsNormaleStoel;
    private ArrayList<Passagier> checkedInPassagiers;

    public CheckIn(Vliegtuig voorVliegtuig, double prijsNormaleStoel)
    {
        this.voorVliegtuig = voorVliegtuig;
        this.prijsNormaleStoel = prijsNormaleStoel;
        this.checkedInPassagiers = new ArrayList<>();
    }

    public void geefStoelAanPassagier(Passagier passagier, String stoelType)
    {
        if (controlleerPassagier(passagier, stoelType))
        {
            voorVliegtuig.zoekStoel(stoelType).setZittende(passagier);
        }
    }
    public boolean controlleerPassagier(Passagier passagier, String stoelType)
    {
        if (passagier.getLengte() > 200 && passagier.getBreedte() > 120 && stoelType == "Economy")
        {
            return false;
        }
        if (passagier.getLeeftijd() < 2 && stoelType != "Baby")
        {
            return false;
        }
        return true;
    }
    public void telLegeStoelen()
    {
        int babyStoelTeller = 0;
        int economyStoelTeller = 0;
        int comfortStoelTeller = 0;

        for (int i = 0; i < voorVliegtuig.getStoelen().size(); i++)
        {
            if (voorVliegtuig.getStoelen().get(i).getStoelType() == "Baby" && voorVliegtuig.getStoelen().get(i).getZittende() == null)
            {
                babyStoelTeller++;
            }
            if (voorVliegtuig.getStoelen().get(i).getStoelType() == "Economy" && voorVliegtuig.getStoelen().get(i).getZittende() == null)
            {
                economyStoelTeller++;
            }
            if (voorVliegtuig.getStoelen().get(i).getStoelType() == "Comfort" && voorVliegtuig.getStoelen().get(i).getZittende() == null)
            {
                comfortStoelTeller++;
            }
        }
        System.out.println("Er zijn: "+babyStoelTeller+" Babystoelen beschikbaar");
        System.out.println("Er zijn: "+economyStoelTeller+" Economystoelen beschikbaar");
        System.out.println("Er zijn: "+comfortStoelTeller+" Comfortstoelen beschikbaar");
    }
    public void BerekenPrijs(Passagier passagier)
    {
        double totaal = 0.00;
        totaal = totaal + passagier.getExtraPrijs();

        switch(voorVliegtuig.zoekPassagier(passagier).getStoelType()) {
            case "Economy":
                totaal = totaal + getPrijsNormaleStoel();
                break;
            case "Baby":
                totaal = totaal + (getPrijsNormaleStoel() * 1.1);
                break;
            case "Comfort":
                totaal = totaal + (getPrijsNormaleStoel() * 1.2);
                break;
        }

        System.out.println(passagier.getPassagierNaam() + " betaald: " +totaal+"euro voor zijn stoel");
    }

    public Vliegtuig getVoorVliegtuig()
    {
        return this.voorVliegtuig;
    }

    public ArrayList<Passagier> getCheckedInPassagiers() {
        return checkedInPassagiers;
    }
    public double getPrijsNormaleStoel() {
        return prijsNormaleStoel;
    }
}
