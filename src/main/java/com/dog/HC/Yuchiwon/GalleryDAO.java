package com.dog.HC.Yuchiwon;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dog.HC.manage.ManageMapper;

@Service
public class GalleryDAO {
	
	int TotalCountG = 0;
	String strPgG = null;
	
	@Autowired
	private SqlSession ss;
	
	public void getTotal(gallery g, HttpServletRequest req) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");
		
		int g_tnum = p.getuA_ta_no();
		String g_uid = p.getuA_id();
		String g_uname = p.getuA_name();
		
		g.setG_tnum(g_tnum);
		g.setG_uid(g_uid);
		g.setG_uname(g_uname);
		
		GalleryMapper mm = ss.getMapper(GalleryMapper.class);
		TotalCountG = mm.gallerytotalcount(g);
		
		
	}

	public void pageView(gallery g, HttpServletRequest req) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");

		int rowSizeG = 5; //한페이지에 보여줄 글의 수
		int pgG = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
		    
		if(req.getParameter("pgG") != null) {
			strPgG = req.getParameter("pgG");
		}
			
		
	    if(strPgG != null){ //list.jsp?pg=2
	        pgG = Integer.parseInt(strPgG); //.저장
	    }

		int fromG = (pgG * rowSizeG) - (rowSizeG-1); //(1*10)-(10-1)=10-9=1 //from
		int toG=(pgG * rowSizeG); //(1*10) = 10 //to
		    
		int mp_tnum = p.getuA_ta_no();
		String mp_uid = p.getuA_id();
		String mp_uname = p.getuA_name();
		
		g.setG_tnum(mp_tnum);
		g.setG_uid(mp_uid);
		g.setG_uname(mp_uname);
		g.setFrom(fromG);
		g.setTo(toG);
		    
		GalleryMapper mm = ss.getMapper(GalleryMapper.class);
		List<gallery> galleries = mm.getAllGallery(g);
		String[] imges = null;
		for (gallery gg : galleries) {
			imges = gg.getG_img().split("!");
					gg.setFiless(imges);
		}
		req.setAttribute("galleries", galleries);
		
	}

	public void page(gallery g, HttpServletRequest req) {
		int rowSizeG = 5; //한페이지에 보여줄 글의 수
		int pgG = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
		   
	   	
		if(req.getParameter("pgG") == null) {
			System.out.println("--------Gif1-----");
			System.out.println(strPgG);
		}else {
			strPgG = req.getParameter("pgG");
			System.out.println("---------Gelse1---------");
			System.out.println(strPgG);
		}
		
	    if(strPgG != null){ //list.jsp?pg=2
	        pgG = Integer.parseInt(strPgG); //.저장
	    }

		
	 
	    
	   
	    int totalG = TotalCountG; //총 게시물 수
	    int allPageG = (int) Math.ceil(totalG/(double)rowSizeG); //페이지수
	    int blockG = 10; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>

	    int fromPageG = ((pgG-1)/blockG*blockG)+1;  //보여줄 페이지의 시작
	    int toPageG = ((pgG-1)/blockG*blockG)+blockG; //보여줄 페이지의 끝
	    if(toPageG> allPageG){ // 예) 20>17
	        toPageG = allPageG;
	    }

	    req.setAttribute("pgG", pgG);
	    req.setAttribute("blockG", blockG);
	    req.setAttribute("fromPageG", fromPageG);
	    req.setAttribute("toPageG", toPageG);
	    req.setAttribute("allPageG", allPageG);
	    req.setAttribute("rowSizeG", rowSizeG);
	    req.setAttribute("TotalCountG", totalG);
		
		
	}


	public void getAllGallery(HttpServletRequest req, gallery g) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");
//		System.out.println(p);
		String g_tid = ss.getMapper(ManageMapper.class).getTeacherId(p.getuA_ta_no());
		String g_uid = p.getuA_id();
		String g_uname = p.getuA_name();

		g.setG_tid(g_tid);
		g.setG_uid(g_uid);
		g.setG_uname(g_uname);

		GalleryMapper gm = ss.getMapper(GalleryMapper.class);
		List<gallery> galleries = gm.getAllGallery(g);
		String[] imges = null;
		
		
		for (gallery gg : galleries) {
			imges = gg.getG_img().split("!");
					gg.setFiless(imges);
		}
		
		req.setAttribute("galleries", galleries);
	}

	public void getGallery(HttpServletRequest req, gallery g) {
		puppy p = (puppy) req.getSession().getAttribute("puppies");
		
		int g_no = Integer.parseInt(req.getParameter("g_no"));
		
		System.out.println("------------getGallery------------");
		System.out.println(g_no);
		g.setG_no(g_no);

		
		GalleryMapper gm = ss.getMapper(GalleryMapper.class);
		gallery gallery = gm.getGallery(g);
		System.out.println("------");
		System.out.println(gallery.getG_da_no());

		String[] imges = gallery.getG_img().split("!");
		gallery.setFiless(imges);
			
		req.setAttribute("g", gallery);
		
	}

	public void writeGallery(@RequestParam String g_title, @RequestParam("g_img") List<MultipartFile> multiFileList, HttpServletRequest req) {

		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");

		if (token.equals(successToken)) {
			return;
		}
		gallery g = new gallery();
		puppy p = (puppy) req.getSession().getAttribute("puppies");

		String g_tid = ss.getMapper(ManageMapper.class).getTeacherId(p.getuA_ta_no());
		int g_tnum = p.getuA_ta_no();
		String g_uid = p.getuA_id();
		String g_uname = p.getuA_name();
		
		g.setG_tnum(g_tnum);
		g.setG_title(g_title);
		g.setG_tid(g_tid);
		g.setG_uid(g_uid);
		g.setG_uname(g_uname);
		g.setG_da_no(p.getuA_da_no());
		
		// 받아온것 출력 확인
		System.out.println(multiFileList);

		// path 가져오기
		String path = req.getSession().getServletContext().getRealPath("resources");
		String root = path + "\\" + "img";
		System.out.println(root);
		File fileCheck = new File(root);
		if (!fileCheck.exists())
			fileCheck.mkdirs();

		List<Map<String, String>> fileList = new ArrayList<Map<String, String>>();
		String saveFileName = "";
		for (int i = 0; i < multiFileList.size(); i++) {
			String originFile = multiFileList.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;

			Map<String, String> map = new HashMap<String, String>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			saveFileName += changeFile + "!";
			
			fileList.add(map);
		}
		g.setG_img(saveFileName);
		 System.out.println(fileList);

		// 파일업로드
		try {
			for (int i = 0; i < multiFileList.size(); i++) {
				File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
			
			GalleryMapper gm = ss.getMapper(GalleryMapper.class);
			if(gm.writeGallery(g)==1) {
				System.out.println("등록성공");
				req.getSession().setAttribute("successToken", token);
			}else {
				System.out.println("등록실패");
			}

			System.out.println("다중 파일 업로드 성공!");

		} catch (Exception e) {
			System.out.println("다중 파일 업로드 실패 ㅠㅠ");
			// 만약 업로드 실패하면 파일 삭제
			for (int i = 0; i < multiFileList.size(); i++) {
				new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
	}

	public void updateGallery(String g_title, List<MultipartFile> multiFileList, HttpServletRequest req, String off, int g_no) {

		String[] of = off.split("!");

		gallery g = new gallery();
		puppy p = (puppy) req.getSession().getAttribute("puppies");
		System.out.println("1"+p);
		String g_tid = ss.getMapper(ManageMapper.class).getTeacherId(p.getuA_da_no());
		String g_uid = p.getuA_id();
		String g_uname = p.getuA_name();
		System.out.println(g_tid);
		g.setG_title(g_title);
		g.setG_tid(g_tid);
		g.setG_uid(g_uid);
		g.setG_uname(g_uname);
		g.setG_da_no(p.getuA_da_no());
		g.setG_no(g_no);
		// 받아온것 출력 확인
		System.out.println(multiFileList);

		// path 가져오기
		String path = req.getSession().getServletContext().getRealPath("resources");
		String root = path + "\\" + "img";
		System.out.println(root);
		File fileCheck = new File(root);
		if (!fileCheck.exists())
			fileCheck.mkdirs();

		List<Map<String, String>> fileList = new ArrayList<Map<String, String>>();
		String saveFileName = "";
		for (int i = 0; i < multiFileList.size(); i++) {
			String originFile = multiFileList.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;

			Map<String, String> map = new HashMap<String, String>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			saveFileName += changeFile + "!";
			
			fileList.add(map);
		}
		g.setG_img(saveFileName);
		 System.out.println(fileList);

		// 파일업로드
		try {
			for (int i = 0; i < multiFileList.size(); i++) {
				File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
			
			GalleryMapper gm = ss.getMapper(GalleryMapper.class);
			if(gm.updateGallery(g)==1) {
				System.out.println("수정성공");

				
				for (String o : of) {
					File oo = new File(root +"\\"+ o );
					System.out.println("------------------------------------------------");
					System.out.println(oo);
					System.out.println("------------------------------------------------");
					oo.delete();
				
				}
				
				
			}else {
				System.out.println("수정실패");
			}

			System.out.println("다중 파일 업로드 성공!");

		} catch (Exception e) {
			System.out.println("다중 파일 업로드 실패 ㅠㅠ");
			// 만약 업로드 실패하면 파일 삭제
			for (int i = 0; i < multiFileList.size(); i++) {
				new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
		
		try {
			if (ss.getMapper(GalleryMapper.class).updateGallery(g) == 1) {
				req.setAttribute("result", "갤러리수정성공");
			} else {
				req.setAttribute("result", "갤러리수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "갤러리수정실패");
		}
		
	}

	public void deleteGallery(HttpServletRequest req, gallery g) {

		try {
			if (ss.getMapper(GalleryMapper.class).deleteGallery(g) == 1) {
				req.setAttribute("result", "갤러리삭제성공");
			} else {
				req.setAttribute("result", "갤러리삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "갤러리삭제실패");
		}
		
	}


}
