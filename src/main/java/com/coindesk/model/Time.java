package com.coindesk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 * {@link Data} @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor in one @Data annotation
 * {@link JsonIgnoreProperties} Annotation ignores processing of JSON properties
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Time {

    private String updated;



}
