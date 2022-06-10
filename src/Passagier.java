public abstract class Passagier
{
    private int leeftijd;
    private String passagierNaam;
    private CheckIn checkIn;

    private PassagierDimensie dimensies = new PassagierDimensie();

    private PassagierPassen passen = new PassagierPassen();

    private PassagierExtraInfo extraInfo = new PassagierExtraInfo();

    public Passagier(int leeftijd, String passagierNaam)
    {
        this.leeftijd = leeftijd;
        this.passagierNaam = passagierNaam;
    }

    public void boekEenVlucht(String stoelType, Vliegtuig vliegtuig)
    {
        if (controleerGegevens())
        {
            if (vliegtuig.getCheckin() == null)
            {
                System.out.println("Uw gekozen vliegtuig heeft geen checkin geopent");
            }
            else
            {
                if (vliegtuig.getCheckin().countVrijeStoelen(stoelType) > 0)
                {
                    CheckinPassagier c = new CheckinPassagier();
                    c.setPassagier(this);
                    c.setStoelType(stoelType);
                    c.setCheckIn(vliegtuig.getCheckin());

                    if (c.getCheckIn().controleerPassagierEigenschappen(c))
                    {
                        System.out.println("Uw eigenschappen voldoen niet aan de stoel die u gekozen heeft");
                    }
                }
                else
                {
                    System.out.println("er zijn geen stoelen meer beschikbaar :(");
                }
            }
        }

    }

    public boolean controleerGegevens()
    {
        if (this.getLeeftijd() < 18 && !this.getPassen().isHasMinorPass())
        {
            return false;
        }

        return this.getPassen().isGeldigPaspoort();
    }

    public int getLeeftijd()
    {
        return leeftijd;
    }

    public CheckIn getCheckIn()
    {
        return checkIn;
    }

    public String getPassagierNaam()
    {
        return passagierNaam;
    }

    public PassagierDimensie getDimensies()
    {
        return dimensies;
    }

    public PassagierExtraInfo getExtraInfo()
    {
        return extraInfo;
    }

    public PassagierPassen getPassen()
    {
        return passen;
    }

}
