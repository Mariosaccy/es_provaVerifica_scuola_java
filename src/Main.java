import static java.lang.IO.println;
import static java.lang.IO.readln;

class main{
    void main() {

        String path = "D:\\documenti\\SCUOLA\\TPSIT\\5a\\java\\es_pre_verifica_2\\es_pre_verifica_2\\src\\stuenti.txt";

        Scuola scuola = new Scuola();

        try {
            scuola.letturaFile(path);
        } catch (Exception e) {
            println("errore: " + e.getMessage());
        }

        Integer nIn;
        do{

            do{
                nIn = Integer.parseInt(readln("1 - Stampa tutti gli studenti (in ordine di matricola)\n" +
                        "2 - Cerca studente per matricola\n" +
                        "3 - Inserisci nuovo studente\n" +
                        "4 - Elimina studente\n" +
                        "0 - Esci\n" +
                        "scelta: "));
            } while (nIn < 0 || nIn > 4);

            switch (nIn){
                case 1:
                    println(scuola.Stampa());
                    break;

                case 2:
                    Integer m1 = Integer.parseInt(readln("inserire matricola: "));
                    println(scuola.cecaPerMatricola(m1));
                    break;

                case 3:
                    Integer m2 = Integer.parseInt(readln("inserire matricola: "));
                    String nome = readln("nome:  ").trim();
                    String cognome = readln("cognome:  ").trim();
                    String classe = readln("classe:  ").trim();
                    Double media = Double.parseDouble(readln("inserire media: "));

                    try {
                        scuola.insertStudente(m2, nome, cognome, classe, media);

                        println("studente aggiunto");
                    }catch (Exception e){
                        println("errore: " + e.getMessage());
                    }
                    break;

                case 4:
                    Integer m3 = Integer.parseInt(readln("inserire matricola: "));

                    try {
                        scuola.eliminaStudente(m3);

                        println("studente eliminato");
                    }catch (Exception e){
                        println("errore: " + e.getMessage());
                    }

                    break;

                default:
                    println("uscita");
            }

        } while (nIn != 0);

    }


}
