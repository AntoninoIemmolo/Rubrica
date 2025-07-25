
import java.util.LinkedList;

public class Rubrica {
    private static final LinkedList<Persona> personasList = new LinkedList<>();
    private static final LinkedList<String> personasStringList = new LinkedList<>();

    public static Persona addPerona(String n, String c, String i, String t, String e){
        if(n.equals("") || c.equals("") || i.equals("") || t.equals("") || e.equals(""))
            return null;
        Persona p = new Persona(n, c, i, t, Integer.parseInt(e));
        personasList.add(p);
        personasStringList.add(p.toStringMinInfo());
        return p;
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
    
    public static void remove(int index){
        personasList.remove(index);
        personasStringList.remove(index);
    }

    

}
