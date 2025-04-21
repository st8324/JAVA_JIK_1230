package kr.kh.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;

@Service
public class PostService {

	@Autowired
	PostDAO postDAO;
}
