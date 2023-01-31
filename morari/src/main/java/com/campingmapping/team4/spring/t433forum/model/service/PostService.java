package com.campingmapping.team4.spring.t433forum.model.service;
// package com.campingmapping.team4.spring.t4_33Forum.model.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t433forum.model.dao.repository.PostRepository;
import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.utils.service.JwtService;

@Service
@Transactional
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtService jwtService;

	// 查單一貼文
	public Post getPostById(Integer id) {
		// Optional<Post> findById = postRepository.findById(id);
		return postRepository.findById(id).get();
	}

	// 查所有貼文
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	// 查會員貼文
	public List<Post> getUserNonHidePost(UUID userId) {
		UserProfiles uProfiles = userRepository.findById(userId).get();
		return postRepository.findByuserprofiles(uProfiles);
	}

	// 查非隱藏貼文
	public List<Post> getNonHidePost() {
		return postRepository.findByposthide(0);
	}

	// 查隱藏貼文
	public List<Post> getHidePost() {
		return postRepository.findByposthide(1);
	}

	// 查檢舉貼文
	public List<Post> getReportPost() {
		return postRepository.findBypostreport(1);
	}

	// 新增
	public Post insert(Post post) {
		UUID uid = jwtService.getUId(null);
		UserProfiles userProfiles = userRepository.findById(uid).get();
		post.setUserprofiles(userProfiles);

		post.setUserprofiles(userProfiles);
		post.setReleasedate(new Date());
		post.setUserlike(0);
		post.setUserunlike(0);
		post.setPostreport(0);
		post.setPosthide(0);

		return postRepository.save(post);
	}

	// 修改
	public Post update(Post post) {
		post.setReleasedate(new Date());
		post.setPostreport(0);

		return postRepository.save(post);
	}

	// 喜歡

	// 不喜歡

	// 檢舉
	public Post report(Post post) {
		post.setPostreport(1);
		return postRepository.save(post);
	}

	// 取消檢舉
	public Post cancelReport(Post post) {
		post.setPostreport(0);
		return postRepository.save(post);
	}

	// 隱藏
	public Post hide(Post post) {
		post.setPosthide(1);
		return postRepository.save(post);
	}

	// 取消隱藏
	public Post cancelHide(Post post) {
		post.setPosthide(0);
		return postRepository.save(post);
	}

	// private PostDao postDao;

	// public PostService() {
	// this.postDao = new PostDao();
	// }

	// SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// // 查所有貼文
	// public List<Post> selectAllPost() throws SQLException {
	// Post post = new Post();
	// post.setPostHide(1);
	// return postDao.selectAllPost(post);
	// }

	// // 查單一貼文
	// public Post selectSinglePost(Post post) throws SQLException {
	// return postDao.selectSinglePost(post);
	// }
	// // 查會員貼文

	// // 新增貼文
	// public void insertPost(Post post) throws SQLException, ParseException {
	// // 設定現在時間
	// Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
	// post.setReleaseDate(new Timestamp(utilReleaseDate.getTime()));
	// post.setUserLike(0);
	// post.setUserUnlike(0);
	// post.setPostReport(0);
	// post.setPostHide(0);
	// postDao.insertPost(post);
	// }

	// // 修改貼文
	// public void updatePost(Post post) throws SQLException, ParseException {
	// // 設定現在時間
	// Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
	// post.setReleaseDate(new Timestamp(utilReleaseDate.getTime()));
	// post.setPostReport(0);
	// postDao.updatePost(post);
	// }

	// // 喜歡貼文

	// // 不喜歡貼文

	// // 檢舉貼文
	// public void reportPost(Post post) throws SQLException {
	// post.setPostReport(1);
	// postDao.reportPost(post);
	// }

	// // 查詢被檢舉貼文
	// public List<Post> selectReportPost(Post post) throws SQLException {
	// post.setPostReport(1);
	// return postDao.selectReportPost(post);
	// }

	// // 取消檢舉貼文
	// public void cancelReportPost(Post post) throws SQLException {
	// post.setPostReport(2);
	// postDao.cancelReportPost(post);
	// }

	// // 隱藏貼文
	// public void hidePost(Post post) throws SQLException {
	// post.setPostHide(1);
	// postDao.changeHidePost(post);
	// }

	// // 取消隱藏貼文
	// public void cancelHidePost(Post post) throws SQLException {
	// post.setPostHide(0);
	// postDao.changeHidePost(post);
	// }
}
