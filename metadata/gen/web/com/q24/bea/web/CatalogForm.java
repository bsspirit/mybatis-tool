//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bea.web;

import com.q24.bea.model.CatalogDTO;

/**
 * This is CatalogForm Form Model
 * @author Conan Zhang
 * @date 2011-09-22
 */
public class CatalogForm extends CatalogDTO {

public CatalogForm(){}
public CatalogForm(CatalogDTO dto){
super.setId(dto.getId());
super.setName(dto.getName());
}


}
