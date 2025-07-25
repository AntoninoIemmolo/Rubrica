

public class Persona {
    private final String nome;
    private final String cognome;
    private final String indirizzo;
    private final String telefono;
    private final Integer età;

    public Persona(String n, String c, String i, String t, int e){
        this.nome = n;
        this.cognome = c;
        this.indirizzo = i;
        this.telefono = t;
        this.età = e;
    }


    public String getCognome() {
        return cognome;
    }

    public Integer getEtà() {
        return età;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return this.nome + " " +
        this.cognome + " " +
        this.telefono+ " " +
        this.indirizzo+ " " +
        this.età;
    };
    public String toStringNameOnly() {
        return this.nome + " " +
        this.cognome ;
    }
    public String toStringFieldSafe() {
        return this.nome + ";" +
        this.cognome + ";" +
        this.telefono+ ";" +
        this.indirizzo+ ";" +
        this.età;
    }
    public String toStringMinInfo(){
       return this.nome + " "+
        this.cognome + " " +
        this.telefono+ " ";
    }

}
