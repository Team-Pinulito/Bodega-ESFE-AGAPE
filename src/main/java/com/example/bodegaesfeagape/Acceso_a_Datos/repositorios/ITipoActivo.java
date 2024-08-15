package com.example.bodegaesfeagape.Acceso_a_Datos.repositorios;

import com.example.bodegaesfeagape.Entidades_de_Negocio.TipoActivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoActivo extends JpaRepository<TipoActivo, Integer> {
}
