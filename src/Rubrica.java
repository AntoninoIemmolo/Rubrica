
import java.util.LinkedList;

public class Rubrica {
    private static LinkedList<Persona> personasList = new LinkedList<>();
    private static LinkedList<String> personasStringList = new LinkedList<>();

    public static Persona addPerona(String n, String c, String i, String t, String e){
        if(n.equals("") || c.equals("") || i.equals("") || t.equals("") || e.equals(""))
            return null;
        Persona p = new Persona(n, c, i, t, Integer.parseInt(e));
        personasList.add(p);
        personasStringList.add(p.toString());
        return p;
    }

    private static Persona getPersonaByNameSurname(String n, String s){
        return personasList.stream().filter((A)->{
            return A.getNome().equals(n) && A.getCognome().equals(s);
        }).toList().getFirst();
    }
    private static Persona getPersonaByNumber(String n){
        return personasList.stream().filter((A)->{
            return A.getTelefono().equals(n);
        }).toList().getFirst();
    }
    
    public static LinkedList<Persona> getPersonasList() {
        return personasList;
    }
    public static LinkedList<String> getPersonaStringList(){
        return personasStringList;
    }
    public static void remove(String l){
        int indx = personasStringList.indexOf(l);
        personasList.remove(indx);
        personasStringList.remove(indx);
    }

}
