package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;

public class UpdateIntervaloBienRequest  implements Serializable {
    private int bien_intervalo;

    public int getBien_intervalo() {
        return bien_intervalo;
    }

    public void setBien_intervalo(int bien_intervalo) {
        this.bien_intervalo = bien_intervalo;
    }
}
