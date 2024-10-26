package com.example.ruleengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ruleengine.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {}
