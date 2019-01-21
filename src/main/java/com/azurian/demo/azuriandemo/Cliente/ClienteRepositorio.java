package com.azurian.demo.azuriandemo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
