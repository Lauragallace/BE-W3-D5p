package laura.gallace.dao;

import laura.gallace.entities.ElementoBibliotecario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ElementoBibliotecarioDAO {
    private final EntityManager em;

    public ElementoBibliotecarioDAO(EntityManager em) {
        this.em = em;
    }
    public void save(ElementoBibliotecario elementoBibliotecario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elementoBibliotecario);
        transaction.commit();
        System.out.println("ElementoBibliotecario" + elementoBibliotecario.getTitolo() + " aggiunto correttamente al database!");
    }

    public ElementoBibliotecario findById(long id) {
        return em.find(ElementoBibliotecario.class,id);
    }


    public void findByIdAndDelete(long id) {
        ElementoBibliotecario found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("ElementoBibliotecario" + found.getTitolo() + "rimosso correttamente dal database!");
        } else {
            System.out.println("ElementoBibliotecario con id " + id + " non trovato");
        }


    }

    public void findByISBNAndDelete(String isbn) {
        TypedQuery<ElementoBibliotecario> findByISBN = em.createQuery("SELECT l FROM ElementoBibliotecario l WHERE l.codiceISBN = :isbn",ElementoBibliotecario.class);
        findByISBN.setParameter("isbn",isbn);
      ElementoBibliotecario found = findByISBN.getSingleResult();
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("ElementoBibliotecario " + found.getTitolo() + " rimosso correttamente dal database!");
        } else {
            System.out.println("ElementoBibliotecario con isbn " + isbn + " non trovato");
        }
    }
}
