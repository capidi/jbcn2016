package org.jsoftbiz.service;

import org.springframework.stereotype.Service;

/**
 * 9 exercises
 *
 * 2. cache aside
 * 3. cache annotation
 * 4. cache through (loader writer)
 * 5. statistics
 * 6. ehcache capacity
 * 7. ehcache topology
 * 8. ehcache consistency shared cache between threads
 * 9. comparison jsr107 providers
 *
 */

public interface SomeService {

  String someLogic(String id);

}