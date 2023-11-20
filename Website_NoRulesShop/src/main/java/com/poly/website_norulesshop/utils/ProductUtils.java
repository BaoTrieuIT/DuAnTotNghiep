//package com.poly.website_norulesshop.utils;
//
//import com.poly.website_norulesshop.entity.CategoryQuantity;
//import com.poly.website_norulesshop.entity.Product;
//
//import java.util.List;
//
//public class ProductUtils {
//    public static Integer findMinPriceInCategoryQuantityList(Product product) {
//        // Lấy danh sách categoryQuantityList từ đối tượng Product
//        List<CategoryQuantity> categoryQuantityList = product.getCategoryQuantityList();
//
//        // Kiểm tra xem danh sách có rỗng không
//        if (categoryQuantityList == null || categoryQuantityList.isEmpty()) {
//            throw new IllegalArgumentException("Danh sách không hợp lệ hoặc rỗng.");
//        }
//
//        // Gán giá trị đầu tiên của danh sách cho biến tạm minPrice
//        Integer minPrice = categoryQuantityList.get(0).getPrice();
//
//        // Duyệt qua từng đối tượng trong danh sách để tìm giá trị nhỏ nhất
//        for (CategoryQuantity categoryQuantity : categoryQuantityList) {
//            // So sánh giá trị hiện tại với giá trị nhỏ nhất hiện tại
//            if (categoryQuantity.getPrice() < minPrice) {
//                // Nếu tìm thấy giá trị nhỏ hơn, gán giá trị đó cho biến minPrice
//                minPrice = categoryQuantity.getPrice();
//            }
//        }
//
//        // Trả về giá trị nhỏ nhất trong danh sách
//        return minPrice;
//    }
//
//    public static Integer findMaxPriceInCategoryQuantityList(Product product) {
//        // Lấy danh sách categoryQuantityList từ đối tượng Product
//        List<CategoryQuantity> categoryQuantityList = product.getCategoryQuantityList();
//
//        // Kiểm tra xem danh sách có rỗng không
//        if (categoryQuantityList == null || categoryQuantityList.isEmpty()) {
//            throw new IllegalArgumentException("Danh sách không hợp lệ hoặc rỗng.");
//        }
//
//        // Gán giá trị đầu tiên của danh sách cho biến tạm maxPrice
//        Integer maxPrice = categoryQuantityList.get(0).getPrice();
//
//        // Duyệt qua từng đối tượng trong danh sách để tìm giá trị lớn nhất
//        for (CategoryQuantity categoryQuantity : categoryQuantityList) {
//            // So sánh giá trị hiện tại với giá trị lớn nhất hiện tại
//            if (categoryQuantity.getPrice() > maxPrice) {
//                // Nếu tìm thấy giá trị lớn hơn, gán giá trị đó cho biến maxPrice
//                maxPrice = categoryQuantity.getPrice();
//            }
//        }
//
//        // Trả về giá trị lớn nhất trong danh sách
//        return maxPrice;
//    }
//
//
//}
