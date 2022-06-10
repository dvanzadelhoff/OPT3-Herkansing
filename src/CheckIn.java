import java.util.ArrayList;

public class CheckIn
{
    private double prijsNormaleStoel;
    private ArrayList<CheckinPassagier> checkedInPassagiers;
    private Vliegtuig voorVliegtuig;

    public CheckIn(Vliegtuig voorVliegtuig, double prijsNormaleStoel)
    {
        if (voorVliegtuig.getCheckin() != null)
        {
            System.out.println("!!!");
            System.out.println("Error: Deze Vliegtuig heeft al een Check-in, maak daar gebruik van");
            System.out.println("!!!");
        }
        else
        {
            voorVliegtuig.setCheckin(this);
            this.voorVliegtuig = voorVliegtuig;
            this.prijsNormaleStoel = prijsNormaleStoel;
            this.checkedInPassagiers = new ArrayList<>();
        }
    }

    public boolean controleerPassagierEigenschappen(CheckinPassagier passagier)
    {
        if ((passagier.getPassagier().getDimensies().getLengte() > 200 || passagier.getPassagier().getDimensies().getBreedte() > 120) && passagier.getStoelType() == "Economy")
        {
            return false;
        }

        if (passagier.getPassagier().getLeeftijd() < 2 && ( passagier.getStoelType() == "Economy" || passagier.getStoelType() == "Comfort"))
        {
            return false;
        }

        return true;
    }

    public void geefStoelAanPassagier(CheckinPassagier passagier)
    {
        if (controleerPassagierEigenschappen(passagier))
        {

        }
    }

    public int countVrijeStoelen(String stoelType)
    {
        int counter = 0;

        for (Stoel s : voorVliegtuig.getStoelen())
        {
            if (s.getZittende() == null && s.getStoelType() == stoelType)
            {
                counter++;
            }
        }
        return counter;
    }

    public Vliegtuig getVoorVliegtuig()
    {
        return voorVliegtuig;
    }

    public ArrayList<CheckinPassagier> getCheckedInPassagiers()
    {
        return checkedInPassagiers;
    }
    public double getPrijsNormaleStoel()
    {
        return prijsNormaleStoel;
    }


}
