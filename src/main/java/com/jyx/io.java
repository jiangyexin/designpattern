package com.jyx;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-04-01 18:34
 **/
public class io {
    public static void main(String[] args) {
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }
}
