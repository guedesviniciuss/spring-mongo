package com.example.mongo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    private String country;
    private String postCode;
    private String city;
}
