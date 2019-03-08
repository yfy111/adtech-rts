package com.adtech.rts.page;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页
 */
@Component
public class PageForList {

    /**
     * 对list进行内存分页
     *
     * @param t
     * @param pageSize
     * @param pageNum
     * @param <T>
     * @return
     */
    public <T> Page pageList(List<T> t, Integer pageSize, Integer pageNum) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setTotalCount(t.size());

        //分页参数参数计算
//        t.add(null);
        int limit = pageSize * pageNum;
        if (limit == 0) limit = 5;
        int bgin = limit - pageSize;
        if (page.getTotalCount() < limit) {
            limit = t.size() - 1;
            if (page.getTotalCount() == 1) limit = 1;
        }
        if (bgin < 0 || bgin > page.getTotalCount()) {
            bgin = 0;
        }
        //分页截取数据集
        if(t.isEmpty()) page.setList(t);
        else page.setList(t.subList(bgin, limit));
        return page;
    }
}
