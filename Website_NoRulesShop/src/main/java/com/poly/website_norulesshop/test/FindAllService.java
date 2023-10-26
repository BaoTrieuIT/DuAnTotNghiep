package com.poly.website_norulesshop.test;

import com.poly.website_norulesshop.model.Account;
import com.poly.website_norulesshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poly.website_norulesshop.model.*;

import java.util.List;

@Service
public class FindAllService {
//
//    @Autowired
//    private ProductInformationTypeService productInformationTypeService;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private AccountStatusService accountStatusService;
//
//    @Autowired
//    private AddressService addressService;
//
//
//    @Autowired
//    private BrandService brandService;
//
//    @Autowired
//    private BrandImageService brandImageService;
//
//    @Autowired
//    private CategoryLevel1Service categoryLevel1Service;
//
//    @Autowired
//    private CategoryLevel2Service categoryLevel2Service;
//
//    @Autowired
//    private CategoryLevel1DetailService categoryLevel1DetailService;
//
//    @Autowired
//    private CategoryLevel2DetailService categoryLevel2DetailService;
//
//    @Autowired
//    private CategoryQuantityService categoryQuantityService;
//
//
//    @Autowired
//    private DetailInformationTypeService detailInformationTypeService;
//
//    @Autowired
//    private DirectoryService directoryService;
//
//    @Autowired
//    private DirectoryLv1Service directoryLv1Service;
//    @Autowired
//    private FeedbackService feedbackService;
//
//    @Autowired
//    private FeedbackImageService feedbackImageService;
//
//
//    @Autowired
//    private InformationTypeService informationTypeService;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private OrderDetailService orderDetailService;
//
//    @Autowired
//    private OrderStatusService orderStatusService;
//
//    @Autowired
//    private PaymentMethodService paymentMethodService;
//
//    @Autowired
//    private PaymentStatusService paymentStatusService;
//
//    @Autowired
//    private PointsService pointsService;
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private ProductDiscountService productDiscountService;
//
//    @Autowired
//    private ProductImageService productImageService;
//
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private RankedService rankedService;
//
//    @Autowired
//    private VoucherService voucherService;
//
//    @Autowired
//    private DirectoryLv1BrandService directoryLv1BrandService;
//
//
//    @Autowired TypeService typeService;
//
//    @Autowired GenderService genderService;
//
//    public void findAllDataFromServices() {
//        List<Type> typeList = typeService.getAllTypes();
//        List<Gender> genderList = genderService.getAllGenders();
//        List<DirectoryLv1Brand> directoryLv1Brands = directoryLv1BrandService.getAllDirectoryLv1Brands();
//        List<Account> accounts = accountService.getAllAccounts();
//        List<AccountStatus> accountStatuses = accountStatusService.getAllAccountStatuses();
//        List<Address> addresses = addressService.getAllAddresses();
//        List<Brand> brands = brandService.getAllBrands();
//        List<BrandImage> brandImages = brandImageService.getAllBrandImages();
//        List<CategoryLevel1> categoryLevel1s = categoryLevel1Service.getAllCategoryLevel1s();
//        List<CategoryLevel2> categoryLevel2s = categoryLevel2Service.getAllCategoryLevel2s();
//        List<CategoryLevel1Detail> categoryLevel1Details = categoryLevel1DetailService.getAllCategoryLevel1Details();
//        List<CategoryLevel2Detail> categoryLevel2Details = categoryLevel2DetailService.getAllCategoryLevel2Details();
//        List<CategoryQuantity> categoryQuantities = categoryQuantityService.getAllCategoryQuantities();
//        List<DetailInformationType> detailInformationTypes = detailInformationTypeService.getAllDetailInformationTypes();
//        List<Directory> directories = directoryService.getAllDirectories();
//        List<DirectoryLv1> directoryLv1s = directoryLv1Service.getAllDirectoryLv1s();
//        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
//        List<FeedbackImage> feedbackImages = feedbackImageService.getAllFeedbackImages();
//        List<InformationType> informationTypes = informationTypeService.getAllInformationTypes();
//        List<Order> orders = orderService.getAllOrders();
//        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetails();
//        List<OrderStatus> orderStatuses = orderStatusService.getAllOrderStatuses();
//        List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethods();
//        List<PaymentStatus> paymentStatuses = paymentStatusService.getAllPaymentStatuses();
//        List<Points> points = pointsService.getAllPoints();
//        List<Product> products = productService.getAllProducts();
//        List<ProductDiscount> productDiscounts = productDiscountService.getAllProductDiscounts();
//        List<ProductImage> productImages = productImageService.getAllProductImages();
//        List<Role> roles = roleService.getAllRoles();
//        List<Ranked> rankeds = rankedService.getAllRankeds();
//        List<Voucher> vouchers = voucherService.getAllVouchers();
//        List<ProductInformationType> productInformationTypeServices = productInformationTypeService.getAllProductInformationTypes();
//        // Gọi hàm printAllValuesInList cho từng danh sách
//        printAllValuesInList(productInformationTypeServices);
//        printAllValuesInList(directoryLv1Brands);
//        printAllValuesInList(accounts);
//        printAllValuesInList(accountStatuses);
//        printAllValuesInList(addresses);
//        printAllValuesInList(brands);
//        printAllValuesInList(brandImages);
//        printAllValuesInList(categoryLevel1s);
//        printAllValuesInList(categoryLevel2s);
//        printAllValuesInList(categoryLevel1Details);
//        printAllValuesInList(categoryLevel2Details);
//        printAllValuesInList(categoryQuantities);
//        printAllValuesInList(detailInformationTypes);
//        printAllValuesInList(directories);
//        printAllValuesInList(directoryLv1s);
//        printAllValuesInList(feedbacks);
//        printAllValuesInList(feedbackImages);
//        printAllValuesInList(informationTypes);
//        printAllValuesInList(orders);
//        printAllValuesInList(orderDetails);
//        printAllValuesInList(orderStatuses);
//        printAllValuesInList(paymentMethods);
//        printAllValuesInList(paymentStatuses);
//        printAllValuesInList(points);
//        printAllValuesInList(products);
//        printAllValuesInList(productDiscounts);
//        printAllValuesInList(productImages);
//        printAllValuesInList(roles);
//        printAllValuesInList(rankeds);
//        printAllValuesInList(vouchers);
//        printAllValuesInList(genderList);
//        printAllValuesInList(typeList);
//    }
//
//    public void printAllValuesInList(List<?> list) {
//        for (Object item : list) {
//            System.out.println(item);
//        }
//    }


}
