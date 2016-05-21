package com.creativedna.vortex.constants;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class AppConstants {

    public enum SharedPreferenceKeys {
        USER_NAME("userName"),
        USER_EMAIL("userEmail"),
        USER_IMAGE_URL("userImageUrl");


        private String value;

        SharedPreferenceKeys(String value) {
            this.value = value;
        }

        public String getKey() {
            return value;
        }
    }


    public static final String REGISTER_URL = "http://192.168.1.242/vortex/register.php";
    public static final String LOGIN_URL = "http://192.168.1.242/vortex/login.php";


    public static final String GOOGLE_CLIENT_ID = "45756826175-5hl5k7m0bikgdbcf6c99iq61ma5ua6t3.apps.googleusercontent.com";

}
