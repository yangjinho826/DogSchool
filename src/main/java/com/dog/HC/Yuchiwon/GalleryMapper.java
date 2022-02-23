package com.dog.HC.Yuchiwon;

import java.util.List;

public interface GalleryMapper {

	List<gallery> getAllGallery(gallery g);

	int writeGallery(gallery g);

	gallery getGallery(gallery g);

	int updateGallery(gallery g);

	int deleteGallery(gallery g);

	List<gallery> getFiveGallery(gallery g);

}
