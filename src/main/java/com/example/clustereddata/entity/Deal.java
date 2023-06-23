package com.example.clustereddata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "deals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_unique_id")
    private String dealUniqueId;

    @Column(name = "from_currency_iso_code")
    @Pattern(regexp = "[A-Z]{3}")
    private String fromCurrencyIsoCode;

    @Column(name = "to_currency_iso_code")
    @Pattern(regexp = "[A-Z]{3}")
    private String toCurrencyIsoCode;

    @Column(name = "deal_timestamp")
    private Timestamp dealTimestamp;

    @Column(name = "deal_amount")
    private BigDecimal dealAmount;

}

