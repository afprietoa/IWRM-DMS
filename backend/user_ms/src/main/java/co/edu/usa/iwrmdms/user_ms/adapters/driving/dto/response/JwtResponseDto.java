package co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response;

public class JwtResponseDto {
    private String token;

    public JwtResponseDto(){

    }
    public JwtResponseDto(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
