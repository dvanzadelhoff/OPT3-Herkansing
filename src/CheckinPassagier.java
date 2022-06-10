public class CheckinPassagier
{
    public Passagier passagier;
    public String stoelType;
    public CheckIn checkIn;

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
