package com.dog.HC.schoolmain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.HC.apply.ApplySchool;

@Service
public class priceTagDAO {
	@Autowired
	SqlSession ss;

	public void getAllpriceTag(priceTag pT, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		pT.setP_da_no(as.getdA_no());
		
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		List<priceTag> priceTags = mm.getAllpriceTag(pT);
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
	    pT.setP_no(p_no);
		 
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		priceTag pTag = mm.getpriceTag(pT);
		req.setAttribute("pTag", pTag);
		
	}

	public void getWrite(priceTag pT, HttpServletRequest req) {
		ApplySchool as = (ApplySchool) req.getSession().getAttribute("getSchoolSession");
		 
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		
		if(token.equals(successToken)){ return; }
		
		int p_da_no = as.getdA_no();;
		pT.setP_da_no(p_da_no);
		
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		if(mm.priceTagWrite(pT) == 1){
			System.out.println("등록성공");
			req.getSession().setAttribute("successToken", token);
		}else {
			System.out.println("등록실패");
		}
		
	}

	public void priceTagDelete(priceTag pT, HttpServletRequest req) {
	    int p_no = Integer.parseInt(req.getParameter("p_no"));
	    pT.setP_no(p_no);
	    
	    
	    
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		if(mm.priceTagDelete(pT) == 1){
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		
		
	}

	public void priceTagUpdate(priceTag pT, HttpServletRequest req) {
		    
		priceTagmapper mm = ss.getMapper(priceTagmapper.class);
		if(mm.priceTagUpdate(pT) == 1){
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}
		
	}


}
