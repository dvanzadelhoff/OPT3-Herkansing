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
        this.getEersteVrijeStoel(passagier.getStoelType()).setZittende(passagier.getPassagier());
    }

    public void verwijderPassagierVanVlucht(CheckinPassagier passagier)
    {
        for (Stoel s : getVoorVliegtuig().getStoelen())
        {
            if (s.getZittende() == passagier.passagier)
            {
                s.setZittende(null);
                System.out.println("Passagier is verwijdert");
            }
        }

        System.out.println("geen passagier gevonden");
    }

    public Stoel getEersteVrijeStoel(String stoeltype)
    {
        for(int i = 0; i < this.voorVliegtuig.getStoelen().size(); i++)
        {
            if (this.voorVliegtuig.getStoelen().get(i).getZittende() == null && this.voorVliegtuig.getStoelen().get(i).getStoelType().equals(stoeltype))
            {
                return this.voorVliegtuig.getStoelen().get(i);
            }
        }

        return null;

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

    public void vullCheckedInPassagiers(CheckinPassagier passagier)
    {
        this.checkedInPassagiers.add(passagier);
    }

    public void setVoorVliegtuig(Vliegtuig voorVliegtuig)
    {
        this.voorVliegtuig = voorVliegtuig;
    }


}
