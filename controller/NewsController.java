package com.work.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.work.domain.News;
import com.work.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/news")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, HttpServletRequest request) {
        Page<News> page = new Page<>();
        Page<News> news = newsService.findNews(page);
        model.addObject("page", news);
        model.setViewName("news/newsList");
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewNews(@PathVariable Integer id,ModelAndView model, HttpServletRequest request) {
        News news = newsService.findById(id);
        model.addObject("news", news);
        model.setViewName("news/newsDetail");
        return model;
    }

}
