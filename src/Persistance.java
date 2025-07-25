
import java.io.File;
import java.util.Scanner;

public class Persistance {
    private String path;
    public Persistance(String filePath){
        this.path = filePath;
    }

    public void loadSaves(){
        File file = new File(path);
        Scanner scan=null;
        String [] s = null;
        try {
            scan=new Scanner(file);
        } catch (Exception e) {
            return;
        }
        while (scan.hasNext()) { 
            s = scan.nextLine().split(";");
            Persona p = Rubrica.addPerona(s[0], s[1], s[2], s[3], s[4]);
            App.addPersonaUI(p.toString());
        }
    }

}
