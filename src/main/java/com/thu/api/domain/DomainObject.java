
package com.thu.api.domain;

import java.io.Serializable;

/**
 *
 * @author liushuai
 */
public interface DomainObject<ID extends Serializable> extends Serializable {

    ID getId();
    
    void setId(ID id);
    
}
