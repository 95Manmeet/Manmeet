package com.example.hasna.manmeet;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by manmeet on 6/27/2018.
 */

public class TableData implements Serializable {
    TableData(){
    }
    public static abstract class users implements BaseColumns {
        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String EMAIL = "EMAIL";
        public static final String DATABASE_NAME = "manmeet.db";
        public static final String TABLE_NAME = "users";
    }

}
