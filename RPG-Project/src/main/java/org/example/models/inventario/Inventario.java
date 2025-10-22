package org.example.models.inventario;

import java.io.Serializable;

public class Inventario implements Cloneable, Serializable {



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
