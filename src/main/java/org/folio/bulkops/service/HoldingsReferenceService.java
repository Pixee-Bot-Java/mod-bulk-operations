package org.folio.bulkops.service;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.folio.bulkops.util.Constants.QUERY_PATTERN_NAME;
import static org.folio.bulkops.util.Utils.encode;

import org.apache.commons.lang3.ObjectUtils;
import org.folio.bulkops.client.CallNumberTypeClient;
import org.folio.bulkops.client.HoldingsClient;
import org.folio.bulkops.client.HoldingsNoteTypeClient;
import org.folio.bulkops.client.HoldingsSourceClient;
import org.folio.bulkops.client.HoldingsTypeClient;
import org.folio.bulkops.client.IllPolicyClient;
import org.folio.bulkops.client.LocationClient;
import org.folio.bulkops.client.StatisticalCodeClient;
import org.folio.bulkops.domain.bean.HoldingsRecord;
import org.folio.bulkops.domain.bean.HoldingsRecordsSource;
import org.folio.bulkops.exception.NotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class HoldingsReferenceService {

  private final HoldingsClient holdingsClient;
  private final HoldingsTypeClient holdingsTypeClient;
  private final LocationClient locationClient;
  private final CallNumberTypeClient callNumberTypeClient;
  private final HoldingsNoteTypeClient holdingsNoteTypeClient;
  private final IllPolicyClient illPolicyClient;
  private final HoldingsSourceClient holdingsSourceClient;
  private final StatisticalCodeClient statisticalCodeClient;

  @Cacheable(cacheNames = "holdings")
  public HoldingsRecord getHoldingsRecordById(String id) {
    return holdingsClient.getHoldingById(id);
  }

  @Cacheable(cacheNames = "holdingsTypesNames")
  public String getHoldingsTypeNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : holdingsTypeClient.getById(id)
          .getName();
    } catch (NotFoundException e) {
      log.error("Holdings type not found by id={}", id);
      return id;
    }
  }

  @Cacheable(cacheNames = "holdingsTypeIds")
  public String getHoldingsTypeIdByName(String name) {
    if (isEmpty(name)) {
      return null;
    }
    var holdingsTypes = holdingsTypeClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (holdingsTypes.getHoldingsTypes().isEmpty()) {
      log.error("Holdings type not found by name={}", name);
      return name;
    }
    return holdingsTypes.getHoldingsTypes().get(0).getId();
  }

  @Cacheable(cacheNames = "holdingsLocationsNames")
  public String getLocationNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : locationClient.getLocationById(id)
          .getName();
    } catch (NotFoundException e) {
      log.error("Location not found by id={}", id);
      return id;
    }
  }

  public String getLocationIdByName(String name) {
    if (isEmpty(name)) {
      return null;
    }
    var locations = locationClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (locations.getLocations().isEmpty()) {
      log.error("Location not found by name={}", name);
      return name;
    }
    return locations.getLocations().get(0).getId();
  }

  @Cacheable(cacheNames = "holdingsCallNumberTypesNames")
  public String getCallNumberTypeNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : callNumberTypeClient.getById(id)
          .getName();
    } catch (NotFoundException e) {
      log.error("Call number type not found by id={}", id);
      return id;
    }
  }

  @Cacheable(cacheNames = "holdingsCallNumberTypes")
  public String getCallNumberTypeIdByName(String name) {
    if (isEmpty(name)) {
      return null;
    }
    var callNumberTypes = callNumberTypeClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (callNumberTypes.getCallNumberTypes().isEmpty()) {
      log.error("Call number type not found by name={}", name);
      return name;
    }
    return callNumberTypes.getCallNumberTypes().get(0).getId();
  }

  @Cacheable(cacheNames = "holdingsNoteTypesNames")
  public String getNoteTypeNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : holdingsNoteTypeClient.getById(id)
          .getName();
    } catch (NotFoundException e) {
      log.error("Note type not found by id={}", id);
      return id;
    }
  }

  @Cacheable(cacheNames = "holdingsNoteTypes")
  public String getNoteTypeIdByName(String name) {
    if (isEmpty(name)) {
      return null;
    }
    var noteTypes = holdingsNoteTypeClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (noteTypes.getHoldingsNoteTypes().isEmpty()) {
      log.error("Note type not found by name={}", name);
      return name;
    }
    return noteTypes.getHoldingsNoteTypes().get(0).getId();
  }

  @Cacheable(cacheNames = "illPolicyNames")
  public String getIllPolicyNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : illPolicyClient.getById(id)
          .getName();
    } catch (NotFoundException e) {
      log.error("Ill policy not found by id={}", id);
      return id;
    }
  }

  @Cacheable(cacheNames = "illPolicies")
  public String getIllPolicyIdByName(String name) {
    if (isEmpty(name)) {
      return null;
    }
    var illPolicies = illPolicyClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (illPolicies.getIllPolicies().isEmpty()) {
      log.error("Ill policy not found by name={}", name);
      return name;
    }
    return illPolicies.getIllPolicies().get(0).getId();
  }

  @Cacheable(cacheNames = "sources")
  public HoldingsRecordsSource getSourceById(String id) {
    return holdingsSourceClient.getById(id);
  }

  @Cacheable(cacheNames = "holdingsSourceNames")
  public String getSourceNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : holdingsSourceClient.getById(id)
          .getName();
    } catch (NotFoundException e) {
      log.error("Holdings record source not found by id={}", id);
      return id;
    }
  }

  @Cacheable(cacheNames = "holdingsSources")
  public String getSourceIdByName(String name) {
    if (isEmpty(name)) {
      return null;
    }
    var sources = holdingsSourceClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (ObjectUtils.isEmpty(sources) || ObjectUtils.isEmpty(sources.getHoldingsRecordsSources())) {
      log.error("Source not found by name={}", name);
      return name;
    }
    return sources.getHoldingsRecordsSources().get(0).getId();
  }

  @Cacheable(cacheNames = "holdingsStatisticalCodeNames")
  public String getStatisticalCodeNameById(String id) {
    try {
      return isEmpty(id) ? EMPTY
        : statisticalCodeClient.getById(id)
          .getName();
    } catch (Exception e) {
      log.error("Statistical code not found by id={}", id);
      return id;
    }
  }

  @Cacheable(cacheNames = "holdingsStatisticalCodes")
  public String getStatisticalCodeIdByName(String name) {
    var statisticalCodes = statisticalCodeClient.getByQuery(format(QUERY_PATTERN_NAME, encode(name)));
    if (statisticalCodes.getStatisticalCodes().isEmpty()) {
      log.error("Statistical code not found by name={}", name);
      return name;
    }
    return statisticalCodes.getStatisticalCodes().get(0).getId();
  }
}
