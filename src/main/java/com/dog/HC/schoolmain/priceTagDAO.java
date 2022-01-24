package com.dog.HC.schoolmain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class priceTagDAO {
	@Autowired
	SqlSession ss;

	public void getAllpriceTag(priceTag pT, HttpServletRequest req) {
		
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		List<priceTag> priceTags = mm.getAllpriceTag();
		req.setAttribute("priceTags", priceTags);
	
		for (priceTag p : priceTags) {
			if(p.getP_Dogkind().equals("대형견")) {
				req.setAttribute("BigDog", "대형견");
			}else if(p.getP_Dogkind().equals("중형견")) {
				req.setAttribute("MiddleDog", "중형견");
			}else if(p.getP_Dogkind().equals("소형견")) {
				req.setAttribute("SmallDog", "소형견");
			}
		}
	
		
	}
	
	public void getpriceTag(priceTag pT, HttpServletRequest req) {
		
	    int p_no = Integer.parseInt(req.getParameter("p_no"));
		 
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		priceTag pTag = mm.getpriceTag(pT);
		req.setAttribute("pTag", pTag);
		
	}

	public void getWrite(priceTag pT, HttpServletRequest req) {
		int p_da_no = 1;
		pT.setP_da_no(p_da_no);
		
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		if(mm.priceTagWrite(pT) == 1){
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
		
	}


}
