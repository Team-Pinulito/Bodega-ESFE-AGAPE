package com.example.bodegaesfeagape.Acceso_a_Datos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;


public interface IActivoRepository extends JpaRepository<Activo, Integer>{

}
