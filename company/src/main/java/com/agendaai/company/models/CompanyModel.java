package com.agendaai.company.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_COMPANIES")
public class CompanyModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID companyID;
    private String companyName;
    private String companyCep;
    private String companyCnpj;
    private String companyEmail;
    private String companyTelNumber;
    private double companyReview;
    private int companyQtdReview;
    private ArrayList<String> companySocialLinks;

    public static long getSerialversionuid(){
        return serialVersionUID;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public UUID getCompanyID() {
        return companyID;
    }

    public void setCompanyID(UUID companyID) {
        this.companyID = companyID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCep() {
        return companyCep;
    }

    public void setCompanyCep(String companyCep) {
        this.companyCep = companyCep;
    }

    public String getCompanyCnpj() {
        return companyCnpj;
    }

    public void setCompanyCnpj(String companyCnpj) {
        this.companyCnpj = companyCnpj;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyTelNumber() {
        return companyTelNumber;
    }

    public void setCompanyTelNumber(String companyTelNumber) {
        this.companyTelNumber = companyTelNumber;
    }

    public ArrayList<String> getCompanySocialLinks() {
        return companySocialLinks;
    }

    public void setCompanySocialLinks(ArrayList<String> socialLinks) {
        this.companySocialLinks = socialLinks;
    }

    public double getCompanyReview() {
        return companyReview/getCompanyQtdReview();
    }

    public void setCompanyReview(double companyReview) {
        this.companyReview = companyReview;
    }

    public int getCompanyQtdReview() {
        return companyQtdReview;
    }

    public void setCompanyQtdReview(int companyQtdReview) {
        this.companyQtdReview = companyQtdReview;
    }
    
}
