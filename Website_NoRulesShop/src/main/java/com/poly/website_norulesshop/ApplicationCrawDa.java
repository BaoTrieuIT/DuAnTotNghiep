package com.poly.website_norulesshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.poly.website_norulesshop.model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationCrawDa {
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        int id = 1;
        for (int i = 1; i <= 60; i++) {
            try {

                Document document = Jsoup.connect("https://www.acfc.com.vn/new-collection.html?acfc_product_type=5977&attr_gender=15526").get();
                Elements items = document.select(".product-item .product-item-info");
                for (Element element : items) {
                    Product product = new Product();
                    Element product_item_details = element.selectFirst(".product-item-details");
                    assert product_item_details != null;
                    Element product_name = element.selectFirst(".product-item-link");
                    product.setProduct_name(product_name.text());
                    Element product_price = element.selectFirst(".price-wrapper");
                    product.setPrice(Double.parseDouble(product_price.attr("data-price-amount")));
//                    product.setCreate_date(date1);
                    product.setProduct_id(i++);
                    products.add(product);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        writeInFile();
    }
    private static void writeInFile() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.json"))) {
            try {
                writer.write(mapper.writeValueAsString(products));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Đã ghi dữ liệu vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
