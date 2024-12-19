package com.infopulse.web.rest.errors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import tech.jhipster.web.rest.errors.ProblemDetailWithCause;

public class ConstraintViolationException extends ErrorResponseException {

    private static final long serialVersionUID = 1L;

    public ConstraintViolationException(String defaultMessage, String entityName, String errorKey) {
        super(
            HttpStatus.CONFLICT,
            ProblemDetailWithCause.ProblemDetailWithCauseBuilder.instance()
                .withStatus(HttpStatus.CONFLICT.value())
                .withType(ErrorConstants.DEFAULT_TYPE)
                .withDetail(defaultMessage)
                .withTitle(defaultMessage)
                .withProperty("message", "error." + errorKey)
                .withProperty("params", entityName)
                .build(),
            null
        );
    }
    //    private String formatConstraintViolationMessage(String message) {
    //        if (message == null) {
    //            return "Detalhes indisponíveis.";
    //        }
    //
    //        if (message.contains("violates foreign key constraint")) {
    //            String[] parts = message.split("\"");
    //            if (parts.length > 3) {
    //                return "Tabela referenciada: " + parts[3] + ", Chave violada: " + parts[1];
    //            }
    //        }
    //        return message.replaceAll("[\\n\\r]", " ");
    //    }
    //
    //
    //    private String extractTableName(String errorMessage) {
    //        // O PostgreSQL inclui o nome da tabela referenciadora na mensagem de erro.
    //        // A mensagem normalmente terá o formato: "violação de chave estrangeira em tabela "nome_da_tabela""
    //        String[] parts = errorMessage.split("\"");
    //        if (parts.length > 3) {
    //            return parts[3]; // Retorna o nome da tabela que está fazendo a referência
    //        }
    //        return "desconhecida";
    //    }

}
