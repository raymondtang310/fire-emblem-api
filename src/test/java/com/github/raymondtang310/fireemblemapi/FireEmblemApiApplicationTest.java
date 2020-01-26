package com.github.raymondtang310.fireemblemapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.ConfigurableEnvironment;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Dotenv.class, FireEmblemApiApplication.class})
public class FireEmblemApiApplicationTest {

    @Test
    public void testMainShouldLoadDotenv() throws Exception {
        String[] args = {};
        PowerMockito.spy(Dotenv.class);
        SpringApplicationBuilder springApplicationBuilderMock = PowerMockito.mock(SpringApplicationBuilder.class);
        PowerMockito.whenNew(SpringApplicationBuilder.class).withArguments(Mockito.any(Class.class)).thenReturn(springApplicationBuilderMock);
        PowerMockito.doReturn(springApplicationBuilderMock).when(springApplicationBuilderMock).environment(Mockito.any(ConfigurableEnvironment.class));

        FireEmblemApiApplication.main(args);

        PowerMockito.verifyStatic(Dotenv.class);
        Dotenv.load();
    }

    @Test
    public void testMainShouldRunSpringApplication() throws Exception {
        String[] args = {};
        SpringApplicationBuilder springApplicationBuilderMock = PowerMockito.mock(SpringApplicationBuilder.class);
        PowerMockito.whenNew(SpringApplicationBuilder.class).withArguments(Mockito.any(Class.class)).thenReturn(springApplicationBuilderMock);
        PowerMockito.doReturn(springApplicationBuilderMock).when(springApplicationBuilderMock).environment(Mockito.any(ConfigurableEnvironment.class));

        FireEmblemApiApplication.main(args);

        Mockito.verify(springApplicationBuilderMock, Mockito.times(1)).run(args);
    }
}
