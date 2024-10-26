package com.example.ruleengine.controller;

import com.example.ruleengine.model.ASTNode;
import com.example.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @PostMapping("/create")
    public ASTNode createRule(@RequestBody String ruleString) {
        return ruleService.createRule(ruleString);
    }

    @PostMapping("/combine")
    public ASTNode combineRules(@RequestBody List<String> ruleStrings) {
        List<ASTNode> rules = ruleStrings.stream()
                .map(ruleService::createRule)
                .toList();
        return ruleService.combineRules(rules);
    }

    @PostMapping("/evaluate")
    public boolean evaluateRule(@RequestBody Map<String, Object> data) {
        // Load AST from repository or predefined rules
        ASTNode rule = ruleService.createRule("(age > 30 AND department = 'Sales')");
        return ruleService.evaluateRule(rule, data);
    }
}
