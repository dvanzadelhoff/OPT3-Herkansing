public class Volwassene extends Passagier
{


    public Volwassene(int leeftijd, String passagierNaam, int lengte, int breedte, boolean geldigePaspoort, boolean hasMinorPass, boolean heeftExtraKoffer, boolean heeftMedicijnen) {
        super(leeftijd, passagierNaam, lengte, breedte, geldigePaspoort, hasMinorPass, heeftExtraKoffer, heeftMedicijnen);
    }

    public boolean controlleerPassagier()
    {
        if (getLeeftijd() < 18 && !getGeldigePaspoort() )
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
