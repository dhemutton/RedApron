/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.restful.datamodel;

import entity.Category;

/**
 *
 * @author MX
 */
public class CreateCategoryRsp {
    private Category category;

    public CreateCategoryRsp() {
    }

    public CreateCategoryRsp(Category category) {
        this.category = category;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
