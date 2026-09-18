package com.expertsoft.phoneshop.persistence.repository;

import com.expertsoft.phoneshop.persistence.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("select p from Phone p where (:name is null or :name = ''" +
            "            or lower(p.brand) like lower(concat('%', :name, '%'))" +
            "            or lower(p.model) like lower(concat('%', :name, '%')))" +
            "                and (:fromPrice is null or p.price >= :fromPrice)" +
            "                and (:toPrice is null or p.price <= :toPrice)")
    Page<Phone> searchByParameters(
            Pageable pageable,
            String name,
            BigDecimal fromPrice,
            BigDecimal toPrice);
}
