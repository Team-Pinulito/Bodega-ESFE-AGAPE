package com.example.bodegaesfeagape.Acceso_a_Datos.repositorios;

import com.example.bodegaesfeagape.Entidades_de_Negocio.AjusteInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAjusteInventarioRepository extends JpaRepository<AjusteInventario, Integer> {
}
