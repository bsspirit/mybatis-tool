package org.conan.base.service;

import org.conan.base.BaseObject;

/**
 * 
 * @author ConanZhang
 * 
 * @date: 2010-10-11
 */
public class PageBtnsObject extends BaseObject {

    private static final long serialVersionUID = -7006368777772636980L;
    private PageBtnObject first = new PageBtnObject("first", "首页");
    private PageBtnObject previous = new PageBtnObject("previous", "上一页");
    private PageBtnObject next = new PageBtnObject("next", "下一页");
    private PageBtnObject last = new PageBtnObject("last", "末页");
    private PageBtnObject btn1 = new PageBtnObject("btn1", "1");
    private PageBtnObject btn2 = new PageBtnObject("btn2", "2");
    private PageBtnObject btn3 = new PageBtnObject("btn3", "3");
    private PageBtnObject btn4 = new PageBtnObject("btn4", "4");
    private PageBtnObject btn5 = new PageBtnObject("btn5", "5");

    public PageBtnsObject(PageOutObject page) {
        first.setValue(page.getFirstPage());
        previous.setValue(page.getPreviousPage());
        next.setValue(page.getNextPage());
        last.setValue(page.getLastPage());

        switch (page.getPageCount()) {
        case 0:
        case 1:
            break;
        case 2:
            configBtn(page);
            btn1.setLvr("1", 1, true);
            btn2.setLvr("2", 2, true);
            break;
        case 3:
            configBtn(page);
            btn1.setLvr("1", 1, true);
            btn2.setLvr("2", 2, true);
            btn3.setLvr("3", 3, true);
            break;
        case 4:
            configBtn(page);
            btn1.setLvr("1", 1, true);
            btn2.setLvr("2", 2, true);
            btn3.setLvr("3", 3, true);
            btn4.setLvr("4", 4, true);
            break;
        default:
            // greater equals 5
            configBtn(page);
            ge5(page);
            break;
        }
    }

    private void configBtn(PageOutObject page) {
        if (page.getPageNow() == 1) {
            next.setRender(true);
            last.setRender(true);

        } else if (page.getPageNow() == page.getLastPage()) {
            first.setRender(true);
            previous.setRender(true);
        } else {
            first.setRender(true);
            previous.setRender(true);
            next.setRender(true);
            last.setRender(true);
        }
    }

    private void ge5(PageOutObject page) {
        if (page.getPageNow() <= 3) {
            btn1.setLvr("1", 1, true);
            btn2.setLvr("2", 2, true);
            btn3.setLvr("3", 3, true);
            btn4.setLvr("4", 4, true);
            btn5.setLvr("5", 5, true);
        } else if (page.getPageNow() >= page.getPageCount() - 2) {
            btn1.setLvr(page.getPageCount() - 4 + "", page.getPageCount() - 4, true);
            btn2.setLvr(page.getPageCount() - 3 + "", page.getPageCount() - 3, true);
            btn3.setLvr(page.getPageCount() - 2 + "", page.getPageCount() - 2, true);
            btn4.setLvr(page.getPageCount() - 1 + "", page.getPageCount() - 1, true);
            btn5.setLvr(page.getPageCount() + "", page.getPageCount(), true);
        } else {
            btn1.setLvr(page.getPageNow() - 2 + "", page.getPageNow() - 2, true);
            btn2.setLvr(page.getPageNow() - 1 + "", page.getPageNow() - 1, true);
            btn3.setLvr(page.getPageNow() + "", page.getPageNow(), true);
            btn4.setLvr(page.getPageNow() + 1 + "", page.getPageNow() + 1, true);
            btn5.setLvr(page.getPageNow() + 2 + "", page.getPageNow() + 2, true);
        }
    }

    public PageBtnObject getBtn1() {
        return btn1;
    }

    public PageBtnObject getBtn2() {
        return btn2;
    }

    public PageBtnObject getBtn3() {
        return btn3;
    }

    public PageBtnObject getBtn4() {
        return btn4;
    }

    public PageBtnObject getBtn5() {
        return btn5;
    }

    public PageBtnObject getFirst() {
        return first;
    }

    public PageBtnObject getLast() {
        return last;
    }

    public PageBtnObject getNext() {
        return next;
    }

    public PageBtnObject getPrevious() {
        return previous;
    }
}
