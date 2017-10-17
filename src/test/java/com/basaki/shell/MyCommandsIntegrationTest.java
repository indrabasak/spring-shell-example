package com.basaki.shell;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Input;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.Shell;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * {@code MyCommandsIntegrationTest} integration test for {@code
 * com.basaki.shell.MyCommands}.
 * <p/>
 *
 * @author Indra Basak
 * @since 10/17/17
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyCommandsIntegrationTest {

    @Autowired
    private Shell shell;

    @Test
    public void testAdd() {
        Map<String, MethodTarget> commands = shell.listCommands();
        MethodTarget methodTarget = commands.get("add");
        assertThat(methodTarget, notNullValue());
        Assertions.assertThat(methodTarget.getGroup()).isEqualTo(
                "Mathematical Commands");
        assertThat(methodTarget.getHelp(), is("Add two integers together."));
        assertThat(methodTarget.getMethod(), is(
                ReflectionUtils.findMethod(MyCommands.class, "add", int.class,
                        int.class)));
        assertThat(methodTarget.getAvailability().isAvailable(), is(true));
        assertEquals(3, shell.evaluate(new Input() {
            public String rawText() {
                return "add 1 2";
            }

            public List<String> words() {
                return Arrays.asList("add", "1", "2");
            }
        }));
    }
}
