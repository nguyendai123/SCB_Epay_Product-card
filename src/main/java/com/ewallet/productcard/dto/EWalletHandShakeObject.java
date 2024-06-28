package com.ewallet.productcard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EWalletHandShakeObject {
    @JsonProperty("LanguageID")
    private String languageID;

    @JsonProperty("RefNumber")
    private String refNumber;

    @JsonProperty("PINPublicKeyExponent")
    private String pinPublicKeyExponent;

    @JsonProperty("PINPublicKeyModulus")
    private String pinPublicKeyModulus;

    @JsonProperty("DESKey")
    private String desKey;
}
