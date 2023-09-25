package br.com.heinzenberg.heinzenberg.entities;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Register {
    private UUID id;
    private LocalDate date;
    private String local;
    private Boolean feedback;
    private int brandId;
    private int productSku;
    private int qtd_comment;

    private List<String> goals;

    public Register() {
    }

    public Register(RegisterRequest registerRequest) {
        this.id = UUID.randomUUID();
        this.date = LocalDate.parse(registerRequest.date());
        this.local = registerRequest.local();
        this.feedback = registerRequest.feedback();
        this.productSku = registerRequest.productSku();
        this.brandId = registerRequest.brandId();
        this.goals = registerRequest.goals();
        this.qtd_comment = registerRequest.qtd_comment();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocal() {
        return local;
    }

    public Boolean getFeedback() {
        return feedback;
    }

    public int getBrandId() {
        return brandId;
    }

    public int getProductSku() {
        return productSku;
    }

    public List<String> getGoals() {
        return goals;
    }

    public int getQtd_comment() {
        return qtd_comment;
    }
}
