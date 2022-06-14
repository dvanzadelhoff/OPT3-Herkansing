public class Minderjarige extends Passagier
{


    public Minderjarige(int leeftijd, String passagierNaam) {
        super(leeftijd, passagierNaam);
    }

    @Override
    public boolean controleerGegevens() {

        if (!getPassen().isHasMinorPass() && !getPassen().isGeldigPaspoort())
        {
            return false;
        }

        return true;

    }
}
