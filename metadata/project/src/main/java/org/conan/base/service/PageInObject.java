package org.conan.base.service;

import org.conan.base.BaseObject;

/**
 * 
 * @author ConanZhang
 * 
 * @date: 2010-10-11
 */
public class PageInObject extends BaseObject {

    private static final long serialVersionUID = -1999232071982352916L;

    private int pgBegin;
    private int pgSize;
    private String pgIndex;
    private String pgSort;

    public PageInObject() {
        this(0, 10, "id", "asc");
    }

    public PageInObject(int pgBegin, int pgSize) {
        this.pgBegin = pgBegin;
        this.pgSize = pgSize;
    }

    public PageInObject(int pgBegin, int pgSize, String pgIndex, String pgSort) {
        this.pgBegin = pgBegin;
        this.pgSize = pgSize;
        this.pgIndex = pgIndex;
        this.pgSort = pgSort;
    }

    public int getPgBegin() {
        return pgBegin;
    }

    public void setPgBegin(int pgBegin) {
        this.pgBegin = pgBegin;
    }

    public int getPgSize() {
        return pgSize;
    }

    public void setPgSize(int pgSize) {
        this.pgSize = pgSize;
    }

    public String getPgIndex() {
        return pgIndex;
    }

    public void setPgIndex(String pgIndex) {
        this.pgIndex = pgIndex;
    }

    public String getPgSort() {
        return pgSort;
    }

    public void setPgSort(String pgSort) {
        this.pgSort = pgSort;
    }

    public int getEnd() {
        return this.pgBegin + this.pgSize;
    }
}
