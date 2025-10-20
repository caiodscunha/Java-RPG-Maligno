package org.example.models.inventario;

public class Inventario implements Cloneable{



    //TODO: Implementar clone
    @Override
    public Inventario clone() {
        try {
            return (Inventario) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
