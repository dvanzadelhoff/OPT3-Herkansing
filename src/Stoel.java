public class Stoel
{
    private Vliegtuig vliegtuig;
    private String stoelLabel;
    private String stoelType;
    private Passagier zittende = null;
    public Stoel(Vliegtuig vliegtuig, String stoelNaam, String stoelType)
    {
        this.vliegtuig = vliegtuig;
        this.stoelLabel = stoelNaam;
        this.stoelType = stoelType;
    }

    public String getStoelLabel() {
        return this.stoelLabel;
    }

    public String getStoelType() {
        return this.stoelType;
    }

    public Passagier getZittende() {
        return zittende;
    }

    public void setZittende(Passagier zittende) {
        this.zittende = zittende;
    }
}
