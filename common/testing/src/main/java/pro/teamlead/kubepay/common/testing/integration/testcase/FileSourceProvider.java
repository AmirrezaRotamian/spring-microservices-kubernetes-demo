package pro.teamlead.kubepay.common.testing.integration.testcase;

import pro.teamlead.kubepay.common.json.ObjectMapperWrapper;
import org.junit.jupiter.api.extension.*;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileSourceProvider implements ParameterResolver, BeforeEachCallback {

    private volatile String[] paths;

    @Override
    public void beforeEach(ExtensionContext context) {
        paths = null;
        context.getTestMethod().ifPresent(method -> {
            TestCase testParams = method.getAnnotation(TestCase.class);
            if (testParams != null) {
                paths = testParams.value();
            }
        });
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) {
        return paths != null && parameterContext.getIndex() < paths.length;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) {

        try {
            String jsonResource = getJsonResource(paths[parameterContext.getIndex()]);
            Class<?> type = parameterContext.getParameter().getType();
            if (type == String.class) {
                return jsonResource;
            } else {
                return ObjectMapperWrapper.fromStringJson(jsonResource, type);
            }
        } catch (IOException e) {
            throw new ParameterResolutionException("Failed to read file", e);
        }
    }

    private String getJsonResource(String file) throws IOException {
        String classpathName = String.format("classpath:%s", file);
        Path path = ResourceUtils.getFile(classpathName).toPath();
        String result = new String(Files.readAllBytes(path));
        return result.trim();
    }
}
