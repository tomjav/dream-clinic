package pl.tgrzybowski.dreamclinic.Security;

import java.io.Serializable;

public class TokenResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TokenResponse(String token) {

        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private final String token;

}
