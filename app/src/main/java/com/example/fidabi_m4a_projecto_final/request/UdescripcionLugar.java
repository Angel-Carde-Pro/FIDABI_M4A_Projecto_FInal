package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;

public class UdescripcionLugar implements Serializable {
        private String bien_codigoG;
        private String bien_descripcion_lugar;

        public UdescripcionLugar(String bien_codigoG, String bien_descripcion_lugar) {
            this.bien_codigoG = bien_codigoG;
            this.bien_descripcion_lugar = bien_descripcion_lugar;
        }

        public String getBien_codigoG() {
            return bien_codigoG;
        }

        public void setBien_codigoG(String bien_codigoG) {
            this.bien_codigoG = bien_codigoG;
        }

        public String getBien_descripcion_lugar() {
            return bien_descripcion_lugar;
        }

        public void setBien_descripcion_lugar(String bien_descripcion_lugar) {
            this.bien_descripcion_lugar = bien_descripcion_lugar;
        }

        @Override
        public String toString() {
            return "UdescripcionLugar{" +
                    "bien_codigoG='" + bien_codigoG + '\'' +
                    ", bien_descripcion_lugar='" + bien_descripcion_lugar + '\'' +
                    '}';
        }
    }


