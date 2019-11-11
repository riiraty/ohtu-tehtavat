
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author riiraty
 */
public interface Accounting {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
