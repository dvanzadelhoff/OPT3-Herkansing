import java.util.ArrayList;

public class CheckinPassagier
{
    public Passagier passagier;
    public String stoelType;
    public CheckIn checkIn;

    public double BerekenTicketPrijs(CheckinPassagier checkinPassagier)
    {
        double totaalprijs = 0;
        PassagierExtraInfo passagiergegevens = checkinPassagier.getPassagier().getExtraInfo();

        switch (this.getStoelType())
        {
            case "Economy":
                totaalprijs += checkIn.getPrijsNormaleStoel();
                break;
            case "Comfort":
                totaalprijs += (checkIn.getPrijsNormaleStoel() * 1.2);
                break;
            case "Baby":
                totaalprijs += (checkIn.getPrijsNormaleStoel() * 1.1);
                break;
        }

        if (passagiergegevens.isHeeftMedicijnen())
        {
            totaalprijs += 5;
        }

        if (passagiergegevens.isHeeftExtraKoffer())
        {
            totaalprijs += 50;
        }
        return totaalprijs;
    }

    public static void Annulering(CheckinPassagier checkinPassagier)
    {
        haaluitCheckinArray(checkinPassagier);
        checkinPassagier.setCheckIn(null);
        checkinPassagier.getCheckIn().verwijderPassagierVanVlucht(checkinPassagier);
    }

    public static void haaluitCheckinArray(CheckinPassagier checkinPassagier)
    {
        ArrayList<CheckinPassagier> lijst = checkinPassagier.getCheckIn().getCheckedInPassagiers();

        int target = 0;

        for (int i = 0; i < checkinPassagier.getCheckIn().getCheckedInPassagiers().size(); i++)
        {
            if (lijst.get(i) == checkinPassagier)
            {
                i = target;
            }
        }

        lijst.remove(target);
    }

    public void setPassagier(Passagier passagier)
    {
        this.passagier = passagier;
    }

    public void setCheckIn(CheckIn checkIn)
    {
        this.checkIn = checkIn;
    }

    public void setStoelType(String stoelType)
    {
        this.stoelType = stoelType;
    }

    public Passagier getPassagier()
    {
        return passagier;
    }

    public CheckIn getCheckIn()
    {
        return checkIn;
    }

    public String getStoelType()
    {
        return stoelType;
    }
}
