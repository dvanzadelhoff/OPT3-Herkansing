import java.util.ArrayList;

public class CheckIn
{
    private double prijsNormaleStoel;
    private ArrayList<Passagier> checkedInPassagiers;
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

    public Vliegtuig getVoorVliegtuig() {
        return voorVliegtuig;
    }

    public ArrayList<Passagier> getCheckedInPassagiers() {
        return checkedInPassagiers;
    }
    public double getPrijsNormaleStoel() {
        return prijsNormaleStoel;
    }
}
