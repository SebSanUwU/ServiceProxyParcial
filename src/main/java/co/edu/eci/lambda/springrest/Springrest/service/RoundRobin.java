package co.edu.eci.lambda.springrest.Springrest.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class RoundRobin {
    private final String[] DOMAIN = new String[]{"ec2-18-208-185-105.compute-1.amazonaws.com", "ec2-18-232-81-111.compute-1.amazonaws.com"};
    public int currentServiceNum;
    public RoundRobin() {
        this.currentServiceNum = 0;
    }

    public Object responseRobin(String list,String value,String search) throws IOException {
        String currentService = DOMAIN[this.currentServiceNum];
        URL obj = new URL(currentService+"/"+search);
        System.out.println(currentService);
        nextService();
        return currentService;
    }

    private void nextService(){
        currentServiceNum +=1;
        if (currentServiceNum> DOMAIN.length-1){
            currentServiceNum = 0;
        }

    }
}
