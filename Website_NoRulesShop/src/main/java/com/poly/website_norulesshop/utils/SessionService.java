package com.poly.website_norulesshop.utils;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession seesion;

    /**
     * Thay đổi hoặc tạo mới attribute trong session
     *
     * @param name  tên attribute
     * @param value giá trị attribute
     */
    public void set(String name, Object value) {
        seesion.setAttribute(name, value);
    }

    /**
     * Đọc giá trị của attribute trong session
     *
     * @param name tên attribute
     * @return giá trị đọc được hoặc null nếu không tồn tại
     */
    public <T> T get(String name) {
        return (T) seesion.getAttribute(name);
    }

    public <T> T getdefaultValue(String name, T defaultValue) {
        T value = get(name);
        return value != null ? value : defaultValue;
    }

    /**
     * Xóa attribute trong session
     *
     * @param name tên attribute cần xóa
     */
    public void remove(String name) {
        seesion.removeAttribute(name);
    }
}
