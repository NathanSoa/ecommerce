package br.com.nathan.ecommerce.main.modules.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AddressEntity, Long> {
}