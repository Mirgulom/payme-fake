package com.example.mobilebanking;

public class Service {
    private String name;     // название
    private int Id;
    private int serviceResource; // ресурс флага

    public Service(String name,  int service){

        this.name=name;
        this.serviceResource=service;
    }

    public String getName() {    return this.name;}

    public void setName(String name) {  this.name = name;  }

    public int getServiceResource() {  return this.serviceResource;   }

    public void setServiceResource(int serviceResource)
    { this.serviceResource = serviceResource; }

}
