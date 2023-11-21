package com.acmepetsupplies.productcatalog;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.model.Request;
import com.atlassian.oai.validator.report.JsonValidationReportFormat;
import com.atlassian.oai.validator.report.ValidationReport;
import com.atlassian.oai.validator.restassured.RestAssuredRequest;
import com.atlassian.oai.validator.restassured.RestAssuredResponse;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.Objects;

import static com.atlassian.oai.validator.util.StringUtils.requireNonEmpty;

public class ResponseOnlyValidationFilter implements Filter {

    private final OpenApiInteractionValidator validator;

    public ResponseOnlyValidationFilter(final String specUrlOrDefinition) {
        requireNonEmpty(specUrlOrDefinition, "A spec is required");

        validator = OpenApiInteractionValidator.createFor(specUrlOrDefinition).build();
    }

    public ResponseOnlyValidationFilter(final OpenApiInteractionValidator validator) {
        Objects.requireNonNull(validator, "A validator is required");

        this.validator = validator;
    }

    @Override
    public Response filter(final FilterableRequestSpecification requestSpec,
                           final FilterableResponseSpecification responseSpec,
                           final FilterContext ctx) {

        final Response response = ctx.next(requestSpec, responseSpec);

        Request request = RestAssuredRequest.of(requestSpec);
        final ValidationReport validationReport =
                validator.validateResponse(request.getPath(), request.getMethod(), RestAssuredResponse.of(response));

        if (validationReport.hasErrors()) {
            throw new com.atlassian.oai.validator.restassured.OpenApiValidationFilter.OpenApiValidationException(validationReport);
        }

        return response;
    }

    public static class OpenApiValidationException extends RuntimeException {
        private final ValidationReport report;

        public OpenApiValidationException(final ValidationReport report) {
            super(JsonValidationReportFormat.getInstance().apply(report));
            this.report = report;
        }

        /**
         * @return The validation report that generating this exception
         */
        public ValidationReport getValidationReport() {
            return report;
        }
    }
}
