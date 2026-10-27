import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class Scuola {

    TreeMap<Integer, Studente> studenti;

    public Scuola(){
        studenti = new TreeMap<>();
    }

    public void letturaFile(String path){

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            br.readLine();

            String riga;
            while ((riga = br.readLine()) != null){
                List<String> elmenti = List.of(riga.split(";"));

                Integer matricola = Integer.parseInt(elmenti.get(0).trim());
                String nome = elmenti.get(1).trim();
                String cognome = elmenti.get(2).trim();
                String classe = elmenti.get(3).trim();
                Double media = Double.parseDouble(elmenti.get(4).trim());

                studenti.put(matricola, new Studente(matricola, nome, cognome, classe, media));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String Stampa(){
        String out = "";

        for (Studente s : studenti.values()){
            out += s.toString() + "\n";
        }

        return out;
    }

    public String cecaPerMatricola(Integer matricolaIn){
        if(studenti.containsKey(matricolaIn)){
            return  studenti.get(matricolaIn).toString();
        }
        else {
            return "nessuno studente trovato";
        }
    }

    public void insertStudente(Integer matricola, String nome, String cognome, String classe, Double media) throws datoNonValidoException{

        if(studenti.containsKey(matricola)){
            throw new datoNonValidoException("matricola già utilizzata");
        }

        Studente s = new Studente(matricola, nome, cognome, classe, media);
        studenti.put(matricola, s);
    }

    public void eliminaStudente(Integer matricola) throws datoNonValidoException {
        if(!studenti.containsKey(matricola)){
            throw new datoNonValidoException("studente non esistente");
        }

        studenti.remove(matricola);
    }
}
