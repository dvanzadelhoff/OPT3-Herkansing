public abstract class Passagier
{
    private int leeftijd;
    private String passagierNaam;

    private boolean hasMinorPass;

    private boolean geldigePaspoort;

    private int lengte;

    private int breedte;

    private CheckIn checkIn;

    private boolean heeftExtraKoffer;

    private boolean heeftMedicijnen;

    public Passagier(int leeftijd, String passagierNaam, int lengte, int breedte, boolean geldigePaspoort, boolean hasMinorPass, boolean heeftExtraKoffer, boolean heeftMedicijnen)
    {
        this.leeftijd = leeftijd;
        this.passagierNaam = passagierNaam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.geldigePaspoort = geldigePaspoort;
        this.hasMinorPass = hasMinorPass;
        this.heeftExtraKoffer = heeftExtraKoffer;
        this.heeftMedicijnen = heeftMedicijnen;

        controlleerPassagier();
    }

    public boolean controlleerPassagier()
    {
        System.out.println("je hoort hier niet te zijn");
        return false;
    }

    public Boolean getGeldigePaspoort() {
        return geldigePaspoort;
    }

    public double getExtraPrijs()
    {
        double extra = 0.00;

        if (heeftMedicijnen){extra +=5.00;}
        if (heeftExtraKoffer){extra += 50.00;}

        return extra;
    }

    public CheckIn checkIn(CheckIn checkIn)
    {
        if (controlleerPassagier())
        {
            this.checkIn = checkIn;
            return checkIn;
        }
        return null;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getLengte() {
        return lengte;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public String getPassagierNaam() {
        return passagierNaam;
    }

    public boolean isHasMinorPass() {
        return hasMinorPass;
    }

    public boolean isHeeftExtraKoffer() {
        return heeftExtraKoffer;
    }

    public boolean isHeeftMedicijnen() {
        return heeftMedicijnen;
    }

    public boolean isGeldigePaspoort() {
        return geldigePaspoort;
    }
}
