package com.example.ruleengine.model;

public class ASTNode {
    private String type;      // "operator" or "operand"
    private ASTNode left;
    private ASTNode right;
    private Object value;     // used for operand nodes

    public ASTNode(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    // Getters and setters
    // toString method for debugging
}
