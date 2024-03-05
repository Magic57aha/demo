package com.example.firstspringboot.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code羊
 * @date 2024/1/31 16 48
 * discription
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setpagination(Integer totalPage, Integer page, Integer size) {
        this.totalPage = totalPage;
        // 边界检查
        if (page < 1) page = 1;
        if (page > totalPage) page = totalPage;
        this.page = page;
        // 页码列表
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            // 前插三页
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            // 后插三页
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        // 是否展示上一页跳转
        if (page == 1) {
            showPrevious = false;
        } else showPrevious = true;
        // 是否展示下一页跳转
        if (page == totalPage) {
            showNext = false;
        } else showNext = true;
        // 是否展示首页跳转
        if (pages.contains(1)) {
            showFirstPage = false;
        } else showFirstPage = true;
        // 是否展示尾页跳转
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else showEndPage = true;
    }
}
