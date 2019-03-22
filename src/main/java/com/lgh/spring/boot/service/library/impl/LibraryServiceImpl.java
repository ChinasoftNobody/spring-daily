package com.lgh.spring.boot.service.library.impl;

import com.lgh.spring.boot.mongo.model.library.MBook;
import com.lgh.spring.boot.service.library.BookService;
import com.lgh.spring.boot.service.library.LibraryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Value("${sclib.query.url}")
    private String sclibUrl;
    @Resource
    private BookService bookService;

    @Override
    public Page<MBook> queryFromScLib(String keyword) {
        try {
            List<MBook> books = new ArrayList<>();
            Document doc = Jsoup.connect(sclibUrl).get();
            Elements form = doc.getElementsByTag("form");
            String searchUrl = form.attr("action") + "?func=find-b&find_code=WRD&filter_code_1=WLN&" +
                    "filter_request_1=&filter_code_2=WYR&filter_request_2=&filter_code_3=WYR&filter_request_3=" +
                    "&filter_code_4=WFM&filter_request_4=&filter_code_5=WSL&filter_request_5=" +
                    "&request=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
            Document document = Jsoup.connect(searchUrl).get();
            Elements elements = document.select("table.items");
            elements.forEach((element -> {
                String imgUrl = element.selectFirst("td.cover>a>img").attr("src");
                String name = element.selectFirst("td.col2>div.itemtitle").text();
                String detailRrl = element.selectFirst("td.col2>div.itemtitle>a").attr("href");
                Elements detailInfos = element.select("td.col2>table>tbody>tr");
                String author = detailInfos.get(0).select("td").get(1).text();
                String callNumber = detailInfos.get(0).select("td").get(3).text();
                String publishFrom = detailInfos.get(1).select("td").get(1).text();
                String age = detailInfos.get(1).select("td").get(3).text();
                String type = detailInfos.get(2).select("td").get(1).text();
                String link = detailInfos.get(2).select("td").get(3).text();
                MBook book = new MBook();
                book.setName(name);
                book.setType(type);
                book.setAuthor(author);
                book.setLink(link);
                book.setAge(age);
                book.setPublishFrom(publishFrom);
                book.setCallNumber(callNumber);
                book.setImgUrl(imgUrl);
                book.setDetailUrl(detailRrl);
                books.add(book);
            }));
            return new PageImpl<>(bookService.addBatch(books));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PageImpl<>(Collections.emptyList());
    }
}
