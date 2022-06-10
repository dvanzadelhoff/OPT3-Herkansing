public class PassagierExtraInfo {

    public boolean HeeftExtraKoffer;
    public boolean HeeftMedicijnen;

    public void setHeeftExtraKoffer(boolean heeftExtraKoffer)
    {
        HeeftExtraKoffer = heeftExtraKoffer;
    }

    public void setHeeftMedicijnen(boolean heeftMedicijnen)
    {
        HeeftMedicijnen = heeftMedicijnen;
    }

    public boolean isHeeftMedicijnen()
    {
        return HeeftMedicijnen;
    }

    public boolean isHeeftExtraKoffer()
    {
        return HeeftExtraKoffer;
    }
}
