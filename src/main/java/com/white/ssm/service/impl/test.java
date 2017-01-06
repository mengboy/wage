package com.white.ssm.service.impl;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by vector on 16/12/11.
 */

public class test {
    @Test
    public void creatFile() throws IOException {
        File file = new File("src/main/webapp/wage/images/test");
        System.out.println(System.getProperty("user.dir"));
        if(!file.exists())
        {
            file.createNewFile();
        }
    }
}
