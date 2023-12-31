package com.example.fidabi_m4a_projecto_final.request;
import java.io.Serializable;
import java.util.List;

public class FechaBienResponse implements Serializable  {

        private int bien_cod;
        private String bien_codigoG;
        private String bien_descripcion;
        private String bien_detalles;
        private String bien_estado;
        private boolean bien_estadoA;
        private boolean bien_estado_asignado;
        private String bien_fecha_consta;
        private int bien_intervalo;
        private String bien_marca;
        private String bien_modelo;
        private int bien_precio;
        private String bien_serie;
        private Categoria categoria;
        private Propietario propietario;
        private Ubicacion ubicacion;
        private Usuario usuario;

        public int getBien_cod() {
            return bien_cod;
        }

        public void setBien_cod(int bien_cod) {
            this.bien_cod = bien_cod;
        }

        public String getBien_codigoG() {
            return bien_codigoG;
        }

        public void setBien_codigoG(String bien_codigoG) {
            this.bien_codigoG = bien_codigoG;
        }

        public String getBien_descripcion() {
            return bien_descripcion;
        }

        public void setBien_descripcion(String bien_descripcion) {
            this.bien_descripcion = bien_descripcion;
        }

        public String getBien_detalles() {
            return bien_detalles;
        }

        public void setBien_detalles(String bien_detalles) {
            this.bien_detalles = bien_detalles;
        }

        public String getBien_estado() {
            return bien_estado;
        }

        public void setBien_estado(String bien_estado) {
            this.bien_estado = bien_estado;
        }

        public boolean isBien_estadoA() {
            return bien_estadoA;
        }

        public void setBien_estadoA(boolean bien_estadoA) {
            this.bien_estadoA = bien_estadoA;
        }

        public boolean isBien_estado_asignado() {
            return bien_estado_asignado;
        }

        public void setBien_estado_asignado(boolean bien_estado_asignado) {
            this.bien_estado_asignado = bien_estado_asignado;
        }

        public String getBien_fecha_consta() {
            return bien_fecha_consta;
        }

        public void setBien_fecha_consta(String bien_fecha_consta) {
            this.bien_fecha_consta = bien_fecha_consta;
        }

        public int getBien_intervalo() {
            return bien_intervalo;
        }

        public void setBien_intervalo(int bien_intervalo) {
            this.bien_intervalo = bien_intervalo;
        }

        public String getBien_marca() {
            return bien_marca;
        }

        public void setBien_marca(String bien_marca) {
            this.bien_marca = bien_marca;
        }

        public String getBien_modelo() {
            return bien_modelo;
        }

        public void setBien_modelo(String bien_modelo) {
            this.bien_modelo = bien_modelo;
        }

        public int getBien_precio() {
            return bien_precio;
        }

        public void setBien_precio(int bien_precio) {
            this.bien_precio = bien_precio;
        }

        public String getBien_serie() {
            return bien_serie;
        }

        public void setBien_serie(String bien_serie) {
            this.bien_serie = bien_serie;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        public Propietario getPropietario() {
            return propietario;
        }

        public void setPropietario(Propietario propietario) {
            this.propietario = propietario;
        }

        public Ubicacion getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(Ubicacion ubicacion) {
            this.ubicacion = ubicacion;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public static class Categoria {
            private int cat_cod;
            private String cat_descripcion;
            private boolean cat_estado;
            private String cat_nombre;

            public int getCat_cod() {
                return cat_cod;
            }

            public void setCat_cod(int cat_cod) {
                this.cat_cod = cat_cod;
            }

            public String getCat_descripcion() {
                return cat_descripcion;
            }

            public void setCat_descripcion(String cat_descripcion) {
                this.cat_descripcion = cat_descripcion;
            }

            public boolean isCat_estado() {
                return cat_estado;
            }

            public void setCat_estado(boolean cat_estado) {
                this.cat_estado = cat_estado;
            }

            public String getCat_nombre() {
                return cat_nombre;
            }

            public void setCat_nombre(String cat_nombre) {
                this.cat_nombre = cat_nombre;
            }
        }

        public static class Propietario {
            private int pro_cod;
            private String pro_direccion;
            private boolean pro_estado;
            private String pro_nombre;
            private String pro_telefono;

            public int getPro_cod() {
                return pro_cod;
            }

            public void setPro_cod(int pro_cod) {
                this.pro_cod = pro_cod;
            }

            public String getPro_direccion() {
                return pro_direccion;
            }

            public void setPro_direccion(String pro_direccion) {
                this.pro_direccion = pro_direccion;
            }

            public boolean isPro_estado() {
                return pro_estado;
            }

            public void setPro_estado(boolean pro_estado) {
                this.pro_estado = pro_estado;
            }

            public String getPro_nombre() {
                return pro_nombre;
            }

            public void setPro_nombre(String pro_nombre) {
                this.pro_nombre = pro_nombre;
            }

            public String getPro_telefono() {
                return pro_telefono;
            }

            public void setPro_telefono(String pro_telefono) {
                this.pro_telefono = pro_telefono;
            }
        }

        public static class Ubicacion {
            private int ubi_cod;
            private String ubi_departamento;
            private boolean ubi_estado;
            private String ubi_nombre;

            // Getters y setters
            // ...
        }

        public static class Usuario {
            private String contrasenia;
            private Persona persona;
            private List<Rol> roles;
            private int usu_cod;
            private boolean usu_estado;
            private String usuario;

            public void setContrasenia(String contrasenia) {
                this.contrasenia = contrasenia;
            }

            public void setPersona(Persona persona) {
                this.persona = persona;
            }

            public void setRoles(List<Rol> roles) {
                this.roles = roles;
            }

            public void setUsu_cod(int usu_cod) {
                this.usu_cod = usu_cod;
            }

            public void setUsu_estado(boolean usu_estado) {
                this.usu_estado = usu_estado;
            }

            public void setUsuario(String usuario) {
                this.usuario = usuario;
            }

            public static class Persona {
                private String perApellidoMater;
                private String perApellidoPater;
                private String perCedula;
                private int perCod;
                private String perEmail;
                private String perFechaNac;
                private String perGenero;
                private String perPrimerNom;
                private String perSegundoNom;
                private String perTelefono;

                public void setPerApellidoMater(String perApellidoMater) {
                    this.perApellidoMater = perApellidoMater;
                }

                public void setPerApellidoPater(String perApellidoPater) {
                    this.perApellidoPater = perApellidoPater;
                }

                public void setPerCedula(String perCedula) {
                    this.perCedula = perCedula;
                }

                public void setPerCod(int perCod) {
                    this.perCod = perCod;
                }

                public void setPerEmail(String perEmail) {
                    this.perEmail = perEmail;
                }

                public void setPerFechaNac(String perFechaNac) {
                    this.perFechaNac = perFechaNac;
                }

                public void setPerGenero(String perGenero) {
                    this.perGenero = perGenero;
                }

                public void setPerPrimerNom(String perPrimerNom) {
                    this.perPrimerNom = perPrimerNom;
                }

                public void setPerSegundoNom(String perSegundoNom) {
                    this.perSegundoNom = perSegundoNom;
                }

                public void setPerTelefono(String perTelefono) {
                    this.perTelefono = perTelefono;
                }
            }

            public static class Rol {
                private int rol_cod;
                private boolean rol_estado;
                private String rol_nombre;

                // Getters y setters
                // ...
            }
        }

        // Getters y setters
        // ...
    }


