package io.secugrow.demo.a11y;

import com.deque.html.axecore.args.AxeRunOptions;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class A11yHelper {

    private static final Logger log = LoggerFactory.getLogger(A11yHelper.class);

    public static List<Rule> hasAccessibilityIssues(WebDriver driver, List<String> a11yExclusions) {
        List<Rule> violations;
        List<String> ruleSet = List.of("wcag2a", "wcag2aa", "wcag21a", "wcag21aa");

        long timeTaken = System.currentTimeMillis();
        AxeBuilder axeRunner = new AxeBuilder()
                .withOptions(new AxeRunOptions())
                .withTags(ruleSet)
                .disableRules(a11yExclusions);
        violations = axeRunner.analyze(driver).getViolations();
        timeTaken = System.currentTimeMillis() - timeTaken;

        log.debug("AXE took {} ms", timeTaken);

        return violations.isEmpty() ? List.of() : violations;
    }
}