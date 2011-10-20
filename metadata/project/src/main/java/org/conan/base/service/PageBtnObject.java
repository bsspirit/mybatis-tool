package org.conan.base.service;

import org.conan.base.BaseObject;

/**
 * 
 * @author ConanZhang
 * 
 * @date: 2010-10-11
 */
public class PageBtnObject extends BaseObject {

    private static final long serialVersionUID = -2968032840143903790L;

    public PageBtnObject() {
    }

    public PageBtnObject(String name, String label) {
        this.name = name;
        this.label = label;
    }

    private String name;
    private String label;
    private int value = 0;
    private boolean render = false;

    public void setLvr(String label, int value, boolean render) {
        this.label = label;
        this.value = value;
        this.render = render;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
