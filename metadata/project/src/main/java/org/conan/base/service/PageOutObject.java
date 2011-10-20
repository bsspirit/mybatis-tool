package org.conan.base.service;

import java.util.ArrayList;
import java.util.List;

import org.conan.base.BaseObject;

/**
 * 
 * @author ConanZhang
 * 
 * @date: 2010-10-11
 * @param <E>
 */
public class PageOutObject<E> extends BaseObject {
    private static final long serialVersionUID = -4186074274297349106L;

    public PageOutObject() {
    }

    public PageOutObject(int count, List<E> list, PageInObject inObj) {
        this.count = count;
        this.list = list;
        this.inObj = inObj;
    }

    private int count;
    private List<E> list;
    private PageInObject inObj;
    private PageBtnsObject pageBtns;

    public PageBtnsObject getPageBtns() {
        pageBtns = new PageBtnsObject(this);
        return pageBtns;
    }

    public int getCount() {
        return count;
    }

    public PageInObject getInObj() {
        return inObj;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list.clear();
        this.list = list;
    }

    /*-----------page function----------*/
    public int getItemBegin() {
        if (count == 0) {
            return 0;
        }
        return inObj.getPgBegin() + 1;
    }

    public int getItemEnd() {
        if (count < inObj.getEnd()) {
            return count;
        }
        return inObj.getEnd();
    }

    public int getPageSize() {
        return inObj.getPgSize();
    }

    public int getPageCount() {
        int tmp = count / inObj.getPgSize();
        if (count % inObj.getPgSize() == 0) {
            return tmp;
        }
        return (int) (Math.floor(tmp) + 1);
    }

    public int getPageNow() {
        if (getItemBegin() > count) {
            return getPageCount();
        }

        if (getItemBegin() == 0) { // 没有记录的情况
            return 0;
        }

        if (getItemBegin() < getPageSize()) { // 不足一页的情况
            return getFirstPage();
        } else {
            return (int) (Math.floor(getItemBegin() / getPageSize())) + 1;
        }
    }

    public int getFirstPage() {
        return 1;
    }

    public int getPreviousPage() {
        if (getPageNow() <= 1) {
            return getFirstPage();
        }
        return getPageNow() - 1;
    }

    public int getNextPage() {
        if (getPageNow() >= getLastPage()) {
            return getLastPage();
        }
        return getPageNow() + 1;
    }

    public int getLastPage() {
        return getPageCount();
    }

    public int getPageItem(int page) {
        return (page - 1) * getPageSize();
    }

    /*-----------page function----------*/
    public static void main(String[] args) {
        PageInObject inObj = new PageInObject(20, 10, "id", "asc");
        List list = new ArrayList(9);
        for (int i = 0; i < 107; i++) {
            list.add(i);
        }

        PageOutObject outObj = new PageOutObject(27, list, inObj);

        System.out.println("记录总数:" + outObj.count);
        System.out.println("开始记录:" + outObj.getItemBegin());
        System.out.println("结束记录:" + outObj.getItemEnd());

        System.out.println("页总数:" + outObj.getPageCount());
        System.out.println("页大小:" + outObj.getPageSize());
        System.out.println("当前页:" + outObj.getPageNow());

        System.out.print("首页:" + outObj.getFirstPage());
        System.out.print("上一页:" + outObj.getPreviousPage());
        System.out.print("下一页:" + outObj.getNextPage());
        System.out.println("末页:" + outObj.getLastPage());

        System.out.print("首页Item:" + outObj.getPageItem(outObj.getFirstPage()));
        System.out.print("上一页Item:" + outObj.getPageItem(outObj.getPreviousPage()));
        System.out.print("下一页Item:" + outObj.getPageItem(outObj.getNextPage()));
        System.out.println("末页Item:" + outObj.getPageItem(outObj.getLastPage()));

        PageBtnsObject btns = outObj.getPageBtns();
        System.out.println(btns.getBtn1());
        System.out.println(btns.getBtn2());
        System.out.println(btns.getBtn3());
        System.out.println(btns.getBtn4());
        System.out.println(btns.getBtn5());
        System.out.println(btns.getFirst());
        System.out.println(btns.getPrevious());
        System.out.println(btns.getNext());
        System.out.println(btns.getLast());

    }
}
