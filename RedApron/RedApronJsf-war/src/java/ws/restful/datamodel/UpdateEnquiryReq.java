/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.restful.datamodel;

import entity.Enquiry;

/**
 *
 * @author MX
 */
public class UpdateEnquiryReq {
    private Enquiry enquiry;

    public UpdateEnquiryReq() {
    }

    public UpdateEnquiryReq(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    /**
     * @return the enquiry
     */
    public Enquiry getEnquiry() {
        return enquiry;
    }

    /**
     * @param enquiry the enquiry to set
     */
    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }
    
    
}
