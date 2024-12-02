
package com.sgb.bac.repository;

import com.sgb.bac.entity.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaBancaria, Long> {
}
