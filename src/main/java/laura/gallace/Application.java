package laura.gallace;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_bibliotecario");
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
