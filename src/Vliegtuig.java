import java.util.ArrayList;

public class Vliegtuig
{
    private String vliegtuigNaam;
    private ArrayList<Stoel> stoelen;

    private CheckIn checkin;
    public Vliegtuig(String vliegtuigNaam)
    {
        this.vliegtuigNaam = vliegtuigNaam;
        this.stoelen = new ArrayList<>();
        this.checkin = null;
    }

    public Stoel zoekStoel(int rijNummer, int stoelNummer)
    {
        String zoekterm = ""+rijNummer+"."+stoelNummer;

        for (int i = 0; i < this.getStoelen().size(); i++)
        {
            if (this.getStoelen().get(i).getStoelLabel().equals(zoekterm))
            {
                return this.getStoelen().get(i);
            }
        }
        return null;
    }

    public Stoel zoekStoel(String stoelType)
    {
        for (int i = 0; i < this.getStoelen().size(); i++)
        {
            if (this.getStoelen().get(i).getStoelType().equals(stoelType) && this.getStoelen().get(i).getZittende() == null)
            {
                return this.getStoelen().get(i);
            }
        }
        return null;
    }

    public Stoel zoekPassagier(Passagier passagier)
    {
        for (int i = 0; i < this.getStoelen().size(); i++)
        {
            if (this.getStoelen().get(i).getZittende().getPassagierNaam() == passagier.getPassagierNaam())
            {
                return this.getStoelen().get(i);
            }
        }
        return null;
    }

    public void setCheckin(CheckIn checkin) {
        this.checkin = checkin;
    }
    public CheckIn getCheckin() {
        return checkin;
    }
    public String getVliegtuigNaam() {
        return vliegtuigNaam;
    }
    public ArrayList<Stoel> getStoelen() {
        return stoelen;
    }
}
