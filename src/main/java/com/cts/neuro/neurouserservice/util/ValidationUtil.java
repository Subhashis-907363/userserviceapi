//package com.cts.neuro.neurouserservice.util;
//
//import javax.validation.Validation;
//import javax.validation.Validator;
//
//import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
//import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
//
//public class ValidationUtil {
//    private ValidationUtil() {
//    }
//
//    public static Validator getValidator() {
//        final PlatformResourceBundleLocator resourceBundleLocator = new PlatformResourceBundleLocator(
//                "CiqdUserValidationMessages",
//                null, true);
//        return Validation.byDefaultProvider().configure()
//                .messageInterpolator(new ResourceBundleMessageInterpolator(
//                        resourceBundleLocator))
//                .buildValidatorFactory().getValidator();
//
//
//    }
//}
