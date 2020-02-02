package com.github.raymondtang310.fireemblemapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.NoMoreInteractions;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * FireEmblemAPIApplicationTest is a class for unit testing {@link FireEmblemAPIApplication}.
 * <p>
 * Created February 02, 2020.
 *
 * @author Raymond Tang
 * @version %I%, %G%
 * @since 1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Dotenv.class, SpringApplication.class, FireEmblemAPIApplication.class})
public class FireEmblemAPIApplicationTest {

    /**
     * Tests that the <code>main</code> method loads {@link Dotenv} environment variables when this application is
     * running in a local environment.
     *
     * @throws Exception If <code>PowerMockito.whenNew().withArguments()</code> throws an {@link Exception}
     * @since 1.0
     */
    @Test
    public void testMainShouldLoadDotenvInLocalEnvironment() throws Exception {
        String[] args = {};
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getenv("APP_ENV")).thenReturn(null);
        Dotenv dotenvMock = PowerMockito.mock(Dotenv.class);
        PowerMockito.mockStatic(Dotenv.class);
        PowerMockito.when(Dotenv.load()).thenReturn(dotenvMock);
        SpringApplicationBuilder springApplicationBuilderMock = PowerMockito.mock(SpringApplicationBuilder.class);
        PowerMockito.whenNew(SpringApplicationBuilder.class).withArguments(Mockito.any(Class.class)).thenReturn(springApplicationBuilderMock);
        PowerMockito.doReturn(springApplicationBuilderMock).when(springApplicationBuilderMock).environment(Mockito.any(ConfigurableEnvironment.class));

        FireEmblemAPIApplication.main(args);

        PowerMockito.verifyStatic(Dotenv.class, Mockito.times(1));
        Dotenv.load();
    }

    /**
     * Tests that the <code>main</code> method does NOT load {@link Dotenv} environment variables when this
     * application is running in a deployed environment.
     *
     * @since 1.0
     */
    @Test
    public void testMainShouldNotLoadDotenvInDeployedEnvironment() {
        String[] args = {};
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getenv("APP_ENV")).thenReturn("production");
        PowerMockito.mockStatic(Dotenv.class);
        PowerMockito.mockStatic(SpringApplication.class);

        FireEmblemAPIApplication.main(args);

        PowerMockito.verifyStatic(Dotenv.class, new NoMoreInteractions());
        Dotenv.load();
    }

    /**
     * Tests that the <code>main</code> method runs an instance of {@link SpringApplicationBuilder} when this
     * application is running in a local environment.
     *
     * @throws Exception If <code>PowerMockito.whenNew().withArguments()</code> throws an {@link Exception}
     * @since 1.0
     */
    @Test
    public void testMainShouldRunSpringApplicationBuilderInLocalEnvironment() throws Exception {
        String[] args = {};
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getenv("APP_ENV")).thenReturn(null);
        Dotenv dotenvMock = PowerMockito.mock(Dotenv.class);
        PowerMockito.mockStatic(Dotenv.class);
        PowerMockito.when(Dotenv.load()).thenReturn(dotenvMock);
        SpringApplicationBuilder springApplicationBuilderMock = PowerMockito.mock(SpringApplicationBuilder.class);
        PowerMockito.whenNew(SpringApplicationBuilder.class).withArguments(Mockito.any(Class.class)).thenReturn(springApplicationBuilderMock);
        PowerMockito.doReturn(springApplicationBuilderMock).when(springApplicationBuilderMock).environment(Mockito.any(ConfigurableEnvironment.class));

        FireEmblemAPIApplication.main(args);

        Mockito.verify(springApplicationBuilderMock, Mockito.times(1)).run(args);
    }

    /**
     * Tests that the <code>main</code> method runs {@link SpringApplication} when this
     * application is running in a deployed environment.
     *
     * @since 1.0
     */
    @Test
    public void testMainShouldRunSpringApplicationInDeployedEnvironment() {
        String[] args = {};
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getenv("APP_ENV")).thenReturn("production");
        PowerMockito.mockStatic(SpringApplication.class);

        FireEmblemAPIApplication.main(args);

        PowerMockito.verifyStatic(SpringApplication.class, Mockito.times(1));
        SpringApplication.run(FireEmblemAPIApplication.class, args);
    }
}
