public class Volwassene extends Passagier
{

    public Volwassene(int leeftijd, String passagierNaam) {
        super(leeftijd, passagierNaam);
    }

    @Override
    public boolean controleerGegevens()
    {
        if (this.getLeeftijd() > 18 && this.getPassen().isGeldigPaspoort())
        {
            return true;
        }

        return false;
    }


}
