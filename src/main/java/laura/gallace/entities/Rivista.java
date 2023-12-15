package laura.gallace.entities;

import laura.gallace.entities.enums.Periodicità;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rivista")
@DiscriminatorValue("rivista")
public class Rivista extends ElementoBibliotecario {
    private Periodicità periodicità;
    public Rivista(){
}

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                '}';
    }
}
