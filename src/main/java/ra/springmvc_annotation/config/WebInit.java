package ra.springmvc_annotation.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    //khai báo thành phần cốt lỗi ứng dụng
    //controller, bean, define, convert
    //khi bật ứng dụng là tạo luôn root
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    //thanh phan phu bo sung
    //service, repository
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }



    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //cau hinh tieng viet

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setForceEncoding(true);
        filter.setEncoding("utf-8");
        return new Filter[]{filter};
    }

}
