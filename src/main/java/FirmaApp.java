import pl.workjava.firma.WniosekRepository;
import pl.workjava.firma.WniesekService;

import java.io.IOException;

public class FirmaApp {

    public static void main(String[] args) throws IOException {
        WniosekRepository wniosekRepository=new WniosekRepository();//wstrzykiwanie zalerznosci repository
        WniesekService wniosekService=new WniesekService(wniosekRepository);//wstrzykiwanie zalerznosci serwis +repo parametr

        TextMainView view=new TextMainView(wniosekService);//wstrzykiwanie zalerznosci parametr c.d.

        view.init();
    }

}
