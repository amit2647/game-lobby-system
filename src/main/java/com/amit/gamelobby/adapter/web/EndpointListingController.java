// package com.amit.gamelobby.adapter.web;

// import java.util.LinkedHashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Objects;
// import java.util.Set;
// import java.util.stream.Collectors;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.method.HandlerMethod;
// import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
// import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

// @RestController
// @RequestMapping("/dev")
// public class EndpointListingController {

//     private final RequestMappingHandlerMapping handlerMapping;

//     public EndpointListingController(
//         @Qualifier(
//             "requestMappingHandlerMapping"
//         ) RequestMappingHandlerMapping handlerMapping
//     ) {
//         this.handlerMapping = handlerMapping;
//     }

//     @GetMapping("/endpoints")
//     public List<Map<String, Object>> listEndpoints() {
//         return handlerMapping
//             .getHandlerMethods()
//             .entrySet()
//             .stream()
//             .map(entry -> {
//                 RequestMappingInfo info = entry.getKey();
//                 HandlerMethod method = entry.getValue();

//                 // Filter only your own package
//                 if (
//                     !method
//                         .getBeanType()
//                         .getPackageName()
//                         .startsWith("com.amit.gamelobby")
//                 ) {
//                     return null;
//                 }

//                 Map<String, Object> map = new LinkedHashMap<>();
//                 map.put("controller", method.getBeanType().getSimpleName());
//                 map.put("method", method.getMethod().getName());

//                 // Use getPathPatternsCondition for Spring 6+
//                 Set<String> patterns = info.getPathPatternsCondition() != null
//                     ? info
//                         .getPathPatternsCondition()
//                         .getPatterns()
//                         .stream()
//                         .map(Object::toString)
//                         .collect(Collectors.toSet())
//                     : Set.of();

//                 Set<String> methods = info.getMethodsCondition() != null
//                     ? info
//                         .getMethodsCondition()
//                         .getMethods()
//                         .stream()
//                         .map(Enum::name)
//                         .collect(Collectors.toSet())
//                     : Set.of();

//                 map.put("paths", patterns);
//                 map.put("methods", methods);
//                 return map;
//             })
//             .filter(Objects::nonNull)
//             .toList();
//     }
// }
