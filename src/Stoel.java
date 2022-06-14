public class Stoel
{
    private Vliegtuig vliegtuig;

    private StoelInfo stoelInfo = new StoelInfo();
    private Passagier zittende = null;
    public Stoel(Vliegtuig vliegtuig, StoelInfo info /*, String stoelNaam, String stoelType */)
    {
        this.vliegtuig = vliegtuig;
        this.stoelInfo = info;
    }

    public String getStoelLabel() {
        return this.getStoelInfo().getStoelLabel();
    }

    public String getStoelType() {
        return this.getStoelInfo().getStoelType();
    }

    public StoelInfo getStoelInfo() {
        return stoelInfo;
    }

    public Passagier getZittende() {
        return zittende;
    }

    public void setZittende(Passagier zittende) {
        this.zittende = zittende;
    }
}