package com.basaki.shell;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.ConfigurableCommandRegistry;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.standard.StandardMethodTargetRegistrar;
import org.springframework.util.ReflectionUtils;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * {@code MyCommandsIntegrationTest} unit test for {@code
 * com.basaki.shell.MyCommands}.
 * <p/>
 *
 * @author Indra Basak
 * @since 10/17/17
 */
public class MyCommandsTest {

    private StandardMethodTargetRegistrar registrar =
            new StandardMethodTargetRegistrar();
    private ConfigurableCommandRegistry registry =
            new ConfigurableCommandRegistry();

    @Before
    public void setUp() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyCommands.class);
        registrar.setApplicationContext(context);
        registrar.register(registry);
    }

    @Test
    public void testAdd() {
        Map<String, MethodTarget> commands = registry.listCommands();

        MethodTarget methodTarget = commands.get("add");
        assertThat(methodTarget, notNullValue());
        Assertions.assertThat(methodTarget.getGroup()).isEqualTo(
                "Mathematical Commands");
        assertThat(methodTarget.getHelp(), is("Add two integers together."));
        assertThat(methodTarget.getMethod(), is(
                ReflectionUtils.findMethod(MyCommands.class, "add", int.class,
                        int.class)));
        assertThat(methodTarget.getAvailability().isAvailable(), is(true));
        assertEquals(3, ReflectionUtils.invokeMethod(methodTarget.getMethod(),
                methodTarget.getBean(), 1, 2));
    }
}
