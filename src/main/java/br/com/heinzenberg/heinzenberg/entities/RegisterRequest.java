package br.com.heinzenberg.heinzenberg.entities;

import java.time.LocalDate;
import java.util.List;

public record RegisterRequest(String date,
                              String local, Boolean feedback, int productSku, int brandId, int qtd_comment,
                              List<String> goals) {
}
