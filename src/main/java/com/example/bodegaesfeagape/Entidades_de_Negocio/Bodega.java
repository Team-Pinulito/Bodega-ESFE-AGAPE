package com.example.bodegaesfeagape.Entidades_de_Negocio;

@Entity
@Table(name = "bodegas")
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
