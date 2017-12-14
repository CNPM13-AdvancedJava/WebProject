/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Linh
 */
public class Constant {
    public class ErrorMessage {
        public static final String NO_MESSAGE = "";
        public static final String UNKNOW_ERROR = "Đã xảy ra lỗi, vui lòng thử lại";
        public static final String INVALID_EMAIL = "Email không hợp lệ, vui lòng thử lại";
        public static final String INVALID_PASSWORD = "Mật khẩu không chính xác, vui lòng thử lại";
        public static final String EMAIL_EXIST = "Email này đã được đăng ký, vui lòng nhập một email khác";
        public static final String PWD_AND_CFMPWD_NOT_MATCH = "Mật khẩu xác nhận phải trùng với mật khẩu";
        public static final String INVALID_PASSWORD_LENGTH = "Mật khẩu phải có độ dài từ 8 đến 20 ký tự";
        public static final String INVALID_GENDER = "Giới tính không hợp lệ";
        public static final String INVALID_EMAIL_LENGTH = "Email không được vượt quá 50 ký tự";
        public static final String INVALID_USER_NAME_LENGTH = "Tên người dùng không được vượt quá 50 ký tự";
        public static final String INVALID_DATE_OF_BIRTH = "Bạn phải trên 16 tuổi mới được phép đăng ký";
        public static final String INVALID_PHONE_NUMBER_LENGTH = "Số điện thoại không được phép vượt quá 14 chữ số";
        public static final String INVALID_ADDRESS_LENGTH = "Địa chỉ không được vượt quá 100 ký tự";
        public static final String ADD_KEY_FAILED = "Mã kích hoạt đã tồn tại";
    }
    
    public class SuccessMessage {
        public static final String CHANGE_PASSWORD_SUCCESS = "Thay đổi mật khẩu thành công";
        public static final String UPDATE_INFO_SUCCESS = "Thay đổi thông tin cá nhân thành công";
        public static final String ADD_KEY_SUCCESS = "Thêm mã kích hoạt thành công";
    }
}
