package com.dog.HC.schoolmain;

import java.util.List;

public interface priceTagmapper {

	List<priceTag> getAllpriceTag();

	priceTag getBogdog(String bigDog);

	int priceTagWrite(priceTag pT);

	priceTag getpriceTag(priceTag pT);

}
