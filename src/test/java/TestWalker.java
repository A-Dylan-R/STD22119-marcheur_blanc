import org.marcheur.Location;
import org.marcheur.Map;
import org.marcheur.Walker;

import java.util.List;

public class TestWalker {
    public static void main(String[] args) {
        Map map = new Map();
        map.addLocation("HEI");
        map.addLocation("Pullman");
        map.addLocation("Balancoire");
        map.addLocation("ESTI");
        map.addLocation("Sekolintsika");
        map.addLocation("Marais");
        map.addLocation("Boulevard de l'Europe");
        map.addLocation("Nexta");

        map.addStreet("HEI", "Pullman");
        map.addStreet("HEI", "Sekolintsika");
        map.addStreet("Sekolintsika", "Marais");
        map.addStreet("Pullman", "Balancoire");
        map.addStreet("Pullman", "Nexta");
        map.addStreet("Balancoire", "ESTI");
        map.addStreet("Balancoire", "Boulevard de l'Europe");
        map.addStreet("Boulevard de l'Europe", "ESTI");

        Walker walker = new Walker(map);

        try {
            List<Location> path = walker.walk("HEI", "ESTI");

            assert path.get(0).getName().equals("HEI") : "Le chemin doit commencer à HEI";
            assert path.get(path.size() - 1).getName().equals("ESTI") : "Le chemin doit se terminer à ESTI";

            System.out.println("Chemin trouvé : ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).getName());
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
