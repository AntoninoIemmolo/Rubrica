
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Persistance {
    private final String path;
    public Persistance(String filePath){
        this.path = filePath;
    }

    public void loadSaves(){
        File file = new File(path);
        Scanner scan=null;
        String [] s = null;
        try {
            scan=new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }
        while (scan.hasNext()) { 
            s = scan.nextLine().split(";");
            Persona p = Rubrica.addPerona(s[0], s[1], s[2], s[3], s[4]);
            App.addPersonaUI(p.toString());
        }
        scan.close();
    }

}
