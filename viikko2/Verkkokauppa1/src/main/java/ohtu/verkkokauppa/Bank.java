
package ohtu.verkkokauppa;

/**
 *
 * @author riiraty
 */
public interface Bank {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
