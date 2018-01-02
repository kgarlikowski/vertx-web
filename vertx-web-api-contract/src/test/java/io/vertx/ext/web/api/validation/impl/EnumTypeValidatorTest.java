package io.vertx.ext.web.api.validation.impl;

import io.vertx.ext.web.api.validation.ValidationException;
import org.junit.Test;

import static java.util.Arrays.asList;

public class EnumTypeValidatorTest {

  private static String allowed1 = "foo";
  private static String allowed2 = "bar";

  private EnumTypeValidator enumTypeValidator = new EnumTypeValidator(asList(allowed1, allowed2), null);

  @Test
  public void should_pass_allowed_values() {
    enumTypeValidator.isValidCollection(asList(allowed1, allowed2));
  }

  @Test(expected = ValidationException.class)
  public void should_not_pass_disallowed_values() {
    enumTypeValidator.isValidCollection(asList(allowed1, "baz"));
  }

  @Test(expected = ValidationException.class)
  public void should_not_pass_disallowed_values_opposite_order() {
    enumTypeValidator.isValidCollection(asList("baz", allowed2));
  }
}
