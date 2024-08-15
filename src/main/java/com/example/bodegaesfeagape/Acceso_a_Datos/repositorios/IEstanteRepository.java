package com.example.bodegaesfeagape.Acceso_a_Datos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;

public interface IEstanteRepository  extends JpaRepository<Estante, Integer>{

}
