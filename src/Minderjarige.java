public class Minderjarige extends Passagier
{


    public Minderjarige(int leeftijd, String passagierNaam, int lengte, int breedte, boolean geldigePaspoort, boolean hasMinorPass, boolean heeftExtraKoffer, boolean heeftMedicijnen) {
        super(leeftijd, passagierNaam, lengte, breedte, geldigePaspoort, hasMinorPass, heeftExtraKoffer, heeftMedicijnen);
    }

    public boolean controlleerPassagier()
    {
        if (!isHasMinorPass() && !getGeldigePaspoort() )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
