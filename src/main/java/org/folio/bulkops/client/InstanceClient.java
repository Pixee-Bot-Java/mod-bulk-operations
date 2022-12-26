package org.folio.bulkops.client;

import org.folio.bulkops.domain.bean.BriefInstance;
import org.folio.bulkops.domain.bean.BriefInstanceCollection;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "instance-storage/instances")
public interface InstanceClient {
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  BriefInstanceCollection getByQuery(@RequestParam String query);

  @GetMapping(value = "/{instanceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  BriefInstance getById(@PathVariable String instanceId);
}
