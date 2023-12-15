package laura.gallace.entities;

import laura.gallace.entities.enums.Periodicità;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_elementobibliotecario")
public abstract class ElementoBibliotecario {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true, name = "codice_isbn")
    private String codiceISBN;
    @Column(name = "titolo")
    private String Titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;


    public ElementoBibliotecario() {

    }

    public ElementoBibliotecario(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
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
        return "ElementoBibliotecario{" +
                "id=" + id +
                ", Titolo='" + Titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}