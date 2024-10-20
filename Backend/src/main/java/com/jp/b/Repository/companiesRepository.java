package com.jp.b.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.b.Entity.companies;

public interface companiesRepository extends JpaRepository<companies, Long> {

}
