package com.folautech.java;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private long              id;
    private String            firstName;
    private String            lastName;
    private String            email;
    private String            phoneNumber;
}
