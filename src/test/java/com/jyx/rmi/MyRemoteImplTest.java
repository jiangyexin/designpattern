package com.jyx.rmi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-04-02 17:36
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({MyRemoteImpl.class})
public class MyRemoteImplTest {
    @InjectMocks
    private MyRemoteImpl myRemote;

    @Test
    public void sayHelloTest() {

    }
}
