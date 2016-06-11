package org.jsoftbiz.service;

import org.jsoftbiz.repository.SomeRepository;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 * Example service : Cache aside
 */

@Service
public class Ex2Service implements SomeService {

  private SomeRepository repository = new SomeRepository();
  private Cache<String, String> cache;

  public Ex2Service() {
    CachingProvider provider = Caching.getCachingProvider();
    CacheManager cacheManager = provider.getCacheManager();

    MutableConfiguration<String, String> configuration = new MutableConfiguration<>();
    configuration.setTypes(String.class, String.class);
    cache = cacheManager.createCache("someCache2", configuration);
  }

  @Override
  public String someLogic(final String id) {
    System.out.println("---> Call to service 2");

    String val = cache.get(id);
    if (val == null) {
      val = repository.readFromDb(id);
      cache.put(id, val);
    }
    return val;
  }
}
