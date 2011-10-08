//Create by Conan. E-mail:bsspirit@gmail.com
package com.q24.bea.web;

import com.q24.bea.model.ProdDTO;

/**
 * This is ProdForm Form Model
 * @author Conan Zhang
 * @date 2011-09-22
 */
public class ProdForm extends ProdDTO {

public ProdForm(){}
public ProdForm(ProdDTO dto){
super.setId(dto.getId());
super.setCatid(dto.getCatid());
super.setTitle(dto.getTitle());
super.setContent(dto.getContent());
super.setImage_url(dto.getImage_url());
super.setDescription(dto.getDescription());
super.setCreate_date(dto.getCreate_date());
}


}
