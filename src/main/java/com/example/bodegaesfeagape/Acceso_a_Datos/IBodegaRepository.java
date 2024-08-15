package com.example.bodegaesfeagape.Acceso_a_Datos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Bodega;

public interface IBodegaRepository extends JpaRepository<Bodega, Integer>{

}
