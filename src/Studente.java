
public class Studente {

    private Integer matricola;
    private String nome;
    private String cognome;
    private String classe;
    private Double media;

    public Studente(Integer matricola, String nome, String cognome, String classe, Double media) throws datoNonValidoException {
        setMatricola(matricola);
        setNome(nome);
        setCognome(cognome);
        setClasse(classe);
        setMedia(media);
    }

    public Integer getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getClasse() {
        return classe;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) throws datoNonValidoException {
        if(media > 10 || media < 0){
            throw new datoNonValidoException("media non valida");
        }else{
            this.media = media;
        }
    }

    public void setClasse(String classe) throws datoNonValidoException {
        if(classe == null || classe.trim().isEmpty()){
            throw new datoNonValidoException("classe non valido");
        } else {
            this.classe = classe;
        }
    }

    public void setCognome(String cognome) throws datoNonValidoException {
        if(cognome == null || cognome.trim().isEmpty()){
            throw new datoNonValidoException("cognome non valido");
        } else {
            this.cognome = cognome;
        }
    }

    public void setNome(String nome) throws datoNonValidoException {
        if(nome == null || nome.trim().isEmpty()){
            throw new datoNonValidoException("nome non valido");
        } else {
            this.nome = nome;
        }
    }

    private void setMatricola(Integer matricola) throws datoNonValidoException {
        if(matricola <= 0){
            throw new datoNonValidoException("matricola non valida");
        } else {
            this.matricola = matricola;
        }
    }

    @Override
    public String toString() {
        return "matricola: " + matricola + " nome: " + nome + " cognome: " + cognome + " classe: " + classe + " media: " + media;
    }


}
