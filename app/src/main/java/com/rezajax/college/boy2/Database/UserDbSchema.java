package com.rezajax.college.boy2.Database;

public class UserDbSchema {
    public static final class UserTable {
        public static final String NAME = "user";

        public static final class Cols {  //Column ستون ها
            public static final String ID = "id";
            public static final String APPID = "appid";
            public static final String STUID = "stuid";
            public static final String PASS = "pass";
            public static final String NAME = "name";
            public static final String FAMILY = "family";
            //public static final String COURCE = "id";
            public static final String EMAIL = "email";
            public static final String PHONE = "phone";
            public static final String DATE = "date";
            public static final String CAT_NAME = "cat_name";
            public static final String NUM_POST = "num_post";
            public static final String IS_STU = "is_stu";
        }
    }

}
