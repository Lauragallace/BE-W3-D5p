package laura.gallace.dao;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_elementobibliotecario")
@NamedQuery(name = "ricercaElementoBibliotecarioPerISBN",query = "SELECT l FROM ElementoBibliotecario l WHERE l.codiceISBN = :codiceISBN")
@NamedQuery(name = "ricercaElementoBibliotecarioPerAnnoPubblicazione",query = "SELECT l FROM ElementoBibliotecario l WHERE l.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "ricercaElementoBibliotecarioPerTitoloOparte",query = "SELECT l FROM ElementoBibliotecario l WHERE l.titolo LIKE CONCAT('%', :titolo, '%')")
public class ElementoBibliotecarioDAO {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, name = "codice_isbn")
    private String codiceISBN;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;
    public void ElementoBibliotecario() {
    }

    public void ElementoBibliotecario(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", Titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine;
    }
}

