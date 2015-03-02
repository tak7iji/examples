package org.sample.springmvc.api;

import java.util.List;

import org.sample.springmvc.dto.TestTableDto;

public interface DBAccess {

    List<TestTableDto> dbAccess() throws Throwable;

}
