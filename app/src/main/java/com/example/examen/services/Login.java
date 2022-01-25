package com.example.examen.services;


import com.example.examen.model.HttpDate;
import com.example.examen.services.utils.Config;
import com.example.examen.services.utils.HttpService;

public class Login {

    private String user;
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean saveToken(){

        boolean answer = false;

        HttpService httpService = new HttpService();
        String body = "{\n" +
                "  \"email\": \"brayanpablo@outlook.com\",\n" +
                "  \"password\": \"604258715\"\n" +
                "}";

        HttpDate httpDate = httpService.post(body, Config.URL+"/auth/login");

        if(httpDate.getStatusCode() == 200){
            saveDataBaseToken(getToken(httpDate.getBody()));
            answer = true;
        }
        return answer;
    }

    private String getToken(String body){
        return "";
    }

    private void saveDataBaseToken(String token){
        //save database token
    }

}
