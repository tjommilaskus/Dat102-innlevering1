package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
    public T data;         // Dataen som noden holder (i vårt tilfelle Film)
    public LinearNode<T> neste; // Referanse til neste node i listen

    // Konstruktør
    public LinearNode(T data) {
        this.data = data;
        this.neste = null;
    }
}
