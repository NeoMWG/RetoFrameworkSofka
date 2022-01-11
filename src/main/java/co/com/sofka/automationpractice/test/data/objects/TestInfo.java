package co.com.sofka.automationpractice.test.data.objects;

import cucumber.api.Scenario;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestInfo {
    private Scenario scenario;
    private String scenarioValue;
    private String scenarioName;
    private String environment;
    private String featureName;
    private List<String> scenarioTags;
    private List<String> paramTags;

    public enum InformationTag {
        ENVIRONMENT("@Environment:"),
        FEATURE("@FeatureName:"),
        SCENARIO("@ScenarioName:");
        String tag;

        InformationTag(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }


    private static final String REGEX_PARAM_TAG = "^@((?!ScenarioName|FeatureName|Environment).*):(.*)$";
    private static final String REGEX_SCENARIO_TAG = "^@(\\w*)([^:])(\\w*)$";
    private static final String REGEX_INDIVIDUAL_PARAM_TAG = "^@%s:(.*)$";

    private static final String ERROR_TAG = "Tag not found: '%s'.";
    private static final String NOT_FOUND_TAG = "NOT_FOUND";


    public TestInfo(Scenario scenario) {
        this.scenario = scenario;
        this.scenarioValue = scenario.getName().trim();
        this.scenarioTags = scenarioMatch(REGEX_SCENARIO_TAG);
        this.paramTags = scenarioMatch(REGEX_PARAM_TAG);
        this.environment = getInfoTag(InformationTag.ENVIRONMENT);
        this.featureName = getInfoTag(InformationTag.FEATURE);
        this.scenarioName = getInfoTag(InformationTag.SCENARIO);
    }

    public String getEnvironment() {
        return environment;
    }


    public String getFeatureName() {
        return featureName;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public String getScenarioValue() {
        return scenarioValue;
    }

    public List<String> getScenarioTags() {
        return scenarioTags;
    }

    public List<String> getParamTags() {
        return paramTags;
    }
    public String getStatus() {
        return scenario.getStatus().name();
    }


    public String getCustomParam(String param) {
        final String PARAM_REGEX = String.format(REGEX_INDIVIDUAL_PARAM_TAG, param);
        Pattern paramPattern = Pattern.compile(PARAM_REGEX);
         Matcher paramMatcher = scenario.getSourceTagNames().stream().filter(tag -> paramPattern.matcher(tag).find())
                        .map(paramPattern::matcher)
                        .findFirst()
                       .orElseThrow(()->new NoSuchElementException(String.format(ERROR_TAG,param)));
         return paramMatcher.find() ? paramMatcher.group(1) : StringUtils.EMPTY;
    }

    private List<String> scenarioMatch(String regex) {
        return scenario.getSourceTagNames().stream()
                .filter(scenarioTag ->
                        scenarioTag.matches(regex))
                .collect(Collectors.toList());
    }

    private String getInfoTag(InformationTag tag) {
        return scenario.getSourceTagNames().stream()
                .filter(sourceTag -> sourceTag.startsWith(tag.getTag()))
                .findFirst()
                .map(scenarioTag -> scenarioTag.replace(tag.getTag(),StringUtils.EMPTY))
                .orElse(NOT_FOUND_TAG);
    }
}
