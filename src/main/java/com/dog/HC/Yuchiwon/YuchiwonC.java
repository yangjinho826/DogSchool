package com.dog.HC.Yuchiwon;

import java.lang.reflect.Parameter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dog.HC.TokenMaker;
import com.dog.HC.apply.ApplyDAO;
import com.dog.HC.apply.ApplyMapper;
import com.dog.HC.apply.ApplyPet;
import com.dog.HC.apply.ApplySchool;
import com.dog.HC.apply.ApplyTeacher;
import com.dog.HC.manage.ManageDAO;
import com.dog.HC.member.MemberDAO;
import com.dog.HC.schoolmain.postscript;

@Controller
public class YuchiwonC {
	
	@Autowired
	private YuchiwonDAO ydao;
	
	@Autowired
	private DiaryDAO ddao;

	@Autowired
	private GalleryDAO gdao;

	@Autowired
	private MemberDAO mDAOO;
	
	@Autowired
	private ApplyDAO aDAO;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private ManageDAO mDAO;
	
	//uapplytable에 해당 id의 강아지가 전혀 존재하지 않을 때
	@RequestMapping(value = "my_registrationCheck", method = RequestMethod.GET)
	public @ResponseBody int postscriptDelete(ApplySchool as, HttpServletRequest req, ApplyPet ap, ApplyTeacher at) {
		String typee = req.getParameter("typee");
		String id = req.getParameter("id");
		as.setdA_id(id);
		
		ApplyMapper mm = ss.getMapper(ApplyMapper.class);
		int totalPet1 = mm.getAllPetCount(as);
		int totalPet2 = mm.getAllTeacherPetCount(as);
		
		if(typee.equals("1") && totalPet1 == 0){
			return aDAO.getulistSession(req, as);
		}else if(typee.equals("2") && totalPet2 == 0) {
			return aDAO.gettlistSession(req, as, at);
		}
		return 3;
	}
	
	@RequestMapping(value = "yuchiwon.get.allpuppy", method = RequestMethod.GET)
	public String pList(HttpServletRequest req, signup s,ApplySchool as, ApplyPet ap) {

		if(mDAOO.loginCheck(req)) {
			ydao.getAllPuppy(req, s);
			mDAO.getAllSchool(req); //승인된 유치원 목록 조회
		}
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/puppyList.jsp");
		req.setAttribute("footer", "main/footer.jsp");
	
		return "index";
	}

	@RequestMapping(value = "yuchiwon.get.puppy", method = RequestMethod.GET)
	public String getPuppy(HttpServletRequest req, puppy puppy) {
		mDAOO.loginCheck(req);
		ydao.getPuppy(req, puppy);
		ddao.getFiveDiary(req);
		gdao.getFiveGallery(req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/puppyPage.jsp");
		req.setAttribute("footer", "main/footer.jsp");
	
		return "index";
	}
	
	// 알림장
	@RequestMapping(value = "yuchiwon.get.alldiary", method = RequestMethod.GET)
	public String diaryGo(HttpServletRequest req, puppy puppy, diary d) {
		mDAOO.loginCheck(req);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.write.go", method = RequestMethod.GET)
	public String diaryWriteGo(HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.write", method = RequestMethod.GET)
	public String diaryWrite(HttpServletRequest req, diary d) {
		mDAOO.loginCheck(req);
		ddao.writeDiary(req, d);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "diary.update.go", method = RequestMethod.GET)
	public String diaryUpdateGo(HttpServletRequest req, diaryReply dr, diary d) {
		mDAOO.loginCheck(req);
		ddao.getDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_update.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.update", method = RequestMethod.GET)
	public String diaryUpdate(HttpServletRequest req, diary d) {
		if (mDAOO.loginCheck(req)) {
			ddao.updateDiary(req, d);
		}
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "diary.delete", method = RequestMethod.GET)
	public String diaryDelete(HttpServletRequest req, diary d) {
		if (mDAOO.loginCheck(req)) {
			ddao.deleteDiary(req, d);
		}
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	@RequestMapping(value = "diary.reply.write", method = RequestMethod.GET)
	public String diaryReplyWrite(HttpServletRequest req, diaryReply dr, diary d) {
		mDAOO.loginCheck(req);
		ddao.writeReply(req, dr);
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "diary.reply.delete", method = RequestMethod.GET)
	public String replyDelete(HttpServletRequest req, diaryReply dr, diary d) {
		if (mDAOO.loginCheck(req)) {
			ddao.deleteReply(req, dr);
		}
		ddao.getAllDiary(req, d);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/diary_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

	// 갤러리
	@RequestMapping(value = "yuchiwon.get.allgallery", method = RequestMethod.GET)
	public String galleryGo(HttpServletRequest req, gallery g, puppy p) {
		mDAOO.loginCheck(req);
		gdao.getAllGallery(req, g);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "gallery.write.go", method = RequestMethod.GET)
	public String galleryWriteGo(HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_write.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "gallery.write", method = RequestMethod.POST)
	public String galleryWrite(@RequestParam String g_title, @RequestParam("g_img") List<MultipartFile> multiFileList, HttpServletRequest req) {
		mDAOO.loginCheck(req);
		TokenMaker.make(req);
		gdao.writeGallery(g_title, multiFileList, req);
		gallery g = new gallery();
		gdao.getAllGallery(req, g);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "gallery.detail", method = RequestMethod.GET)
	public String galleryDetail(HttpServletRequest req, gallery g, puppy p) {
		mDAOO.loginCheck(req);
		gdao.getGallery(req, g);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_detail.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "gallery.update.go", method = RequestMethod.GET)
	public String galleryUpdateGo(HttpServletRequest req, gallery g) {
		mDAOO.loginCheck(req);
		gdao.getGallery(req, g);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_update.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}	

	@RequestMapping(value = "gallery.update", method = RequestMethod.POST	)
	public String galleryUpdate(@RequestParam String g_title, @RequestParam("g_img") List<MultipartFile> multiFileList, HttpServletRequest req,@RequestParam("originalFile") String of, @RequestParam("g_no") int g_no) {
		TokenMaker.make(req);
		gallery g = null;
		if (mDAOO.loginCheck(req)) {
			gdao.updateGallery(g_title, multiFileList, req, of, g_no);
			g = new gallery();
		}
		gdao.getAllGallery(req, g);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "gallery.delete", method = RequestMethod.GET)
	public String galleryDelete(HttpServletRequest req, gallery g) {
		if (mDAOO.loginCheck(req)) {
			gdao.deleteGallery(req, g);
		}
		gdao.getAllGallery(req, g);
		
		req.setAttribute("MenuBar", "schoolmain/SchoolMenu.jsp");
		req.setAttribute("contentPage", "yuchiwon/gallery_home.jsp");
		req.setAttribute("footer", "main/footer.jsp");
		
		return "index";
	}

}
