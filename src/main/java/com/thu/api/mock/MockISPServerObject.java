package com.thu.api.mock;

import com.thu.api.domain.BusinessAddress;
import com.thu.api.result.ISPServerObject;

public class MockISPServerObject {
    public static ISPServerObject getServerSideISP() {
    	ISPServerObject iso = new ISPServerObject();
	    iso.setEmail("fredwestgate@gmail.com");
	    iso.setWebsite("www.fredwestgatedentistry.com");
	    BusinessAddress address = new BusinessAddress();
	    address.setCountry("USA");
	    address.setState("wa");
	    address.setCity("Seattle");
	    address.setLine1("16250 NE 85th St");
	    address.setZip("98052-3528");
	    iso.setAddress(address);
	    iso.setFriendRecommends(18);
	    return iso;
    }
}
